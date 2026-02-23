# 🔧 Fix Error Code 10 - Google Cloud Console Setup

## Problem
```
❌ Native Google Sign-In failed: Something went wrong
Error code: 10
```

**Error Code 10 = Developer console configuration incorrect**

## Your SHA-1 Fingerprints
```
Debug:   55:26:6C:1C:9A:48:3C:50:2B:22:B5:49:CA:A3:9D:2C:6A:2A:51:A3
Release: A0:64:46:20:44:AA:33:99:96:89:42:AB:2F:76:31:48:AE:F5:41:82
```

## Your App Details
```
Package Name: com.yourdomain.salahdiary
Project ID: salahdiary-543e1
Web Client ID: 433228794223-mf6he8m4vieqqfenq309v4o5v8bk4b2r.apps.googleusercontent.com
```

---

## Step-by-Step Fix

### Step 1: Open Google Cloud Console
1. Go to: https://console.cloud.google.com/
2. Login with your Google account
3. Select project: **salahdiary-543e1** (top dropdown)

### Step 2: Go to Credentials
1. Click hamburger menu (☰) → **APIs & Services** → **Credentials**
2. You'll see a list of OAuth 2.0 Client IDs

### Step 3: Check Existing Android OAuth Clients

Look for Android OAuth clients. You should see:
- Web client (already exists)
- Android client(s) - **THIS IS WHAT WE NEED TO FIX**

### Step 4: Create/Update Android OAuth Client

#### Option A: If Android OAuth Client Doesn't Exist

1. Click **"+ CREATE CREDENTIALS"** button (top)
2. Select **"OAuth client ID"**
3. Choose **Application type**: **Android**
4. Fill in the form:

```
Name: SalahDiary Android Debug
Package name: com.yourdomain.salahdiary
SHA-1 certificate fingerprint: 55:26:6C:1C:9A:48:3C:50:2B:22:B5:49:CA:A3:9D:2C:6A:2A:51:A3
```

5. Click **"CREATE"**
6. Note down the Client ID (it will be auto-generated)

#### Option B: If Android OAuth Client Exists

1. Click on the existing Android OAuth client
2. Verify these details:
   - **Package name**: Must be exactly `com.yourdomain.salahdiary`
   - **SHA-1 fingerprint**: Must be `55:26:6C:1C:9A:48:3C:50:2B:22:B5:49:CA:A3:9D:2C:6A:2A:51:A3`
3. If wrong, click **"EDIT"** and fix them
4. Click **"SAVE"**

### Step 5: Create Second Android OAuth Client (for Release)

Repeat Step 4 but with Release SHA-1:

```
Name: SalahDiary Android Release
Package name: com.yourdomain.salahdiary
SHA-1 certificate fingerprint: A0:64:46:20:44:AA:33:99:96:89:42:AB:2F:76:31:48:AE:F5:41:82
```

### Step 6: Verify OAuth Consent Screen

1. Go to **OAuth consent screen** (left sidebar)
2. Check:
   - **Publishing status**: Testing or Production
   - **User type**: External
   - **App name**: SalahDiary
   - **Scopes**: email, profile, openid

3. **IMPORTANT**: If status is "Testing", scroll down to **Test users**
4. Click **"+ ADD USERS"**
5. Add your Gmail address that you'll use for testing
6. Click **"SAVE"**

### Step 7: Enable Required APIs

1. Go to **APIs & Services** → **Library**
2. Search and enable these APIs:
   - **Google Sign-In API** (or Google+ API)
   - **Identity Toolkit API**
3. Click **"ENABLE"** if not already enabled

---

## After Making Changes

### Wait for Propagation
Changes take **5-10 minutes** to propagate. Be patient!

### Download New google-services.json (Optional)

If you created new OAuth clients:

1. Go to Firebase Console: https://console.firebase.google.com/
2. Select project: **salahdiary-543e1**
3. Click gear icon → **Project Settings**
4. Scroll to **Your apps** section
5. Click on Android app
6. Click **"Download google-services.json"**
7. Replace file at: `android/app/google-services.json`
8. Run: `npx cap sync android`

### Rebuild APK
```bash
cd android
.\gradlew clean
.\gradlew assembleRelease
```

### Test Again
1. Install new APK
2. Try Google Sign-In
3. Should work now! 🎉

---

## Common Mistakes

### ❌ Wrong Package Name
```
Package in OAuth client: com.example.app
Your actual package: com.yourdomain.salahdiary
```
**Fix**: Must match exactly!

### ❌ Wrong SHA-1
```
SHA-1 in OAuth client: AA:BB:CC:...
Your actual SHA-1: 55:26:6C:1C:...
```
**Fix**: Copy-paste carefully, no spaces!

### ❌ Not Added to Test Users
If OAuth consent screen is in "Testing" mode, you MUST add your Gmail to test users.

### ❌ API Not Enabled
Google Sign-In API must be enabled in the project.

---

## Quick Verification Checklist

Before testing, verify in Google Cloud Console:

- [ ] Android OAuth client exists
- [ ] Package name = `com.yourdomain.salahdiary`
- [ ] SHA-1 = `55:26:6C:1C:9A:48:3C:50:2B:22:B5:49:CA:A3:9D:2C:6A:2A:51:A3`
- [ ] OAuth consent screen configured
- [ ] Your Gmail added to test users (if in Testing mode)
- [ ] Google Sign-In API enabled
- [ ] Waited 5-10 minutes after changes

---

## Still Not Working?

### Check Logs
Look for these in Android Studio Logcat:
```
Status{statusCode=DEVELOPER_ERROR}
```
This confirms OAuth client configuration issue.

### Screenshot Needed
Take screenshot of:
1. Google Cloud Console → Credentials page (showing all OAuth clients)
2. The Android OAuth client details page

Share with me and I'll help debug!

---

## Alternative: Use Redirect Method (Temporary)

Your app already has fallback to redirect method. It works but opens browser instead of native picker.

To force redirect method (for testing):
- Just let Error Code 10 happen
- App will automatically fallback to browser redirect
- Sign-in will still work!

But native method is better UX, so fix Google Cloud Console for best experience.

---

**Next Steps:**
1. Go to Google Cloud Console NOW
2. Follow Step 1-7 above
3. Wait 10 minutes
4. Rebuild APK
5. Test again

Good luck! 🚀
