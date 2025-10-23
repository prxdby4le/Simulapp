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
        q1.addImagem("questao1_img1_linguagens_2024");
        q1.addImagem("questao1_img2_linguagens_2024");
        q1.addReferencia("Disponível em: http://thumbpress.com. Acesso em: 28 out. 2013.");
        q1.addEnunciado("A relação entre as citações atribuídas ao físico Albert Einstein e ao cantor e compositor Bob Marley reside na crença de que é necessário");
        q1.setAlternativaA("dar oportunidade a pessoas que parecem necessitadas.");
        q1.setAlternativaB("identificar contextos que podem representar perigo.");
        q1.setAlternativaC("tirar proveito de situações que podem ser adversas.");
        q1.setAlternativaD("evitar dificuldades que parecem ser intransponíveis.");
        q1.setAlternativaE("contestar circunstâncias que parecem ser harmônicas");
        q1.setRespostaCorreta("C");
        databaseHelper.inserirQuestao(q1);

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
        q13.addEnunciado("No senso comum, considera-se, ainda hoje, que compostos orgânicos são substâncias presentes nos seres vivos. Na Química, a expressão “compostos orgânicos” tem um uso histórico de mais de 200 anos, adquirindo diferentes conotações ao longo do desenvolvimento dessa ciência. Atualmente, atribui-se a essa expressão outro significado.A concepção científica atual define esses compostos como substâncias");
        q13.setAlternativaA("benéficas à saúde humana.");
        q13.setAlternativaB("capazes de serem biodegradadas.");
        q13.setAlternativaC("formadas a partir de gás carbônico.");
        q13.setAlternativaD("produzidas sem o uso de agrotóxicos.");
        q13.setAlternativaE("contendo carbono como elemento principal.");
        q13.setRespostaCorreta("E");
        databaseHelper.inserirQuestao(q13);

        // Questão 14 -
        Questao q14 = new Questao();
        q14.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q14.setAno(2024);
        q14.setNumero(6);
        q14.setTextoApoio("Expressões e termos utilizados no Amazonas são retratados em livro e em camisetas “Na linguagem, podemos nos ver da forma mais verdadeira: nossas crenças, nossos valores, nosso lugar no mundo”, afirmou o doutor em linguística e professor da Ufam em seu livro Amazonês: expressões e termos usados no Amazonas. Portanto, o amazonense, com todas as suas “cunhantãs” e “curumins”, acaba por encontrar um lugar no mundo e formar uma unidade linguística, informalmente denominada de português “caboco”, que muito se diferencia do português “mineiro”, “gaúcho”, “carioca” e de tantos outros espalhados pelo Brasil. O livro, que conta com cerca de 1100 expressões e termos típicos do falar amazonense, levou dez anos para ser construído. Para o autor, o principal objetivo da obra é registrar a linguagem. Um designer amazonense também acha o amazonês “xibata”, tanto é que criou uma série de camisetas estampadas com o nome de Caboquês Ilustrado, que mistura o bom humor com as expressões típicas da região. A coleção conta com sete modelos já lançados, entre eles: Leseira Baré, Xibata no Balde e Até o Tucupi, e 43 ainda na fila de espera. Para o criador, as camisas têm como objetivo “resgatar o orgulho do povo manauara, do povo do Norte”.");
        q14.setFonte("Disponível em: https://g1.globo.com. Acesso em: 15 jan. 2024 (adaptado).");
        q14.setEnunciado("A reportagem apresenta duas iniciativas: o livro Amazonês e as camisetas do Caboquês Ilustrado. Com temática em comum, essas iniciativas");
        q14.setAlternativaA("recomendam produtos feitos por empreendedores da região Norte.");
        q14.setAlternativaB("ressaltam diferenças entre o falar manauara e outros falares.");
        q14.setAlternativaC("reverenciam o trabalho feito por pesquisadores brasileiros.");
        q14.setAlternativaD("destacam a descontração no jeito de ser do amazonense.");
        q14.setAlternativaE("valorizam o repertório linguístico do povo do Amazonas.");
        q14.setRespostaCorreta("E");
        databaseHelper.inserirQuestao(q14);

        // Questão 15 -
        Questao q15 = new Questao();
        q15.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q15.setAno(2024);
        q15.setNumero(7);
        q15.setTextoApoio("Conheça histórias de atletas paralímpicas que trocaram de modalidade durante a carreira esportiva Jane Karla: a goiana de 45 anos teve poliomielite aos três anos, o que prejudicou seus movimentos das pernas. Em 2003, iniciou no tênis de mesa e conseguiu conquistar títulos nacionais e internacionais. Mas conheceu o tiro com arco e, em 2015, optou por se dedicar somente à nova modalidade. Em seu ano de estreia no tiro, já faturou a medalha de ouro nos Jogos Parapan-Americanos de Toronto 2015. Elizabeth Gomes: a santista de 55 anos era jogadora de vôlei quando foi diagnosticada com esclerose múltipla em 1993. Ingressou no Movimento Paralímpico pelo basquete em cadeira de rodas até experimentar o atletismo. Chegou a praticar as duas modalidades simultaneamente até optar pelas provas de campo em 2010. No Campeonato Mundial de Atletismo, realizado em Dubai, em 2019, Beth se sagrou campeã do lançamento de disco e estabeleceu um novo recorde mundial da classe F52. Silvana Fernandes: a paraibana de 21 anos é natural de São Bento e nasceu com malformação no braço direito. Aos 15 anos, começou a praticar atletismo no lançamento de dardo. Em 2018, enquanto competia na regional Norte-Nordeste, foi convidada para conhecer o paratae kwon do. No ano seguinte, migrou para a modalidade e já faturou o ouro na categoria até 58 kg nos Jogos Parapan-Americanos de Lima 2019.");
        q15.setFonte("Disponível em: https://cpb.org.br. Acesso em: 15 jan. 2024 (adaptado).");
        q15.setEnunciado("Esse conjunto de minibiografias tem como propósito");
        q15.setAlternativaA("descrever as rotinas de treinamento das atletas.");
        q15.setAlternativaB("comparar os desempenhos de atletas de alto rendimento.");
        q15.setAlternativaC("destacar a trajetória profissional de atletas paralímpicas brasileiras.");
        q15.setAlternativaD("indicar as categorias mais adequadas a adaptações paralímpicas.");
        q15.setAlternativaE("estimular a participação de mulheres em campeonatos internacionais.");
        q15.setRespostaCorreta("C");
        databaseHelper.inserirQuestao(q15);

        // Questão 16 -
        Questao q16 = new Questao();
        q16.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q16.setAno(2024);
        q16.setNumero(8);
        q16.setTextoApoio("É fundamentalmente no Minho, norte de Portugal, que o cavaquinho aparece como instrumento tipicamente popular, ligado às formas essenciais da música característica dessa província. O cavaquinho minhoto tem escala rasa com o tampo, o que facilita a prática do “rasqueado”. O cavaquinho chega ao Brasil diretamente de Portugal, e o modelo brasileiro é maior do que a sua versão portuguesa, com uma caixa de ressonância mais funda. Semelhante ao cavaquinho minhoto, o machete, ou machetinho madeirense, é um pequeno cordófono de corda dedilhada, que faz parte da grande e diversificada família das violas de mão portuguesas. O ukulele tem a sua origem no século XIX, tendo como ancestrais o braguinha (ou machete) e o rajão, instrumentos levados pelos madeirenses quando eles emigraram para o Havaí.");
        q16.setFonte("OLIVEIRA, E. V. Cavaquinhos e família. Disponível em: https://casadaguitarra.pt. Acesso em: 18 nov. 2021 (adaptado).");
        q16.setEnunciado("O conjunto dessas práticas musicais demonstra que os instrumentos mencionados no texto");
        q16.setAlternativaA("refletem a dependência da utilização de matéria-prima europeia.");
        q16.setAlternativaB("adaptam suas características a cada cultura, assumindo nova identidade.");
        q16.setAlternativaC("comprovam a hegemonia portuguesa na invenção de cordófonos dedilhados.");
        q16.setAlternativaD("ilustram processos de dominação cultural, evidenciando situações de choque cultural.");
        q16.setAlternativaE("mantêm nomenclatura própria para garantir a fidelidade às formas originais de confecção.");
        q16.setRespostaCorreta("B");
        databaseHelper.inserirQuestao(q16);

        // Questão 17 -
        Questao q17 = new Questao();
        q17.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q17.setAno(2024);
        q17.setNumero(9);
        q17.setTextoApoio("Pressão, depressão, estresse e crise de ansiedade. Os males da sociedade contemporânea também estão no esporte. A tenista Naomi Osaka, do Japão, jogadora mais bem paga do mundo e que já ocupou o número 2 do ranking, retirou-se do torneio de Roland Garros de 2021 porque não estava conseguindo administrar as crises de ansiedade provocadas pelos grandes eventos, por ser uma estrela aos 23 anos, e pelo peso de parte da imprensa. O tenista australiano Nick Kyrgios, de 25 anos, revelou sua “situação triste e solitária” enquanto lutava contra a depressão causada pelo ritmo avassalador do Circuito Mundial de Tênis. O jogador de basquete americano Kevin Love também tornou público seu quadro de ansiedade e depressão. O mundo do atleta é solitário e distante da família. O que vemos numa partida não reflete a rotina desgastante. A imprensa denomina atletas como heróis, como se aquele corpo fosse indestrutível, mas a mente é o ponto fraco da história.");
        q17.setFonte("Disponível em: www.uol.com.br. Acesso em: 31 out. 2021 (adaptado).");
        q17.setEnunciado("As causas do desequilíbrio na saúde mental apontadas no texto estão relacionadas às");
        q17.setAlternativaA("nacionalidades diversificadas dos praticantes.");
        q17.setAlternativaB("modalidades esportivas distintas.");
        q17.setAlternativaC("faixas etárias aproximadas.");
        q17.setAlternativaD("representações heroicas dos atletas.");
        q17.setAlternativaE("pressões constantes dos eventos e da mídia.");
        q17.setRespostaCorreta("E");
        databaseHelper.inserirQuestao(q17);

        // Questão 18 -
        Questao q18 = new Questao();
        q18.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q18.setAno(2024);
        q18.setNumero(10);
        q18.setTextoApoio("Já ouvi gente falando que o podcast é o renascimento do rádio. O rádio é genial, uma mídia imorredoura, mas podcast não tem nada a ver com ele. O formato está mais próximo do ensaio literário do que de um programa de ondas curtas, médias ou longas. \n" + "Podcasts são antípodas das redes sociais. Enquanto elas são dispersivas, levam à evasão e à desinformação, os podcasts são uma possibilidade de imersão, concentração, aprendizado. Depois que eles surgiram, lavar a louça e me locomover pela cidade viraram um programaço. Um pós-almoço de domingo e aprendo tudo sobre bonobos e gorilas. Um táxi pro aeroporto e chego ao embarque PhD em reforma tributária.");
        q18.setFonte("PRATA, A. Disponível em: www1.folha.uol.com.br. Acesso em: 7 jan. 2024 (adaptado).");
        q18.setEnunciado("Segundo a argumentação construída nesse texto, o podcast");
        q18.setAlternativaA("provoca dispersão da atenção em seu público.");
        q18.setAlternativaB("funciona por meio de uma frequência de ondas curtas.");
        q18.setAlternativaC("propicia divulgação de conhecimento para seus usuários.");
        q18.setAlternativaD("tem um formato de interação semelhante ao das redes sociais.");
        q18.setAlternativaE("constitui uma evolução na transmissão de informações via rádio.");
        q18.setRespostaCorreta("C");
        databaseHelper.inserirQuestao(q18);

        // Questão 19 -
        Questao q19 = new Questao();
        q19.setArea(DatabaseHelper.AREA_HUMANAS);
        q19.setAno(2024);
        q19.setNumero(51);
        q19.setTextoApoio("A valsa vienense é a mais antiga das danças de salão tradicional. É dançada desde a Idade Média, quando os pares davam voltas pelo salão realizando giros em torno de si mesmos em postura fechada. Pelo fato de ser dançada aos pares em contato íntimo, a valsa encantava a sociedade medieval, como também sofria proibições por infringir os “bons costumes”. Originária das danças campestres e folclóricas, no século XVI, a aristocracia francesa abandonou a valsa por sua estreita relação com a cultura plebeia, retomando-a posteriormente.");
        q19.setFonte("FRANCO, N.; FERREIRA, N. Evolução da dança no contexto histórico: aproximações iniciais com o tema. R");
        q19.setEnunciado("A expressão cultural descrita no texto foi rejeitada no início da Idade Moderna por congregar\n");
        q19.setAlternativaA("traços advindos da feitiçaria nórdica.");
        q19.setAlternativaB("práticas inspiradas em rituais pagãos.");
        q19.setAlternativaC("regras decorrentes do período renascentista.");
        q19.setAlternativaD("compassos produzidos em territórios colonizados.\n");
        q19.setAlternativaE("elementos provenientes de segmentos populares.\n");
        q19.setRespostaCorreta("E");
        databaseHelper.inserirQuestao(q19);

        // Questão 20 -
        Questao q20 = new Questao();
        q20.setArea(DatabaseHelper.AREA_HUMANAS);
        q20.setAno(2024);
        q20.setNumero(52);
        q20.setTextoApoio("O Black Lives Matter vai para além do nacionalismo estreito que pode prevalecer no seio das comunidades negras, que se limita a apelar aos negros a amar os negros, viver como os negros e comprar produtos dos negros, e mantém à frente do movimento homens negros heterossexuais. Black Lives Matter estima as vidas dos negros e negras homossexuais e transexuais, pessoas incapacitadas, negros sem documentos ou com antecedentes criminais, mulheres e as vidas de todos os negros de todo o espectro de gêneros.");
        q20.setFonte("LA BOTZ, D. O movimento Black Lives Matter organiza-se e procura definir-se politicamente. Disponível em: www.ufes.br. Acesso em: 4 out. 2021 (adaptado).");
        q20.setEnunciado("A reivindicação do movimento norte-americano apresentada no texto consiste na necessidade de");
        q20.setAlternativaA("manter a conquista de direitos sociais.");
        q20.setAlternativaB("integrar a diversidade do grupo identitário.");
        q20.setAlternativaC("priorizar a preservação de culturas africanas.");
        q20.setAlternativaD("defender a adoção de valores supremacistas.");
        q20.setAlternativaE("permitir a permanência do modelo androcêntrico.");
        q20.setRespostaCorreta("B");
        databaseHelper.inserirQuestao(q20);

        // Questão 21 -
        Questao q21 = new Questao();
        q21.setArea(DatabaseHelper.AREA_HUMANAS);
        q21.setAno(2024);
        q21.setNumero(53);
        q21.setTextoApoio("Diferenças entre inundação gradual e brusca");
        q21.setImagens("questao53_img1_humanas_2024");
        q21.setFonte("TOMINAGA, L. K.; SANTORO, J.; AMARAL, R. Desastres naturais: conhecer para prevenir. São Paulo: Instituto Geológico, 2009 (adaptado)");
        q21.setEnunciado("A desproporção de velocidade e tempo de duração nos tipos de inundação destacados é condicionada pela");
        q21.setAlternativaA("variabilidade solar anual.");
        q21.setAlternativaB("temperatura média mensal.");
        q21.setAlternativaC("declividade do relevo local.");
        q21.setAlternativaD("dinâmica tectônica regional.");
        q21.setAlternativaE("gradação da turbidez fluvial.");
        q21.setRespostaCorreta("C");
        databaseHelper.inserirQuestao(q21);

        // Questão 22 -
        Questao q22 = new Questao();
        q22.setArea(DatabaseHelper.AREA_HUMANAS);
        q22.setAno(2024);
        q22.setNumero(54);
        q22.setTextoApoio("Os grupos dominantes são beneficiados em termos de credibilidade e podem, com isso, controlar falas de membros de outros grupos, descredibilizando seus testemunhos com base em concepções compartilhadas de preconceito de identidade (gênero e raça). Algumas formas de preconceito tornam as declarações das pessoas menos importantes devido ao seu pertencimento a determinado grupo social. Assim, um falante recebe menos credibilidade devido ao preconceito do ouvinte.");
        q22.setFonte("KUHNEN, T. Resenha de The Power and Ethics of Knowing, de Miranda Fricker. Revista Princípios, n. 33, 2013.");
        q22.setEnunciado("Com base na reflexão suscitada no texto, o preconceito de identidade é responsável por um tipo de injustiça");
        q22.setAlternativaA("estética, que normatiza os padrões corporais.");
        q22.setAlternativaB("sensorial, que privilegia as habilidades visuais.");
        q22.setAlternativaC("afetiva, que impede as expressões emocionais.");
        q22.setAlternativaD("epistêmica, que prejudica as trocas informacionais.");
        q22.setAlternativaE("econômica, que perpetua as desigualdades materiais.");
        q22.setRespostaCorreta("D");
        databaseHelper.inserirQuestao(q22);

        // Questão 23 -
        Questao q23 = new Questao();
        q23.setArea(DatabaseHelper.AREA_HUMANAS);
        q23.setAno(2024);
        q23.setNumero(55);
        q23.setTextoApoio("A alma funciona no meu corpo de maneira maravilhosa. Nele se aloja, certamente, mas sabe bem dele escapar: escapa para ver as coisas através da janela dos meus olhos, escapa para sonhar quando durmo, para sobreviver quando morro. Minha alma durará muito tempo e mais que muito tempo, quando meu corpo vier a apodrecer. Viva minha alma! É meu corpo luminoso, purificado, virtuoso, ágil, móvel, tépido, viçoso; é meu corpo liso, castrado, arredondado como uma bolha de sabão.");
        q23.setFonte("FOUCAULT, M. O corpo utópico, as heterotopias. São Paulo: Edições N-1, 2013.");
        q23.setEnunciado("Esse texto reforça uma concepção metafísica clássica que remete a um(a)");
        q23.setAlternativaA("pressuposto lógico.");
        q23.setAlternativaB("pensamento dicotômico.");
        q23.setAlternativaC("contemplação da natureza.");
        q23.setAlternativaD("raciocínio argumentativo.");
        q23.setAlternativaE("crítica à individualidade");
        q23.setRespostaCorreta("B");
        databaseHelper.inserirQuestao(q23);

        // Questão 24 -
        Questao q24 = new Questao();
        q24.setArea(DatabaseHelper.AREA_NATUREZA);
        q24.setAno(2024);
        q24.setNumero(94);
        q24.setTextoApoio("A nimesulida é um fármaco pouco solúvel em água, utilizado como anti-inflamatório, analgésico e antitérmico. Essa substância pode ser convertida em uma espécie eletricamente carregada, de maior solubilidade em água, mediante o tratamento com uma base de Brönsted-Lowry, isto é, uma espécie química capaz de capturar um próton (H+). Na figura são apresentados os grupamentos presentes na estrutura química da nimesulida.");
        q24.setImagens("questao94_img1_natureza_2024");
        q24.setFonte("GONÇALVES, A. A. et al. Contextualizando reações ácido-base de acordo com a teoria protônica de Brönsted-Lowry usando comprimidos de propranolol e nimesulida. Química Nova, n. 3, 2013 (adaptado).");
        q24.setEnunciado("Na estrutura desse fármaco, o grupamento capaz de reagir com a base de Brönsted-Lowry é o grupo");
        q24.setAlternativaA("sulfonamida.");
        q24.setAlternativaB("metila.");
        q24.setAlternativaC("fenila.");
        q24.setAlternativaD("nitro.");
        q24.setAlternativaE("éter.");
        q24.setRespostaCorreta("A");
        databaseHelper.inserirQuestao(q24);

        // Questão 25 -
        Questao q25 = new Questao();
        q25.setArea(DatabaseHelper.AREA_NATUREZA);
        q25.setAno(2024);
        q25.setNumero(95);
        q25.setTextoApoio("O desenvolvimento da biotecnologia e da clonagem gênica em procariotos fez com que a produção de proteínas se tornasse mais intensa, rápida e econômica. Para a produção de hormônios, enzimas e proteínas de resistência a drogas, uma variação da técnica de reação em cadeia pela polimerase (PCR, na sigla em inglês) utiliza a enzima transcriptase reversa (RT-PCR), que sintetiza moléculas de DNA complementares a partir de fitas de RNA.");
        q25.setEnunciado("Nesse contexto, essa técnica é importante para detectar genes");
        q25.setAlternativaA("expressos.");
        q25.setAlternativaB("plasmidiais.");
        q25.setAlternativaC("bacterianos.");
        q25.setAlternativaD("dominantes.");
        q25.setAlternativaE("autossômicos.");
        q25.setRespostaCorreta("A");
        databaseHelper.inserirQuestao(q25);

        // Questão 26 -
        Questao q26 = new Questao();
        q26.setArea(DatabaseHelper.AREA_NATUREZA);
        q26.setAno(2024);
        q26.setNumero(96);
        q26.setTextoApoio("Nos automóveis, é importante garantir que o centro de massa (CM) de cada conjunto roda/pneu coincida com o seu centro geométrico. Esse processo é realizado em uma máquina de balanceamento, na qual o conjunto roda e pneu é colocado para girar a uma velocidade de valor constante. Com base nas oscilações medidas, a máquina indica a posição do centro de massa do conjunto, e pequenas peças de chumbo são fixadas em lugares específicos da roda até que as vibrações diminuam. Durante o treinamento de sua equipe, a fim de corrigir a posição do centro de massa indicada pela máquina, um mecânico apresenta o esquema a seguir, com cinco possíveis pontos da roda para posicionar uma peça de chumbo.");
        q26.setImagens("questao96_im1_natureza_2024");
        q26.setEnunciado("Em qual ponto deve ser fixada a peça de chumbo para corrigir a posição do centro de massa desse conjunto roda/pneu?");
        q26.setAlternativaA("1");
        q26.setAlternativaB("2");
        q26.setAlternativaC("3");
        q26.setAlternativaD("4");
        q26.setAlternativaE("5");
        q26.setRespostaCorreta("C");
        databaseHelper.inserirQuestao(q26);

        // Questão 27 -
        Questao q27 = new Questao();
        q27.setArea(DatabaseHelper.AREA_NATUREZA);
        q27.setAno(2024);
        q27.setNumero(97);
        q27.setTextoApoio1("O soro caseiro serve para combater a desidratação por meio da reposição da água e sais minerais perdidos, por exemplo, por diarreia. Uma receita simples para a sua preparação consiste em utilizar duas colheres grandes (de sopa) de açúcar e duas colheres pequenas (de café) de sal de cozinha, dissolvidos em 2 L de água fervida, obtendo-se uma solução com concentração de íon sódio de 1,4 mg/mL.");
        q27.setTextoApoio2("Considere as massas molares: NaCl = 58,5 g/mol; Na = 23 g/mol.");
        q27.setEnunciado("Qual é o valor mais próximo da massa, em grama, de cloreto de sódio presente em uma única colher pequena?");
        q27.setAlternativaA("0,7 g");
        q27.setAlternativaB("1,8 g");
        q27.setAlternativaC("2,8 g");
        q27.setAlternativaD("3,6 g");
        q27.setAlternativaE("7,0 g");
        q27.setRespostaCorreta("D");
        databaseHelper.inserirQuestao(q27);

        // Questão 28 -
        Questao q28 = new Questao();
        q28.setArea(DatabaseHelper.AREA_NATUREZA);
        q28.setAno(2024);
        q28.setNumero(7);
        q28.setTextoApoio("Apesar de os animais representados no cladograma compartilharem um mesmo ancestral, eles se caracterizam por distintos padrões de reprodução ou de nutrição dos embriões e descendentes.");
        q28.setImagens("questao98_img1_natureza_2024");
        q28.setFonte("DIXSON, A. F. Mammalian Sexuality: The Act of Mating and the Evolution of Reproduction. Disponível em: www.cambridge.org. Acesso em: 2 jul. 2024 (adaptado).");
        q28.setEnunciado("Ao longo do processo evolutivo, percebem-se, entre esses animais, perdas e ganhos nos padrões citados que envolvem o(a)");
        q28.setAlternativaA("aumento no número de descendentes por ninhada.");
        q28.setAlternativaB("mudança no tipo de fecundação de externa para interna.");
        q28.setAlternativaC("redução da versatilidade de reprodução, que se torna unicamente sexuada.");
        q28.setAlternativaD("desenvolvimento embrionário, que passa do meio aquático para o terrestre.");
        q28.setAlternativaE("diminuição da vesícula vitelínica, associada ao desenvolvimento da lactação.");
        q28.setRespostaCorreta("E");
        databaseHelper.inserirQuestao(q28);

        // Questão 29 -
        Questao q29 = new Questao();
        q29.setArea(DatabaseHelper.AREA_NATUREZA);
        q29.setAno(2024);
        q29.setNumero(99);
        q29.setTextoApoio("Uma ambulância em alta velocidade com a sirene ligada desloca-se em direção a um radar operado por uma pessoa. O radar emite ondas de rádio com frequência f 0 que são refletidas pela dianteira da ambulância, retornando para o detector com frequência f r . A percepção do operador do radar, em relação ao som emitido pela sirene, é de que este se altera à medida que a ambulância se aproxima ou se afasta.");
        q29.setEnunciado("Durante a aproximação, como o operador percebe o som da sirene e qual é a relação entre as frequências f r e f 0 medidas pelo radar?");
        q29.setAlternativaA("Mais grave do que o som emitido e f r < f 0.");
        q29.setAlternativaB("Mais agudo do que o som emitido e f r < f 0.");
        q29.setAlternativaC("Mais agudo do que o som emitido e f r = f 0.");
        q29.setAlternativaD("Mais agudo do que o som emitido e f r > f 0.");
        q29.setAlternativaE("Mais grave do que o som emitido e f r > f 0.");
        q29.setRespostaCorreta("D");
        databaseHelper.inserirQuestao(q29);

        // Questão 30 -
        Questao q30 = new Questao();
        q30.setArea(DatabaseHelper.AREA_NATUREZA);
        q30.setAno(2024);
        q30.setNumero(100);
        q30.setTextoApoio("Mirascópio 3D: produtor de ilusão instantânea O equipamento ilustrado na figura, de dimensões apresentadas no esquema, é composto por dois espelhos côncavos E1 e E2, apoiados um sobre o outro por suas bordas, de tal forma que o vértice de E1 coincide com o foco de E2 e vice-versa. Na abertura circular de E2, é formada uma imagem tridimensional de um objeto posicionado sobre o vértice de E1. Essa imagem é formada a partir dos raios procedentes do objeto, refletidos por E2 e E1, respectivamente, conforme o esquema. Os observadores julgam visualizar o objeto quando estão, de fato, visualizando sua imagem. O efeito só é possível porque as superfícies de ambos os espelhos são de extrema qualidade.");
        q30.setImagens("questao100_img1_natureza_2024");
        q30.setFonte("SALZMANN, W. Disponível em: https://wissenstexte.de. Acesso em: 27 jun. 2024 (adaptado).");
        q30.setEnunciado("A natureza da imagem formada e a distância vertical entre cada ponto objeto e seu correspondente ponto imagem são");
        q30.setAlternativaA("real e 5 cm.");
        q30.setAlternativaB("real e 3,8 cm.");
        q30.setAlternativaC("real e 7,6 cm.");
        q30.setAlternativaD("virtual e 7,6 cm.");
        q30.setAlternativaE("virtual e 3,8 cm.");
        q30.setRespostaCorreta("C");
        databaseHelper.inserirQuestao(q30);

        // Questão 31 -
        Questao q31 = new Questao();
        q31.setArea(DatabaseHelper.AREA_MATEMATICA);
        q31.setAno(2024);
        q31.setNumero(136);
        q31.setTextoApoio1("O tamanho mínimo que a visão humana é capaz de visualizar sem o uso de equipamento auxiliar é equivalente a 100 micrômetros (1 micrômetro = 10-3 milímetros). Uma estudante pretende visualizar e analisar hemácias do sangue humano, que medem 0,007 mm de diâmetro. Ela adquiriu um microscópio óptico que tem uma lente ocular que amplia em 10 vezes a imagem do objeto em observação, e um conjunto de lentes objetivas com estas capacidades de ampliação:");
        q31.setTextoApoio2("• lente I: 2 vezes;\n" +
                "• lente II: 10 vezes;\n" +
                "• lente III: 15 vezes;\n" +
                "• lente IV: 1,1 vez;\n" +
                "• lente V: 1,4 vez.");
        q31.setTextoApoio3("O funcionamento desse microscópio permite o uso da lente ocular sozinha ou a combinação dela com uma de suas lentes objetivas, proporcionando, nesse caso, um aumento de sua capacidade de ampliação final, que é dada pelo produto entre as capacidades de ampliação da ocular e da objetiva.");
        q31.setTextoApoio4("Essa estudante pretende selecionar a lente objetiva de menor capacidade de ampliação que permita, na combinação com a ocular, visualizar hemácias do sangue humano.");
        q31.setImagens("questao136_img1_matematica_2024");
        q31.setEnunciado("A lente objetiva a ser selecionada pela estudante é a");
        q31.setAlternativaA("I.");
        q31.setAlternativaB("II.");
        q31.setAlternativaC("III.");
        q31.setAlternativaD("IV");
        q31.setAlternativaE("V.");
        q31.setRespostaCorreta("A");
        databaseHelper.inserirQuestao(q31);

        // Questão 32 -
        Questao q32 = new Questao();
        q32.setArea(DatabaseHelper.AREA_MATEMATICA);
        q32.setAno(2024);
        q32.setNumero(137);
        q32.setTextoApoio("Ao calcular a média de suas notas em 4 provas, um estudante dividiu, por engano, a soma das notas por 5. Com isso, a média obtida foi 1 unidade menor do que deveria ser, caso fosse calculada corretamente.");
        q32.setEnunciado("O valor correto da média das notas desse estudante é");
        q32.setAlternativaA("4.");
        q32.setAlternativaB("5.");
        q32.setAlternativaC("6.");
        q32.setAlternativaD("19.");
        q32.setAlternativaE("21.");
        q32.setRespostaCorreta("B");
        databaseHelper.inserirQuestao(q32);

        // Questão 33 -
        Questao q33 = new Questao();
        q33.setArea(DatabaseHelper.AREA_MATEMATICA);
        q33.setAno(2024);
        q33.setNumero(138);
        q33.setTextoApoio("Para abrir a porta de uma empresa, cada funcionário deve cadastrar uma senha utilizando um teclado alfanumérico como o representado na figura.");
        q33.setImagem("questao138_img1_matematica_2024");
        q33.setTextoApoio1("Por exemplo: a tecla que contém o número 2 traz as letras correlacionadas A, B e C. Cada toque nessa tecla mostra, sequencialmente, os seguintes caracteres: 2, A, B e C. Para os próximos toques, essa sequência se repete. As demais teclas funcionam da mesma maneira.");
        q33.setTextoApoio2("As senhas a serem cadastradas pelos funcionários devem conter 5 caracteres, sendo 2 algarismos distintos seguidos de 3 letras diferentes, nessa ordem. Um funcionário irá cadastrar a sua primeira senha, podendo escolher entre as teclas que apresentam os números 1, 2, 5, 7 e 0 e as respectivas letras correlacionadas, quando houver.");
        q33.setEnunciado("O número de possibilidades diferentes que esse funcionário tem para cadastrar sua senha é");
        q33.setAlternativaA("11520.");
        q33.setAlternativaB("14400.");
        q33.setAlternativaC("18000.");
        q33.setAlternativaD("312000.");
        q33.setAlternativaE("390000");
        q33.setRespostaCorreta("B");
        databaseHelper.inserirQuestao(q33);

        // Questão 34 -
        Questao q34 = new Questao();
        q34.setArea(DatabaseHelper.AREA_MATEMATICA);
        q34.setAno(2024);
        q34.setNumero(139);
        q34.setTextoApoio("Um artesão utiliza dois tipos de componentes, X e Y, nos enfeites que produz. Ele sempre compra todos os componentes em uma mesma loja. O quadro apresenta os preços dos dois tipos de componentes nas lojas I e II.");
        q34.setImagem("questao139_img1_matematica_2024");
        q34.setTextoApoio1("Ele confeccionará enfeites formados por duas unidades do componente X e uma unidade do componente Y e efetuará a compra na loja que oferecer o menor valor total para a confecção de um enfeite.");
        q34.setEnunciado("O artesão efetuará a compra na loja");
        q34.setAlternativaA("I, pois o valor é R$ 7,00.");
        q34.setAlternativaB("I, pois o valor é R$ 4,00.");
        q34.setAlternativaC("II, pois o valor é R$ 6,00.");
        q34.setAlternativaD("I, pois anuncia o componente com o menor preço.");
        q34.setAlternativaE("II, pois o componente X, que é o mais utilizado, tem menor preço.");
        q34.setRespostaCorreta("A");
        databaseHelper.inserirQuestao(q34);

        // Questão 35 -
        Questao q35 = new Questao();
        q35.setArea(DatabaseHelper.AREA_MATEMATICA);
        q35.setAno(2024);
        q35.setNumero(140);
        q35.setTextoApoio("João e Felipe participaram, na escola, de uma maratona de matemática na qual, durante uma semana, resolveram 200 questões cada. Nessa maratona, a porcentagem P de acertos de cada participante é convertida em um conceito:");
        q35.setTextoApoio1("• insatisfatório: se 0 ≤ P < 50;\n" +
                "• regular: se 50 ≤ P < 60;\n" +
                "• bom: se 60 ≤ P < 75;\n" +
                "• muito bom: se 75 ≤ P < 90;\n" +
                "• excelente: se 90 ≤ P ≤ 100.");
        q35.setTextoApoio2("João acertou 75% das questões da maratona e Felipe acertou 30% a menos que a quantidade de questões que João acertou.");
        q35.setEnunciado("Os conceitos de João e Felipe foram, respectivamente,");
        q35.setAlternativaA("muito bom e bom.");
        q35.setAlternativaB("muito bom e regular.");
        q35.setAlternativaC("muito bom e insatisfatório.");
        q35.setAlternativaD("bom e regular.");
        q35.setAlternativaE("bom e insatisfatório.");
        q35.setRespostaCorreta("B");
        databaseHelper.inserirQuestao(q35);

        // Questão 36 -
        Questao q36 = new Questao();
        q36.setArea(DatabaseHelper.AREA_MATEMATICA);
        q36.setAno(2024);
        q36.setNumero(141);
        q36.setTextoApoio("Três grandezas (I, II e III) se relacionam entre si. Os gráficos a seguir, formados por segmentos de reta, descrevem as relações de dependência existentes entre as grandezas I e II, e entre as grandezas II e III.");
        q36.setImagens("questao141_img1_matematica_2024", "questao141_img1_matematica_2024");
        q36.setEnunciado("O valor máximo assumido pela grandeza III, quando a grandeza I varia de 1 a 3, é");
        q36.setAlternativaA("1,0.");
        q36.setAlternativaB("2,5.");
        q36.setAlternativaC("3,0.");
        q36.setAlternativaD("3,5.");
        q36.setAlternativaE("4,0.");
        q36.setRespostaCorreta("B");
        databaseHelper.inserirQuestao(q36);

        // Questão 37 -
        Questao q37 = new Questao();
        q37.setArea(DatabaseHelper.AREA_MATEMATICA);
        q37.setAno(2024);
        q37.setNumero(142);
        q37.setTextoApoio("Uma criança, utilizando um aplicativo, escreveu uma mensagem para enviar a um amigo. Essa mensagem foi escrita seguindo estas etapas:");
        q37.setImagens("questao142_img1_matematica_2024");
        q37.setTextoApoio1("A criança seguiu copiando e colando, em cada etapa, o que tinha no visor na etapa imediatamente anterior, até concluir a 20ª etapa. Em seguida, enviou a mensagem.");
        q37.setEnunciado("Qual foi o total de figuras contidas na mensagem enviada?");
        q37.setAlternativaA("3 × 2^19");
        q37.setAlternativaB("3 × 2^20");
        q37.setAlternativaC("3 × 2^21");
        q37.setAlternativaD("3 × 2^20 − 1");
        q37.setAlternativaE("3 × 2^20 − 3");
        q37.setRespostaCorreta("A");
        databaseHelper.inserirQuestao(q37);

        // Questão 38 -
        Questao q38 = new Questao();
        q38.setArea(DatabaseHelper.AREA_MATEMATICA);
        q38.setAno(2024);
        q38.setNumero(143);
        q38.setTextoApoio("Uma casa de shows terá um evento cujo custo total de produção é de R$ 34 350,00, sendo que comporta 500 pessoas. O preço do ingresso será de R$ 130,00 e, normalmente, 60% das pessoas adquirem meia-entrada, pagando R$ 65,00 pelo ingresso. Além do faturamento proveniente da venda de ingressos, a casa de shows vende, com 60% de lucro, bebidas e petiscos ao público no dia do evento.");
        q38.setTextoApoio1("Após ter vendido todos os 500 ingressos, constatou-se que a quantidade de meias-entradas vendidas superou em 50% o que estava previsto, impactando o faturamento estimado com a venda de ingressos.");
        q38.setTextoApoio2("No dia do evento, decidiu-se manter o percentual de 60% de lucro sobre as bebidas e petiscos, pois todo o público que comprou ingresso compareceu ao show. Com isso, espera-se ter lucro de R$ 17 000,00 nesse evento.");
        q38.setEnunciado("Para que se alcance o lucro esperado, o gasto médio por pessoa com bebidas e petiscos, em real, deverá ser de");
        q38.setAlternativaA("19,50.");
        q38.setAlternativaB("28,80.");
        q38.setAlternativaC("34,00.");
        q38.setAlternativaD("52,00.");
        q38.setAlternativaE("68,70");
        q38.setRespostaCorreta("D");
        databaseHelper.inserirQuestao(q38);

        // Questão 39 -
        Questao q39 = new Questao();
        q39.setArea(DatabaseHelper.AREA_MATEMATICA);
        q39.setAno(2024);
        q39.setNumero(144);
        q39.setTextoApoio("Para obter um sólido de revolução (rotação de 360° em torno de um eixo fixo), uma professora realizou as seguintes etapas:");
        q39.setTextoApoio1("• recortou o trapézio retângulo PQRS de um material rígido;\n" +
                "• afixou o lado PS do trapézio em uma vareta fixa retilínea (eixo de rotação);\n" +
                "• girou o trapézio 360° em torno da vareta e obteve um sólido de revolução.");
        q39.setTextoApoio2("Observe a figura que apresenta o trapézio afixado na vareta e o sentido de giro.");
        q39.setImagens("questao144_img1_matematica_2024");
        q39.setEnunciado("O sólido obtido foi um(a)");
        q39.setAlternativaA("cone.");
        q39.setAlternativaB("cilindro.");
        q39.setAlternativaC("pirâmide.");
        q39.setAlternativaD("tronco de cone.");
        q39.setAlternativaE("tronco de pirâmide.");
        q39.setRespostaCorreta("D");
        databaseHelper.inserirQuestao(q39);

        // Questão 40 -
        Questao q40 = new Questao();
        q40.setArea(DatabaseHelper.AREA_MATEMATICA);
        q40.setAno(2024);
        q40.setNumero(145);
        q40.setTextoApoio("O estádio do Maracanã passou por algumas modificações estruturais para a realização da Copa do Mundo de 2014, como, por exemplo, as dimensões do campo retangular. Para se adaptar aos padrões da Fifa, as dimensões do campo foram reduzidas de 110 m × 75 m para 105 m × 68 m.");
        q40.setFonte("Disponível em: http://virgula.uol.com.br. Acesso em: 14 ago. 2013 (adaptado).");
        q40.setEnunciado("Em quantos metros quadrados a área do campo do Maracanã foi reduzida?");
        q40.setAlternativaA("24");
        q40.setAlternativaB("35");
        q40.setAlternativaC("555");
        q40.setAlternativaD("1110");
        q40.setAlternativaE("1145");
        q40.setRespostaCorreta("D");
        databaseHelper.inserirQuestao(q40);

        Questao q500 = new Questao();
        q500.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q500.setAno(2023);
        q500.setNumero(1);
        q500.setIdiomaEstrangeiro("Inglês");
        q500.addImagem("questao1_img1_linguagens_2023");
        q500.addTextoApoio("The average american tosses 300 pounds of food\n" +
                "each year, making food the number one contributor to\n" +
                "America’s landfills. Eat your leftovers and keep your\n" +
                "perishables in the fridge – the Earth is counting on it.");
        q500.addReferencia("Disponível em: https://mir-s3-cdn-cf.behance.net. Acesso em: 29 out. 2021 (adaptado).");
        q500.addEnunciado("Esse cartaz de campanha sugere que");
        q500.setAlternativaA("os lixões precisam de ampliação. ");
        q500.setAlternativaB("o desperdício degrada o ambiente.");
        q500.setAlternativaC("os mercados doam alimentos perecíveis.");
        q500.setAlternativaD("a desnutrição compromete o raciocínio.");
        q500.setAlternativaE("as residências carecem de refrigeradores.");
        q500.setRespostaCorreta("B");
        databaseHelper.inserirQuestao(q500);

        Questao q501 = new Questao();
        q501.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q501.setAno(2023);
        q501.setNumero(2);
        q501.setIdiomaEstrangeiro("Inglês");
        q501.addTextoApoio("No man is an island,\n" +
                "Entire of itself;\n" +
                "Every man is a piece of the continent,\n" +
                "A part of the main.\n" +
                "[...]\n" +
                "Any man’s death diminishes me,\n" +
                "Because I am involved in mankind.");
        q501.addReferencia("DONNE, J. The Works of John Donne. Londres: John W. Parker, 1839 (fragmento).");
        q501.addEnunciado("Nesse poema, a expressão “No man is an island”ressalta o(a)");
        q501.setAlternativaA("medo da morte.");
        q501.setAlternativaB("ideia de conexão.");
        q501.setAlternativaC("conceito de solidão.");
        q501.setAlternativaD("risco de devastação.");
        q501.setAlternativaE("necessidade de empatia.");
        q501.setRespostaCorreta("B");
        databaseHelper.inserirQuestao(q501);

        Questao q502 = new Questao();
        q502.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q502.setAno(2023);
        q502.setNumero(3);
        q502.setIdiomaEstrangeiro("Inglês");
        q502.addTextoApoio("Things We Carry on the Sea\n \n" +
                "We carry tears in our eyes: good-bye father, good-bye\n" +
                "[mother\n" +
                "We carry soil in small bags: may home never fade in our\n" +
                "[hearts\n" +
                "We carry carnage of mining, droughts, floods, genocides\n" +
                "We carry dust of our families and neighbors incinerated\n" +
                "[in mushroom clouds\n" +
                "We carry our islands sinking under the sea\n" +
                "We carry our hands, feet, bones, hearts and best minds\n" +
                "[for a new life\n" +
                "We carry diplomas: medicine, engineer, nurse,\n" +
                "[education, math, poetry, even if they mean\n" +
                "[nothing to the other shore\n" +
                "We carry railroads, plantations, laundromats,\n" +
                "[bodegas, taco trucks, farms, factories, nursing\n" +
                "[homes, hospitals, schools, temples... built on\n" +
                "[our ancestors’ backs\n" +
                "We carry old homes along the spine, new dreams in our\n" +
                "[chests\n" +
                "We carry yesterday, today and tomorrow\n" +
                "We’re orphans of the wars forced upon us\n" +
                "We’re refugees of the sea rising from industrial wastes\n" +
                "And we carry our mother tongues\n" +
                "[...]\n" +
                "As we drift... in our rubber boats... from shore... to shore...\n" +
                "[to shore...\n");
        q502.addReferencia("PING, W. Disponível em: https://poets.org. Acesso em: 1 jun. 2023 (fragmento).");
        q502.addEnunciado("Ao retratar a trajetória de refugiados, o poema recorre à imagem de viagem marítima para destacar o(a)");
        q502.setAlternativaA("risco de choques culturais.");
        q502.setAlternativaB("impacto do ensino de história");
        q502.setAlternativaC("importância da luta ambiental.");
        q502.setAlternativaD("existência de experiências plurais.");
        q502.setAlternativaE("necessidade de capacitação profissional.");
        q502.setRespostaCorreta("D");
        databaseHelper.inserirQuestao(q502);

        Questao q503 = new Questao();
        q503.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q503.setAno(2023);
        q503.setNumero(4);
        q503.setIdiomaEstrangeiro("Inglês");
        q503.addTextoApoio("Spanglish\n" + "\n" +
                "pues estoy creando Spanglish\n" +
                "bi-cultural systems\n" +
                "scientific lexicographical\n" +
                "inter-textual integrations\n" +
                "two expressions\n" +
                "existentially wired\n" +
                "two dominant languages\n" +
                "continentally abrazándose\n" +
                "in colloquial combate\n" +
                "imperio spanglish emerges\n" +
                "sobre territorio bi-lingual\n" +
                "las novelas mexicanas\n" +
                "mixing with radiorocknroll\n" +
                "immigrant/migrant\n" +
                "nasal mispronouncements\n" +
                "hip-hop, street salsa, spanish pop\n" +
                "standard english classroom\n" +
                "with computer technicalities\n" +
                "spanglish is literally perfect");
        q503.addReferencia("LAVIERA, T. Benedición: The Complete Poetry of Tato Laviera.\n" +
                "Houston: Arte Público Press, 2014 (fragmento).");
        q503.addEnunciado("Nesse poema de Tato Laviera, o eu lírico destaca uma");
        q503.setAlternativaA("convergência linguístico-cultural.");
        q503.setAlternativaB("característica histórico-cultural.");
        q503.setAlternativaC("tendência estilístico-literária.");
        q503.setAlternativaD("discriminação cultural.");
        q503.setAlternativaE("censura musical.");
        q503.setRespostaCorreta("A");
        databaseHelper.inserirQuestao(q503);

        Questao q504 = new Questao();
        q504.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q504.setAno(2023);
        q504.setNumero(5);
        q504.setIdiomaEstrangeiro("Inglês");
        q504.addImagem("questao5_img1_linguagens_2023");
        q504.addTextoApoio("“Oh, you’ll love working here. Nobody treats you any\n" +
                "differently just because of your age, race, or gender.”");
        q504.addReferencia("Disponível em: www.cartoonstock.com. Acesso em: 25 out. 2021.");
        q504.addEnunciado("Ao retratar o ambiente de trabalho em um escritório, esse cartum tem por objetivo");
        q504.setAlternativaA("criticar um padrão de vestimenta.");
        q504.setAlternativaB("destacar a falta de diversidade.");
        q504.setAlternativaC("indicar um modo de interação.");
        q504.setAlternativaD("elogiar um modelo de organização.");
        q504.setAlternativaE("salientar o espírito de cooperação");
        q504.setRespostaCorreta("B");
        databaseHelper.inserirQuestao(q504);

        Questao q505 = new Questao();
        q505.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q505.setAno(2023);
        q505.setNumero(1);
        q505.setIdiomaEstrangeiro("Espanhol");
        q505.addImagem("questao6_img1_linguagens_2023");
        q505.addReferencia("Disponível em: www.otrasvoceseneducacion.org. Acesso em: 8 nov. 2022.");
        q505.addTextoApoio("Ishaan Awashi es un niño de 8 años cuyo mundo está plagado de maravillas que nadie más parece apreciar: colores, peces, perros y cometas, que simplemente no son importantes en la vida de los adultos, que parecen más interesados en cosas como los deberes, las notas o la limpieza. E Ishaan parece no poder hacer nada bien en clase. Cuando los problemas que ocasiona superan a sus padres, es internado en un colegio para que le disciplinen. Las cosas no mejoran en el nuevo colegio, donde Ishaan tiene además que aceptar estar lejos de sus padres. Hasta que un día, el nuevo profesor de arte, Ram Shankar Nikumbh, entra en escena, se interesa por el pequeño Ishaan y todo cambia.");
        q505.addReferencia("Disponível em: https://elfinalde.com. Acesso em: 26 out. 2021 (adaptado).");
        q505.addEnunciado("O filme Como estrellas en la tierra aborda o tema da dislexia. Relacionando o cartaz do filme com a sinopse, constata-se que o(a)");
        q505.setAlternativaA("olhar diferenciado para com o outro gera mudanças.");
        q505.setAlternativaB("estudante com dislexia apresenta um tom questionador");
        q505.setAlternativaC("abordagem para lidar com a dislexia é pautada na disciplina");
        q505.setAlternativaD("contato com os pais prejudica o acompanhamento da dislexia.");
        q505.setAlternativaE("mudança de interesses ocorre na transição da infância para a vida adulta.");
        q505.setRespostaCorreta("A");
        databaseHelper.inserirQuestao(q505);

        Questao q506 = new Questao();
        q506.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q506.setAno(2023);
        q506.setNumero(2);
        q506.setIdiomaEstrangeiro("Espanhol");
        q506.addTextoApoio("Me niego rotundamente\n" +
                "A negar mi voz,\n" +
                "Mi sangre y mi piel.\n" +
                "Y me niego rotundamente\n" +
                "A dejar de ser yo,\n" +
                "A dejar de sentirme bien\n" +
                "Cuando miro mi rostro en el espejo\n" +
                "Con mi boca\n" +
                "Rotundamente grande,\n" +
                "Y mi nariz\n" +
                "Rotundamente hermosa,\n" +
                "Y mis dientes\n" +
                "Rotundamente blancos,\n" +
                "Y mi piel valientemente negra.\n" +
                "Y me niego categóricamente\n" +
                "A dejar de hablar\n" +
                "Mi lengua, mi acento y mi historia.\n" +
                "Y me niego absolutamente\n" +
                "A ser parte de los que callan,\n" +
                "De los que temen,\n" +
                "De los que lloran.\n" +
                "Porque me acepto\n" +
                "Rotundamente libre,\n" +
                "Rotundamente negra,\n" +
                "Rotundamente hermosa.");
        q506.addReferencia("CAMPBELL BARR, S. Disponível em: https://negracubanateniaqueser.com.\n" +
                "Acesso em: 25 out. 2021.\n");
        q506.addEnunciado("Para enfatizar características e atitudes que reforçam a identidade da mulher negra, o poema da escritora costarriquenha apresenta");
        q506.setAlternativaA("advérbios como “rotundamente” e “categóricamente”.");
        q506.setAlternativaB("verbos reflexivos como “me niego” e “me acepto”.");
        q506.setAlternativaC("adjetivos como “grande” e “hermosa”.");
        q506.setAlternativaD("substantivos como “sangre” e “piel”.");
        q506.setAlternativaE("adjetivos possessivos como “mi” e “mis”.");
        q506.setRespostaCorreta("A");
        databaseHelper.inserirQuestao(q506);

        Questao q507 = new Questao();
        q507.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q507.setAno(2023);
        q507.setNumero(3);
        q507.setIdiomaEstrangeiro("Espanhol");
        q507.addTextoApoio("“Caramelos” en sus suelos\n" + "\n" +
                "Las tierras de España, tu vista enamoran; sus gentes; te amistan; ¿“cocinas”?, ¡“te molan”!\n" +
                "¿El plato común?, ¡pues «tortilla/patatas»!; en bares, figones, o tascas, ¡las «tapas»!; “sabor nacional”, ¡el «gazpacho», sus «vinos», «sangría», y «jamón» de sabrosos cochinos! (Cual “sellos”, te grabas sus «Típicos Platos»; ¡sabrás por dó pasas, por sólo tu olfato!, ¡si en cada lugar, un sabor peculiar, “al paso” cautiva tu buen paladar!).\n" +
                "¡Son más que “recetas”!, ¡será “alegoría”!, ¡será “identidad”! (¡hay “reserva” en su «Guía»!); son platos allende un “timón conductor”, ¡son mar, ríos, sierras!, ¡son valles, son flor!, ¡y aportan “Conventos” a gastronomía, sus «dulces»! (sabor “celestial”, ¡de ambrosía!).");
        q507.addReferencia("QUIROZ Y LÓPEZ, M. Disponível em: https://pt.calameo.com. Acesso em: 25 out. 2021.\n");
        q507.addEnunciado("Nesse poema, o eu poético enaltece a");
        q507.setAlternativaA("característica amistosa do povo espanhol.");
        q507.setAlternativaB("beleza das paisagens naturais da Espanha.");
        q507.setAlternativaC("variedade de pratos na gastronomia espanhola.");
        q507.setAlternativaD("relação entre os sentidos do paladar e do olfato na gastronomia.");
        q507.setAlternativaE("gastronomia como representação da identidade cultural de um povo.");
        q507.setRespostaCorreta("E");
        databaseHelper.inserirQuestao(q507);

        Questao q508 = new Questao();
        q508.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q508.setAno(2023);
        q508.setNumero(4);
        q508.setIdiomaEstrangeiro("Espanhol");
        q508.addTextoApoio("Técnicas de manipulación y el resultado\n" + "\n" +
                "Manipular es sembrar en la conciencia y en la mente de la gente ideas, actitudes, conceptos y aspiraciones — incluso falsas e inmorales — que sirvan a los objetivos de sus manipuladores.\n" +
                "Manipular es una de las primeras cosas que aprendemos en la vida. A muy temprana edad, los bebés descubren el poder del llanto, el berrinche, los pataleos, la risa o alguna “gracia” como recursos para demandar atención, exigir comida, pedir ayuda o simplemente mantener ocupada a la gente. Nuestras actitudes de adultos reflejan lo mucho o poco que algunos maduraron, procesaron y rebasaron ese periodo.\n" +
                "Para que exista un manipulador, debe haber una base de ciudadanos indefensos, dóciles, desinformados. El manipulador es celoso, a veces casi paranoico; no admite cuestionamientos ni quiere que nadie ocupe su espacio, sabe que su vigencia depende de presencia controladora. Todos los días, hay que marcar la línea de discurso, incidir en el debate. El ridículo vale la pena si con ello se logra una cortina de humo.");
        q508.addReferencia("Disponível em: www.forbes.com.mx. Acesso em: 7 out. 2021 (adaptado)");
        q508.addEnunciado("Nesse texto, a expressão “cortina de humo” revela que o manipulador");
        q508.setAlternativaA("amadurece tardiamente");
        q508.setAlternativaB("busca mascarar a verdade.");
        q508.setAlternativaC("rejeita questionamentos alheios.");
        q508.setAlternativaD("aproxima-se de pessoas indefesas");
        q508.setAlternativaE("faz-se presente de forma controladora.");
        q508.setRespostaCorreta("B");
        databaseHelper.inserirQuestao(q508);

        Questao q509 = new Questao();
        q509.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q509.setAno(2023);
        q509.setNumero(5);
        q509.setIdiomaEstrangeiro("Espanhol");
        q509.addTextoApoio("Que quede claro\n" + "n" +
                "Cómo es posible que se cierren\n" +
                "tantas bocas, tantos ojos,\n" +
                "tantas puertas, muchas mentes ante un\n" +
                "acto xenofóbico sin precedentes.\n" + "n" +
                "Presidentes, ministros, cancilleres,\n" +
                "autoridades, responsables.\n" +
                "¿Quién pagará el daño causado a familiares?\n" +
                "Por un loco del estrada sin modales. [...]\n" + "n" +
                "Se alejó de aquel lugar donde su color era\n" +
                "mucho más que su color, era su raza.\n" +
                "Persiguiendo un sueño que desapareció,\n" +
                "que se fusionó y terminó en una pesadilla. [...]\n" + "n" +
                "Déjame que te cuente esta historia\n" +
                "que sucedió en el metro de Barcelona,\n" +
                "cuando aquella mañana la injusticia\n" +
                "y xenofobia se juntaron de la mano,\n" +
                "protagonizando una de las más feas escenas de racismo.\n" + "n" +
                "En aquel vagón viajaba un ángel de color diferente,\n" +
                "en su camino se interpuso aquel inconsciente,\n" +
                "que aún sabiendo lo que hacía,\n" +
                "seguía hablando con su gente.\n" + "n" +
                "Le dio al ángel dos patadas en su cara,\n" +
                "se rió de ella sin cambiar la mirada.\n" +
                "Y aún anda suelto, aún anda suelto...");
        q509.addReferencia("ORISHAS. In: Cosita buena. Delaware: Suerte Publishing LLC, 2008 (fragmento).\n");
        q509.addEnunciado("A letra da canção Que quede claro, da banda cubana Orishas, revela o(a)");
        q509.setAlternativaA("indignação diante do desrespeito à diversidade.");
        q509.setAlternativaB("violência característica das grandes metrópoles.");
        q509.setAlternativaC("preconceito da sociedade com relação ao misticismo.");
        q509.setAlternativaD("descuido da população com os sonhos dos imigrantes.");
        q509.setAlternativaE("falta de segurança existente no transporte público urbano.");
        q509.setRespostaCorreta("A");
        databaseHelper.inserirQuestao(q509);

        Questao q510 = new Questao();
        q510.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q510.setAno(2023);
        q510.setNumero(6);
        q510.addTextoApoio("A sessão do Comitê Olímpico Internacional (COI) aprovou uma mudança histórica e inédita no lema olímpico, criado em 1894 pelo Barão Pierre de Coubertin para expressar os valores e a excelência do esporte. Mais de 120 anos depois, o lema tem sua primeira alteração para ressaltar a solidariedade e incluir a palavra “juntos”: mais rápido, mais alto, mais forte — juntos. A mudança foi aprovada por unanimidade pelos membros do COI e celebrada pelo presidente da entidade.");
        q510.addReferencia("Disponível em: https://ge.globo.com. Acesso em: 10 nov. 2021 (adaptado)");
        q510.setEnunciado("De acordo com o texto, a alteração do lema olímpico teve como objetivo a");
        q510.setAlternativaA("unificação do lema anterior ao atual.");
        q510.setAlternativaB("aproximação entre o lema olímpico e o COI.");
        q510.setAlternativaC("junção do lema olímpico com os princípios esportivos.");
        q510.setAlternativaD("associação entre o lema olímpico e a cooperatividade.");
        q510.setAlternativaE("vinculação entre o lema olímpico e os eventos atléticos.");
        q510.setRespostaCorreta("D");
        databaseHelper.inserirQuestao(q510);

        Questao q511 = new Questao();
        q511.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q511.setAno(2023);
        q511.setNumero(7);
        q511.addTextoApoio("Mais iluminada que outras\n" + "\n" +
                "Tenho dois seios, estas duas coxas, duas mãos que me são muito úteis, olhos escuros, estas duas sobrancelhas que preencho com maquiagem comprada por dezenove e noventa e orelhas que não aceitam bijuterias. Este corpo é um corpo\n" +
                "faminto, dentado, cruel, capaz e violento. Movo os braços e multidões correm desesperadas. Caminho no escuro com o rosto para baixo, pois cada parte isolada de mim tem sua própria vida e não quero domá-las. Animal da caatinga. Forte demais. Engolidora de espadas e espinhos.\n" +
                "Dizem e eu ouvi, mas depois também li, que o estado do Ceará aboliu a escravidão quatro anos antes do restante do país. Todos aqueles corpos que eram trazidos com seus dedos contados, seus calcanhares prontos e seus umbigos em fogo, todos eles foram interrompidos no porto. Um homem — dizem e eu ouvi e depois também li — liderou o levante. E todos esses corpos foram buscar outros incômodos. Foram ser incomodados.");
        q511.addReferencia("ARRAES, J. Redemoinho em dia quente. São Paulo: Alfaguara, 2019.");
        q511.setEnunciado("Nesse texto, os recursos expressivos usados pela narradora");
        q511.setAlternativaA("revelam as marcas da violência de raça e de gênero na construção da identidade.");
        q511.setAlternativaB("questionam o pioneirismo do estado do Ceará no enfrentamento à escravidão.");
        q511.setAlternativaC("reproduzem padrões estéticos em busca da valorização da autoestima feminina.");
        q511.setAlternativaD("sugerem uma atmosfera onírica alinhada ao desejo de resgate da espiritualidade.");
        q511.setAlternativaE("mimetizam, na paisagem, os corpos transformados pela violência da escravidão.");
        q511.setRespostaCorreta("A");
        databaseHelper.inserirQuestao(q511);

        Questao q512 = new Questao();
        q512.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q512.setAno(2023);
        q512.setNumero(8);
        q512.addTextoApoio("De quem é esta língua?\n" + "\n" +
                "Uma pequena editora brasileira, a Urutau, acaba de lançar em Lisboa uma “antologia antirracista de poetas estrangeiros em Portugal”, com o título Volta para a tua terra.\n" +
                "O livro denuncia as diversas formas de racismo a que os imigrantes estão sujeitos. Alguns dos poetas brasileiros\n" +
                "antologiados queixam-se do desdém com que um grande número de portugueses acolhe o português brasileiro. É uma queixa frequente.\n" +
                "“Aqui em Portugal eles dizem / — eles dizem — / que nosso português é errado, que nós não falamos português”, escreve a poetisa paulista Maria Giulia Pinheiro, para concluir: “Se a sua linguagem, a lusitana, / ainda conserva a palavra da opressão / ela não é a mais bonita do mundo./ Ela é uma das mais violentas”.");
        q512.addReferencia("AGUALUSA, J. E. Disponível em: https://oglobo.globo.com.  Acesso em: 22 nov. 2021 (adaptado).");
        q512.setEnunciado("O texto de Agualusa tematiza o preconceito em relação ao português brasileiro. Com base no trecho citado pelo autor, infere-se que esse preconceito se deve");
        q512.setAlternativaA("à dificuldade de consolidação da literatura brasileira em outros países.");
        q512.setAlternativaB("aos diferentes graus de instrução formal entre os falantes de língua portuguesa");
        q512.setAlternativaC("à existência de uma língua ideal que alguns falantes lusitanos creem ser a falada em Portugal.");
        q512.setAlternativaD("ao intercâmbio cultural que ocorre entre os povos dos diferentes países de língua portuguesa.");
        q512.setAlternativaE("à distância territorial entre os falantes do português que vivem em Portugal e no Brasil.");
        q512.setRespostaCorreta("c");
        databaseHelper.inserirQuestao(q512);

        Questao q513 = new Questao();
        q513.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q513.setAno(2023);
        q513.setNumero(9);
        q513.addTextoApoio("Na Idade Média, as notícias se propagavam com surpreendente eficácia.Segundo uma emérita professora de Sorbonne, um cavalo era capaz de percorrer 30 quilômetros por dia, mas o tempo podia se acelerar dependendo do interesse da notícia. As ordens mendicantes tinham um papel importante na disseminação de informações, assim como os jograis, os peregrinos e os vagabundos, porque todos eles percorriam grandes distâncias. As cidades também tinham correios organizados e selos para lacrar mensagens e tentar certificar a veracidade das correspondências. Graças a tudo isso, a circulação de boatos era intensa e politicamente relevante. Um exemplo clássico de fake news da era medieval é a história do rei que desaparece na batalha e reaparece muito depois, idoso e transformado.");
        q513.addReferencia("Disponível em: www.elpais.com.br. Acesso em: 18 jun. 2018 (adaptado).");
        q513.setEnunciado("A propagação sistemática de informações é um fenômeno recorrente na história e no desenvolvimento das sociedades. No texto, a eficácia dessa propagação está diretamente relacionada ao(à)");
        q513.setAlternativaA("velocidade de circulação das notícias");
        q513.setAlternativaB("nível de letramento da população marginalizada.");
        q513.setAlternativaC("poder de censura por parte dos serviços públicos.");
        q513.setAlternativaD("legitimidade da voz dos representantes da nobreza.");
        q513.setAlternativaE("diversidade dos meios disponíveis em uma época histórica.");
        q513.setRespostaCorreta("E");
        databaseHelper.inserirQuestao(q513);

        Questao q514 = new Questao();
        q514.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q514.setAno(2023);
        q514.setNumero(10);
        q514.addTextoApoio("Se a interferência de contas falsas em discussões políticas nas redes sociais já representava um perigo para os sistemas democráticos, sua sofisticação e maior semelhança com pessoas reais têm agravado o problema pelo mundo.\n" +
                "O perigo cresceu porque a tecnologia e os métodos evoluíram dos robôs, os “bots” — softwares com tarefas on-line automatizadas —, para os “ciborgues” ou “trolls”, contas controladas diretamente por humanos com ajuda de um pouco de automação.\n" +
                "Mas pesquisadores começam agora a observar outros padrões de comportamento: quando mensagens não são programadas, sua publicação se concentra só em horários de trabalho, já que é controlada por pessoas cuja profissão é exatamente essa, administrar um perfil falso durante o dia.\n" +
                "Outra pista: a pobreza vocabular das mensagens publicadas por esses perfis. Um funcionário de uma empresa que supostamente produzia e vendia perfis falsos explica que às vezes “faltava criatividade” para criar mensagens distintas controlando tantos perfis falsos ao mesmo tempo");
        q514.addReferencia("GRAGNANI, J. Disponível em: www.bbc.com. Acesso em: 16 dez. 2017.");
        q514.setEnunciado("De acordo com o texto, a análise de características da linguagem empregada por perfis automatizados contribui para o(a)");
        q514.setAlternativaA("controle da atuação dos profissionais de TI.");
        q514.setAlternativaB("desenvolvimento de tecnologias como os “trolls”.");
        q514.setAlternativaC("flexibilização dos turnos de trabalho dos controladores.");
        q514.setAlternativaD("necessidade de regulamentação do funcionamento dos “bots”.");
        q514.setAlternativaE("identificação de padrões de disseminação de informações inverídicas.");
        q514.setRespostaCorreta("E");
        databaseHelper.inserirQuestao(q514);

        Questao q515 = new Questao();
        q515.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q515.setAno(2023);
        q515.setNumero(11);
        q515.addTextoApoio("Maio foi colorido de amarelo, e o foi porque mundialmente amarelo é a cor convencionada para as advertências. No trânsito, essas advertências têm sido fatais. A estimativa, caso nada seja feito, é a de que se atinjam assustadoras 2,4 milhões de mortes no trânsito em 2030 em todo o mundo.\n" +
                "A pressa constante, o sentimento de invencibilidade, a certeza de invulnerabilidade, a necessidade de poder, a falta de civilidade, a certeza de impunidade, a ausência de solidariedade, a inexistência de compaixão e o desrespeito por si próprio são circunstâncias reais que, não raro, concorrem para o comportamento violento no trânsito.\n" +
                "O Maio Amarelo, que preconiza a atenção pela vida, é uma das iniciativas nesse sentido. E é precisamente a atenção pela vida que está esquecida. Essa atenção, por certo, requer menos pressa, mais civilidade, limites assegurados, consciência de vulnerabilidade, solidariedade, compaixão e respeito por si e pelo outro. Reafirmar e praticar esses princípios e valores talvez seja um caminho mais seguro e menos violento, que garanta a vida e não celebre a morte.");
        q515.addReferencia("Disponível em: http://portaldotransito.com.br. Acesso em: 11 dez. 2018 (adaptado)");
        q515.setEnunciado("Considerando os procedimentos argumentativos utilizados, infere-se que o objetivo desse texto é");
        q515.setAlternativaA("enumerar as causas determinantes da violência no trânsito.");
        q515.setAlternativaB("contextualizar a campanha de advertência no cenário mundial.");
        q515.setAlternativaC("divulgar dados numéricos alarmantes sobre acidentes de trânsito.");
        q515.setAlternativaD("sensibilizar o público para a importância de uma direção responsável.");
        q515.setAlternativaE("restringir os problemas da violência no trânsito a aspectos emocionais.");
        q515.setRespostaCorreta("D");
        databaseHelper.inserirQuestao(q515);

        Questao q516 = new Questao();
        q516.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q516.setAno(2023);
        q516.setNumero(12);
        q516.addTextoApoio("Ainda daquela vez pude constatar a bizarrice dos costumes que constituíam as leis mais ou menos constantes do seu mundo: ao me aproximar, verifiquei que o Sr. Timóteo, gordo e suado, trajava um vestido de franjas e lantejoulas que pertencera a sua mãe. O corpete descia-lhe excessivamente justo na cintura, e aqui e ali rebentava através da costura um pouco da carne aprisionada, esgarçando a fazenda e tornando o prazer de vestir-se daquele modo uma autêntica espécie de suplício. Movia-se ele com lentidão, meneando todas as suas franjas e abanando-se vigorosamente com um desses leques de madeira de sândalo, o que o envolvia numa enjoativa onda de perfume. Não sei direito o que colocara sobre a cabeça, assemelhava-se mais a um turbante ou a um chapéu sem abas de onde saíam vigorosas mechas de cabelos alourados. Como era costume seu também, trazia o rosto pintado — e para isto, bem como para suas vestimentas, apoderara-se de todo o guarda-roupa deixado por sua mãe, também em sua época famosa pela extravagância com que se vestia — o que sem dúvida fazia sobressair-lhe o nariz enorme, tão característico da família Meneses.");
        q516.addReferencia("CARDOSO, L. Crônica da casa assassinada. São Paulo: Círculo do Livro, s.d");
        q516.setEnunciado("Pela voz de uma empregada da casa, a descrição de um dos membros da família exemplifica a renovação da ficção urbana nos anos 1950, aqui observada na");
        q516.setAlternativaA("opção por termos e expressões de sentido ambíguo.");
        q516.setAlternativaB("crítica social inspirada pelo convívio com os patrões.");
        q516.setAlternativaC("descrição impressionista do fetiche do personagem.");
        q516.setAlternativaD("presença de um foco narrativo de caráter impreciso.");
        q516.setAlternativaE("ambiência de mistério das relações entre familiares.");
        q516.setRespostaCorreta("C");
        databaseHelper.inserirQuestao(q516);

        Questao q517 = new Questao();
        q517.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q517.setAno(2023);
        q517.setNumero(13);
        q517.addTextoApoio("Girassol da madrugada\n" + "\n" +
                "Teu dedo curioso me segue lento no rosto\n" +
                "Os sulcos, as sombras machucadas por onde a\n" +
                "[vida passou.\n" +
                "Que silêncio, prenda minha... Que desvio triunfal\n" +
                "[da verdade,\n" +
                "Que círculos vagarosos na lagoa em que uma asa\n" +
                "[gratuita roçou...\n" +
                "Tive quatro amores eternos...\n" +
                "O primeiro era moça donzela,\n" +
                "O segundo... eclipse, boi que fala, cataclisma,\n" +
                "O terceiro era a rica senhora,\n" +
                "O quarto és tu... E eu afinal me repousei dos\n" +
                "[meus cuidados");
        q517.addReferencia("ANDRADE, M. Poesias completas. Rio de Janeiro: Nova Fronteira, 2013 (fragmento).");
        q517.setEnunciado("Perante o outro, o eu lírico revela, na força das memórias evocadas, a");
        q517.setAlternativaA("vergonha das marcas provocadas pela passagem do tempo.");
        q517.setAlternativaB("indecisão em face das possibilidades afetivas do presente.");
        q517.setAlternativaC("serenidade sedimentada pela entrega pacífica ao desejo.");
        q517.setAlternativaD("frustração causada pela vontade de retorno ao passado.");
        q517.setAlternativaE("disponibilidade para a exploração do prazer efêmero.");
        q517.setRespostaCorreta("C");
        databaseHelper.inserirQuestao(q517);

        Questao q518 = new Questao();
        q518.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q518.setAno(2023);
        q518.setNumero(14);
        q518.addTextoApoio("Dão Lalalão\n" + "\n" + "Do povoado do Ão, ou dos sítios perto, alguém precisava urgente de querer vir por escutar a novela do rádio. Ouvia-a, aprendia-a, guardava na ideia, e, retornado ao Ão, no dia seguinte, a repetia a outros.\n" +
                "Assim estavam jantando, vinham os do povoado receber a nova parte da novela do rádio. Ouvir já tinham ouvido tudo, de uma vez, fugia da regra: falhara ali no Ão, na véspera, o caminhão de um comprador de galinhas e ovos, seo Abrãozinho Buristém, que carregava um rádio pequeno, de pilhas, armara um fio no arame da cerca... Mas queriam escutar outra vez, por confirmação. — “A estória é estável de boa, mal que acompridada: taca e não rende...” — explicava o Zuz ao Dalberto.\n" +
                "Soropita começou a recontar o capítulo da novela. Sem trabalho, se recordava das palavras, até com clareza — disso se admirava. Contava com prazer de demorar, encher a sala com o poder de outros altos personagens. Tomar a atenção de todos, pudesse contar aquilo noite adiante. Era preciso trazer luz, nem uns enxergavam mais os outros; quando alguém ria, ria de muito longe. O capítulo da novela estava terminando");
        q518.addReferencia("ROSA, J. G. Noites do sertão (Corpo de baile). São Paulo: Global, 2021.\n");
        q518.setEnunciado("Nesse trecho do conto, o gosto dos moradores do povoado por ouvir a novela de rádio recontada por Soropita deve-se ao(à)");
        q518.setAlternativaA("qualidade do som do rádio.");
        q518.setAlternativaB("estabilidade do enredo contado");
        q518.setAlternativaC("ineditismo do capítulo da novela.");
        q518.setAlternativaD("jeito singular de falar aos ouvintes");
        q518.setAlternativaE("dificuldade de compreensão da história.");
        q518.setRespostaCorreta("D");
        databaseHelper.inserirQuestao(q518);

        Questao q519 = new Questao();
        q519.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q519.setAno(2023);
        q519.setNumero(15);
        q519.addTextoApoio("As cinzas do Museu Nacional, no Rio de Janeiro, consumido pelas chamas no mês de setembro de 2018, são mais do que restos de fósseis, cerâmicas e espécimes raros. O museu abrigava, entre mais de 20 milhões de peças, os esqueletos com as respostas para perguntas que ainda não haviam sido respondidas — ou sequer feitas — por pesquisadores brasileiros. E o incêndio pode ter calado para sempre palavras e cantos indígenas ancestrais, de línguas que não existem mais no mundo.\n" +
                "O acervo do local continha gravações de conversas, cantos e rituais de dezenas de sociedades indígenas, muitas feitas durante a década de 1960 com antigos gravadores de rolo e que ainda não haviam sido digitalizadas. Alguns dos registros abordavam línguas já extintas, sem falantes originais ainda vivos. “A esperança é que outras instituições tenham registros dessas línguas”, diz a linguista Marilia Facó Soares. A pesquisadora, que trabalha com os índios Tikuna, o maior grupo da Amazônia brasileira, crê ter perdido parte de seu material. “Terei que fazer novas viagens de campo para recompor meus arquivos. Mas obviamente não dá para recuperar a fala de nativos já falecidos, geralmente os mais idosos”, lamenta.");
        q519.addReferencia("Disponível em: https://brasil.elpais.com. Acesso em: 10 dez. 2018 (adaptado)");
        q519.setEnunciado("A perda dos registros linguísticos no incêndio do Museu Nacional tem impacto potencializado, uma vez que");
        q519.setAlternativaA("exige a retomada das pesquisas por especialistas de diferentes áreas");
        q519.setAlternativaB("representa danos irreparáveis à memória e à identidade nacionais.");
        q519.setAlternativaC("impossibilita o surgimento de novas pesquisas na área");
        q519.setAlternativaD("resulta na extinção da cultura de povos originários.");
        q519.setAlternativaE("inviabiliza o estudo da língua do povo Tikuna.");
        q519.setRespostaCorreta("B");
        databaseHelper.inserirQuestao(q519);

        Questao q520 = new Questao();
        q520.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q520.setAno(2023);
        q520.setNumero(16);
        q520.addTextoApoio("Mandioca, macaxeira, aipim e castelinha são nomes diferentes da mesma planta. Semáforo, sinaleiro e farol também significam a mesma coisa. O que muda é só o hábito cultural de cada região. A mesma coisa acontece com a Língua Brasileira de Sinais (Libras). Embora ela seja a comunicação oficial da comunidade surda no Brasil, existem sinais que variam em relação à região, à idade e até ao gênero de quem se comunica. A cor verde, por exemplo,\n" +
                "possui sinais diferentes no Rio de Janeiro, Paraná e São Paulo. São os regionalismos na língua de sinais.\n" +
                "Essas variações são um dos temas da disciplina Linguística na língua de sinais, oferecida pela Universidade Estadual Paulista (Unesp) ao longo do segundo semestre. “Muitas pessoas pensam que a língua de sinais é universal, o que não é verdade”, explica a professora e chefe do Departamento de Linguística, Literatura e Letras Clássicas da Unesp. “Mesmo dentro de um mesmo país, ela sofre variação em relação à localização geográfica, à faixa etária e até ao gênero dos usuários”, completa a especialista.\n" +
                "Os surdos podem criar sinais diferentes para identificar lugares, objetos e conceitos. Em São Paulo, o sinal de “cerveja” é feito com um giro do punho como uma meia-volta. Em Minas, a bebida é citada quando os dedos indicador e médio batem no lado do rosto. Também ocorrem mudanças históricas. Um sinal pode sofrer alterações decorrentes dos costumes da geração que o utiliza.");
        q520.addReferencia("Disponível em: www.educacao.sp.gov.br. Acesso em: 1 nov. 2021 (adaptado)");
        q520.setEnunciado("Nesse texto, a Língua Brasileira de Sinais (Libras)");
        q520.setAlternativaA("passa por fenômenos de variação linguística como qualquer outra língua.");
        q520.setAlternativaB("apresenta variações regionais, assumindo novo sentido para algumas palavras.");
        q520.setAlternativaC("sofre mudança estrutural motivada pelo uso de sinais diferentes para algumas palavras.");
        q520.setAlternativaD("diferencia-se em todo o Brasil, desenvolvendo cada região a sua própria língua de sinais.");
        q520.setAlternativaE("é ininteligível para parte dos usuários em razão das mudanças de sinais motivadas geograficamente.");
        q520.setRespostaCorreta("A");
        databaseHelper.inserirQuestao(q520);

        Questao q521 = new Questao();
        q521.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q521.setAno(2023);
        q521.setNumero(17);
        q521.addTextoApoio("Como é bom reencontrar os leitores da Revista da Cultura por meio de uma publicação com outro visual, conteúdo de qualidade e interesses ampliados! ]cultura[, este nome simples, e eu diria mesmo familiar, nasce entre dois colchetes voltados para fora. E não é por acaso: são sinais abertos, receptivos, propícios à circulação de ideias. O DNA da publicação se mantém o mesmo, afinal, por longos anos montamos nossas edições com assuntos saídos das estantes de uma grande livraria — e assim continuará sendo. Literatura, sociologia, filosofia, artes... nunca será difícil montar a pauta da revista porque os livros nos ensinam que monotonia é só para quem não lê.");
        q521.addReferencia("HERZ, P. ]cultura[, n. 1, jun. 2018 (adaptado).");
        q521.setEnunciado("O uso não padrão dos colchetes para nomear a revista atribui-lhes uma nova função e está correlacionado ao(à)");
        q521.setAlternativaA("perfil de público-alvo, constituído por leitores exigentes e especializados em leitura acadêmica.");
        q521.setAlternativaB("propósito do editor, chamando a atenção para o rigor normativo nos textos da revista.");
        q521.setAlternativaC("exclusividade na seleção temática, direcionada para a área das ciências humanas.");
        q521.setAlternativaD("identidade da revista, voltada para a recepção e a promoção de ideias circulantes em livros.");
        q521.setAlternativaE("padrão editorial dos artigos, organizados em torno de uma proposta de design inovador.");
        q521.setRespostaCorreta("D");
        databaseHelper.inserirQuestao(q521);

        Questao q522 = new Questao();
        q522.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q522.setAno(2023);
        q522.setNumero(18);
        q522.addTextoApoio("TEXTO 1: Alegria, alegria");
        q522.addTextoApoio("O sol nas bancas de revista\n" +
                "Me enche de alegria e preguiça\n" +
                "Quem lê tanta notícia\n" +
                "Eu vou\n" +
                "Por entre fotos e nomes\n" +
                "Os olhos cheios de cores\n" +
                "O peito cheio de amores vãos\n" +
                "Eu vou\n" +
                "Por que não, por que não?");
        q522.addReferencia("VELOSO, C. Alegria, alegria. Rio de Janeiro: Polygram, 1990 (fragmento)");
        q522.addTextoApoio("Anjos tronchos");
        q522.addTextoApoio("Uns anjos tronchos do Vale do Silício\n" +
                "Desses que vivem no escuro em plena luz\n" +
                "Disseram vai ser virtuoso no vício\n" +
                "Das telas dos azuis mais do que azuis\n" +
                "Agora a minha história é um denso algoritmo\n" +
                "Que vende venda a vendedores reais\n" +
                "Neurônios meus ganharam novo outro ritmo\n" +
                "E mais, e mais, e mais, e mais, e mais");
        q522.addReferencia("VELOSO, C. Meu coco. Rio de Janeiro: Sony, 2021 (fragmento)");
        q522.setEnunciado("Embora oriundas de momentos históricos diferentes, essas letras de canção têm em comum a");
        q522.setAlternativaA("referência às cores como elemento de crítica a hábitos contemporâneos.");
        q522.setAlternativaB("percepção da profusão de informações gerada pela tecnologia.");
        q522.setAlternativaC("contraposição entre os vícios e as virtudes da vida moderna.");
        q522.setAlternativaD("busca constante pela liberdade de expressão individual.");
        q522.setAlternativaE("crítica à finalidade comercial das notícias.");
        q522.setRespostaCorreta("B");
        databaseHelper.inserirQuestao(q522);

        Questao q523 = new Questao();
        q523.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q523.setAno(2023);
        q523.setNumero(19);
        q523.addTextoApoio("“São tantas formas de matar um preto\n" +
                "Que para alguns sua morte é justificada\n" +
                "Devia tá fazendo coisa errada\n" +
                "Se não era bandido, um dia ia ser\n" +
                "Por ser PRETO sua morte é defendida\n" +
                "O PRETO sempre merece morrer”.");
        q523.addTextoApoio("A estrofe acima é do poeta e educador social Baticum Proletário, que atua na periferia de Fortaleza, no Ceará, preparando jovens — em quase sua totalidade negros — para enfrentar as dificuldades impostas pelo racismo estrutural no país.\n" +
                "É a partir da arte que Baticum consegue envolver a juventude em um projeto de fortalecimento dessa população ao promover batalhas de rimas, slams e saraus com temáticas que discutem os problemas sociais. Não por acaso, o tema mais explorado nas rimas, versos e prosas é a violência. De acordo com o mais recente Atlas da violência, em 2019, os negros representaram 77% das vítimas de homicídios, quase 30 assassinatos por 100 mil habitantes, a maioria deles jovens.\n" +
                "O Atlas revela ainda que um negro tem quase 2,7 vezes mais chance de ser morto do que um branco, o que justifica o movimento de resistência crescente no Brasil.");
        q523.addReferencia("MENDONÇA, F. Disponível em: www.cartacapital.com.br. Acesso em: 22 nov. 2021 (adaptado)");
        q523.setEnunciado("O uso de citação e de dados estatísticos nesse texto tem o objetivo de");
        q523.setAlternativaA("ressaltar a importância da poesia para denunciar a morte de negros, que cresce a cada dia.");
        q523.setAlternativaB("destacar o crescimento exponencial da temática do preconceito na produção literária no Brasil.");
        q523.setAlternativaC("demonstrar o incremento no quantitativo de expressões artísticas na discussão de problemas sociais.");
        q523.setAlternativaD("evidenciar argumentos que reforçam a ideia de que os negros são vítimas em potencial da violência.");
        q523.setAlternativaE("salientar o aumento da participação de jovens nos movimentos de resistência na área da cultura.");
        q523.setRespostaCorreta("D");
        databaseHelper.inserirQuestao(q523);

        Questao q524 = new Questao();
        q524.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q524.setAno(2023);
        q524.setNumero(20);
        q524.addTextoApoio("No princípio era o verbo. A frase que abre o primeiro capítulo do Evangelho de João e remete à criação do mundo, assim como também faz o Gênesis, é a mais famosa da Bíblia. A ideia de que o mundo é criado pela palavra, porém, é tão estruturante que está presente em outras religiões, para muito além das fundadas no cristianismo. Como humanos, a linguagem é o mundo que habitamos. Basta tentar imaginar um mundo em que não podemos usar palavras para dizer de nós e dos outros para compreender o que isso significa. Ou um mundo em que aquilo que você diz não é entendido pelo outro, e o que o outro diz não é entendido por você.\n" +
                "O que acontece então quando a palavra é destruída e, com ela, a linguagem?\n" +
                "Durante séculos, em diferentes sociedades e línguas, é importante lembrar, a linguagem serviu — e ainda serve — para manter privilégios de grupos de poder e deixar todos os outros de fora. Quem entende linguagem de advogados, juízes e promotores, linguagem de médicos, linguagem de burocratas, linguagem de cientistas? A maior parte da população foi submetida à violência de propositalmente ser impedida de compreender a linguagem daqueles que determinam seus destinos.\n" +
                "Se o princípio é o verbo, o fim pode ser o silenciamento. Mesmo que ele seja cheio de gritos entre aqueles que já não têm linguagem comum para compreender uns aos outros.");
        q524.addReferencia("BRUM, E. Disponível em: https://brasil.elpais.com. Acesso em: 5 nov. 2021.");
        q524.setEnunciado("Nesse texto, a estratégia usada para convencer o leitor de que uma grande parcela da população não compreende a linguagem daqueles que detêm o poder foi");
        q524.setAlternativaA("revelar a origem religiosa da linguagem");
        q524.setAlternativaB("questionar o temor sobre o futuro da linguagem.");
        q524.setAlternativaC("descrever a relação entre sociedade e linguagem.\n");
        q524.setAlternativaD("apresentar as consequências do esfacelamento da linguagem.");
        q524.setAlternativaE("criticar o obstáculo promovido pelos usos especializados da linguagem.");
        q524.setRespostaCorreta("E");
        databaseHelper.inserirQuestao(q524);

        Questao q525 = new Questao();
        q525.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q525.setAno(2023);
        q525.setNumero(21);
        q525.addTextoApoio("Um grupo de pesquisadores da Universidade Federal do Ceará desenvolveu um dicionário para traduzir sintomas de doenças da linguagem popular para os termos médicos. Defruço, chanha e piloura, por exemplo, podem ser termos conhecidos para muitos, mas, durante uma consulta médica, o desconhecimento pode significar um diagnóstico errado.\n" +
                "“Isso é um registro histórico e pode ser muito útil para estudos dessas comunidades, na abordagem médica delas. É de certa forma pioneiro no Brasil e, sem dúvida, um instrumento de trabalho importante, porque a comunicação é fundamental na relação médico-paciente”, avalia o reitor da instituição.");
        q525.addReferencia("Disponível em: https://g1.globo.com. Acesso em: 1 nov. 2021 (adaptado).");
        q525.setEnunciado("Ao registrarem usos regionais de termos da área médica, pesquisadores");
        q525.setAlternativaA("apontaram erros motivados pelo desconhecimento da variedade linguística local.");
        q525.setAlternativaB("explicaram problemas provocados pela incapacidade de comunicação.");
        q525.setAlternativaC("descobriram novos sintomas de doenças existentes na comunidade.");
        q525.setAlternativaD("propiciaram melhor compreensão dos sintomas dos pacientes.");
        q525.setAlternativaE("divulgaram um novo rol de doenças características da localidade.");
        q525.setRespostaCorreta("D");
        databaseHelper.inserirQuestao(q525);

        Questao q526 = new Questao();
        q526.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q526.setAno(2023);
        q526.setNumero(22);
        q526.addTextoApoio("Alguém muito recentemente cortara o mato, que na época das chuvas crescia e rodeava a casa da mãe de Ponciá Vicêncio e de Luandi. Havia também vestígios de que a terra fora revolvida, como se ali fosse plantar uma pequena roça. Luandi sorriu. A mãe devia estar bastante forte, pois ainda labutava a terra. Cantou alto uma cantiga que aprendera com o pai, quando eles trabalhavam na terra dos brancos. Era uma canção que os negros mais velhos ensinavam aos mais novos. Eles diziam ser uma cantiga de voltar, que os homens, lá na África, entoavam sempre, quando estavam regressando da pesca, da caça ou de algum lugar. O pai de Luandi, no dia em que queria agradar à mulher, costumava entoar aquela cantiga ao se aproximar de casa. Luandi não entendia as palavras do canto; sabia, porém, que era uma língua que alguns negros falavam ainda, principalmente os velhos. Era uma cantiga alegre. Luandi, além de cantar, acompanhava o ritmo batendo com as palmas das mãos em um atabaque imaginário. Estava de regresso à terra. Voltava em casa. Chegava cantando, dançando a doce e vitoriosa cantiga de regressar.");
        q526.addReferencia("EVARISTO, C. Ponciá Vicêncio. Rio de Janeiro: Pallas, 2018");
        q526.setEnunciado("A leitura do texto permite reconhecer a “cantiga de voltar“ como patrimônio linguístico que");
        q526.setAlternativaA("representa a memória de uma língua africana extinta.");
        q526.setAlternativaB("exalta a rotina executada por jovens afrodescendentes.");
        q526.setAlternativaC("preserva a ancestralidade africana por meio da tradição oral.");
        q526.setAlternativaD("resgata a musicalidade africana por meio de palavras inteligíveis");
        q526.setAlternativaE("remonta à tristeza dos negros mais velhos com saudade da África.");
        q526.setRespostaCorreta("C");
        databaseHelper.inserirQuestao(q526);

        Questao q527 = new Questao();
        q527.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q527.setAno(2023);
        q527.setNumero(23);
        q527.addTextoApoio("TEXTO I");
        q527.addTextoApoio("Zapeei os canais, como há dezenas de anos faço, e pá: parei num que exibia um episódio daquela velha família do futuro, Os Jetsons.\n" +
                "Nesse episódio em particular, a Jane Jetson, esposa do George, tratava de dirigir aquele veículo voador deles. Meu queixo foi caindo à medida que as piadinhas machistas sobre mulheres dirigirem foram se acumulando. Impressionante! Que futuro careta aqueles roteiristas imaginavam! Seriam incapazes de projetar algo melhor, e não apenas em termos de tecnologias, robôs e carros voadores? Será que nossa máxima visão de futuro só atinge as coisas, e jamais as pessoas? Como a Jane, uma mulher de 33 anos no desenho, poderia ser o que foram as minhas bisavós?\n" +
                "O futuro, naquele desenho, se esqueceu de ser melhor nas relações entre as pessoas. Aliás... tão parecido com a vida.\n" +
                "Fiquei de cara, como dizemos aqui, ou como dizíamos na minha adolescência, pobre adolescência, aprendendo, sem querer e sem muita defesa, um futuro tão besta quanto o passado.");
        q527.addReferencia("RIBEIRO, A. E. Disponível em: www.rascunho.com br. Acesso em: 21 out. 2021 (adaptado)");
        q527.addTextoApoio("TEXTO II");
        q527.addTextoApoio("Masculino e feminino são campos escorregadios que só se definem por oposição, sempre incompleta, um do outro. São formações imaginárias que buscam produzir ma diferença radical e complementar onde só existem, de fato, mínimas diferenças. O resto é questão de estilo. Até pelo menos a segunda metade do século 19, o divisor de águas era claro: os homens ocupavam o espaço público. As mulheres tratavam da vida privada. Privada de quê? De visibilidade, diria Hannah Arendt. De visibilidade pública. Do que as mulheres estiveram privadas até o século 20 foi de presença pública manifesta não em imagem, mas em palavra. A palavra feminina, reservada ao espaço doméstico, não produzia diferença na vida social.");
        q527.addReferencia("KHEL, M. R. Disponível em: https://alias.estadao.com.br.\n" +
                "Acesso em: 19 out. 2021 (adaptado).\n");
        q527.setEnunciado("A representação da mulher apresentada no Texto I pode ser explicada pelo Texto II no que diz respeito à(às)");
        q527.setAlternativaA("censura a formas de expressão femininas.");
        q527.setAlternativaB("ausência da figura feminina na vida pública.");
        q527.setAlternativaC("construções imaginárias cristalizadas na sociedade");
        q527.setAlternativaD("limitações inerentes às figuras femininas e masculinas");
        q527.setAlternativaE("dificuldade na atribuição de papéis masculinos e femininos.");
        q527.setRespostaCorreta("C");
        databaseHelper.inserirQuestao(q527);

        Questao q528 = new Questao();
        q528.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q528.setAno(2023);
        q528.setNumero(24);
        q528.addImagem("questao24_img1_linguagens_2023");
        q528.addReferencia("Disponível em: www.defensoriapublica.mt.gov.br. Acesso em: 29 out. 2021 (adaptado)");
        q528.setEnunciado("Esse anúncio publicitário, veiculado durante o contexto da pandemia de covid-19, tem por finalidade");
        q528.setAlternativaA("divulgar o canal telefônico de atendimento a casos de violência contra a mulher.");
        q528.setAlternativaB("nformar sobre a atuação de uma entidade defensora da mulher vítima de violência.");
        q528.setAlternativaC("evidenciar o trabalho da Defensoria Pública em relação ao problema do abuso contra a mulher.");
        q528.setAlternativaD("alertar a sociedade sobre o aumento da violência contra a mulher em decorrência do coronavírus.");
        q528.setAlternativaE("incentivar o público feminino a denunciar crimes de violência contra a mulher durante o período de isolamento.");
        q528.setRespostaCorreta("E");
        databaseHelper.inserirQuestao(q528);

        Questao q529 = new Questao();
        q529.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q529.setAno(2023);
        q529.setNumero(25);
        q529.addTextoApoio("Passado muito tempo, resolvi tentar falar, porque estava sozinha me embrenhando na mesma vereda que Donana costumava entrar. Ainda recordo da palavra que escolhi: arado. Me deleitava vendo meu pai conduzindo o arado velho da fazenda carregado pelo boi, rasgando a terra para depois lançar grãos de arroz em torrões marrons e vermelhos revolvidos. Gostava do som redondo, fácil e ruidoso que tinha ao ser enunciado. “Vou trabalhar no arado.” “Vou arar a terra.” “Seria bom ter um arado novo, esse arado tá troncho e velho.” O som que deixou minha boca era uma aberração, uma desordem, como se no lugar do pedaço perdido da língua tivesse um ovo quente. Era um arado torto, deformado, que penetrava a terra de tal forma a deixá-la infértil, destruída, dilacerada.");
        q529.addReferencia("VIEIRA JR., I. Torto arado. São Paulo: Todavia, 2019.");
        q529.setEnunciado("Com a perda de parte da língua na infância, a narradora tenta voltar a falar. Essa tentativa revela uma experiência que");
        q529.setAlternativaA("reflete o olhar do pai sobre as etapas do plantio.");
        q529.setAlternativaB("metaforiza a linguagem como ferramenta de lavoura.");
        q529.setAlternativaC("explicita, na busca pela palavra, o medo da solidão.");
        q529.setAlternativaD("confirma a frustração da narradora com relação à terra.");
        q529.setAlternativaE("sugere, na ausência da linguagem, a estagnação do tempo.");
        q529.setRespostaCorreta("B");
        databaseHelper.inserirQuestao(q529);

        Questao q530 = new Questao();
        q530.setArea(DatabaseHelper.AREA_LINGUAGENS);
        q530.setAno(2023);
        q530.setNumero(26);
        q530.addTextoApoio("A escravidão");
        q530.addTextoApoio("Esses meninos que aí andam jogando peteca não viram nunca um escravo... Quando crescerem, saberão que já houve no Brasil uma raça triste, votada à escravidão e ao desespero; e verão nos museus a coleção hedionda dos troncos, dos vira-mundos e dos bacalhaus; e terão notícias dos trágicos horrores de uma época maldita: filhos arrancados ao seio das mães, virgens violadas em pranto, homens assados lentamente em fornos de cal, mulheres nuas recebendo na sua mísera nudez desvalida o duplo ultraje das chicotadas e dos olhares do feitor bestial. [...]\n" +
                "Mas a sua indignação nunca poderá ser tão grande como a daqueles que nasceram e cresceram em pleno horror, no meio desse horrível drama de sangue e lodo, sentindo dentro do ouvido e da alma, numa arrastada e contínua melopeia, o longo gemer da raça mártir — orquestração satânica de todos os soluços, de todas as impressões, de todos os lamentos que a tortura e a injustiça podem arrancar a gargantas humanas.");
        q530.addReferencia("BILAC, O. Disponível em: www.escritas.org. Acesso em: 29 out. 2021");
        q530.setEnunciado("Publicado em 1902, o texto de Olavo Bilac enfatiza as mazelas da escravidão no Brasil ao");
        q530.setAlternativaA("descrever de modo impessoal as consequências da exploração racial sobre as gerações futuras.");
        q530.setAlternativaB("contrapor a infância privilegiada das crianças da época à infância violentada das crianças escravizadas.");
        q530.setAlternativaC("antecipar o futuro apagamento das marcas da escravidão no contexto social.");
        q530.setAlternativaD("criticar a atenuação da violência contra os povos escravizados nas memórias retratadas pelos museus.");
        q530.setAlternativaE("imaginar a reação de indiferença de seus contemporâneos com os escravizados libertos");
        q530.setRespostaCorreta("C");
        databaseHelper.inserirQuestao(q530);
    }
}
