package com.example.simulapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.MaterialToolbar;

public class GerarProvaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerar_prova);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> finish());

        setupCounterByName("etQuantidadeLinguagens", "btnIncrementarLinguagens", "btnDecrementarLinguagens");
        setupCounterByName("etQuantidadeHumanas", "btnIncrementarHumanas", "btnDecrementarHumanas");
        setupCounterByName("etQuantidadeNatureza", "btnIncrementarNatureza", "btnDecrementarNatureza");
        setupCounterByName("etQuantidadeMatematica", "btnIncrementarMatematica", "btnDecrementarMatematica");
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
