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

public class perfil extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private Usuario user;


    private TextView nombre2;
    private TextView puntajeTotal;

    private Button mundos;
    private Button ranking;
    private Button atras;

  ;

    private ImageView avatar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);


        nombre2= findViewById(R.id.perfil_nombre2);

        puntajeTotal= findViewById(R.id.puntajeTotal);

        avatar= findViewById(R.id.avatar);

        atras= findViewById(R.id.btn_atras_perfil);

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        FirebaseUser user = mAuth.getCurrentUser();



        DatabaseReference myRef = database.getReference().child("usuarios").child(user.getUid());

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI

                Usuario u = dataSnapshot.getValue(Usuario.class);

                int pTotal=0;
                for (int i=0; i<u.getPuntajes().size();i++){
                    pTotal+=u.getPuntajes().get(i);
                }


    agregarPuntajeTotal(pTotal, u.getUid());


                nombre2.setText(u.getNombre());
                puntajeTotal.setText( ""+pTotal);

                if(u.getAvatar().equals("uno")){
                    avatar.setImageResource(R.drawable.avatar1);

                }
                if(u.getAvatar().equals("dos")){
                    avatar.setImageResource(R.drawable.avatar2);

                }
                if(u.getAvatar().equals("tres")){
                    avatar.setImageResource(R.drawable.avatar3);

                }
                if(u.getAvatar().equals("cuatro")){
                    avatar.setImageResource(R.drawable.avatar4);

                }
                if(u.getAvatar().equals("cinco")){
                    avatar.setImageResource(R.drawable.avatar5);

                }
                if(u.getAvatar().equals("seis")){
                    avatar.setImageResource(R.drawable.avatar6);

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




        ranking= findViewById(R.id.btn_mundos_ranking2);
        mundos= findViewById(R.id.btn_ranking_mundos2);

        mundos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(), mundos.class);
                startActivity(i);
            }
        });

        ranking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(), ranking.class);
                startActivity(i);
            }
        });
        ;
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(), mundos.class);
                startActivity(i);
            }
        });







    }
    public void agregarPuntajeTotal( int puntaje, String uid){
        // Write a message to the database
        DatabaseReference myRef = database.getReference().child("usuarios").child(uid).child("puntajeTotal");

        myRef.setValue(puntaje);


    }


}
