package com.example.simulapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.MaterialToolbar;

import com.example.simulapp.database.DatabaseHelper;
import com.example.simulapp.model.Questao;

import java.io.Serializable;
import java.util.List;

public class GerarProvaActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    private EditText etQuantidadeLinguagens;
    private EditText etQuantidadeHumanas;
    private EditText etQuantidadeNatureza;
    private EditText etQuantidadeMatematica;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerar_prova);

        databaseHelper = new DatabaseHelper(this);

        // Inicializar questões apenas uma vez
        inicializarQuestoes();

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> finish());

        etQuantidadeLinguagens = findViewById(R.id.etQuantidadeLinguagens);
        etQuantidadeHumanas = findViewById(R.id.etQuantidadeHumanas);
        etQuantidadeNatureza = findViewById(R.id.etQuantidadeNatureza);
        etQuantidadeMatematica = findViewById(R.id.etQuantidadeMatematica);

        setupCounterByName("etQuantidadeLinguagens", "btnIncrementarLinguagens", "btnDecrementarLinguagens");
        setupCounterByName("etQuantidadeHumanas", "btnIncrementarHumanas", "btnDecrementarHumanas");
        setupCounterByName("etQuantidadeNatureza", "btnIncrementarNatureza", "btnDecrementarNatureza");
        setupCounterByName("etQuantidadeMatematica", "btnIncrementarMatematica", "btnDecrementarMatematica");

        Button btnGerarProva = findViewById(R.id.btnGerarProva);
        btnGerarProva.setOnClickListener(v -> gerarProva());
    }

    private void inicializarQuestoes() {
        SharedPreferences prefs = getSharedPreferences("SimulappPrefs", MODE_PRIVATE);
        boolean questoesInicializadas = prefs.getBoolean("questoes_inicializadas", false);

        if (!questoesInicializadas) {
            new Thread(() -> {
                AdicionarQuestoesUtil.adicionarQuestoes(databaseHelper);
                prefs.edit().putBoolean("questoes_inicializadas", true).apply();
            }).start();
        }
    }

    private void gerarProva() {
        int qtdLinguagens = getCurrentValue(etQuantidadeLinguagens);
        int qtdHumanas = getCurrentValue(etQuantidadeHumanas);
        int qtdNatureza = getCurrentValue(etQuantidadeNatureza);
        int qtdMatematica = getCurrentValue(etQuantidadeMatematica);

        int totalQuestoes = qtdLinguagens + qtdHumanas + qtdNatureza + qtdMatematica;

        if (totalQuestoes == 0) {
            Toast.makeText(this, "Selecione pelo menos uma questão", Toast.LENGTH_SHORT).show();
            return;
        }

        List<Questao> questoes = databaseHelper.getQuestoesSimulado(
                qtdLinguagens, qtdHumanas, qtdNatureza, qtdMatematica
        );

        if (questoes.isEmpty()) {
            Toast.makeText(this, "Não há questões disponíveis no banco de dados", Toast.LENGTH_LONG).show();
            return;
        }

        if (questoes.size() < totalQuestoes) {
            Toast.makeText(this, "Apenas " + questoes.size() + " questões disponíveis no banco", Toast.LENGTH_LONG).show();
        }

        Intent intent = new Intent(this, SimuladoActivity.class);
        intent.putExtra("questoes", (Serializable) questoes);
        startActivity(intent);
    }

    private void setupCounterByName(String etName, String incName, String decName) {
        int etId = getResources().getIdentifier(etName, "id", getPackageName());
        int incId = getResources().getIdentifier(incName, "id", getPackageName());
        int decId = getResources().getIdentifier(decName, "id", getPackageName());
        if (etId == 0 || incId == 0 || decId == 0) return;
        setupCounter(etId, incId, decId);
    }

    private void setupCounter(int etId, int incBtnId, int decBtnId) {
        EditText etQuantidade = findViewById(etId);
        Button btnInc = findViewById(incBtnId);
        Button btnDec = findViewById(decBtnId);

        if (etQuantidade == null || btnInc == null || btnDec == null) return;

        if (TextUtils.isEmpty(etQuantidade.getText())) {
            etQuantidade.setText("0");
        }

        btnInc.setOnClickListener(v -> {
            int current = getCurrentValue(etQuantidade);
            etQuantidade.setText(String.valueOf(current + 1));
        });

        btnDec.setOnClickListener(v -> {
            int current = getCurrentValue(etQuantidade);
            if (current > 0) {
                etQuantidade.setText(String.valueOf(current - 1));
            } else {
                etQuantidade.setText("0");
            }
        });

        etQuantidade.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                int current = getCurrentValue(etQuantidade);
                if (current < 0) current = 0;
                etQuantidade.setText(String.valueOf(current));
            }
        });
    }

    private int getCurrentValue(EditText et) {
        try {
            String text = et.getText() != null ? et.getText().toString().trim() : "";
            if (text.isEmpty()) return 0;
            return Integer.parseInt(text);
        } catch (NumberFormatException ex) {
            return 0;
        }
    }
}
