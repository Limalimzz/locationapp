package com.social.locationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.util.HashMap;

public class MainActivity2 extends AppCompatActivity {
    private static int SPLASH_SCREEN_TIME_OUT=2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(new SessionManager(MainActivity2.this).isLoggedIn()){
                    HashMap<String, String> m = new SessionManager(MainActivity2.this).getUserDetails();
                    String latitude=m.get("latitide");
                    String longitude=m.get("longitude");

                    Intent i=new Intent(MainActivity2.this,MainActivity3.class);
                    i.putExtra("latitide",latitude);
                    i.putExtra("latitide",longitude);
                    startActivity(i);


                }
                else {
                    Intent i=new Intent(MainActivity2.this,MainActivity.class);
                    startActivity(i);

                }
                finish();
            }
        }, SPLASH_SCREEN_TIME_OUT);
    }
}