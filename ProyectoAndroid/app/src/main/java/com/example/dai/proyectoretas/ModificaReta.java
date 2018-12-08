package com.example.dai.proyectoretas;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class ModificaReta extends AppCompatActivity {

    private Spinner spReta;
    private EditText lugarM;
    private EditText horaM;
    private EditText folioM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifica_reta);
        spReta=(Spinner)findViewById(R.id.spRetas);
        lugarM=(EditText)findViewById(R.id.etLugarMod);
        horaM=(EditText) findViewById(R.id.etHoraMod);
        folioM=(EditText)findViewById(R.id.etFolMod) ;

        //Se llena el Spinner con las retas creadas por el usuario
        AdminSQLiteOpenHelper2 adminR= new AdminSQLiteOpenHelper2(this,"adminR",null,1);
        SQLiteDatabase db = adminR.getWritableDatabase();
        Bundle bundle= this.getIntent().getExtras();
        String aux = bundle.get("idUsuario").toString();


        ArrayList<String> elementos= new ArrayList<String>();

        Cursor fila=db.rawQuery("select folio,deporte,lugar,hora from Reta where idJugador="+aux,null);
        while (fila.moveToNext()){
            String concatena="folio:"+fila.getString(0)+" /deporte: "+fila.getString(1)
                            +" /lugar: "+fila.getString(2)+" /hora: "+fila.getString(3);
            elementos.add(concatena);
        }
        ArrayAdapter adp= new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,elementos);

        //En esta clase el metodo funciona excelente
        spReta.setAdapter(adp);
        db.close();
    }


    public void modReta(View v){
        //Analogo a las modificaciones previas, el ususario puede cambiar datos de su reta.
        AdminSQLiteOpenHelper2 adminR=new AdminSQLiteOpenHelper2(this,"adminR", null, 1);
        SQLiteDatabase db=adminR.getWritableDatabase();
        String clave=folioM.getText().toString();
        String lugar=lugarM.getText().toString();
        String hora=horaM.getText().toString();

        ContentValues registro=new ContentValues();

        registro.put("lugar",lugar);
        registro.put("hora",hora);

        int cant=db.update("Reta", registro, "folio="+clave, null);
        db.close();

        if(cant==1)
            Toast.makeText(this, "Se modificaron correctamente los datos de la reta con clave: "+clave, Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "No existe la clave: "+clave, Toast.LENGTH_LONG).show();
    }





}
