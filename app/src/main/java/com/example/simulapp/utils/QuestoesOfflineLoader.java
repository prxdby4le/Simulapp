package com.example.simulapp.utils;

import android.content.Context;
import android.util.Log;

import com.example.simulapp.database.DatabaseHelper;
import com.example.simulapp.model.Questao;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class QuestoesOfflineLoader {
    private static final String TAG = "QuestoesOfflineLoader";
    private Context context;
    private DatabaseHelper databaseHelper;
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
     * Carrega todas as questões do arquivo JSON nos assets
     */
    public void carregarQuestoesDoAssets() {
        new Thread(() -> {
            try {
                notifyProgress(0, 100, "Iniciando carregamento de questões...");

                // Ler arquivo JSON dos assets
                String jsonString = lerArquivoAssets("questoes_enem.json");
                if (jsonString == null || jsonString.isEmpty()) {
                    notifyError("Arquivo de questões não encontrado");
                    return;
                }

                // Parsear JSON
                JSONArray questoesArray = new JSONArray(jsonString);
                int totalQuestoes = questoesArray.length();
                int questoesImportadas = 0;

                notifyProgress(0, totalQuestoes, "Carregando questões...");

                // Processar cada questão
                for (int i = 0; i < totalQuestoes; i++) {
                    try {
                        JSONObject questaoJson = questoesArray.getJSONObject(i);
                        Questao questao = converterJsonParaQuestao(questaoJson);

                        if (questao != null) {
                            databaseHelper.inserirQuestao(questao);
                            questoesImportadas++;
                        }
                    } catch (JSONException e) {
                        Log.e(TAG, "Erro ao processar questão " + i, e);
                    }

                    // Atualizar progresso a cada 10 questões
                    if (i % 10 == 0) {
                        notifyProgress(i, totalQuestoes,
                            String.format("Carregando questões... %d/%d", i, totalQuestoes));
                    }
                }

                notifyProgress(totalQuestoes, totalQuestoes, "Carregamento concluído!");
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
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
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
        questao.setAlternativaA(json.optString("alternativa_a", null));
        questao.setAlternativaB(json.optString("alternativa_b", null));
        questao.setAlternativaC(json.optString("alternativa_c", null));
        questao.setAlternativaD(json.optString("alternativa_d", null));
        questao.setAlternativaE(json.optString("alternativa_e", null));

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
