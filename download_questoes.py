import json
import os
import requests
import time
from pathlib import Path

# Configurações
BASE_URL = "https://enem.dev"
ANOS_DISPONIVEIS = list(range(2009, 2024))
OUTPUT_DIR = "questoes_enem"
IMAGES_DIR = os.path.join(OUTPUT_DIR, "images")

# Criar diretórios
os.makedirs(OUTPUT_DIR, exist_ok=True)
os.makedirs(IMAGES_DIR, exist_ok=True)

def mapear_disciplina(discipline):
    """Mapeia disciplina da API para área do app"""
    mapping = {
        "ciencias-humanas": "Humanas",
        "ciencias-natureza": "Natureza",
        "linguagens": "Linguagens",
        "matematica": "Matemática"
    }
    return mapping.get(discipline, "Linguagens")

def baixar_imagem(url, nome_arquivo):
    """Baixa uma imagem da URL e salva localmente"""
    try:
        response = requests.get(url, timeout=30)
        if response.status_code == 200:
            filepath = os.path.join(IMAGES_DIR, nome_arquivo)
            with open(filepath, 'wb') as f:
                f.write(response.content)
            return nome_arquivo
    except Exception as e:
        print(f"Erro ao baixar imagem {url}: {e}")
    return None

def buscar_questao(ano, questao_id):
    """Busca detalhes de uma questão da API"""
    url = f"{BASE_URL}/{ano}/questions/{questao_id}/details.json"

    try:
        response = requests.get(url, timeout=30)
        if response.status_code == 200:
            return response.json()
    except Exception as e:
        print(f"Erro ao buscar questão {questao_id} de {ano}: {e}")

    return None

def processar_questao(detalhes, ano, questao_id):
    """Processa uma questão e retorna no formato do app"""
    if not detalhes:
        return None

    questao = {
        "ano": detalhes["year"],
        "numero": detalhes["index"],
        "area": mapear_disciplina(detalhes.get("discipline")),
        "idioma_estrangeiro": detalhes.get("language"),
        "enunciado": detalhes.get("alternativesIntroduction", ""),
        "texto_apoio": "",
        "imagens": [],
        "alternativa_a": "",
        "alternativa_b": "",
        "alternativa_c": "",
        "alternativa_d": "",
        "alternativa_e": "",
        "resposta_correta": detalhes.get("correctAlternative", "")
    }

    # Processar contexto (remover markdown de imagens)
    context = detalhes.get("context", "")
    if context:
        # Remover markdown de imagens
        import re
        context_limpo = re.sub(r'!\[\]\([^)]+\)', '', context).strip()
        if context_limpo:
            questao["texto_apoio"] = context_limpo

    # Processar imagens
    if detalhes.get("files"):
        for idx, url_imagem in enumerate(detalhes["files"]):
            extensao = url_imagem.split(".")[-1]
            nome_imagem = f"q{ano}_{detalhes['index']}_{idx+1}.{extensao}"

            # Baixar imagem
            if baixar_imagem(url_imagem, nome_imagem):
                questao["imagens"].append(nome_imagem.replace(f".{extensao}", ""))

    # Processar alternativas
    if detalhes.get("alternatives"):
        for alt in detalhes["alternatives"]:
            letra = alt["letter"]
            texto = alt["text"]

            if letra == "A":
                questao["alternativa_a"] = texto
            elif letra == "B":
                questao["alternativa_b"] = texto
            elif letra == "C":
                questao["alternativa_c"] = texto
            elif letra == "D":
                questao["alternativa_d"] = texto
            elif letra == "E":
                questao["alternativa_e"] = texto

    return questao

def main():
    todas_questoes = []
    total_processadas = 0

    for ano in ANOS_DISPONIVEIS:
        print(f"\n=== Processando ano {ano} ===")

        # Questões de língua estrangeira (1-5)
        for i in range(1, 6):
            for idioma in ["ingles", "espanhol"]:
                questao_id = f"{i}-{idioma}"
                print(f"Buscando questão {questao_id}...")

                detalhes = buscar_questao(ano, questao_id)
                if detalhes:
                    questao = processar_questao(detalhes, ano, questao_id)
                    if questao:
                        todas_questoes.append(questao)
                        total_processadas += 1

                time.sleep(0.5)  # Delay para não sobrecarregar a API

        # Questões regulares (6-180)
        for i in range(6, 181):
            questao_id = str(i)
            print(f"Buscando questão {questao_id}...")

            detalhes = buscar_questao(ano, questao_id)
            if detalhes:
                questao = processar_questao(detalhes, ano, questao_id)
                if questao:
                    todas_questoes.append(questao)
                    total_processadas += 1

            time.sleep(0.5)  # Delay para não sobrecarregar a API

        print(f"Total processadas até agora: {total_processadas}")

    # Salvar todas as questões em JSON
    output_file = os.path.join(OUTPUT_DIR, "questoes_enem.json")
    with open(output_file, 'w', encoding='utf-8') as f:
        json.dump(todas_questoes, f, ensure_ascii=False, indent=2)

    print(f"\n=== CONCLUÍDO ===")
    print(f"Total de questões processadas: {total_processadas}")
    print(f"Arquivo JSON salvo em: {output_file}")
    print(f"Imagens salvas em: {IMAGES_DIR}")

if __name__ == "__main__":
    main()

