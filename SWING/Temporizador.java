package clemente;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class Temporizador extends JDialog implements ActionListener, WindowListener {
	private String Texto;
	JLabel LblTexto;
	Timer T;
	public Temporizador(String Texto){
		this.Texto=Texto;
		HazInterfaz();

		T=new Timer(500,this);

		
		T.setRepeats(true);
		T.start();
		
	
		this.addWindowListener(this);
		//Ajusta(Texto);
		while(this.Texto.length()<80)
			this.Texto+=" ";
	
	}

	public void HazInterfaz(){
		LblTexto=new JLabel(Texto);
		add(LblTexto,BorderLayout.SOUTH);
		setSize(300,300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setModal(true);
	}
	public void actionPerformed(ActionEvent Evt) {
		if(Evt.getSource()==T)
			Texto=Texto.substring(1)+Texto.charAt(0);
		LblTexto.setText(Texto);
		
	}
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		T.stop();
		
	}
	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
