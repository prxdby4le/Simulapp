package com.example.simulapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.simulapp.model.Questao;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.List;

public class SimuladoActivity extends AppCompatActivity {

    private List<Questao> questoes;
    private int questaoAtualIndex = 0;

    private TextView tvNumeroQuestao;
    private TextView tvEnunciado;
    private TextView tvTextoApoio;
    private TextView tvFonte;
    private LinearLayout layoutImagens;
    private RadioGroup rgAlternativas;
    private RadioButton rbAlternativaA;
    private RadioButton rbAlternativaB;
    private RadioButton rbAlternativaC;
    private RadioButton rbAlternativaD;
    private RadioButton rbAlternativaE;
    private Button btnProxima;
    private Button btnFinalizar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulado);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> finish());

        tvNumeroQuestao = findViewById(R.id.tvNumeroQuestao);
        tvEnunciado = findViewById(R.id.tvEnunciado);
        tvTextoApoio = findViewById(R.id.tvTextoApoio);
        tvFonte = findViewById(R.id.tvFonte);
        layoutImagens = findViewById(R.id.layoutImagens);
        rgAlternativas = findViewById(R.id.rgAlternativas);
        rbAlternativaA = findViewById(R.id.rbAlternativaA);
        rbAlternativaB = findViewById(R.id.rbAlternativaB);
        rbAlternativaC = findViewById(R.id.rbAlternativaC);
        rbAlternativaD = findViewById(R.id.rbAlternativaD);
        rbAlternativaE = findViewById(R.id.rbAlternativaE);
        btnProxima = findViewById(R.id.btnProxima);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        questoes = (List<Questao>) getIntent().getSerializableExtra("questoes");

        if (questoes == null || questoes.isEmpty()) {
            Toast.makeText(this, "Nenhuma questão disponível", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        exibirQuestao();

        rgAlternativas.setOnCheckedChangeListener((group, checkedId) -> {
            salvarResposta();
        });

        btnProxima.setOnClickListener(v -> {
            if (questaoAtualIndex < questoes.size() - 1) {
                questaoAtualIndex++;
                exibirQuestao();
            }
        });

        btnFinalizar.setOnClickListener(v -> {
            finalizarSimulado();
        });
    }

    private void exibirQuestao() {
        Questao questao = questoes.get(questaoAtualIndex);

        tvNumeroQuestao.setText("Questão " + (questaoAtualIndex + 1) + " de " + questoes.size() +
                               " - " + questao.getArea() + " (" + questao.getAno() + ")");
        tvEnunciado.setText(questao.getEnunciado());

        if (!TextUtils.isEmpty(questao.getTextoApoio())) {
            tvTextoApoio.setVisibility(View.VISIBLE);
            tvTextoApoio.setText(questao.getTextoApoio());
        } else {
            tvTextoApoio.setVisibility(View.GONE);
        }

        if (!TextUtils.isEmpty(questao.getFonte())) {
            tvFonte.setVisibility(View.VISIBLE);
            tvFonte.setText("Fonte: " + questao.getFonte());
        } else {
            tvFonte.setVisibility(View.GONE);
        }

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

        rbAlternativaA.setText("A) " + questao.getAlternativaA());
        rbAlternativaB.setText("B) " + questao.getAlternativaB());
        rbAlternativaC.setText("C) " + questao.getAlternativaC());
        rbAlternativaD.setText("D) " + questao.getAlternativaD());
        rbAlternativaE.setText("E) " + questao.getAlternativaE());

        if (questao.isRespondida()) {
            switch (questao.getRespostaUsuario().toUpperCase()) {
                case "A": rgAlternativas.check(R.id.rbAlternativaA); break;
                case "B": rgAlternativas.check(R.id.rbAlternativaB); break;
                case "C": rgAlternativas.check(R.id.rbAlternativaC); break;
                case "D": rgAlternativas.check(R.id.rbAlternativaD); break;
                case "E": rgAlternativas.check(R.id.rbAlternativaE); break;
            }
        } else {
            rgAlternativas.clearCheck();
        }

        if (questaoAtualIndex == questoes.size() - 1) {
            btnProxima.setVisibility(View.GONE);
            btnFinalizar.setVisibility(View.VISIBLE);
        } else {
            btnProxima.setVisibility(View.VISIBLE);
            btnFinalizar.setVisibility(View.GONE);
        }
    }

    private void salvarResposta() {
        int selectedId = rgAlternativas.getCheckedRadioButtonId();
        if (selectedId == -1) return;

        String resposta = "";
        if (selectedId == R.id.rbAlternativaA) resposta = "A";
        else if (selectedId == R.id.rbAlternativaB) resposta = "B";
        else if (selectedId == R.id.rbAlternativaC) resposta = "C";
        else if (selectedId == R.id.rbAlternativaD) resposta = "D";
        else if (selectedId == R.id.rbAlternativaE) resposta = "E";

        questoes.get(questaoAtualIndex).setRespostaUsuario(resposta);
    }

    private void finalizarSimulado() {
        int acertos = 0;
        for (Questao questao : questoes) {
            if (questao.isCorreta()) {
                acertos++;
            }
        }

        Intent intent = new Intent(this, ResultadoSimuladoActivity.class);
        intent.putExtra("questoes", (ArrayList<Questao>) questoes);
        intent.putExtra("acertos", acertos);
        intent.putExtra("total", questoes.size());
        startActivity(intent);
        finish();
    }
}
