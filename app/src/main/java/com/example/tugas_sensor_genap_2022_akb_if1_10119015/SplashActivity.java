/*
Nama    : Agi Sutrisna
Nim     : 10119015
Kelas   : IF1
 */


package com.example.tugas_sensor_genap_2022_akb_if1_10119015;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent (SplashActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        },3000);
    }
}