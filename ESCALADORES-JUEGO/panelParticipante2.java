package Escalador;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

/*
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
}*/
class myCIELO extends Canvas implements ActionListener{
	private String nomImagen;
	Timer T;
	int sub;
	String [] imagenes= {"cielo1.png","cielo2.png","cielo3.png","cielo4.png"};
	public myCIELO() {
		this.setSize(560, 840);
		sub=0;
		this.nomImagen=nomImagen;
		T=new Timer(1000,this);
		T.start();
	}
	public void paint( Graphics g) 	{
		
	//	g.drawImage(Rutinas.AjustarImagen(nomImagen, this.getWidth(), this.getHeight()).getImage(), 0, 0,null);
		//g.drawString("EJEMPLO DEL LLIENZO EN CANVAS", 20, 20);
	//	g.drawImage(Rutinas.AjustarImagen("CABALLO.JPG", 50,50).getImage(), 0, this.getHeight()-55,null);
	}
	
	public void actionPerformed(ActionEvent e) {

		nomImagen=imagenes[sub % imagenes.length];
		repaint();
		sub++;
	}	
	
	
}
public class panelParticipante2 extends JPanel  {
	int x,y,w,h;
	//JTextField [] vc;
	myCIELO C5;
	
	
	
	
	int inc,incPlayer;
	Timer T,TPlayer;
	
	
	Graphics g;
	Image backbuffer = null;	
	
	public panelParticipante2(){
		
		/*
		TPlayer=new Timer(200,this);
		TPlayer.start();
		*/
	
		HazInterfaz();
		HazEscuchas();
		
		backbuffer = createImage(getWidth(), getHeight());
	//	g = backbuffer.getGraphics();
		//g = backbuffer.paintComponent(...)
		
	}
	private void HazInterfaz(){
		//setLayout(null);
	//	this.setPreferredSize(new Dimension(560, 840));
		this.setSize(560, 840);

		
		
		
		
	//	this.setBorder(new LineBorder(Color.blue));
		//vc=new JTextField[2];
	//	w = getWidth();
	//	h = getHeight();
//			for(int i=0 ; i< vc.length; i++)
//			vc[i]=new JTextField();
//			vc[i].setSize(w-20,20);
//			vc[i].setLocation(10,5+i*20);
//			add(vc[i]);
		
		/*
		C5 = new myCIELO();
		
		add(C5);
		*/
		this.setVisible(true);
		
		
	}
	private void HazEscuchas(){
		//this.addComponentListener(this);
	}
	
	
	public void paint( Graphics g) 	{

		Dibuja();
		g.drawImage(backbuffer, 0, 0, getWidth(), getHeight(), this);	
	}
	private void Dibuja() {
		if(g==null)
			return;
		super.paint(g);
		
		
		
		g.drawString("INSTITUTO TECNOLÓGICO DE CULIACÁN",50,40);
		g.drawLine(20,45,300,45);
		g.drawString("INGENIERÍA EN SISTEMAS COMPUTACIONALES",50,60);
		MetodoPintura(g);
		}
	
	
	
	private void MetodoPintura(Graphics grafico) {
		grafico.setColor(Color.RED);
		grafico.drawString("estoy en un método ",500,300);
	}


}
