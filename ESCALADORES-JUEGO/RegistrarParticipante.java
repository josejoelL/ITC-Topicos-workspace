package Escalador;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class RegistrarParticipante extends JPanel{
	int x,y,w,h;
	
	public RegistrarParticipante(){
		HazInterfaz();
		HazEscuchas();
	}
	private void HazInterfaz(){
		
		
		/*
		setLayout(new GridLayout(1,0));
		this.setPreferredSize(new Dimension(100,100));
		
		this.setBorder(new LineBorder(Color.red));
		JTextField [] vc=new JTextField[5];
		for(int i=0 ; i<5; i++){
			vc[i]=new JTextField();
			add(vc[i]);
			*/
		
		setLayout(null);
		//this.setPreferredSize(new Dimension(100,100));
		 this.setSize(100,150);

		 Label p1 = new Label();
		 p1.setText("Player 1");
		 p1.setSize(20,60);
		 p1.setLocation(20, 20);
		 add(p1);
		 JButton b1 = new JButton("actualizar");
		 //b1.setSize(30,30);
		 p1.setLocation(20,20);
		add(b1);
			this.setBorder(new LineBorder(Color.red));
		/*
		this.setBorder(new LineBorder(Color.red));
		vc=new JTextField[5];
		w = getWidth();
		h = getHeight();
		for(int i=0 ; i< vc.length; i++){
			vc[i]=new JTextField();
//			vc[i].setSize(w-20,20);
//			vc[i].setLocation(10,5+i*20);
//			add(vc[i]);
			
			
		}

			
		}*/
		

	}
	private void HazEscuchas(){
	
	}

}
