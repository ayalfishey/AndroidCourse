package com.androidclass.contactlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.prefs.Preferences;

public class AltSplashActivity extends AppCompatActivity {
    Runnable runnable;
    int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alt_splash);
        changeColors(); //int colors
        final Handler handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                counter++;
                if (counter <= 4) {
                    changeColors();
                    handler.postDelayed(runnable,1000);
                }else{
                    sendToNextActivity();
                }
            }
        };
        handler.postDelayed(runnable,0);
    }

    private void changeColors(){
        TextView[] tv = new TextView[5];
        tv[0]=findViewById(R.id.Color);
        tv[1]=findViewById(R.id.Color2);
        tv[2]=findViewById(R.id.Color3);
        tv[3]=findViewById(R.id.Color4);
        tv[4]=findViewById(R.id.Color5);
        for (TextView txt: tv) {
            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            txt.setBackgroundColor(color);
        }
    }

    private void sendToNextActivity (){
        SharedPreferences pref = getSharedPreferences("loginDetails",MODE_PRIVATE);
        if (!pref.getString("userName", "").equals("")) {
            Intent intent = new Intent(getBaseContext(), ContactListActivity.class);
            Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_LONG).show();
            startActivity(intent);
            finish();
        }else{
            Intent intent = new Intent(getBaseContext(), LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
