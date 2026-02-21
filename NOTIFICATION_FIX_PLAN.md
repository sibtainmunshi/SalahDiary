# Notification Fix - Background Scheduling

## Current Problem:

Notifications only work when app is open because:
1. `schedulePrayerNotifications()` is called only when app opens
2. `setTimeout` for midnight scheduling clears when app closes
3. No background task to reschedule notifications

## Solution Options:

### Option 1: Schedule All Notifications in Advance (Recommended)
Instead of scheduling only today's notifications, schedule for next 7-30 days in advance.

**Pros:**
- ✅ Works even if app not opened
- ✅ Simple implementation
- ✅ No background tasks needed

**Cons:**
- ⚠️ Limited to max notifications (usually 64 on Android)
- ⚠️ If prayer times change (location), need to reschedule

### Option 2: Use Capacitor Background Task
Use `@capacitor/background-task` plugin to run code when app is in background.

**Pros:**
- ✅ Can reschedule dynamically
- ✅ Handles location changes

**Cons:**
- ❌ Requires additional plugin
- ❌ Battery drain
- ❌ May not work on all devices (battery optimization)

### Option 3: Native Android AlarmManager (Advanced)
Create custom Capacitor plugin using Android's AlarmManager.

**Pros:**
- ✅ Most reliable
- ✅ Works even after device restart

**Cons:**
- ❌ Requires native Android code
- ❌ Complex implementation
- ❌ Maintenance overhead

## Recommended Implementation: Option 1

Schedule notifications for next 7 days in advance:
- When app opens, schedule 7 days of notifications
- When user changes location, reschedule all
- When user enables/disables notifications, update all

### Implementation:

```javascript
async function schedulePrayerNotifications() {
    // Clear all existing notifications
    await LocalNotifications.cancel({ notifications: [] });
    
    // Schedule for next 7 days
    const notifications = [];
    for (let day = 0; day < 7; day++) {
        const date = new Date();
        date.setDate(date.getDate() + day);
        
        // Get prayer times for this date
        const prayerTimes = await fetchPrayerTimesForDate(date);
        
        // Create notifications for each prayer
        prayers.forEach((prayer, index) => {
            // 5 min before, at time, 10 min before end
            // ... notification logic
        });
    }
    
    // Schedule all at once
    await LocalNotifications.schedule({ notifications });
}
```

### When to Reschedule:
1. App opens (check if notifications exist)
2. User changes location
3. User enables notifications
4. Once a week (when app opens)

## Implementation Steps:

1. Modify `schedulePrayerNotifications()` to schedule 7 days
2. Add check on app open: if no pending notifications, reschedule
3. Add reschedule on location change
4. Test thoroughly

## Testing:

1. Enable notifications
2. Close app
3. Wait for prayer time
4. ✅ Should receive notification
5. Don't open app for 2-3 days
6. ✅ Should still receive notifications
