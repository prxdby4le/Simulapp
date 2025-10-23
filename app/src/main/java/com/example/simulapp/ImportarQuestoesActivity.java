package com.example.simulapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.simulapp.api.EnemApiImporter;
import com.example.simulapp.database.DatabaseHelper;

public class ImportarQuestoesActivity extends AppCompatActivity {

    private Button btnImportar;
    private ProgressBar progressBar;
    private TextView tvProgress;
    private TextView tvStatus;
    private DatabaseHelper databaseHelper;
    private EnemApiImporter apiImporter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_importar_questoes);

        databaseHelper = new DatabaseHelper(this);
        apiImporter = new EnemApiImporter(this, databaseHelper);

        initViews();
        setupListeners();
    }

    private void initViews() {
        btnImportar = findViewById(R.id.btnImportar);
        progressBar = findViewById(R.id.progressBar);
        tvProgress = findViewById(R.id.tvProgress);
        tvStatus = findViewById(R.id.tvStatus);

        progressBar.setVisibility(View.GONE);
        tvProgress.setVisibility(View.GONE);
        tvStatus.setVisibility(View.GONE);
    }

    private void setupListeners() {
        btnImportar.setOnClickListener(v -> iniciarImportacao());

        apiImporter.setProgressCallback(new EnemApiImporter.ProgressCallback() {
            @Override
            public void onProgress(int current, int total, String message) {
                runOnUiThread(() -> {
                    progressBar.setMax(total);
                    progressBar.setProgress(current);
                    tvProgress.setText(String.format("%d / %d", current, total));
                    tvStatus.setText(message);
                });
            }

            @Override
            public void onComplete(int totalImported) {
                runOnUiThread(() -> {
                    btnImportar.setEnabled(true);
                    progressBar.setVisibility(View.GONE);
                    tvProgress.setVisibility(View.GONE);
                    tvStatus.setText(String.format("✅ Importação concluída!\n%d questões do ENEM foram importadas com sucesso.", totalImported));
                    Toast.makeText(ImportarQuestoesActivity.this,
                        String.format("Sucesso! %d questões importadas", totalImported), Toast.LENGTH_LONG).show();
                });
            }

            @Override
            public void onError(String error) {
                runOnUiThread(() -> {
                    btnImportar.setEnabled(true);
                    progressBar.setVisibility(View.GONE);
                    tvProgress.setVisibility(View.GONE);
                    tvStatus.setText("❌ Erro: " + error + "\n\nVerifique sua conexão com a internet e tente novamente.");
                    Toast.makeText(ImportarQuestoesActivity.this,
                        "Erro na importação: " + error, Toast.LENGTH_LONG).show();
                });
            }
        });
    }

    private void iniciarImportacao() {
        btnImportar.setEnabled(false);
        progressBar.setVisibility(View.VISIBLE);
        tvProgress.setVisibility(View.VISIBLE);
        tvStatus.setVisibility(View.VISIBLE);
        tvStatus.setText("🌐 Conectando à API do ENEM...\nIsso pode levar 10-30 minutos.\nMantenha o app aberto e conectado ao WiFi.");

        // Importar todas as questões da API
        apiImporter.importarTodasQuestoes();
    }
}

