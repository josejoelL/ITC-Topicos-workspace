package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ConsultAutos extends AppCompatActivity implements View.OnClickListener{
    BaseDeDatos Conexion;
    SQLiteDatabase BD;


    Button btnRecuperar, btnGrabar,btnBorrar,btnConsultar,btnLimpiar,btnActualizar;
    EditText txtPlaca, txtMarca, txtModelo,txtYear,txtClaveCliente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult_autos);

        Conexion=new BaseDeDatos(this, "AGENCIA", null, BaseDeDatos.VERSION);
        if(Conexion==null){
            AlertDialog Alerta= new AlertDialog.Builder(this).create();
            Alerta.setMessage("LA CONEXION NO EXISTE");
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


        txtPlaca=(EditText) findViewById(R.id.txtPlaca);
        txtMarca=(EditText) findViewById(R.id.txtMarca);
        txtModelo=(EditText) findViewById(R.id.txtModelo);
        txtYear=(EditText) findViewById(R.id.txtYear);
        txtClaveCliente=(EditText)findViewById(R.id.txtClaveCliente);

        btnRecuperar=(Button) findViewById(R.id.btnRecuperar);
        btnGrabar=(Button) findViewById(R.id.btnGrabar);
        btnBorrar=(Button) findViewById(R.id.btnBorrar);
        btnActualizar=(Button) findViewById(R.id.btnActualizar);
        btnConsultar=(Button) findViewById(R.id.btnConsultar);
        btnLimpiar=(Button) findViewById(R.id.btnLimpiar);

        HazEscuchadores();
    }

    private void HazEscuchadores() {
        btnRecuperar.setOnClickListener(this);
        btnGrabar.setOnClickListener(this);
        btnBorrar.setOnClickListener(this);
        btnActualizar.setOnClickListener(this);
        btnConsultar.setOnClickListener(this);
        btnLimpiar.setOnClickListener( this);
    }


    @Override
    public void onClick(View evt) {
        if(evt==btnRecuperar){
            MetRecuperar();
            return;
        }
        if(evt==btnGrabar){
            MetGrabar();
            return;
        }
        if(evt==btnBorrar){
            MetBorrar();
            return;
        }
        if(evt==btnActualizar){
            MetActualizar();
            return;
        }
        if(evt==btnConsultar){

            //provicional, la clase va a hacer diferente
            startActivity(new Intent(this,listaConsultAutos.class));

        }
        if(evt==btnLimpiar){
            MetLimpiar();
            return;
        }
    }

    private void MetLimpiar() {
        txtClaveCliente.setText("");
        txtPlaca.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtYear.setText("");
        txtPlaca.requestFocus();

    }

    private void MetActualizar() {
        String placa=txtPlaca.getText().toString();
        String marca=txtMarca.getText().toString();
        String modelo=txtModelo.getText().toString();
        if (txtClaveCliente.getText().toString().equals("")||txtYear.getText().toString().equals("")){
            Toast msg = Toast.makeText(getBaseContext(), " CLAVE CLIENTE O AÑO SIN DATOS",Toast.LENGTH_LONG);msg.show();
            txtPlaca.requestFocus();
            return;
        }

        int año=Integer.parseInt(txtYear.getText().toString());
        int claveCliente=Integer.parseInt(txtClaveCliente.getText().toString());
        if(placa.length()==0 || marca.length()==0 || modelo.length()==0 || año<1980||claveCliente==0){
            Toast msg = Toast.makeText(getBaseContext(), "FALTAN DE CAPTURAR DATOS",Toast.LENGTH_LONG);msg.show();
            txtPlaca.requestFocus();
            return;
        }
        String cadena="SELECT CVECLIENTE FROM CLIENTES WHERE CVECLIENTE='"+claveCliente+"'";
        // aqui no se que hacer
        Cursor c = BD.rawQuery(cadena, null);
        if (c.getCount() == 0) {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Comprobando en BD ");
            alertDialog.setMessage("LA CLAVECLIENTE PROPORCIONADA NO ESTA REGISTRADA");
            alertDialog.show();
            return;
        }


        String cadena2="UPDATE AUTOS SET MARCA='"+ marca + "', MODELO='"+ modelo +"', YEAR= "+ año + ", CVECLIENTE ='"+claveCliente+ "' WHERE PLACA='"+ placa+"'";
        BD.execSQL(cadena2);
        MetLimpiar();

    }

    private void MetBorrar() {
        String placa=txtPlaca.getText().toString();
        if(placa.length()==0){
            Toast msg = Toast.makeText(getBaseContext(), "FALTÓ proporcionar placa",Toast.LENGTH_LONG);msg.show();
            txtPlaca.requestFocus();
            return;
        }
        String cadena="DELETE FROM AUTOS WHERE PLACA='" + placa + "'";
        BD.execSQL(cadena);
        MetLimpiar();
    }

    private void MetGrabar() {
        String placa=txtPlaca.getText().toString();
        String marca=txtMarca.getText().toString();
        String modelo=txtModelo.getText().toString();
        if (txtClaveCliente.getText().toString().equals("")||txtYear.getText().toString().equals("")){
            Toast msg = Toast.makeText(getBaseContext(), " CLAVE CLIENTE O AÑO SIN DATOS",Toast.LENGTH_LONG);msg.show();
            txtPlaca.requestFocus();
            return;
        }
        int año=Integer.parseInt(txtYear.getText().toString());
        int claveCliente=Integer.parseInt(txtClaveCliente.getText().toString());    //debo selec clave from cliente wheere clave cliente==null

        if(placa.length()==0 || marca.length()==0 || modelo.length()==0 || año<1980){
            Toast msg = Toast.makeText(getBaseContext(), "FALTÓ CAPTURAR ALGÚN DATO",Toast.LENGTH_LONG);msg.show();
            txtPlaca.requestFocus();
            return;
        }


        String cadena="SELECT CVECLIENTE FROM CLIENTES WHERE CVECLIENTE='"+claveCliente+"'";
     // aqui no se que hacer
        Cursor c = BD.rawQuery(cadena, null);
        if (c.getCount() == 0) {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Comprobando en BD ");
            alertDialog.setMessage("LA CLAVECLIENTE PROPORCIONADA NO ESTA REGISTRADA");
            alertDialog.show();
            return;
        }


        String cadena2="INSERT INTO AUTOS  VALUES('" +placa + "','" + marca + "','"+modelo+"','"+año+"','"+claveCliente+ "')" ;
        try {
            BD.execSQL(cadena2);
        } catch (SQLiteConstraintException E){
            AlertDialog Alerta = new AlertDialog.Builder(this).create();
            Alerta.setMessage("se presentó una violación de integridad, se intentó grabar mas de una tupla con la misma placa");
            Alerta.show();
            return;
        }
        MetLimpiar();

    }

    private void MetRecuperar() {
        String placa=txtPlaca.getText().toString();
        if(placa.length()==0) {
            Toast msg = Toast.makeText(getBaseContext(), "debe de capturar número de placa", Toast.LENGTH_LONG);
            msg.show();
            txtPlaca.requestFocus();
            return;
        }

        String cadena="SELECT MARCA, MODELO, YEAR, CVECLIENTE FROM AUTOS WHERE PLACA='"+placa+"'";
        Cursor c = BD.rawQuery(cadena, null);
        if (c.getCount() == 0) {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Recuperando ");
            alertDialog.setMessage("LA PLACA PROPORCIONADA NO ESTA REGISTRADA");
            alertDialog.show();
            return;
        }
        // RECUPERO EL AUTO CON LA PLACA PROPORCIONADO
        c.moveToFirst(); // POSICIONA EN LA TUPLA
        txtMarca.setText(c.getString(0)); // asignó el modelo a la caja de texto modelo
        txtModelo.setText(c.getString(1));
        txtYear.setText(c.getInt(2)+"");
        txtClaveCliente.setText(c.getInt(3)+"");


    }

}
