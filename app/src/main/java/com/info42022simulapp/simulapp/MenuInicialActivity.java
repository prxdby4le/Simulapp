package com.info42022simulapp.simulapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.info42022simulapp.simulapp.database.DatabaseHelper;
import com.google.android.material.button.MaterialButton;
import com.info42022simulapp.simulapp.utils.QuestoesOfflineLoader;

import java.util.Locale;

public class MenuInicialActivity extends AppCompatActivity {

    private MaterialButton btnGerarProva, btnRedacao;
    private TextView tvLoginLink;
    private ProgressBar progressBarCarregamento;
    private TextView tvCarregamento;
    private TextView tvTotalQuestoes;
    private DatabaseHelper databaseHelper;
    private ImageButton btnSettings;

    private static final String PREFS_NAME = "simulapp_prefs";
    private static final String KEY_FIRST_RUN_COMPLETED = "first_run_completed";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_inicial);

        databaseHelper = new DatabaseHelper(this);
        try { databaseHelper.normalizarRespostasCorretas(); } catch (Exception ignore) {}

        btnGerarProva = findViewById(R.id.btnGerarProva);
        btnRedacao = findViewById(R.id.btnRedacao);
        btnSettings = findViewById(R.id.btnSettings);
        tvLoginLink = findViewById(R.id.tvLoginLink);
        progressBarCarregamento = findViewById(R.id.progressBarCarregamento);
        tvCarregamento = findViewById(R.id.tvCarregamento);
        tvTotalQuestoes = findViewById(R.id.tvTotalQuestoes);

        configurarCliques();
        atualizarContador();

        if (!isFirstRunCompleted()) {
            iniciarImportacaoAutomatica();
        } else {
            verificarECarregarQuestoes();
        }
    }

    private void configurarCliques() {
        btnGerarProva.setOnClickListener(v -> startActivity(new Intent(this, GerarProvaActivity.class)));
        btnRedacao.setOnClickListener(v -> startActivity(new Intent(this, RedacaoActivity.class)));
        tvLoginLink.setOnClickListener(v -> startActivity(new Intent(this, EntrarComCodigoActivity.class)));
        if (btnSettings != null) btnSettings.setOnClickListener(this::mostrarMenuSettings);
    }

    private void mostrarMenuSettings(View anchor) {
        PopupMenu popup = new PopupMenu(this, anchor);
        popup.getMenu().add(0, 1, 0, getString(R.string.menu_sobre));
        popup.getMenu().add(0, 2, 1, getString(R.string.menu_resetar_banco));
        popup.setOnMenuItemClickListener(this::onSettingsMenuItem);
        popup.show();
    }

    private boolean onSettingsMenuItem(MenuItem item) {
        int id = item.getItemId();
        if (id == 1) {
            startActivity(new Intent(this, SobreActivity.class));
            return true;
        } else if (id == 2) {
            resetarBancoEReimportar();
            return true;
        }
        return false;
    }

    private void atualizarContador() {
        if (tvTotalQuestoes != null) {
            int total = 0;
            try { total = databaseHelper.getTotalQuestoes(); } catch (Exception ignore) {}
            tvTotalQuestoes.setText(getString(R.string.label_total_questoes, total));
        }
    }

    private void verificarECarregarQuestoes() {
        int total = 0;
        try { total = databaseHelper.getTotalQuestoes(); } catch (Exception ignore) {}
        if (total < 2000) {
            iniciarImportacaoAutomatica();
        } else {
            if (progressBarCarregamento != null) progressBarCarregamento.setVisibility(View.GONE);
            if (tvCarregamento != null) tvCarregamento.setVisibility(View.GONE);
        }
    }

    private void iniciarImportacaoAutomatica() {
        if (progressBarCarregamento != null) progressBarCarregamento.setVisibility(View.VISIBLE);
        if (tvCarregamento != null) {
            tvCarregamento.setVisibility(View.VISIBLE);
            tvCarregamento.setText(getString(R.string.carregando_preparando));
        }
        btnGerarProva.setEnabled(false);
        btnRedacao.setEnabled(false);
        if (btnSettings != null) btnSettings.setEnabled(false);
        carregarQuestoesOfflineAssets();
    }

    private boolean isFirstRunCompleted() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        return prefs.getBoolean(KEY_FIRST_RUN_COMPLETED, false);
    }

    private void marcarFirstRunCompleta() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        prefs.edit().putBoolean(KEY_FIRST_RUN_COMPLETED, true).apply();
    }

    private void marcarFirstRunIncompleta() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        prefs.edit().putBoolean(KEY_FIRST_RUN_COMPLETED, false).apply();
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
                        tvCarregamento.setText(message == null ? getString(R.string.carregando_offline) : message);
                    }
                });
            }
            @Override
            public void onComplete(int totalImported) {
                runOnUiThread(() -> {
                    try { databaseHelper.normalizarRespostasCorretas(); } catch (Exception ignore) {}
                    finalizarCarregamento(totalImported);
                    atualizarContador();
                    marcarFirstRunCompleta();
                });
            }
            @Override
            public void onError(String error) {
                runOnUiThread(() -> {
                    if (progressBarCarregamento != null) progressBarCarregamento.setVisibility(View.GONE);
                    if (tvCarregamento != null) tvCarregamento.setVisibility(View.GONE);
                    btnGerarProva.setEnabled(true);
                    btnRedacao.setEnabled(true);
                    if (btnSettings != null) btnSettings.setEnabled(true);
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
            marcarFirstRunIncompleta(); // garantir auto-import no próximo launch se algo falhar
            atualizarContador();
            Toast.makeText(this, getString(R.string.msg_banco_resetado), Toast.LENGTH_SHORT).show();
            iniciarImportacaoAutomatica();
        } catch (Exception e) {
            Toast.makeText(this, getString(R.string.msg_banco_falhou_resetar, e.getMessage()), Toast.LENGTH_LONG).show();
        }
    }

    private void finalizarCarregamento(int totalImported) {
        if (progressBarCarregamento != null) progressBarCarregamento.setVisibility(View.GONE);
        if (tvCarregamento != null) tvCarregamento.setVisibility(View.GONE);
        btnGerarProva.setEnabled(true);
        btnRedacao.setEnabled(true);
        if (btnSettings != null) btnSettings.setEnabled(true);
        Toast.makeText(MenuInicialActivity.this,
                String.format(Locale.getDefault(), getString(R.string.msg_questoes_carregadas), totalImported),
                Toast.LENGTH_LONG).show();
    }
}
