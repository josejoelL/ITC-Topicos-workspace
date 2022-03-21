package contarPalabras;

public class modelo {
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
	
	public int contarPalabras(String texto) {
		
		return texto.split("\\s+").length;
		
	}
}
