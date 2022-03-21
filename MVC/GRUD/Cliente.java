package GRUD;

public class Cliente {
	//private String RFC;
	//private int Nregistro;
	//private boolean estado;
	
	private String nombre;
	private int edad;
	private int idCiudad;
	
	static final int LARGO=40+4+4;

	public Cliente(String nombre, int edad, int idCiudad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.idCiudad = idCiudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}


	public String toString() {
		return nombre+edad+idCiudad;
	}
	
}
