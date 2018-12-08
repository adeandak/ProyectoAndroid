package com.example.dai.proyectoretas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Fifa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifa);
        WebView web=(WebView)findViewById(R.id.webView1);
        web.loadUrl("https://es.fifa.com/");
    }
}
