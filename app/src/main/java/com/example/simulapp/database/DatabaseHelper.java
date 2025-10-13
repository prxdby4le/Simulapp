package com.example.simulapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.simulapp.model.Questao;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "simulapp.db";
    private static final int DATABASE_VERSION = 3; // Incrementada para incluir novos campos

    private static final String TABLE_QUESTOES = "questoes";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_AREA = "area";
    private static final String COLUMN_ANO = "ano";
    private static final String COLUMN_NUMERO = "numero";
    private static final String COLUMN_ENUNCIADO = "enunciado";
    private static final String COLUMN_IMAGEM = "imagem";
    private static final String COLUMN_TEXTO_APOIO = "texto_apoio";
    private static final String COLUMN_FONTE = "fonte";
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
    private static final String COLUMN_RESPOSTA_CORRETA = "resposta_correta";

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
                + COLUMN_RESPOSTA_CORRETA + " TEXT NOT NULL)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTOES);
        onCreate(db);
    }

    public long inserirQuestao(Questao questao) {
        SQLiteDatabase db = this.getWritableDatabase();

        // Verificar se já existe uma questão com o mesmo ano, número e área
        String query = "SELECT " + COLUMN_ID + " FROM " + TABLE_QUESTOES +
                      " WHERE " + COLUMN_ANO + " = ? AND " +
                      COLUMN_NUMERO + " = ? AND " +
                      COLUMN_AREA + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{
            String.valueOf(questao.getAno()),
            String.valueOf(questao.getNumero()),
            questao.getArea()
        });

        // Se já existe, deletar a antiga antes de inserir a nova
        if (cursor.moveToFirst()) {
            long existingId = cursor.getLong(0);
            db.delete(TABLE_QUESTOES, COLUMN_ID + " = ?", new String[]{String.valueOf(existingId)});
        }
        cursor.close();

        ContentValues values = new ContentValues();
        values.put(COLUMN_AREA, questao.getArea());
        values.put(COLUMN_ANO, questao.getAno());
        values.put(COLUMN_NUMERO, questao.getNumero());
        values.put(COLUMN_ENUNCIADO, questao.getEnunciado());
        values.put(COLUMN_IMAGEM, questao.getImagem());
        values.put(COLUMN_TEXTO_APOIO, questao.getTextoApoio());
        values.put(COLUMN_FONTE, questao.getFonte());
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
        values.put(COLUMN_RESPOSTA_CORRETA, questao.getRespostaCorreta());

        long id = db.insert(TABLE_QUESTOES, null, values);
        db.close();
        return id;
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
                questao.setRespostaCorreta(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_RESPOSTA_CORRETA)));

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
}
