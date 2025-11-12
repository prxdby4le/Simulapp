package com.info42022simulapp.simulapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;

import com.info42022simulapp.simulapp.model.Questao;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "simulapp.db";

    private static final int DATABASE_VERSION = 7; // bumped to 7: add unique partial indexes por idioma

    private static final String TABLE_QUESTOES = "questoes";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_AREA = "area";
    private static final String COLUMN_ANO = "ano";
    private static final String COLUMN_NUMERO = "numero";
    private static final String COLUMN_ENUNCIADO = "enunciado";
    private static final String COLUMN_IMAGEM = "imagem";
    private static final String COLUMN_TEXTO_APOIO = "texto_apoio";
    private static final String COLUMN_FONTE = "fonte";
    private static final String COLUMN_IDIOMA_ESTRANGEIRO = "idioma_estrangeiro";
    // Novos campos para múltiplos textos de apoio
    private static final String COLUMN_TEXTO_APOIO_1 = "texto_apoio_1";
    private static final String COLUMN_TEXTO_APOIO_2 = "texto_apoio_2";
    private static final String COLUMN_TEXTO_APOIO_3 = "texto_apoio_3";
    private static final String COLUMN_TEXTO_APOIO_4 = "texto_apoio_4";
    private static final String COLUMN_REFERENCIA_TEXTO_1 = "referencia_texto_1";
    private static final String COLUMN_REFERENCIA_TEXTO_2 = "referencia_texto_2";
    private static final String COLUMN_REFERENCIA_TEXTO_3 = "referencia_texto_3";
    private static final String COLUMN_REFERENCIA_TEXTO_4 = "referencia_texto_4";
    private static final String COLUMN_ALTERNATIVA_A = "alternativa_a";
    private static final String COLUMN_ALTERNATIVA_B = "alternativa_b";
    private static final String COLUMN_ALTERNATIVA_C = "alternativa_c";
    private static final String COLUMN_ALTERNATIVA_D = "alternativa_d";
    private static final String COLUMN_ALTERNATIVA_E = "alternativa_e";
    // Novos: imagens para alternativas
    private static final String COLUMN_ALTERNATIVA_A_IMAGEM = "alternativa_a_imagem";
    private static final String COLUMN_ALTERNATIVA_B_IMAGEM = "alternativa_b_imagem";
    private static final String COLUMN_ALTERNATIVA_C_IMAGEM = "alternativa_c_imagem";
    private static final String COLUMN_ALTERNATIVA_D_IMAGEM = "alternativa_d_imagem";
    private static final String COLUMN_ALTERNATIVA_E_IMAGEM = "alternativa_e_imagem";

    private static final String COLUMN_RESPOSTA_CORRETA = "resposta_correta";
    // Novo: persistir a ordem de elementos (texto, imagem, referencia, enunciado)
    private static final String COLUMN_ELEMENTOS_ORDENADOS = "elementos_ordenados";

    public static final String AREA_LINGUAGENS = "Linguagens";
    public static final String AREA_HUMANAS = "Humanas";
    public static final String AREA_NATUREZA = "Natureza";
    public static final String AREA_MATEMATICA = "Matemática";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_QUESTOES + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_AREA + " TEXT NOT NULL, "
                + COLUMN_ANO + " INTEGER NOT NULL, "
                + COLUMN_NUMERO + " INTEGER NOT NULL, "
                + COLUMN_ENUNCIADO + " TEXT NOT NULL, "
                + COLUMN_IMAGEM + " TEXT, "
                + COLUMN_TEXTO_APOIO + " TEXT, "
                + COLUMN_FONTE + " TEXT, "
                + COLUMN_IDIOMA_ESTRANGEIRO + " TEXT, "
                + COLUMN_TEXTO_APOIO_1 + " TEXT, "
                + COLUMN_TEXTO_APOIO_2 + " TEXT, "
                + COLUMN_TEXTO_APOIO_3 + " TEXT, "
                + COLUMN_TEXTO_APOIO_4 + " TEXT, "
                + COLUMN_REFERENCIA_TEXTO_1 + " TEXT, "
                + COLUMN_REFERENCIA_TEXTO_2 + " TEXT, "
                + COLUMN_REFERENCIA_TEXTO_3 + " TEXT, "
                + COLUMN_REFERENCIA_TEXTO_4 + " TEXT, "
                + COLUMN_ALTERNATIVA_A + " TEXT NOT NULL, "
                + COLUMN_ALTERNATIVA_B + " TEXT NOT NULL, "
                + COLUMN_ALTERNATIVA_C + " TEXT NOT NULL, "
                + COLUMN_ALTERNATIVA_D + " TEXT NOT NULL, "
                + COLUMN_ALTERNATIVA_E + " TEXT NOT NULL, "
                + COLUMN_ALTERNATIVA_A_IMAGEM + " TEXT, "
                + COLUMN_ALTERNATIVA_B_IMAGEM + " TEXT, "
                + COLUMN_ALTERNATIVA_C_IMAGEM + " TEXT, "
                + COLUMN_ALTERNATIVA_D_IMAGEM + " TEXT, "
                + COLUMN_ALTERNATIVA_E_IMAGEM + " TEXT, "
                + COLUMN_RESPOSTA_CORRETA + " TEXT NOT NULL, "
                + COLUMN_ELEMENTOS_ORDENADOS + " TEXT)";
        db.execSQL(CREATE_TABLE);

        // Índices únicos parciais para garantir integridade considerando idioma nulo vs. não nulo
        try {
            db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS idx_questoes_unique_sem_idioma ON " + TABLE_QUESTOES +
                    " (" + COLUMN_ANO + ", " + COLUMN_NUMERO + ", " + COLUMN_AREA + ") " +
                    " WHERE " + COLUMN_IDIOMA_ESTRANGEIRO + " IS NULL");
        } catch (Exception ignore) {}
        try {
            db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS idx_questoes_unique_com_idioma ON " + TABLE_QUESTOES +
                    " (" + COLUMN_ANO + ", " + COLUMN_NUMERO + ", " + COLUMN_AREA + ", " + COLUMN_IDIOMA_ESTRANGEIRO + ") " +
                    " WHERE " + COLUMN_IDIOMA_ESTRANGEIRO + " IS NOT NULL");
        } catch (Exception ignore) {}
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Migração incremental sem perder dados
        if (oldVersion < 5) {
            try {
                db.execSQL("ALTER TABLE " + TABLE_QUESTOES + " ADD COLUMN " + COLUMN_ELEMENTOS_ORDENADOS + " TEXT");
            } catch (Exception ignore) {
                // coluna já pode existir; ignorar
            }
        }
        if (oldVersion < 6) {
            // Adicionar colunas de imagens das alternativas
            try { db.execSQL("ALTER TABLE " + TABLE_QUESTOES + " ADD COLUMN " + COLUMN_ALTERNATIVA_A_IMAGEM + " TEXT"); } catch (Exception ignore) {}
            try { db.execSQL("ALTER TABLE " + TABLE_QUESTOES + " ADD COLUMN " + COLUMN_ALTERNATIVA_B_IMAGEM + " TEXT"); } catch (Exception ignore) {}
            try { db.execSQL("ALTER TABLE " + TABLE_QUESTOES + " ADD COLUMN " + COLUMN_ALTERNATIVA_C_IMAGEM + " TEXT"); } catch (Exception ignore) {}
            try { db.execSQL("ALTER TABLE " + TABLE_QUESTOES + " ADD COLUMN " + COLUMN_ALTERNATIVA_D_IMAGEM + " TEXT"); } catch (Exception ignore) {}
            try { db.execSQL("ALTER TABLE " + TABLE_QUESTOES + " ADD COLUMN " + COLUMN_ALTERNATIVA_E_IMAGEM + " TEXT"); } catch (Exception ignore) {}
        }
        if (oldVersion < 7) {
            // Criar índices únicos parciais para evitar sobrescritas entre variações de idioma
            try {
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS idx_questoes_unique_sem_idioma ON " + TABLE_QUESTOES +
                        " (" + COLUMN_ANO + ", " + COLUMN_NUMERO + ", " + COLUMN_AREA + ") " +
                        " WHERE " + COLUMN_IDIOMA_ESTRANGEIRO + " IS NULL");
            } catch (Exception ignore) {}
            try {
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS idx_questoes_unique_com_idioma ON " + TABLE_QUESTOES +
                        " (" + COLUMN_ANO + ", " + COLUMN_NUMERO + ", " + COLUMN_AREA + ", " + COLUMN_IDIOMA_ESTRANGEIRO + ") " +
                        " WHERE " + COLUMN_IDIOMA_ESTRANGEIRO + " IS NOT NULL");
            } catch (Exception ignore) {}
        }
    }

    public long inserirQuestao(Questao questao) {
        SQLiteDatabase db = this.getWritableDatabase();

        // Verificar se já existe uma questão com o mesmo ano, número, área e idioma (null-safe)
        String idioma = questao.getIdiomaEstrangeiro();
        Cursor cursor;
        if (idioma == null) {
            String query = "SELECT " + COLUMN_ID + " FROM " + TABLE_QUESTOES +
                           " WHERE " + COLUMN_ANO + " = ? AND " +
                           COLUMN_NUMERO + " = ? AND " +
                           COLUMN_AREA + " = ? AND " +
                           COLUMN_IDIOMA_ESTRANGEIRO + " IS NULL";
            cursor = db.rawQuery(query, new String[]{
                String.valueOf(questao.getAno()),
                String.valueOf(questao.getNumero()),
                questao.getArea()
            });
        } else {
            String query = "SELECT " + COLUMN_ID + " FROM " + TABLE_QUESTOES +
                           " WHERE " + COLUMN_ANO + " = ? AND " +
                           COLUMN_NUMERO + " = ? AND " +
                           COLUMN_AREA + " = ? AND " +
                           COLUMN_IDIOMA_ESTRANGEIRO + " = ?";
            cursor = db.rawQuery(query, new String[]{
                String.valueOf(questao.getAno()),
                String.valueOf(questao.getNumero()),
                questao.getArea(),
                idioma
            });
        }

        if (cursor.moveToFirst()) {
            long existingId = cursor.getLong(0);
            db.delete(TABLE_QUESTOES, COLUMN_ID + " = ?", new String[]{String.valueOf(existingId)});
        }
        cursor.close();

        // Mapear elementos ordenados (se existirem) para os campos texto_apoio_1..4 e referencias
        if (questao.temElementosOrdenados()) {
            ArrayList<String> textos = new ArrayList<>();
            ArrayList<String> refs = new ArrayList<>();
            for (Questao.ElementoQuestao el : questao.getElementosOrdenados()) {
                switch (el.getTipo()) {
                    case TEXTO_APOIO:
                        textos.add(el.getConteudo());
                        refs.add(null);
                        break;
                    case REFERENCIA:
                        if (!textos.isEmpty()) {
                            int idx = textos.size() - 1;
                            refs.set(idx, el.getConteudo());
                        }
                        break;
                    case ENUNCIADO:
                        if (TextUtils.isEmpty(questao.getEnunciado())) {
                            questao.setEnunciado(el.getConteudo());
                        }
                        break;
                    case IMAGEM:
                        // imagens já foram acumuladas no campo 'imagem' pelo modelo
                        break;
                }
            }
            if (TextUtils.isEmpty(questao.getTextoApoio1()) && textos.size() >= 1) questao.setTextoApoio1(textos.get(0));
            if (TextUtils.isEmpty(questao.getTextoApoio2()) && textos.size() >= 2) questao.setTextoApoio2(textos.get(1));
            if (TextUtils.isEmpty(questao.getTextoApoio3()) && textos.size() >= 3) questao.setTextoApoio3(textos.get(2));
            if (TextUtils.isEmpty(questao.getTextoApoio4()) && textos.size() >= 4) questao.setTextoApoio4(textos.get(3));

            if (TextUtils.isEmpty(questao.getReferenciaTexto1()) && refs.size() >= 1) questao.setReferenciaTexto1(refs.get(0));
            if (TextUtils.isEmpty(questao.getReferenciaTexto2()) && refs.size() >= 2) questao.setReferenciaTexto2(refs.get(1));
            if (TextUtils.isEmpty(questao.getReferenciaTexto3()) && refs.size() >= 3) questao.setReferenciaTexto3(refs.get(2));
            if (TextUtils.isEmpty(questao.getReferenciaTexto4()) && refs.size() >= 4) questao.setReferenciaTexto4(refs.get(3));
        }

        ContentValues values = new ContentValues();
        values.put(COLUMN_AREA, questao.getArea());
        values.put(COLUMN_ANO, questao.getAno());
        values.put(COLUMN_NUMERO, questao.getNumero());
        values.put(COLUMN_ENUNCIADO, questao.getEnunciado());
        values.put(COLUMN_IMAGEM, questao.getImagem());
        values.put(COLUMN_TEXTO_APOIO, questao.getTextoApoio());
        values.put(COLUMN_FONTE, questao.getFonte());
        values.put(COLUMN_IDIOMA_ESTRANGEIRO, questao.getIdiomaEstrangeiro());
        values.put(COLUMN_TEXTO_APOIO_1, questao.getTextoApoio1());
        values.put(COLUMN_TEXTO_APOIO_2, questao.getTextoApoio2());
        values.put(COLUMN_TEXTO_APOIO_3, questao.getTextoApoio3());
        values.put(COLUMN_TEXTO_APOIO_4, questao.getTextoApoio4());
        values.put(COLUMN_REFERENCIA_TEXTO_1, questao.getReferenciaTexto1());
        values.put(COLUMN_REFERENCIA_TEXTO_2, questao.getReferenciaTexto2());
        values.put(COLUMN_REFERENCIA_TEXTO_3, questao.getReferenciaTexto3());
        values.put(COLUMN_REFERENCIA_TEXTO_4, questao.getReferenciaTexto4());
        values.put(COLUMN_ALTERNATIVA_A, questao.getAlternativaA());
        values.put(COLUMN_ALTERNATIVA_B, questao.getAlternativaB());
        values.put(COLUMN_ALTERNATIVA_C, questao.getAlternativaC());
        values.put(COLUMN_ALTERNATIVA_D, questao.getAlternativaD());
        values.put(COLUMN_ALTERNATIVA_E, questao.getAlternativaE());
        // Novos: imagens alternativas
        values.put(COLUMN_ALTERNATIVA_A_IMAGEM, questao.getAlternativaAImagem());
        values.put(COLUMN_ALTERNATIVA_B_IMAGEM, questao.getAlternativaBImagem());
        values.put(COLUMN_ALTERNATIVA_C_IMAGEM, questao.getAlternativaCImagem());
        values.put(COLUMN_ALTERNATIVA_D_IMAGEM, questao.getAlternativaDImagem());
        values.put(COLUMN_ALTERNATIVA_E_IMAGEM, questao.getAlternativaEImagem());

        // Persistir resposta correta normalizada (A–E) quando possível
        String respNorm = questao.getRespostaCorretaLetra();
        values.put(COLUMN_RESPOSTA_CORRETA, TextUtils.isEmpty(respNorm) ? questao.getRespostaCorreta() : respNorm);

        // Serializar elementos ordenados em JSON
        if (questao.temElementosOrdenados()) {
            try {
                JSONArray arr = new JSONArray();
                for (Questao.ElementoQuestao el : questao.getElementosOrdenados()) {
                    JSONObject o = new JSONObject();
                    o.put("tipo", el.getTipo().name());
                    o.put("conteudo", el.getConteudo());
                    arr.put(o);
                }
                values.put(COLUMN_ELEMENTOS_ORDENADOS, arr.toString());
            } catch (JSONException e) {
                values.putNull(COLUMN_ELEMENTOS_ORDENADOS);
            }
        } else {
            values.putNull(COLUMN_ELEMENTOS_ORDENADOS);
        }

        long id = db.insert(TABLE_QUESTOES, null, values);
        db.close();
        return id;
    }

    private void preencherElementosOrdenadosSeExistir(Questao questao, Cursor cursor) {
        int idx = cursor.getColumnIndex(COLUMN_ELEMENTOS_ORDENADOS);
        if (idx == -1) return;
        String json = cursor.getString(idx);
        if (android.text.TextUtils.isEmpty(json)) return;
        try {
            org.json.JSONArray arr = new org.json.JSONArray(json);
            // Limpar qualquer estado anterior
            questao.getElementosOrdenados().clear();
            for (int i = 0; i < arr.length(); i++) {
                org.json.JSONObject o = arr.getJSONObject(i);
                String tipo = o.optString("tipo");
                String conteudo = o.optString("conteudo");
                if (android.text.TextUtils.isEmpty(conteudo)) continue;
                Questao.ElementoQuestao.TipoElemento t;
                if ("IMAGEM".equals(tipo)) t = Questao.ElementoQuestao.TipoElemento.IMAGEM;
                else if ("TEXTO_APOIO".equals(tipo)) t = Questao.ElementoQuestao.TipoElemento.TEXTO_APOIO;
                else if ("REFERENCIA".equals(tipo)) t = Questao.ElementoQuestao.TipoElemento.REFERENCIA;
                else if ("ENUNCIADO".equals(tipo)) t = Questao.ElementoQuestao.TipoElemento.ENUNCIADO;
                else continue;

                questao.getElementosOrdenados().add(new Questao.ElementoQuestao(t, conteudo));

                if (t == Questao.ElementoQuestao.TipoElemento.ENUNCIADO && android.text.TextUtils.isEmpty(questao.getEnunciado())) {
                    questao.setEnunciado(conteudo);
                }
            }
        } catch (org.json.JSONException ignore) {
        }
    }

    public List<Questao> getQuestoesPorArea(String area, int quantidade) {
        List<Questao> questoes = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + TABLE_QUESTOES +
                      " WHERE " + COLUMN_AREA + " = ? " +
                      " ORDER BY RANDOM() LIMIT ?";

        Cursor cursor = db.rawQuery(query, new String[]{area, String.valueOf(quantidade)});

        if (cursor.moveToFirst()) {
            do {
                Questao questao = new Questao();
                questao.setId(cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_ID)));
                questao.setArea(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_AREA)));
                questao.setAno(cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ANO)));
                questao.setNumero(cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_NUMERO)));
                questao.setEnunciado(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ENUNCIADO)));
                questao.setImagem(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_IMAGEM)));
                questao.setTextoApoio(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TEXTO_APOIO)));
                questao.setFonte(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_FONTE)));
                questao.setIdiomaEstrangeiro(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_IDIOMA_ESTRANGEIRO)));
                questao.setTextoApoio1(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TEXTO_APOIO_1)));
                questao.setTextoApoio2(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TEXTO_APOIO_2)));
                questao.setTextoApoio3(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TEXTO_APOIO_3)));
                questao.setTextoApoio4(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TEXTO_APOIO_4)));
                questao.setReferenciaTexto1(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_REFERENCIA_TEXTO_1)));
                questao.setReferenciaTexto2(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_REFERENCIA_TEXTO_2)));
                questao.setReferenciaTexto3(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_REFERENCIA_TEXTO_3)));
                questao.setReferenciaTexto4(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_REFERENCIA_TEXTO_4)));
                questao.setAlternativaA(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ALTERNATIVA_A)));
                questao.setAlternativaB(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ALTERNATIVA_B)));
                questao.setAlternativaC(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ALTERNATIVA_C)));
                questao.setAlternativaD(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ALTERNATIVA_D)));
                questao.setAlternativaE(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ALTERNATIVA_E)));
                // Imagens alternativas
                int idxA = cursor.getColumnIndex(COLUMN_ALTERNATIVA_A_IMAGEM);
                if (idxA != -1) questao.setAlternativaAImagem(cursor.getString(idxA));
                int idxB = cursor.getColumnIndex(COLUMN_ALTERNATIVA_B_IMAGEM);
                if (idxB != -1) questao.setAlternativaBImagem(cursor.getString(idxB));
                int idxC = cursor.getColumnIndex(COLUMN_ALTERNATIVA_C_IMAGEM);
                if (idxC != -1) questao.setAlternativaCImagem(cursor.getString(idxC));
                int idxD = cursor.getColumnIndex(COLUMN_ALTERNATIVA_D_IMAGEM);
                if (idxD != -1) questao.setAlternativaDImagem(cursor.getString(idxD));
                int idxE = cursor.getColumnIndex(COLUMN_ALTERNATIVA_E_IMAGEM);
                if (idxE != -1) questao.setAlternativaEImagem(cursor.getString(idxE));

                questao.setRespostaCorreta(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_RESPOSTA_CORRETA)));

                // Reconstruir ordem
                preencherElementosOrdenadosSeExistir(questao, cursor);

                questoes.add(questao);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return questoes;
    }

    public List<Questao> getQuestoesPorAreaComIdioma(String area, int quantidade, String idiomaEstrangeiro) {
        List<Questao> questoes = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query;
        String[] args;

        if (idiomaEstrangeiro == null) {
            query = "SELECT * FROM " + TABLE_QUESTOES +
                    " WHERE " + COLUMN_AREA + " = ? " +
                    " ORDER BY RANDOM() LIMIT ?";
            args = new String[]{area, String.valueOf(quantidade)};
        } else {
            query = "SELECT * FROM " + TABLE_QUESTOES +
                    " WHERE " + COLUMN_AREA + " = ? " +
                    " AND (" + COLUMN_IDIOMA_ESTRANGEIRO + " = ? OR " + COLUMN_IDIOMA_ESTRANGEIRO + " IS NULL) " +
                    " ORDER BY RANDOM() LIMIT ?";
            args = new String[]{area, idiomaEstrangeiro, String.valueOf(quantidade)};
        }

        Cursor cursor = db.rawQuery(query, args);

        if (cursor.moveToFirst()) {
            do {
                Questao questao = new Questao();
                questao.setId(cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_ID)));
                questao.setArea(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_AREA)));
                questao.setAno(cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ANO)));
                questao.setNumero(cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_NUMERO)));
                questao.setEnunciado(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ENUNCIADO)));
                questao.setImagem(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_IMAGEM)));
                questao.setTextoApoio(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TEXTO_APOIO)));
                questao.setFonte(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_FONTE)));
                questao.setIdiomaEstrangeiro(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_IDIOMA_ESTRANGEIRO)));
                questao.setTextoApoio1(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TEXTO_APOIO_1)));
                questao.setTextoApoio2(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TEXTO_APOIO_2)));
                questao.setTextoApoio3(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TEXTO_APOIO_3)));
                questao.setTextoApoio4(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TEXTO_APOIO_4)));
                questao.setReferenciaTexto1(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_REFERENCIA_TEXTO_1)));
                questao.setReferenciaTexto2(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_REFERENCIA_TEXTO_2)));
                questao.setReferenciaTexto3(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_REFERENCIA_TEXTO_3)));
                questao.setReferenciaTexto4(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_REFERENCIA_TEXTO_4)));
                questao.setAlternativaA(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ALTERNATIVA_A)));
                questao.setAlternativaB(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ALTERNATIVA_B)));
                questao.setAlternativaC(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ALTERNATIVA_C)));
                questao.setAlternativaD(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ALTERNATIVA_D)));
                questao.setAlternativaE(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ALTERNATIVA_E)));
                // Imagens alternativas
                int idxA = cursor.getColumnIndex(COLUMN_ALTERNATIVA_A_IMAGEM);
                if (idxA != -1) questao.setAlternativaAImagem(cursor.getString(idxA));
                int idxB = cursor.getColumnIndex(COLUMN_ALTERNATIVA_B_IMAGEM);
                if (idxB != -1) questao.setAlternativaBImagem(cursor.getString(idxB));
                int idxC = cursor.getColumnIndex(COLUMN_ALTERNATIVA_C_IMAGEM);
                if (idxC != -1) questao.setAlternativaCImagem(cursor.getString(idxC));
                int idxD = cursor.getColumnIndex(COLUMN_ALTERNATIVA_D_IMAGEM);
                if (idxD != -1) questao.setAlternativaDImagem(cursor.getString(idxD));
                int idxE = cursor.getColumnIndex(COLUMN_ALTERNATIVA_E_IMAGEM);
                if (idxE != -1) questao.setAlternativaEImagem(cursor.getString(idxE));

                questao.setRespostaCorreta(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_RESPOSTA_CORRETA)));

                // Reconstruir ordem
                preencherElementosOrdenadosSeExistir(questao, cursor);

                questoes.add(questao);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return questoes;
    }

    public List<Questao> getQuestoesSimulado(int qtdLinguagens, int qtdHumanas, int qtdNatureza, int qtdMatematica) {
        List<Questao> todasQuestoes = new ArrayList<>();

        if (qtdLinguagens > 0) {
            todasQuestoes.addAll(getQuestoesPorArea(AREA_LINGUAGENS, qtdLinguagens));
        }
        if (qtdHumanas > 0) {
            todasQuestoes.addAll(getQuestoesPorArea(AREA_HUMANAS, qtdHumanas));
        }
        if (qtdNatureza > 0) {
            todasQuestoes.addAll(getQuestoesPorArea(AREA_NATUREZA, qtdNatureza));
        }
        if (qtdMatematica > 0) {
            todasQuestoes.addAll(getQuestoesPorArea(AREA_MATEMATICA, qtdMatematica));
        }

        java.util.Collections.shuffle(todasQuestoes);

        return todasQuestoes;
    }

    public List<Questao> getQuestoesSimuladoComIdioma(int qtdLinguagens, int qtdHumanas, int qtdNatureza, int qtdMatematica, String idiomaEstrangeiro) {
        List<Questao> todasQuestoes = new ArrayList<>();

        if (qtdLinguagens > 0) {
            todasQuestoes.addAll(getQuestoesPorAreaComIdioma(AREA_LINGUAGENS, qtdLinguagens, idiomaEstrangeiro));
        }
        if (qtdHumanas > 0) {
            todasQuestoes.addAll(getQuestoesPorArea(AREA_HUMANAS, qtdHumanas));
        }
        if (qtdNatureza > 0) {
            todasQuestoes.addAll(getQuestoesPorArea(AREA_NATUREZA, qtdNatureza));
        }
        if (qtdMatematica > 0) {
            todasQuestoes.addAll(getQuestoesPorArea(AREA_MATEMATICA, qtdMatematica));
        }

        // Embaralhar as questões para misturar todas as áreas
        java.util.Collections.shuffle(todasQuestoes);

        return todasQuestoes;
    }

    public int getQuantidadeQuestoesPorArea(String area) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT COUNT(*) FROM " + TABLE_QUESTOES + " WHERE " + COLUMN_AREA + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{area});

        int count = 0;
        if (cursor.moveToFirst()) {
            count = cursor.getInt(0);
        }

        cursor.close();
        db.close();
        return count;
    }

    // Verificar se as questões já foram carregadas
    public boolean isQuestoesCarregadas() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT COUNT(*) FROM " + TABLE_QUESTOES;
        Cursor cursor = db.rawQuery(query, null);

        int count = 0;
        if (cursor.moveToFirst()) {
            count = cursor.getInt(0);
        }

        cursor.close();
        db.close();

        // Se tiver pelo menos 100 questões, considera que foi carregado
        return count >= 100;
    }

    // Obter total de questões no banco
    public int getTotalQuestoes() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT COUNT(*) FROM " + TABLE_QUESTOES;
        Cursor cursor = db.rawQuery(query, null);

        int count = 0;
        if (cursor.moveToFirst()) {
            count = cursor.getInt(0);
        }

        cursor.close();
        db.close();
        return count;
    }

    public List<Questao> getQuestoesPorIds(long[] ids) {
        List<Questao> questoes = new ArrayList<>();
        if (ids == null || ids.length == 0) return questoes;

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ").append(TABLE_QUESTOES).append(" WHERE ").append(COLUMN_ID).append(" IN (");
        String[] args = new String[ids.length];
        for (int i = 0; i < ids.length; i++) {
            sb.append("?");
            if (i < ids.length - 1) sb.append(",");
            args[i] = String.valueOf(ids[i]);
        }
        sb.append(")");

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sb.toString(), args);
        if (cursor.moveToFirst()) {
            do {
                Questao questao = new Questao();
                questao.setId(cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_ID)));
                questao.setArea(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_AREA)));
                questao.setAno(cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ANO)));
                questao.setNumero(cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_NUMERO)));
                questao.setEnunciado(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ENUNCIADO)));
                questao.setImagem(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_IMAGEM)));
                questao.setTextoApoio(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TEXTO_APOIO)));
                questao.setFonte(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_FONTE)));
                questao.setIdiomaEstrangeiro(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_IDIOMA_ESTRANGEIRO)));
                questao.setTextoApoio1(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TEXTO_APOIO_1)));
                questao.setTextoApoio2(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TEXTO_APOIO_2)));
                questao.setTextoApoio3(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TEXTO_APOIO_3)));
                questao.setTextoApoio4(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TEXTO_APOIO_4)));
                questao.setReferenciaTexto1(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_REFERENCIA_TEXTO_1)));
                questao.setReferenciaTexto2(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_REFERENCIA_TEXTO_2)));
                questao.setReferenciaTexto3(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_REFERENCIA_TEXTO_3)));
                questao.setReferenciaTexto4(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_REFERENCIA_TEXTO_4)));
                questao.setAlternativaA(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ALTERNATIVA_A)));
                questao.setAlternativaB(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ALTERNATIVA_B)));
                questao.setAlternativaC(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ALTERNATIVA_C)));
                questao.setAlternativaD(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ALTERNATIVA_D)));
                questao.setAlternativaE(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ALTERNATIVA_E)));
                // Imagens alternativas
                int idxA = cursor.getColumnIndex(COLUMN_ALTERNATIVA_A_IMAGEM);
                if (idxA != -1) questao.setAlternativaAImagem(cursor.getString(idxA));
                int idxB = cursor.getColumnIndex(COLUMN_ALTERNATIVA_B_IMAGEM);
                if (idxB != -1) questao.setAlternativaBImagem(cursor.getString(idxB));
                int idxC = cursor.getColumnIndex(COLUMN_ALTERNATIVA_C_IMAGEM);
                if (idxC != -1) questao.setAlternativaCImagem(cursor.getString(idxC));
                int idxD = cursor.getColumnIndex(COLUMN_ALTERNATIVA_D_IMAGEM);
                if (idxD != -1) questao.setAlternativaDImagem(cursor.getString(idxD));
                int idxE = cursor.getColumnIndex(COLUMN_ALTERNATIVA_E_IMAGEM);
                if (idxE != -1) questao.setAlternativaEImagem(cursor.getString(idxE));

                // Preencher resposta correta (estava faltando)
                int idxRC = cursor.getColumnIndex(COLUMN_RESPOSTA_CORRETA);
                if (idxRC != -1) {
                    questao.setRespostaCorreta(cursor.getString(idxRC));
                }

                // Reconstruir ordem
                preencherElementosOrdenadosSeExistir(questao, cursor);

                questoes.add(questao);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return questoes;
    }

    /**
     * Busca todas as questões de uma área específica, ordenadas por ano e número.
     * Usado para selecionar questões por índice (algoritmo de código de prova).
     *
     * @param area Área/Competência (Linguagens, Humanas, Natureza, Matemática)
     * @param idiomaEstrangeiro Idioma (inglês, espanhol) ou null para qualquer
     * @return Lista de questões ordenadas
     */
    public List<Questao> getTodasQuestoesPorArea(String area, String idiomaEstrangeiro) {
        List<Questao> questoes = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query;
        String[] args;

        if (idiomaEstrangeiro != null && !idiomaEstrangeiro.isEmpty()) {
            // Filtrar por idioma se especificado
            query = "SELECT * FROM " + TABLE_QUESTOES +
                   " WHERE " + COLUMN_AREA + " = ? " +
                   " AND (" + COLUMN_IDIOMA_ESTRANGEIRO + " = ? OR " + COLUMN_IDIOMA_ESTRANGEIRO + " IS NULL)" +
                   " ORDER BY " + COLUMN_ANO + ", " + COLUMN_NUMERO;
            args = new String[]{area, idiomaEstrangeiro};
        } else {
            // Buscar todas, sem filtro de idioma
            query = "SELECT * FROM " + TABLE_QUESTOES +
                   " WHERE " + COLUMN_AREA + " = ? " +
                   " ORDER BY " + COLUMN_ANO + ", " + COLUMN_NUMERO;
            args = new String[]{area};
        }

        Cursor cursor = db.rawQuery(query, args);

        if (cursor.moveToFirst()) {
            do {
                Questao questao = new Questao();
                questao.setId(cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_ID)));
                questao.setArea(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_AREA)));
                questao.setAno(cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ANO)));
                questao.setNumero(cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_NUMERO)));
                questao.setEnunciado(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ENUNCIADO)));
                questao.setImagem(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_IMAGEM)));
                questao.setTextoApoio(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TEXTO_APOIO)));
                questao.setFonte(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_FONTE)));
                questao.setIdiomaEstrangeiro(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_IDIOMA_ESTRANGEIRO)));
                questao.setTextoApoio1(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TEXTO_APOIO_1)));
                questao.setTextoApoio2(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TEXTO_APOIO_2)));
                questao.setTextoApoio3(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TEXTO_APOIO_3)));
                questao.setTextoApoio4(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TEXTO_APOIO_4)));
                questao.setReferenciaTexto1(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_REFERENCIA_TEXTO_1)));
                questao.setReferenciaTexto2(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_REFERENCIA_TEXTO_2)));
                questao.setReferenciaTexto3(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_REFERENCIA_TEXTO_3)));
                questao.setReferenciaTexto4(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_REFERENCIA_TEXTO_4)));
                questao.setAlternativaA(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ALTERNATIVA_A)));
                questao.setAlternativaB(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ALTERNATIVA_B)));
                questao.setAlternativaC(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ALTERNATIVA_C)));
                questao.setAlternativaD(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ALTERNATIVA_D)));
                questao.setAlternativaE(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ALTERNATIVA_E)));

                // Imagens alternativas
                int idxA = cursor.getColumnIndex(COLUMN_ALTERNATIVA_A_IMAGEM);
                if (idxA != -1) questao.setAlternativaAImagem(cursor.getString(idxA));
                int idxB = cursor.getColumnIndex(COLUMN_ALTERNATIVA_B_IMAGEM);
                if (idxB != -1) questao.setAlternativaBImagem(cursor.getString(idxB));
                int idxC = cursor.getColumnIndex(COLUMN_ALTERNATIVA_C_IMAGEM);
                if (idxC != -1) questao.setAlternativaCImagem(cursor.getString(idxC));
                int idxD = cursor.getColumnIndex(COLUMN_ALTERNATIVA_D_IMAGEM);
                if (idxD != -1) questao.setAlternativaDImagem(cursor.getString(idxD));
                int idxE = cursor.getColumnIndex(COLUMN_ALTERNATIVA_E_IMAGEM);
                if (idxE != -1) questao.setAlternativaEImagem(cursor.getString(idxE));

                // Preencher resposta correta (estava faltando)
                int idxRC = cursor.getColumnIndex(COLUMN_RESPOSTA_CORRETA);
                if (idxRC != -1) {
                    questao.setRespostaCorreta(cursor.getString(idxRC));
                }

                // Reconstruir ordem
                preencherElementosOrdenadosSeExistir(questao, cursor);

                questoes.add(questao);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return questoes;
    }

    /**
     * Normaliza todas as respostas corretas persistidas no banco para letras A–E.
     * Útil para corrigir dados legados ("Gabarito: D", "A)", "3", ou texto completo da alternativa).
     *
     * @return quantidade de linhas atualizadas
     */
    public int normalizarRespostasCorretas() {
        int atualizadas = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = null;
        try {
            cursor = db.query(
                    TABLE_QUESTOES,
                    new String[]{
                            COLUMN_ID,
                            COLUMN_ALTERNATIVA_A,
                            COLUMN_ALTERNATIVA_B,
                            COLUMN_ALTERNATIVA_C,
                            COLUMN_ALTERNATIVA_D,
                            COLUMN_ALTERNATIVA_E,
                            COLUMN_RESPOSTA_CORRETA
                    },
                    null, null, null, null, null
            );
            while (cursor.moveToNext()) {
                long id = cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_ID));
                String a = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ALTERNATIVA_A));
                String b = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ALTERNATIVA_B));
                String c = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ALTERNATIVA_C));
                String d = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ALTERNATIVA_D));
                String e = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ALTERNATIVA_E));
                String rc = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_RESPOSTA_CORRETA));

                Questao q = new Questao();
                q.setAlternativaA(a);
                q.setAlternativaB(b);
                q.setAlternativaC(c);
                q.setAlternativaD(d);
                q.setAlternativaE(e);
                q.setRespostaCorreta(rc);

                String norm = q.getRespostaCorretaLetra();
                if (!android.text.TextUtils.isEmpty(norm) && (rc == null || !rc.equalsIgnoreCase(norm))) {
                    ContentValues values = new ContentValues();
                    values.put(COLUMN_RESPOSTA_CORRETA, norm);
                    db.update(TABLE_QUESTOES, values, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
                    atualizadas++;
                }
            }
        } catch (Exception ignore) {
        } finally {
            if (cursor != null) cursor.close();
            db.close();
        }
        return atualizadas;
    }
}
