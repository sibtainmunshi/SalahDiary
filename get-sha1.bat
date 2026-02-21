@echo off
echo ========================================
echo Getting SHA-1 Fingerprints for Firebase
echo ========================================
echo.

echo Package Name: com.yourdomain.salahdiary
echo.

echo ========================================
echo DEBUG SHA-1 (for development/testing):
echo ========================================
keytool -list -v -keystore "%USERPROFILE%\.android\debug.keystore" -alias androiddebugkey -storepass android -keypass android 2>nul | findstr /C:"SHA1:"
echo.

echo ========================================
echo RELEASE SHA-1 (for production):
echo ========================================
if exist "android\my-release-key.keystore" (
    echo Enter keystore password when prompted: salahdiary
    keytool -list -v -keystore "android\my-release-key.keystore" -alias my-key-alias | findstr /C:"SHA1:"
) else (
    echo Release keystore not found at: android\my-release-key.keystore
)
echo.

echo ========================================
echo NEXT STEPS:
echo ========================================
echo 1. Copy the SHA-1 fingerprint(s) above
echo 2. Go to: https://console.firebase.google.com/
echo 3. Select project: salahdiary-543e1
echo 4. Go to Project Settings ^> Your apps ^> Android app
echo 5. Add the SHA-1 fingerprint
echo 6. Download new google-services.json
echo 7. Replace android/app/google-services.json
echo 8. Rebuild the app
echo.
pause
