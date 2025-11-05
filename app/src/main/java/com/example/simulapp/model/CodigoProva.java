package com.example.simulapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa o resultado da decodificação de um código de prova.
 * Contém informações sobre questões selecionadas para cada competência e idioma.
 */
public class CodigoProva {
    private CompetenciaInfo competenciaA;
    private CompetenciaInfo competenciaB;
    private CompetenciaInfo competenciaC;
    private CompetenciaInfo competenciaD;
    private String idioma; // "inglês" ou "espanhol"

    // Novos campos: parâmetros globais do código
    private int startIndex; // G5 (0-255)
    private int step;       // G6 decimal (1-9, tratando 0 como 1)
    private boolean crescente; // Direção definida pelo dia (par=crescente)

    public CodigoProva() {
        this.competenciaA = new CompetenciaInfo();
        this.competenciaB = new CompetenciaInfo();
        this.competenciaC = new CompetenciaInfo();
        this.competenciaD = new CompetenciaInfo();
    }

    public CompetenciaInfo getCompetenciaA() {
        return competenciaA;
    }

    public void setCompetenciaA(CompetenciaInfo competenciaA) {
        this.competenciaA = competenciaA;
    }

    public CompetenciaInfo getCompetenciaB() {
        return competenciaB;
    }

    public void setCompetenciaB(CompetenciaInfo competenciaB) {
        this.competenciaB = competenciaB;
    }

    public CompetenciaInfo getCompetenciaC() {
        return competenciaC;
    }

    public void setCompetenciaC(CompetenciaInfo competenciaC) {
        this.competenciaC = competenciaC;
    }

    public CompetenciaInfo getCompetenciaD() {
        return competenciaD;
    }

    public void setCompetenciaD(CompetenciaInfo competenciaD) {
        this.competenciaD = competenciaD;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public boolean isCrescente() {
        return crescente;
    }

    public void setCrescente(boolean crescente) {
        this.crescente = crescente;
    }

    /**
     * Classe interna que representa informações sobre uma competência.
     */
    public static class CompetenciaInfo {
        private int totalQuestoes;
        private List<Integer> indicesSelecionados;

        public CompetenciaInfo() {
            this.totalQuestoes = 0;
            this.indicesSelecionados = new ArrayList<>();
        }

        public int getTotalQuestoes() {
            return totalQuestoes;
        }

        public void setTotalQuestoes(int totalQuestoes) {
            this.totalQuestoes = totalQuestoes;
        }

        public List<Integer> getIndicesSelecionados() {
            return indicesSelecionados;
        }

        public void setIndicesSelecionados(List<Integer> indicesSelecionados) {
            this.indicesSelecionados = indicesSelecionados;
        }
    }

    @Override
    public String toString() {
        return "CodigoProva{" +
                "competenciaA=" + formatCompetencia(competenciaA) +
                ", competenciaB=" + formatCompetencia(competenciaB) +
                ", competenciaC=" + formatCompetencia(competenciaC) +
                ", competenciaD=" + formatCompetencia(competenciaD) +
                ", idioma='" + idioma + '\'' +
                ", startIndex=" + startIndex +
                ", step=" + step +
                ", crescente=" + crescente +
                '}';
    }

    private String formatCompetencia(CompetenciaInfo info) {
        return "{total=" + info.getTotalQuestoes() +
               ", indices=" + info.getIndicesSelecionados() + "}";
    }
}
