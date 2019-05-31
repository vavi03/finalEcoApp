package com.example.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class Splash extends AppCompatActivity {

    private final int DURACION_SPLASH=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i= new Intent(getApplicationContext(), comienza.class);
                startActivity(i);
/** Fading Transition Effect */
                Splash.this.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            };
        }, DURACION_SPLASH);

    }
}
