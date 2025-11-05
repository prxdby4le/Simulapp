# SimuLapp - App de Simulados ENEM 100% Offline

## ⚡ Características Principais

- ✅ **100% Offline** - Funciona sem internet após instalação
- ✅ **2.700+ Questões** - ENEM 2009-2023
- ✅ **Carregamento Rápido** - Apenas 10-30 segundos na primeira vez
- ✅ **Todas as Imagens Incluídas** - Nada precisa ser baixado
- ✅ **Zero Consumo de Dados** - Ideal para planos limitados

## 📱 Como Usar

1. Instale o APK
2. Abra o app
3. Aguarde o carregamento inicial (10-30 segundos)
4. Pronto! Use offline para sempre

## 🔧 Para Desenvolvedores

### Preparar Questões Offline

**Passo 1:** Execute o script Python
```bash
pip install requests
python download_questoes.py
```

**Passo 2:** Copie os arquivos
- `questoes_enem/questoes_enem.json` → `app/src/main/assets/`
- `questoes_enem/images/*` → `app/src/main/res/drawable/`

**Passo 3:** Compile o APK
```
Build > Build Bundle(s) / APK(s) > Build APK(s)
```

### Separar questões por ano (opcional)
Caso você queira gerar arquivos JSON separados por ano a partir do arquivo combinado (`questoes_enem/questoes_enem.json`), use o script já incluído:

- Saída: um arquivo por ano em `questoes_enem/anos/` (ex.: `2022.json`, `2023.json`) e um índice `years.json` com a lista de anos.
- Modo compacto: adicione `--compact` para remover indentação.
- Preencher todos os anos: use `--min-year 2009` (padrão) e opcionalmente `--max-year 2023` para forçar o intervalo; por padrão o script infere o ano máximo pelas questões e cria arquivos vazios para anos sem questões.

Comando no Windows (cmd.exe):
```bat
py tools\split_questoes_por_ano.py -i questoes_enem\questoes_enem.json -o questoes_enem\anos --min-year 2009 --max-year 2023
```

> Observação: se o comando `py` não estiver disponível, tente `python` no lugar de `py`.

### Documentação Completa
- `GUIA_OFFLINE.md` - Guia detalhado de preparação
- `IMPORTACAO_ENEM.md` - Documentação técnica

## 📊 Estatísticas

- **Anos:** 2009-2023 (15 anos)
- **Questões:** ~2.700 total
- **Áreas:** Linguagens, Humanas, Natureza, Matemática
- **Tamanho APK:** ~100-150 MB
- **Tempo 1ª abertura:** 10-30 segundos
- **Tempo demais aberturas:** < 1 segundo

## 🚀 Tecnologias

- Android SDK
- SQLite (banco local)
- JSON (armazenamento de questões)
- Drawable (imagens embutidas)

## 📄 Licença

Este projeto usa dados públicos da API ENEM (https://enem.dev)
