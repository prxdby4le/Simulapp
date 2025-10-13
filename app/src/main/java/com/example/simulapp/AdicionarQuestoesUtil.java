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
        q2.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q2.setAno(2024);
        q2.setNumero(2);
        q2.setTextoApoio("Oh, so we can hate each other and fear each other We can build these walls between each other Baby, blow by blow and brick by brick Keep yourself locked in, yourself locked in […] Oh, maybe we should love somebody Oh, maybe we could care a little more So maybe we should love somebody Instead of polishing the bombs of holy war");
        q2.setFonte("KEYS, A. Here. Estados Unidos: RCA Records, 2016.");
        q2.setEnunciado("Nessa letra de canção, que aborda um contexto de ódio e intolerância, o marcador “instead of ” introduz a ideia de");

        q2.setAlternativaA("mudança de comportamento.");
        q2.setAlternativaB("panorama de conflitos.");
        q2.setAlternativaC("rotina de isolamento.");
        q2.setAlternativaD("perspectiva bélica.");
        q2.setAlternativaE("cenário relogioso.");
        q2.setRespostaCorreta("A");
        databaseHelper.inserirQuestao(q2);

        // Questão 3 -
        Questao q3 = new Questao();
        q3.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q3.setAno(2024);
        q3.setNumero(3);
        q3.setImagens("questao3_img1_linguagens_2024");
        q3.setFonte("Disponível em: www.hongkiat.com. Acesso em: 18 ago. 2017 (adaptado).");
        q3.setEnunciado("O texto estabelece uma relação entre elementos da natureza e comandos de um programa de computador para");

        q3.setAlternativaA("alertar as pessoas sobre a rápida destruição da natureza.");
        q3.setAlternativaB("conscientizar os indivíduos sobre a passagem acelerada do tempo.");
        q3.setAlternativaC("apresentar aos leitores os avanços tecnológicos na área da agricultura.");
        q3.setAlternativaD("orientar os usuários sobre o emprego sustentável das novas tecnologias.");
        q3.setAlternativaE("informar os interessados sobre o tempo de crescimento de novas árvores.");
        q3.setRespostaCorreta("A");
        databaseHelper.inserirQuestao(q3);

        // Questão 4 -
        Questao q4 = new Questao();
        q4.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q4.setAno(2024);
        q4.setNumero(4);
        q4.setTextoApoio("I remember being caught speaking Spanish at recess [...] I remember being sent to the corner of the classroom for “talking back” to the Anglo teacher when all I was trying to do was tell her how to pronounce my name. “If you want to be American, speak ‘American’. If you don’t like it, go back to Mexico where you belong”. “I want you to speak English […]”, my mother would say, mortified that I spoke English like a Mexican. At Pan American University, I and all Chicano students were required to take two speech classes. Their purpose: to get rid of our accents.");
        q4.setFonte("ANZALDÚA, G. Borderlands/La Frontera: The New Mestiza. San Francisco: Aunt Lute Books, 1987.");
        q4.setEnunciado("O problema abordado nesse texto sobre imigrantes residentes nos Estados Unidos diz respeito aos prejuízos gerados pelo(a)");

        q4.setAlternativaA("repúdio ao sotaque espanhol no uso do inglês.");
        q4.setAlternativaB("resignação diante do apagamento da língua materna.");
        q4.setAlternativaC("escassez de oportunidades de aprendizado do espanhol.");
        q4.setAlternativaD("choque entre falantes de línguas distintas de diferentes gerações.");
        q4.setAlternativaE("concorrência entre as variações linguísticas do inglês e as do espanhol.");
        q4.setRespostaCorreta("A");
        databaseHelper.inserirQuestao(q4);

        // Questão 5 -
        Questao q5 = new Questao();
        q5.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q5.setAno(2024);
        q5.setNumero(5);
        q5.setImagens("questao5_img1_linguagens_2024");
        q5.setFonte("Disponível em: www.clickhole.com. Acesso em: 26 out. 2015");
        q5.setEnunciado("A carta da editora Stephanie Allen-Nichols à escritora Alice Walker tem o propósito de");

        q5.setAlternativaA("problematizar o enredo de sua obra.");
        q5.setAlternativaB("acusar o recebimento de seu manuscrito.");
        q5.setAlternativaC("solicitar a revisão ortográfica de seu texto.");
        q5.setAlternativaD("informar a transferência de seu livro a outra editora.");
        q5.setAlternativaE("comunicar a recusa da publicação de seu romance.");
        q5.setRespostaCorreta("E");
        databaseHelper.inserirQuestao(q5);

        // Questão 6 -
        Questao q6 = new Questao();
        q6.setArea(DatabaseHelper.AREA_HUMANAS);
        q6.setAno(2024);
        q6.setNumero(46);

        q6.setTextoApoio1("Um terremoto de magnitude 5,9 atingiu a cidade de Valparaíso, na costa chilena. O terremoto ocorreu a uma profundidade de 112 quilômetros.");
        q6.setReferenciaTexto1("Terremoto de magnitude 5,9 atinge Valparaíso, no Chile. Disponível em: www.cnnbrasil.com.br. Acesso em: 6 nov. 2021 (adaptado).");

        q6.setTextoApoio2("Um tremor de terra de magnitude 4,8 foi registrado no município de Atalaia do Norte, no interior do estado do Amazonas. O abalo é de magnitude considerada mediana para os níveis do Brasil. Os eventos dessa região costumam ser resultado das atividades da placa de Nazca.");
        q6.setReferenciaTexto2("Tremor de terra de magnitude 4,8 é registrado no interior do Amazonas. Disponível em: https://g1.globo.com. Acesso em: 6 nov. 2021 (adaptado).");
        q6.setTextoApoio3("Moradores usaram as redes sociais para relatar tremores de terra no interior de São Paulo. As atividades foram registradas nas cidades de Júlio Mesquita e Guaimbê e tiveram magnitude 3,0 na escala Richter, o que é considerado pequeno e sem previsão de danos.");
        q6.setReferenciaTexto3("Moradores do interior de SP relatam tremores de terra. Disponível em: https://noticias.r7.com. Acesso em: 6 nov. 2021 (adaptado).");

        q6.setEnunciado("As diferenças entre os eventos geológicos relatados decorrem de distintas posições geográficas das cidades em relação a:");
        q6.setAlternativaA("Planícies costeiras.");
        q6.setAlternativaB("Bacias continentais.");
        q6.setAlternativaC("Zonas de subducção");
        q6.setAlternativaD("Áreas de denudação.");
        q6.setAlternativaE("Vertentes escarpadas.");
        q6.setRespostaCorreta("C");
        databaseHelper.inserirQuestao(q6);

        // Questão 7 -
        Questao q7 = new Questao();
        q7.setArea(DatabaseHelper.AREA_HUMANAS);
        q7.setAno(2024);
        q7.setNumero(47);
        q7.setTextoApoio("Tal qual num exército, não se compreende um efetivo composto apenas de oficiais. Também na saúde pública, os funcionários técnicos graduados necessitam ser assistidos por auxiliares em número suficiente e com preparo adequado, constituído pelas enfermeiras de saúde pública, educadoras ou visitadoras sanitárias, técnicos de laboratório, inspetores ou guardas etc., para não falarmos no pessoal burocrático, não especializado.");
        q7.setFonte("PAULA SOUZA, G. H.; VIEIRA, F. B. Centro de saúde “eixo” de organização sanitária. Boletim do Instituto de Higiene de São Paulo, n. 59 (adaptado).");
        q7.setEnunciado("O texto dos sanitaristas atuantes nas décadas de 1920 e 1930 veicula uma mensagem caracterizada pela");

        q7.setAlternativaA("higienização moral.");
        q7.setAlternativaB("imposição eugênica.");
        q7.setAlternativaC("assimilação cultural.");
        q7.setAlternativaD("hegemonização identitária.");
        q7.setAlternativaE("hierarquização profissional.");
        q7.setRespostaCorreta("D");
        databaseHelper.inserirQuestao(q7);

        // Questão 8 -
        Questao q8 = new Questao();
        q8.setArea(DatabaseHelper.AREA_HUMANAS);
        q8.setAno(2024);
        q8.setNumero(48);
        q8.setTextoApoio("O rompimento da barragem de Fundão levou muito consigo. A lama soterrou sonhos e modificou de forma permanente centenas de vidas nascidas e criadas em Bento Rodrigues e Paracatu, em Mariana (MG). Mas não somente. Ao se estender ao longo do rio, outras famílias e histórias foram atingidas de formas diferentes. Ao fugirem dos rejeitos que rapidamente tomaram as localidades, deixaram para trás os resquícios da vida que tiveram até o 5 de novembro de 2015. Nada jamais seria igual.");
        q8.setFonte("SANTOS, P. Histórias soterradas. Curinga, n. 19, nov. 2016 (adaptado).");
        q8.setEnunciado("Conforme o texto, o evento gerou o seguinte impacto na relação entre as pessoas e o seu espaço vivido:");

        q8.setAlternativaA("Flexibilização de parâmetros ambientais.");
        q8.setAlternativaB("Consolidação de identidades regionais.");
        q8.setAlternativaC("Fragilização de vínculos afetivos.");
        q8.setAlternativaD("Supressão de práticas exploratórias.");
        q8.setAlternativaE("Recuperação de tradições ancestrais.");
        q8.setRespostaCorreta("C");
        databaseHelper.inserirQuestao(q8);

        // Questão 9 -
        Questao q9 = new Questao();
        q9.setArea(DatabaseHelper.AREA_HUMANAS);
        q9.setAno(2024);
        q9.setNumero(49);
        q9.setTextoApoio("Com a proximidade do final do século XIX, amplificam-se as expectativas com relação ao século seguinte. Se muitas eram as utopias, talvez uma das mais evidentes tenha se concentrado nas potencialidades da nova ciência, com suas invenções e projetos. Não é por mera coincidência que a agenda do país tenha sido tomada pela introdução de uma série de inventos. De forma acelerada, entraram no Brasil a luz elétrica e, com ela, o telégrafo, o telefone, o cinematógrafo. Na área dos transportes, o trem a vapor é substituído pelo elétrico, que assiste à entrada do automóvel e até do aeroplano.");
        q9.setFonte("COSTA, A. M.; SCHWARCZ, L. M. 1890-1914, no tempo das certezas. São Paulo: Cia. das Letras, 2000 (adaptado).");
        q9.setEnunciado("No Brasil, os eventos descritos ganharam conotação política ao serem vinculados à");
        q9.setAlternativaA("expansão estratégica do imperialismo.");
        q9.setAlternativaB("ascensão gradual do mercantilismo.");
        q9.setAlternativaC("laicidade da educação.");
        q9.setAlternativaD("retomada do absolutismo.");
        q9.setAlternativaE("visão republicana de nação.");
        q9.setRespostaCorreta("E");
        databaseHelper.inserirQuestao(q9);

        // Questão 10 -
        Questao q10 = new Questao();
        q10.setArea(DatabaseHelper.AREA_HUMANAS);
        q10.setAno(2024);
        q10.setNumero(50);
        q10.setTextoApoio("O bispo Bartolomeu de Las Casas é o homem mais odiado da América, o anti-Cristo dos senhores, o açoite destas terras. Por sua culpa, o imperador promulgou novas leis que despojam de escravos índios os filhos dos conquistadores. O que será deles sem os braços que os sustentam nas minas e nas lavouras? As novas leis estão arrancando a comida de suas bocas. Las Casas é o homem mais amado da América. Voz dos mudos, teimoso defensor dos que recebem pior tratamento que o esterco das praças, denunciador de quem por cobiça converte Jesus Cristo no mais cruel dos deuses e o rei em lobo faminto de carne humana.");
        q10.setFonte("GALEANO, E. Os nascimentos. Porto Alegre: L&PM, 2011 (adaptado).");
        q10.setEnunciado("Os diferentes pontos de vista presentes no texto expressam que o bispo era, ao mesmo tempo,");
        q10.setAlternativaA("execrado pelos reis e reverenciado pelos religiosos do local.");
        q10.setAlternativaB("detestado pelos colonizadores e respeitado pelos povos do lugar.");
        q10.setAlternativaC("menosprezado pela colônia e idolatrado pelos governantes da região.");
        q10.setAlternativaD("desrespeitado pela metrópole e adorado pelos invasores da Espanha.");
        q10.setAlternativaE("desacatado pelos excluídos e valorizado pelos negociantes de negros.");
        q10.setRespostaCorreta("B");
        databaseHelper.inserirQuestao(q10);

        // Questão 11 -
        Questao q11 = new Questao();
        q11.setArea(DatabaseHelper.AREA_NATUREZA);
        q11.setAno(2024);
        q11.setNumero(91);
        q11.setTextoApoio("Muitas pessoas ainda se espantam com o fato de um passageiro sair ileso de um acidente de carro enquanto o veículo onde estava teve perda total. Essas pessoas talvez considerem, equivocadamente, que os carros mais seguros são os que têm as estruturas mais rígidas, ou seja, estruturas, que durante uma colisão, apresentam menor deformação. Na verdade, o que ocorre é o contrário. Por isso, a partir de 1958, passaram a ser produzidos carros com partes que se deformam facilmente. ------ Assim, além dos cintos de segurança e dos airbags, os carros modernos passaram a contar com o dispositivo de segurança conhecido como crumple zone (região deformável, em inglês), conforme a figura.");
        q11.setReferenciaTexto1("DAY, C. Crumple Zones. Disponível em: https://pubs.aip.org. Acesso em: 2 jul. 2024 (adaptado). ----- Momentum and Car safety.");
        q11.setImagens("questao91_img1_natureza_2024");
        q11.setReferenciaTexto2("GCSE Physics Revision. Disponível em: www.shalom-education.com. Acesso em: 5 jul. 2024 (adaptado).");
        q11.setEnunciado("Considerando o carro, seus ocupantes e o muro da figura como um sistema isolado, o crumple zone aumenta a segurança dos passageiros porque, durante uma colisão, a deformação da estrutura do carro");
        q11.setAlternativaA("aciona os airbags do veículo.");
        q11.setAlternativaB("absorve a energia cinética do sistema.");
        q11.setAlternativaC("consome a quantidade de movimento do sistema.");
        q11.setAlternativaD("cria uma barreira de proteção para seus ocupantes.");
        q11.setAlternativaE("diminui a velocidade do centro de massa do sistema.");
        q11.setRespostaCorreta("B");
        databaseHelper.inserirQuestao(q11);

        // Questão 12 -
        Questao q12 = new Questao();
        q12.setArea(DatabaseHelper.AREA_NATUREZA);
        q12.setAno(2024);
        q12.setNumero(92);
        q12.setTextoApoio("Células a combustível microbianas (CCM) são capazes de gerar eletricidade a partir de águas residuárias urbanas e agroindustriais. As CCM são compostas de duas câmaras. Numa delas, onde ocorre o tratamento da matéria orgânica, as bactérias eletrogênicas crescem formando um biofilme e se alimentam dos poluentes presentes no efluente. Ao se alimentarem, essas bactérias geram uma corrente elétrica que percorre o material sobre o qual elas formaram o biofilme. Um fio condutor externo possibilita a migração dessa corrente para uma segunda câmara, promovendo uma reação química. A figura esquematiza uma CCM e as reações envolvidas.");
        q12.setImagens("questao92_img1_natureza_2024");
        q12.setFonte("QUINTO, A. C. Biobaterias geram eletricidade a partir de esgoto sanitário e efluentes agroindustriais. Disponível em: https://jornal.usp.br. Acesso em: 1 dez. 2021 (adaptado).");
        q12.setEnunciado("Células a combustível microbianas (CCM) são capazes de gerar eletricidade a partir de águas residuárias urbanas e agroindustriais. As CCM são compostas de duas câmaras. Numa delas, onde ocorre o tratamento da matéria orgânica, as bactérias eletrogênicas crescem formando um biofilme e se alimentam dos poluentes presentes no efluente. Ao se alimentarem, essas bactérias geram uma corrente elétrica que percorre o material sobre o qual elas formaram o biofilme. Um fio condutor externo possibilita a migração dessa corrente para uma segunda câmara, promovendo uma reação química. A figura esquematiza uma CCM e as reações envolvidas. ------ Qual das equações representa a reação global que ocorre durante o funcionamento dessa CCM?");
        q12.setAlternativaA("CH3COO− (aq) + O2 (g) → 2 CO2 (g) + 3 H+ (aq)");
        q12.setAlternativaB("CO2 (g) + O2 (g) + H+ (aq) → H2O (l) + CH3COO− (aq)");
        q12.setAlternativaC("CH3 COO − (aq) + H + (aq) + 2 O2 (g) → 2 CO2 (g) + 2 H2 O (l)");
        q12.setAlternativaD("CH3 COO − (aq) + 6 H2 O (l) → 2 CO2 (g) + 2 O2 (g) + 15 H + (aq)");
        q12.setAlternativaE("2 CO2 (g) + 11 H + (aq) + O2 (g) → CH3 COO− (aq) + 4 H2O (l)");
        q12.setRespostaCorreta("C");
        databaseHelper.inserirQuestao(q12);

        // Questão 13 -
        Questao q13 = new Questao();
        q13.setArea(DatabaseHelper.AREA_NATUREZA);
        q13.setAno(2024);
        q13.setNumero(93);
        q13.setEnunciado("No senso comum, considera-se, ainda hoje, que compostos orgânicos são substâncias presentes nos seres vivos. Na Química, a expressão “compostos orgânicos” tem um uso histórico de mais de 200 anos, adquirindo diferentes conotações ao longo do desenvolvimento dessa ciência. Atualmente, atribui-se a essa expressão outro significado.A concepção científica atual define esses compostos como substâncias");
        q13.setAlternativaA("benéficas à saúde humana.");
        q13.setAlternativaB("capazes de serem biodegradadas.");
        q13.setAlternativaC("formadas a partir de gás carbônico.");
        q13.setAlternativaD("produzidas sem o uso de agrotóxicos.");
        q13.setAlternativaE("contendo carbono como elemento principal.");
        q13.setRespostaCorreta("E");
        databaseHelper.inserirQuestao(q13);

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
