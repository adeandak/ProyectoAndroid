package com.example.dai.proyectoretas;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class BuscaRetasLugar extends AppCompatActivity {
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca_retas_lugar);
        spinner=(Spinner)findViewById(R.id.spRetasL);

        llenarSpinner();
    }

    public void llenarSpinner(){
        int i=0;
        String ayuda=null;
        try {
            AdminSQLiteOpenHelper2 adminR= new AdminSQLiteOpenHelper2(this,"adminR",null,1);
            i++;
            SQLiteDatabase db = adminR.getWritableDatabase();
            Toast.makeText(this, i++, Toast.LENGTH_SHORT).show();
            Bundle bundle = this.getIntent().getExtras();
            //Toast.makeText(this, i++, Toast.LENGTH_SHORT).show();
            String aux = bundle.get("aux").toString();
            //Toast.makeText(this, i++, Toast.LENGTH_SHORT).show();


            ArrayList<String> elementos = new ArrayList<String>();
            //Toast.makeText(this, i++, Toast.LENGTH_SHORT).show();

            Cursor fila = db.rawQuery("select folio,deporte,lugar,hora from Reta where lugar=" + aux, null);
            //Toast.makeText(this, i++, Toast.LENGTH_SHORT).show();
            while (fila.moveToNext()) {
                //Toast.makeText(this, i++, Toast.LENGTH_SHORT).show();

                String concatena = "folio:" + fila.getString(0) + " /deporte: " + fila.getString(1) + " /lugar: " + fila.getString(2) + " /hora: " + fila.getString(3);
                elementos.add(concatena);


            }
            //Toast.makeText(this, "Ya salio del while"+i++, Toast.LENGTH_SHORT).show();
            ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, elementos);
            //Toast.makeText(this, i++, Toast.LENGTH_SHORT).show();

            spinner.setAdapter(adp);
            db.close();
        }catch (Exception e){
            Toast.makeText(this, "Quien sabe que paso"+i+" "+ayuda, Toast.LENGTH_SHORT).show();

        }
    }
}
