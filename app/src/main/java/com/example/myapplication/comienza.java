package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class comienza extends AppCompatActivity {

    private Button registrarse;
    private Button iniciarsesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comienza);

        registrarse = findViewById(R.id.btn_comienza_registrarse);
        iniciarsesion = findViewById(R.id.btn_comienza_iniciarsesion);

        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(comienza.this, registrarse.class);
                startActivity(i);
            }
        });

        iniciarsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(comienza.this, iniciarsesion.class);
                startActivity(i);
            }
        });

    }
}
