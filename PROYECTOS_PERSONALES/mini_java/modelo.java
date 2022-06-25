package mini_java;

import java.util.ArrayList;
import Modelos.Simbolo;

public class modelo {

    public static ArrayList<Simbolo> tablaSimbolos;
  //  public static ArrayList<Cuadruple> cuadruples;
    //public static Programa Arbol;
	
	
//	private String txt;
//	private int palabras;
//	public modelo(){
//		palabras=0;
//		txt="";
//	}
//	public modelo(String txt){
//	
//		this.txt=txt;
//		
//	}
	
	public int contarPalabras(String texto) {//todo el texto llega al metodo	
		return texto.equals("public") ? 1 :texto.split("\\s+").length;	
	}
}
