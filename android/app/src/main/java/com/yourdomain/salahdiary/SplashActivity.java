package com.yourdomain.salahdiary; // Yeh line change mat karna

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper; // Isko add karna zaroori hai

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                // MainActivity aapki main app screen hai
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
                finish(); // is activity ko band kar do
            }
        }, 2000); // 2000 milliseconds = 2 seconds ka delay
    }
}