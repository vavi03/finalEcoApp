package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class mundos extends AppCompatActivity {

    private Button info;
    private Button perfil;
    private Button ranking;
    private Button islamemoria;
    private ImageButton islaatencion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mundos);

        info = findViewById(R.id.btn_mundos_info);
        perfil = findViewById(R.id.btn_mundos_perfil);
        ranking = findViewById(R.id.btn_mundos_ranking);
        islamemoria = findViewById(R.id.btn_mundos_islamemoria);
        islaatencion = findViewById(R.id.btn_mundos_islaatencion);

        //con este codigo se le cambia la imagen, toca acomodarla bien----------------
        //islaatencion.setImageResource(R.drawable.islaatencion);

        islamemoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mundos.this, mundoMemoria.class);
                startActivity(i);
            }
        });

        islaatencion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mundos.this, mundoAtencion.class);
                startActivity(i);
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mundos.this, informacion.class);
                startActivity(i);
            }
        });

        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mundos.this, perfil.class);
                startActivity(i);
            }
        });

        ranking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mundos.this, ranking.class);
                startActivity(i);

            }
        });
    }
}
