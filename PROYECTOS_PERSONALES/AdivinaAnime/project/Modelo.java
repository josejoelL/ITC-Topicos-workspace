package project;

import java.util.ArrayList;
import java.util.Iterator;

import Modelos.Rutinas;
import Modelos.opening;
/*

import java.sql.Connection; //instalar la libreria

import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

*/
import Modelos.pruebaConexion;
public class Modelo {
	// aqui manejo la funcionalidad
	//base de datos
	private int rondas, difiID, genID,opciones;
	private pruebaConexion BD;
	
	 private ArrayList<opening> listaOpening = new ArrayList<opening>();
	 
	 static opening [][] op ;
	 
	//static final String DATABASE_URL = "jdbc:mysql://localhost/AdivinaAnime";
	 
	 
	
	
	
	
	
	
	
	/*
	public ConvertidorModelo(double Cotizacion){
		this.Cotizacion=Cotizacion;
	}
	*/
	
	
	public void iniciaRonda(int rondas,int difiID,int genID) {
		this.rondas=rondas;
		
		
		
	}
	public void iniciaRonda(int rondas,int difiID) {
		this.rondas=rondas;
		
		opciones = 4;
		op= new opening[rondas][opciones];
		op=generaListaOpenings(op);
		
		for (int i = 0; i < op.length; i++) {
			for (int j = 0; j < opciones; j++) {
				try {
					
					System.out.println("Ronda "+(i+1)+"."+(j+1)+"-"+op[i][j].getOpID() +" ");
				} catch (Exception e) {
					
				}
			}
			
			System.out.println("");
		}
		//runMusic play op[i].getOpRuta()
		
		
		
		
		
	}
	
	
	public  opening[][] generaListaOpenings (opening[][] op2) {
		pruebaConexion BD= new pruebaConexion();
		
		
		BD.getConnection();
		//BD.setQuery("SELECT * FROM opening");
		//	BD.setQuery("SELECT * FROM anime ");
		
		for (int i = 0; i < op2[i].length; i++) {
			//opening opening = op[i];
			for(int j = 0; j < opciones; j++) {
				op2[i][j]= animeRandom();
				
			}
		}
		return op2;
		
	}
	
	
	private opening animeRandom() {
		
	
		
		//son como 800 animes
		//dependiendo de la dificultad seran los que se traiga
		int ListaAnimeid=170;// traerla de la base de datos
		int idRandom;
		idRandom=Rutinas.nextInt(1, ListaAnimeid);
		//buscar en la base de datos con la ID y recuperar los datos para acompletar
		opening opRandom =new opening(idRandom, null, null, null);
		return opRandom;
	}
	
	
	
	
}
