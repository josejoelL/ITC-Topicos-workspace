package Menu;

interface EditarComas {
	
		public String EditarComas(int cant);
		public String EditarComas(double Cant);
		public String EditarComas(long Cant);
}
class Editar implements EditarComas {
	
	

	public String EditarComas(double Cant) {
		
		 System.out.println("Some text..");
		return null;
	}
	
	public String EditarComas(long Cant) {
		
		 System.out.println("Some text..");
		return null;
	}
	
	public String EditarComas(int cant) {
	
		 String cadena = cant+"";
		 //cadena=cadena.lastIndexOf(cant, 3).;
		
			 System.out.println(cadena); 
		return null;
	}
	}