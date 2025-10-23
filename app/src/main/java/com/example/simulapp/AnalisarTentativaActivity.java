package com.example.simulapp;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.simulapp.database.DatabaseHelper;
import com.example.simulapp.model.Questao;
import com.github.chrisbanes.photoview.PhotoView;
import com.google.android.material.appbar.MaterialToolbar;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalisarTentativaActivity extends AppCompatActivity {

    private List<Questao> questoes;
    private int questaoAtualIndex = 0;

    private TextView tvNumeroQuestao;
    private TextView tvQuestaoOriginal;
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
        tvQuestaoOriginal = findViewById(R.id.tvQuestaoOriginal);
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

        long[] ids = getIntent().getLongArrayExtra("questao_ids");
        String[] respostasUsuario = getIntent().getStringArrayExtra("respostas_usuario");

        if (ids != null && ids.length > 0) {
            DatabaseHelper db = new DatabaseHelper(this);
            List<Questao> carregadas = db.getQuestoesPorIds(ids);
            Map<Long, Questao> porId = new HashMap<>();
            for (Questao q : carregadas) porId.put(q.getId(), q);
            questoes = new ArrayList<>(ids.length);
            for (int i = 0; i < ids.length; i++) {
                Questao q = porId.get(ids[i]);
                if (q != null) {
                    // Aplicar resposta do usuário preservada
                    if (respostasUsuario != null && i < respostasUsuario.length) {
                        String r = respostasUsuario[i];
                        if (r != null && !r.isEmpty()) q.setRespostaUsuario(r);
                    }
                    questoes.add(q);
                }
            }
        } else {
            // Compatibilidade com caminhos antigos
            questoes = (ArrayList<Questao>) getIntent().getSerializableExtra("questoes");
        }

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
                " - " + questao.getArea());
        tvQuestaoOriginal.setText("Questão " + questao.getNumero() + " - Caderno azul - ENEM " + questao.getAno());

        layoutTextosApoio.removeAllViews();
        layoutImagens.removeAllViews();

        if (questao.temElementosOrdenados()) {
            boolean exibiuReferencia = false;
            boolean exibiuImagem = false;
            Questao.ElementoQuestao.TipoElemento ultimoTipo = null;
            for (Questao.ElementoQuestao elemento : questao.getElementosOrdenados()) {
                switch (elemento.getTipo()) {
                    case TEXTO_APOIO:
                        adicionarTextoApoio(elemento.getConteudo());
                        ultimoTipo = Questao.ElementoQuestao.TipoElemento.TEXTO_APOIO;
                        break;
                    case IMAGEM:
                        adicionarImagem(elemento.getConteudo());
                        exibiuImagem = true;
                        ultimoTipo = Questao.ElementoQuestao.TipoElemento.IMAGEM;
                        break;
                    case REFERENCIA:
                        if (ultimoTipo == Questao.ElementoQuestao.TipoElemento.IMAGEM) {
                            adicionarReferenciaEmImagens(elemento.getConteudo());
                        } else {
                            adicionarReferencia(elemento.getConteudo());
                        }
                        exibiuReferencia = true;
                        ultimoTipo = Questao.ElementoQuestao.TipoElemento.REFERENCIA;
                        break;
                    case ENUNCIADO:
                        tvEnunciado.setText(elemento.getConteudo());
                        ultimoTipo = Questao.ElementoQuestao.TipoElemento.ENUNCIADO;
                        break;
                }
            }
            if (!exibiuReferencia && questao.getFonte() != null && !questao.getFonte().isEmpty()) {
                if (exibiuImagem) adicionarReferenciaEmImagens(questao.getFonte());
                else adicionarReferencia(questao.getFonte());
            }
        } else {
            boolean exibiuReferencia = false;
            if (questao.temTextosApoio()) {
                layoutTextosApoio.setVisibility(View.VISIBLE);
                String[] textosApoio = questao.getTextosApoio();
                for (String texto : textosApoio) {
                    if (texto.startsWith("Fonte:") || texto.contains("Disponível em:") || texto.contains("Acesso em:")) {
                        adicionarReferencia(texto);
                        exibiuReferencia = true;
                    } else {
                        adicionarTextoApoio(texto);
                    }
                }
            } else {
                layoutTextosApoio.setVisibility(View.GONE);
            }

            boolean exibiuImagem = false;
            if (questao.temImagens()) {
                String[] imagens = questao.getImagens();
                for (String nomeImagem : imagens) {
                    adicionarImagem(nomeImagem);
                    exibiuImagem = true;
                }
            } else {
                layoutImagens.setVisibility(View.GONE);
            }

            if (!exibiuReferencia && questao.getFonte() != null && !questao.getFonte().isEmpty()) {
                if (exibiuImagem) adicionarReferenciaEmImagens(questao.getFonte());
                else adicionarReferencia(questao.getFonte());
            }
        }

        tvAlternativaA.setText(formatAlternativa("A", questao.getAlternativaA()));
        tvAlternativaB.setText(formatAlternativa("B", questao.getAlternativaB()));
        tvAlternativaC.setText(formatAlternativa("C", questao.getAlternativaC()));
        tvAlternativaD.setText(formatAlternativa("D", questao.getAlternativaD()));
        tvAlternativaE.setText(formatAlternativa("E", questao.getAlternativaE()));

        // Exibir imagens das alternativas logo abaixo do texto, se houver
        exibirImagemAlternativaAbaixo(tvAlternativaA, questao.getAlternativaAImagem());
        exibirImagemAlternativaAbaixo(tvAlternativaB, questao.getAlternativaBImagem());
        exibirImagemAlternativaAbaixo(tvAlternativaC, questao.getAlternativaCImagem());
        exibirImagemAlternativaAbaixo(tvAlternativaD, questao.getAlternativaDImagem());
        exibirImagemAlternativaAbaixo(tvAlternativaE, questao.getAlternativaEImagem());

        resetarAlternativa(tvAlternativaA);
        resetarAlternativa(tvAlternativaB);
        resetarAlternativa(tvAlternativaC);
        resetarAlternativa(tvAlternativaD);
        resetarAlternativa(tvAlternativaE);

        String respostaCorreta = questao.getRespostaCorreta().toUpperCase();
        String respostaUsuario = questao.getRespostaUsuario() != null ? questao.getRespostaUsuario().toUpperCase() : "";

        marcarAlternativaCorreta(getTextViewPorLetra(respostaCorreta), respostaCorreta);

        if (!respostaUsuario.isEmpty() && !respostaUsuario.equals(respostaCorreta)) {
            marcarAlternativaErrada(getTextViewPorLetra(respostaUsuario), respostaUsuario);
        }

        btnAnterior.setEnabled(questaoAtualIndex > 0);
        btnProxima.setEnabled(questaoAtualIndex < questoes.size() - 1);
    }

    private void exibirImagemAlternativaAbaixo(TextView tv, String nomeImagemBase) {
        // Remove qualquer ImageView previamente adicionada como próximo irmão se não for para exibir
        LinearLayout parent = (LinearLayout) tv.getParent();
        int index = parent.indexOfChild(tv);
        // Se houver uma view logo após e for uma ImageView marcada por tag, removê-la
        if (index >= 0 && index < parent.getChildCount() - 1) {
            View next = parent.getChildAt(index + 1);
            if (next instanceof ImageView && "altImage".equals(next.getTag())) {
                parent.removeViewAt(index + 1);
            }
        }
        if (TextUtils.isEmpty(nomeImagemBase)) return;

        // Tentar imagem interna
        File imgFile = encontrarImagemInterna(nomeImagemBase);
        if (imgFile != null && imgFile.exists()) {
            android.graphics.Bitmap bitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            if (bitmap != null) {
                ImageView imageView = criarImageViewAlternativa();
                imageView.setImageBitmap(bitmap);
                parent.addView(imageView, index + 1);
                return;
            }
        }
        // Fallback: drawable
        int resIdDrawable = getResources().getIdentifier(nomeImagemBase, "drawable", getPackageName());
        if (resIdDrawable != 0) {
            ImageView imageView = criarImageViewAlternativa();
            imageView.setImageResource(resIdDrawable);
            parent.addView(imageView, index + 1);
            return;
        }
        // Fallback: mipmap
        int resIdMipmap = getResources().getIdentifier(nomeImagemBase, "mipmap", getPackageName());
        if (resIdMipmap != 0) {
            ImageView imageView = criarImageViewAlternativa();
            imageView.setImageResource(resIdMipmap);
            parent.addView(imageView, index + 1);
        }
    }

    private ImageView criarImageViewAlternativa() {
        ImageView iv = new ImageView(this);
        iv.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        iv.setAdjustViewBounds(true);
        iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        iv.setMaxHeight(getResources().getDimensionPixelSize(R.dimen.alt_image_max_height));
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) iv.getLayoutParams();
        params.bottomMargin = getResources().getDimensionPixelSize(R.dimen.block_bottom_margin);
        iv.setLayoutParams(params);
        iv.setTag("altImage");
        return iv;
    }

    private void adicionarTextoApoio(String texto) {
        layoutTextosApoio.setVisibility(View.VISIBLE);
        TextView tvTexto = new TextView(this);
        tvTexto.setText(texto);
        tvTexto.setTextSize(14);
        tvTexto.setTextColor(ContextCompat.getColor(this, R.color.colorTextoApoio));
        tvTexto.setBackground(ContextCompat.getDrawable(this, R.drawable.border_text));
        int pad = getResources().getDimensionPixelSize(R.dimen.text_block_padding);
        tvTexto.setPadding(pad, pad, pad, pad);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.bottomMargin = getResources().getDimensionPixelSize(R.dimen.block_bottom_margin);
        tvTexto.setLayoutParams(params);
        layoutTextosApoio.addView(tvTexto);
    }

    private void adicionarImagem(String nomeImagemBase) {
        layoutImagens.setVisibility(View.VISIBLE);
        // Preferir imagem salva internamente
        File imgFile = encontrarImagemInterna(nomeImagemBase);
        if (imgFile != null && imgFile.exists()) {
            android.graphics.Bitmap bitmap = android.graphics.BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            if (bitmap != null) {
                PhotoView photoView = criarPhotoViewBase();
                photoView.setImageBitmap(bitmap);
                configurarZoomSeGrande(photoView, bitmap.getWidth(), bitmap.getHeight());
                layoutImagens.addView(photoView);
                return;
            }
        }
        int resourceIdDrawable = getResources().getIdentifier(nomeImagemBase, "drawable", getPackageName());
        if (resourceIdDrawable != 0) {
            Drawable d = ContextCompat.getDrawable(this, resourceIdDrawable);
            PhotoView photoView = criarPhotoViewBase();
            photoView.setImageDrawable(d);
            if (d != null) configurarZoomSeGrande(photoView, Math.max(1, d.getIntrinsicWidth()), Math.max(1, d.getIntrinsicHeight()));
            layoutImagens.addView(photoView);
            return;
        }
        int resourceIdMipmap = getResources().getIdentifier(nomeImagemBase, "mipmap", getPackageName());
        if (resourceIdMipmap != 0) {
            Drawable d = ContextCompat.getDrawable(this, resourceIdMipmap);
            PhotoView photoView = criarPhotoViewBase();
            photoView.setImageDrawable(d);
            if (d != null) configurarZoomSeGrande(photoView, Math.max(1, d.getIntrinsicWidth()), Math.max(1, d.getIntrinsicHeight()));
            layoutImagens.addView(photoView);
        }
    }

    private PhotoView criarPhotoViewBase() {
        PhotoView photoView = new PhotoView(this);
        photoView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        photoView.setAdjustViewBounds(true);
        photoView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        photoView.setZoomable(false); // habilita somente quando necessário
        photoView.setMaxHeight(getMaxContextImageHeightPx());
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) photoView.getLayoutParams();
        params.bottomMargin = getResources().getDimensionPixelSize(R.dimen.block_bottom_margin);
        photoView.setLayoutParams(params);
        return photoView;
    }

    private int getMaxContextImageHeightPx() {
        float fraction = getResources().getFraction(R.fraction.context_image_max_height_fraction, 1, 1);
        int screenH = getResources().getDisplayMetrics().heightPixels;
        return Math.round(screenH * fraction);
    }

    private int getScreenContentWidthPx() {
        int screenW = getResources().getDisplayMetrics().widthPixels;
        int hMargin = getResources().getDimensionPixelSize(R.dimen.content_horizontal_margin);
        return Math.max(1, screenW - 2 * hMargin);
    }

    private void configurarZoomSeGrande(PhotoView photoView, int imgW, int imgH) {
        boolean grandePorAltura = imgH > getMaxContextImageHeightPx();
        boolean grandePorLargura = imgW > getScreenContentWidthPx();
        photoView.setZoomable(grandePorAltura || grandePorLargura);
    }

    private File encontrarImagemInterna(String nomeBase) {
        try {
            File dir = new File(getFilesDir(), "images");
            if (!dir.exists()) return null;
            File[] files = dir.listFiles();
            if (files == null || files.length == 0) return null;
            for (File f : files) {
                String nome = f.getName();
                int idx = nome.lastIndexOf('.');
                String semExt = (idx > 0) ? nome.substring(0, idx) : nome;
                if (semExt.equalsIgnoreCase(nomeBase)) {
                    return f;
                }
            }
        } catch (Exception ignore) {
        }
        return null;
    }

    private void adicionarReferenciaEmImagens(String referencia) {
        layoutImagens.setVisibility(View.VISIBLE);
        TextView tvReferencia = new TextView(this);
        tvReferencia.setText(referencia);
        tvReferencia.setTextColor(ContextCompat.getColor(this, R.color.colorTextoFonte));
        tvReferencia.setTypeface(null, android.graphics.Typeface.ITALIC);
        tvReferencia.setTextSize(11);
        tvReferencia.setGravity(android.view.Gravity.END);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.topMargin = getResources().getDimensionPixelSize(R.dimen.small_top_margin);
        layoutImagens.addView(tvReferencia, params);
    }

    private void adicionarReferencia(String referencia) {
        layoutTextosApoio.setVisibility(View.VISIBLE);
        TextView tvReferencia = new TextView(this);
        tvReferencia.setText(referencia);
        tvReferencia.setTextColor(ContextCompat.getColor(this, R.color.colorTextoFonte));
        tvReferencia.setTypeface(null, android.graphics.Typeface.ITALIC);
        tvReferencia.setTextSize(11);
        tvReferencia.setGravity(android.view.Gravity.END);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.bottomMargin = getResources().getDimensionPixelSize(R.dimen.block_bottom_margin);
        tvReferencia.setLayoutParams(params);

        layoutTextosApoio.addView(tvReferencia);
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

    // Reintroduzido: formata o texto da alternativa exibindo apenas a letra quando o texto é vazio
    private String formatAlternativa(String letra, String texto) {
        return TextUtils.isEmpty(texto) ? (letra + ")") : (letra + ") " + texto);
    }

    private void resetarAlternativa(TextView tv) {
        tv.setBackground(ContextCompat.getDrawable(this, R.drawable.border_text));
        tv.setPaintFlags(tv.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
        tv.setTextColor(Color.BLACK);
    }

    private void marcarAlternativaCorreta(TextView tv, String letra) {
        if (tv != null) {
            tv.setBackground(ContextCompat.getDrawable(this, R.drawable.border_correct));
            tv.setTextColor(Color.parseColor("#2E7D32"));
            String textoOriginal = tv.getText().toString();
            tv.setText("✓ " + textoOriginal);
        }
    }

    private void marcarAlternativaErrada(TextView tv, String letra) {
        if (tv != null) {
            tv.setBackground(ContextCompat.getDrawable(this, R.drawable.border_wrong));
            tv.setTextColor(Color.parseColor("#C62828"));
            tv.setPaintFlags(tv.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }
}
