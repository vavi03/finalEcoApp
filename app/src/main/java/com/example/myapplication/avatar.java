package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class avatar extends AppCompatActivity {
    private FirebaseDatabase database;
    private FirebaseAuth mAuth;
    private ToggleButton carauno;
    private ToggleButton carados;
    private ToggleButton caratres;
    private ToggleButton caracuatro;
    private ToggleButton caracinco;
    private ToggleButton caraseis;
    private Button seleccionar;
    private String avatar;
    private Usuario u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar);

        mAuth = FirebaseAuth.getInstance();
        final FirebaseUser user = mAuth.getCurrentUser();
u= new Usuario();
        carauno = findViewById(R.id.tbtn_avatar_carauno);
        carados = findViewById(R.id.tbtn_avatar_carados);
        caratres = findViewById(R.id.tbtn_avatar_caratres);
        caracuatro = findViewById(R.id.tbtn_avatar_caracuatro);
        caracinco = findViewById(R.id.tbtn_avatar_caracinco);
        caraseis = findViewById(R.id.tbtn_avatar_caraseis);
        seleccionar = findViewById(R.id.btn_avatar_seleccionar);

        database = FirebaseDatabase.getInstance();
        carauno.setChecked(true);
        avatar = "uno";


        seleccionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseReference myRef = database.getReference().child("usuarios");
                myRef.child(user.getUid()).child("avatar").setValue(avatar);
                u.setAvatar(avatar);
                Toast.makeText(getApplicationContext(), avatar, Toast.LENGTH_SHORT);
                Intent i = new Intent(avatar.this, mundos.class);
                startActivity(i);
            }
        });

        carauno.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    avatar = "uno";
                   carados.setChecked(false);
                   caratres.setChecked(false);
                   caracuatro.setChecked(false);
                   caracinco.setChecked(false);
                   caraseis.setChecked(false);
                }
            }
        });
        carados.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    avatar = "dos";
                    carauno.setChecked(false);
                    caratres.setChecked(false);
                    caracuatro.setChecked(false);
                    caracinco.setChecked(false);
                    caraseis.setChecked(false);
                }
            }
        });
        caratres.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    avatar = "tres";
                    carados.setChecked(false);
                    carauno.setChecked(false);
                    caracuatro.setChecked(false);
                    caracinco.setChecked(false);
                    caraseis.setChecked(false);
                }
            }
        });
        caracuatro.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    avatar = "cuatro";
                    carados.setChecked(false);
                    caratres.setChecked(false);
                    carauno.setChecked(false);
                    caracinco.setChecked(false);
                    caraseis.setChecked(false);
                }
            }
        });
        caracinco.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    avatar = "cinco";
                    carados.setChecked(false);
                    caratres.setChecked(false);
                    caracuatro.setChecked(false);
                    carauno.setChecked(false);
                    caraseis.setChecked(false);
                }
            }
        });
        caraseis.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    avatar = "seis";
                    carados.setChecked(false);
                    caratres.setChecked(false);
                    caracuatro.setChecked(false);
                    caracinco.setChecked(false);
                    carauno.setChecked(false);
                }
            }
        });
    }
}
