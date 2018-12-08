package com.example.dai.proyectoretas;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class BuscaRetasDeporte extends AppCompatActivity {
    private Spinner spReta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca_retas_deporte);
        spReta=(Spinner)findViewById(R.id.spRetas);
        String ana;
        ArrayList<String> elementos= new ArrayList<String>();


        AdminSQLiteOpenHelper2 adminR= new AdminSQLiteOpenHelper2(this,"adminR",null,1);
        SQLiteDatabase db = adminR.getWritableDatabase();
        Bundle bundle= this.getIntent().getExtras();
         ana= bundle.get("dep").toString();
        Toast.makeText(this,ana,Toast.LENGTH_LONG).show();


        //ArrayList<String> elementos= new ArrayList<String>();
        Cursor fila=db.rawQuery("select folio,deporte,lugar,hora from Reta where deporte='Basquetbol'",null);
        while (fila.moveToNext()){
            Toast.makeText(this,ana,Toast.LENGTH_LONG).show();
            String concatena="folio:"+fila.getString(0)+" /deporte: "+fila.getString(1)
                    +" /lugar: "+fila.getString(2)+" /hora: "+fila.getString(3);
            elementos.add(concatena);
        }

            ArrayAdapter adp= new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,elementos);

            spReta.setAdapter(adp);








    }
}
