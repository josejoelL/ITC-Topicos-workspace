package Modelos;

import java.awt.Color;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

public class Rutinas {

	public static ImageIcon AjustarImagen(String ico,int Ancho,int Alto)
	{
		ImageIcon tmpIconAux = new ImageIcon(ico);
		//Escalar Imagen
		ImageIcon tmpIcon = new ImageIcon(tmpIconAux.getImage().getScaledInstance(Ancho,
				Alto, Image.SCALE_SMOOTH));//SCALE_DEFAULT
		return tmpIcon;
	} 
	
	public static ImageIcon rotaImagen(String ico,int Ancho,int Alto)
	{
		ImageIcon tmpIconAux = new ImageIcon(ico);
		//Escalar Imagen
		ImageIcon tmpIcon = new ImageIcon(tmpIconAux.getImage().getScaledInstance(Ancho,
				Alto, Image.SCALE_SMOOTH));//SCALE_DEFAULT
		
		//hay una libreria que si hace bien el smooth de las fotos
		return tmpIcon;
	} 
	
	
	
	
	
	static Random R=new Random();
	static String []VN ={"ANASTACIA","PLUTARCO","Alicia","Maria","Sofia","Antonio","Nereida","Carolina",
		"Rebeca","Javier","Luis"};
	static String [] VA={"Garcia","Lopez","Perez","Urias","Mendoza","Coppel","Diaz"};
	static boolean [] Sexo={false,true,false,false,false,true,false,false,
		false,true,true};	
	static String []paises ={"MEXICO","COLOMBIA","ARGENTINA","PERU","CHILE","ESPAÑA","VENEZUELA","BOLIVIA",
			"PUERTO RICO","PARAGUAY","URUGUAY"};

	public static String PonBlancos(String Texto,int Tamaño){
		while (Texto.length() <Tamaño)
			Texto+=" ";
		return Texto;
	}
	public static String PonCeros(int Valor, int Tamaño){
		String Texto=Valor+"";
		while (Texto.length()<Tamaño)
			Texto="0"+Texto;
		return Texto;
	}
	public static int nextInt(int Valor){
		return R.nextInt(Valor);
	}
	public static int nextInt(int Ini,int Fin){
		return R.nextInt( Fin-Ini+1  )+Ini;
	}
	public static String nextNombre(int Numero){
		String Nom="",NomTra="";
		int Pos;
		boolean Genero=true;;

		for(int i=0;i<Numero;i++){
			Pos=nextInt(VN.length);

			NomTra=VN[Pos]+" ";

			if (i==0){
				Genero=Sexo[Pos];
			}

			if( Genero != Sexo[Pos]  || i>0 && Nom.indexOf(NomTra)>-1    ){
				i--;
				continue;
			}	

			Nom+=NomTra;

		}
		for(byte i=0;i<2;i++){
			Nom+=VA[nextInt(VA.length)]+" ";
		}
		return Nom.trim();
	}
	public static String nextPais() {
		int Pos=nextInt(paises.length);
		return paises[Pos];
	}
	public static Color nextColor() {
		return new Color(R.nextInt(200)+55,R.nextInt(200)+55,R.nextInt(200)+55);
	}    
}
