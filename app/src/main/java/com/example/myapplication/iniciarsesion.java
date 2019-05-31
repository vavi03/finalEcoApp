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

public class iniciarsesion extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText correo;
    private EditText contrasena;
    private Button entrar;
    private Button atras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciarsesion);
        mAuth = FirebaseAuth.getInstance();
        correo = findViewById(R.id.edt_iniciarsesion_correo);
        contrasena = findViewById(R.id.edt_iniciarsesion_contrasena);
        entrar = findViewById(R.id.btn_iniciarsesion_entrar);
        atras = findViewById(R.id.btn_iniciarsesion_atras);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //aqui hay que evaluar que haya escrito algo y que el usuario y la contraseña existan y que esten correctas
                iniciar();
            }
        });

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(iniciarsesion.this, comienza.class);
                startActivity(i);
            }
        });



    }

    public void iniciar(){
        final String email= correo.getText().toString().trim();
        final String contra= contrasena.getText().toString().trim();


        mAuth.signInWithEmailAndPassword(email, contra)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(">>>>>", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent i = new Intent(iniciarsesion.this, mundos.class);
                            startActivity(i);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(">>>>>>", "signInWithEmail:failure", task.getException());
                            FirebaseAuthException e = (FirebaseAuthException )task.getException();
                            Toast.makeText(getApplicationContext(), "Failed Registration: "+e.getMessage(),
                                    Toast.LENGTH_LONG).show();

                        }

                        // ...
                    }
                });
    }
}
