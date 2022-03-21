package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class listaConsultAutos extends AppCompatActivity {
    BaseDeDatos Conexion;
    SQLiteDatabase BD;
    ListView lista1;
    private ArrayList<Auto> myAutos=new ArrayList<Auto>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_consult_autos);
        lista1=(ListView)findViewById(R.id.IdListView2);
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

        String cadena="SELECT * FROM AUTOS ORDER BY YEAR";//
        Cursor c = BD.rawQuery(cadena, null);
        if (c.getCount() == 0) {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Recuperando ");
            alertDialog.setMessage("NO HAY DATOS REGISTRADOS");
            alertDialog.show();
            return;
        }
        int claveCliente,year;
        String placa,marca,modelo;
        while(c.moveToNext()){

            placa=c.getString(0);
            marca=c.getString(1);
            modelo=c.getString(2);
            year=c.getInt(3);
            claveCliente=c.getInt(4);
            myAutos.add(new Auto( placa, marca,  modelo,  year,  claveCliente));

        }
        ArrayAdapter<Auto> adapter=new MyListAdapter();
        lista1.setAdapter(adapter);

    }
    private class MyListAdapter extends ArrayAdapter<Auto> {
        public MyListAdapter() {
            super(listaConsultAutos.this, R.layout.item_view, myAutos);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = convertView;

            if (itemView == null)
                itemView = getLayoutInflater().inflate(R.layout.item_view, parent, false);
            Auto CurrentAuto = myAutos.get(position);

            TextView lblPlaca = (TextView) itemView.findViewById(R.id.lblPlaca1);
            lblPlaca.setText(CurrentAuto.getPlaca());
            TextView lblMarca = (TextView) itemView.findViewById(R.id.lblMarca);
            lblMarca.setText(CurrentAuto.getMarca());
            TextView lblModelo = (TextView) itemView.findViewById(R.id.lblModelo);
            lblModelo.setText(CurrentAuto.getModelo());
            TextView lblClaveCliente = (TextView) itemView.findViewById(R.id.lblClaveCliente);
            lblClaveCliente.setText(CurrentAuto.getClaveCliente()+"");
            TextView lblYear = (TextView) itemView.findViewById(R.id.lblYear);
            lblYear.setText(CurrentAuto.getYear() + "");

            return itemView;

        }
    }
}
