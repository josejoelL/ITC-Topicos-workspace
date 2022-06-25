package project;


public class App {
		 Vista v=new Vista();
		Modelo m=new Modelo();
   Controlador c=new Controlador(v,m);
	//	v.setControlador(c); todos los eventos --zika
	
	
		
	
	public static void main(String[] args) {
		new App();

	}

}

