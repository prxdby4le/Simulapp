import json
import os
import sys
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
PUBLIC = ROOT / 'temp_enem_api' / 'public'
ASSETS = ROOT / 'app' / 'src' / 'main' / 'assets'
IMAGES_DIR = ASSETS / 'images'

YEARS = [
    2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016,
    2017, 2018, 2019, 2020, 2021, 2022, 2023
]

# Map API discipline -> app area labels
AREA_MAP = {
    'ciencias-humanas': 'Humanas',
    'ciencias-natureza': 'Natureza',
    'linguagens': 'Linguagens',
    'matematica': 'Matemática',
}

def load_exam_questions(year_dir: Path):
    # Each exam/year has questions subfolders or files listed in exams.json
    # We'll iterate index ranges as in app importer: 1-5 with languages, then 6-180
    items = []
    def load_detail(index_label: str):
        f = year_dir / 'questions' / index_label / 'details.json'
        if f.exists():
            try:
                return json.loads(f.read_text(encoding='utf-8'))
            except Exception:
                return None
        return None

    # language questions 1..5 for ingles/espanhol
    for i in range(1, 6):
        for lang in ['ingles', 'espanhol']:
            d = load_detail(f'{i}-{lang}')
            if d: items.append(d)
    # regular questions 6..180
    for i in range(6, 181):
        d = load_detail(str(i))
        if d: items.append(d)
    return items


def norm_text(s):
    if not s:
        return ''
    return s.strip()


def process_question(d):
    q = {
        'ano': d.get('year'),
        'numero': d.get('index'),
        'area': AREA_MAP.get(d.get('discipline'), 'Linguagens'),
        'idioma_estrangeiro': d.get('language'),
        'enunciado': norm_text(d.get('alternativesIntroduction') or d.get('title') or 'Leia o texto e responda à questão.'),
        'texto_apoio': '',
        'imagens': [],
        'alternativa_a': None,
        'alternativa_b': None,
        'alternativa_c': None,
        'alternativa_d': None,
        'alternativa_e': None,
        'resposta_correta': d.get('correctAlternative')
    }

    ctx = d.get('context') or ''
    if ctx:
        import re
        ctx_no_imgs = re.sub(r'!\[\]\([^)]+\)', '', ctx)
        q['texto_apoio'] = ctx_no_imgs.strip()

    # files -> we reference by base name only; copy later
    for url in d.get('files') or []:
        # url like https://enem.dev/2020/questions/1-ingles/<uuid>.png
        base = url.rsplit('/', 1)[-1]
        base_no_ext = base.rsplit('.', 1)[0]
        q['imagens'].append(base_no_ext)

    alts = d.get('alternatives') or []
    for alt in alts:
        letra = alt.get('letter')
        texto = norm_text(alt.get('text')) or None
        if letra == 'A': q['alternativa_a'] = texto
        elif letra == 'B': q['alternativa_b'] = texto
        elif letra == 'C': q['alternativa_c'] = texto
        elif letra == 'D': q['alternativa_d'] = texto
        elif letra == 'E': q['alternativa_e'] = texto
    return q


def ensure_dirs():
    ASSETS.mkdir(parents=True, exist_ok=True)
    IMAGES_DIR.mkdir(parents=True, exist_ok=True)


def copy_question_images(year_dir: Path):
    imgs_copied = 0
    # images live in year/questions/*/*.{png,jpg}
    for qdir in (year_dir / 'questions').glob('*'):
        if not qdir.is_dir():
            continue
        for img in qdir.glob('*.*'):
            if img.name.lower().endswith(('.png', '.jpg', '.jpeg', '.webp')):
                dst = IMAGES_DIR / img.name
                if not dst.exists():
                    dst.write_bytes(img.read_bytes())
                    imgs_copied += 1
    return imgs_copied


def main():
    if not PUBLIC.exists():
        print(f'ERRO: Pasta pública não encontrada: {PUBLIC}')
        sys.exit(1)

    ensure_dirs()

    all_questions = []
    total_imgs = 0

    for year in YEARS:
        year_dir = PUBLIC / str(year)
        if not year_dir.exists():
            print(f'Aviso: ano ausente {year}')
            continue
        details = load_exam_questions(year_dir)
        for d in details:
            all_questions.append(process_question(d))
        total_imgs += copy_question_images(year_dir)
        print(f'{year}: {len(details)} questões, imagens copiadas até agora {total_imgs}')

    out_json = ASSETS / 'questoes_enem.json'
    out_json.write_text(json.dumps(all_questions, ensure_ascii=False), encoding='utf-8')
    print(f'Gerado {len(all_questions)} questões em {out_json}')
    print(f'Imagens copiadas para {IMAGES_DIR}')

if __name__ == '__main__':
    main()

