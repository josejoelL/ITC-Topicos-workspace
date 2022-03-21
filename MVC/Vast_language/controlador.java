package Vast_language;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class controlador implements ActionListener {

	vista vista;
	modelo modelo;
	
	public controlador(vista vista, modelo modelo) {
		this.vista=vista;
		this.modelo=modelo;
	}
	public void actionPerformed(ActionEvent e) {

		if (e.getSource()== vista.btnCont ){
			
			String texto=vista.getTexto();
			int  Npalabras =modelo.contarPalabras(texto);
			
			vista.setResultado(Npalabras);
			return;
			
		}
		
		
	
	}
}
