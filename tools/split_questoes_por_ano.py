import argparse
import json
import os
from pathlib import Path
from typing import Any, Dict, List, DefaultDict
from collections import defaultdict


def split_by_year(input_path: Path, out_dir: Path, indent: int = 2) -> Dict[str, int]:
    """Split a combined questions JSON (array of objects) into files per year.

    Contract:
    - input JSON: list of objects, each containing key 'ano' (int or str)
    - output: one file per year named '<year>.json' containing an array of questions for that year
    - returns: dict mapping year (str) -> count of questions written
    - raises: ValueError if the input format is invalid
    """
    if not input_path.exists():
        raise FileNotFoundError(f"Input file not found: {input_path}")

    with input_path.open("r", encoding="utf-8") as f:
        data = json.load(f)

    if not isinstance(data, list):
        raise ValueError("Expected input JSON to be a list of question objects")

    buckets: DefaultDict[str, List[Dict[str, Any]]] = defaultdict(list)

    for idx, item in enumerate(data):
        if not isinstance(item, dict):
            raise ValueError(f"Item at index {idx} is not an object")
        if "ano" not in item:
            raise ValueError(f"Item at index {idx} missing 'ano' field")
        year_val = item["ano"]
        if isinstance(year_val, int):
            year_str = str(year_val)
        elif isinstance(year_val, str) and year_val.isdigit():
            year_str = year_val
        else:
            raise ValueError(f"Item at index {idx} has invalid 'ano': {year_val!r}")
        buckets[year_str].append(item)

    out_dir.mkdir(parents=True, exist_ok=True)

    written: Dict[str, int] = {}
    # Write index of years for convenience
    years_sorted = sorted(buckets.keys(), reverse=True)
    with (out_dir / "years.json").open("w", encoding="utf-8") as fidx:
        json.dump(years_sorted, fidx, ensure_ascii=False, indent=indent)

    for year, items in buckets.items():
        year_path = out_dir / f"{year}.json"
        with year_path.open("w", encoding="utf-8") as fyear:
            json.dump(items, fyear, ensure_ascii=False, indent=indent)
        written[year] = len(items)

    return written


def main() -> None:
    parser = argparse.ArgumentParser(description="Separa as questões de um JSON combinado por ano.")
    parser.add_argument(
        "--input",
        "-i",
        type=str,
        default=str(Path("questoes_enem") / "questoes_enem.json"),
        help="Caminho do arquivo JSON de entrada (lista de questões).",
    )
    parser.add_argument(
        "--out-dir",
        "-o",
        type=str,
        default=str(Path("questoes_enem") / "anos"),
        help="Diretório de saída para salvar os JSONs por ano.",
    )
    parser.add_argument(
        "--compact",
        action="store_true",
        help="Gravar saída compacta (sem indentação).",
    )

    args = parser.parse_args()

    input_path = Path(args.input).resolve()
    out_dir = Path(args.out_dir).resolve()
    indent = None if args.compact else 2

    try:
        result = split_by_year(input_path, out_dir, indent=0 if indent is None else indent)
    except Exception as e:
        print(f"ERRO: {e}")
        raise SystemExit(1)

    total = sum(result.values())
    anos_info = ", ".join(f"{ano}: {qtd}" for ano, qtd in sorted(result.items(), reverse=True))
    print(f"Separação concluída. {total} questões distribuídas. {anos_info}")


if __name__ == "__main__":
    main()

