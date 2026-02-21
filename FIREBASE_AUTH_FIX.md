# Firebase Authentication Fix - Android App Blocked

## Problem
```
Error: auth/requests-from-this-android-client-application-<empty>-are-blocked
```

Firebase is blocking authentication requests from your Android app because the app is not properly registered in Firebase Console.

## Solution Steps

### Step 1: Go to Firebase Console
1. Open https://console.firebase.google.com/
2. Select your project: **salahdiary-543e1**

### Step 2: Fix API Key Restrictions
1. Go to **Project Settings** (gear icon) → **General** tab
2. Scroll down to **Your apps** section
3. Find your Android app or click **Add app** if not added

### Step 3: Register Android App Properly
You need to add your Android package name and SHA-1 certificate:

**Package Name:** `com.yourdomain.salahdiary`
(Check in: `android/app/src/main/java/com/yourdomain/salahdiary/MainActivity.java`)

### Step 4: Get SHA-1 Certificate Fingerprint

#### For Debug Build (Development):
```bash
cd android
./gradlew signingReport
```

Or using keytool:
```bash
keytool -list -v -keystore ~/.android/debug.keystore -alias androiddebugkey -storepass android -keypass android
```

#### For Release Build (Production):
```bash
keytool -list -v -keystore android/app/my-release-key.keystore -alias my-key-alias
```

Copy the **SHA-1** fingerprint (looks like: `AA:BB:CC:DD:...`)

### Step 5: Add SHA-1 to Firebase
1. In Firebase Console → Project Settings → Your Android App
2. Click **Add fingerprint**
3. Paste your SHA-1 certificate
4. Click **Save**

### Step 6: Download Updated google-services.json
1. After adding SHA-1, download the new `google-services.json`
2. Replace the file at: `android/app/google-services.json`

### Step 7: Alternative Quick Fix - Remove API Restrictions (Less Secure)
If you want to test quickly (NOT recommended for production):

1. Go to Google Cloud Console: https://console.cloud.google.com/
2. Select project: **salahdiary-543e1**
3. Go to **APIs & Services** → **Credentials**
4. Find your API key: `AIzaSyB7JuG_X2cv0T7f_DpkoR_DN5jtU1n2Z1g`
5. Click on it to edit
6. Under **Application restrictions**:
   - Change from "Android apps" to "None" (temporarily)
   - OR add your package name and SHA-1 fingerprint
7. Click **Save**

### Step 8: Rebuild Your App
```bash
# Clean and rebuild
cd android
./gradlew clean
cd ..

# Rebuild APK
npm run build
npx cap sync android
cd android
./gradlew assembleRelease
```

## Quick Test (Web Version)
To test if Firebase auth works in general, open the app in a web browser:
```bash
# Serve the www folder
cd www
python -m http.server 8000
# Or use any local server
```

Then open: http://localhost:8000

If it works in browser but not in Android app, it confirms the SHA-1/package name issue.

## Important Notes
- The error shows `<empty>` which means Firebase can't identify your Android app
- This is a Firebase Console configuration issue, not a code issue
- Your code is correct, just need to register the app properly in Firebase
- After fixing, authentication will work normally

## Current Status
- ✅ Code is correct
- ✅ Firebase config is correct
- ❌ Android app not registered in Firebase Console
- ❌ SHA-1 fingerprint missing or incorrect

## Next Steps
1. Get your SHA-1 fingerprint using the commands above
2. Add it to Firebase Console
3. Download new google-services.json
4. Rebuild the app
5. Test authentication again
