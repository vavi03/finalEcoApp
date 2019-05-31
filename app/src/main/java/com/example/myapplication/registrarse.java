package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class registrarse extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;

    private EditText usuario;
    private EditText correo;
    private EditText contrasena;
    private Button atras;
    private Button entrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        usuario = findViewById(R.id.edt_registrarse_usuario);
        correo = findViewById(R.id.edt_registrarse_correo);
        contrasena = findViewById(R.id.edt_registrarse_contrasena);
        atras = findViewById(R.id.btn_registrarse_atras);
        entrar = findViewById(R.id.btn_registrarse_entrar);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //aqui toca mirar si no está creado el usuario, si
               registroUsuario();
            }
        });

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(registrarse.this, comienza.class);
                startActivity(i);
            }
        });
    }


        private void guardarEnDB(Usuario newData){
            // Write a message to the database
            DatabaseReference myRef = database.getReference().child("usuarios");

            myRef.child(newData.getUid()).setValue(newData);
        }


    private void registroUsuario() {
        final String nombre= usuario.getText().toString().trim();
        final String email= correo.getText().toString().trim();
        final String contra= contrasena.getText().toString().trim();

        mAuth.createUserWithEmailAndPassword(email, contra)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("<<<<<", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                            guardarEnDB(new Usuario(nombre, email, contra, user.getUid()));

                            Toast.makeText(getApplicationContext(), "Authentication done.",
                                    Toast.LENGTH_SHORT).show();
                            ///
                            Intent intent = new Intent(getApplicationContext(), avatar.class);
                            startActivity(intent);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(">>>>>", "createUserWithEmail:failure", task.getException());
                            FirebaseAuthException e = (FirebaseAuthException )task.getException();
                            Toast.makeText(getApplicationContext(), "Failed Registration: "+e.getMessage(),
                                    Toast.LENGTH_LONG).show();

                            ///

                        }

                        // ...
                    }
                });
    }
}
