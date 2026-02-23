# Debug Google Sign-In Issue

## Current Problem
"This site can't be reached" error aa raha hai, matlab browser still open ho raha hai instead of native plugin.

## Debug Steps

### 1. Build Fresh APK
```bash
build-apk.bat
```

### 2. Install on Phone
```bash
adb install -r android\app\build\outputs\apk\release\app-release.apk
```

### 3. Check Logs While Testing
Terminal mein yeh command run karo BEFORE clicking Google button:
```bash
adb logcat | findstr "GoogleAuth\|Capacitor\|Firebase"
```

### 4. Click Google Button and Watch Logs

Logs mein yeh dikhna chahiye:
```
🔐 Attempting Google Sign-In...
   Capacitor available: true
   isNativePlatform: true
   Plugins: [object Object]
   Detected platform: MOBILE
📱 Using native Google Sign-In
   GoogleAuth plugin: [object Object]
```

### 5. Check What's Actually Happening

**If logs show "WEB" instead of "MOBILE":**
- Capacitor not detecting properly
- Plugin not loaded

**If logs show "MOBILE" but still browser opens:**
- Plugin not configured properly
- Need to check capacitor.config.json

**If no logs at all:**
- JavaScript error before reaching the code
- Check browser console in Chrome DevTools

## Alternative: Use Chrome DevTools

### Connect Phone to PC
```bash
# Enable USB debugging on phone
# Connect via USB
adb devices
```

### Open Chrome DevTools
1. Open Chrome on PC
2. Go to: `chrome://inspect`
3. Find your app in the list
4. Click "inspect"
5. Go to Console tab
6. Click Google button in app
7. Watch console logs

## Expected Console Output

### If Working (Native):
```
🔐 Attempting Google Sign-In...
   Capacitor available: true
   isNativePlatform: true
   Detected platform: MOBILE
📱 Using native Google Sign-In
   GoogleAuth plugin: [GoogleAuth object]
✅ Native Google Sign-In successful!
   User: {email, name, imageUrl, ...}
✅ Firebase authentication successful!
```

### If Falling Back to Web:
```
🔐 Attempting Google Sign-In...
   Capacitor available: false (or true)
   isNativePlatform: false (or undefined)
   Detected platform: WEB
💻 Using web popup sign-in
[Then browser opens]
```

## Quick Fix Options

### Option 1: Force Native Mode (Temporary Test)
In `handleGoogleSignIn`, temporarily force native:
```javascript
const isMobile = true; // Force native for testing
```

### Option 2: Check Plugin Registration
Make sure plugin is in `android/app/src/main/java/.../MainActivity.java`:
```java
import com.codetrixstudio.capacitor.GoogleAuth.GoogleAuth;

public class MainActivity extends BridgeActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerPlugin(GoogleAuth.class);
    }
}
```

### Option 3: Verify capacitor.config.json
Make sure it's in the right place:
- Root: `capacitor.config.json` ✅
- Android assets: `android/app/src/main/assets/capacitor.config.json` ✅

## Common Issues

### Issue 1: Plugin Not Loaded
**Symptom:** `window.Capacitor.Plugins.GoogleAuth` is undefined
**Fix:** 
```bash
npm install @codetrix-studio/capacitor-google-auth --legacy-peer-deps
npx cap sync android
```

### Issue 2: Wrong Client ID
**Symptom:** "Developer Error" or "Invalid client ID"
**Fix:** Check `capacitor.config.json` has correct `serverClientId`

### Issue 3: SHA-1 Not Added
**Symptom:** "Sign-in failed" after selecting account
**Fix:** Add SHA-1 to Firebase Console

### Issue 4: Capacitor Not Initialized
**Symptom:** `window.Capacitor` is undefined
**Fix:** Make sure Capacitor scripts are loaded before your code

## Next Steps

1. Build APK
2. Install on phone
3. Run logcat command
4. Click Google button
5. Share the console logs with me

Then we can see exactly what's happening! 🔍
