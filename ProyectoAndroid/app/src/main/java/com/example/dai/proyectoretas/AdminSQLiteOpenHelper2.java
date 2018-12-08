package com.example.dai.proyectoretas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOpenHelper2 extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper2( Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    //base de datos para guardar las retas
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Reta (folio integer primary key, deporte text, lugar text, hora text, idJugador text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Reta");
        db.execSQL("create table Reta (folio integer primary key, deporte text, lugar text, hora text,idJugador text)");

    }
}
