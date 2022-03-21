package clemente;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class MultiplePantallas implements ActionListener, WindowListener{

	Window [] vp;
	JButton [] BtnAvanza,BtnRegresa;
	byte Sub=0;
	public MultiplePantallas(){

		HazInterfaz();
		HazEscuchas();
	}
	public void HazInterfaz(){
		
		vp=new Window[10];
		vp[0]=new JFrame("Pantalla # 1");
		BtnAvanza=new JButton[vp.length-1];
		BtnRegresa=new JButton[vp.length-1];
		for(int i=0 ; i<BtnAvanza.length;i++){
			BtnAvanza[i]=new JButton("Avanza");
			BtnRegresa[i]=new JButton("Rgeresa");
		}
		
		for(byte i=1 ; i<vp.length;i++){
			vp[i]=new JDialog();
			
		}
		for(int i=0 ; i<vp.length ; i++){
			vp[i].setSize(300,400);
			vp[i].setLocationRelativeTo(null);
			if(i>0){
				((JDialog) vp[i]).setTitle("Pantalla #"+(i+1));
				((JDialog) vp[i]).setModal(true);
				((JDialog) vp[i]).setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		}
		for(int i=0 ; i<BtnAvanza.length; i++){
			vp[i].add(BtnAvanza[i],BorderLayout.SOUTH);
		}
		for(int i=0 ; i<BtnRegresa.length; i++){
			vp[i+1].add(BtnRegresa[i],BorderLayout.NORTH);
		}
		
		vp[0].setVisible(true);
		
		
	}
	public void HazEscuchas(){
		for(int i=0 ; i<BtnAvanza.length;i++){
			BtnAvanza[i].addActionListener(this);
			BtnRegresa[i].addActionListener(this);
			vp[i+1].addWindowListener(this);
		}
		
	}
	public static void main(String [] a){
		new MultiplePantallas();
	}
	@Override
	public void actionPerformed(ActionEvent Evt) {
		JButton Btn=(JButton)Evt.getSource();
		vp[Sub].setVisible(false);
		if(Btn.getText().equals("Avanza"))
		    Sub++;
		 else
		    Sub--;
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
