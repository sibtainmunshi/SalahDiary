@echo off
echo ========================================
echo Building Salah Diary APK
echo ========================================
echo.

echo Step 1: Cleaning previous build...
cd android
call gradlew.bat clean
if %errorlevel% neq 0 (
    echo Error: Clean failed
    pause
    exit /b 1
)

echo.
echo Step 2: Building debug APK...
call gradlew.bat assembleDebug
if %errorlevel% neq 0 (
    echo Error: Build failed
    pause
    exit /b 1
)

echo.
echo ========================================
echo Build Successful!
echo ========================================
echo APK Location: android\app\build\outputs\apk\debug\app-debug.apk
echo.
echo To install on device:
echo 1. Connect device via USB
echo 2. Enable USB debugging
echo 3. Run: adb install app\build\outputs\apk\debug\app-debug.apk
echo.
pause
