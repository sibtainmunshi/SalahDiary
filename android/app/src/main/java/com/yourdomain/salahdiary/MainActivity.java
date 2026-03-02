package com.yourdomain.salahdiary;

import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.provider.Settings;
import android.widget.Toast;

import com.getcapacitor.BridgeActivity;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

public class MainActivity extends BridgeActivity {
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Register custom plugins
        registerPlugin(ExactAlarmPlugin.class);
        registerPlugin(BatteryOptimizationPlugin.class);
        
        // Check and request exact alarm permission for Android 12+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            checkExactAlarmPermission();
        }
        
        // Check battery optimization
        checkBatteryOptimization();
    }
    
    private void checkExactAlarmPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            if (alarmManager != null && !alarmManager.canScheduleExactAlarms()) {
                // Show toast to inform user
                Toast.makeText(this, 
                    "Please enable 'Alarms & reminders' permission for prayer notifications", 
                    Toast.LENGTH_LONG).show();
                
                // Open settings after a delay
                new android.os.Handler().postDelayed(() -> {
                    try {
                        Intent intent = new Intent(Settings.ACTION_REQUEST_SCHEDULE_EXACT_ALARM);
                        intent.setData(Uri.parse("package:" + getPackageName()));
                        startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }, 2000);
            }
        }
    }
    
    private void checkBatteryOptimization() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
            if (powerManager != null && !powerManager.isIgnoringBatteryOptimizations(getPackageName())) {
                // Show toast
                Toast.makeText(this, 
                    "Please disable battery optimization for reliable prayer notifications", 
                    Toast.LENGTH_LONG).show();
                
                // Open battery optimization settings after a delay
                new android.os.Handler().postDelayed(() -> {
                    try {
                        Intent intent = new Intent(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
                        intent.setData(Uri.parse("package:" + getPackageName()));
                        startActivity(intent);
                    } catch (Exception e) {
                        // Fallback to general battery settings
                        try {
                            Intent fallbackIntent = new Intent(Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS);
                            startActivity(fallbackIntent);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }, 4000); // 4 seconds after exact alarm prompt
            }
        }
    }
    
    // Custom plugin to check exact alarm permission from JavaScript
    @CapacitorPlugin(name = "ExactAlarm")
    public static class ExactAlarmPlugin extends Plugin {
        
        @PluginMethod
        public void canScheduleExactAlarms(PluginCall call) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                AlarmManager alarmManager = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);
                boolean canSchedule = alarmManager != null && alarmManager.canScheduleExactAlarms();
                call.resolve(new com.getcapacitor.JSObject().put("value", canSchedule));
            } else {
                // For Android < 12, exact alarms don't need special permission
                call.resolve(new com.getcapacitor.JSObject().put("value", true));
            }
        }
        
        @PluginMethod
        public void requestExactAlarmPermission(PluginCall call) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                try {
                    Intent intent = new Intent(Settings.ACTION_REQUEST_SCHEDULE_EXACT_ALARM);
                    intent.setData(Uri.parse("package:" + getContext().getPackageName()));
                    getActivity().startActivity(intent);
                    call.resolve();
                } catch (Exception e) {
                    call.reject("Failed to open settings", e);
                }
            } else {
                call.resolve();
            }
        }
    }
    
    // Custom plugin to check and request battery optimization exemption
    @CapacitorPlugin(name = "BatteryOptimization")
    public static class BatteryOptimizationPlugin extends Plugin {
        
        @PluginMethod
        public void isIgnoringBatteryOptimizations(PluginCall call) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                PowerManager powerManager = (PowerManager) getContext().getSystemService(Context.POWER_SERVICE);
                boolean isIgnoring = powerManager != null && 
                    powerManager.isIgnoringBatteryOptimizations(getContext().getPackageName());
                call.resolve(new com.getcapacitor.JSObject().put("value", isIgnoring));
            } else {
                // For Android < 6.0, battery optimization doesn't exist
                call.resolve(new com.getcapacitor.JSObject().put("value", true));
            }
        }
        
        @PluginMethod
        public void requestIgnoreBatteryOptimizations(PluginCall call) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                try {
                    Intent intent = new Intent(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
                    intent.setData(Uri.parse("package:" + getContext().getPackageName()));
                    getActivity().startActivity(intent);
                    call.resolve();
                } catch (Exception e) {
                    // Fallback to general battery settings
                    try {
                        Intent fallbackIntent = new Intent(Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS);
                        getActivity().startActivity(fallbackIntent);
                        call.resolve();
                    } catch (Exception ex) {
                        call.reject("Failed to open battery settings", ex);
                    }
                }
            } else {
                call.resolve();
            }
        }
        
        @PluginMethod
        public void getManufacturer(PluginCall call) {
            String manufacturer = Build.MANUFACTURER.toLowerCase();
            call.resolve(new com.getcapacitor.JSObject().put("value", manufacturer));
        }
    }
}

