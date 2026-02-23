# 🔧 Remove Google Sign-In & Fix Notifications

## Changes to Make:

### 1. Remove Google Sign-In Feature
### 2. Fix Notifications (Android 12+ Exact Alarm Permission)

---

## Issue: Notifications Not Coming

**Root Cause:** Android 12+ requires `SCHEDULE_EXACT_ALARM` permission for exact timing notifications.

**Current Code:** Uses `LocalNotifications.schedule()` but missing exact alarm permission.

**Solution:** Add exact alarm permission to AndroidManifest.xml

---

## Files to Modify:

1. `www/index.html` - Remove Google Sign-In buttons and code
2. `android/app/src/main/AndroidManifest.xml` - Add exact alarm permission

---

Let's do it!
