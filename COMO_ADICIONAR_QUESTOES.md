# Como Adicionar Questões ao Banco de Dados

## Método 1: Via Código Java (Recomendado para poucos registros)

### Passo a Passo:

1. Crie um método em qualquer Activity (por exemplo, no `MenuInicialActivity`):

```java
private void inserirQuestoesExemplo() {
    DatabaseHelper db = new DatabaseHelper(this);
    
    // Exemplo de questão
    Questao questao = new Questao();
    questao.setArea(DatabaseHelper.AREA_LINGUAGENS); // ou AREA_HUMANAS, AREA_NATUREZA, AREA_MATEMATICA
    questao.setAno(2023);
    questao.setNumero(90);
    questao.setEnunciado("Qual é a principal característica do Modernismo brasileiro?");
    questao.setTextoApoio("O Modernismo foi um movimento artístico..."); // OPCIONAL
    questao.setImagem(null); // OPCIONAL - caminho da imagem
    questao.setFonte("ENEM 2023"); // OPCIONAL
    questao.setAlternativaA("Ruptura com o academicismo");
    questao.setAlternativaB("Valorização do indianismo");
    questao.setAlternativaC("Retorno ao Classicismo");
    questao.setAlternativaD("Ênfase no nacionalismo conservador");
    questao.setAlternativaE("Uso de sonetos e rimas ricas");
    questao.setRespostaCorreta("A"); // A, B, C, D ou E
    
    long id = db.inserirQuestao(questao);
    
    if (id > 0) {
        Toast.makeText(this, "Questão inserida com sucesso! ID: " + id, Toast.LENGTH_SHORT).show();
    }
}
```

## Método 2: Via SQL Direto (Recomendado para muitos registros)

### Localize o banco de dados no Android:

O banco está em: `/data/data/com.example.simulapp/databases/simulapp.db`

### Use ADB para acessar:

```bash
adb shell
cd /data/data/com.example.simulapp/databases/
sqlite3 simulapp.db
```

### Inserir questão via SQL:

```sql
INSERT INTO questoes (
    area, 
    ano, 
    numero, 
    enunciado, 
    imagem, 
    texto_apoio, 
    fonte, 
    alternativa_a, 
    alternativa_b, 
    alternativa_c, 
    alternativa_d, 
    alternativa_e, 
    resposta_correta
) VALUES (
    'Linguagens',
    2023,
    90,
    'Qual é a principal característica do Modernismo brasileiro?',
    NULL,
    'O Modernismo foi um movimento artístico...',
    'ENEM 2023',
    'Ruptura com o academicismo',
    'Valorização do indianismo',
    'Retorno ao Classicismo',
    'Ênfase no nacionalismo conservador',
    'Uso de sonetos e rimas ricas',
    'A'
);
```

## Método 3: Via DB Browser for SQLite (Mais Fácil)

1. **Baixe o DB Browser**: https://sqlitebrowser.org/
2. **Extraia o banco do emulador**:
   ```bash
   adb pull /data/data/com.example.simulapp/databases/simulapp.db C:\temp\
   ```
3. **Abra o arquivo** `simulapp.db` no DB Browser
4. **Vá em "Browse Data"** > Tabela "questoes"
5. **Clique em "Insert Record"** e preencha os campos
6. **Salve** e depois envie de volta para o emulador:
   ```bash
   adb push C:\temp\simulapp.db /data/data/com.example.simulapp/databases/
   ```

## Estrutura da Tabela

| Campo | Tipo | Obrigatório | Descrição |
|-------|------|-------------|-----------|
| id | INTEGER | AUTO | Gerado automaticamente |
| area | TEXT | SIM | "Linguagens", "Humanas", "Natureza" ou "Matemática" |
| ano | INTEGER | SIM | Ano da prova (ex: 2023) |
| numero | INTEGER | SIM | Número da questão (ex: 90) |
| enunciado | TEXT | SIM | Texto da pergunta |
| imagem | TEXT | NÃO | Caminho ou URL da imagem |
| texto_apoio | TEXT | NÃO | Texto de apoio/contexto |
| fonte | TEXT | NÃO | Fonte/citação |
| alternativa_a | TEXT | SIM | Texto da alternativa A |
| alternativa_b | TEXT | SIM | Texto da alternativa B |
| alternativa_c | TEXT | SIM | Texto da alternativa C |
| alternativa_d | TEXT | SIM | Texto da alternativa D |
| alternativa_e | TEXT | SIM | Texto da alternativa E |
| resposta_correta | TEXT | SIM | "A", "B", "C", "D" ou "E" |

## Áreas Disponíveis (use exatamente como está escrito):

- `Linguagens` (Linguagens, Códigos e suas Tecnologias)
- `Humanas` (Ciências Humanas e suas Tecnologias)
- `Natureza` (Ciências da Natureza e suas Tecnologias)
- `Matemática` (Matemática e suas Tecnologias)

## Exemplo Completo de Inserção em Lote (Java):

```java
private void inserirQuestoesEnem2023() {
    DatabaseHelper db = new DatabaseHelper(this);
    
    // Questão 1
    Questao q1 = new Questao();
    q1.setArea(DatabaseHelper.AREA_LINGUAGENS);
    q1.setAno(2023);
    q1.setNumero(1);
    q1.setEnunciado("...");
    q1.setAlternativaA("...");
    q1.setAlternativaB("...");
    q1.setAlternativaC("...");
    q1.setAlternativaD("...");
    q1.setAlternativaE("...");
    q1.setRespostaCorreta("A");
    db.inserirQuestao(q1);
    
    // Questão 2
    Questao q2 = new Questao();
    q2.setArea(DatabaseHelper.AREA_HUMANAS);
    // ... continuar
    
    Toast.makeText(this, "Questões inseridas!", Toast.LENGTH_SHORT).show();
}
```

## Verificar Quantas Questões Existem:

```java
DatabaseHelper db = new DatabaseHelper(this);
int qtdLinguagens = db.getQuantidadeQuestoesPorArea(DatabaseHelper.AREA_LINGUAGENS);
int qtdHumanas = db.getQuantidadeQuestoesPorArea(DatabaseHelper.AREA_HUMANAS);
int qtdNatureza = db.getQuantidadeQuestoesPorArea(DatabaseHelper.AREA_NATUREZA);
int qtdMatematica = db.getQuantidadeQuestoesPorArea(DatabaseHelper.AREA_MATEMATICA);

Log.d("DATABASE", "Linguagens: " + qtdLinguagens);
Log.d("DATABASE", "Humanas: " + qtdHumanas);
Log.d("DATABASE", "Natureza: " + qtdNatureza);
Log.d("DATABASE", "Matemática: " + qtdMatematica);
```

## Dicas:

- **Campos opcionais** podem ser `null` ou string vazia
- **Resposta correta** deve ser apenas a letra (A, B, C, D ou E) em maiúscula
- **Área** deve ser escrita exatamente como nas constantes do DatabaseHelper
- Para **imagens**, guarde o caminho ou URL no campo `imagem`

