package material_clase;
import java.awt.Canvas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.util.*;


class myLienzo extends Canvas{
	private String nomImagen;
	public myLienzo(String nomImagen) {
		this.setSize(200, 200);
		this.nomImagen=nomImagen;
	}
	public void paint( Graphics g) 	{
		
		g.drawImage(Rutinas.AjustarImagen(nomImagen, this.getWidth(), this.getHeight()).getImage(), 0, 0,null);
		g.drawString("EJEMPLO DEL LLIENZO EN CANVAS", 20, 20);
		g.drawImage(Rutinas.AjustarImagen("CABALLO.JPG", 50,50).getImage(), 0, this.getHeight()-55,null);
	}
}
class myLienzoTodas extends Canvas implements ActionListener{
	private String nomImagen;
	Timer T;
	int sub;
	String [] imagenes= {"primavera.gif","verano.gif","otoño.jpg","invierno.jpg","maquina.gif","ojo.jpg"};
	public myLienzoTodas(String nomImagen) {
		this.setSize(200, 200);
		sub=0;
		this.nomImagen=nomImagen;
		T=new Timer(500,this);
		T.start();
	}
	public void paint( Graphics g) 	{
		
		g.drawImage(Rutinas.AjustarImagen(nomImagen, this.getWidth(), this.getHeight()).getImage(), 0, 0,null);
		g.drawString("EJEMPLO DEL LLIENZO EN CANVAS", 20, 20);
		g.drawImage(Rutinas.AjustarImagen("CABALLO.JPG", 50,50).getImage(), 0, this.getHeight()-55,null);
	}
	
	public void actionPerformed(ActionEvent e) {

		nomImagen=imagenes[sub % imagenes.length];
		repaint();
		sub++;
	}	
	
	
}
public class GraficoLienzoCanvas extends JFrame{
	myLienzo lienzo1,lienzo2,lienzo3,lienzo4;
	myLienzoTodas lienzo5;
	public GraficoLienzoCanvas() {
		super("manejo de multiples lienzos");
		HazInterfaz();
		HazEscuchas();
	}
	private void HazInterfaz() {
		setSize(600,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(0,2));
		lienzo1=new myLienzo("primavera.gif");
		lienzo2=new myLienzo("verano.gif");
		lienzo3=new myLienzo("otoño.jpg");
		lienzo4=new myLienzo("invierno.jpg");
		lienzo5=new myLienzoTodas("caballo.jpg");
		
		add(lienzo1);
		add(lienzo2);
		add(lienzo3);
		add(lienzo4);
		add(lienzo5);
		
		
		setVisible(true);
	}
	private void HazEscuchas() {
		
	}
	public static void main(String [] a) {
		new GraficoLienzoCanvas();
		
	}
}
