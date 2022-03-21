package clemente;
import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.awt.geom.*;
//import java.awt.image.*;
class Graphic2d extends JFrame  {

	Image backbuffer = null;

	private JFrame M=this;

	int i;
	public Graphic2d () {
    	setBounds(0,0,1000,700);
		setVisible(true);
		
		backbuffer = createImage(getWidth(), getHeight());
		Graphics a =backbuffer.getGraphics();

		Graphics2D g = (Graphics2D) a;

        g.drawString("texto impreso",200,200);
        g.drawLine(50,50,300,50);
		g.setColor(Color.BLUE);
        g.fillRect(50,70,100,50);

		/****************** Arcos sin Rellenos. *************************/
		// Dibujando una Elipse de Color Verde y con un grosor de seis pixeles.
		// Este Arco tiene la particularidad que es cerrado por tal motivo parecera
		//que le hace falta
		// un Pedazo al Pastel completo.
		g.setPaint(Color.GREEN);
		g.setStroke(new BasicStroke(8.0f));
		g.draw(new Arc2D.Double(200, 210, 100,50, 45, 270,Arc2D.PIE ));
		g.setPaint(Color.DARK_GRAY);
		g.drawString( " Dibujo de ARCO 2D - PASTEL " , 70, 265 );

		// color

		//Sin relleno, solo el borde de color, generando el borde
		g.setPaint(new GradientPaint( 500, 100, Color.RED , 530,150,Color.GREEN , true ));

	//	g.setPaint(Color.red);
		//linea
		g.setStroke(new BasicStroke(10)); //Grosor de 10 pixeles
		g.draw(new Line2D.Double( 30, 520, 400, 520 ));
		VE(g);
		repaint();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void VE(Graphics2D g){
		g.drawString("AAAAAAAAAAAAAAAAAAAAAAAAAAAAA",20,300);
	}
	public void paint( Graphics G)
	{	G.drawImage(backbuffer, 0, 0, getWidth(), getHeight(), this);
		G.dispose();
	}

	public static void main(String [] arg) {
		new Graphic2d();
		
	}
}