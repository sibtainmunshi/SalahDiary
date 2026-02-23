@echo off
echo Starting local development server...
echo.
echo Opening browser at http://localhost:8000
echo Press Ctrl+C to stop the server
echo.
cd www
python -m http.server 8000
