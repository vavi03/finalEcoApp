package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class resultados extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private int puntaje;
    private int puntajeTotal;
    private TextView tv_puntaje;
    private TextView tv_isla;
    private TextView tv_tema;
    private Button  btn;
    private ImageView fondo;
    private Button ranking;
    private String mensaje;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        puntaje = 0;
    puntajeTotal=0;
        tv_puntaje= findViewById(R.id.puntaje);
        tv_isla= findViewById(R.id.islanombre_resultados);
        tv_tema=findViewById(R.id.tema_resultados);
        btn= findViewById(R.id.botonResultados);
        fondo= findViewById(R.id.fondoResultados);
ranking= findViewById(R.id.irARanking);
        Intent ii = getIntent();
        Bundle b = ii.getExtras();

        if (b != null) {
            mensaje = "" + b.get("nivel");
            Log.e(">>>>>", mensaje);

        }

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        DatabaseReference myRefNiveles = database.getReference().child("niveles").child(mensaje);

        ValueEventListener nivelesListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI

               final Nivel n = dataSnapshot.getValue(Nivel.class);


                /**
                 * validaciones segun nivel
                 */


                ranking.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i= new Intent(getApplicationContext(), ranking.class);
                        startActivity(i);
                    }
                });


                if (n.getId() == 1) {//////////////////////////////////nivel 1

                    final FirebaseUser user = mAuth.getCurrentUser();
                    DatabaseReference myRef = database.getReference().child("usuarios").child(user.getUid()).child("resp"+1);

                    ValueEventListener postListener = new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            // Get Post object and use the values to update the UI

                            ArrayList<String> respuestasUsuario= new ArrayList<>();

                            for (DataSnapshot respuesta: dataSnapshot.getChildren()){
                                String r= respuesta.getValue(String.class);

                                respuestasUsuario.add(r);
                            }

                            int puntaje=0;


                            //
                            if(respuestasUsuario.get(0).equalsIgnoreCase(n.getRespuestas().get(0))){
                                puntaje+=200;
                            }

                            if(respuestasUsuario.get(1).equalsIgnoreCase(n.getRespuestas().get(1))){
                                puntaje+=200;
                            }
                            if(respuestasUsuario.get(2).equalsIgnoreCase(n.getRespuestas().get(2))){
                                puntaje+=200;
                            }

                            //*

                            agregarPuntaje(0, puntaje, user.getUid());
                            //////
                            tv_isla.setText("Isla Memoria");
                            tv_tema.setText("Memoria Sensorial");
                            if(puntaje>0){
                                tv_puntaje.setText(puntaje+"\r\nNeurons");
                                fondo.setImageResource(R.drawable.memoriasensorialganar);
                                btn.setBackgroundResource(R.drawable.signivelganar);

                                btn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent i= new Intent(getApplicationContext(), mundos.class);
                                        startActivity(i);
                                    }
                                });
                            }

                            else{
                                tv_puntaje.setText("");
                                fondo.setImageResource(R.drawable.resultadosperder);
                                btn.setBackgroundResource(R.drawable.volverintentar);

                                btn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        String mensaje= "1";
                                        Intent i= new Intent(getApplicationContext(), instrucciones.class);
                                        i.putExtra("nivel", mensaje);
                                        startActivity(i);
                                    }
                                });
                            }

                            // ...
                        }








                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            // Getting Post failed, log a message
                            Log.w(">>>>>", "loadPost:onCancelled", databaseError.toException());
                            // ...
                        }
                    };
                    myRef.addValueEventListener(postListener);


                }//////////////////////////////////nivel 1


                if (n.getId() == 2) {//////////////////////////////////nivel 2

                    final FirebaseUser user = mAuth.getCurrentUser();
                    DatabaseReference myRef = database.getReference().child("usuarios").child(user.getUid()).child("resp"+2);

                    ValueEventListener postListener = new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            // Get Post object and use the values to update the UI

                            ArrayList<String> respuestasUsuario= new ArrayList<>();

                            for (DataSnapshot respuesta: dataSnapshot.getChildren()){
                                String r= respuesta.getValue(String.class);

                                respuestasUsuario.add(r);
                            }

                            char[] letrasUsuario= respuestasUsuario.get(0).toCharArray();

                            int puntaje=0;

                            for (int i=0; i<letrasUsuario.length; i++){

                                if(n.getRespuestas().get(0).indexOf(letrasUsuario[i])>=0){
                                    puntaje+=40;
                                }

                            }




                            //*

                            agregarPuntaje(1, puntaje, user.getUid());
                            //////
                            tv_isla.setText("Isla Memoria");
                            tv_tema.setText("Memoria de Corto Plazo");
                            if(puntaje>0){
                                tv_puntaje.setText(puntaje+"\r\nNeurons");
                                fondo.setImageResource(R.drawable.memoriacortoganar);
                                btn.setBackgroundResource(R.drawable.signivelganar);

                                btn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent i= new Intent(getApplicationContext(), mundos.class);
                                        startActivity(i);
                                    }
                                });
                            }

                            else{
                                tv_puntaje.setText("");
                                fondo.setImageResource(R.drawable.resultadosperder);
                                btn.setBackgroundResource(R.drawable.volverintentar);

                                btn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        String mensaje= "2";
                                        Intent i= new Intent(getApplicationContext(), instrucciones.class);
                                        i.putExtra("nivel", mensaje);
                                        startActivity(i);
                                    }
                                });
                            }

                            // ...
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            // Getting Post failed, log a message
                            Log.w(">>>>>", "loadPost:onCancelled", databaseError.toException());
                            // ...
                        }
                    };
                    myRef.addValueEventListener(postListener);


                }///fin del nivel 2
                if (n.getId() == 3) {//////////////////////////////////nivel 3

                    final FirebaseUser user = mAuth.getCurrentUser();
                    DatabaseReference myRef = database.getReference().child("usuarios").child(user.getUid()).child("resp"+3);

                    ValueEventListener postListener = new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            // Get Post object and use the values to update the UI

                            ArrayList<String> respuestasUsuario= new ArrayList<>();

                            for (DataSnapshot respuesta: dataSnapshot.getChildren()){
                                String r= respuesta.getValue(String.class);

                                respuestasUsuario.add(r);
                            }

                            int puntaje=0;


                            ////falta validar caracteres

                            if(respuestasUsuario.get(0).equalsIgnoreCase(n.getRespuestas().get(0))){
                                puntaje+=200;
                            }
                            if(respuestasUsuario.get(1).equalsIgnoreCase(n.getRespuestas().get(1))){
                                puntaje+=200;
                            }
                            if(respuestasUsuario.get(2).equalsIgnoreCase(n.getRespuestas().get(2))){
                                puntaje+=200;
                            }
                            if(respuestasUsuario.get(3).equalsIgnoreCase(n.getRespuestas().get(3))){
                                puntaje+=200;
                            }



                            //*

                            agregarPuntaje(2, puntaje, user.getUid());
                            //////
                            tv_isla.setText("Isla Memoria");
                            tv_tema.setText("Memoria de Largo Plazo");
                            if(puntaje>0){
                                tv_puntaje.setText(puntaje+"\r\nNeurons");
                              fondo.setImageResource(R.drawable.memorialargoganar);
                                btn.setBackgroundResource(R.drawable.signivelganar);

                                btn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent i= new Intent(getApplicationContext(), mundos.class);
                                        startActivity(i);
                                    }
                                });
                            }

                            else{
                                tv_puntaje.setText("");
                                fondo.setImageResource(R.drawable.resultadosperder);
                                btn.setBackgroundResource(R.drawable.volverintentar);

                                btn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        String mensaje= "3";
                                        Intent i= new Intent(getApplicationContext(), instrucciones.class);
                                        i.putExtra("nivel", mensaje);
                                        startActivity(i);
                                    }
                                });
                            }

                            // ...
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            // Getting Post failed, log a message
                            Log.w(">>>>>", "loadPost:onCancelled", databaseError.toException());
                            // ...
                        }
                    };
                    myRef.addValueEventListener(postListener);


                } //fin nivel 3
                if (n.getId() == 4) {//////////////////////////////////nivel 4

                    final FirebaseUser user = mAuth.getCurrentUser();
                    DatabaseReference myRef = database.getReference().child("usuarios").child(user.getUid()).child("resp"+4);

                    ValueEventListener postListener = new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            // Get Post object and use the values to update the UI

                            ArrayList<String> respuestasUsuario= new ArrayList<>();

                            for (DataSnapshot respuesta: dataSnapshot.getChildren()){
                                String r= respuesta.getValue(String.class);

                                respuestasUsuario.add(r);
                            }

                            int puntaje=0;


                            ////falta validar caracteres

                            if(respuestasUsuario.get(0).equalsIgnoreCase(n.getRespuestas().get(0))){
                                puntaje+=600;
                            }

                            //*

                            agregarPuntaje(3, puntaje, user.getUid());
                            //////
                            tv_isla.setText("Isla Atención");
                            tv_tema.setText("Orientación");
                            if(puntaje>0){
                                tv_puntaje.setText(puntaje+"\r\nNeurons");
                                fondo.setImageResource(R.drawable.orientacionganar);
                                btn.setBackgroundResource(R.drawable.signivelganar);

                                btn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent i= new Intent(getApplicationContext(), mundos.class);
                                        startActivity(i);
                                    }
                                });
                            }

                            else{
                                tv_puntaje.setText("");
                                fondo.setImageResource(R.drawable.resultadosperder);
                                btn.setBackgroundResource(R.drawable.volverintentar);

                                btn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        String mensaje= "4";
                                        Intent i= new Intent(getApplicationContext(), instrucciones.class);
                                        i.putExtra("nivel", mensaje);
                                        startActivity(i);
                                    }
                                });
                            }

                            // ...
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            // Getting Post failed, log a message
                            Log.w(">>>>>", "loadPost:onCancelled", databaseError.toException());
                            // ...
                        }
                    };
                    myRef.addValueEventListener(postListener);


                } //fin nivel 4

                if (n.getId() == 5) {//////////////////////////////////nivel 5

                    final FirebaseUser user = mAuth.getCurrentUser();
                    DatabaseReference myRef = database.getReference().child("usuarios").child(user.getUid()).child("resp"+5);

                    ValueEventListener postListener = new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            // Get Post object and use the values to update the UI

                            ArrayList<String> respuestasUsuario= new ArrayList<>();

                            for (DataSnapshot respuesta: dataSnapshot.getChildren()){
                                String r= respuesta.getValue(String.class);

                                respuestasUsuario.add(r);
                            }

                            int puntaje=0;


                            ////falta validar caracteres

                            if(respuestasUsuario.get(0).equalsIgnoreCase(n.getRespuestas().get(0))){
                                puntaje+=200;
                            }

                            if(respuestasUsuario.get(1).equalsIgnoreCase(n.getRespuestas().get(1))){
                                puntaje+=200;
                            }
                            if(respuestasUsuario.get(2).equalsIgnoreCase(n.getRespuestas().get(2))){
                                puntaje+=200;
                            }
                            //*

                            agregarPuntaje(4, puntaje, user.getUid());
                            //////
                            tv_isla.setText("Isla Atención");
                            tv_tema.setText("Filtración");
                            if(puntaje>0){
                                tv_puntaje.setText(puntaje+"\r\nNeurons");
                                fondo.setImageResource(R.drawable.filtracionganar);
                                btn.setBackgroundResource(R.drawable.signivelganar);

                                btn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent i= new Intent(getApplicationContext(), mundos.class);
                                        startActivity(i);
                                    }
                                });
                            }

                            else{
                                tv_puntaje.setText("");
                                fondo.setImageResource(R.drawable.resultadosperder);
                                btn.setBackgroundResource(R.drawable.volverintentar);

                                btn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        String mensaje= "5";
                                        Intent i= new Intent(getApplicationContext(), instrucciones.class);
                                        i.putExtra("nivel", mensaje);
                                        startActivity(i);
                                    }
                                });
                            }

                            // ...
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            // Getting Post failed, log a message
                            Log.w(">>>>>", "loadPost:onCancelled", databaseError.toException());
                            // ...
                        }
                    };
                    myRef.addValueEventListener(postListener);


                }//fin nivel 5
                if (n.getId() == 6) {//////////////////////////////////nivel 6

                    final FirebaseUser user = mAuth.getCurrentUser();
                    DatabaseReference myRef = database.getReference().child("usuarios").child(user.getUid()).child("resp"+6);

                    ValueEventListener postListener = new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            // Get Post object and use the values to update the UI

                            ArrayList<String> respuestasUsuario= new ArrayList<>();

                            for (DataSnapshot respuesta: dataSnapshot.getChildren()){
                                String r= respuesta.getValue(String.class);

                                respuestasUsuario.add(r);
                            }

                            int puntaje=0;


                            ////falta validar caracteres

                            if(respuestasUsuario.get(0).equalsIgnoreCase(n.getRespuestas().get(0))){
                                puntaje+=600;
                            }


                            //*

                            agregarPuntaje(5, puntaje, user.getUid());
                            //////
                            tv_isla.setText("Isla Atención");
                            tv_tema.setText("Búsqueda por Conjunción");
                            if(puntaje>0){
                                tv_puntaje.setText(puntaje+"\r\nNeurons");
                              fondo.setImageResource(R.drawable.busquedaganar);
                                btn.setBackgroundResource(R.drawable.signivelganar);

                                btn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent i= new Intent(getApplicationContext(), mundos.class);
                                        startActivity(i);
                                    }
                                });
                            }

                            else{
                                tv_puntaje.setText("");
                                fondo.setImageResource(R.drawable.resultadosperder);
                                btn.setBackgroundResource(R.drawable.volverintentar);

                                btn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        String mensaje= "6";
                                        Intent i= new Intent(getApplicationContext(), instrucciones.class);
                                        i.putExtra("nivel", mensaje);
                                        startActivity(i);
                                    }
                                });
                            }

                            // ...
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            // Getting Post failed, log a message
                            Log.w(">>>>>", "loadPost:onCancelled", databaseError.toException());
                            // ...
                        }
                    };
                    myRef.addValueEventListener(postListener);


                }//fin nivel 6
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(">>>>>", "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };
        myRefNiveles.addValueEventListener(nivelesListener);


    }

    public void agregarPuntaje(int nivel, int puntaje, String uid){
            // Write a message to the database
            DatabaseReference myRef = database.getReference().child("usuarios").child(uid).child("puntajes").child(nivel+"");

            myRef.setValue(puntaje);


    }



    public int getPuntajeTotal() {
        return puntajeTotal;
    }

    public void setPuntajeTotal(int puntajeTotal) {
        this.puntajeTotal = puntajeTotal;
    }
}
