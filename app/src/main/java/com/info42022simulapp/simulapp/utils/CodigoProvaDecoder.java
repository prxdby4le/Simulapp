package com.info42022simulapp.simulapp.utils;

import com.info42022simulapp.simulapp.model.CodigoProva;
import com.info42022simulapp.simulapp.model.CodigoProva.CompetenciaInfo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Decodificador de códigos de prova seguindo o formato:
 * G1-G2-G3-G4-G5-G6-G7
 *
 * Onde:
 * - G1..G4: 2 dígitos hex cada (00-FF) representando quantidade de questões por competência
 * - G5: 2 dígitos hex (00-FF) índice inicial global
 * - G6: 1 dígito hex (0-F) representando o step (passo)
 * - G7: 1 dígito binário (0 ou 1) representando idioma (0=inglês, 1=espanhol)
 *
 * Algoritmo:
 * 1. Para cada competência, calcula-se o start com módulo: start = G5 % total_questoes
 * 2. O step é convertido de hex para decimal (0=1, para evitar loops infinitos)
 * 3. A direção depende do último dígito do dia:
 *    - Par: crescente (índices aumentam com wrap-around)
 *    - Ímpar: decrescente (índices diminuem com wrap-around)
 * 4. Coleta-se exatamente total_questoes índices seguindo o passo
 */
public class CodigoProvaDecoder {

    private static final Pattern CODIGO_PATTERN =
        Pattern.compile("^[0-9A-Fa-f]{2}-[0-9A-Fa-f]{2}-[0-9A-Fa-f]{2}-[0-9A-Fa-f]{2}-[0-9A-Fa-f]{2}-[0-9A-Fa-f]-[01]$");

    /**
     * Decodifica um código de prova baseado em uma data específica.
     *
     * @param codigo Código no formato "HH-HH-HH-HH-HH-H-B"
     * @param dataInsercao Data no formato "YYYY-MM-DD"
     * @return CodigoProva com as informações decodificadas
     * @throws IllegalArgumentException se o código ou data forem inválidos
     */
    public static CodigoProva decodificar(String codigo, String dataInsercao) {
        // Validar formato do código
        if (codigo == null || !CODIGO_PATTERN.matcher(codigo).matches()) {
            throw new IllegalArgumentException(
                "Formato de código inválido. Esperado: HH-HH-HH-HH-HH-H-B " +
                "(H=hex, B=binário). Exemplo: 0A-14-05-FF-02-A-1"
            );
        }

        // Validar e extrair dia da data
        int ultimoDigitoDia = extrairUltimoDigitoDia(dataInsercao);

        // Separar grupos do código
        String[] grupos = codigo.toUpperCase().split("-");

        // Extrair valores dos grupos
        int g1 = hexToInt(grupos[0]); // Total competência A
        int g2 = hexToInt(grupos[1]); // Total competência B
        int g3 = hexToInt(grupos[2]); // Total competência C
        int g4 = hexToInt(grupos[3]); // Total competência D
        int g5 = hexToInt(grupos[4]); // Índice inicial
        int g6Raw = hexToInt(grupos[5]); // Step (0-15)
        int step = g6Raw == 0 ? 1 : g6Raw; // Trata step 0 como 1
        boolean crescente = (ultimoDigitoDia % 2 == 0); // Par=crescente, Ímpar=decrescente
        String idioma = grupos[6].equals("0") ? "inglês" : "espanhol";

        // Criar objeto de resultado
        CodigoProva resultado = new CodigoProva();
        resultado.setIdioma(idioma);
        resultado.setStartIndex(g5);
        resultado.setStep(step);
        resultado.setCrescente(crescente);

        // Processar cada competência
        resultado.setCompetenciaA(processarCompetencia(g1, g5, step, crescente));
        resultado.setCompetenciaB(processarCompetencia(g2, g5, step, crescente));
        resultado.setCompetenciaC(processarCompetencia(g3, g5, step, crescente));
        resultado.setCompetenciaD(processarCompetencia(g4, g5, step, crescente));

        return resultado;
    }

