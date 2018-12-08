package com.example.dai.proyectoretas;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class EliminarReta extends AppCompatActivity {
    private Spinner spReta;
    private EditText folElim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_reta);
        spReta=(Spinner)findViewById(R.id.spRetas);
        folElim=(EditText)findViewById(R.id.etFolioEliminar);

        try{

            AdminSQLiteOpenHelper2 adminR= new AdminSQLiteOpenHelper2(this,"adminR",null,1);
            SQLiteDatabase db = adminR.getWritableDatabase();
            Bundle bundle= this.getIntent().getExtras();
            String aux = bundle.get("idUsuario").toString();


            ArrayList<String> elementos= new ArrayList<String>();

            Cursor fila=db.rawQuery("select folio,deporte,lugar,hora from Reta where idJugador="+aux,null);
            while (fila.moveToNext()){

                String concatena="folio:"+fila.getString(0)+" /deporte: "+fila.getString(1)+" /lugar: "+fila.getString(2)+" /hora: "+fila.getString(3);
                elementos.add(concatena);


            }
            ArrayAdapter adp= new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,elementos);

            spReta.setAdapter(adp);

        }catch (Exception ex){
            Toast.makeText(this,"ERROR"+ex,Toast.LENGTH_LONG).show();
        }





    }

    public void eliminaReta(View v){
        AdminSQLiteOpenHelper2 adminR=new AdminSQLiteOpenHelper2(this,"adminR", null, 1);
        SQLiteDatabase db=adminR.getWritableDatabase();
        String folio=folElim.getText().toString();

        int num=db.delete("Reta", "folio="+folio,null);
        db.close();

        if(num==1)
            Toast.makeText(this, "Se elimninó correctamente la reta con clave: "+folio, Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "No existe la clave "+folio,Toast.LENGTH_LONG).show();

    }
}
