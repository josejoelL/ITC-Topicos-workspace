package Menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Escalador.PanelMontaña;
import componentes.Rutinas;
import componentes.meta;



public class InterfazEscalador implements ActionListener, MouseListener {

	private JButton btnSumar, btnRestar, btnJugar;
	private JButton cerrar,config;
	private int jugadores;
	private JPanel Panelmain;
	private JPanel  P1, P2, glass,P3,P4;
	private pantallaComenzar P0;
	private Window Main;
	private componentes.meta S;
	private boolean band;
	
	
	private Vector<PanelMontaña> VEscaladores = new Vector<PanelMontaña>();

	public InterfazEscalador() {
	
		band=false;
		jugadores=3;
		 S = new meta();
		
		HazInterfaz();
		HazEscuchas();

	}



	public void HazInterfaz() {

  
		Main = new JFrame(" Escaladores ");
		 
		Main.setSize(1080, 720);
	
		Panelmain = new JPanel();
	
	
		((Frame) Main).setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		
		 P0 = new pantallaComenzar(); 
		Main.add(P0);  
		 P1 = new JPanel();
		 P2 = new JPanel();
		 P3 = new JPanel();
		 P4 = new JPanel();
	   
		P1.setLayout(new GridLayout(1, 0, 10, 10));
		P2.setLayout(new FlowLayout(FlowLayout.CENTER));
		
	
		for (int i = 0; i < jugadores; i++) {
			
			VEscaladores.addElement(new PanelMontaña(i + 1, S));
			P1.add(VEscaladores.lastElement());
		}
	
		Panelmain.setLayout(new BorderLayout());
		
		
		  glass=(JPanel) ((JFrame) Main).getGlassPane();
		  
		  
		  P3.setLayout(new BorderLayout());
		  P3.setPreferredSize(new Dimension(150, 90));
		  
		  P4.setLayout(new FlowLayout(FlowLayout.CENTER));
		  
		  
		 cerrar = new JButton(" cerrar ");
		 cerrar.setBackground(Color.black);
		 cerrar.setForeground(Color.white);
		 P3.add(cerrar,BorderLayout.SOUTH);
		 
		 config = new JButton();
		 config.setBackground(Color.white);
		 config.setIcon(Rutinas.AjustarImagen("src/sprite/config.png", 25, 25));
		 config.setBorderPainted(false);
		 config.setBackground(new Color(17, 45, 78));
		 P4.add(config);
		 
		 	glass.add(P3);
		 	P3.add(P2);
			Panelmain.add(P1, BorderLayout.CENTER);
			Panelmain.add(P4, BorderLayout.SOUTH);
		 
		 
		btnSumar = new JButton();
		btnSumar.setBackground(new Color(17, 45, 78));
		btnSumar.setBorderPainted(false);
		btnSumar.setIcon(Rutinas.AjustarImagen("src/sprite/mas.png", 25, 25));
		btnSumar.setPreferredSize(new Dimension(25, 25));
		
		
		btnRestar = new JButton();
		btnRestar.setBackground(new Color(17, 45, 78));
		btnRestar.setBorderPainted(false);
		btnRestar.setIcon(Rutinas.AjustarImagen("src/sprite/menos.png", 25, 25));
		btnRestar.setPreferredSize(new Dimension(25, 25));
		
		
		btnJugar = new JButton();
		btnJugar.setBackground(Color.orange);
		btnJugar.setIcon(Rutinas.AjustarImagen("src/sprite/play.png", 840/10, 497/10));
		btnJugar.setBorderPainted(false);
		btnJugar.setPreferredSize(new Dimension(56, 50));
		P1.setBackground(new Color(114, 63, 75));
		P2.setBackground(Color.orange);
		P4.setBackground(new Color(17, 45, 78));
		
		P2.add(btnRestar);
		P2.add(btnJugar);
		P2.add(btnSumar);

	

		((JFrame) Main).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Main.setVisible(true);

		Image icon = new ImageIcon(getClass().getResource("ico.png")).getImage();
		Main.setIconImage(icon);


	}
	
	private void HazEscuchas() {
		P0.addMouseListener(this);
		btnRestar.addActionListener(this);
		btnJugar.addActionListener(this);
		btnSumar.addActionListener(this);
		cerrar.addActionListener(this);
		config.addActionListener(this);
		
		
	}
	public void actionPerformed(ActionEvent e) {
	if (e.getSource()==btnJugar) {
			for (int i = 0; i < VEscaladores.size(); i++) 
			VEscaladores.get(i).run();
			glass.setVisible(false);	
			P1.revalidate();
		return;
	}
	if (e.getSource()==btnSumar) {
		
		jugadores++;
		VEscaladores.addElement(new PanelMontaña(jugadores, S));
		P1.add(VEscaladores.lastElement());
		P1.revalidate();
		return;
	}
	if (e.getSource()==btnRestar) {
		if (jugadores < 1)
			return;
		P1.remove(jugadores - 1);
		VEscaladores.removeElementAt(jugadores - 1);
		jugadores--;
		P1.revalidate();
		
		return;
	}
	if ( e.getSource()== cerrar) {

		glass.setVisible(false);			

		return;
	}
	if (e.getSource()== config) {
		glass.setVisible(true);
		return;
	}
	
	
	}
	public static void main(String[] args) {
		new InterfazEscalador();
	}

	
	public void mouseClicked(MouseEvent e) {

			if (!band) {
				band = true;
				Main.remove(P0);
				Main.add(Panelmain);
				Main.revalidate();
			}
		

	}
		
	

	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}

	

}
