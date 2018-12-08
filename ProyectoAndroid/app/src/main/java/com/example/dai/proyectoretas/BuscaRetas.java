package com.example.dai.proyectoretas;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class BuscaRetas extends AppCompatActivity {
    private EditText aux;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca_retas);
        aux=(EditText)findViewById(R.id.etNomDep);

    }

    public void otrasD(View v){
        //Este metodo abre la siguiente pestana y le pasa en el bundle el parametro para el query
        Toast.makeText(this, "hola",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, BuscaRetasDeporte.class);
        Bundle b= new Bundle();
        b.putString("dep",aux.getText().toString());
        intent.putExtras(b);
        Toast.makeText(this, aux.getText().toString(),Toast.LENGTH_LONG).show();
        startActivity(intent);

    }

    public void otrasL(View v){
        //Este metodo abre la siguiente pestana y le pasa en el bundle el parametro para el query
        Intent intent = new Intent(this, BuscaRetasLugar.class);
        Bundle b= new Bundle();
        b.putString("aux",aux.getText().toString());
        intent.putExtras(b);
        startActivity(intent);

    }




}
