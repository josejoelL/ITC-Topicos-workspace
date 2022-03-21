package material_clase;

public class Captura2 {
	// ATRIBUTOS
		private int edad,eeso,estatura;
		private float tamañoZapato;
		private String nombre;
		public Captura2() {
			System.out.println("---- estoy en el main -----");
			Captura();
			edad=88;
	   	    Imprime();
	   	    System.out.println("**** CONTENIDOO DEL ARREGLO *****");
	   	    System.out.println("**********************");			
		}
		public  void Captura() {
			System.out.println("-----estoy en captura -------");
			edad=10;
		}
		
		public  void Imprime() {
			System.out.println("--- etoy en impresión ----");
			System.out.println("Edad : "+edad);
			
		}
		public  static void main(String [] a) {
			new Captura2(); // al crear un objeto se ejecuta el constructor 
		}
}
