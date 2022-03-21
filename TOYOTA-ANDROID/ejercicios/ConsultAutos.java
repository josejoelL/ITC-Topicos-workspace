package com.example.crud;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class ConsultAutos extends AppCompatActivity {
    TextView viewGral;
    BaseDeDatos Conexion;
    SQLiteDatabase BD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult_autos);
        viewGral=(TextView) findViewById(R.id.viewGral);
        String cadena="";
        Conexion=new BaseDeDatos(this, "AGENCIA", null, BaseDeDatos.VERSION);
        if(Conexion==null){
            AlertDialog Alerta= new AlertDialog.Builder(this).create();
            Alerta.setMessage("LA conexion NO se ha hecho");
            Alerta.show();
            return;
        }
        BD = Conexion.getWritableDatabase();
        if(BD==null){
            AlertDialog  Alerta= new AlertDialog.Builder(this).create();
            Alerta.setMessage("LA BD NO ESTÁ PREPARADA PARA LECTURA Y ESCRITURA");
            Alerta.show();
            return;
        }
        cadena="SELECT * FROM AUTOS ORDER BY YEAR";
        Cursor c = BD.rawQuery(cadena, null);
        if (c.getCount() == 0) {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Recuperando ");
            alertDialog.setMessage("NO HAY AUTOS REGISTRADOS");
            alertDialog.show();
            return;
        }
        // RECUPERO LOS AUTO CON QUE ESTÉN ASIGNADOS AL CURSOR.
        String losAutos="",placa,marca,modelo;
        int año;

        while (c.moveToNext()){
            placa=c.getString(0);
            marca=c.getString(1);
            modelo=c.getString(2);
            año)c.getInt(3);
            losAutos=placa+"\t"+marca+"\t"+modelo+"\t"+año+"\n";
        }
        viewGral.setText(losAutos);
