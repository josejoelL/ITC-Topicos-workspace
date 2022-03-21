package clemente;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class MultiplePantallasV2 implements ActionListener, WindowListener{

	Window [] vp;
	JButton BtnAvanza,BtnRegresa;
	int Sub=0;
	public MultiplePantallasV2(){

		HazInterfaz();
		HazEscuchas();
	}
	public void HazInterfaz(){
		
		vp=new Window[100];
		vp[0]=new JFrame("Pantalla # 1");
	
			BtnAvanza=new JButton("Avanza");
			BtnRegresa=new JButton("Rgeresa");
		
		
		for(int i=1 ; i<vp.length;i++){
			vp[i]=new JDialog();
			
		}
		for(int i=0 ; i<vp.length ; i++){
			vp[i].setSize(300,400);
			vp[i].setLocationRelativeTo(null);
			if(i>0){
				((JDialog) vp[i]).setTitle("Pantalla #"+(i+1));
			//	((JDialog) vp[i]).setModal(true);
				((JDialog) vp[i]).setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		}
		vp[0].add(BtnAvanza,BorderLayout.SOUTH);
		vp[0].setVisible(true);
		
		
	}
	public void HazEscuchas(){
		for(int i=1 ; i<vp.length;i++){
			vp[i].addWindowListener(this);
		}
		BtnAvanza.addActionListener(this);
		BtnRegresa.addActionListener(this);
		
	}
	public static void main(String [] a){
		new MultiplePantallasV2();
	}
	@Override
	public void actionPerformed(ActionEvent Evt) {
		JButton Btn=(JButton)Evt.getSource();
//		vp[Sub].setVisible(false);
		if(Btn.getText().equals("Avanza"))
		    Sub++;
		 else
		    Sub--;
		if(Sub<vp.length-1) 
			vp[Sub].add(BtnAvanza,BorderLayout.SOUTH);
		if(Sub>0)
			vp[Sub].add(BtnRegresa,BorderLayout.NORTH);
		vp[Sub].setVisible(true);
		
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
	public void windowClosing(WindowEvent Evt) {

		vp[Sub].setVisible(false);
		Sub--;

		vp[Sub].add(BtnAvanza,BorderLayout.SOUTH);
		if(Sub>0)
			vp[Sub].add(BtnRegresa,BorderLayout.NORTH);
		vp[Sub].setVisible(true);		

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
