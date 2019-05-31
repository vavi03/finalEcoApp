package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class mundoMemoria extends AppCompatActivity {

    private Button atras;
    private Button memoriaSensorial;
    private Button memoriaCortoPlazo;
    private Button memoriaLargoPlazo;
    private Button mundos;
    private Button ranking;
    private Button perfil;
    private String nivel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mundo_memoria);
         nivel="";
        atras = findViewById(R.id.btn_islamemoria_atras);
        memoriaSensorial = findViewById(R.id.btn_islamemoria_memoriasensorial);
        memoriaCortoPlazo = findViewById(R.id.btn_islamemoria_memoriacp);
        memoriaLargoPlazo = findViewById(R.id.btn_islamemoria_memorialp);
        mundos = findViewById(R.id.btn_islamemoria_mundos);
        ranking = findViewById(R.id.btn_islamemoria_ranking);
        perfil = findViewById(R.id.btn_islamemoria_perfil);

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mundoMemoria.this, mundos.class);
                startActivity(i);
            }
        });

        mundos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mundoMemoria.this, mundos.class);
                startActivity(i);
            }
        });

        ranking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mundoMemoria.this, ranking.class);
                startActivity(i);
            }
        });

       perfil.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(mundoMemoria.this, perfil.class);
               startActivity(i);
            }
      });

        memoriaSensorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nivel="1";
                Intent i = new Intent(mundoMemoria.this, instrucciones.class);
                i.putExtra("nivel", nivel);
                startActivity(i);
            }
        });

        memoriaCortoPlazo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nivel="2";
                Intent i = new Intent(mundoMemoria.this, instrucciones.class);
                i.putExtra("nivel", nivel);
                startActivity(i);


            }
        });

        memoriaLargoPlazo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nivel="3";
                Intent i = new Intent(mundoMemoria.this, instrucciones.class);
                i.putExtra("nivel", nivel);
                startActivity(i);


            }
        });
    }
}
