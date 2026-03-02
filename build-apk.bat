@echo off
echo ========================================
echo Building Salah Diary APK
echo ========================================
echo.

echo Step 1: Syncing Capacitor (CRITICAL for plugins)...
call npx cap sync android
if %errorlevel% neq 0 (
    echo Error: Capacitor sync failed
    pause
    exit /b 1
)

echo.
echo Step 2: Cleaning previous build...
cd android
call gradlew.bat clean
if %errorlevel% neq 0 (
    echo Error: Clean failed
    cd ..
    pause
    exit /b 1
)

echo.
echo Step 3: Building release APK...
call gradlew.bat assembleRelease
if %errorlevel% neq 0 (
    echo Error: Build failed
    cd ..
    pause
    exit /b 1
)

cd ..

echo.
echo ========================================
echo Build Successful!
echo ========================================
echo APK Location: android\app\build\outputs\apk\release\app-release.apk
echo.
echo Copying APK to www folder...
copy android\app\build\outputs\apk\release\app-release.apk www\app-release.apk
echo.
echo To install on device:
echo 1. Connect device via USB
echo 2. Enable USB debugging
echo 3. Run: adb install -r www\app-release.apk
echo.
pause
