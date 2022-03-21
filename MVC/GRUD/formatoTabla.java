package GRUD;



public class formatoTabla extends Cliente {
	private String rfc;
	public formatoTabla(String rfc,String nombre, int edad, int idCiudad) {
		
		super(nombre, edad, idCiudad);
		this.rfc = rfc;
	}
	
}