    /**
     * Processa uma competência individual, gerando os índices selecionados.
     *
     * @param totalQuestoes Número total de questões a selecionar
     * @param indiceInicial Índice inicial global (G5)
     * @param step Passo entre questões
     * @param crescente Se true, avança; se false, retrocede
     * @return CompetenciaInfo com os índices selecionados
     */
    private static CompetenciaInfo processarCompetencia(
        int totalQuestoes,
        int indiceInicial,
        int step,
        boolean crescente
    ) {
        CompetenciaInfo info = new CompetenciaInfo();
        info.setTotalQuestoes(totalQuestoes);

        // Se não há questões, retorna lista vazia
        if (totalQuestoes == 0) {
            info.setIndicesSelecionados(new ArrayList<>());
            return info;
        }

        // Calcular índice de partida com módulo
        int start = indiceInicial % totalQuestoes;

        List<Integer> indices = new ArrayList<>();
        Set<Integer> usados = new HashSet<>();
        int indiceAtual = start;
        int passoReal = crescente ? step : -step;

        // Garantir unicidade: avançar até preencher totalQuestoes únicos
        while (indices.size() < totalQuestoes && usados.size() < totalQuestoes) {
            if (!usados.contains(indiceAtual)) {
                indices.add(indiceAtual);
                usados.add(indiceAtual);
            }
            // próximo com wrap
            indiceAtual = (indiceAtual + passoReal) % totalQuestoes;
            if (indiceAtual < 0) indiceAtual += totalQuestoes;
            // Se bater em já usado, desloque 1 para frente (ou trás) para destravar
            if (usados.contains(indiceAtual)) {
                int fallbackPasso = crescente ? 1 : -1;
                int tentativa = (indiceAtual + fallbackPasso) % totalQuestoes;
                if (tentativa < 0) tentativa += totalQuestoes;
                indiceAtual = tentativa;
            }
        }

        info.setIndicesSelecionados(indices);
        return info;
    }

    /**
     * Converte uma string hexadecimal para inteiro.
     *
     * @param hex String hexadecimal (1 ou 2 caracteres)
     * @return Valor inteiro
     */
    private static int hexToInt(String hex) {
        try {
            return Integer.parseInt(hex, 16);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Valor hexadecimal inválido: " + hex, e);
        }
    }

    /**
     * Extrai o último dígito do dia de uma data no formato YYYY-MM-DD.
     *
     * @param data Data no formato "YYYY-MM-DD"
     * @return Último dígito do dia (0-9)
     * @throws IllegalArgumentException se a data for inválida
     */
    private static int extrairUltimoDigitoDia(String data) {
        if (data == null || !data.matches("\\d{4}-\\d{2}-\\d{2}")) {
            throw new IllegalArgumentException(
                "Formato de data inválido. Esperado: YYYY-MM-DD. Exemplo: 2025-11-04"
            );
        }

        String[] partes = data.split("-");
        String dia = partes[2];
        char ultimoDigito = dia.charAt(dia.length() - 1);
        return Character.getNumericValue(ultimoDigito);
    }

    /**
     * Valida se um código tem o formato correto (sem decodificar).
     *
     * @param codigo Código a validar
     * @return true se o formato é válido
     */
    public static boolean validarFormato(String codigo) {
        return codigo != null && CODIGO_PATTERN.matcher(codigo).matches();
    }

    /**
     * Gera uma explicação legível do código.
     *
     * @param codigo Código a explicar
     * @return String com a explicação
     */
    public static String explicarCodigo(String codigo) {
        if (!validarFormato(codigo)) {
            return "Código inválido.";
        }

        String[] grupos = codigo.toUpperCase().split("-");
        int g1 = hexToInt(grupos[0]);
        int g2 = hexToInt(grupos[1]);
        int g3 = hexToInt(grupos[2]);
        int g4 = hexToInt(grupos[3]);
        int g5 = hexToInt(grupos[4]);
        int g6 = hexToInt(grupos[5]);
        String idioma = grupos[6].equals("0") ? "Inglês" : "Espanhol";

        return String.format(
            Locale.US,
            "Código: %s\n" +
            "├─ Competência A: %d questões\n" +
            "├─ Competência B: %d questões\n" +
            "├─ Competência C: %d questões\n" +
            "├─ Competência D: %d questões\n" +
            "├─ Índice inicial: %d\n" +
            "├─ Step: %d\n" +
            "└─ Idioma: %s",
            codigo, g1, g2, g3, g4, g5, g6, idioma
        );
    }
}
