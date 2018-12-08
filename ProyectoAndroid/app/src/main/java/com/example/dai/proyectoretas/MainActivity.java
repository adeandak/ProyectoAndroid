package com.example.dai.proyectoretas;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText usuario, contra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario=(EditText)findViewById(R.id.etUsuario);
        contra=(EditText)findViewById(R.id.etContra);
    }

    public void ingresa(View v){


        AdminSQLiteOpenHelper1 adminJ = new AdminSQLiteOpenHelper1(this,"adminJ",null,1);
        SQLiteDatabase db=adminJ.getWritableDatabase();
        String idU= usuario.getText().toString();
        String conU=contra.getText().toString();
        try{
            //Solo te deja entrar si exite un usuario y la contra es correcta.
            Cursor f=db.rawQuery("select contra from Jugador where id=" +idU,null);
            if(f.moveToFirst()){
                String aux= f.getString(0);
                if(aux.compareTo(conU)==0){
                    Intent intent = new Intent(this, Main2Activity.class);
                    Bundle b= new Bundle();
                    b.putString("session",usuario.getText().toString());
                    intent.putExtras(b);
                    startActivity(intent);
                    //Aqui existe un usuario y la contra es correcta
                }
                else
                    Toast.makeText(this,"contra incorrecta",Toast.LENGTH_LONG).show();
            }
            else
                Toast.makeText(this,"usuario incorrecto",Toast.LENGTH_LONG).show();
        }catch(Exception ex){
            Toast.makeText(this,"PROBLEMA"+ex,Toast.LENGTH_LONG).show();
        }




    }
    public void creaNueva(View v){
        //Este intent te lleva a la pestana para crear un usuario nuevo
        Intent intent = new Intent(this, CrearUsuario.class);
        startActivity(intent);
    }


}
