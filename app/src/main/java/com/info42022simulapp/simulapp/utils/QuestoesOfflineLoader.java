package com.info42022simulapp.simulapp.utils;

import android.content.Context;
import android.util.Log;

import com.info42022simulapp.simulapp.database.DatabaseHelper;
import com.info42022simulapp.simulapp.model.Questao;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class QuestoesOfflineLoader {
    private static final String TAG = "QuestoesOfflineLoader";
    private final Context context;
    private final DatabaseHelper databaseHelper;
    private ProgressCallback progressCallback;

    public interface ProgressCallback {
        void onProgress(int current, int total, String message);
        void onComplete(int totalImported);
        void onError(String error);
    }

    public QuestoesOfflineLoader(Context context, DatabaseHelper databaseHelper) {
        this.context = context;
        this.databaseHelper = databaseHelper;
    }

    public void setProgressCallback(ProgressCallback callback) {
        this.progressCallback = callback;
    }

    /**
     * Carrega todas as questões do(s) arquivo(s) JSON nos assets
     * Suporta:
     *  - assets/questoes/*.json (shards por ano/área)
     *  - assets/questoes_enem.json (monolítico)
     */
    public void carregarQuestoesDoAssets() {
        new Thread(() -> {
            try {
                String[] shardFiles = null;
                try { shardFiles = context.getAssets().list("questoes"); } catch (IOException ignore) {}

                int totalQuestoes = 0;
                int questoesImportadas = 0;
                int processadas = 0;

                boolean importouShards = false;
                if (shardFiles != null && shardFiles.length > 0) {
                    for (String f : shardFiles) {
                        if (!f.endsWith(".json")) continue;
                        String json = lerArquivoAssets("questoes/" + f);
                        if (json == null || json.isEmpty()) continue;
                        try { totalQuestoes += new JSONArray(json).length(); } catch (JSONException e) { Log.e(TAG, "Shard inválido: " + f, e); }
                    }
                    notifyProgress(0, Math.max(1, totalQuestoes), "Iniciando carregamento de questões (shards)...");

                    for (String f : shardFiles) {
                        if (!f.endsWith(".json")) continue;
                        String json = lerArquivoAssets("questoes/" + f);
                        if (json == null || json.isEmpty()) continue;
                        try {
                            JSONArray arr = new JSONArray(json);
                            for (int i = 0; i < arr.length(); i++) {
                                try {
                                    JSONObject questaoJson = arr.getJSONObject(i);
                                    Questao questao = converterJsonParaQuestao(questaoJson);
                                    databaseHelper.inserirQuestao(questao);
                                    questoesImportadas++;
                                } catch (JSONException e) {
                                    Log.e(TAG, "Erro no shard " + f + " índice " + i, e);
                                }
                                processadas++;
                                if (processadas % 25 == 0) {
                                    notifyProgress(processadas, Math.max(1, totalQuestoes),
                                            String.format(Locale.getDefault(), "Importando (%s)... %d/%d", f, processadas, totalQuestoes));
                                }
                            }
                            importouShards = true;
                        } catch (JSONException e) {
                            Log.e(TAG, "Erro ao parsear shard: " + f, e);
                        }
                    }
                }

                // Também importa o monolítico (fallback/complemento) se existir
                String jsonMonolitico = lerArquivoAssets("questoes_enem.json");
                if (jsonMonolitico != null && !jsonMonolitico.isEmpty()) {
                    try {
                        JSONArray questoesArray = new JSONArray(jsonMonolitico);
                        int totalMono = questoesArray.length();
                        if (!importouShards) {
                            totalQuestoes = totalMono;
                            notifyProgress(0, totalQuestoes, "Carregando questões...");
                        } else {
                            // Complemento: somar ao total para fins de barra
                            totalQuestoes += totalMono;
                            notifyProgress(processadas, Math.max(1, totalQuestoes), "Complementando com base monolítica...");
                        }
                        for (int i = 0; i < questoesArray.length(); i++) {
                            try {
                                JSONObject questaoJson = questoesArray.getJSONObject(i);
                                Questao questao = converterJsonParaQuestao(questaoJson);
                                databaseHelper.inserirQuestao(questao); // substitui duplicadas
                                questoesImportadas++;
                            } catch (JSONException e) {
                                Log.e(TAG, "Erro ao processar questão monolítica " + i, e);
                            }
                            processadas++;
                            if (processadas % 50 == 0) {
                                notifyProgress(processadas, Math.max(1, totalQuestoes),
                                        String.format(Locale.getDefault(), "Processando... %d/%d", processadas, totalQuestoes));
                            }
                        }
                    } catch (JSONException e) {
                        Log.e(TAG, "Monolítico inválido", e);
                    }
                } else if (!importouShards) {
                    notifyError("Nenhuma fonte de questões encontrada nos assets");
                    return;
                }

                notifyProgress(Math.max(processadas, totalQuestoes), Math.max(1, totalQuestoes), "Carregamento concluído!");
                notifyComplete(questoesImportadas);

            } catch (Exception e) {
                Log.e(TAG, "Erro ao carregar questões", e);
                notifyError("Erro ao carregar questões: " + e.getMessage());
            }
        }).start();
    }

    /**
     * Lê um arquivo dos assets
     */
    private String lerArquivoAssets(String nomeArquivo) {
        try {
            InputStream is = context.getAssets().open(nomeArquivo);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            reader.close();
            is.close();

            return sb.toString();
        } catch (IOException e) {
            Log.e(TAG, "Erro ao ler arquivo dos assets: " + nomeArquivo, e);
            return null;
        }
    }

    /**
     * Converte um JSONObject em um objeto Questao
     */
    private Questao converterJsonParaQuestao(JSONObject json) throws JSONException {
        Questao questao = new Questao();

        // Campos básicos
        questao.setAno(json.getInt("ano"));
        questao.setNumero(json.getInt("numero"));
        questao.setArea(json.getString("area"));

        // Idioma estrangeiro (pode ser null)
        if (json.has("idioma_estrangeiro") && !json.isNull("idioma_estrangeiro")) {
            questao.setIdiomaEstrangeiro(json.getString("idioma_estrangeiro"));
        }

        // Enunciado e texto de apoio
        if (json.has("enunciado") && !json.isNull("enunciado")) {
            String enunciado = json.getString("enunciado");
            if (!enunciado.isEmpty()) {
                questao.addEnunciado(enunciado);
            }
        }

        if (json.has("texto_apoio") && !json.isNull("texto_apoio")) {
            String textoApoio = json.getString("texto_apoio");
            if (!textoApoio.isEmpty()) {
                questao.addTextoApoio(textoApoio);
            }
        }

        // Imagens
        if (json.has("imagens")) {
            JSONArray imagensArray = json.getJSONArray("imagens");
            if (imagensArray.length() > 0) {
                String[] imagens = new String[imagensArray.length()];
                for (int i = 0; i < imagensArray.length(); i++) {
                    imagens[i] = imagensArray.getString(i);
                }
                questao.addImagem(imagens);
            }
        }

        // Alternativas
        // Evitar valores nulos: manter string vazia quando não houver texto
        String a = json.optString("alternativa_a", "");
        String b = json.optString("alternativa_b", "");
        String c = json.optString("alternativa_c", "");
        String d = json.optString("alternativa_d", "");
        String e = json.optString("alternativa_e", "");
        questao.setAlternativaA(a == null ? "" : a);
        questao.setAlternativaB(b == null ? "" : b);
        questao.setAlternativaC(c == null ? "" : c);
        questao.setAlternativaD(d == null ? "" : d);
        questao.setAlternativaE(e == null ? "" : e);

        // Alternativas: imagens (opcionais)
        if (json.has("alternativa_a_imagem") && !json.isNull("alternativa_a_imagem")) {
            questao.setAlternativaAImagem(json.getString("alternativa_a_imagem"));
        }
        if (json.has("alternativa_b_imagem") && !json.isNull("alternativa_b_imagem")) {
            questao.setAlternativaBImagem(json.getString("alternativa_b_imagem"));
        }
        if (json.has("alternativa_c_imagem") && !json.isNull("alternativa_c_imagem")) {
            questao.setAlternativaCImagem(json.getString("alternativa_c_imagem"));
        }
        if (json.has("alternativa_d_imagem") && !json.isNull("alternativa_d_imagem")) {
            questao.setAlternativaDImagem(json.getString("alternativa_d_imagem"));
        }
        if (json.has("alternativa_e_imagem") && !json.isNull("alternativa_e_imagem")) {
            questao.setAlternativaEImagem(json.getString("alternativa_e_imagem"));
        }

        // Resposta correta
        questao.setRespostaCorreta(json.getString("resposta_correta"));

        return questao;
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
