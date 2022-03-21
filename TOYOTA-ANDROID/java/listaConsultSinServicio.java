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


public class listaConsultSinServicio extends AppCompatActivity {
    BaseDeDatos Conexion;
    SQLiteDatabase BD;
    ListView lista4;
    private ArrayList<ReporteTres> myReporteTres=new ArrayList<ReporteTres>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_consult_sin_servicio);
        lista4=(ListView)findViewById(R.id.IdListView5);
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
        String cadena="SELECT A.PLACA,A.CVECLIENTE,NOMBRE FROM AUTOS A,CLIENTES C ON A.CVECLIENTE=C.CVECLIENTE  LEFT JOIN SERVICIOS S ON A.PLACA=S.PLACA WHERE S.PLACA IS NULL  ";//INNER JOIN CLIENTES C ON A.CVECLIENTE=C.CVECLIENTE siquiero agregar Nombre
        Cursor c = BD.rawQuery(cadena, null);
        if (c.getCount() == 0) {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Recuperando ");
            alertDialog.setMessage("NO HAY DATOS REGISTRADOS");
            alertDialog.show();
            return;
        }
        int claveCliente;
        String placa,nombre;//nombre
        while(c.moveToNext()){

            placa=c.getString(0);
            claveCliente=c.getInt(1);
            nombre=c.getString(2);
            myReporteTres.add(new ReporteTres(placa, claveCliente,nombre));

        }
        ArrayAdapter<ReporteTres> adapter=new listaConsultSinServicio.MyListAdapter();
        lista4.setAdapter(adapter);


    }
    private class MyListAdapter extends ArrayAdapter<ReporteTres> {
        public MyListAdapter() {
            super(listaConsultSinServicio.this, R.layout.item_view5, myReporteTres);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = convertView;

            if (itemView == null)
                itemView = getLayoutInflater().inflate(R.layout.item_view5, parent, false);
            ReporteTres CurrentAuto = myReporteTres.get(position);

            TextView lblPlaca2 = (TextView) itemView.findViewById(R.id.lblPlaca2);
            lblPlaca2.setText(CurrentAuto.getPlaca());

            TextView lblClaveCliente1 = (TextView) itemView.findViewById(R.id.lblClaveCliente1);
            lblClaveCliente1.setText(CurrentAuto.getClaveCliente()+"");

            TextView lblNombre2 = (TextView) itemView.findViewById(R.id.lblNombre2);
            lblNombre2.setText(CurrentAuto.getNombre());
            return itemView;

        }
    }


}
