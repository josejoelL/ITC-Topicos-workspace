package componentes;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;
public class MyPanelAbsolute extends JPanel implements ComponentListener{
	int x,y,w,h;
	JTextField [] vc;
	public MyPanelAbsolute(){
		HazInterfaz();
		HazEscuchas();
	}
	private void HazInterfaz(){
		setLayout(null);
		//this.setPreferredSize(new Dimension(100,100));
		this.setSize(100,100);

		
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

		
		
	}
	private void HazEscuchas(){
		this.addComponentListener(this);
	}
	public String getTexto(int Pos){
		if(Pos<0 || Pos>=vc.length)
			return "Posición no válida";
		return vc[Pos].getText();
	}
	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void componentMoved(ComponentEvent e) {
		
		x = getX();
		y = getY();
	}
	@Override
	public void componentResized(ComponentEvent e) {
		//this.removeAll();
		w = getWidth();
		h = getHeight();
		for(int i=0 ; i< vc.length; i++){
		//	vc[i]=new JTextField();
			vc[i].setSize((int)(w*0.80),20);//w-20
			vc[i].setLocation((int)(w*0.10),5+i*20);
			add(vc[i]);
		}		
	}
	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
	
	}

}