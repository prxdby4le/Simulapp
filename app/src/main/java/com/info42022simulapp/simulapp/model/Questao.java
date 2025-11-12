package com.info42022simulapp.simulapp.model;

import android.text.TextUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Questao implements Serializable {
    private long id;
    private String area;
    private int ano;
    private int numero;
    private String enunciado;
    private String imagem;
    private String textoApoio;
    private String fonte;
    private String idiomaEstrangeiro; // "ingles", "espanhol", ou null para questões que não são de língua estrangeira
    // Novos campos para múltiplos textos de apoio
    private String textoApoio1;
    private String textoApoio2;
    private String textoApoio3;
    private String textoApoio4;
    private String referenciaTexto1;
    private String referenciaTexto2;
    private String referenciaTexto3;
    private String referenciaTexto4;
    private String alternativaA;
    private String alternativaB;
    private String alternativaC;
    private String alternativaD;
    private String alternativaE;
    private String respostaCorreta;
    private String respostaUsuario;

    // Imagens por alternativa (nome base salvo/local)
    private String alternativaAImagem;
    private String alternativaBImagem;
    private String alternativaCImagem;
    private String alternativaDImagem;
    private String alternativaEImagem;

    // Nova estrutura para armazenar elementos na ordem de adição
    private List<ElementoQuestao> elementosOrdenados = new ArrayList<>();

    public static class ElementoQuestao implements Serializable {
        public enum TipoElemento {
            TEXTO_APOIO, IMAGEM, REFERENCIA, ENUNCIADO
        }

        private TipoElemento tipo;
        private String conteudo;

        public ElementoQuestao(TipoElemento tipo, String conteudo) {
            this.tipo = tipo;
            this.conteudo = conteudo;
        }

        public TipoElemento getTipo() {
            return tipo;
        }

        public String getConteudo() {
            return conteudo;
        }
    }

    public Questao() {
    }

    // Métodos para adicionar elementos na ordem
    public void addTextoApoio(String texto) {
        if (!TextUtils.isEmpty(texto)) {
            elementosOrdenados.add(new ElementoQuestao(ElementoQuestao.TipoElemento.TEXTO_APOIO, texto));
        }
    }

    // Atualizado: aceitar múltiplas imagens e persistir no campo 'imagem'
    public void addImagem(String... nomesImagens) {
        if (nomesImagens == null || nomesImagens.length == 0) return;

        // Adiciona aos elementos ordenados e acumula lista válida
        List<String> novas = new ArrayList<>();
        for (String nome : nomesImagens) {
            if (!TextUtils.isEmpty(nome)) {
                elementosOrdenados.add(new ElementoQuestao(ElementoQuestao.TipoElemento.IMAGEM, nome));
                novas.add(nome);
            }
        }
        if (novas.isEmpty()) return;

        // Mescla com imagens já definidas no campo persistido
        String[] ja = getImagens();
        List<String> todas = new ArrayList<>();
        if (ja != null && ja.length > 0) {
            for (String s : ja) {
                if (!TextUtils.isEmpty(s)) todas.add(s);
            }
        }
        todas.addAll(novas);
        // Atualiza o campo string pipe-separated
        if (todas.isEmpty()) {
            this.imagem = null;
        } else {
            this.imagem = TextUtils.join("|", todas);
        }
    }

    public void addReferencia(String referencia) {
        if (!TextUtils.isEmpty(referencia)) {
            elementosOrdenados.add(new ElementoQuestao(ElementoQuestao.TipoElemento.REFERENCIA, referencia));
        }
    }

    public void addEnunciado(String enunciado) {
        if (!TextUtils.isEmpty(enunciado)) {
            this.enunciado = enunciado;
            elementosOrdenados.add(new ElementoQuestao(ElementoQuestao.TipoElemento.ENUNCIADO, enunciado));
        }
    }

    public List<ElementoQuestao> getElementosOrdenados() {
        return elementosOrdenados;
    }

    public boolean temElementosOrdenados() {
        return !elementosOrdenados.isEmpty();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public void setImagens(String... imagens) {
        if (imagens == null || imagens.length == 0) {
            this.imagem = null;
            return;
        }
        this.imagem = String.join("|", imagens);
    }

    public String[] getImagens() {
        if (imagem == null || imagem.isEmpty()) {
            return new String[0];
        }
        return imagem.split("\\|");
    }

    public boolean temImagens() {
        return imagem != null && !imagem.isEmpty();
    }

    public String getTextoApoio() {
        return textoApoio;
    }

    public void setTextoApoio(String textoApoio) {
        this.textoApoio = textoApoio;
    }

    public String getFonte() {
        return fonte;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    public String getIdiomaEstrangeiro() {
        return idiomaEstrangeiro;
    }

    public void setIdiomaEstrangeiro(String idiomaEstrangeiro) {
        this.idiomaEstrangeiro = idiomaEstrangeiro;
    }

    // Getters e Setters para os novos campos de texto de apoio
    public String getTextoApoio1() { return textoApoio1; }
    public void setTextoApoio1(String textoApoio1) { this.textoApoio1 = textoApoio1; }
    public String getTextoApoio2() { return textoApoio2; }
    public void setTextoApoio2(String textoApoio2) { this.textoApoio2 = textoApoio2; }
    public String getTextoApoio3() { return textoApoio3; }
    public void setTextoApoio3(String textoApoio3) { this.textoApoio3 = textoApoio3; }
    public String getTextoApoio4() { return textoApoio4; }
    public void setTextoApoio4(String textoApoio4) { this.textoApoio4 = textoApoio4; }
    public String getReferenciaTexto1() { return referenciaTexto1; }
    public void setReferenciaTexto1(String referenciaTexto1) { this.referenciaTexto1 = referenciaTexto1; }
    public String getReferenciaTexto2() { return referenciaTexto2; }
    public void setReferenciaTexto2(String referenciaTexto2) { this.referenciaTexto2 = referenciaTexto2; }
    public String getReferenciaTexto3() { return referenciaTexto3; }
    public void setReferenciaTexto3(String referenciaTexto3) { this.referenciaTexto3 = referenciaTexto3; }
    public String getReferenciaTexto4() { return referenciaTexto4; }
    public void setReferenciaTexto4(String referenciaTexto4) { this.referenciaTexto4 = referenciaTexto4; }

    public String getAlternativaA() { return alternativaA; }
    public void setAlternativaA(String alternativaA) { this.alternativaA = alternativaA; }
    public String getAlternativaB() { return alternativaB; }
    public void setAlternativaB(String alternativaB) { this.alternativaB = alternativaB; }
    public String getAlternativaC() { return alternativaC; }
    public void setAlternativaC(String alternativaC) { this.alternativaC = alternativaC; }
    public String getAlternativaD() { return alternativaD; }
    public void setAlternativaD(String alternativaD) { this.alternativaD = alternativaD; }
    public String getAlternativaE() { return alternativaE; }
    public void setAlternativaE(String alternativaE) { this.alternativaE = alternativaE; }

    public String getAlternativaAImagem() { return alternativaAImagem; }
    public void setAlternativaAImagem(String alternativaAImagem) { this.alternativaAImagem = alternativaAImagem; }
    public String getAlternativaBImagem() { return alternativaBImagem; }
    public void setAlternativaBImagem(String alternativaBImagem) { this.alternativaBImagem = alternativaBImagem; }
    public String getAlternativaCImagem() { return alternativaCImagem; }
    public void setAlternativaCImagem(String alternativaCImagem) { this.alternativaCImagem = alternativaCImagem; }
    public String getAlternativaDImagem() { return alternativaDImagem; }
    public void setAlternativaDImagem(String alternativaDImagem) { this.alternativaDImagem = alternativaDImagem; }
    public String getAlternativaEImagem() { return alternativaEImagem; }
    public void setAlternativaEImagem(String alternativaEImagem) { this.alternativaEImagem = alternativaEImagem; }

    public String getRespostaCorreta() { return respostaCorreta; }
    public void setRespostaCorreta(String respostaCorreta) { this.respostaCorreta = respostaCorreta; }

    public String getRespostaUsuario() { return respostaUsuario; }
    public void setRespostaUsuario(String respostaUsuario) { this.respostaUsuario = respostaUsuario; }

    // Centralização: normalização e resolução para letra A–E
    public String getRespostaCorretaLetra() { return resolveLetra(respostaCorreta); }
    public String getRespostaUsuarioLetra() { return resolveLetra(respostaUsuario); }

    public boolean isRespondida() {
        return !TextUtils.isEmpty(getRespostaUsuarioLetra());
    }

    public boolean isCorreta() {
        String u = getRespostaUsuarioLetra();
        String c = getRespostaCorretaLetra();
        return !TextUtils.isEmpty(u) && u.equals(c);
    }

    // Tenta resolver o valor para uma letra A–E. Considera variações como "A)", "Gabarito: D", dígitos 1–5,
    // e também tenta casar com o texto das alternativas (ignorando prefixo tipo "A) ").
    public String resolveLetra(String valor) {
        String letra = normalizarLetra(valor);
        if (!TextUtils.isEmpty(letra)) return letra;
        if (TextUtils.isEmpty(valor)) return "";
        String alvo = valor.trim();
        if (alvo.isEmpty()) return "";
        String semPrefixo = stripLeadingLetterPattern(alvo);
        if (equalsAlt(semPrefixo, getAlternativaA()) || equalsAlt(alvo, getAlternativaA())) return "A";
        if (equalsAlt(semPrefixo, getAlternativaB()) || equalsAlt(alvo, getAlternativaB())) return "B";
        if (equalsAlt(semPrefixo, getAlternativaC()) || equalsAlt(alvo, getAlternativaC())) return "C";
        if (equalsAlt(semPrefixo, getAlternativaD()) || equalsAlt(alvo, getAlternativaD())) return "D";
        if (equalsAlt(semPrefixo, getAlternativaE()) || equalsAlt(alvo, getAlternativaE())) return "E";
        return "";
    }

    private static boolean equalsAlt(String a, String b) {
        if (a == null || b == null) return false;
        return a.trim().equalsIgnoreCase(b.trim());
    }

    private static String stripLeadingLetterPattern(String s) {
        if (TextUtils.isEmpty(s)) return "";
        String t = s.trim();
        if (t.length() >= 2 && t.charAt(1) == ')') {
            char c = Character.toUpperCase(t.charAt(0));
            if (c >= 'A' && c <= 'E') {
                // remover "A)" e possível espaço seguinte
                String rest = t.substring(2).trim();
                return rest;
            }
        }
        return t;
    }

    public static String normalizarLetra(String valor) {
        if (TextUtils.isEmpty(valor)) return "";
        String s = valor.trim().toUpperCase();
        s = s.replace("ALTERNATIVA", "").replace("LETRA", "").replace("CORRETA", "").replace("GABARITO", "");
        s = s.replace(":", " ").replace("-", " ").replace("(", " ").replace(")", " ").replace(".", " ").replace("|", " ");
        s = s.trim();
        if (s.length() == 1) {
            char c = s.charAt(0);
            if (c >= 'A' && c <= 'E') return String.valueOf(c);
            if (c >= '1' && c <= '5') return String.valueOf((char) ('A' + (c - '1')));
        }
        if (s.length() >= 2 && s.charAt(1) == ')' && s.charAt(0) >= 'A' && s.charAt(0) <= 'E') {
            return String.valueOf(s.charAt(0));
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'E') return String.valueOf(c);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '1' && c <= '5') return String.valueOf((char) ('A' + (c - '1')));
        }
        return "";
    }

    // Métodos auxiliares para múltiplos textos de apoio
    public boolean temTextosApoio() {
        return !TextUtils.isEmpty(textoApoio1) || !TextUtils.isEmpty(textoApoio2) ||
                !TextUtils.isEmpty(textoApoio3) || !TextUtils.isEmpty(textoApoio4) ||
                !TextUtils.isEmpty(textoApoio); // compatibilidade com campo antigo
    }

    public String[] getTextosApoio() {
        java.util.ArrayList<String> textos = new java.util.ArrayList<>();

        // Verificar campo antigo primeiro (para compatibilidade)
        if (!TextUtils.isEmpty(textoApoio)) {
            textos.add(textoApoio);
            if (!TextUtils.isEmpty(fonte)) {
                textos.add("Fonte: " + fonte);
            }
        }

        // Adicionar novos textos de apoio com suas referências
        if (!TextUtils.isEmpty(textoApoio1)) {
            textos.add(textoApoio1);
            if (!TextUtils.isEmpty(referenciaTexto1)) {
                textos.add(referenciaTexto1);
            }
        }

        if (!TextUtils.isEmpty(textoApoio2)) {
            textos.add(textoApoio2);
            if (!TextUtils.isEmpty(referenciaTexto2)) {
                textos.add(referenciaTexto2);
            }
        }

        if (!TextUtils.isEmpty(textoApoio3)) {
            textos.add(textoApoio3);
            if (!TextUtils.isEmpty(referenciaTexto3)) {
                textos.add(referenciaTexto3);
            }
        }

        if (!TextUtils.isEmpty(textoApoio4)) {
            textos.add(textoApoio4);
            if (!TextUtils.isEmpty(referenciaTexto4)) {
                textos.add(referenciaTexto4);
            }
        }

        return textos.toArray(new String[0]);
    }
}
