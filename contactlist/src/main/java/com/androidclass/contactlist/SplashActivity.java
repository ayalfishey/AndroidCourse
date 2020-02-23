package com.androidclass.contactlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.util.prefs.Preferences;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final LottieAnimationView loginAni = findViewById(R.id.joinAni);
        final LottieAnimationView splashAni = findViewById(R.id.loadingAni);
        final SharedPreferences pref = getSharedPreferences("loginDetails", MODE_PRIVATE);
//        SharedPreferences.Editor editor = pref.edit();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!pref.getString("userName", "").equals("")) {
                    Intent intent = new Intent(getBaseContext(), ContactListActivity.class);
                    Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_LONG).show();
                    startActivity(intent);
                    finish();
                }
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        splashAni.cancelAnimation();
                        splashAni.setVisibility(View.INVISIBLE);
                        loginAni.playAnimation();
                        loginAni.setVisibility(View.VISIBLE);
                    }
                },100);

            }
        }, 5000);
        loginAni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
