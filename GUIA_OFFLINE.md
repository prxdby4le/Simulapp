# Guia: Preparação do App para Funcionar Offline

## Visão Geral
Este guia explica como preparar o SimuLapp para funcionar completamente offline, com todas as questões do ENEM já embutidas no APK.

## Passo 1: Executar o Script de Download

### Requisitos
- Python 3.x instalado
- Biblioteca `requests` instalada

### Instalação das Dependências
```bash
pip install requests
```

### Executar o Script
```bash
cd C:\Users\MerdaBosta\AndroidStudioProjects\Simulapp
python download_questoes.py
```

### O que o script faz:
1. Conecta-se à API do ENEM (https://enem.dev)
2. Baixa todas as questões de 2009 a 2023
3. Baixa todas as imagens das questões
4. Gera um arquivo `questoes_enem.json` com todas as questões
5. Salva as imagens na pasta `questoes_enem/images/`

**Tempo estimado:** 30-60 minutos (dependendo da conexão)

## Passo 2: Copiar Arquivos para o Projeto Android

### 2.1 Criar Pasta Assets
Se não existir, crie a pasta:
```
app/src/main/assets/
```

### 2.2 Copiar o arquivo JSON
Copie o arquivo gerado:
```
questoes_enem/questoes_enem.json
```
Para:
```
app/src/main/assets/questoes_enem.json
```

### 2.3 Copiar Imagens para Drawable
Copie todas as imagens da pasta:
```
questoes_enem/images/
```
Para:
```
app/src/main/res/drawable/
```

**Importante:** As imagens devem estar em formato PNG e com nomes válidos para recursos Android (apenas letras minúsculas, números e underscore).

## Passo 3: Compilar o APK

### No Android Studio:
1. Build > Clean Project
2. Build > Rebuild Project
3. Build > Build Bundle(s) / APK(s) > Build APK(s)

### Tamanho Estimado do APK
- **Sem questões:** ~5-10 MB
- **Com todas as questões e imagens:** ~100-150 MB

## Como Funciona Após a Instalação

### Primeira Abertura
1. O usuário instala o APK
2. Abre o app pela primeira vez
3. O app detecta que o banco está vazio
4. Automaticamente carrega as questões do arquivo JSON embutido
5. Processo leva ~10-30 segundos (não requer internet!)
6. App pronto para uso offline!

### Aberturas Subsequentes
- O app verifica que as questões já estão no banco
- Não há carregamento adicional
- App inicia instantaneamente

## Vantagens do Modo Offline

✅ **Funciona sem internet** - Todas as questões já estão no APK
✅ **Carregamento rápido** - ~10-30 segundos vs ~5-10 minutos da API
✅ **Confiável** - Não depende da disponibilidade da API
✅ **Sem consumo de dados** - Perfeito para usuários com plano limitado
✅ **Imagens embutidas** - Todas as imagens já vêm com o app

## Estrutura de Arquivos

```
Simulapp/
├── download_questoes.py          # Script para baixar questões
├── questoes_enem/                # Pasta gerada pelo script
│   ├── questoes_enem.json       # Arquivo JSON com todas as questões
│   └── images/                   # Imagens das questões
│       ├── q2023_1_1.png
│       ├── q2023_1_2.png
│       └── ...
└── app/
    └── src/
        └── main/
            ├── assets/
            │   └── questoes_enem.json    # JSON copiado para assets
            └── res/
                └── drawable/
                    ├── q2023_1_1.png     # Imagens copiadas
                    ├── q2023_1_2.png
                    └── ...
```

## Formato do JSON

Cada questão no JSON tem a seguinte estrutura:

```json
{
  "ano": 2023,
  "numero": 10,
  "area": "Linguagens",
  "idioma_estrangeiro": null,
  "enunciado": "De acordo com o texto...",
  "texto_apoio": "Se a interferência de contas falsas...",
  "imagens": ["q2023_10_1"],
  "alternativa_a": "Controle da atuação...",
  "alternativa_b": "Desenvolvimento de tecnologias...",
  "alternativa_c": "Flexibilização dos turnos...",
  "alternativa_d": "Necessidade de regulamentação...",
  "alternativa_e": "Identificação de padrões...",
  "resposta_correta": "E"
}
```

## Troubleshooting

### Script Python falha
**Problema:** Erro de conexão ao executar o script
**Solução:** 
- Verifique sua conexão com a internet
- Tente novamente mais tarde (API pode estar temporariamente indisponível)
- Execute o script em horários de menor tráfego

### APK muito grande
**Problema:** APK ultrapassa 150 MB
**Solução:** 
- Considere usar App Bundle (AAB) ao invés de APK
- O Google Play comprime automaticamente o download
- Usuários baixarão apenas ~60-80 MB

### Imagens não aparecem
**Problema:** Questões carregam mas imagens não aparecem
**Solução:**
- Verifique se as imagens foram copiadas para `res/drawable/`
- Certifique-se que os nomes não têm caracteres inválidos
- Os nomes devem ser em minúsculas: `q2023_1_1` (não `Q2023_1_1`)

### Erro ao compilar
**Problema:** "Resource not found" ao compilar
**Solução:**
- Clean Project antes de Rebuild
- Verifique se o arquivo JSON está em `assets/`
- Sincronize o projeto (File > Sync Project with Gradle Files)

## Manutenção e Atualizações

### Para adicionar questões de novos anos:
1. Execute novamente o script `download_questoes.py`
2. Atualize a constante `ANOS_DISPONIVEIS` no script
3. Copie o novo JSON e imagens para o projeto
4. Incremente a versão do app
5. Compile e distribua novo APK/AAB

### Incrementar versão do banco de dados:
Se mudar a estrutura das questões, atualize em `DatabaseHelper.java`:
```java
private static final int DATABASE_VERSION = 6; // Incrementar
```

## Estimativas de Recursos

### Questões Totais
- 15 anos (2009-2023)
- ~180 questões por ano
- **Total:** ~2.700 questões

### Espaço em Disco
- JSON: ~5-10 MB
- Imagens: ~80-100 MB
- Banco de dados: ~15-20 MB
- **Total:** ~100-130 MB

### Tempo de Carregamento
- Primeira abertura: 10-30 segundos
- Aberturas seguintes: <1 segundo
- Não requer internet em nenhum momento

## Conclusão

Com este sistema, o SimuLapp funciona 100% offline após a instalação, proporcionando uma excelente experiência ao usuário mesmo sem conexão à internet!

