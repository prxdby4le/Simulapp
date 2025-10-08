package com.example.simulapp.model;

import java.io.Serializable;

public class Questao implements Serializable {
    private long id;
    private String area;
    private int ano;
    private int numero;
    private String enunciado;
    private String imagem;
    private String textoApoio;
    private String fonte;
    private String alternativaA;
    private String alternativaB;
    private String alternativaC;
    private String alternativaD;
    private String alternativaE;
    private String respostaCorreta;
    private String respostaUsuario;

    public Questao() {
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

    public String getAlternativaA() {
        return alternativaA;
    }

    public void setAlternativaA(String alternativaA) {
        this.alternativaA = alternativaA;
    }

    public String getAlternativaB() {
        return alternativaB;
    }

    public void setAlternativaB(String alternativaB) {
        this.alternativaB = alternativaB;
    }

    public String getAlternativaC() {
        return alternativaC;
    }

    public void setAlternativaC(String alternativaC) {
        this.alternativaC = alternativaC;
    }

    public String getAlternativaD() {
        return alternativaD;
    }

    public void setAlternativaD(String alternativaD) {
        this.alternativaD = alternativaD;
    }

    public String getAlternativaE() {
        return alternativaE;
    }

    public void setAlternativaE(String alternativaE) {
        this.alternativaE = alternativaE;
    }

    public String getRespostaCorreta() {
        return respostaCorreta;
    }

    public void setRespostaCorreta(String respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }

    public String getRespostaUsuario() {
        return respostaUsuario;
    }

    public void setRespostaUsuario(String respostaUsuario) {
        this.respostaUsuario = respostaUsuario;
    }

    public boolean isRespondida() {
        return respostaUsuario != null && !respostaUsuario.isEmpty();
    }

    public boolean isCorreta() {
        return respostaUsuario != null && respostaUsuario.equalsIgnoreCase(respostaCorreta);
    }
}
