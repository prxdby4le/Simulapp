package com.example.simulapp;

import com.example.simulapp.database.DatabaseHelper;
import com.example.simulapp.model.Questao;

public class AdicionarQuestoesUtil {

    public static void adicionarQuestoes(DatabaseHelper databaseHelper) {
        // Questão 1 - Linguagens 2024
        //define q1 como variavel da primeira questão
        Questao q1 = new Questao();
        //define a area de uma das 4 que estão no arquivo que te mostrei
        q1.setArea(DatabaseHelper.AREA_LINGUAGENS);
        //define o ano da questão que vc escolheu adicionar
        q1.setAno(2024);
        //define o numero da questão
        q1.setNumero(1);
        //seta o enunciado, ou seja a pergunta
        q1.setEnunciado("A relação entre as citações atribuídas ao físico Albert Einstein e ao cantor e compositor Bob Marley reside na crença de que é necessário");
        //define as imagens (+ de 1, se quiser adicionar só 1 é so deixar no singular: q1.setImagem)
        q1.setImagens("questao1_img1_linguagens_2024", "questao1_img2_linguagens_2024");
        //seta a fonte da imagem ou do texto de apoio
        q1.setFonte("Disponível em: http://thumbpress.com. Acesso em: 28 out. 2013.");
        //define as alternativas de A até a E
        q1.setAlternativaA("dar oportunidade a pessoas que parecem necessitadas.");
        q1.setAlternativaB("identificar contextos que podem representar perigo.");
        q1.setAlternativaC("tirar proveito de situações que podem ser adversas.");
        q1.setAlternativaD("evitar dificuldades que parecem ser intransponíveis.");
        q1.setAlternativaE("contestar circunstâncias que parecem ser harmônicas");
        //define qual delas ta correta
        q1.setRespostaCorreta("C");
        //adiciona a variavel q1 no banco
        databaseHelper.inserirQuestao(q1);
        // IMPORTANTE: SEMPRE QUE QUISER TESTAR O APP COM UMA QUESTÃO NOVA, DEVE DESINSTALAR DO EMULADOR E INSTALAR DNV

        // Questão 2 - Humanas 2024
        Questao q2 = new Questao();
        q2.setArea(DatabaseHelper.AREA_HUMANAS);
        q2.setAno(2024);
        q2.setNumero(46);

        q2.setTextoApoio1("Um terremoto de magnitude 5,9 atingiu a cidade de Valparaíso, na costa chilena. O terremoto ocorreu a uma profundidade de 112 quilômetros.");
        q2.setReferenciaTexto1("Terremoto de magnitude 5,9 atinge Valparaíso, no Chile. Disponível em: www.cnnbrasil.com.br. Acesso em: 6 nov. 2021 (adaptado).");

        q2.setTextoApoio2("Um tremor de terra de magnitude 4,8 foi registrado no município de Atalaia do Norte, no interior do estado do Amazonas. O abalo é de magnitude considerada mediana para os níveis do Brasil. Os eventos dessa região costumam ser resultado das atividades da placa de Nazca.");
        q2.setReferenciaTexto2("Tremor de terra de magnitude 4,8 é registrado no interior do Amazonas. Disponível em: https://g1.globo.com. Acesso em: 6 nov. 2021 (adaptado).");
        q2.setTextoApoio3("Moradores usaram as redes sociais para relatar tremores de terra no interior de São Paulo. As atividades foram registradas nas cidades de Júlio Mesquita e Guaimbê e tiveram magnitude 3,0 na escala Richter, o que é considerado pequeno e sem previsão de danos.");
        q2.setReferenciaTexto3("Moradores do interior de SP relatam tremores de terra. Disponível em: https://noticias.r7.com. Acesso em: 6 nov. 2021 (adaptado).");

        q2.setEnunciado("As diferenças entre os eventos geológicos relatados decorrem de distintas posições geográficas das cidades em relação a:");
        q2.setAlternativaA("Planícies costeiras.");
        q2.setAlternativaB("Bacias continentais.");
        q2.setAlternativaC("Zonas de subducção");
        q2.setAlternativaD("Áreas de denudação.");
        q2.setAlternativaE("Vertentes escarpadas.");
        q2.setRespostaCorreta("C");
        databaseHelper.inserirQuestao(q2);

        // Questão 3 -


        // Questão 4 -


        // Questão 5 -


        // Questão 6 -


        // Questão 7 -


        // Questão 8 -


        // Questão 9 -


        // Questão 10 -


        // Questão 11 -


        // Questão 12 -


        // Questão 13 -


        // Questão 14 -


        // Questão 15 -


        // Questão 16 -


        // Questão 17 -


        // Questão 18 -


        // Questão 19 -


        // Questão 20 -


        // Questão 21 -


        // Questão 22 -


        // Questão 23 -


        // Questão 24 -


        // Questão 25 -


        // Questão 26 -


        // Questão 27 -


        // Questão 28 -


        // Questão 29 -


        // Questão 30 -


        // Questão 31 -


        // Questão 32 -


        // Questão 33 -


        // Questão 34 -


        // Questão 35 -


        // Questão 36 -


        // Questão 37 -


        // Questão 38 -


        // Questão 39 -


        // Questão 40 -
    }
}
