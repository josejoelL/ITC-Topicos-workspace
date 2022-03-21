package Escalador;

import javax.swing.JPanel;

public class panelParticipante extends JPanel {
private	String nombre;
private	int meta;
	
		public panelParticipante(String nombre,int meta){
			this.nombre=nombre;
			this.meta=meta;
			ConvertidorVista Vista=new ConvertidorVista();
		//	ConvertidorModelo Modelo=new ConvertidorModelo(meta);
		//	ConvertidorControlador Controlador=new ConvertidorControlador(Vista,Modelo);
		//	Vista.setControlador(Controlador);
	
	}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public void setMeta(int meta) {
			this.meta = meta;
		}
		
}