package com.example.crud;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    BaseDeDatos Conexion;
    SQLiteDatabase BD;
    Button btnRecuperar, btnGrabar,btnBorrar,btnConsultar,btnLimpiar,btnActualizar;
    EditText txtPlaca, txtMarca, txtModelo,txtAño;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Conexion=new BaseDeDatos(this, "AGENCIA", null, BaseDeDatos.VERSION);
        if(Conexion==null){
            AlertDialog  Alerta= new AlertDialog.Builder(this).create();
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
        txtPlaca=(EditText) findViewById(R.id.txtPlaca);
        txtMarca=(EditText) findViewById(R.id.txtMarca);
        txtModelo=(EditText) findViewById(R.id.txtModelo);
        txtAño=(EditText) findViewById(R.id.txtAño);

        btnRecuperar=(Button) findViewById(R.id.btnRecuperar);
        btnGrabar=(Button) findViewById(R.id.btnGrabar);
        btnBorrar=(Button) findViewById(R.id.btnBorrar);
        btnActualizar=(Button) findViewById(R.id.btnActualizar);
        btnConsultar=(Button) findViewById(R.id.btnConsultar);
        btnLimpiar=(Button) findViewById(R.id.btnLimpiar);
        HazEscuchadores();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    private void HazEscuchadores(){
        btnRecuperar.setOnClickListener(this);
        btnGrabar.setOnClickListener(this);
        btnBorrar.setOnClickListener(this);
        btnActualizar.setOnClickListener(this);
        btnConsultar.setOnClickListener(this);
        btnLimpiar.setOnClickListener(this);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.opMenuRecuperar) {
            MetRecuperar();
            return true;
        }
        if (id == R.id.opMenuGrabar) {
            MetGrabar();
            return true;
        }
        if (id == R.id.opMenuBorrar) {
            MetBorrar();
            return true;
        }
        if( id==R.id.opMenuActualizar){
            MetActualizar();
            return true;
        }
        return super.onOptionsItemSelected(item);
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


            startActivity(new Intent(this,ConsultAutos.class));

        }
    }
    private void MetRecuperar(){
        String placa=txtPlaca.getText().toString();
        if(placa.length()==0){
            Toast msg = Toast.makeText(getBaseContext(), "debe de capturar número de placa",Toast.LENGTH_LONG);msg.show();
            txtPlaca.requestFocus();
            return;
        }
        String cadena="SELECT marca, moddelo, year FROM AUTOS WHERE PLACA='"+placa+"'";
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
        txtAño.setText(c.getInt(2)+"");
    }
    private void MetGrabar(){
        String placa=txtPlaca.getText().toString();
        String marca=txtMarca.getText().toString();
        String modelo=txtModelo.getText().toString();
        int año=Integer.parseInt(txtAño.getText().toString());
        if(placa.length()==0 || marca.length()==0 || modelo.length()==0 || año<1980){
            Toast msg = Toast.makeText(getBaseContext(), "FALTÓ CAPTURAR ALGÚN DATO",Toast.LENGTH_LONG);msg.show();
            txtPlaca.requestFocus();
            return;
        }
        String cadena="INSERT INTO AUTOS (PLACA,MARCA,MODELO,YEAR) VALUES('" +placa + "','" + marca + "','"+modelo+"',"+año+")" ;
        try {
            BD.execSQL(cadena);
        } catch (SQLiteConstraintException E){
            AlertDialog Alerta = new AlertDialog.Builder(this).create();
            Alerta.setMessage("se presentó una violación de integridad, se intentó grabar mas de una tupla con la misma placa");
            Alerta.show();
            return;
        }
        Limpiar();
    }
    private void MetBorrar(){
        String placa=txtPlaca.getText().toString();
        if(placa.length()==0){
            Toast msg = Toast.makeText(getBaseContext(), "FALTÓ proporcionar placa",Toast.LENGTH_LONG);msg.show();
            txtPlaca.requestFocus();
            return;
        }
        String cadena="DELETE FROM AUTOS WHERE PLACA='" + placa + "'";
        BD.execSQL(cadena);
        Limpiar();
    }
    private void MetActualizar(){
        String placa=txtPlaca.getText().toString();
        String marca=txtMarca.getText().toString();
        String modelo=txtModelo.getText().toString();
        int año=Integer.parseInt(txtAño.getText().toString());
        if(placa.length()==0 || marca.length()==0 || modelo.length()==0 || año<1980){
            Toast msg = Toast.makeText(getBaseContext(), "FALTÓ CAPTURAR ALGÚN DATO",Toast.LENGTH_LONG);msg.show();
            txtPlaca.requestFocus();
            return;
        }
        String cadena="UPDATE AUTOS SET MARCA='"+ marca + "', MODELO='"+ modelo +"', YEAR="+ año + " where PLACA='"+ placa+"'";
        BD.execSQL(cadena);
        Limpiar();
    }
    private void Limpiar(){
        txtPlaca.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtAño.setText("");
        txtPlaca.requestFocus();
    }
}