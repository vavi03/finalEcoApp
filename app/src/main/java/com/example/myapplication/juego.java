package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class juego extends AppCompatActivity {

    private WebView webview;
    private String mensaje;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);


        mAuth = FirebaseAuth.getInstance();

        webview= findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());
        Intent ii= getIntent();
        Bundle b= ii.getExtras();

        if(b!=null) {
            mensaje= ""+b.get("nivel");
            Log.e(">>>>>", mensaje);

        }
        webview.loadUrl("https://vavi03.github.io/finalEco/juego"+mensaje+".html");
        webview.setWebViewClient(new WebViewClient() {

            @Override

            public void onPageFinished(WebView view, String url){
                FirebaseUser user = mAuth.getCurrentUser();
                //Here you want to use .loadUrl again
                //on the webview object and pass in
                //"javascript:<your javaScript function"
                webview.loadUrl("javascript:myUser('" + user.getUid() + "')"); //if passing in an object. Mapping may need to take place
            }

            @Override

            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // check the URL, and do whatever you need to do according to the URL
                   Intent intent = new Intent(getApplicationContext(), resultados.class);
                intent.putExtra("nivel", mensaje);
                    startActivity(intent);
                    return true; // Handle By application itself

            }
        });

     //   Toast.makeText(getApplicationContext(), "https://vavi03.github.io/finalEco/juego"+mensaje+".html", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK)
            Toast.makeText(getApplicationContext(), "back press",
                    Toast.LENGTH_LONG).show();

        return false;
        // Disable back button..............
    }
}

