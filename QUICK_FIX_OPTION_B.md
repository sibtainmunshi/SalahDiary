# Quick Fix - Remove API Restrictions (Option B)

## Why This Works
Firebase is blocking your Android app because it's not registered. By removing restrictions, Firebase will allow requests from anywhere (web, Android, iOS, etc.)

## Steps (5 minutes):

### 1. Go to Google Cloud Console
https://console.cloud.google.com/apis/credentials

### 2. Select Your Project
- Click the project dropdown at top
- Select: **salahdiary-543e1**

### 3. Find Your API Key
- You'll see a list of credentials
- Find the one that starts with: `AIzaSyB7JuG_X2cv0T7f_DpkoR_DN5jtU1n2Z1g`
- Click on it to edit

### 4. Remove Application Restrictions
- Scroll to **"Application restrictions"** section
- Currently it might be set to: "Android apps"
- Change it to: **"None"**
- Click **"Save"** at the bottom

### 5. Test Immediately
- No rebuild needed!
- Just open your APK on phone
- Try login again
- Should work instantly

## Pros & Cons

### Pros:
✅ Works immediately (no rebuild)
✅ No SHA-1 needed
✅ Works on all devices
✅ Easy to test

### Cons:
❌ Less secure (anyone with API key can use it)
❌ Not recommended for production
❌ Could hit quota limits faster

## When to Use This:
- Quick testing/development
- Prototyping
- When you want to test auth flow quickly

## When to Use Option A (SHA-1):
- Production apps
- Apps on Play Store
- When security matters
- Professional projects

## Current Situation:
Your web app works fine because browsers don't have these restrictions.
Your Android APK is blocked because Firebase sees it as an "unknown Android app".

By removing restrictions, you're telling Firebase: "Allow requests from anywhere, I trust all sources."

## Next Steps After Testing:
Once you confirm auth works with no restrictions, you can:
1. Add SHA-1 fingerprints (Option A)
2. Re-enable restrictions
3. Keep it secure for production

This way you can test quickly now, and secure it properly later!
