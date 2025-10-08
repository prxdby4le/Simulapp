# Como Adicionar Imagens às Questões

## 📁 Passo 1: Colocar as imagens na pasta correta

As imagens das questões devem ser colocadas na pasta:
```
app/src/main/res/mipmap-hdpi/
```

**Nota:** Os outros recursos do app (como ícones de botões, etc) continuam em `drawable/`

## 📝 Passo 2: Renomear as imagens seguindo as regras do Android

Os nomes dos arquivos **DEVEM**:
- ✅ Usar apenas letras **minúsculas** (a-z)
- ✅ Usar números (0-9)
- ✅ Usar underscores (_)
- ❌ **NÃO** usar letras MAIÚSCULAS
- ❌ **NÃO** usar hífens, espaços ou caracteres especiais

**Exemplos de nomes corretos:**
- `q1_img1_l2024.png`
- `q1_img2_l2024.png`
- `questao_90_linguagens.jpg`
- `enem_2024_matematica_q5.png`

**Exemplos ERRADOS:**
- ~~`Q1I1L2024.png`~~ (maiúsculas)
- ~~`questao-90.png`~~ (hífen)
- ~~`Questão 1.png`~~ (espaço e maiúsculas)

## 💻 Passo 3: Referenciar as imagens no código

No código Java, você usa **APENAS O NOME do arquivo SEM a extensão**:

### Para 1 imagem:
```java
q1.setImagem("q1_img1_l2024");  // SEM .png ou .jpg
```

### Para 2 ou mais imagens:
```java
q1.setImagens("q1_img1_l2024", "q1_img2_l2024", "q1_img3_l2024");
```

### Sem imagem:
```java
// Simplesmente não chame setImagem() ou setImagens()
```

## 📂 Estrutura de pastas completa:

```
app/
  src/
    main/
      res/
        drawable/        ← Ícones do app e outros recursos
          ic_arrow_back.xml
          btn_increment.xml
          ...
        mipmap-hdpi/     ← COLOQUE AS IMAGENS DAS QUESTÕES AQUI
          q1_img1_l2024.png
          q1_img2_l2024.png
          q2_img1_m2024.png
          q3_img1_h2024.jpg
          ...
        mipmap-mdpi/
        mipmap-xhdpi/
        ...
```

## ✅ Exemplo completo no código:

```java
// Suponha que você tenha estas imagens na pasta mipmap-hdpi:
// - q1_img1_l2024.png
// - q1_img2_l2024.png

Questao q1 = new Questao();
q1.setArea(DatabaseHelper.AREA_LINGUAGENS);
q1.setAno(2024);
q1.setNumero(1);
q1.setEnunciado("Texto da questão...");
q1.setImagens("q1_img1_l2024", "q1_img2_l2024");  // SEM extensão!
q1.setAlternativaA("Alternativa A");
q1.setAlternativaB("Alternativa B");
q1.setAlternativaC("Alternativa C");
q1.setAlternativaD("Alternativa D");
q1.setAlternativaE("Alternativa E");
q1.setRespostaCorreta("A");
databaseHelper.inserirQuestao(q1);
```

## 🎯 Resumo rápido:

1. **Coloque a imagem** em: `app/src/main/res/mipmap-hdpi/nome_minusculo.png`
2. **No código use**: `q1.setImagem("nome_minusculo");` (sem extensão)
3. **Para múltiplas**: `q1.setImagens("img1", "img2", "img3");`

## ⚠️ Observações importantes:

- **NÃO inclua** a extensão (.png, .jpg) no código
- **NÃO use** o caminho completo, apenas o nome
- Use a pasta **mipmap-hdpi** para as imagens das questões
- Use a pasta **drawable** para outros recursos do app (ícones, botões, etc)
- Formatos aceitos: PNG, JPG, JPEG, WebP
- Recomendado: PNG para melhor qualidade

## 🔄 Se você já tem imagens com nomes errados:

Use o PowerShell ou Explorador de Arquivos para renomear:

```powershell
# Exemplo: renomear Q1I1L2024.png para q1_img1_l2024.png
Rename-Item "Q1I1L2024.png" "q1_img1_l2024.png"
```

Ou simplesmente clique com botão direito > Renomear no Explorador de Arquivos.

## 📌 Diferença entre mipmap e drawable:

- **mipmap-hdpi/**: Imagens das questões do ENEM (carregadas dinamicamente)
- **drawable/**: Ícones e recursos visuais do app (botões, ícones, etc)
