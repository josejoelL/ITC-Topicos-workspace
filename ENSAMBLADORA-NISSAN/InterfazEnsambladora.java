package ensambladora;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import material_clase.Rutinas;


public class InterfazEnsambladora extends JFrame{
	
	private int w, h;
	Graphics g;
	Image backbuffer = null;	
	
	public InterfazEnsambladora () {
		super("NISSON");
	
		
		HazInterfaz();
		HazEscuchas();
		
		
		backbuffer = createImage(getWidth(), getHeight());
		g =backbuffer.getGraphics();

		
	}
	
	private void HazInterfaz() {
		
		setSize(626*2,248*3);
		setLocationRelativeTo(null);
	
		
		
		
		Image icon = new ImageIcon(getClass().getResource("NISSON.png")).getImage();
		setIconImage(icon);
		
		setVisible(true);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
		
	public void paint( Graphics g) 	{

		Dibuja();

		
		
		g.drawImage(backbuffer, 0, 0, getWidth(), getHeight(), this);	
	
	}
	private void Dibuja() {
		if(g==null)
			return;
		super.paint(g);
		
		  w = getWidth();
		  h = getHeight();
		g.drawImage(Rutinas.AjustarImagen( "src/sprite/image/fondo.jpg", w,h).getImage(), 0, 0,null);
		g.setColor(Color.white);
		
		g.drawString("1. Chasis y cableado",50,45);
		g.drawImage(Rutinas.AjustarImagen( "src/sprite/image/robot_1.jpg", (int)( w*0.10 ), (int)( h*0.10 )).getImage(), 40+200,(int)( h*0.10 -25),null);
		g.drawImage(Rutinas.AjustarImagen( "src/sprite/image/robot_1.jpg", (int)( w*0.10 ), (int)( h*0.10 )).getImage(), 40+200,(int)( h*0.30 -25),null);
		g.drawImage(Rutinas.AjustarImagen( "src/sprite/image/robot_1.jpg", (int)( w*0.10 ), (int)( h*0.10 )).getImage(), 40+200,(int)( h*0.50 -25),null);
		g.drawImage(Rutinas.AjustarImagen( "src/sprite/image/robot_1.jpg", (int)( w*0.10 ), (int)( h*0.10 )).getImage(), 40+200,(int)( h*0.70 -25),null);
		g.drawImage(Rutinas.AjustarImagen( "src/sprite/image/robot_1.jpg", (int)( w*0.10 ), (int)( h*0.10 )).getImage(), 40+200,(int)( h*0.90 -25),null);
		
		
		g.drawImage(Rutinas.AjustarImagen( "src/sprite/image/robot_2.jpg", (int)( w*0.05 ), (int)( h*0.05 )).getImage(),(int)( w*0.25 +200),(int)( h*0.10 -25),null);
		g.drawImage(Rutinas.AjustarImagen( "src/sprite/image/robot_2.jpg", (int)( w*0.05 ), (int)( h*0.05 )).getImage(),(int)( w*0.25 +200),(int)( h*0.30 -25),null);
		g.drawImage(Rutinas.AjustarImagen( "src/sprite/image/robot_3.jpg", (int)( w*0.10 ), (int)( h*0.10 )).getImage(),(int)( w*0.25 +200),(int)( h*0.50 -25),null);
		g.drawImage(Rutinas.AjustarImagen( "src/sprite/image/robot_3.jpg", (int)( w*0.10 ), (int)( h*0.10 )).getImage(),(int)( w*0.25 +200),(int)( h*0.70 -25),null);
		
		g.drawImage(Rutinas.AjustarImagen( "src/sprite/image/robot_5.jpg", (int)( w*0.10 ), (int)( h*0.10 )).getImage(),(int)( w*0.45 +200),(int)( h*0.10 -25),null);
		g.drawImage(Rutinas.AjustarImagen( "src/sprite/image/robot_5.jpg", (int)( w*0.10 ), (int)( h*0.10 )).getImage(),(int)( w*0.45 +200),(int)( h*0.30 -25),null);
		g.drawImage(Rutinas.AjustarImagen( "src/sprite/image/robot_5.jpg", (int)( w*0.10 ), (int)( h*0.10 )).getImage(),(int)( w*0.45 +200),(int)( h*0.50 -25),null);
		
		g.drawImage(Rutinas.AjustarImagen( "src/sprite/image/robot_6.jpg", (int)( w*0.10 ), (int)( h*0.10 )).getImage(),(int)( w*0.65 +200),(int)( h*0.10 -25),null);
		g.drawImage(Rutinas.AjustarImagen( "src/sprite/image/robot_6.jpg", (int)( w*0.10 ), (int)( h*0.10 )).getImage(),(int)( w*0.65 +200),(int)( h*0.30 -25),null);
		g.drawImage(Rutinas.AjustarImagen( "src/sprite/image/robot_6.jpg", (int)( w*0.10 ), (int)( h*0.10 )).getImage(),(int)( w*0.65 +200),(int)( h*0.50 -25),null);
		
		g.drawImage(Rutinas.AjustarImagen( "src/sprite/image/robot_7.jpg", (int)( w*0.10 ), (int)( h*0.10 )).getImage(),(int)( w*0.85 +200),(int)( h*0.10 -25),null);
		g.drawImage(Rutinas.AjustarImagen( "src/sprite/image/robot_7.jpg", (int)( w*0.10 ), (int)( h*0.10 )).getImage(),(int)( w*0.85 +200),(int)( h*0.30 -25),null);
		
		g.drawImage(Rutinas.AjustarImagen( "src/sprite/image/robot_8.jpg", (int)( w*0.05 ), (int)( h*0.05 )).getImage(),(int)( w+60 +200),(int)( h*0.10 -25),null);
		g.drawImage(Rutinas.AjustarImagen( "src/sprite/image/robot_8.jpg", (int)( w*0.05 ), (int)( h*0.05 )).getImage(),(int)( w+60 +200),(int)( h*0.30 -25),null);
		g.drawImage(Rutinas.AjustarImagen( "src/sprite/image/robot_8.jpg", (int)( w*0.05 ), (int)( h*0.05 )).getImage(),(int)( w+60 +200),(int)( h*0.50 -25),null);
		g.drawImage(Rutinas.AjustarImagen( "src/sprite/image/robot_8.jpg", (int)( w*0.05 ), (int)( h*0.05 )).getImage(),(int)( w+60 +200),(int)( h*0.70 -25),null);
		g.drawImage(Rutinas.AjustarImagen( "src/sprite/image/robot_8.jpg", (int)( w*0.05 ), (int)( h*0.05 )).getImage(),(int)( w+60 +200),(int)( h*0.90 -25),null);
		
		
		
	
		
		
		
		
		
	}

	private void HazEscuchas() {
		
	}
	public static void main(String[] args) {
		new InterfazEnsambladora();

	}

}
