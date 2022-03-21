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

public class listaConsultCiudadColonia extends AppCompatActivity {
    BaseDeDatos Conexion;
    SQLiteDatabase BD;
    ListView lista3;
    private ArrayList<ReporteDos> myReporteDos=new ArrayList<ReporteDos>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_consult_ciudad_colonia);
        lista3=(ListView)findViewById(R.id.IdListView4);
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
        String cadena="Select NomCiudad, NomColonia, count(*) as NOORDEN, Sum(Importe) as Importe from Servicios S inner Join Autos A on S.PLACA=A.PLACA INNER JOIN CLIENTES C ON A.CVECLIENTE=C.CVECLIENTE GROUP BY NOMCIUDAD,NOMCOLONIA";//
        Cursor c = BD.rawQuery(cadena, null);
        if (c.getCount() == 0) {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Recuperando ");
            alertDialog.setMessage("NO HAY DATOS REGISTRADOS");
            alertDialog.show();
            return;
        }
        int numSer,sumImp;
        String NomCiudad,NomColonia;
        while(c.moveToNext()){

            NomCiudad=c.getString(0);
           NomColonia=c.getString(1);
            numSer=c.getInt(2);
            sumImp=c.getInt(3);
            myReporteDos.add(new ReporteDos( NomCiudad, NomColonia,  numSer,  sumImp));

        }
        ArrayAdapter<ReporteDos> adapter=new listaConsultCiudadColonia.MyListAdapter();
        lista3.setAdapter(adapter);


    }
    private class MyListAdapter extends ArrayAdapter<ReporteDos> {
        public MyListAdapter() {
            super(listaConsultCiudadColonia.this, R.layout.item_view4, myReporteDos);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = convertView;

            if (itemView == null)
                itemView = getLayoutInflater().inflate(R.layout.item_view4, parent, false);
            ReporteDos CurrentAuto = myReporteDos.get(position);

            TextView lblNomCiudad1 = (TextView) itemView.findViewById(R.id.lblNomCiudad1);
            lblNomCiudad1.setText(CurrentAuto.getNomCiudad());

            TextView lblNomColonia1 = (TextView) itemView.findViewById(R.id.lblNomColonia1);
            lblNomColonia1.setText(CurrentAuto.getNomColonia());

            TextView lblNumSer1 = (TextView) itemView.findViewById(R.id.lblNumSer1);

            lblNumSer1.setText(CurrentAuto.getNumSer()+"");

            TextView lblSumImp1 = (TextView) itemView.findViewById(R.id.lblSumImp1);
            lblSumImp1.setText(CurrentAuto.getSumImp()+"");
/*

            int numSer,sumImp;
        String NomCiudad,NomColonia;
 */

            return itemView;

        }
    }


}
