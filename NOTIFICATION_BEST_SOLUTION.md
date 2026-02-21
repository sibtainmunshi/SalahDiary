# Best Notification Solution - Long-term Reliability

## Problem:
User might not open app for weeks/months, but still needs prayer notifications.

## Why Simple Solutions Won't Work:

### Option 1: Schedule 30 Days
- ❌ Still fails after 30 days
- ❌ Android limits pending notifications (~500)
- ❌ If user changes location, all notifications wrong

### Option 2: Background Task
- ❌ Android kills background tasks to save battery
- ❌ Not reliable for long-term
- ❌ May not work on all devices

## Best Solution: Capacitor Local Notifications with Repeating Schedule

Use **repeating notifications** instead of scheduling individual ones!

### How It Works:

```javascript
// Instead of scheduling each day separately:
await LocalNotifications.schedule({
    notifications: [{
        id: 1,
        title: "Fajr Time",
        body: "Time for Fajr prayer 🕌",
        schedule: {
            // REPEAT DAILY at specific time
            on: {
                hour: 5,
                minute: 30
            },
            repeats: true, // ⭐ This is the key!
            allowWhileIdle: true
        }
    }]
});
```

### Benefits:
- ✅ Works forever (until user disables)
- ✅ No need to reschedule
- ✅ Survives device restart
- ✅ Works even if app never opened

### Limitations:
- ⚠️ Prayer times change daily (sunrise/sunset based)
- ⚠️ Can't use simple repeating schedule

## Real Best Solution: Native Android Plugin

For prayer times that change daily, we need:

1. **Custom Capacitor Plugin** with Android AlarmManager
2. **Calculate prayer times natively** in background
3. **Schedule exact alarms** for each prayer

### Implementation Plan:

#### Step 1: Create Native Plugin
```java
// Android native code
public class PrayerNotificationPlugin extends Plugin {
    @PluginMethod
    public void schedulePrayerNotifications(PluginCall call) {
        // Use AlarmManager to schedule
        // Calculate prayer times for next 30 days
        // Set exact alarms
    }
}
```

#### Step 2: Use in App
```javascript
await PrayerNotifications.schedulePrayerNotifications({
    location: { lat: 23.0225, lon: 72.5714 },
    method: "1_hanafi"
});
```

## Practical Solution for Now:

Since creating native plugin is complex, let's use a **hybrid approach**:

### Hybrid Solution: 30 Days + Smart Reschedule

1. **Schedule 30 days** of notifications when app opens
2. **Add a daily notification** that opens app in background to reschedule
3. **Use Capacitor's background fetch** to check and reschedule

```javascript
// Schedule 30 days of prayer notifications
async function schedulePrayerNotifications() {
    const notifications = [];
    
    for (let day = 0; day < 30; day++) {
        const date = new Date();
        date.setDate(date.getDate() + day);
        
        // Fetch prayer times for this date
        const times = await getPrayerTimesForDate(date);
        
        // Create notifications for each prayer
        // ... add to notifications array
    }
    
    // Add a "reschedule reminder" notification for day 25
    notifications.push({
        id: 9999,
        title: "Salah Diary",
        body: "Tap to ensure prayer notifications continue",
        schedule: { at: new Date(Date.now() + 25 * 24 * 60 * 60 * 1000) },
        // When tapped, app opens and reschedules
    });
    
    await LocalNotifications.schedule({ notifications });
}
```

## Recommendation:

**For MVP (Minimum Viable Product):**
- Use 30-day scheduling
- Add reminder notification on day 25
- Most users open app at least once a month

**For Production (Long-term):**
- Create custom native plugin
- Use Android AlarmManager
- Calculate prayer times in background
- 100% reliable

## What Should We Do Now?

1. **Quick Fix:** Implement 30-day scheduling (30 minutes)
2. **Better Fix:** Add background task plugin (2-3 hours)
3. **Best Fix:** Create native plugin (1-2 days)

Which one do you want? 🤔
