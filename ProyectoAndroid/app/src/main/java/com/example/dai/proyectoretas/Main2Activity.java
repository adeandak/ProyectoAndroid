package com.example.dai.proyectoretas;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }


    public void consulta(View v){
        AdminSQLiteOpenHelper1 adminJ= new AdminSQLiteOpenHelper1(this,"adminJ",null,1);
        SQLiteDatabase db = adminJ.getWritableDatabase();

        Bundle bundle= this.getIntent().getExtras();
        String aux = bundle.get("session").toString();


        try{
            Cursor fila=db.rawQuery("select id,contra from Jugador where id="+aux,null);
            if(fila.moveToFirst()){
                Toast.makeText(this,"usuario: "+fila.getString(0)+",   contra: "+fila.getString(1),Toast.LENGTH_LONG).show();


            }
            else
                Toast.makeText(this,"no se encontró",Toast.LENGTH_LONG).show();

        }catch(Exception ex){
            Toast.makeText(this,"ERROR"+ex,Toast.LENGTH_LONG).show();
        }






        db.close();


    }










    public void crear(View v){
        Intent intent = new Intent(this,CrearNuevaReta.class);

        Bundle bundle= this.getIntent().getExtras();
        String idUsu = bundle.get("session").toString();

        Bundle b= new Bundle();
        b.putString("idUsuario",idUsu);
        intent.putExtras(b);
        startActivity(intent);
    }
    public void eliminar(View v){
        Intent intent = new Intent(this,EliminarReta.class);
        Bundle bundle= this.getIntent().getExtras();
        String idUsu = bundle.get("session").toString();

        Bundle b= new Bundle();
        b.putString("idUsuario",idUsu);
        intent.putExtras(b);
        startActivity(intent);
    }
    public void modificar(View v){
        Intent intent = new Intent(this,ModificaReta.class);
        Bundle bundle= this.getIntent().getExtras();
        String idUsu = bundle.get("session").toString();

        Bundle b= new Bundle();
        b.putString("idUsuario",idUsu);
        intent.putExtras(b);
        startActivity(intent);
    }

    public void fifa(View v){
        Intent intent = new Intent(this, Fifa.class);

        startActivity(intent);
    }

    public void buscar(View v){
        Intent intent = new Intent(this, BuscaRetas.class);

        startActivity(intent);
    }




}
