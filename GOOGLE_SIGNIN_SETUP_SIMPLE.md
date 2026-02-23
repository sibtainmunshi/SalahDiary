# Google Sign-In – 100% Working Setup (In-App)

## Recommendation: Use **In-App (Native)** Only

- **In-app:** Google account picker opens inside the app. One-time config (SHA-1), then it works every time.
- **Chrome/redirect:** In Capacitor apps, redirect goes to localhost and fails on device. Don’t use it for this app.

So use **only native Google Sign-In** on Android. Your app code is already set up for that.

---

## One-Time Setup (Google Cloud)

Error 10 means Google doesn’t recognise your app. You need an **Android** OAuth client with your app’s **SHA-1** and **package name**.

### Step 1: Get your SHA-1

1. Open **PowerShell** or **Command Prompt** in project folder (`C:\Users\...\SalahDiary`).
2. Run:
   - **PowerShell:** **`.\get-sha1.bat`**
   - **CMD:** **`get-sha1.bat`**
3. Copy the **SHA1:** line (e.g. `55:26:6C:1C:9A:48:...`). Use the **DEBUG** one for testing.

### Step 2: Create Android OAuth client

1. Go to: **https://console.cloud.google.com/**
2. Select project: **salahdiary-543e1** (top dropdown).
3. Left menu: **APIs & Services** → **Credentials**.
4. Click **+ CREATE CREDENTIALS** → **OAuth client ID**.
5. **Application type:** **Android**.
6. Fill:
   - **Name:** `SalahDiary Android` (any name)
   - **Package name:** `com.yourdomain.salahdiary` (exactly this)
   - **SHA-1 certificate fingerprint:** paste the SHA-1 from Step 1 (with colons, e.g. `55:26:6C:1C:9A:48:3C:50:2B:22:B5:49:CA:A3:9D:2C:6A:2A:51:A3`)
7. Click **CREATE**.

### Step 3: OAuth consent screen (if you see “Sign in blocked”)

1. Left menu: **OAuth consent screen**.
2. If **User type** is “External” and status is **Testing**:
   - Scroll to **Test users** → **+ ADD USERS**.
   - Add the Gmail address you use to test the app.
   - **SAVE**.

### Step 4: Wait and test

- Wait **5–10 minutes** after creating the Android OAuth client.
- Uninstall the app from the phone (optional but recommended).
- Build and install again, then tap **Continue with Google**.

---

## Checklist

| Item | Your app |
|------|----------|
| Package name | `com.yourdomain.salahdiary` ✓ |
| Web Client ID (serverClientId) | In `capacitor.config.json` ✓ |
| GoogleAuth plugin | Registered in MainActivity ✓ |
| Android OAuth client | You add in Google Cloud (Steps 1–2) |
| SHA-1 | From `get-sha1.bat` → paste in Android OAuth client |

---

## Release build (later)

When you build a **signed release** APK, run `get-sha1.bat` and copy the **RELEASE** SHA-1. In Google Cloud, create **another** OAuth client (Application type: **Android**), same package name `com.yourdomain.salahdiary`, with that release SHA-1. Then both debug and release will work.

---

## Summary

- Use **in-app (native)** Google Sign-In only.
- One-time fix: **Google Cloud** → **Credentials** → **Create OAuth client** → **Android** with package `com.yourdomain.salahdiary` and SHA-1 from `get-sha1.bat`.
- No Chrome/redirect needed; avoid it for this app.
