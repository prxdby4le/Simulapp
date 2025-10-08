package com.example.simulapp;

import com.example.simulapp.database.DatabaseHelper;
import com.example.simulapp.model.Questao;

public class AdicionarQuestoesUtil {

    public static void adicionarQuestoes(DatabaseHelper databaseHelper) {
        // Questão 1 - Linguagens 2024
        Questao q1 = new Questao();
        q1.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q1.setAno(2024);
        q1.setNumero(1);
        q1.setEnunciado("A relação entre as citações atribuídas ao físico Albert Einstein e ao cantor e compositor Bob Marley reside na crença de que é necessário");
        q1.setImagens("questao1_img1_linguagens_2024", "questao1_img2_linguagens_2024");
        q1.setFonte("Disponível em: http://thumbpress.com. Acesso em: 28 out. 2013.");
        q1.setAlternativaA("dar oportunidade a pessoas que parecem necessitadas.");
        q1.setAlternativaB("identificar contextos que podem representar perigo.");
        q1.setAlternativaC("tirar proveito de situações que podem ser adversas.");
        q1.setAlternativaD("evitar dificuldades que parecem ser intransponíveis.");
        q1.setAlternativaE("contestar circunstâncias que parecem ser harmônicas");
        q1.setRespostaCorreta("C");
        databaseHelper.inserirQuestao(q1);

        // Questão 2 - Humanas 2024
        Questao q2 = new Questao();
        q2.setArea(DatabaseHelper.AREA_HUMANAS);
        q2.setAno(2024);
        q2.setNumero(46);
        q2.setTextoApoio(
                "*TEXTO I* \n" + "Um terremoto de magnitude 5,9 atingiu a cidade de Valparaíso, na costa chilena. O terremoto ocorreu a uma profundidade de 112 quilômetros. \n *TEXTO II*\n" +
                "Um tremor de terra de magnitude 4,8 foi registrado " +
                "no município de Atalaia do Norte, no interior do estado do " +
                "Amazonas. O abalo é de magnitude considerada mediana " +
                "para os níveis do Brasil. Os eventos dessa região costumam " +
                "ser resultado das atividades da placa de Nazca. \n  *TEXTO III*\n" +
                "Moradores usaram as redes sociais para relatar tremores" +
                "de terra no interior de São Paulo. As atividades foram" +
                "registradas nas cidades de Júlio Mesquita e Guaimbê e" +
                "tiveram magnitude 3,0 na escala Richter, o que é considerado" +
                "pequeno e sem previsão de danos.");
        q2.setEnunciado("As diferenças entre os eventos geológicos relatados decorrem de distintas posições geográficas das cidades em relação a:");
        q2.setFonte("Terremoto de magnitude 5,9 atinge Valparaíso, no Chile. Disponível em: www.cnnbrasil.com.br. Acesso em: 6 nov. 2021 (adaptado).   ---  Tremor de terra de magnitude 4,8 é registrado no interior do\n" +
                "Amazonas. Disponível em: https://g1.globo.com.\n" +
                "Acesso em: 6 nov. 2021 (adaptado). --- Moradores do interior de SP relatam tremores de terra.\n" +
                "Disponível em: https://noticias.r7.com.\n" +
                "Acesso em: 6 nov. 2021 (adaptado).");
        q2.setAlternativaA("Planícies costeiras.");
        q2.setAlternativaB("Bacias continentais.");
        q2.setAlternativaC("Zonas de subducção");
        q2.setAlternativaD("Áreas de denudação.");
        q2.setAlternativaE("Vertentes escarpadas.");
        q2.setRespostaCorreta("C");
        databaseHelper.inserirQuestao(q2);

    }
}

