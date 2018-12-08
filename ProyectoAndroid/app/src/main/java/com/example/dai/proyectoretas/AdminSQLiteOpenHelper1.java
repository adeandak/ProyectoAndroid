package com.example.dai.proyectoretas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOpenHelper1 extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper1( Context context,String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //crea la base de datos de los usuarios
        db.execSQL("create table Jugador(id integer primary key, contra text, nombre text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Jugador");
        db.execSQL("create table Jugador(id integer primary key, contra text, nombre text)");

    }


}
