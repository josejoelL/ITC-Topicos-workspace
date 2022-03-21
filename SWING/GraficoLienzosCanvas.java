package clemente;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.*;

import java.awt.Event.*;

class MyLienzo extends Canvas {
	private String NomImagen;
	public MyLienzo(String NomImagen){
		this.setSize(200, 200);
		this.NomImagen=NomImagen;
	}
	public void paint( Graphics g) 	{
		g.drawString("EJEMPLO DEL LLIENZO EN CANVAS", 20, 20);
		g.drawImage(Rutinas.AjustarImagen(NomImagen, this.getWidth(), this.getHeight()).getImage(), 0, 0,null);
		g.drawImage(Rutinas.AjustarImagen("CABALLO.JPG", 50,50).getImage(), 0, this.getHeight()-55,null);

	}
}
public class GraficoLienzosCanvas extends JFrame {
	MyLienzo L1,L2,L3,L4;
	
	public GraficoLienzosCanvas(){
		super("Manejo de lienzos canva");
		HazInterfaz();
		HazEscuchas();
	}
	private void HazInterfaz(){
		setSize(500,600);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(0,2));
		add(L1=new MyLienzo("Primavera.gif"));
		add(L2=new MyLienzo("verano.gif"));
		add(L3=new MyLienzo("verano.gif"));
		add(L4=new MyLienzo("primavera.gif"));
		setVisible(true);
		
	}
	private void HazEscuchas(){
		
	}
	public static void main(String [] a){
		new GraficoLienzosCanvas();
	}
}
