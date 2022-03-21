package componentes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

public class hanoiCanvas extends JPanel implements ActionListener,ComponentListener {
	private Image backbuffer = null;
	
	private int w, h,discos;
	private Timer T;
	public hanoiCanvas(int discos) {
		this.discos = discos;
		T = new Timer(500, this);
		w = getWidth();
		h = getHeight();
		HazInterfaz();
		HazEscuchas();
		
	}
	private void HazEscuchas() {
		this.addComponentListener( this);
		
	}
	private void HazInterfaz() {
		// TODO Auto-generated method stub
		setLayout(null);
		this.setSize(100,100);
		fondo();
		
	//	setPreferredSize(new Dimension(w, h));
		this.setBorder(new LineBorder(Color.yellow));
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);	
	
		g.drawImage(backbuffer, 0, 0, null);
		Dibuja(g);
		
	}
	private void Dibuja(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.green);
		g.drawLine(0, 50, 100, 50);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	
	}
	private void fondo() {
		System.out.println("si estoy haciendo los deberes");
		ImageIcon ii = loadImage();
		backbuffer = ii.getImage();
		
	}
	private ImageIcon loadImage() {
		// TODO Auto-generated method stub
		return componentes.Rutinas.AjustarImagen("src/sprite/tablero.png", 100, 200);
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
