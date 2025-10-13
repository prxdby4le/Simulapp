package com.example.simulapp;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.simulapp.model.Questao;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.List;

public class AnalisarTentativaActivity extends AppCompatActivity {

    private List<Questao> questoes;
    private int questaoAtualIndex = 0;

    private TextView tvNumeroQuestao;
    private TextView tvEnunciado;
    private LinearLayout layoutTextosApoio;
    private LinearLayout layoutImagens;
    private TextView tvAlternativaA;
    private TextView tvAlternativaB;
    private TextView tvAlternativaC;
    private TextView tvAlternativaD;
    private TextView tvAlternativaE;
    private Button btnAnterior;
    private Button btnProxima;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analisar_tentativa);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> finish());

        tvNumeroQuestao = findViewById(R.id.tvNumeroQuestao);
        tvEnunciado = findViewById(R.id.tvEnunciado);
        layoutTextosApoio = findViewById(R.id.layoutTextosApoio);
        layoutImagens = findViewById(R.id.layoutImagens);
        tvAlternativaA = findViewById(R.id.tvAlternativaA);
        tvAlternativaB = findViewById(R.id.tvAlternativaB);
        tvAlternativaC = findViewById(R.id.tvAlternativaC);
        tvAlternativaD = findViewById(R.id.tvAlternativaD);
        tvAlternativaE = findViewById(R.id.tvAlternativaE);
        btnAnterior = findViewById(R.id.btnAnterior);
        btnProxima = findViewById(R.id.btnProxima);

        questoes = (ArrayList<Questao>) getIntent().getSerializableExtra("questoes");

        if (questoes == null || questoes.isEmpty()) {
            Toast.makeText(this, "Nenhuma questão disponível", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        exibirQuestao();

        btnAnterior.setOnClickListener(v -> {
            if (questaoAtualIndex > 0) {
                questaoAtualIndex--;
                exibirQuestao();
            }
        });

        btnProxima.setOnClickListener(v -> {
            if (questaoAtualIndex < questoes.size() - 1) {
                questaoAtualIndex++;
                exibirQuestao();
            }
        });
    }

    private void exibirQuestao() {
        Questao questao = questoes.get(questaoAtualIndex);

        tvNumeroQuestao.setText("Questão " + (questaoAtualIndex + 1) + " de " + questoes.size() +
                " - " + questao.getArea() + " (" + questao.getAno() + ")");
        tvEnunciado.setText(questao.getEnunciado());

        // Exibir múltiplos textos de apoio
        layoutTextosApoio.removeAllViews();
        if (questao.temTextosApoio()) {
            layoutTextosApoio.setVisibility(View.VISIBLE);
            String[] textosApoio = questao.getTextosApoio();

            for (int i = 0; i < textosApoio.length; i++) {
                String texto = textosApoio[i];
                TextView tvTexto = new TextView(this);
                tvTexto.setText(texto);
                tvTexto.setTextSize(14);

                if (texto.startsWith("Fonte:") || texto.contains("Disponível em:") || texto.contains("Acesso em:")) {
                    tvTexto.setTextColor(getResources().getColor(R.color.colorTextoFonte));
                    tvTexto.setTypeface(null, android.graphics.Typeface.ITALIC);
                    tvTexto.setTextSize(11);
                    tvTexto.setGravity(android.view.Gravity.END);
                } else {
                    tvTexto.setTextColor(getResources().getColor(R.color.colorTextoApoio));
                    tvTexto.setBackground(getResources().getDrawable(R.drawable.border_text));
                    tvTexto.setPadding(
                            (int) (12 * getResources().getDisplayMetrics().density),
                            (int) (12 * getResources().getDisplayMetrics().density),
                            (int) (12 * getResources().getDisplayMetrics().density),
                            (int) (12 * getResources().getDisplayMetrics().density)
                    );
                }

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.bottomMargin = (int) (8 * getResources().getDisplayMetrics().density);
                tvTexto.setLayoutParams(params);

                layoutTextosApoio.addView(tvTexto);
            }
        } else {
            layoutTextosApoio.setVisibility(View.GONE);
        }

        // Exibir imagens
        layoutImagens.removeAllViews();
        if (questao.temImagens()) {
            layoutImagens.setVisibility(View.VISIBLE);
            String[] imagens = questao.getImagens();

            for (String nomeImagem : imagens) {
                int resourceId = getResources().getIdentifier(nomeImagem, "mipmap", getPackageName());

                if (resourceId != 0) {
                    ImageView imageView = new ImageView(this);
                    imageView.setLayoutParams(new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    ));
                    imageView.setAdjustViewBounds(true);
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    imageView.setImageResource(resourceId);

                    LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) imageView.getLayoutParams();
                    params.bottomMargin = (int) (8 * getResources().getDisplayMetrics().density);
                    imageView.setLayoutParams(params);

                    layoutImagens.addView(imageView);
                }
            }
        } else {
            layoutImagens.setVisibility(View.GONE);
        }

        // Exibir alternativas com indicação visual
        tvAlternativaA.setText("A) " + questao.getAlternativaA());
        tvAlternativaB.setText("B) " + questao.getAlternativaB());
        tvAlternativaC.setText("C) " + questao.getAlternativaC());
        tvAlternativaD.setText("D) " + questao.getAlternativaD());
        tvAlternativaE.setText("E) " + questao.getAlternativaE());

        // Resetar estilos
        resetarAlternativa(tvAlternativaA);
        resetarAlternativa(tvAlternativaB);
        resetarAlternativa(tvAlternativaC);
        resetarAlternativa(tvAlternativaD);
        resetarAlternativa(tvAlternativaE);

        // Aplicar estilos de acordo com resposta
        String respostaCorreta = questao.getRespostaCorreta().toUpperCase();
        String respostaUsuario = questao.getRespostaUsuario() != null ? questao.getRespostaUsuario().toUpperCase() : "";

        // Marcar a resposta correta com borda verde e ✓
        marcarAlternativaCorreta(getTextViewPorLetra(respostaCorreta), respostaCorreta);

        // Se o usuário errou, marcar a resposta dele com borda vermelha e traço
        if (!respostaUsuario.isEmpty() && !respostaUsuario.equals(respostaCorreta)) {
            marcarAlternativaErrada(getTextViewPorLetra(respostaUsuario), respostaUsuario);
        }

        // Controle de navegação
        btnAnterior.setEnabled(questaoAtualIndex > 0);
        btnProxima.setEnabled(questaoAtualIndex < questoes.size() - 1);
    }

    private TextView getTextViewPorLetra(String letra) {
        switch (letra) {
            case "A": return tvAlternativaA;
            case "B": return tvAlternativaB;
            case "C": return tvAlternativaC;
            case "D": return tvAlternativaD;
            case "E": return tvAlternativaE;
            default: return null;
        }
    }

    private void resetarAlternativa(TextView tv) {
        tv.setBackground(getResources().getDrawable(R.drawable.border_text));
        tv.setPaintFlags(tv.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
        tv.setTextColor(Color.BLACK);
    }

    private void marcarAlternativaCorreta(TextView tv, String letra) {
        if (tv != null) {
            tv.setBackground(getResources().getDrawable(R.drawable.border_correct));
            tv.setTextColor(Color.parseColor("#2E7D32"));
            // Adicionar ✓ antes da letra
            String textoOriginal = tv.getText().toString();
            tv.setText("✓ " + textoOriginal);
        }
    }

    private void marcarAlternativaErrada(TextView tv, String letra) {
        if (tv != null) {
            tv.setBackground(getResources().getDrawable(R.drawable.border_wrong));
            tv.setTextColor(Color.parseColor("#C62828"));
            // Adicionar traço no texto
            tv.setPaintFlags(tv.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }
}
