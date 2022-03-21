package clemente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ConvertidorControlador implements ActionListener {
	ConvertidorVista Vista;
	ConvertidorModelo Modelo;
	public ConvertidorControlador(ConvertidorVista Vista,ConvertidorModelo Modelo){
		this.Vista=Vista;
		this.Modelo=Modelo;
	}
	
	
	public void actionPerformed(ActionEvent Evt) {
		if(Evt.getSource()==Vista.BtnPesos){
			double Cantidad=Vista.getCantidad();
			double Pesos=Modelo.Pesos(Cantidad);
			Vista.setResultado(Pesos);
			return;
		}
		if(Evt.getSource()==Vista.BtnDolares){
			
			Vista.setResultado(Modelo.Dolares(Vista.getCantidad()));
			
			return;
		}
	}

}
