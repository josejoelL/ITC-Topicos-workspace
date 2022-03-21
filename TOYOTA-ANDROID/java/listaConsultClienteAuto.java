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

public class listaConsultClienteAuto extends AppCompatActivity {
    BaseDeDatos Conexion;
    SQLiteDatabase BD;
    ListView lista2;
    private ArrayList<ReporteUno> myReporteUno=new ArrayList<ReporteUno>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_consult_cliente_auto);
        lista2=(ListView)findViewById(R.id.IdListView3);
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
        String cadena="SELECT S.PLACA, NOMBRE, COUNT(S.PLACA) AS NOORDEN, SUM(IMPORTE) AS IMPORTE FROM SERVICIOS S INNER JOIN AUTOS A ON S.PLACA=A.PLACA INNER JOIN CLIENTES C ON A.CVECLIENTE=C.CVECLIENTE GROUP BY C.NOMBRE, S.PLACA";//
        Cursor c = BD.rawQuery(cadena, null);
        if (c.getCount() == 0) {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Recuperando ");
            alertDialog.setMessage("NO HAY DATOS REGISTRADOS");
            alertDialog.show();
            return;
        }
        int numSer,sumImp;
        String placa,nombre;
        while(c.moveToNext()){

            placa=c.getString(0);
            nombre=c.getString(1);
            numSer=c.getInt(2);
            sumImp=c.getInt(3);
            myReporteUno.add(new ReporteUno( placa, nombre,  numSer,  sumImp));

        }
        ArrayAdapter<ReporteUno> adapter=new listaConsultClienteAuto.MyListAdapter();
        lista2.setAdapter(adapter);


    }
    private class MyListAdapter extends ArrayAdapter<ReporteUno> {
        public MyListAdapter() {
            super(listaConsultClienteAuto.this, R.layout.item_view3, myReporteUno);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = convertView;

            if (itemView == null)
                itemView = getLayoutInflater().inflate(R.layout.item_view3, parent, false);
            ReporteUno CurrentAuto = myReporteUno.get(position);

            TextView lblPlaca1 = (TextView) itemView.findViewById(R.id.lblPlaca1);
            lblPlaca1.setText(CurrentAuto.getPlaca());
            TextView lblNombre1 = (TextView) itemView.findViewById(R.id.lblNombre1);
            lblNombre1.setText(CurrentAuto.getNombre());
            TextView lblNumSer = (TextView) itemView.findViewById(R.id.lblNumSer);
            lblNumSer.setText(CurrentAuto.getNumSer()+"");
            TextView lblSumImp = (TextView) itemView.findViewById(R.id.lblSumImp);
            lblSumImp.setText(CurrentAuto.getSumInt()+"");


            return itemView;

        }
    }


}
