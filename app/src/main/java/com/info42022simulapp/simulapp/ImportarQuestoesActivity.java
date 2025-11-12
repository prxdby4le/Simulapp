package com.info42022simulapp.simulapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.info42022simulapp.simulapp.database.DatabaseHelper;
import com.info42022simulapp.simulapp.utils.QuestoesOfflineLoader;

import java.util.Locale;

public class ImportarQuestoesActivity extends AppCompatActivity {

    private Button btnImportar;
    private ProgressBar progressBar;
    private TextView tvProgress;
    private TextView tvStatus;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_importar_questoes);

        databaseHelper = new DatabaseHelper(this);

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
    }

    private void iniciarImportacao() {
        btnImportar.setEnabled(false);
        progressBar.setVisibility(View.VISIBLE);
        tvProgress.setVisibility(View.VISIBLE);
        tvStatus.setVisibility(View.VISIBLE);
        tvStatus.setText("Carregando questões offline dos assets...\nIsso pode levar alguns minutos.");

        QuestoesOfflineLoader loader = new QuestoesOfflineLoader(this, databaseHelper);
        loader.setProgressCallback(new QuestoesOfflineLoader.ProgressCallback() {
            @Override
            public void onProgress(int current, int total, String message) {
                runOnUiThread(() -> {
                    progressBar.setMax(Math.max(1, total));
                    progressBar.setProgress(Math.min(current, total));
                    tvProgress.setText(String.format(Locale.getDefault(), "%d / %d", current, total));
                    tvStatus.setText(message == null ? "Carregando..." : message);
                });
            }

            @Override
            public void onComplete(int totalImported) {
                runOnUiThread(() -> {
                    btnImportar.setEnabled(true);
                    progressBar.setVisibility(View.GONE);
                    tvProgress.setVisibility(View.GONE);
                    tvStatus.setText(String.format(Locale.getDefault(), "✅ Carregamento concluído!\n%d questões foram importadas dos assets.", totalImported));
                    Toast.makeText(ImportarQuestoesActivity.this,
                        String.format(Locale.getDefault(), "Sucesso! %d questões importadas (offline)", totalImported), Toast.LENGTH_LONG).show();

                    // Normalizar respostas corretas para garantir marcação verde
                    int fix = databaseHelper.normalizarRespostasCorretas();
                    android.util.Log.d("ImportarQuestoes", "Respostas normalizadas: " + fix);
                });
            }

            @Override
            public void onError(String error) {
                runOnUiThread(() -> {
                    btnImportar.setEnabled(true);
                    progressBar.setVisibility(View.GONE);
                    tvProgress.setVisibility(View.GONE);
                    tvStatus.setText(String.format(Locale.getDefault(), "❌ Erro: %s", error));
                    Toast.makeText(ImportarQuestoesActivity.this,
                        String.format(Locale.getDefault(), "Erro no carregamento offline: %s", error), Toast.LENGTH_LONG).show();
                });
            }
        });
        loader.carregarQuestoesDoAssets();
    }
}
