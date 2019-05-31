package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class mundoAtencion extends AppCompatActivity {

    private Button atras;
    private Button orientacion;
    private Button filtracion;
    private Button busqueda;
    private Button mundos;
    private Button ranking;
    private Button perfil;
    private String nivel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mundo_atencion);
        nivel="";
        atras = findViewById(R.id.btn_islaatencion_atras);
        orientacion = findViewById(R.id.btn_islaatencion_orientacion);
        filtracion = findViewById(R.id.btn_islaatencion_filtracion);
        busqueda = findViewById(R.id.btn_islaatencion_busqueda);
        mundos = findViewById(R.id.btn_islaatencion_mundos);
        ranking = findViewById(R.id.btn_islaatencion_ranking);
        perfil = findViewById(R.id.btn_islaatencion_perfil);

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mundoAtencion.this, mundos.class);
                startActivity(i);
            }
        });

        mundos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mundoAtencion.this, mundos.class);
                startActivity(i);
            }
        });

        ranking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mundoAtencion.this, ranking.class);
                startActivity(i);
            }
        });

        perfil.setOnClickListener(new View.OnClickListener() {
           @Override
        public void onClick(View v) {
                Intent i = new Intent(mundoAtencion.this, perfil.class);
                startActivity(i);
           }
    });

        orientacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nivel="4";
                Intent i = new Intent(mundoAtencion.this, instrucciones.class);
                i.putExtra("nivel", nivel);
                startActivity(i);
            }
        });


        filtracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nivel="5";
                Intent i = new Intent(mundoAtencion.this, instrucciones.class);
                i.putExtra("nivel", nivel);
                startActivity(i);
            }
        });


        busqueda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nivel="6";
                Intent i = new Intent(mundoAtencion.this, instrucciones.class);
                i.putExtra("nivel", nivel);
                startActivity(i);
            }
        });


    }
}
