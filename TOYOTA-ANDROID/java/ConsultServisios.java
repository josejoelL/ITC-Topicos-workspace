package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ConsultServisios extends AppCompatActivity implements View.OnClickListener {
    BaseDeDatos Conexion;
    SQLiteDatabase BD;


    Button btnRecuperar, btnGrabar,btnBorrar,btnActualizar;
    EditText txtNoOrden,txtIdAuto,txtKmServicio,txtImporte,txtFecha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult_servisios);

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


        txtNoOrden=(EditText)findViewById(R.id.txtNoOrden);
        txtIdAuto=(EditText) findViewById(R.id.txtIdAuto);//tambien un select claveauto from auto where claveauto==null; si nor egresa es por que no existe
        txtKmServicio=(EditText) findViewById(R.id.txtKmServicio);
        txtImporte=(EditText) findViewById(R.id.txtImporte);
        txtFecha=(EditText) findViewById(R.id.txtFecha);


        btnRecuperar=(Button) findViewById(R.id.btnRecuperar);
        btnGrabar=(Button) findViewById(R.id.btnGrabar);
        btnBorrar=(Button) findViewById(R.id.btnBorrar);
        btnActualizar=(Button) findViewById(R.id.btnActualizar);

        HazEscuchadores();
    }

    private void HazEscuchadores() {
        btnRecuperar.setOnClickListener(this);
        btnGrabar.setOnClickListener(this);
        btnBorrar.setOnClickListener(this);
        btnActualizar.setOnClickListener(this);

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
    }

    private void MetActualizar() {
        int noOrden = Integer.parseInt(txtNoOrden.getText().toString());
        String idAuto = txtIdAuto.getText().toString();
        int kmServicio = Integer.parseInt(txtKmServicio.getText().toString());
        int importe = Integer.parseInt(txtImporte.getText().toString());
        String fecha = txtFecha.getText().toString();
        if (noOrden == 0 || idAuto.length() == 0 || kmServicio == 0 || importe == 0 || fecha.length() == 0) {
            Toast msg = Toast.makeText(getBaseContext(), "FALTÓ CAPTURAR ALGÚN DATO", Toast.LENGTH_LONG);
            msg.show();
            txtNoOrden.requestFocus();
            return;
        }

        String cadena="SELECT PLACA FROM AUTOS WHERE PLACA='"+idAuto+"'";
        // aqui no se que hacer
        Cursor c = BD.rawQuery(cadena, null);
        if (c.getCount() == 0) {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Comprobando en BD ");
            alertDialog.setMessage("LA PLACA PROPORCIONADA NO ESTA REGISTRADA");
            alertDialog.show();
            return;
        }


         cadena="SELECT NOORDEN FROM SERVICIOS WHERE NOORDEN='"+noOrden+"'";
        // aqui no se que hacer
         c = BD.rawQuery(cadena, null);
        if (c.getCount() == 0) {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Comprobando en BD ");
            alertDialog.setMessage("EL NO.SERVICIO PROPORCIONADO NO ESTA REGISTRADO");
            alertDialog.show();
            return;
        }

//="CREATE TABLE SERVICIOS (NOORDEN INTEGER PRIMARY KEY, PLACA TEXT, KILOMETRAJE INTEGER, IMPORTE REAL, FECHA STRING)";
        cadena="UPDATE SERVICIOS SET PLACA='"+ idAuto+ "', KILOMETRAJE='"+ kmServicio +"', IMPORTE='"+importe + "', FECHA = '"+fecha +"' where NOORDEN='"+ noOrden+"'";
        BD.execSQL(cadena);
        MetLimpiar();
    }

    private void MetBorrar() {

        if ( txtNoOrden.getText().toString().equals("") ){
            Toast msg = Toast.makeText(getBaseContext(), "no.Servicio sin agregar",Toast.LENGTH_LONG);msg.show();
            txtNoOrden.requestFocus();
            return;
        }

        int noOrden=Integer.parseInt(txtNoOrden.getText().toString());
        if(noOrden==0){
            Toast msg = Toast.makeText(getBaseContext(), "FALTÓ proporcionar placa",Toast.LENGTH_LONG);msg.show();
            txtNoOrden.requestFocus();
            return;
        }
        String cadena="DELETE FROM SERVICIOS WHERE NOORDEN='"+noOrden+"'";
        BD.execSQL(cadena);
        MetLimpiar();
    }

    private void MetGrabar() {

        String idAuto=txtIdAuto.getText().toString();
        String fecha=txtFecha.getText().toString();

        if (  txtNoOrden.getText().toString().equals("")  ||  txtKmServicio.getText().toString().equals("")  ||  txtImporte.getText().toString().equals("") ){
            Toast msg = Toast.makeText(getBaseContext(), "NO ORDEN, KMSERVICIO, IMPORTE SIN PARAMETROS",Toast.LENGTH_LONG);msg.show();
            txtNoOrden.requestFocus();
            return;
        }

        int noOrden=Integer.parseInt(txtNoOrden.getText().toString());
        int  kmServicio=Integer.parseInt(txtKmServicio.getText().toString());
        int importe=Integer.parseInt(txtImporte.getText().toString());


        if(noOrden==0 || idAuto.length()==0 || kmServicio==0 || importe==0||fecha.length()==7){
            Toast msg = Toast.makeText(getBaseContext(), "FALTÓ CAPTURAR ALGÚN DATO",Toast.LENGTH_LONG);msg.show();
            txtNoOrden.requestFocus();
            return;
        }
        String cadena="SELECT PLACA FROM AUTOS WHERE PLACA='"+idAuto+"'";
        // aqui no se que hacer
        Cursor c = BD.rawQuery(cadena, null);
        if (c.getCount() == 0) {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Comprobando en BD ");
            alertDialog.setMessage("LA PLACA PROPORCIONADA NO ESTA REGISTRADA");
            alertDialog.show();
            return;
        }


       String  cadena2="INSERT INTO SERVICIOS VALUES('" +noOrden+ "','" +idAuto+ "','" +kmServicio+ "','" +importe+"','"+fecha+"')" ;
        try {
            BD.execSQL(cadena2);
        } catch (SQLiteConstraintException E){
            AlertDialog Alerta = new AlertDialog.Builder(this).create();
            Alerta.setMessage("se presentó una violación de integridad, se intentó grabar mas de una tupla con el mismo numero de servicio");
            Alerta.show();
            return;
        }
        MetLimpiar();
    }

    private void MetRecuperar() {

        if ( txtNoOrden.getText().toString().equals("") ){
            Toast msg = Toast.makeText(getBaseContext(), "no Servicio sin parametros",Toast.LENGTH_LONG);msg.show();
            txtNoOrden.requestFocus();
            return;
        }

        int noOrden=Integer.parseInt(txtNoOrden.getText().toString());
        if(noOrden==0) {
            Toast msg = Toast.makeText(getBaseContext(), "debe de capturar un noServicio", Toast.LENGTH_LONG);
            msg.show();
            txtNoOrden.requestFocus();
            return;
        }

        String cadena="SELECT PLACA, KILOMETRAJE, IMPORTE,FECHA FROM SERVICIOS WHERE NOORDEN='"+noOrden+"'";
        Cursor c = BD.rawQuery(cadena, null);
        if (c.getCount() == 0) {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Recuperando ");
            alertDialog.setMessage("EL NO.SERVICIO PROPORCIONADO NO ESTA REGISTRADO");
            alertDialog.show();
            return;
        }
        // RECUPERO EL AUTO CON LA PLACA PROPORCIONADO
        c.moveToFirst(); // POSICIONA EN LA TUPLA
        txtIdAuto.setText(c.getString(0));
        txtKmServicio.setText(c.getInt(1)+"");
        txtImporte.setText(c.getInt(2)+"");
        txtFecha.setText(c.getString(3));





    }
    private void MetLimpiar(){
        txtNoOrden.setText("");
        txtIdAuto.setText("");
        txtKmServicio.setText("");
        txtImporte.setText("");
        txtFecha.setText("");
        txtNoOrden.requestFocus();

    }
}
