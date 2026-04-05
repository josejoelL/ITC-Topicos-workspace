package sistemabancario;

/**
 * Fecha: 1 Abril 2026 autor: Landeros Santos Jose Joel
 * 
 **/
public class Aplicacion{
	public Aplicacion(){
	
		Modelo 		M = new Modelo();
		Vista		V = new Vista();
		Controlador C = new Controlador( V, M);
	
		V.setControlador(C);
	
	
	}
    public static void main(String[] args) {
        System.out.println("Iniciando Sistmea Bancario...");
        new Aplicacion();
    }
}
