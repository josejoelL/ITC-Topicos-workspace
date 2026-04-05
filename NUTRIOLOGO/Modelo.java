
/**
 * Fecha: 1 Abril 2026 autor: Landeros Santos Jose Joel
 * 
 **/
public class Modelo {
   private Cliente cliente;
   private ClasificacionIMC clasificacion;
   public Modelo(){
         cliente = new Cliente(0,0);

	}
   
    public double getIMC(double peso, double altura) {
        cliente.setPeso(peso);
        cliente.setAltura(altura);
        
		return (cliente.getPeso() / (cliente.getAltura()*cliente.getAltura())) ;
	}
     public ClasificacionIMC getClasificacion(double IMC) {
 
     clasificacion = ClasificacionIMC.setIMC(IMC);
  
    return clasificacion;
	}
}
