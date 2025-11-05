import argparse
import json
from pathlib import Path
from typing import Any, Dict, List, DefaultDict, Optional
from collections import defaultdict


def split_by_year(
    input_path: Path,
    out_dir: Path,
    indent: Optional[int] = 2,
    min_year: int = 2009,
    max_year: Optional[int] = None,
    fill_all_years: bool = True,
) -> Dict[str, int]:
    """Split a combined questions JSON (array of objects) into files per year.

    Contract:
    - input JSON: list of objects, each containing key 'ano' (int or str)
    - output: one file per year named '<year>.json' containing an array of questions for that year
    - returns: dict mapping year (str) -> count of questions written
    - raises: ValueError if the input format is invalid
    - if fill_all_years=True: also write empty arrays for missing years in [min_year, max_year_eff]
    """
    if not input_path.exists():
        raise FileNotFoundError(f"Input file not found: {input_path}")

    with input_path.open("r", encoding="utf-8") as f:
        data = json.load(f)

    if not isinstance(data, list):
        raise ValueError("Expected input JSON to be a list of question objects")

    buckets: DefaultDict[str, List[Dict[str, Any]]] = defaultdict(list)

    max_year_in_data: Optional[int] = None

    for idx, item in enumerate(data):
        if not isinstance(item, dict):
            raise ValueError(f"Item at index {idx} is not an object")
        if "ano" not in item:
            raise ValueError(f"Item at index {idx} missing 'ano' field")
        year_val = item["ano"]
        if isinstance(year_val, int):
            year_int = year_val
        elif isinstance(year_val, str) and year_val.isdigit():
            year_int = int(year_val)
        else:
            raise ValueError(f"Item at index {idx} has invalid 'ano': {year_val!r}")
        year_str = str(year_int)
        buckets[year_str].append(item)
        if max_year_in_data is None or year_int > max_year_in_data:
            max_year_in_data = year_int

    # Determine effective max year
    if max_year is None:
        if max_year_in_data is not None:
            max_year_eff = max(max_year_in_data, min_year)
        else:
            # No data: fallback to current year
            from datetime import datetime

            max_year_eff = max(datetime.now().year, min_year)
    else:
        max_year_eff = max(max_year, min_year)

    out_dir.mkdir(parents=True, exist_ok=True)

    written: Dict[str, int] = {}

    # Determine the list of years to index
    years_in_data_sorted = sorted((int(y) for y in buckets.keys()), reverse=True)

    if fill_all_years:
        # Full range from min_year to max_year_eff, descending
        all_years = list(range(max_year_eff, min_year - 1, -1))
        years_for_index = all_years
    else:
        years_for_index = years_in_data_sorted

    # Write index of years for convenience
    with (out_dir / "years.json").open("w", encoding="utf-8") as fidx:
        json.dump([str(y) for y in years_for_index], fidx, ensure_ascii=False, indent=indent)

    # Write per-year files
    # Always write those present in data
    for year_str, items in buckets.items():
        year_path = out_dir / f"{year_str}.json"
        with year_path.open("w", encoding="utf-8") as fyear:
            json.dump(items, fyear, ensure_ascii=False, indent=indent)
        written[year_str] = len(items)

    # Optionally write empty arrays for missing years in range
    if fill_all_years:
        for y in range(min_year, max_year_eff + 1):
            ys = str(y)
            if ys not in written:
                year_path = out_dir / f"{ys}.json"
                with year_path.open("w", encoding="utf-8") as fyear:
                    json.dump([], fyear, ensure_ascii=False, indent=indent)
                written[ys] = 0

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
    parser.add_argument(
        "--min-year",
        type=int,
        default=2009,
        help="Ano inicial para preencher arquivos por ano (default: 2009).",
    )
    parser.add_argument(
        "--max-year",
        type=int,
        default=None,
        help="Ano final para preencher arquivos por ano (default: inferido do input).",
    )
    parser.add_argument(
        "--no-fill",
        action="store_true",
        help="Não criar arquivos vazios para anos sem questões no intervalo.",
    )

    args = parser.parse_args()

    input_path = Path(args.input).resolve()
    out_dir = Path(args.out_dir).resolve()
    indent = None if args.compact else 2

    try:
        result = split_by_year(
            input_path,
            out_dir,
            indent=indent,
            min_year=args.min_year,
            max_year=args.max_year,
            fill_all_years=not args.no_fill,
        )
    except Exception as e:
        print(f"ERRO: {e}")
        raise SystemExit(1)

    total = sum(result.values())
    anos_info = ", ".join(
        f"{ano}: {qtd}" for ano, qtd in sorted(result.items(), key=lambda x: int(x[0]), reverse=True)
    )
    print(f"Separação concluída. {total} questões distribuídas. {anos_info}")


if __name__ == "__main__":
    main()
