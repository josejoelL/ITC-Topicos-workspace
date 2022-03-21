package com.example.crud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDeDatos extends SQLiteOpenHelper {
    static int VERSION=2;
    String sqlCreateAutos = "CREATE TABLE AUTOS (PLACA TEXT PRIMARY KEY, MARCA TEXT,MODELO TEXT, YEAR INTEGER)";
    String sqlCreateClientes ="CREATE TABLE CLIENTES (ID INTEGER PRIMARY KEY, NOMBRE TEXT, DIRECCION TEXT, ESTATUS TEXT) ";

    public BaseDeDatos(Context contexto, String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreateAutos);
        db.execSQL(sqlCreateClientes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS AUTOS");
        db.execSQL(sqlCreateAutos);
        db.execSQL("DROP TABLE IF EXISTS CLIENTES");
        db.execSQL(sqlCreateClientes);
    }
}
