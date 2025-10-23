package com.example.simulapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.simulapp.database.DatabaseHelper;
import com.example.simulapp.AdicionarQuestoesUtil;
import com.google.android.material.button.MaterialButton;

public class MenuInicialActivity extends AppCompatActivity {

    private MaterialButton btnGerarProva, btnRedacao, btnImportarQuestoes;
    private TextView tvLoginLink;
    private ProgressBar progressBarCarregamento;
    private TextView tvCarregamento;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_inicial);

        databaseHelper = new DatabaseHelper(this);

        btnGerarProva = findViewById(R.id.btnGerarProva);
        btnRedacao = findViewById(R.id.btnRedacao);
        btnImportarQuestoes = findViewById(R.id.btnImportarQuestoes);
        tvLoginLink = findViewById(R.id.tvLoginLink);
        progressBarCarregamento = findViewById(R.id.progressBarCarregamento);
        tvCarregamento = findViewById(R.id.tvCarregamento);

        configurarCliques();
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

        btnImportarQuestoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuInicialActivity.this, ImportarQuestoesActivity.class);
                startActivity(intent);
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

    private void verificarECarregarQuestoes() {
        // Verificar se as questões já foram carregadas
        if (!databaseHelper.isQuestoesCarregadas()) {
            // Questões ainda não foram carregadas, iniciar importação automática
            iniciarImportacaoAutomatica();
        } else {
            // Questões já carregadas, esconder indicador de carregamento
            if (progressBarCarregamento != null) {
                progressBarCarregamento.setVisibility(View.GONE);
            }
            if (tvCarregamento != null) {
                tvCarregamento.setVisibility(View.GONE);
            }
        }
    }

    private void iniciarImportacaoAutomatica() {
        // Mostrar indicador de carregamento
        if (progressBarCarregamento != null) {
            progressBarCarregamento.setVisibility(View.VISIBLE);
        }
        if (tvCarregamento != null) {
            tvCarregamento.setVisibility(View.VISIBLE);
            tvCarregamento.setText("Preparando questões do ENEM...");
        }

        // Desabilitar botões durante o carregamento
        btnGerarProva.setEnabled(false);
        btnRedacao.setEnabled(false);
        btnImportarQuestoes.setEnabled(false);

        // Carregar questões diretamente do código (embutidas no APK)
        carregarQuestoesManuais();
    }

    private void carregarQuestoesManuais() {
        new Thread(() -> {
            try {
                runOnUiThread(() -> {
                    if (tvCarregamento != null) {
                        tvCarregamento.setText("Carregando questões do ENEM...");
                    }
                });

                // Adicionar questões embutidas no código
                AdicionarQuestoesUtil.adicionarQuestoes(databaseHelper);

                int totalQuestoes = databaseHelper.getTotalQuestoes();

                runOnUiThread(() -> {
                    finalizarCarregamento(totalQuestoes);
                });
            } catch (Exception e) {
                runOnUiThread(() -> {
                    if (progressBarCarregamento != null) {
                        progressBarCarregamento.setVisibility(View.GONE);
                    }
                    if (tvCarregamento != null) {
                        tvCarregamento.setVisibility(View.GONE);
                    }

                    btnGerarProva.setEnabled(true);
                    btnRedacao.setEnabled(true);
                    btnImportarQuestoes.setEnabled(true);

                    Toast.makeText(MenuInicialActivity.this,
                        "Erro ao carregar questões: " + e.getMessage(),
                        Toast.LENGTH_LONG).show();
                });
            }
        }).start();
    }

    private void finalizarCarregamento(int totalImported) {
        // Esconder indicador de carregamento
        if (progressBarCarregamento != null) {
            progressBarCarregamento.setVisibility(View.GONE);
        }
        if (tvCarregamento != null) {
            tvCarregamento.setVisibility(View.GONE);
        }

        // Habilitar botões novamente
        btnGerarProva.setEnabled(true);
        btnRedacao.setEnabled(true);
        btnImportarQuestoes.setEnabled(true);

        Toast.makeText(MenuInicialActivity.this,
            String.format("%d questões carregadas com sucesso!", totalImported),
            Toast.LENGTH_LONG).show();
    }
}