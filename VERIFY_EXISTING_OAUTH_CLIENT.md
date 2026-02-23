# ✅ Verify Existing Android OAuth Client

## Good News!
Tumhare paas already 2 Android OAuth clients hain Google Cloud Console mein! 🎉

## What to Do Now

### Step 1: Click on First Android Client
1. Click on: **"Android client for com.yourdomain.salahdiary"** (Feb 21, 2026)
2. Client ID ending: `...8pcv...` ya `...d9q3...`

### Step 2: Verify SHA-1 Fingerprint

Check karo ki isme yeh SHA-1 hai ya nahi:

**Debug SHA-1 (Testing ke liye):**
```
55:26:6C:1C:9A:48:3C:50:2B:22:B5:49:CA:A3:9D:2C:6A:2A:51:A3
```

**Release SHA-1 (Production ke liye):**
```
A0:64:46:20:44:AA:33:99:96:89:42:AB:2F:76:31:48:AE:F5:41:82
```

### Step 3: If SHA-1 Wrong or Missing

1. Click **"EDIT"** button (pencil icon)
2. Update **SHA-1 certificate fingerprint** field
3. For testing, use Debug SHA-1: `55:26:6C:1C:9A:48:3C:50:2B:22:B5:49:CA:A3:9D:2C:6A:2A:51:A3`
4. Click **"SAVE"**

### Step 4: Check Second Android Client

Repeat Step 1-3 for the second Android client.

**Ideally:**
- One client should have Debug SHA-1
- Other client should have Release SHA-1

### Step 5: Verify OAuth Consent Screen

1. Left sidebar → **OAuth consent screen**
2. Scroll down to **Test users** section
3. Check if your Gmail is added
4. If not, click **"+ ADD USERS"** and add your Gmail
5. Click **"SAVE"**

---

## Expected Configuration

After verification, you should have:

### Android Client 1 (Debug)
```
Name: Android client for com.yourdomain.salahdiary
Package: com.yourdomain.salahdiary
SHA-1: 55:26:6C:1C:9A:48:3C:50:2B:22:B5:49:CA:A3:9D:2C:6A:2A:51:A3
```

### Android Client 2 (Release)
```
Name: Android client for com.yourdomain.salahdiary
Package: com.yourdomain.salahdiary
SHA-1: A0:64:46:20:44:AA:33:99:96:89:42:AB:2F:76:31:48:AE:F5:41:82
```

---

## After Fixing

1. **Wait 5-10 minutes** for changes to propagate
2. **Rebuild APK**:
   ```bash
   cd android
   .\gradlew clean
   .\gradlew assembleRelease
   ```
3. **Install and test**

---

## Quick Checklist

- [ ] Clicked on Android OAuth client
- [ ] Verified SHA-1 fingerprint
- [ ] Updated if wrong
- [ ] Added Gmail to test users
- [ ] Waited 10 minutes
- [ ] Rebuilt APK
- [ ] Tested Google Sign-In

---

**Next:** Click on one Android client and share screenshot of its details page!
