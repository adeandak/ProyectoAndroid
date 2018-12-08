package com.example.dai.proyectoretas;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class CrearNuevaReta extends AppCompatActivity {
    private EditText idReta;
    private EditText lugar;
    private EditText hora;
    private RadioGroup rdGroup; //deporte
    private RadioButton rdButton;
    private EditText consultaFolio;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_nueva_reta);
        idReta=(EditText)findViewById(R.id.etFolio);
        lugar=(EditText)findViewById(R.id.etLugar);
        hora=(EditText) findViewById(R.id.idHora);
        rdGroup=(RadioGroup)findViewById(R.id.rdGroup);
        consultaFolio=(EditText)findViewById(R.id.etConsultaId);


    }
    public void activa(View v){
        int radioId=rdGroup.getCheckedRadioButtonId();
        rdButton=findViewById(radioId);
    }


    public void agregarReta (View v){
        try {
            AdminSQLiteOpenHelper2 adminR = new AdminSQLiteOpenHelper2(this, "adminR", null, 1);
            SQLiteDatabase db = adminR.getWritableDatabase();

            String idR = (idReta.getText().toString());
            String lug = lugar.getText().toString();
            String hor = hora.getText().toString();
            int radioId = rdGroup.getCheckedRadioButtonId();
            rdButton = findViewById(radioId);
            String depor = rdButton.getText().toString();

            Bundle bundle= this.getIntent().getExtras();
            String idUsu = bundle.get("idUsuario").toString();


            ContentValues registro = new ContentValues();

            registro.put("folio", idR);
            registro.put("deporte", depor);
            registro.put("lugar", lug);
            registro.put("hora", hor);
            registro.put("idJugador", idUsu);

            Cursor fila=db.rawQuery("select folio from Reta where folio="+idR,null);
            if(fila.moveToFirst()){
                Toast.makeText(this, "ya existe ese folio, piense en otro", Toast.LENGTH_SHORT).show();

            }
            else{
                db.insert("Reta", null, registro);
                db.close();


                Toast.makeText(this, "se dio de alta", Toast.LENGTH_SHORT).show();
            }





        }catch(Exception s){
            Toast.makeText(this,"error",Toast.LENGTH_LONG).show();
        }

    }

    public void consultaReta(View v){
        try{
        AdminSQLiteOpenHelper2 adminR= new AdminSQLiteOpenHelper2(this,"adminR",null,1);
        SQLiteDatabase db=adminR.getWritableDatabase();
        String fol= consultaFolio.getText().toString();


            Cursor fila=db.rawQuery("select folio,deporte,lugar,hora,idJugador from Reta where folio="+fol,null);
            if(fila.moveToFirst()){
                Toast.makeText(this,fila.getString(0)+fila.getString(1)+fila.getString(2)+fila.getString(3)+fila.getString(4),Toast.LENGTH_LONG).show();
            }
            else
                Toast.makeText(this,"no se encontró",Toast.LENGTH_LONG).show();
            db.close();

        }catch(Exception ex){
            Toast.makeText(this,"PEDO AQUI"+ex,Toast.LENGTH_LONG).show();
        }



    }



}
