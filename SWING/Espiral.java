package clemente;
import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
public class Espiral extends JFrame implements ActionListener,
												MouseListener, WindowListener {
	
	private int N;
	JButton BtnDer,BtnIzq,BtnDerCentro,BtnIzqCentro,BtnLimpiar,Btns [][] ;
	public Espiral(){
		N=new Random().nextInt(6)+5;
		Btns=new JButton[N][N];
		HazInterfaz();
		HazEscuchas();
	}
	private void HazInterfaz(){
		
		UIManager.LookAndFeelInfo[] looks;
		String [] lookNames;
		looks = UIManager.getInstalledLookAndFeels();
		lookNames = new String [looks.length];
		for (int i = 0; i < lookNames.length; i++) {lookNames [i] = looks [i].getName();}
		try {UIManager.setLookAndFeel(looks[1].getClassName());} catch (Exception e) {}
		
		
		
		
		
		setTitle("** Espiral externo - interno");
		setSize(400,400);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(0,N));
		
		for(int i=0 ; i< N ; i++)
			for(int j=0 ; j<N ; j++)
				Btns[i][j]=new JButton();
		
		for(int i=0 ; i< N ; i++)
			for(int j=0 ; j<N ; j++)
				add(Btns[i][j]);		
		BtnDer=new JButton("Derecha");
		BtnIzq=new JButton("Izquierda");
		BtnDerCentro=new JButton("centro derecha");
		BtnIzqCentro=new JButton("centro Izquierda");
		BtnLimpiar=new JButton("Limpiar");
		add(BtnDer);
		add(BtnIzq);
		add(BtnDerCentro);
		add(BtnIzqCentro);
		add(BtnLimpiar);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	private void HazEscuchas(){
		BtnIzq.addActionListener(this);
		BtnDer.addActionListener(this);
		for(int i=0 ; i<Btns.length ; i++)
			for(int j=0 ; j<Btns.length ; j++){
				Btns[i][j].addActionListener(this);
				Btns[i][j].addMouseListener(this);
			}
		this.addWindowListener(this);
	}
	public static void main(String[] args) {
		new Espiral();
	}

	public void actionPerformed(ActionEvent Evt) {
		if(Evt.getSource()==BtnDer){
			
			return;
		}
		if(Evt.getSource()==BtnIzq){
			
			return;
		}
		
		JButton Aux=(JButton) Evt.getSource();
		Aux.setBackground(Color.PINK);
		Aux.setText(""+new Random().nextInt(100));
		
/*		
		int Ren,Col;
		Ren=Col=-1;
		for(int i=0 ; i< Btns.length ; i++)
			for(int j=0 ; j<Btns.length ; j++)
				if(Evt.getSource()==Btns[i][j]){
					Ren=i;
					Col=j;
					break;
				}
		Btns[Ren][Col].setBackground(Color.PINK);
*/		
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("click");
		
	}
	@Override
	public void mouseEntered(MouseEvent Evt) {
		JButton Aux=(JButton) Evt.getSource();
		Aux.setBackground(new Color(new Random().nextInt(2147483647)));
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("salida");
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("presionado");
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("liberado");
	}
	@Override
	public void windowActivated(WindowEvent arg0) {
		System.out.println("la ventana se está ACTIVA");
		
	}
	@Override
	public void windowClosed(WindowEvent arg0) {
		System.out.println("la ventana se está cerrÓ");
		
	}
	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stu
		System.out.println("la ventana se está cerrando");
	}
	@Override
	public void windowDeactivated(WindowEvent arg0) {
		System.out.println("la ventana se está INACTIVA");
		
	}
	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("la ventana se está NO SE QUE HACCE");
	}
	@Override
	public void windowIconified(WindowEvent arg0) {
		System.out.println("la ventana se está NO SE QUE HACCE");
		
	}
	@Override
	public void windowOpened(WindowEvent arg0) {
		System.out.println("la ventana se está ABRIERTA");
		
	}

}
