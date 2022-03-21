package componentes;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;
public class MyPanel extends JPanel{
	int x,y,w,h;
	
	public MyPanel(){
		HazInterfaz();
		HazEscuchas();
	}
	private void HazInterfaz(){
		setLayout(new GridLayout(0,1));
		this.setPreferredSize(new Dimension(100,100));
		
		this.setBorder(new LineBorder(Color.red));
		JTextField [] vc=new JTextField[5];
		for(int i=0 ; i<5; i++){
			vc[i]=new JTextField();
			add(vc[i]);
		}
		

	}
	private void HazEscuchas(){
	
	}

}
