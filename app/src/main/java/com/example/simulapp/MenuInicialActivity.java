package com.example.simulapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.simulapp.database.DatabaseHelper;
import com.google.android.material.button.MaterialButton;
import com.example.simulapp.utils.QuestoesOfflineLoader;

public class MenuInicialActivity extends AppCompatActivity {

    private MaterialButton btnGerarProva, btnRedacao;
    private MaterialButton btnResetarBanco;
    private TextView tvLoginLink;
    private ProgressBar progressBarCarregamento;
    private TextView tvCarregamento;
    private TextView tvTotalQuestoes;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_inicial);

        databaseHelper = new DatabaseHelper(this);

        btnGerarProva = findViewById(R.id.btnGerarProva);
        btnRedacao = findViewById(R.id.btnRedacao);
        btnResetarBanco = findViewById(R.id.btnResetarBanco);
        tvLoginLink = findViewById(R.id.tvLoginLink);
        progressBarCarregamento = findViewById(R.id.progressBarCarregamento);
        tvCarregamento = findViewById(R.id.tvCarregamento);
        tvTotalQuestoes = findViewById(R.id.tvTotalQuestoes);

        configurarCliques();
        atualizarContador();
        verificarECarregarQuestoes();
    }

    private void configurarCliques() {

        btnGerarProva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuInicialActivity.this, GerarProvaActivity.class);
                startActivity(intent);
            }
        });

        btnRedacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuInicialActivity.this, RedacaoActivity.class);
                startActivity(intent);
            }
        });

        btnResetarBanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetarBancoEReimportar();
            }
        });

        tvLoginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuInicialActivity.this, EntrarComCodigoActivity.class);
                startActivity(intent);
            }
        });
    }

    private void atualizarContador() {
        if (tvTotalQuestoes != null) {
            int total = 0;
            try { total = databaseHelper.getTotalQuestoes(); } catch (Exception ignore) {}
            tvTotalQuestoes.setText("Total de questões: " + total);
        }
    }

    private void verificarECarregarQuestoes() {
        int total = 0;
        try {
            total = databaseHelper.getTotalQuestoes();
        } catch (Exception ignore) {}

        if (total < 2000) {
            iniciarImportacaoAutomatica();
        } else {
            if (progressBarCarregamento != null) {
                progressBarCarregamento.setVisibility(View.GONE);
            }
            if (tvCarregamento != null) {
                tvCarregamento.setVisibility(View.GONE);
            }
        }
    }

    private void iniciarImportacaoAutomatica() {
        if (progressBarCarregamento != null) {
            progressBarCarregamento.setVisibility(View.VISIBLE);
        }
        if (tvCarregamento != null) {
            tvCarregamento.setVisibility(View.VISIBLE);
            tvCarregamento.setText("Preparando questões do ENEM (offline)...");
        }

        btnGerarProva.setEnabled(false);
        btnRedacao.setEnabled(false);
        if (btnResetarBanco != null) btnResetarBanco.setEnabled(false);

        carregarQuestoesOfflineAssets();
    }

    private void carregarQuestoesOfflineAssets() {
        QuestoesOfflineLoader loader = new QuestoesOfflineLoader(this, databaseHelper);
        loader.setProgressCallback(new QuestoesOfflineLoader.ProgressCallback() {
            @Override
            public void onProgress(int current, int total, String message) {
                runOnUiThread(() -> {
                    if (progressBarCarregamento != null) {
                        progressBarCarregamento.setMax(Math.max(1, total));
                        progressBarCarregamento.setProgress(Math.min(current, total));
                    }
                    if (tvCarregamento != null) {
                        tvCarregamento.setText(message == null ? "Carregando questões offline..." : message);
                    }
                });
            }

            @Override
            public void onComplete(int totalImported) {
                runOnUiThread(() -> {
                    finalizarCarregamento(totalImported);
                    atualizarContador();
                });
            }

            @Override
            public void onError(String error) {
                runOnUiThread(() -> {
                    if (progressBarCarregamento != null) {
                        progressBarCarregamento.setVisibility(View.GONE);
                    }
                    if (tvCarregamento != null) {
                        tvCarregamento.setVisibility(View.GONE);
                    }

                    btnGerarProva.setEnabled(true);
                    btnRedacao.setEnabled(true);
                    if (btnResetarBanco != null) btnResetarBanco.setEnabled(true);

                    Toast.makeText(MenuInicialActivity.this,
                        "Erro ao carregar questões offline: " + error,
                        Toast.LENGTH_LONG).show();
                });
            }
        });
        loader.carregarQuestoesDoAssets();
    }

    private void resetarBancoEReimportar() {
        try {
            getApplicationContext().deleteDatabase("simulapp.db");
            databaseHelper = new DatabaseHelper(this);
            atualizarContador();
            Toast.makeText(this, "Banco resetado. Reimportando...", Toast.LENGTH_SHORT).show();
            iniciarImportacaoAutomatica();
        } catch (Exception e) {
            Toast.makeText(this, "Falha ao resetar banco: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void finalizarCarregamento(int totalImported) {
        if (progressBarCarregamento != null) {
            progressBarCarregamento.setVisibility(View.GONE);
        }
        if (tvCarregamento != null) {
            tvCarregamento.setVisibility(View.GONE);
        }

        btnGerarProva.setEnabled(true);
        btnRedacao.setEnabled(true);
        if (btnResetarBanco != null) btnResetarBanco.setEnabled(true);

        Toast.makeText(MenuInicialActivity.this,
            String.format("%d questões carregadas com sucesso!", totalImported),
            Toast.LENGTH_LONG).show();
    }
}
