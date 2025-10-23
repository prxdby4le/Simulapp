# Sistema de Questões Offline do ENEM

## Visão Geral
O SimuLapp agora funciona **100% OFFLINE**! Todas as questões do ENEM (2009-2023) já vêm embutidas no aplicativo. Não é necessária conexão com a internet após o download do app.

## Como Funciona

### Primeira Abertura do App
1. **Instalação do APK**
   - O usuário baixa e instala o SimuLapp
   - Todas as questões e imagens já estão incluídas no APK

2. **Carregamento Inicial (Apenas na Primeira Vez)**
   - Ao abrir o app pela primeira vez, ele detecta que o banco está vazio
   - Um indicador de progresso aparece automaticamente
   - As questões são carregadas do arquivo embutido no app (não da internet!)
   - **Tempo:** Apenas 10-30 segundos
   - **Não requer internet!**

3. **Pronto para Usar**
   - Todas as ~2.700 questões estão disponíveis
   - App funciona completamente offline
   - Nenhum dado móvel é consumido

### Aberturas Subsequentes
- O app verifica que as questões já estão carregadas
- Inicia instantaneamente, sem carregamento adicional
- Funciona offline sempre!

## Vantagens do Modo Offline

✅ **Sem necessidade de internet** - Funciona em qualquer lugar
✅ **Carregamento ultra-rápido** - 10-30 segundos vs 5-10 minutos online
✅ **Zero consumo de dados** - Ideal para planos limitados
✅ **Sempre disponível** - Não depende de APIs externas
✅ **Todas as imagens incluídas** - Nada é baixado depois

## Para Desenvolvedores

### Preparar o App com Questões

Siga o guia completo em `GUIA_OFFLINE.md` para:
1. Executar o script Python que baixa todas as questões
2. Copiar o JSON e imagens para o projeto
3. Compilar o APK com tudo embutido

**Arquivo de preparação:** `download_questoes.py`

## Estrutura das Questões

### Questões Incluídas
- **Anos:** 2009 a 2023 (15 anos)
- **Total por ano:** 180 questões
  - Questões 1-5: Língua Estrangeira (Inglês e Espanhol)
  - Questões 6-180: Questões das 4 áreas de conhecimento
- **Total geral:** ~2.700 questões

### Áreas de Conhecimento
- **Linguagens, Códigos e suas Tecnologias**
- **Ciências Humanas e suas Tecnologias**
- **Ciências da Natureza e suas Tecnologias**
- **Matemática e suas Tecnologias**

### Recursos das Questões
✅ Todas as alternativas (A, B, C, D, E)
✅ Resposta correta identificada
✅ Imagens das questões incluídas
✅ Textos de apoio completos
✅ Ano e número da questão preservados
✅ Filtro de idioma estrangeiro (Inglês/Espanhol)

## Botão "Recarregar Questões"

O botão verde "Recarregar Questões" no menu inicial serve apenas para:
- Recarregar as questões em caso de problemas com o banco de dados
- Resetar as questões para o estado original
- **Não é necessário usar em condições normais**

## Tamanho do App

- **APK sem questões:** ~5-10 MB
- **APK com todas as questões:** ~100-150 MB
- **Banco de dados local:** ~15-20 MB

## Tecnologia

### Armazenamento Local
- Questões armazenadas em SQLite
- Imagens embutidas como recursos do app (drawable)
- JSON de configuração nos assets

### Sem Dependências Externas
- ❌ Não usa internet
- ❌ Não depende de APIs
- ❌ Não consome dados móveis
- ✅ Funciona em modo avião
- ✅ Funciona sem conexão

## Troubleshooting

### Primeira abertura demora muito
**Normal:** O carregamento inicial leva 10-30 segundos para processar todas as questões.

### Questões não aparecem
**Solução:** Use o botão "Recarregar Questões" no menu inicial.

### Imagens não carregam
**Causa:** Possível problema na instalação do APK.
**Solução:** Reinstale o app ou use o botão "Recarregar Questões".

## Para Desenvolvedores

Veja o arquivo `GUIA_OFFLINE.md` para instruções completas sobre como:
- Baixar todas as questões da API do ENEM
- Preparar os arquivos para incluir no app
- Compilar o APK com tudo embutido
- Atualizar questões para novos anos


