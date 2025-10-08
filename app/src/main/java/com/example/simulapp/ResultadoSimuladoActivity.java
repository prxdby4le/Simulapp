package com.example.simulapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;

public class ResultadoSimuladoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_simulado);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> finish());

        int acertos = getIntent().getIntExtra("acertos", 0);
        int total = getIntent().getIntExtra("total", 0);

        TextView tvResultado = findViewById(R.id.tvResultado);
        TextView tvAcertos = findViewById(R.id.tvAcertos);
        TextView tvPercentual = findViewById(R.id.tvPercentual);
        Button btnVoltar = findViewById(R.id.btnVoltar);

        double percentual = total > 0 ? (acertos * 100.0 / total) : 0;

        tvResultado.setText("Simulado Finalizado!");
        tvAcertos.setText("Você acertou " + acertos + " de " + total + " questões");
        tvPercentual.setText(String.format("%.1f%% de aproveitamento", percentual));

        btnVoltar.setOnClickListener(v -> finish());
    }
}

