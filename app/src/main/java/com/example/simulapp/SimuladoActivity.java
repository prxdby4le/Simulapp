package com.example.simulapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
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
import androidx.core.content.ContextCompat;

import com.example.simulapp.database.DatabaseHelper;
import com.example.simulapp.model.Questao;
import com.github.chrisbanes.photoview.PhotoView;
import com.google.android.material.appbar.MaterialToolbar;
import com.example.simulapp.R;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimuladoActivity extends AppCompatActivity {

    private List<Questao> questoes;
    private int questaoAtualIndex = 0;

    private TextView tvNumeroQuestao;
    private TextView tvQuestaoOriginal;
    private TextView tvEnunciado;
    private LinearLayout layoutTextosApoio;
    private LinearLayout layoutImagens;
    private RadioGroup rgAlternativas;
    private RadioButton rbAlternativaA;
    private RadioButton rbAlternativaB;
    private RadioButton rbAlternativaC;
    private RadioButton rbAlternativaD;
    private RadioButton rbAlternativaE;
    private Button btnProxima;
    private Button btnFinalizar;

    // Índice em memória: nomeBase -> arquivo dentro de assets/images
    private static Map<String, String> assetsImageIndex;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            setContentView(R.layout.activity_simulado);

            android.util.Log.d("SimuladoActivity", "onCreate iniciado");

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
            rgAlternativas = findViewById(R.id.rgAlternativas);
            rbAlternativaA = findViewById(R.id.rbAlternativaA);
            rbAlternativaB = findViewById(R.id.rbAlternativaB);
            rbAlternativaC = findViewById(R.id.rbAlternativaC);
            rbAlternativaD = findViewById(R.id.rbAlternativaD);
            rbAlternativaE = findViewById(R.id.rbAlternativaE);
            btnProxima = findViewById(R.id.btnProxima);
            btnFinalizar = findViewById(R.id.btnFinalizar);

            // Preferir IDs para evitar TransactionTooLargeException
            long[] ids = getIntent().getLongArrayExtra("questao_ids");
            android.util.Log.d("SimuladoActivity", "IDs recebidos: " + (ids != null ? ids.length : "null"));

            if (ids != null && ids.length > 0) {
                DatabaseHelper db = new DatabaseHelper(this);
                List<Questao> carregadas = db.getQuestoesPorIds(ids);
                android.util.Log.d("SimuladoActivity", "Questões carregadas do banco: " + carregadas.size());

                // Reordenar conforme a ordem dos IDs recebidos
                Map<Long, Questao> porId = new HashMap<>();
                for (Questao q : carregadas) porId.put(q.getId(), q);
                questoes = new ArrayList<>(ids.length);
                for (long id : ids) {
                    Questao q = porId.get(id);
                    if (q != null) questoes.add(q);
                }
            } else {
                // Compatibilidade: receber lista serializada quando pequena
                @SuppressWarnings("unchecked")
                List<Questao> temp = (List<Questao>) getIntent().getSerializableExtra("questoes");
                questoes = temp;
                android.util.Log.d("SimuladoActivity", "Questões recebidas via serialização: " +
                        (questoes != null ? questoes.size() : "null"));
            }

            if (questoes == null || questoes.isEmpty()) {
                android.util.Log.w("SimuladoActivity", "Nenhuma questão disponível!");
                Toast.makeText(this, "Nenhuma questão disponível", Toast.LENGTH_SHORT).show();
                finish();
                return;
            }

            android.util.Log.d("SimuladoActivity", "Exibindo primeira questão");
            exibirQuestao();

            rgAlternativas.setOnCheckedChangeListener((group, checkedId) -> salvarResposta());
            btnProxima.setOnClickListener(v -> {
                if (questaoAtualIndex < questoes.size() - 1) {
                    questaoAtualIndex++;
                    exibirQuestao();
                }
            });
            btnFinalizar.setOnClickListener(v -> finalizarSimulado());

            android.util.Log.d("SimuladoActivity", "onCreate concluído com sucesso");

        } catch (Exception e) {
            android.util.Log.e("SimuladoActivity", "ERRO CRÍTICO no onCreate", e);
            Toast.makeText(this, "Erro ao iniciar simulado: " + e.getMessage(), Toast.LENGTH_LONG).show();
            finish();
        }
    }

    private void exibirQuestao() {
        try {
            Questao questao = questoes.get(questaoAtualIndex);

            android.util.Log.d("SimuladoActivity", "Exibindo questão " + (questaoAtualIndex + 1) +
                    " - ID: " + questao.getId() + ", Número: " + questao.getNumero());

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
            // Fallback: se não houve referência explícita, mas há fonte definida, exibi-la
            if (!exibiuReferencia && !android.text.TextUtils.isEmpty(questao.getFonte())) {
                if (exibiuImagem) adicionarReferenciaEmImagens(questao.getFonte());
                else adicionarReferencia(questao.getFonte());
            }
        } else {
            tvEnunciado.setText(questao.getEnunciado());

            // Exibir múltiplos textos de apoio (método antigo)
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
            }

            boolean exibiuImagem = false;
            if (questao.temImagens()) {
                layoutImagens.setVisibility(View.VISIBLE);
                String[] imagens = questao.getImagens();
                for (String nomeImagem : imagens) {
                    adicionarImagem(nomeImagem);
                    exibiuImagem = true;
                }
            }

            // Se não houve referência e existe uma fonte geral, posicionar conforme contexto
            if (!exibiuReferencia && !TextUtils.isEmpty(questao.getFonte())) {
                if (exibiuImagem) adicionarReferenciaEmImagens(questao.getFonte());
                else adicionarReferencia(questao.getFonte());
            }
        }

        // Substituir para evitar "null" quando a alternativa só tem imagem
        rbAlternativaA.setText(formatAlternativa("A", questao.getAlternativaA()));
        rbAlternativaB.setText(formatAlternativa("B", questao.getAlternativaB()));
        rbAlternativaC.setText(formatAlternativa("C", questao.getAlternativaC()));
        rbAlternativaD.setText(formatAlternativa("D", questao.getAlternativaD()));
        rbAlternativaE.setText(formatAlternativa("E", questao.getAlternativaE()));

        // Configurar imagens das alternativas (se houver)
        configurarImagemAlternativa(rbAlternativaA, questao.getAlternativaAImagem());
        configurarImagemAlternativa(rbAlternativaB, questao.getAlternativaBImagem());
        configurarImagemAlternativa(rbAlternativaC, questao.getAlternativaCImagem());
        configurarImagemAlternativa(rbAlternativaD, questao.getAlternativaDImagem());
        configurarImagemAlternativa(rbAlternativaE, questao.getAlternativaEImagem());

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

        android.util.Log.d("SimuladoActivity", "Questão exibida com sucesso");

        } catch (Exception e) {
            android.util.Log.e("SimuladoActivity", "ERRO ao exibir questão", e);
            Toast.makeText(this, "Erro ao exibir questão: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void configurarImagemAlternativa(RadioButton radioButton, String nomeImagemBase) {
        // Limpar padrão
        radioButton.setCompoundDrawables(null, null, null, null);
        if (TextUtils.isEmpty(nomeImagemBase)) return;
        Drawable drawable = carregarDrawablePorNome(nomeImagemBase);
        if (drawable != null) {
            int maxWidth = getMaxAltDrawableWidthPx();
            int maxHeight = getResources().getDimensionPixelSize(R.dimen.alt_image_max_height);
            int iw = Math.max(1, drawable.getIntrinsicWidth());
            int ih = Math.max(1, drawable.getIntrinsicHeight());
            float scale = Math.min(1f, Math.min((float) maxWidth / iw, (float) maxHeight / ih));
            int w = Math.max(1, Math.round(iw * scale));
            int h = Math.max(1, Math.round(ih * scale));
            drawable.setBounds(0, 0, w, h);
            radioButton.setCompoundDrawables(null, drawable, null, null);
            radioButton.setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.alt_image_drawable_padding));
        }
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

    private void adicionarImagem(String nomeImagemBase) {
        if (nomeImagemBase == null || nomeImagemBase.trim().isEmpty()) {
            return;
        }

        layoutImagens.setVisibility(View.VISIBLE);

        // 1) Tenta carregar a partir do armazenamento interno (filesDir/images)
        File imgFile = encontrarImagemInterna(nomeImagemBase);
        if (imgFile != null && imgFile.exists()) {
            Bitmap bitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            if (bitmap != null) {
                PhotoView photoView = criarPhotoViewBase();
                photoView.setImageBitmap(bitmap);
                configurarZoomSeGrande(photoView, bitmap.getWidth(), bitmap.getHeight());
                layoutImagens.addView(photoView);
                return;
            }
        }

        // 2) Fallback: tenta como recurso drawable
        int resIdDrawable = getResources().getIdentifier(nomeImagemBase, "drawable", getPackageName());
        if (resIdDrawable != 0) {
            Drawable d = ContextCompat.getDrawable(this, resIdDrawable);
            PhotoView photoView = criarPhotoViewBase();
            photoView.setImageDrawable(d);
            if (d != null) configurarZoomSeGrande(photoView, Math.max(1, d.getIntrinsicWidth()), Math.max(1, d.getIntrinsicHeight()));
            layoutImagens.addView(photoView);
            return;
        }

        // 3) Fallback: tenta como recurso mipmap (compatibilidade antiga)
        int resIdMipmap = getResources().getIdentifier(nomeImagemBase, "mipmap", getPackageName());
        if (resIdMipmap != 0) {
            Drawable d = ContextCompat.getDrawable(this, resIdMipmap);
            PhotoView photoView = criarPhotoViewBase();
            photoView.setImageDrawable(d);
            if (d != null) configurarZoomSeGrande(photoView, Math.max(1, d.getIntrinsicWidth()), Math.max(1, d.getIntrinsicHeight()));
            layoutImagens.addView(photoView);
            return;
        }

        // 4) Fallback final: assets/images
        String assetFile = encontrarImagemAssets(nomeImagemBase);
        if (assetFile != null) {
            try (InputStream is = getAssets().open("images/" + assetFile)) {
                Bitmap bitmap = BitmapFactory.decodeStream(is);
                if (bitmap != null) {
                    PhotoView photoView = criarPhotoViewBase();
                    photoView.setImageBitmap(bitmap);
                    configurarZoomSeGrande(photoView, bitmap.getWidth(), bitmap.getHeight());
                    layoutImagens.addView(photoView);
                    return;
                }
            } catch (IOException e) {
                android.util.Log.w("SimuladoActivity", "Falha ao carregar imagem de assets: " + nomeImagemBase, e);
            }
        }

        // Se nenhum fallback funcionou, log de aviso
        android.util.Log.w("SimuladoActivity", "Imagem não encontrada em nenhuma fonte: " + nomeImagemBase);
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

    private int getMaxAltDrawableWidthPx() {
        int screenW = getResources().getDisplayMetrics().widthPixels;
        int hMargin = getResources().getDimensionPixelSize(R.dimen.content_horizontal_margin);
        return Math.max(1, screenW - 2 * hMargin);
    }

    private int dpToPx(int dp) {
        float density = getResources().getDisplayMetrics().density;
        return Math.round(dp * density);
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
        try {
            // CORREÇÃO: Salvar a resposta da questão atual antes de finalizar
            salvarResposta();

            android.util.Log.d("SimuladoActivity", "Finalizando simulado com " + questoes.size() + " questões");

            int acertos = 0;
            long[] ids = new long[questoes.size()];
            String[] respostasUsuario = new String[questoes.size()];

            for (int i = 0; i < questoes.size(); i++) {
                Questao q = questoes.get(i);
                ids[i] = q.getId();
                String r = q.getRespostaUsuario();
                respostasUsuario[i] = r == null ? "" : r;
                if (q.isCorreta()) {
                    acertos++;
                }
            }

            android.util.Log.d("SimuladoActivity", "Acertos: " + acertos + " de " + questoes.size());

            Intent intent = new Intent(this, ResultadoSimuladoActivity.class);
            intent.putExtra("questao_ids", ids);
            intent.putExtra("respostas_usuario", respostasUsuario);
            intent.putExtra("acertos", acertos);
            intent.putExtra("total", questoes.size());

            android.util.Log.d("SimuladoActivity", "Iniciando ResultadoSimuladoActivity");
            startActivity(intent);
            finish();

        } catch (Exception e) {
            android.util.Log.e("SimuladoActivity", "ERRO ao finalizar simulado", e);
            Toast.makeText(this, "Erro ao finalizar simulado: " + e.getMessage(), Toast.LENGTH_LONG).show();
            // Não fazer finish() para não fechar a activity em caso de erro
        }
    }

    private String formatAlternativa(String letra, String texto) {
        return TextUtils.isEmpty(texto) ? (letra + ")") : (letra + ") " + texto);
    }

    private Drawable carregarDrawablePorNome(String nomeImagemBase) {
        // Tenta a partir do armazenamento interno (filesDir/images)
        File imgFile = encontrarImagemInterna(nomeImagemBase);
        if (imgFile != null && imgFile.exists()) {
            Bitmap bitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            if (bitmap != null) {
                return new BitmapDrawable(getResources(), bitmap);
            }
        }
        // Fallback: tenta como drawable
        int resIdDrawable = getResources().getIdentifier(nomeImagemBase, "drawable", getPackageName());
        if (resIdDrawable != 0) {
            return ContextCompat.getDrawable(this, resIdDrawable);
        }
        // Fallback: tenta como mipmap
        int resIdMipmap = getResources().getIdentifier(nomeImagemBase, "mipmap", getPackageName());
        if (resIdMipmap != 0) {
            return ContextCompat.getDrawable(this, resIdMipmap);
        }
        // Fallback final: assets/images
        String assetFile = encontrarImagemAssets(nomeImagemBase);
        if (assetFile != null) {
            try (InputStream is = getAssets().open("images/" + assetFile)) {
                Bitmap bitmap = BitmapFactory.decodeStream(is);
                if (bitmap != null) {
                    return new BitmapDrawable(getResources(), bitmap);
                }
            } catch (IOException ignore) {
            }
        }
        return null;
    }

    private synchronized void ensureAssetsImageIndex() {
        if (assetsImageIndex != null) return;
        assetsImageIndex = new HashMap<>();
        try {
            String[] files = getAssets().list("images");
            if (files != null) {
                for (String f : files) {
                    String base = f;
                    int idx = base.lastIndexOf('.');
                    if (idx > 0) base = base.substring(0, idx);
                    assetsImageIndex.put(base.toLowerCase(), f);
                }
            }
        } catch (IOException ignore) {
        }
    }

    private String encontrarImagemAssets(String nomeBase) {
        if (TextUtils.isEmpty(nomeBase)) return null;
        ensureAssetsImageIndex();
        if (assetsImageIndex == null || assetsImageIndex.isEmpty()) return null;
        String f = assetsImageIndex.get(nomeBase.toLowerCase());
        if (f != null) return f;
        // Tentativa relaxada: remover espaços/underscores
        String key2 = nomeBase.replace(" ", "_").toLowerCase();
        return assetsImageIndex.getOrDefault(key2, null);
    }
}
