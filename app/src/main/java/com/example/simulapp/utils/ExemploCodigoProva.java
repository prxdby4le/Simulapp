package com.example.simulapp.utils;

import com.example.simulapp.model.CodigoProva;
import com.example.simulapp.model.CodigoProva.CompetenciaInfo;

import java.util.List;

/**
 * Exemplo de uso do CodigoProvaDecoder.
 * Demonstra como decodificar códigos de prova e obter os índices das questões.
 */
public class ExemploCodigoProva {

    public static void main(String[] args) {
        System.out.println("=== Exemplo de Uso do CodigoProvaDecoder ===\n");

        // Exemplo 1: Código simples com dia par (crescente)
        exemplo1();

        // Exemplo 2: Código com dia ímpar (decrescente)
        exemplo2();

        // Exemplo 3: Código com step maior
        exemplo3();

        // Exemplo 4: Código com competência vazia
        exemplo4();

        // Exemplo 5: Validação de formato
        exemplo5();
    }

    private static void exemplo1() {
        System.out.println("--- Exemplo 1: Código simples com dia par ---");
        String codigo = "05-05-05-05-00-1-0";
        String data = "2025-11-04"; // Dia 04 (par) → crescente

        System.out.println("Código: " + codigo);
        System.out.println("Data: " + data + " (dia par → crescente)");

        CodigoProva resultado = CodigoProvaDecoder.decodificar(codigo, data);

        System.out.println("Idioma: " + resultado.getIdioma());
        imprimirCompetencia("A", resultado.getCompetenciaA());
        imprimirCompetencia("B", resultado.getCompetenciaB());
        imprimirCompetencia("C", resultado.getCompetenciaC());
        imprimirCompetencia("D", resultado.getCompetenciaD());

        System.out.println("\nExplicação do código:");
        System.out.println(CodigoProvaDecoder.explicarCodigo(codigo));
        System.out.println("\n");
    }

    private static void exemplo2() {
        System.out.println("--- Exemplo 2: Mesmo código com dia ímpar ---");
        String codigo = "05-05-05-05-00-1-0";
        String data = "2025-11-05"; // Dia 05 (ímpar) → decrescente

        System.out.println("Código: " + codigo);
        System.out.println("Data: " + data + " (dia ímpar → decrescente)");

        CodigoProva resultado = CodigoProvaDecoder.decodificar(codigo, data);

        System.out.println("Idioma: " + resultado.getIdioma());
        imprimirCompetencia("A", resultado.getCompetenciaA());
        System.out.println("\n");
    }

    private static void exemplo3() {
        System.out.println("--- Exemplo 3: Código com step maior (coprimo) ---");
        String codigo = "05-05-05-05-00-2-0";
        String data = "2025-11-04";

        System.out.println("Código: " + codigo);
        System.out.println("Step = 2, Total = 5 (coprimos → percorre todos)");

        CodigoProva resultado = CodigoProvaDecoder.decodificar(codigo, data);
        imprimirCompetencia("A", resultado.getCompetenciaA());
        System.out.println("\n");
    }

    private static void exemplo4() {
        System.out.println("--- Exemplo 4: Código com competência vazia ---");
        String codigo = "14-00-0F-01-03-3-1";
        String data = "2025-11-04";

        System.out.println("Código: " + codigo);
        System.out.println("Competência B com 0 questões");

        CodigoProva resultado = CodigoProvaDecoder.decodificar(codigo, data);

        System.out.println("Idioma: " + resultado.getIdioma());
        imprimirCompetencia("A", resultado.getCompetenciaA());
        imprimirCompetencia("B", resultado.getCompetenciaB());
        imprimirCompetencia("C", resultado.getCompetenciaC());
        imprimirCompetencia("D", resultado.getCompetenciaD());
        System.out.println("\n");
    }

    private static void exemplo5() {
        System.out.println("--- Exemplo 5: Validação de formato ---");

        String[] codigos = {
            "0A-14-05-FF-02-A-1",  // Válido
            "INVALID",              // Inválido
            "0A-14-05-FF-02-A-2",  // G7 inválido
            "GG-14-05-FF-02-A-1"   // Não hex
        };

        for (String codigo : codigos) {
            boolean valido = CodigoProvaDecoder.validarFormato(codigo);
            System.out.println("Código '" + codigo + "': " + (valido ? "VÁLIDO ✓" : "INVÁLIDO ✗"));
        }

        System.out.println("\nTentando decodificar código inválido:");
        try {
            CodigoProvaDecoder.decodificar("INVALID", "2025-11-04");
        } catch (IllegalArgumentException e) {
            System.out.println("Exceção capturada: " + e.getMessage());
        }
        System.out.println("\n");
    }

    private static void imprimirCompetencia(String nome, CompetenciaInfo info) {
        System.out.printf("Competência %s: %d questões → Índices: %s%n",
            nome,
            info.getTotalQuestoes(),
            formatarIndices(info.getIndicesSelecionados())
        );
    }

    private static String formatarIndices(List<Integer> indices) {
        if (indices.isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        int maxDisplay = 10;

        for (int i = 0; i < Math.min(indices.size(), maxDisplay); i++) {
            if (i > 0) sb.append(", ");
            sb.append(indices.get(i));
        }

        if (indices.size() > maxDisplay) {
            sb.append(", ... (").append(indices.size() - maxDisplay).append(" mais)");
        }

        sb.append("]");
        return sb.toString();
    }
}

