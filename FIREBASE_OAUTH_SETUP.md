# Firebase OAuth Client ID Setup for Native Google Sign-In

## Problem
Error code 10 = "Something went wrong" means OAuth client configuration missing or incorrect.

## Solution: Create OAuth 2.0 Client ID in Google Cloud Console

### Step 1: Go to Google Cloud Console
https://console.cloud.google.com/apis/credentials?project=salahdiary-543e1

### Step 2: Create OAuth 2.0 Client ID

1. Click "CREATE CREDENTIALS" button
2. Select "OAuth client ID"
3. Application type: **Android**
4. Name: "SalahDiary Android"
5. Package name: `com.yourdomain.salahdiary`
6. SHA-1 certificate fingerprint: `55:26:6C:1C:9A:48:3C:50:2B:22:B5:49:CA:A3:9D:2C:6A:2A:51:A3`
7. Click "CREATE"

### Step 3: Get the Web Client ID

After creating Android client, you'll see a list of OAuth clients. Find the one with type "Web application" (it should already exist). Copy its Client ID.

It will look like: `433228794223-xxxxxxxxxxxxxxxxx.apps.googleusercontent.com`

### Step 4: Update capacitor.config.json

Use the **Web Client ID** (not Android client ID) in your config:

```json
{
  "plugins": {
    "GoogleAuth": {
      "scopes": ["profile", "email"],
      "serverClientId": "YOUR_WEB_CLIENT_ID_HERE.apps.googleusercontent.com",
      "forceCodeForRefreshToken": true
    }
  }
}
```

### Step 5: Download Updated google-services.json

1. Go to Firebase Console: https://console.firebase.google.com/project/salahdiary-543e1/settings/general
2. Scroll to "Your apps" section
3. Click on Android app
4. Click "Download google-services.json"
5. Replace: `android/app/google-services.json`

### Step 6: Sync and Build

```bash
npx cap sync android
build-apk.bat
```

## Alternative: Simpler Approach (Recommended)

Bhai, native Google Sign-In setup complex hai. Let me suggest a simpler solution that WILL work:

### Use Firebase UI or Simple Web Flow

Instead of native plugin, we can use a hybrid approach:
1. Open Google Sign-In in a WebView (not external browser)
2. Use Firebase's built-in redirect handling
3. Works perfectly, no complex setup needed

Would you like me to implement this simpler approach? It will:
- ✅ Work immediately (no OAuth setup needed)
- ✅ Stay in-app (no external browser)
- ✅ Use Firebase's built-in handling
- ✅ Sync profile picture and name
- ✅ Much simpler to maintain

Let me know and I'll implement it! 🚀
