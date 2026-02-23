# Google Cloud Console Setup for Native Google Sign-In

## Current Issue
Error Code 10 - "Something went wrong"

This means the Android OAuth client is not properly configured in Google Cloud Console.

## What You Need

### 1. Your App Details
- **Package Name**: `com.yourdomain.salahdiary`
- **SHA-1 Fingerprint (Debug)**: `55:26:6C:1C:9A:48:3C:50:2B:22:B5:49:CA:A3:9D:2C:6A:2A:51:A3`
- **Project ID**: `salahdiary-543e1`

### 2. Current OAuth Clients (from google-services.json)
- **Web Client**: `433228794223-mf6he8m4vieqqfenq309v4o5v8bk4b2r.apps.googleusercontent.com`
- **Android Client (Release)**: `433228794223-0pcvbjp8l4q9in742nbgfj6etku5c3le.apps.googleusercontent.com`
- **Android Client (Debug)**: `433228794223-d9q3rppcvae2o6fmsrpvaoithj9q9sud.apps.googleusercontent.com`

## Step-by-Step Fix

### Step 1: Go to Google Cloud Console
1. Open: https://console.cloud.google.com/
2. Select project: **salahdiary-543e1**
3. Go to: **APIs & Services** → **Credentials**

### Step 2: Check Existing OAuth Clients
Look for these OAuth 2.0 Client IDs:

#### Web Client (Should exist)
- **Name**: Web client (auto created by Google Service)
- **Client ID**: `433228794223-mf6he8m4vieqqfenq309v4o5v8bk4b2r.apps.googleusercontent.com`
- **Type**: Web application

#### Android Clients (Check if they exist)
You should have TWO Android OAuth clients:

**Android Client 1 (Debug)**
- **Name**: Android client (auto created by Google Service) - Debug
- **Client ID**: `433228794223-d9q3rppcvae2o6fmsrpvaoithj9q9sud.apps.googleusercontent.com`
- **Package name**: `com.yourdomain.salahdiary`
- **SHA-1**: `55:26:6C:1C:9A:48:3C:50:2B:22:B5:49:CA:A3:9D:2C:6A:2A:51:A3`

**Android Client 2 (Release)**
- **Name**: Android client (auto created by Google Service) - Release
- **Client ID**: `433228794223-0pcvbjp8l4q9in742nbgfj6etku5c3le.apps.googleusercontent.com`
- **Package name**: `com.yourdomain.salahdiary`
- **SHA-1**: `A0:64:46:20:44:AA:33:99:96:89:42:AB:2F:76:31:48:AE:F5:41:82`

### Step 3: Verify Android OAuth Client Configuration

Click on the **Debug Android client** and verify:

1. **Application type**: Android
2. **Package name**: `com.yourdomain.salahdiary` (must match exactly)
3. **SHA-1 certificate fingerprint**: `55:26:6C:1C:9A:48:3C:50:2B:22:B5:49:CA:A3:9D:2C:6A:2A:51:A3`

### Step 4: If Android Client Doesn't Exist or Wrong SHA-1

If the Android OAuth client doesn't exist or has wrong SHA-1:

1. Click **"+ CREATE CREDENTIALS"**
2. Select **"OAuth client ID"**
3. Choose **"Android"** as application type
4. Fill in:
   - **Name**: `SalahDiary Android (Debug)`
   - **Package name**: `com.yourdomain.salahdiary`
   - **SHA-1 certificate fingerprint**: `55:26:6C:1C:9A:48:3C:50:2B:22:B5:49:CA:A3:9D:2C:6A:2A:51:A3`
5. Click **"CREATE"**
6. Note down the Client ID

### Step 5: Update google-services.json (If Needed)

If you created a new Android OAuth client:

1. Go to Firebase Console: https://console.firebase.google.com/
2. Select project: **salahdiary-543e1**
3. Go to **Project Settings** (gear icon)
4. Scroll down to **Your apps**
5. Click on your Android app
6. Download the new **google-services.json**
7. Replace the file at: `android/app/google-services.json`

### Step 6: Verify OAuth Consent Screen

1. In Google Cloud Console, go to **OAuth consent screen**
2. Make sure:
   - **User type**: External (or Internal if G Suite)
   - **App name**: SalahDiary
   - **User support email**: Your email
   - **Scopes**: `email`, `profile`, `openid`
   - **Test users**: Add your Gmail accounts (if in testing mode)

### Step 7: Enable Google Sign-In API

1. Go to **APIs & Services** → **Library**
2. Search for **"Google Sign-In API"** or **"Google+ API"**
3. Click **"ENABLE"** if not already enabled

## Common Issues

### Issue 1: Wrong Package Name
- **Error**: Code 10
- **Fix**: Package name in OAuth client must exactly match `com.yourdomain.salahdiary`

### Issue 2: Wrong SHA-1 Fingerprint
- **Error**: Code 10
- **Fix**: SHA-1 must be `55:26:6C:1C:9A:48:3C:50:2B:22:B5:49:CA:A3:9D:2C:6A:2A:51:A3`

### Issue 3: OAuth Client Not Created
- **Error**: Code 10
- **Fix**: Create Android OAuth client in Google Cloud Console

### Issue 4: App Not in Test Users (if in Testing mode)
- **Error**: Code 10 or access denied
- **Fix**: Add your Gmail to test users in OAuth consent screen

## After Fixing

1. Wait 5-10 minutes for changes to propagate
2. Rebuild APK: `npx cap sync android && cd android && .\gradlew assembleRelease`
3. Install new APK
4. Test Google Sign-In
5. Should show in-app account picker (no browser!)

## Current Fallback

Right now, if native fails (error code 10), the app automatically falls back to browser redirect method. So sign-in will still work, just not with in-app picker.

## What to Check Right Now

1. Go to Google Cloud Console
2. Check if Android OAuth client exists with correct SHA-1
3. If not, create it following Step 4 above
4. Wait 5-10 minutes
5. Rebuild and test

## Need Help?

Share screenshot of:
1. Google Cloud Console → Credentials page (showing all OAuth clients)
2. The Android OAuth client details (if it exists)

Then I can tell you exactly what's wrong and how to fix it.
