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

public class listaConsultClientes extends AppCompatActivity {
    BaseDeDatos Conexion;
    SQLiteDatabase BD;
    private ArrayList<Cliente> myClientes=new ArrayList<Cliente>();
    ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_consult_clientes);
        lista=findViewById(R.id.IdListView);       //lo ocupa pero parece que no es necesario en esta version TableLayout casteo
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
        String cadena="SELECT CVECLIENTE,NOMBRE, NOMESTADO, NOMCIUDAD, NOMCOLONIA FROM CLIENTES ";//ORDER BY CVECLIENTE
        Cursor c = BD.rawQuery(cadena, null);
        if (c.getCount() == 0) {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Recuperando ");
            alertDialog.setMessage("NO HAY DATOS REGISTRADOS");
            alertDialog.show();
            return;
        }
        int claveCliente;
        String nombre,nombreEdo,nombreCiudad,nombreColonia;
        while(c.moveToNext()){
             claveCliente=c.getInt(0);
             nombre=c.getString(1);
             nombreEdo=c.getString(2);
             nombreCiudad=c.getString(3);
             nombreColonia=c.getString(4);

            myClientes.add(new Cliente( claveCliente, nombre,  nombreEdo,  nombreCiudad,  nombreColonia));

        }
        ArrayAdapter<Cliente> adapter=new MyListAdapter();
        lista.setAdapter(adapter);

    }

    private class MyListAdapter extends ArrayAdapter<Cliente> {
        public MyListAdapter() {
            super(listaConsultClientes.this, R.layout.item_view2, myClientes);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = convertView;

            if (itemView == null)
                itemView = getLayoutInflater().inflate(R.layout.item_view2, parent, false);


            Cliente CurrentCliente = myClientes.get(position);
            //2020-12-15 02:07:50.529 11868-11868/com.example.proyecto E/ArrayAdapter: You must supply a resource ID for a TextView
            TextView lblClaveCliente = (TextView) itemView.findViewById(R.id.lblClaveCliente);
            lblClaveCliente.setText("ID. "+CurrentCliente.getClaveCliente());
            TextView lblNombre = (TextView) itemView.findViewById(R.id.lblNombre1);
            lblNombre.setText(CurrentCliente.getNombre());
            TextView lblNombreEdo = (TextView) itemView.findViewById(R.id.lblNombreEdo);
            lblNombreEdo.setText(CurrentCliente.getNombreEdo());
            TextView lblNombreCiudad = (TextView) itemView.findViewById(R.id.lblNombreCiudad);
            lblNombreCiudad.setText(CurrentCliente.getNombreCiudad());
            TextView lblNombreColonia = (TextView) itemView.findViewById(R.id.lblNombreColonia);
            lblNombreColonia.setText(CurrentCliente.getNombreColona() );

            return itemView;

        }
    }


}
   // Caused by: java.lang.ClassCastException: android.widget.TableLayout cannot be cast to android.widget.TextView
//es problema de como lo construi