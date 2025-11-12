package com.info42022simulapp.simulapp;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.info42022simulapp.simulapp.model.CodigoProva;
import com.info42022simulapp.simulapp.utils.CodigoProvaDecoder;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Activity para entrada de código de prova.
 * Permite ao usuário inserir um código no formato G1-G2-G3-G4-G5-G6-G7
 * e decodifica as questões selecionadas para cada competência.
 *
 * Exemplo de integração com CodigoProvaDecoder.
 */
public class EntrarComCodigoActivityCompleto extends AppCompatActivity {

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

        // Configurar ação do botão
        btnEntrar.setOnClickListener(v -> processarCodigo());

        // Validação em tempo real (opcional)
        etCodigo.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                validarFormatoCodigo();
            }
        });
    }

    /**
     * Valida o formato do código em tempo real.
     */
    private void validarFormatoCodigo() {
        String codigo = etCodigo.getText() != null ?
            etCodigo.getText().toString().trim().toUpperCase() : "";

        if (codigo.isEmpty()) {
            tilCodigo.setError(null);
            return;
        }

        if (!CodigoProvaDecoder.validarFormato(codigo)) {
            tilCodigo.setError("Formato inválido. Use: HH-HH-HH-HH-HH-H-B");
        } else {
            tilCodigo.setError(null);
            tilCodigo.setHelperText("Formato válido ✓");
        }
    }

    /**
     * Processa o código inserido e decodifica as questões.
     */
    private void processarCodigo() {
        String codigo = etCodigo.getText() != null ?
            etCodigo.getText().toString().trim().toUpperCase() : "";

        // Validar entrada vazia
        if (codigo.isEmpty()) {
            tilCodigo.setError("Digite um código");
            return;
        }

        // Validar formato
        if (!CodigoProvaDecoder.validarFormato(codigo)) {
            tilCodigo.setError("Formato inválido. Exemplo: 0A-14-05-FF-02-A-1");
            Toast.makeText(this,
                "Formato esperado: HH-HH-HH-HH-HH-H-B\n" +
                "H = hex (0-9, A-F)\n" +
                "B = binário (0 ou 1)",
                Toast.LENGTH_LONG).show();
            return;
        }

        tilCodigo.setError(null);

        // Obter data atual
        String dataAtual = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date());

        try {
            // Decodificar código
            CodigoProva resultado = CodigoProvaDecoder.decodificar(codigo, dataAtual);

            // Processar resultado
            processarResultado(resultado);

            // Feedback ao usuário
            Toast.makeText(this,
                "Código decodificado com sucesso!\n" +
                "Idioma: " + resultado.getIdioma() + "\n" +
                "Total questões: " + calcularTotalQuestoes(resultado),
                Toast.LENGTH_LONG).show();

            // Aqui você pode navegar para outra activity com os dados
            // Intent intent = new Intent(this, SimuladoActivity.class);
            // intent.putExtra("codigo_prova", resultado);
            // startActivity(intent);

        } catch (IllegalArgumentException e) {
            tilCodigo.setError("Erro ao processar código");
            Toast.makeText(this, "Erro: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Processa o resultado decodificado.
     * Aqui você pode implementar a lógica para usar os índices selecionados.
     */
    private void processarResultado(CodigoProva resultado) {
        // Log dos resultados (para debug)
        android.util.Log.d("CodigoProva", "Idioma: " + resultado.getIdioma());

        logCompetencia("A", resultado.getCompetenciaA());
        logCompetencia("B", resultado.getCompetenciaB());
        logCompetencia("C", resultado.getCompetenciaC());
        logCompetencia("D", resultado.getCompetenciaD());

        // Aqui você implementaria:
        // 1. Carregar questões do banco de dados/API
        // 2. Selecionar questões usando os índices retornados
        // 3. Montar a prova
        // 4. Iniciar o simulado

        // Exemplo pseudocódigo:
        // List<Questao> questoesA = buscarQuestoesPorCompetencia("A");
        // List<Questao> questoesSelecionadasA = new ArrayList<>();
        // for (int indice : resultado.getCompetenciaA().getIndicesSelecionados()) {
        //     if (indice < questoesA.size()) {
        //         questoesSelecionadasA.add(questoesA.get(indice));
        //     }
        // }
    }

    /**
     * Log de informações de uma competência.
     */
    private void logCompetencia(String nome, CodigoProva.CompetenciaInfo info) {
        android.util.Log.d("CodigoProva",
            String.format(Locale.US,
                "Competência %s: %d questões → Índices: %s",
                nome,
                info.getTotalQuestoes(),
                info.getIndicesSelecionados().toString()
            )
        );
    }

    /**
     * Calcula o total de questões em todas as competências.
     */
    private int calcularTotalQuestoes(CodigoProva resultado) {
        return resultado.getCompetenciaA().getTotalQuestoes() +
               resultado.getCompetenciaB().getTotalQuestoes() +
               resultado.getCompetenciaC().getTotalQuestoes() +
               resultado.getCompetenciaD().getTotalQuestoes();
    }
}

