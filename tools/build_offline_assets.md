Offline assets pipeline (no runtime downloads)

Overview
- Source: temp_enem_api/public
- Generates: app/src/main/assets/questoes_enem.json and app/src/main/assets/images/

Steps
1) Make sure temp_enem_api/public is present locally (already in repo, no network required).
2) Run the Python helper to aggregate questions and copy images:

   Windows (PowerShell):
   
   python tools\make_offline_assets.py

3) Build the app; it will import from assets on first run.

Notes
- The generated files are .gitignored to keep the repo light.
- You can adjust filters (years, languages) inside the script.

