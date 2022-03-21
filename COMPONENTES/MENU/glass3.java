package Menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class glass3 implements ActionListener {
	JFrame frame;
	 JPanel p1,p2,p3;
	 private JButton config,cerrar;
	 private JButton btnSumar, btnRestar, btnJugar;
	 JPanel glass;
	public glass3() {
		hazInterfaz();
		hazEscuchas();
	}
		
	
	private void hazInterfaz() {
		
		
		    frame = new JFrame("probar glass");
		    frame.setSize(1500, 800);
		    frame.setLocationRelativeTo(null);
		    
		    p1 = new JPanel(new BorderLayout());
		    
		    frame.add(p1);
		    config = new JButton(" configurar ");
		    p1.add( config,BorderLayout.SOUTH);
		   
		   
		    glass=(JPanel) frame.getGlassPane();
		//    z.setBounds(x, y, width, height);
		    
		    p2 = new JPanel();
		    
		    p3 = new JPanel();
		    p3.setLayout(new BorderLayout());
		    
		    
		    p2.setLayout(new FlowLayout(FlowLayout.CENTER));
		    
		    
		    p3.setPreferredSize(new Dimension(250, 70));
		  //  glass.setBounds(x, y, width, height);
		    glass.setLayout(new GridLayout(0,4));
		    glass.add(p3);
		  //  glass.setVisible(true);
		    
		    p3.add(p2,BorderLayout.CENTER);
		    cerrar = new JButton(" cerrar ");
		    p3.add(cerrar,BorderLayout.SOUTH); //          cerrar
		   
		    
		   	btnSumar = new JButton(" + ");
			btnSumar.setForeground(Color.white);
			btnSumar.setBackground(new Color(114, 63, 75));
			
			btnRestar = new JButton(" - ");
			btnRestar.setForeground(Color.white);
			btnRestar.setBackground(new Color(63, 114, 175));
			
			p2.setBackground(Color.black);
			cerrar.setBackground(Color.white);
			btnJugar = new JButton(" comenzar ");
			btnJugar.setBackground(Color.white);
		    
			p2.add(btnRestar);
			p2.add(btnJugar);
			p2.add(btnSumar);
			
	        p1.setBackground(new Color(17, 45, 78));
		//  glass.setOpaque(true);
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setVisible(true);
		    
		   
	}
	private void hazEscuchas() {
			cerrar.addActionListener(this);
			config.addActionListener(this);
		
		
	}

	public static void main(String[] args) {
		new glass3();

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if ( e.getSource()== cerrar) {

			glass.setVisible(false);			

			return;
		}
		if (e.getSource()== config) {
			glass.setVisible(true);
			return;
		}
		
	}

}
