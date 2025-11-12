package com.info42022simulapp.simulapp.utils;

import com.info42022simulapp.simulapp.model.CodigoProva;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

/**
 * Testes unitários para o CodigoProvaDecoder.
 * Cobre casos normais e de borda conforme especificação.
 */
public class CodigoProvaDecoderTest {

    @Test
    public void testFormatoValido() {
        assertTrue(CodigoProvaDecoder.validarFormato("0A-14-05-FF-02-A-1"));
        assertTrue(CodigoProvaDecoder.validarFormato("00-00-00-00-00-0-0"));
        assertTrue(CodigoProvaDecoder.validarFormato("FF-FF-FF-FF-FF-F-1"));
    }

    @Test
    public void testFormatoInvalido() {
        assertFalse(CodigoProvaDecoder.validarFormato("0A-14-05-FF-02-A-2")); // G7 não é binário
        assertFalse(CodigoProvaDecoder.validarFormato("0A-14-05-FF-02-AG-1")); // G6 com 2 dígitos
        assertFalse(CodigoProvaDecoder.validarFormato("0A-14-05-FF-02")); // Faltam grupos
        assertFalse(CodigoProvaDecoder.validarFormato("GG-14-05-FF-02-A-1")); // Não é hex
        assertFalse(CodigoProvaDecoder.validarFormato(null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCodigoInvalidoLancaExcecao() {
        CodigoProvaDecoder.decodificar("INVALIDO", "2025-11-04");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDataInvalidaLancaExcecao() {
        CodigoProvaDecoder.decodificar("0A-14-05-FF-02-A-1", "04-11-2025");
    }

    @Test
    public void testIdiomaIngles() {
        CodigoProva resultado = CodigoProvaDecoder.decodificar("05-05-05-05-00-1-0", "2025-11-04");
        assertEquals("inglês", resultado.getIdioma());
    }

    @Test
    public void testIdiomaEspanhol() {
        CodigoProva resultado = CodigoProvaDecoder.decodificar("05-05-05-05-00-1-1", "2025-11-04");
        assertEquals("espanhol", resultado.getIdioma());
    }

    @Test
    public void testTotalQuestoesPorCompetencia() {
        // Código: 0A-14-05-FF-02-1-0
        // G1=10, G2=20, G3=5, G4=255
        CodigoProva resultado = CodigoProvaDecoder.decodificar("0A-14-05-FF-02-1-0", "2025-11-04");

        assertEquals(10, resultado.getCompetenciaA().getTotalQuestoes());
        assertEquals(20, resultado.getCompetenciaB().getTotalQuestoes());
        assertEquals(5, resultado.getCompetenciaC().getTotalQuestoes());
        assertEquals(255, resultado.getCompetenciaD().getTotalQuestoes());
    }

    @Test
    public void testCompetenciaComZeroQuestoes() {
        // G2 = 00 (zero questões na competência B)
        CodigoProva resultado = CodigoProvaDecoder.decodificar("0A-00-0F-01-03-3-1", "2025-11-05");

        assertEquals(0, resultado.getCompetenciaB().getTotalQuestoes());
        assertEquals(0, resultado.getCompetenciaB().getIndicesSelecionados().size());
    }

    @Test
    public void testDirecaoCrescenteDiaPar() {
        // Data: 2025-11-04 (dia 04, último dígito = 4, par → crescente)
        // Código: 05-05-05-05-00-1-0
        // G1=5 questões, start=0, step=1, crescente
        // Esperado: [0, 1, 2, 3, 4]
        CodigoProva resultado = CodigoProvaDecoder.decodificar("05-05-05-05-00-1-0", "2025-11-04");

        List<Integer> indices = resultado.getCompetenciaA().getIndicesSelecionados();
        assertEquals(5, indices.size());
        assertEquals(Integer.valueOf(0), indices.get(0));
        assertEquals(Integer.valueOf(1), indices.get(1));
        assertEquals(Integer.valueOf(2), indices.get(2));
        assertEquals(Integer.valueOf(3), indices.get(3));
        assertEquals(Integer.valueOf(4), indices.get(4));
    }

    @Test
    public void testDirecaoDecrescenteDiaImpar() {
        // Data: 2025-11-05 (dia 05, último dígito = 5, ímpar → decrescente)
        // Código: 05-05-05-05-00-1-0
        // G1=5 questões, start=0, step=1, decrescente
        // Esperado: [0, 4, 3, 2, 1] (começa em 0, depois vai para 4 com wrap)
        CodigoProva resultado = CodigoProvaDecoder.decodificar("05-05-05-05-00-1-0", "2025-11-05");

        List<Integer> indices = resultado.getCompetenciaA().getIndicesSelecionados();
        assertEquals(5, indices.size());
        assertEquals(Integer.valueOf(0), indices.get(0));
        assertEquals(Integer.valueOf(4), indices.get(1));
        assertEquals(Integer.valueOf(3), indices.get(2));
        assertEquals(Integer.valueOf(2), indices.get(3));
        assertEquals(Integer.valueOf(1), indices.get(4));
    }

    @Test
    public void testStepMaiorQueUmCrescente() {
        // Data: 2025-11-04 (par → crescente)
        // Código: 0A-0A-0A-0A-05-A-0
        // G1=10 (0x0A), start=5, step=10 (0xA), crescente
        // Começando em 5, step=10, total=10
        // Esperado: [5, 15%10=5, 5, 5, ...] → ciclo em 5
        // Na verdade: [5, (5+10)%10=5, ...] repete
        CodigoProva resultado = CodigoProvaDecoder.decodificar("0A-0A-0A-0A-05-A-0", "2025-11-04");

        List<Integer> indices = resultado.getCompetenciaA().getIndicesSelecionados();
        assertEquals(10, indices.size());
        // Step=10 em total=10 causa ciclo, todos índices são 5
        for (Integer idx : indices) {
            assertEquals(Integer.valueOf(5), idx);
        }
    }

    @Test
    public void testStepCoprimo() {
        // Data: 2025-11-04 (par → crescente)
        // Código: 05-05-05-05-00-2-0
        // G1=5, start=0, step=2, crescente
        // Esperado: [0, 2, 4, 1, 3] (percorre todos com step 2)
        CodigoProva resultado = CodigoProvaDecoder.decodificar("05-05-05-05-00-2-0", "2025-11-04");

        List<Integer> indices = resultado.getCompetenciaA().getIndicesSelecionados();
        assertEquals(5, indices.size());
        assertEquals(Integer.valueOf(0), indices.get(0));
        assertEquals(Integer.valueOf(2), indices.get(1));
        assertEquals(Integer.valueOf(4), indices.get(2));
        assertEquals(Integer.valueOf(1), indices.get(3));
        assertEquals(Integer.valueOf(3), indices.get(4));
    }

    @Test
    public void testStepZeroTratadoComoUm() {
        // Código: 05-05-05-05-01-0-0
        // G6=0 → step deve ser tratado como 1
        CodigoProva resultado = CodigoProvaDecoder.decodificar("05-05-05-05-01-0-0", "2025-11-04");

        List<Integer> indices = resultado.getCompetenciaA().getIndicesSelecionados();
        assertEquals(5, indices.size());
        // start=1, step=1 (tratado), crescente
        assertEquals(Integer.valueOf(1), indices.get(0));
        assertEquals(Integer.valueOf(2), indices.get(1));
        assertEquals(Integer.valueOf(3), indices.get(2));
        assertEquals(Integer.valueOf(4), indices.get(3));
        assertEquals(Integer.valueOf(0), indices.get(4)); // Wrap-around
    }

    @Test
    public void testG5MaiorQueTotalComModulo() {
        // Código: 05-05-05-05-64-1-0
        // G5=100 (0x64), mas total=5 → start = 100 % 5 = 0
        CodigoProva resultado = CodigoProvaDecoder.decodificar("05-05-05-05-64-1-0", "2025-11-04");

        List<Integer> indices = resultado.getCompetenciaA().getIndicesSelecionados();
        assertEquals(5, indices.size());
        assertEquals(Integer.valueOf(0), indices.get(0)); // Começa em 0 devido ao módulo
    }

    @Test
    public void testStepMaiorQueTotal() {
        // Data: 2025-11-04 (par → crescente)
        // Código: 03-03-03-03-00-5-0
        // G1=3, start=0, step=5, crescente
        // Índices: [0, (0+5)%3=2, (2+5)%3=1, (1+5)%3=0...] → ciclo curto
        CodigoProva resultado = CodigoProvaDecoder.decodificar("03-03-03-03-00-5-0", "2025-11-04");

        List<Integer> indices = resultado.getCompetenciaA().getIndicesSelecionados();
        assertEquals(3, indices.size());
        assertEquals(Integer.valueOf(0), indices.get(0));
        assertEquals(Integer.valueOf(2), indices.get(1)); // (0+5)%3 = 2
        assertEquals(Integer.valueOf(1), indices.get(2)); // (2+5)%3 = 1
    }

    @Test
    public void testStepENaoCoprimos() {
        // Data: 2025-11-04 (par → crescente)
        // Código: 04-04-04-04-00-2-0
        // G1=4, start=0, step=2 (gcd(2,4)=2 > 1)
        // Esperado: [0, 2, 0, 2] (ciclo entre 0 e 2)
        CodigoProva resultado = CodigoProvaDecoder.decodificar("04-04-04-04-00-2-0", "2025-11-04");

        List<Integer> indices = resultado.getCompetenciaA().getIndicesSelecionados();
        assertEquals(4, indices.size());
        assertEquals(Integer.valueOf(0), indices.get(0));
        assertEquals(Integer.valueOf(2), indices.get(1));
        assertEquals(Integer.valueOf(0), indices.get(2)); // Repete
        assertEquals(Integer.valueOf(2), indices.get(3)); // Repete
    }

    @Test
    public void testWrapAroundCrescente() {
        // Data: 2025-11-04 (par → crescente)
        // Código: 05-05-05-05-04-2-0
        // G1=5, start=4, step=2, crescente
        // Esperado: [4, (4+2)%5=1, (1+2)%5=3, (3+2)%5=0, (0+2)%5=2]
        CodigoProva resultado = CodigoProvaDecoder.decodificar("05-05-05-05-04-2-0", "2025-11-04");

        List<Integer> indices = resultado.getCompetenciaA().getIndicesSelecionados();
        assertEquals(5, indices.size());
        assertEquals(Integer.valueOf(4), indices.get(0));
        assertEquals(Integer.valueOf(1), indices.get(1));
        assertEquals(Integer.valueOf(3), indices.get(2));
        assertEquals(Integer.valueOf(0), indices.get(3));
        assertEquals(Integer.valueOf(2), indices.get(4));
    }

    @Test
    public void testWrapAroundDecrescente() {
        // Data: 2025-11-05 (ímpar → decrescente)
        // Código: 05-05-05-05-01-2-0
        // G1=5, start=1, step=2, decrescente
        // Esperado: [1, (1-2+5)%5=4, (4-2)%5=2, (2-2)%5=0, (0-2+5)%5=3]
        CodigoProva resultado = CodigoProvaDecoder.decodificar("05-05-05-05-01-2-0", "2025-11-05");

        List<Integer> indices = resultado.getCompetenciaA().getIndicesSelecionados();
        assertEquals(5, indices.size());
        assertEquals(Integer.valueOf(1), indices.get(0));
        assertEquals(Integer.valueOf(4), indices.get(1));
        assertEquals(Integer.valueOf(2), indices.get(2));
        assertEquals(Integer.valueOf(0), indices.get(3));
        assertEquals(Integer.valueOf(3), indices.get(4));
    }

    @Test
    public void testExemplo1Especificacao() {
        // Exemplo da especificação: "0A-0A-0A-0A-05-A-0"
        // G1..G4 = 0x0A (10 questões cada)
        // G5 = 0x05 (start=5)
        // G6 = 0xA (step=10)
        // G7 = 0 (inglês)
        // Data par para crescente
        CodigoProva resultado = CodigoProvaDecoder.decodificar("0A-0A-0A-0A-05-A-0", "2025-11-04");

        assertEquals("inglês", resultado.getIdioma());
        assertEquals(10, resultado.getCompetenciaA().getTotalQuestoes());

        // Com step=10 e total=10, todos os índices serão 5 (ciclo fixo)
        List<Integer> indices = resultado.getCompetenciaA().getIndicesSelecionados();
        assertEquals(10, indices.size());
    }

    @Test
    public void testExemplo2Especificacao() {
        // Exemplo: "14-00-0F-01-03-3-1"
        // G1=0x14=20, G2=0x00=0, G3=0x0F=15, G4=0x01=1
        // G5=0x03=3, G6=0x3=3, G7=1 (espanhol)
        CodigoProva resultado = CodigoProvaDecoder.decodificar("14-00-0F-01-03-3-1", "2025-11-04");

        assertEquals("espanhol", resultado.getIdioma());
        assertEquals(20, resultado.getCompetenciaA().getTotalQuestoes());
        assertEquals(0, resultado.getCompetenciaB().getTotalQuestoes());
        assertEquals(15, resultado.getCompetenciaC().getTotalQuestoes());
        assertEquals(1, resultado.getCompetenciaD().getTotalQuestoes());

        // Competência B deve ter lista vazia
        assertTrue(resultado.getCompetenciaB().getIndicesSelecionados().isEmpty());
    }

    @Test
    public void testDiferentesDias() {
        // Mesmo código, dias diferentes devem gerar sequências diferentes
        CodigoProva resultadoDia4 = CodigoProvaDecoder.decodificar("05-05-05-05-02-3-0", "2025-11-04"); // Par
        CodigoProva resultadoDia5 = CodigoProvaDecoder.decodificar("05-05-05-05-02-3-0", "2025-11-05"); // Ímpar

        List<Integer> indicesDia4 = resultadoDia4.getCompetenciaA().getIndicesSelecionados();
        List<Integer> indicesDia5 = resultadoDia5.getCompetenciaA().getIndicesSelecionados();

        // Ambos devem ter 5 elementos
        assertEquals(5, indicesDia4.size());
        assertEquals(5, indicesDia5.size());

        // Mas devem ser diferentes (crescente vs decrescente)
        assertNotEquals(indicesDia4, indicesDia5);
    }

    @Test
    public void testExplicarCodigo() {
        String explicacao = CodigoProvaDecoder.explicarCodigo("0A-14-05-FF-02-A-1");

        assertNotNull(explicacao);
        assertTrue(explicacao.contains("Competência A: 10 questões"));
        assertTrue(explicacao.contains("Competência B: 20 questões"));
        assertTrue(explicacao.contains("Competência C: 5 questões"));
        assertTrue(explicacao.contains("Competência D: 255 questões"));
        assertTrue(explicacao.contains("Índice inicial: 2"));
        assertTrue(explicacao.contains("Step: 10"));
        assertTrue(explicacao.contains("Espanhol"));
    }

    @Test
    public void testExplicarCodigoInvalido() {
        String explicacao = CodigoProvaDecoder.explicarCodigo("INVALIDO");
        assertEquals("Código inválido.", explicacao);
    }
}

