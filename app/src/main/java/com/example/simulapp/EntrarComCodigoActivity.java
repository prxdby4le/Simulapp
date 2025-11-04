package com.example.simulapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.simulapp.database.DatabaseHelper;
import com.example.simulapp.model.CodigoProva;
import com.example.simulapp.model.Questao;
import com.example.simulapp.utils.CodigoProvaDecoder;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Activity para entrada de código de prova.
 * Decodifica códigos no formato G1-G2-G3-G4-G5-G6-G7 e valida em tempo real.
 */
public class EntrarComCodigoActivity extends AppCompatActivity {

    private static final String TAG = "EntrarComCodigo";

    private TextInputEditText etCodigo;
    private TextInputLayout tilCodigo;
    private MaterialButton btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrar_com_codigo);

        // Configurar toolbar com botão de voltar
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> finish());

        // Inicializar views
        etCodigo = findViewById(R.id.etCodigo);
        tilCodigo = findViewById(R.id.tilCodigo);
        btnEntrar = findViewById(R.id.btnEntrar);

        // Configurar listeners
        setupListeners();
    }

    /**
     * Configura os listeners dos campos e botões.
     */
    private void setupListeners() {
        // Validação em tempo real enquanto digita
        etCodigo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Não usado
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Limpar erro enquanto digita
                tilCodigo.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Converter para maiúsculas
                String input = s.toString().toUpperCase();
                if (!input.equals(s.toString())) {
                    s.replace(0, s.length(), input);
                }

                // Validação após digitar
                String codigo = s.toString().trim();
                if (!codigo.isEmpty() && codigo.length() >= 17) { // Tamanho mínimo: XX-XX-XX-XX-XX-X-X
                    validarFormatoEmTempoReal(codigo);
                }
            }
        });

        // Validação ao perder o foco
        etCodigo.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                String codigo = etCodigo.getText() != null ?
                    etCodigo.getText().toString().trim().toUpperCase() : "";
                if (!codigo.isEmpty()) {
                    validarFormatoCompleto(codigo);
                }
            }
        });

        // Ação do botão Entrar
        btnEntrar.setOnClickListener(v -> processarCodigo());
    }

    /**
     * Validação básica em tempo real (não invasiva).
     */
    private void validarFormatoEmTempoReal(String codigo) {
        if (CodigoProvaDecoder.validarFormato(codigo)) {
            tilCodigo.setHelperText("✓ Formato válido");
            tilCodigo.setError(null);
        }
    }

    /**
     * Validação completa ao perder o foco.
     */
    private void validarFormatoCompleto(String codigo) {
        if (!CodigoProvaDecoder.validarFormato(codigo)) {
            tilCodigo.setError("Formato inválido");
            tilCodigo.setHelperText("Use: HH-HH-HH-HH-HH-H-B (Ex: 0A-14-05-FF-02-A-1)");
        } else {
            tilCodigo.setError(null);
            tilCodigo.setHelperText("✓ Formato válido");
        }
    }

    /**
     * Processa o código inserido e decodifica.
     */
    private void processarCodigo() {
        String codigo = etCodigo.getText() != null ?
            etCodigo.getText().toString().trim().toUpperCase() : "";

        // Validar entrada vazia
        if (codigo.isEmpty()) {
            tilCodigo.setError("Digite um código");
            tilCodigo.setHelperText(null);
            etCodigo.requestFocus();
            return;
        }

        // Validar formato
        if (!CodigoProvaDecoder.validarFormato(codigo)) {
            tilCodigo.setError("Formato inválido");
            tilCodigo.setHelperText("Formato esperado: HH-HH-HH-HH-HH-H-B (Ex: 0A-14-05-FF-02-A-1)");

            Toast.makeText(this,
                "❌ Código inválido\n" +
                "Use formato: HH-HH-HH-HH-HH-H-B\n" +
                "Exemplo: 0A-14-05-FF-02-A-1",
                Toast.LENGTH_LONG).show();

            return;
        }

        // Limpar erros
        tilCodigo.setError(null);
        tilCodigo.setHelperText("✓ Processando...");

        // Obter data atual
        String dataAtual = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date());

        try {
            // Decodificar código
            CodigoProva resultado = CodigoProvaDecoder.decodificar(codigo, dataAtual);

            // Log dos resultados
            logResultado(resultado);

            // Mostrar feedback de sucesso
            int totalQuestoes = calcularTotalQuestoes(resultado);
            tilCodigo.setHelperText("✓ Código válido - Carregando questões...");

            // Buscar questões do banco de dados baseado nos índices
            DatabaseHelper db = new DatabaseHelper(this);
            List<Long> idsQuestoesSelecionadas = new ArrayList<>();

            // Mapear idioma para o formato do banco
            String idiomaDb = resultado.getIdioma().equals("inglês") ? "inglês" : "espanhol";

            // Buscar questões para cada competência
            idsQuestoesSelecionadas.addAll(
                buscarQuestoesPorIndices(db, DatabaseHelper.AREA_LINGUAGENS,
                    resultado.getCompetenciaA().getIndicesSelecionados(), idiomaDb)
            );
            idsQuestoesSelecionadas.addAll(
                buscarQuestoesPorIndices(db, DatabaseHelper.AREA_HUMANAS,
                    resultado.getCompetenciaB().getIndicesSelecionados(), idiomaDb)
            );
            idsQuestoesSelecionadas.addAll(
                buscarQuestoesPorIndices(db, DatabaseHelper.AREA_NATUREZA,
                    resultado.getCompetenciaC().getIndicesSelecionados(), idiomaDb)
            );
            idsQuestoesSelecionadas.addAll(
                buscarQuestoesPorIndices(db, DatabaseHelper.AREA_MATEMATICA,
                    resultado.getCompetenciaD().getIndicesSelecionados(), idiomaDb)
            );

            if (idsQuestoesSelecionadas.isEmpty()) {
                Toast.makeText(this,
                    "❌ Nenhuma questão encontrada no banco de dados.\n" +
                    "Importe questões antes de usar o código.",
                    Toast.LENGTH_LONG).show();
                tilCodigo.setHelperText(null);
                return;
            }

            // Converter List<Long> para long[]
            long[] idsArray = new long[idsQuestoesSelecionadas.size()];
            for (int i = 0; i < idsQuestoesSelecionadas.size(); i++) {
                idsArray[i] = idsQuestoesSelecionadas.get(i);
            }

            // Navegar para SimuladoActivity
            Intent intent = new Intent(this, SimuladoActivity.class);
            intent.putExtra("questao_ids", idsArray);
            startActivity(intent);
            finish();

        } catch (IllegalArgumentException e) {
            tilCodigo.setError("Erro ao processar");
            tilCodigo.setHelperText(null);

            Toast.makeText(this,
                "❌ Erro ao decodificar: " + e.getMessage(),
                Toast.LENGTH_LONG).show();

            Log.e(TAG, "Erro ao processar código: " + codigo, e);
        }
    }

    /**
     * Calcula total de questões em todas as competências.
     */
    private int calcularTotalQuestoes(CodigoProva resultado) {
        return resultado.getCompetenciaA().getTotalQuestoes() +
               resultado.getCompetenciaB().getTotalQuestoes() +
               resultado.getCompetenciaC().getTotalQuestoes() +
               resultado.getCompetenciaD().getTotalQuestoes();
    }

    /**
     * Log detalhado do resultado (para debug).
     */
    private void logResultado(CodigoProva resultado) {
        Log.d(TAG, "===== CÓDIGO DECODIFICADO =====");
        Log.d(TAG, "Idioma: " + resultado.getIdioma());

        logCompetencia("A", resultado.getCompetenciaA());
        logCompetencia("B", resultado.getCompetenciaB());
        logCompetencia("C", resultado.getCompetenciaC());
        logCompetencia("D", resultado.getCompetenciaD());

        Log.d(TAG, "Total: " + calcularTotalQuestoes(resultado) + " questões");
        Log.d(TAG, "===============================");
    }

    /**
     * Log de uma competência específica.
     */
    private void logCompetencia(String nome, CodigoProva.CompetenciaInfo info) {
        Log.d(TAG, String.format(Locale.US,
            "Competência %s: %d questões → Índices: %s",
            nome,
            info.getTotalQuestoes(),
            info.getIndicesSelecionados().toString()
        ));
    }

    /**
     * Busca questões do banco de dados baseado em área e índices específicos.
     *
     * @param db DatabaseHelper
     * @param area Área/Competência (Linguagens, Humanas, Natureza, Matemática)
     * @param indices Lista de índices das questões a serem selecionadas
     * @param idioma Idioma (inglês, espanhol)
     * @return Lista de IDs das questões encontradas
     */
    private List<Long> buscarQuestoesPorIndices(DatabaseHelper db, String area,
                                                 List<Integer> indices, String idioma) {
        List<Long> ids = new ArrayList<>();

        if (indices.isEmpty()) {
            return ids;
        }

        // Buscar todas as questões da área ordenadas
        List<Questao> todasQuestoes = db.getTodasQuestoesPorArea(area, idioma);

        Log.d(TAG, String.format(Locale.US,
            "Área %s: %d questões disponíveis, selecionando %d índices",
            area, todasQuestoes.size(), indices.size()
        ));

        // Selecionar questões pelos índices
        for (int indice : indices) {
            if (indice >= 0 && indice < todasQuestoes.size()) {
                ids.add(todasQuestoes.get(indice).getId());
            } else {
                Log.w(TAG, String.format(Locale.US,
                    "Índice %d fora do range para área %s (total: %d)",
                    indice, area, todasQuestoes.size()
                ));
            }
        }

        return ids;
    }
}
