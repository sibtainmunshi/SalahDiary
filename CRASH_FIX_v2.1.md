# Google Sign-In Crash Fix - v2.1

## Issue
App was crashing (closing to home screen) when clicking Google Sign-In button.

## Changes Made

### 1. Enhanced Error Handling
- **File**: `www/index.html`
- Added comprehensive try-catch blocks around native plugin calls
- Added detailed logging at every step:
  - Before calling `GoogleAuth.signIn()`
  - After receiving Google user data
  - When creating Firebase credential
  - When signing in to Firebase
- Added validation to check if ID token exists before proceeding

### 2. Removed Manual Initialization
- Removed the manual `GoogleAuth.initialize()` call
- The plugin auto-initializes from `capacitor.config.json`
- Manual initialization was causing conflicts

### 3. Better Error Messages
- Added JSON stringification for error objects
- Log error type, code, message, and full error object
- Specific handling for error code 10 (OAuth config issue)
- Check for "No ID token" errors

### 4. Version Update
- Updated version indicator to "v2.1 - Debug"
- Easy verification that new APK is installed

## What to Check

### When Testing v2.1:
1. Install the new APK
2. Verify version shows "v2.1 - Debug" on welcome screen
3. Open Chrome DevTools (chrome://inspect) on your computer
4. Connect phone via USB
5. Click Google Sign-In button
6. Watch the console logs carefully

### Expected Console Output:
```
🔐 Attempting Google Sign-In...
   Platform check: {isNative: true, hasGoogleAuth: {...}}
📱 Using native Google Sign-In
   Calling GoogleAuth.signIn()...
```

### If It Crashes:
The console should show the exact error before the crash. Look for:
- Error code (especially code 10)
- Error message
- Full error object (JSON)

### If Error Code 10 Appears:
This means OAuth configuration issue. Possible causes:
1. SHA-1 fingerprint mismatch
2. Wrong OAuth client ID
3. Package name mismatch
4. OAuth client not enabled in Google Cloud Console

## Current Configuration

### capacitor.config.json
```json
{
  "plugins": {
    "GoogleAuth": {
      "scopes": ["profile", "email"],
      "serverClientId": "433228794223-mf6he8m4vieqqfenq309v4o5v8bk4b2r.apps.googleusercontent.com",
      "forceCodeForRefreshToken": true
    }
  }
}
```

### OAuth Clients in google-services.json
1. **Release Android** (SHA-1: a064...): `433228794223-0pcvbjp8l4q9in742nbgfj6etku5c3le`
2. **Debug Android** (SHA-1: 5526...): `433228794223-d9q3rppcvae2o6fmsrpvaoithj9q9sud`
3. **Web** (for plugin): `433228794223-mf6he8m4vieqqfenq309v4o5v8bk4b2r`

## Debugging Steps

### Step 1: Check Console Logs
```bash
# On computer, open Chrome
chrome://inspect

# Select your device
# Click "inspect" on the WebView
# Watch console when clicking Google Sign-In
```

### Step 2: Verify SHA-1 Fingerprint
```powershell
# Get debug keystore SHA-1
keytool -list -v -keystore "$env:USERPROFILE\.android\debug.keystore" -alias androiddebugkey -storepass android -keypass android
```

Expected: `55:26:6C:1C:9A:48:3C:50:2B:22:B5:49:CA:A3:9D:2C:6A:2A:51:A3`

### Step 3: Check Package Name
Should be: `com.yourdomain.salahdiary`

Verify in:
- `capacitor.config.json` → `appId`
- `android/app/build.gradle` → `applicationId`
- `android/app/src/main/AndroidManifest.xml` → `package`

### Step 4: Verify OAuth Client in Google Cloud Console
1. Go to: https://console.cloud.google.com/apis/credentials
2. Select project: salahdiary-543e1
3. Find OAuth 2.0 Client IDs
4. Verify Web client exists: `433228794223-mf6he8m4vieqqfenq309v4o5v8bk4b2r`
5. Verify Android clients exist with correct SHA-1 fingerprints

## Alternative Approach (If Still Crashing)

If the native plugin continues to crash, we can try:

### Option A: Use Different Plugin
Switch to `@capacitor-community/google-auth` (more stable)

### Option B: Use Firebase Auth UI
Use Firebase's built-in auth UI (opens in-app browser but more reliable)

### Option C: Use Custom Tabs
Use Chrome Custom Tabs instead of external browser (better UX than full browser)

## Files Modified
1. `www/index.html` - Enhanced error handling and logging
2. Version indicator updated to v2.1

## APK Location
`android\app\build\outputs\apk\release\app-release.apk`

## Next Steps After Testing
1. Share the console logs from Chrome DevTools
2. If error code 10, we'll verify OAuth configuration
3. If different error, we'll adjust based on the error message
4. If it works, celebrate! 🎉
