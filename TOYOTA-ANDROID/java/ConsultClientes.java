package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ConsultClientes extends AppCompatActivity implements View.OnClickListener {
    BaseDeDatos Conexion;
    SQLiteDatabase BD;


    Button btnRecuperar, btnGrabar,btnBorrar,btnConsultar,btnLimpiar,btnActualizar;
    EditText txtClaveCliente,txtNombre,txtNombreCiudad,txtNombreEdo,txtNombreColonia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult_clientes);

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



        txtClaveCliente=(EditText)findViewById(R.id.txtClaveCliente2);//provando el text number
        txtNombre=(EditText) findViewById(R.id.txtNombre);
        txtNombreColonia=(EditText) findViewById(R.id.txtNombreColonia);
        txtNombreEdo=(EditText) findViewById(R.id.txtNombreEdo);
        txtNombreCiudad=(EditText) findViewById(R.id.txtNombreCiudad);


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


            startActivity(new Intent(this,listaConsultClientes.class));

        }
        if(evt==btnLimpiar){
            MetLimpiar();
            return;
        }
    }

    private void MetLimpiar() {
        txtClaveCliente.setText("");
        txtNombre.setText("");
        txtNombreCiudad.setText("");
        txtNombreEdo.setText("");
        txtNombreColonia.setText("");
        txtClaveCliente.requestFocus();

    }

    private void MetActualizar() {
        if (txtClaveCliente.getText().toString().equals("")){
            Toast msg = Toast.makeText(getBaseContext(), "FALTÓ AGREGAR CLAVE CLIENTE",Toast.LENGTH_LONG);msg.show();
            txtClaveCliente.requestFocus();
            return;
        }
        int claveCliente=Integer.parseInt(txtClaveCliente.getText().toString());
        String nombre=txtNombre.getText().toString();
        String nombreCiudad=txtNombreCiudad.getText().toString();
        String nombreEdo=txtNombreEdo.getText().toString();
        String nombreColonia=txtNombreColonia.getText().toString();




        if(claveCliente==0||nombre.length()==0 || nombreCiudad.length()==0 || nombreEdo.length()==0 || nombreColonia.length()==0||claveCliente==0){
            Toast msg = Toast.makeText(getBaseContext(), "FALTÓ CAPTURAR ALGÚN DATO",Toast.LENGTH_LONG);msg.show();
            txtClaveCliente.requestFocus();
            return;
        }
        String cadena="UPDATE CLIENTES SET CVECLIENTE='"+ claveCliente + "', NOMBRE='"+ nombre +"', NOMESTADO='"+ nombreEdo+ "', NOMCIUDAD='"+ nombreCiudad + "', NOMCOLONIA='"+ nombreColonia + "' where CVECLIENTE='"+ claveCliente+"'";
        BD.execSQL(cadena);
        MetLimpiar();
    }

    private void MetBorrar() {
        if (txtClaveCliente.getText().toString().equals("")){
            Toast msg = Toast.makeText(getBaseContext(), "FALTÓ AGREGAR CLAVE CLIENTE",Toast.LENGTH_LONG);msg.show();
            txtClaveCliente.requestFocus();
            return;
        }
        int claveCliente=Integer.parseInt(txtClaveCliente.getText().toString());


        String cadena="DELETE FROM CLIENTES WHERE CVECLIENTE='" + claveCliente+ "'";
        BD.execSQL(cadena);
        MetLimpiar();


    }

    private void MetGrabar() {
        if (txtClaveCliente.getText().toString().equals("")){
            Toast msg = Toast.makeText(getBaseContext(), "FALTÓ AGREGAR CLAVE CLIENTE",Toast.LENGTH_LONG);msg.show();
            txtClaveCliente.requestFocus();
            return;
        }
        int claveCliente=Integer.parseInt(txtClaveCliente.getText().toString());
        String nombre=txtNombre.getText().toString();
        String nombreEdo=txtNombreEdo.getText().toString();
        String nombreCiudad=txtNombreCiudad.getText().toString();
        String nombreColonia=txtNombreColonia.getText().toString();

        if( nombre.length()==0 || nombreEdo.length()==0 || nombreCiudad.length()==0 || nombreColonia.length()==0){
            Toast msg = Toast.makeText(getBaseContext(), "FALTÓ CAPTURAR ALGÚN DATO",Toast.LENGTH_LONG);msg.show();
            txtClaveCliente.requestFocus();
            return;
        }

        String cadena="INSERT INTO CLIENTES VALUES('" +claveCliente + "','" + nombre + "','"+nombreEdo+"','"+nombreCiudad+"','"+nombreColonia+"')" ;
        try {
            BD.execSQL(cadena);
        } catch (SQLiteConstraintException E){
            AlertDialog Alerta = new AlertDialog.Builder(this).create();
            Alerta.setMessage("se presentó una violación de integridad, se intentó grabar mas de una tupla con la misma clave Cliente");
            Alerta.show();
            return;
        }
        MetLimpiar();
    }

    private void MetRecuperar() {
        if (txtClaveCliente.getText().toString().equals("")){
            Toast msg = Toast.makeText(getBaseContext(), "FALTÓ AGREGAR CLAVE CLIENTE",Toast.LENGTH_LONG);msg.show();
            txtClaveCliente.requestFocus();
            return;
        }
        int claveCliente=Integer.parseInt(txtClaveCliente.getText().toString());
        if(claveCliente==0){
            Toast msg = Toast.makeText(getBaseContext(), "debe de capturar número de Clave Cliente",Toast.LENGTH_LONG);msg.show();
            txtClaveCliente.requestFocus();
            return;
        }

        String cadena="SELECT NOMBRE, NOMESTADO, NOMCIUDAD, NOMCOLONIA FROM CLIENTES WHERE CVECLIENTE='"+claveCliente+"'";
        Cursor c = BD.rawQuery(cadena, null);
        if (c.getCount() == 0) {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Recuperando ");
            alertDialog.setMessage("LA CLAVE CLIENTE PROPORCIONADA NO ESTA REGISTRADA");
            alertDialog.show();
            return;
        }
        // RECUPERO EL AUTO CON LA PLACA PROPORCIONADO
        c.moveToFirst(); // POSICIONA EN LA TUPLA
        txtNombre.setText(c.getString(0)+""); // asignó el modelo a la caja de texto modelo
        txtNombreEdo.setText(c.getString(1));
        txtNombreCiudad.setText(c.getString(2));
        txtNombreColonia.setText(c.getString(3));



    }



}
