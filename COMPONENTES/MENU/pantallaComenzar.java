package Menu;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;





public class pantallaComenzar extends JPanel implements ActionListener, ComponentListener{
	private Image backbuffer = null;
	private int w, h;
	private  ImageIcon ii;
	private  Timer T,T2;
	private boolean band,band2;
	private  Font fuente;
	private  int count;
	private String texto;
	
	public pantallaComenzar () {
		
		 fuente = new Font("Monospaced", Font.BOLD, 20);
		hazinterfaz();
		count=0;
		band=band2=false;
		T = new Timer(900, this);
		texto="      ESCALADORES         ";
		T.start();
		T2 = new Timer(500, this);
		T.setRepeats(true);
		T2.start();
		
	}
	
	
	
	
	
	private void hazinterfaz() {
			setLayout(null);
			setSize(1600,840);
			w = getWidth();
			h = getHeight();
		
			fondo();	
	}


	
	private void fondo() {
	    ii = loadImage();
		backbuffer = ii.getImage();
	
	}

	  private ImageIcon loadImage() {
		  w = getWidth();
		  h = getHeight();
	        return componentes.Rutinas.AjustarImagen("src/sprite/fondo_inicio3.jpg",w, h);
	    }

	  public void paintComponent(Graphics g) {		
			Dibuja(g);
			
		}
	private void Dibuja(Graphics g) {
		
	 
		g.drawImage( 	backbuffer, 0, 0, null);
		g.setColor(Color.white);
		
		g.setFont(fuente);
		
		g.drawString("author:  @Landeros ", w-300, h-30);
		g.drawString("version: 1.1 ", 25, h-30);
		
		if(band) {
		g.drawString(" click para comenzar ", (w/2)-120,h-50);
		}
		
		g.setFont(new Font("Monospaced", Font.BOLD, 200));
		g.setColor(band2 ? Color.pink : Color.white);
		g.drawString(texto,0,h/2);
		
	}





	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == T) {
			band = !band;
			repaint();
			return;
		}
		if (e.getSource() == T2) {

			texto = texto.substring(1) + texto.charAt(0);

			repaint();
			if (T2.isRepeats()) {
				count++;

			}
			if (count == 20) {

				band2 = !band2;
				count = 0;
				repaint();
			}

			return;
		}

	}




	
	@Override
	public void componentResized(ComponentEvent e) {
		 w = getWidth();
		 h = getHeight();
			
		// ii = loadImage();
		// label = new JLabel(ii);
		// label.setSize(w,h);
		 //add(label);
		  revalidate();
		// setPreferredSize(new Dimension(w, h));
		 fondo();
		
		 repaint();
	}





	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
