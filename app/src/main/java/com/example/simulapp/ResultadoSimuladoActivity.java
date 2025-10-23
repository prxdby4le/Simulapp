package com.example.simulapp;

import android.content.Intent;
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
        long[] ids = getIntent().getLongArrayExtra("questao_ids");
        String[] respostasUsuario = getIntent().getStringArrayExtra("respostas_usuario");

        TextView tvResultado = findViewById(R.id.tvResultado);
        TextView tvAcertos = findViewById(R.id.tvAcertos);
        TextView tvPercentual = findViewById(R.id.tvPercentual);
        Button btnAnalisarTentativa = findViewById(R.id.btnAnalisarTentativa);
        Button btnVoltar = findViewById(R.id.btnVoltar);

        double percentual = total > 0 ? (acertos * 100.0 / total) : 0;

        tvResultado.setText("Simulado Finalizado!");
        tvAcertos.setText("Você acertou " + acertos + " de " + total + " questões");
        tvPercentual.setText(String.format(java.util.Locale.getDefault(), "%.1f%% de aproveitamento", percentual));

        btnAnalisarTentativa.setOnClickListener(v -> {
            Intent intent = new Intent(this, AnalisarTentativaActivity.class);
            intent.putExtra("questao_ids", ids);
            intent.putExtra("respostas_usuario", respostasUsuario);
            startActivity(intent);
        });

        btnVoltar.setOnClickListener(v -> finish());
    }
}
