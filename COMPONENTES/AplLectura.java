package componentes;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*; 

import componentes.*;

public class AplLectura extends JFrame implements ActionListener {
	LeeEntero Edad;
	LeeReal   Estatura;
	LeeTexto  Nombre;
	int x,y,w,h;
	MyPanelAbsolute MP;
	public AplLectura(){
		super("Uso de componentes para lectura");
		HazInterfaz();
		HazEscuchas();
	}
	private void HazInterfaz(){
		setSize(600,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(0,2,5,0));
		Edad=new LeeEntero(6);
		Estatura=new LeeReal(8);
		Nombre=new LeeTexto();
		add(new JLabel("Edad",SwingConstants.RIGHT));
		add(Edad);
		add(new JLabel("Estatura",SwingConstants.RIGHT));
		add(Estatura);
		add(new JLabel("Nombre",SwingConstants.RIGHT));
		add(Nombre);
		MP=new MyPanelAbsolute();
		add(new JLabel("panel",SwingConstants.RIGHT));
		add(MP);
		
		//this.setResizable(false);
		setVisible(true);

		
	}
	private void HazEscuchas(){
		Edad.addActionListener(this);
	
	}
	public static void main(String [] a){
		new AplLectura();
	}
	@Override
	public void actionPerformed(ActionEvent Evt) {
		if(Evt.getSource()==Edad){
			if(Edad.getCantidad()<18 || Edad.getCantidad()>60){
				JOptionPane.showMessageDialog(null, "valor no válido");
				return;
			}
			Estatura.requestFocus();
		}
		
	}

}



