package com.yourdomain.salahdiary;

import android.os.Bundle;
import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Register plugins
        registerPlugin(com.capacitorjs.plugins.geolocation.GeolocationPlugin.class);
        registerPlugin(com.capacitorjs.plugins.localnotifications.LocalNotificationsPlugin.class);
        registerPlugin(com.capacitorjs.plugins.pushnotifications.PushNotificationsPlugin.class);
        registerPlugin(com.codetrixstudio.capacitor.GoogleAuth.GoogleAuth.class);
    }
}
