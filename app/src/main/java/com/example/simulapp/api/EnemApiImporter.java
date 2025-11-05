package com.example.simulapp.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.example.simulapp.database.DatabaseHelper;
import com.example.simulapp.model.Questao;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class EnemApiImporter {
    private static final String TAG = "EnemApiImporter";
    private static final String BASE_URL = "https://enem.dev";
    private static final int[] ANOS_DISPONIVEIS = {2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020, 2021, 2022, 2023};

    private final Context context;
    private final DatabaseHelper databaseHelper;
    private final OkHttpClient httpClient;
    private final Gson gson;
    private ProgressCallback progressCallback;

    public interface ProgressCallback {
        void onProgress(int current, int total, String message);
        void onComplete(int totalImported);
        void onError(String error);
    }

    public EnemApiImporter(Context context, DatabaseHelper databaseHelper) {
        this.context = context;
        this.databaseHelper = databaseHelper;
        this.gson = new Gson();
        this.httpClient = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
    }

    public void setProgressCallback(ProgressCallback callback) {
        this.progressCallback = callback;
    }

    public void importarTodasQuestoes() {
        new Thread(() -> {
            try {
                int totalImportadas = 0;
                int totalQuestoes = 0;

                for (int ano : ANOS_DISPONIVEIS) {
                    totalQuestoes += contarQuestoesAno(ano);
                }

                int questoesProcessadas = 0;

                for (int ano : ANOS_DISPONIVEIS) {
                    notifyProgress(questoesProcessadas, totalQuestoes, "Importando questões de " + ano);

                    List<String> questoesAno = getQuestoesAno(ano);

                    for (String questaoId : questoesAno) {
                        try {
                            EnemApiModels.QuestionDetails detalhes = buscarDetalhesQuestao(ano, questaoId);
                            if (detalhes != null) {
                                Questao questao = converterParaQuestao(detalhes);
                                // Baixar e salvar imagens (contexto e alternativas)
                                processarImagensQuestao(questao, detalhes, ano, questaoId);
                                databaseHelper.inserirQuestao(questao);
                                totalImportadas++;
                            }
                        } catch (Exception e) {
                            Log.e(TAG, "Erro ao importar questão " + questaoId + " de " + ano, e);
                        }

                        questoesProcessadas++;
                        notifyProgress(questoesProcessadas, totalQuestoes,
                            String.format(Locale.getDefault(), "Processando questão %d de %d", questoesProcessadas, totalQuestoes));
                    }
                }

                notifyComplete(totalImportadas);
            } catch (Exception e) {
                Log.e(TAG, "Erro ao importar questões", e);
                notifyError("Erro ao importar questões: " + e.getMessage());
            }
        }).start();
    }

    private int contarQuestoesAno(int ano) {
        return 185;
    }

    private List<String> getQuestoesAno(int ano) {
        List<String> questoes = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            questoes.add(i + "-ingles");
            questoes.add(i + "-espanhol");
        }
        for (int i = 6; i <= 180; i++) {
            questoes.add(String.valueOf(i));
        }
        return questoes;
    }

    private EnemApiModels.QuestionDetails buscarDetalhesQuestao(int ano, String questaoId) {
        String url = String.format(Locale.ROOT, "%s/%d/questions/%s/details.json", BASE_URL, ano, questaoId);

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                String json = response.body().string();
                return gson.fromJson(json, EnemApiModels.QuestionDetails.class);
            }
        } catch (Exception e) {
            Log.w(TAG, "Questão não encontrada: " + questaoId + " de " + ano);
        }

        return null;
    }

    private Questao converterParaQuestao(EnemApiModels.QuestionDetails detalhes) {
        Questao questao = new Questao();

        questao.setAno(detalhes.year);
        questao.setNumero(detalhes.index);

        String area = mapearDisciplinaParaArea(detalhes.discipline);
        questao.setArea(area);

        if (detalhes.language != null && !detalhes.language.isEmpty()) {
            questao.setIdiomaEstrangeiro(detalhes.language);
        }

        processarContexto(questao, detalhes.context, detalhes.files);

        if (detalhes.alternativesIntroduction != null && !detalhes.alternativesIntroduction.isEmpty()) {
            questao.addEnunciado(detalhes.alternativesIntroduction);
        } else if (detalhes.title != null && !detalhes.title.isEmpty()) {
            questao.addEnunciado(detalhes.title);
        } else {
            questao.addEnunciado("Leia o texto e responda à questão.");
        }

        String letraCorreta = detalhes.correctAlternative;

        if (detalhes.alternatives != null && detalhes.alternatives.size() == 5) {
            for (EnemApiModels.Alternative alt : detalhes.alternatives) {
                String textoAlt = alt.text;
                if ((textoAlt == null || textoAlt.trim().isEmpty()) && alt.file != null && !alt.file.isEmpty()) {
                    textoAlt = "[Imagem]";
                }

                // CORREÇÃO: Detectar resposta correta pelo campo isCorrect quando correctAlternative for null
                if (alt.isCorrect && (letraCorreta == null || letraCorreta.isEmpty())) {
                    letraCorreta = alt.letter;
                    Log.d(TAG, "Resposta correta detectada via isCorrect: " + letraCorreta);
                }

                switch (alt.letter) {
                    case "A":
                        questao.setAlternativaA(textoAlt);
                        break;
                    case "B":
                        questao.setAlternativaB(textoAlt);
                        break;
                    case "C":
                        questao.setAlternativaC(textoAlt);
                        break;
                    case "D":
                        questao.setAlternativaD(textoAlt);
                        break;
                    case "E":
                        questao.setAlternativaE(textoAlt);
                        break;
                }
            }
        }

        // Garantir que sempre temos uma resposta correta
        if (letraCorreta == null || letraCorreta.isEmpty()) {
            Log.w(TAG, "AVISO: Questão " + detalhes.index + " do ano " + detalhes.year +
                    " não tem resposta correta definida!");
            letraCorreta = "A"; // Fallback para evitar null
        }

        questao.setRespostaCorreta(letraCorreta);

        return questao;
    }

    private String mapearDisciplinaParaArea(String discipline) {
        if (discipline == null) return DatabaseHelper.AREA_LINGUAGENS;
        switch (discipline.toLowerCase()) {
            case "ciencias-humanas":
                return DatabaseHelper.AREA_HUMANAS;
            case "ciencias-natureza":
                return DatabaseHelper.AREA_NATUREZA;
            case "linguagens":
                return DatabaseHelper.AREA_LINGUAGENS;
            case "matematica":
                return DatabaseHelper.AREA_MATEMATICA;
            default:
                return DatabaseHelper.AREA_LINGUAGENS;
        }
    }

    private void processarContexto(Questao questao, String context, List<String> files) {
        if (context == null || context.isEmpty()) return;

        // Remove imagens em markdown do contexto
        Pattern pattern = Pattern.compile("!\\[\\]\\((https://enem\\.dev/[^)]+)\\)");
        Matcher matcher = pattern.matcher(context);
        String textoSemImagens = context;
        while (matcher.find()) {
            String grupo = matcher.group(0);
            if (grupo != null) {
                textoSemImagens = textoSemImagens.replace(grupo, "");
            }
        }

        // Normaliza e separa possíveis trechos de referência
        textoSemImagens = textoSemImagens.replace("-----", "\n");
        String[] linhas = textoSemImagens.split("\n");
        StringBuilder bloco = new StringBuilder();
        for (String linha : linhas) {
            String l = linha.trim();
            if (l.isEmpty()) continue;
            // Heurística de referência
            if (l.startsWith("Fonte:") || l.contains("Disponível em:") || l.contains("Disponivel em:") || l.contains("Acesso em:")) {
                // adiciona bloco acumulado como texto de apoio
                if (bloco.length() > 0) {
                    questao.addTextoApoio(bloco.toString().trim());
                    bloco.setLength(0);
                }
                questao.addReferencia(l);
            } else {
                if (bloco.length() > 0) bloco.append('\n');
                bloco.append(l);
            }
        }
        if (bloco.length() > 0) {
            questao.addTextoApoio(bloco.toString().trim());
        }
    }

    private void processarImagensQuestao(Questao questao, EnemApiModels.QuestionDetails detalhes, int ano, String questaoId) {
        List<String> imagensContexto = new ArrayList<>();
        List<String> imagensAlternativas = new ArrayList<>();

        // Processar imagens do contexto (files)
        if (detalhes.files != null && !detalhes.files.isEmpty()) {
            for (int i = 0; i < detalhes.files.size(); i++) {
                String urlImagem = detalhes.files.get(i);
                try {
                    String extensao = extrairExtensao(urlImagem);
                    String nomeImagem = String.format(Locale.ROOT, "questao%d_img%d_%s_%d%s",
                        detalhes.index, i + 1, detalhes.discipline, ano, extensao);

                    if (baixarESalvarImagem(urlImagem, nomeImagem)) {
                        imagensContexto.add(removerExtensao(nomeImagem));
                    }
                } catch (Exception e) {
                    Log.e(TAG, "Erro ao processar imagem: " + urlImagem, e);
                }
            }
        }

        // Processar imagens das alternativas
        if (detalhes.alternatives != null) {
            for (EnemApiModels.Alternative alt : detalhes.alternatives) {
                if (alt.file != null && !alt.file.isEmpty()) {
                    try {
                        String extensao = extrairExtensao(alt.file);
                        String nomeImagem = String.format(Locale.ROOT, "questao%d_alt%s_%s_%d%s",
                                detalhes.index, alt.letter, detalhes.discipline, ano, extensao);
                        if (baixarESalvarImagem(alt.file, nomeImagem)) {
                            String base = removerExtensao(nomeImagem);
                            imagensAlternativas.add(base);
                            // vincular à alternativa correspondente
                            if ("A".equalsIgnoreCase(alt.letter)) questao.setAlternativaAImagem(base);
                            else if ("B".equalsIgnoreCase(alt.letter)) questao.setAlternativaBImagem(base);
                            else if ("C".equalsIgnoreCase(alt.letter)) questao.setAlternativaCImagem(base);
                            else if ("D".equalsIgnoreCase(alt.letter)) questao.setAlternativaDImagem(base);
                            else if ("E".equalsIgnoreCase(alt.letter)) questao.setAlternativaEImagem(base);
                        }
                    } catch (Exception e) {
                        Log.e(TAG, "Erro ao processar imagem de alternativa: " + alt.file, e);
                    }
                }
            }
        }

        // Adicionar apenas as imagens de contexto ao array de imagens da questão
        // As imagens das alternativas já foram vinculadas diretamente aos campos específicos
        if (!imagensContexto.isEmpty()) {
            questao.addImagem(imagensContexto.toArray(new String[0]));
        }
    }

    private String removerExtensao(String nomeArquivo) {
        int idx = nomeArquivo.lastIndexOf('.');
        return (idx > 0) ? nomeArquivo.substring(0, idx) : nomeArquivo;
    }

    private String extrairExtensao(String urlImagem) {
        int idx = urlImagem.lastIndexOf('.');
        if (idx >= 0) {
            return urlImagem.substring(idx);
        }
        return ".png";
    }

    private boolean baixarESalvarImagem(String url, String nomeArquivo) {
        try {
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            try (Response response = httpClient.newCall(request).execute()) {
                if (response.isSuccessful() && response.body() != null) {
                    InputStream inputStream = response.body().byteStream();
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                    if (bitmap != null) {
                        File outputDir = new File(context.getFilesDir(), "images");
                        if (!outputDir.exists()) {
                            //noinspection ResultOfMethodCallIgnored
                            outputDir.mkdirs();
                        }

                        File outputFile = new File(outputDir, nomeArquivo);
                        try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
                        }
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "Erro ao baixar imagem: " + url, e);
        }

        return false;
    }

    private void notifyProgress(int current, int total, String message) {
        if (progressCallback != null) {
            progressCallback.onProgress(current, total, message);
        }
    }

    private void notifyComplete(int totalImported) {
        if (progressCallback != null) {
            progressCallback.onComplete(totalImported);
        }
    }

    private void notifyError(String error) {
        if (progressCallback != null) {
            progressCallback.onError(error);
        }
    }
}
