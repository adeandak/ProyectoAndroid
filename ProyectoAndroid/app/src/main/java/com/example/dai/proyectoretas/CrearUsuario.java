package com.example.dai.proyectoretas;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CrearUsuario extends AppCompatActivity {
    private EditText usu, contra, nom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_usuario);
        usu=(EditText)findViewById(R.id.etNuevoUsu);
        contra=(EditText)findViewById(R.id.etNuevaContra);
        nom=(EditText)findViewById(R.id.etNuevoNombre);

    }


    public void agregaJugador(View v){

        try{
            AdminSQLiteOpenHelper1 adminJ = new AdminSQLiteOpenHelper1(this,"adminJ",null,1);
            SQLiteDatabase db=adminJ.getWritableDatabase();
            String usuario= usu.getText().toString();
            String contraseña= contra.getText().toString();
            String nombre = nom.getText().toString();

            ContentValues registro = new ContentValues();
            registro.put("id",usuario);
            registro.put("contra",contraseña);
            registro.put("nombre",nombre);

            Cursor fila=db.rawQuery("select id from Jugador where id="+usuario,null);

            if(fila.moveToFirst()){
                Toast.makeText(this, "ya existe ese folio, piense en otro", Toast.LENGTH_SHORT).show();

            }
            else{
                db.insert("Jugador",null,registro);
                db.close();


                Toast.makeText(this, "se dio de alta", Toast.LENGTH_SHORT).show();
            }






        }catch(Exception ex){
            Toast.makeText(this, "no se pudo dar de alta, pruebe otro usuario"+ex,Toast.LENGTH_LONG).show();

        }



    }



    public void consultaP(View v){
        AdminSQLiteOpenHelper1 adminJ= new AdminSQLiteOpenHelper1(this,"adminJ",null,1);
        SQLiteDatabase db = adminJ.getWritableDatabase();

        String usuario= usu.getText().toString();

        try{
            Cursor fila=db.rawQuery("select id,contra, nombre from Jugador where id="+usuario,null);
            if(fila.moveToFirst()){
                usu.setText(fila.getString(0));
                contra.setText(fila.getString(1));
                nom.setText(fila.getString(2));

            }
            else
                Toast.makeText(this,"no se encontró",Toast.LENGTH_LONG).show();

        }catch(Exception ex){
            Toast.makeText(this,"PROBLEMA AQUI"+ex,Toast.LENGTH_LONG).show();
        }


        db.close();


    }














    public void regresarMain1(View v){
        Intent intent = new Intent(this,MainActivity.class);
         startActivity(intent);
    }

}
