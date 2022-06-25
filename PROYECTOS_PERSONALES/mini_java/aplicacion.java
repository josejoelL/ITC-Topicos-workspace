package mini_java;


public class aplicacion {
	public aplicacion(){
	
		modelo 		M = new modelo();
		vista		V = new vista();
		controlador C = new controlador( V, M);
	
					V.setControlador(C);
	
	
	}
	
	public static void main(String [] a){
		new aplicacion();
	}

}