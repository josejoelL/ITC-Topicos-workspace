package contarPalabras;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Scrollbar;

import javax.swing.*;
public class vista extends JFrame {
	 JButton btnCont;
	private JLabel LblResultado;
	private JTextArea Txt;
	private JPanel P1,P2;
    Scrollbar S;
	public vista(){
		super("Contar Palabras");
		HazInterfaz();
	}
	private void HazInterfaz(){
		setSize(300,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setResizable(false);
		 P1 = new JPanel();
		 P2 = new JPanel();
		 
		
			P1.setLayout(new GridLayout(0,2));
			P2.setLayout(new FlowLayout(FlowLayout.CENTER));
		setLayout(new BorderLayout());
		btnCont=new JButton("contar");
		
		Txt=new JTextArea();
		Txt.setWrapStyleWord(true);
		
	//	add(new JLabel("Cantidad Palabras",SwingConstants.CENTER));
		
		add(Txt,BorderLayout.CENTER);
		S=new Scrollbar(); 
		
		P1.add(new JLabel("Resultado: ",SwingConstants.LEFT));
		
		P1.add(LblResultado=new JLabel("",SwingConstants.CENTER));
		add(P1,BorderLayout.NORTH);
		P2.add(btnCont);
		add(P2,BorderLayout.SOUTH);
		setVisible(true);
	}
	public void setControlador(controlador C){
		btnCont.addActionListener(C);

	}
	public String getTexto() {
		return Txt.getText();
	}
	
	
	public void setResultado(int palabras){
		LblResultado.setText(palabras+"");
	}
}
