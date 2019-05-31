package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class instrucciones extends AppCompatActivity {

    private TextView titulo;
    private TextView instrucciones;
    private Button empezar;
    private String mensaje;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrucciones);
        mensaje="";
        titulo = findViewById(R.id.tv_instrucciones_titulo);
        instrucciones = findViewById(R.id.tv_instrucciones_instrucciones);
        empezar = findViewById(R.id.btn_instrucciones_empezar);

        Intent ii= getIntent();
      final  Bundle b= ii.getExtras();

        if(b!=null){
            String j= (""+ b.get("nivel")).trim();
            mensaje=j;
            if(j.equalsIgnoreCase("1")){
                titulo.setText("Memoria Sensorial");
                instrucciones.setText("Observa la siguiente imagen durante 3 segundos");
            }
            if(j.equalsIgnoreCase("2")){
                titulo.setText("Memoria de Corto Plazo");
                instrucciones.setText("Observa la siguiente secuencia y trata de retener la mayor cantidad de caracteres");
            }
            if(j.equalsIgnoreCase("3")){
                titulo.setText("Memoria a Largo Plazo");
                instrucciones.setText("¿Reconoces estos personajes?");
            }

            if(j.equalsIgnoreCase("4")){
                titulo.setText("Orientacion");
                instrucciones.setText("Concéntrate en el girasol hasta que se agote el tiempo");
            }
            if(j.equalsIgnoreCase("5")){
                titulo.setText("Filtracion");
                instrucciones.setText("Lee el mensaje tachado lo más rápido posible");
            }
            if(j.equalsIgnoreCase("6")){
                titulo.setText("Busqueda por Conjuncion");
                instrucciones.setText("Encuentra al Señor Burns");
            }

        }


        empezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(instrucciones.this, juego.class);
                i.putExtra("nivel", mensaje);
                startActivity(i);
            }
        });

    }
}
