package Hanoi;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;

import tarea.src.ConvertidorControlador;


public class PanelOpciones extends JPanel {
	private BtnEmpieza BtnEmpieza;
	private BtnPausa BtnPausa;
	private JButton BtnSalir;
	
	
	private Deslizador NumAros;
	private Deslizador TiempoDeslizador;

	private Barras b;
	private Vista v;

	private Thread runningThread;

	
	
	static class Deslizador extends JPanel implements ChangeListener {
		static	String originalLabel;
		static JLabel label;
		static JSlider slider;
		
		Deslizador(String labelString, int minValor, int maxValor, int espacio, int orientacion) {
			this.originalLabel = labelString;
			if(orientacion == JSlider.HORIZONTAL) {
				setLayout(new GridLayout(2,1));
				
			}
			else {
				setLayout(new GridLayout(1,2));
			}
			slider = new JSlider(orientacion, minValor, maxValor, minValor);
			slider.setMajorTickSpacing(espacio);
			slider.setPaintTicks(true);
			slider.setPaintLabels(true);
			

			add(label = new JLabel());
			add(slider);
		
			setValor(minValor);
		}
		
		public void setControlador(Controlador C){
			slider.addChangeListener(C);
		}
		
		
		public void stateChanged(ChangeEvent Evt) {
			JSlider sitio = (JSlider)Evt.getSource();
			
			if(!sitio.getValueIsAdjusting()) {
				label.setText(originalLabel +" "+ Integer.toString(getValor()));
			}
		}

		static int getValor() {
			return (int)slider.getValue();
		}

		void setValor(int valor) {
			label.setText(originalLabel +" "+ Integer.toString(valor));
			slider.setValue(valor);
		}
		
		
		
		
		
		
		
		
		
		
		class Zoom extends Deslizador implements ChangeListener {
			private Barras b;
			Zoom() {
				super("Zoom:", 1, 10, 1, JSlider.HORIZONTAL);

				setValor(5);
				slider.addChangeListener(this);
				b.setPixelScaling(5);
				b.repaint();
			}

			public void stateChanged(ChangeEvent Evt) {
				super.stateChanged(Evt);
				JSlider source = (JSlider)Evt.getSource();
				if(!source.getValueIsAdjusting()) {
					int scaling = (int) source.getValue();
					b.setPixelScaling(scaling);
					b.repaint();
				}
			}
		}
		

	}
	class BtnEmpieza{
		
	}
	class BtnPausa{
			
	}
	public void actionPerformed(ActionEvent e) {
		
	}
}
