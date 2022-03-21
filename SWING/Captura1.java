package material_clase;

public class Captura1 {
	// ATRIBUTOS
	static private int edad,eeso,estatura;
	private float tamañoZapato;
	private String nombre;
	
	public static void Captura() {
		System.out.println("-----estoy en captura -------");
		edad=10;
		
	}
	
	public static void Imprime() {
		System.out.println("--- etoy en impresión ----");
		System.out.println("Edad : "+edad);
		
	}
	public static void main(String [] a) {
		
		System.out.println("---- estoy en el main -----");
		Captura();
		edad=88;
   	    Imprime();
   	    System.out.println("**** CONTENIDOO DEL ARREGLO *****	 Elementos : "+a.length);
   	    for(int i=0 ; i<a.length ; i++)
   	    	System.out.println(i+"  "+a[i]);
   	    System.out.println("**********************");
		
	}
}
