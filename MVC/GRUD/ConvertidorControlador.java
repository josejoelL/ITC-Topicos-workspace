package GRUD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;




public class ConvertidorControlador implements ActionListener ,WindowListener{
	ConvertidorVista Vista;
	ConvertidorModelo Modelo;
	
	public ConvertidorControlador(ConvertidorVista Vista,ConvertidorModelo Modelo){
		this.Vista=Vista;
		this.Modelo=Modelo;
	}
	
	
	public void actionPerformed(ActionEvent Evt) {
		
		
		
		if(Evt.getSource()==Vista.BtnConsultas){
			Vista.paginaSec(true);
			
			Vista.setTabla(Modelo.consultarCtas());
			//quisa tenga que hacer cosas de la tabla aqui
			//     model.addRow(new Object[] { rfc, name, age, cityId });
			//aqui recogera una matriz y la enviara a imprimir a la lista
			
			
			 return;
		}
		if(Evt.getSource()==Vista.BtnRegresa){
			Vista.paginaSec(false);
			 return;
		}
		/*
		if(Evt.getSource()==Vista.BtnPesos){
			double Cantidad=Vista.getCantidad();
			double Pesos=Modelo.Pesos(Cantidad);
			Vista.setResultado(Pesos);
			return;
		}
		if(Evt.getSource()==Vista.BtnDolares){
			
			Vista.setResultado(Modelo.Dolares(Vista.getCantidad()));
			
			return;
			
		}*/
		if(Evt.getSource()==Vista.recuperar){
			
			/*
			String rfc=Vista.getRFC();
			Cliente a=Modelo.recuperar(rfc);
			
			Vista.setNombre(a.getNombre());
			Vista.setEdad(a.getEdad());
			Vista.setidCiudad(a.getIdCiudad());
			*/
			return;
		}
		if(Evt.getSource()==Vista.modificar){
			
			String rfc=Vista.getRFC();
			Cliente a=Modelo.recuperar(rfc);
			
			Vista.setNombre(a.getNombre());
			Vista.setEdad(a.getEdad());
			Vista.setidCiudad(a.getIdCiudad());
			return;
		}
		if(Evt.getSource()==Vista.grabar){	
			//primero deberia checar si lo que subo esta bien 
			String rfc=Vista.getRFC();
			String nombre=Vista.getNombre();
			int    edad=Vista.getEdad();
			int    idCiudad=Vista.getIdCiudad();
			
			
				
			
			
			
			Modelo.grabar(rfc, nombre, edad, idCiudad);
			
			
			
			//Vista.setNuevoCliente(c, I);
			// modelo.addRow(new Object[] { rfc, name, age, cityId });
			
			return;
		}
		if(Evt.getSource()==Vista.borrar){
			String rfc=Vista.getRFC();
			Modelo.borrar(rfc);
			return;
		}
	
	}


	
	
	public void windowClosing(WindowEvent e) {
		Vista.paginaSec(false);		
		return;
	}
	public void windowOpened(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowActivated(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}

}
