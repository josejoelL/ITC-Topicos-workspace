package clemente;
import java.awt.GridLayout;

import javax.swing.*;
public class ConvertidorVista extends JFrame {
	 JButton BtnPesos,BtnDolares;
	private JLabel LblResultado;
	private JTextField TxtCantidad;
	
	
	public ConvertidorVista(){
		super("Convertidor Pesos-Dolar");
		HazInterfaz();
	}
	private void HazInterfaz(){

		UIManager.LookAndFeelInfo[] looks;
		String [] lookNames;
		looks = UIManager.getInstalledLookAndFeels();
		lookNames = new String [looks.length];
		for (int i = 0; i < lookNames.length; i++) {lookNames [i] = looks [i].getName();}
		try {UIManager.setLookAndFeel(looks[3].getClassName());} catch (Exception e) {}
		
		
		setSize(300,200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new GridLayout(0,2,5,5));
		BtnPesos=new JButton("Pesos");
		BtnDolares=new JButton("Dolares");
		TxtCantidad=new JTextField(20);
		
		add(new JLabel("Cantidad",SwingConstants.RIGHT));
		add(TxtCantidad);
		add(BtnPesos);
		add(BtnDolares);
		add(new JLabel("Entregar: ",SwingConstants.RIGHT));
		add(LblResultado=new JLabel());
		setVisible(true);
	}
	public void setControlador(ConvertidorControlador C){
		BtnPesos.addActionListener(C);
		BtnDolares.addActionListener(C);
	}
	public double getCantidad(){
		double Cantidad=0.0;
		try{
			Cantidad=Double.parseDouble(TxtCantidad.getText());
		} catch (Exception E){
			
		}
		return Cantidad;
	}
	public void setResultado(double Cantidad){
		LblResultado.setText(Cantidad+"");
	}
}
