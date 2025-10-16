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
        /*Questao q37 = new Questao();
        q37.setArea(DatabaseHelper.AREA_MATEMATICA);
        q37.setAno(2024);
        q37.setNumero(142);
        q37.setTextoApoio("Uma criança, utilizando um aplicativo, escreveu uma mensagem para enviar a um amigo. Essa mensagem foi escrita seguindo estas etapas:");
        q37.setImagens("questao142_img1_matematica_2024");
        q37.setTextoApoio1("A criança seguiu copiando e colando, em cada etapa, o que tinha no visor na etapa imediatamente anterior, até concluir a 20ª etapa. Em seguida, enviou a mensagem.");
        q37.setEnunciado("Qual foi o total de figuras contidas na mensagem enviada?");
        q37.setAlternativaA("3 × 219");
        q37.setAlternativaB("3 × 220");
        q37.setAlternativaC("3 × 221");
        q37.setAlternativaD("3 × 220 − 1");
        q37.setAlternativaE("3 × 220 − 3");
        q37.setRespostaCorreta("A");
        databaseHelper.inserirQuestao(q37); */

        // Questão 38 -


        // Questão 39 -


        // Questão 40 -
    }
}
