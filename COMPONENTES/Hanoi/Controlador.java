package Hanoi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Hanoi.PanelOpciones.Deslizador;



public class Controlador implements ActionListener,ChangeListener  {
	PanelMovimientos PanelMovimientos;
	PanelOpciones PanelOpciones;
	Vista Vista;
	Modelo Modelo;
	public Controlador(Vista Vista,Modelo Modelo,PanelMovimientos PanelMovimientos,PanelOpciones PanelOpciones){
		this.Vista=Vista;
		this.Modelo=Modelo;
		this.PanelMovimientos=PanelMovimientos;
		this.PanelOpciones=PanelOpciones;
	}
	
	
	public void actionPerformed(ActionEvent Evt) {
		if(Evt.getSource()==Vista){
			
			return;
		}
		if(Evt.getSource()==Vista){
			
			return;
		}
	

}


		public void stateChanged(ChangeEvent Evt) {
		
			
			
		
		if (Evt.getSource() == Deslizador.slider) {
			
			JSlider sitio = (JSlider) Evt.getSource();
			
			if (!sitio.getValueIsAdjusting()) {
				Deslizador.label.setText(Deslizador.originalLabel + " " + Integer.toString(Deslizador.getValor()));
			}
			return;
		}

		}

 
}
