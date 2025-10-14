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
        q21.setImagens("questao53_img1_humanas_2024.png");
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
