package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ConsultReportes extends AppCompatActivity implements View.OnClickListener {
    BaseDeDatos Conexion;
    SQLiteDatabase BD;


    Button btnClienteAuto, btnCiudadColonia,btnSinServicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult_reportes);

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


        btnClienteAuto=(Button) findViewById(R.id.btnClienteAuto);
        btnCiudadColonia=(Button) findViewById(R.id.btnCiudadColonia);
        btnSinServicio=(Button) findViewById(R.id.btnSinServicio);

        HazEscuchadores();
    }

    private void HazEscuchadores() {

        btnClienteAuto.setOnClickListener(this);
        btnCiudadColonia.setOnClickListener(this);
        btnSinServicio.setOnClickListener(this);
    }

    @Override
    public void onClick(View evt) {
        if(evt==btnClienteAuto){
            MetClienteAuto();
            return;
        }
        if(evt==btnCiudadColonia){
            MetCiudadColonia();
            return;
        }
        if(evt==btnSinServicio){
            MetSinServicio();
            return;
        }
        
    }

    private void MetSinServicio() {
        startActivity(new Intent(this,listaConsultSinServicio.class));
    }

    private void MetCiudadColonia() {
        startActivity(new Intent(this,listaConsultCiudadColonia.class));
    }

    private void MetClienteAuto() {
        startActivity(new Intent(this,listaConsultClienteAuto.class));
    }
}
