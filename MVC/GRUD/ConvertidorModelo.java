package GRUD;

import java.util.Hashtable;
import java.util.Vector;



public class ConvertidorModelo  {
	static Vector<Indice> VIndice=new Vector<Indice>();
	static Vector<Cliente> VClientes=new Vector<Cliente>();
	static Vector<formatoTabla> VFT=new Vector<formatoTabla>();
	ManejoArchivos ma=new ManejoArchivos();
	
	Hashtable Numeros = new Hashtable();


		
	
	public void grabar (String rfc,String nombre,int edad,int idCiudad) {
		/*
		int Nregistro=0;
		if (rfc.length()>10) {
			
		}else
		if (nombre.length()>40) {
			
		}else
		if (integer.) {
			
		}	*/
		
		
		
		
		
		
		
		ma.abrirIndice();
		ma.registrarIndice(new Indice(rfc,ma.Nregistro(),true));
		ma.cerrarIndice();

		ma.abrirClientes();
		ma.registrarCliente(new Cliente(nombre,edad,idCiudad));
		ma.cerrarClientes();
		
		
	}
	public Cliente recuperar (String rfc) {
		ma.abrirIndice();
		ma.consultarIndicePorRFC(rfc);
		ma.cerrarIndice(); 
		return null;
	}/*
	private static boolean MostrarClientes() {
		System.out.println();
		boolean band=false;
		for(int i=0 ; i<VClientes.size() ; i++) {
			System.out.println((i+1)+"-. "+VClientes.get(i));
			band=true;
		}
		System.out.println();
		return band;
	}	*/
	public void modificar (String rfc) {
		ma.abrirIndice();
	
		ma.cerrarIndice();
		
	}
	
	
	
	public void borrar (String rfc) {
		ma.abrirIndice();
		ma.darBajaPorRFC(rfc);
		ma.cerrarIndice();
	}
	
	public Vector<formatoTabla> consultarCtas () {
		
			ma.abrirIndice();
		VIndice  =	ma.consultarIndices();
			ma.cerrarIndice();
			ma.abrirClientes();
		VClientes= ma.consultarClientes();
		ma.cerrarClientes();
		
		for (int i = 0; i < VIndice.size(); i++) {
			if (VIndice.get(i).isEstado()) {
				continue;
			}
			
			VFT.add(new formatoTabla(VIndice.get(i).getRfc(),VClientes.get(i).getNombre(),VClientes.get(i).getEdad(),VClientes.get(i).getIdCiudad()));
		}
		
		
		//aqui recogere  y hare la tablita
	
		
		
		return VFT;
		
	}
		
	
	
	
	
	/*
	private double Cotizacion;
	public ConvertidorModelo(){
		Cotizacion=24.06;
	}
	public ConvertidorModelo(double Cotizacion){
		this.Cotizacion=Cotizacion;
	}
	public double Pesos(double Cantidad){
		return Cantidad*Cotizacion;
	}
	public double Dolares(double Cantidad){
		return Cantidad/Cotizacion;
	}*/
}
