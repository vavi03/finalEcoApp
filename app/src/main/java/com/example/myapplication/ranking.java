package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class ranking extends AppCompatActivity {

   // private DatabaseReference mDatabase;// ...
   private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private ImageView avatar;
    private Button perfil;
    private Button mundos;
    private TextView nombrePrimerPuesto;
    private ArrayList<usuarioRanking> allUsers;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        nombrePrimerPuesto = findViewById(R.id.tv_ranking_nombrePrimerPuesto);
        avatar = findViewById(R.id.iv_ranking_avatar);//imagen del avatar grandeeeeeeeeeeeeeeeeeeee
        perfil = findViewById(R.id.btn_ranking_perfil);//falta hacer el vinculo con el perfilllllllllllllllllllllllllll
        mundos = findViewById(R.id.btn_ranking_mundos);



        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        DatabaseReference mDatabase = database.getReference("usuarios");

        final LinkedList <PuestoRanking> puestos = new LinkedList<>();

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                //Post post = dataSnapshot.getValue(Post.class);



                allUsers= new ArrayList<>();

                for(DataSnapshot user: dataSnapshot.getChildren()){

                    usuarioRanking ur= user.getValue(usuarioRanking.class);

                    allUsers.add(ur);

                }

                LinkedList<usuarioRanking> usersFirebase = new LinkedList<>();
                for (int i=0; i<allUsers.size(); i++){

                    usersFirebase.add(new usuarioRanking(allUsers.get(i).getNombre(),allUsers.get(i).getPuntajeTotal(), allUsers.get(i).getAvatar() ));

                }

                Collections.sort(usersFirebase, new comparacionPuntaje());

                ///
                if(usersFirebase.size()<6){
                    for (int i=0; i<usersFirebase.size(); i++){
                        puestos.add(new PuestoRanking(usersFirebase.get(i).getNombre(), usersFirebase.get(i).getPuntajeTotal(), usersFirebase.get(i).getAvatar(), i+1));
                    }
                }else{
                    for (int i=0; i<6; i++){
                        puestos.add(new PuestoRanking(usersFirebase.get(i).getNombre(), usersFirebase.get(i).getPuntajeTotal(), usersFirebase.get(i).getAvatar(), i+1));
                    }
                }

                nombrePrimerPuesto.setText(usersFirebase.get(0).getNombre());

                String avatarPrimerPuesto = usersFirebase.get(0).getAvatar();
                if(avatarPrimerPuesto.equals("uno")){
                    avatar.setImageResource(R.drawable.avataruno);
                }
                if(avatarPrimerPuesto.equals("dos")){
                    avatar.setImageResource(R.drawable.avatardos);
                }
                if(avatarPrimerPuesto.equals("tres")){
                    avatar.setImageResource(R.drawable.avatartres);
                }
                if(avatarPrimerPuesto.equals("cuatro")){
                    avatar.setImageResource(R.drawable.avatarcuatro);
                }
                if(avatarPrimerPuesto.equals("cinco")){
                    avatar.setImageResource(R.drawable.avatarcinco);
                }
                if(avatarPrimerPuesto.equals("seis")){
                    avatar.setImageResource(R.drawable.avatarseis);
                }
                // ...
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("<<<<<<<<<", "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };
        mDatabase.addValueEventListener(postListener);


        ListView lista = (ListView) findViewById(R.id.listview_ranking_puestos);

        AdapterPuestoRanking adapterPuestoRanking = new AdapterPuestoRanking(this, puestos);
        lista.setAdapter(adapterPuestoRanking);

        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ranking.this, perfil.class);
                startActivity(i);
           }
     });

        mundos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ranking.this, mundos.class);
                startActivity(i);
            }
        });


    }


}
