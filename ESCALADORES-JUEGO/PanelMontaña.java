package Escalador;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

import componentes.meta;
import material_clase.Rutinas;

public class PanelMontaña extends JPanel implements ActionListener,ComponentListener {

	private Image backbuffer = null;
	private int w, h, index,x,y;
	private int cmAcendidos,cm;
	private boolean band,caer;
	private meta S;
	private Color random;
	private String Pais;
	private Timer T;
	private  Font fuente;
	
	public void run() {
		if (!T.isRunning()) {
			cmAcendidos = 740;
			caer=band=false;
			this.setBorder(null);
			S.setHayGanador();		
			random=componentes.Rutinas.nextColor();
		}
		T.start();
	}

	public PanelMontaña(int index, meta S) {
		this.index = index;
		this.S = S;
		hazinterfaz();
		cmAcendidos = 740;
		band = false;
		w = backbuffer.getWidth(this);
		h = backbuffer.getHeight(this);
		T = new Timer(500, this);
		random = Color.green;
		Pais = componentes.Rutinas.nextPais();
		fuente = new Font("Monospaced", Font.BOLD, 15);

	}

	private void hazinterfaz() {
		setLayout(null);
		this.setSize(100,100);
		fondo();
		setPreferredSize(new Dimension(w, h));
		
	}

	private void fondo() {
		ImageIcon ii = loadImage();
		backbuffer = ii.getImage();
	}

	private ImageIcon loadImage() {
		Random R = new Random();
		int f=R.nextInt(6);
		return componentes.Rutinas.AjustarImagen("src/sprite/fondo/fondo_inicio"+f+".jpg", 560+200, 840);
	}

	@Override
	public void paintComponent(Graphics g) {
	//	super.paintComponent(g);	
		g.drawImage(backbuffer, 0, 0, null);
		Dibuja(g);
		
	}

	private void Dibuja(Graphics g) {

		DibujaPanel  (g);
		DibujaJugador(g);
		DibujaGanador(g);
		DibujaPuntaje(g);

	}

	private void DibujaPanel(Graphics g) {
		g.drawImage(Rutinas.AjustarImagen("src/sprite/montaña.png", 500, 1000).getImage(), 0, 0, null);
		g.setColor(Color.green);
		g.drawLine(0, 50, 100, 50);
		g.drawString("Mts. 7.50 ", 110, 50);
		g.setColor(!band ? Color.white : Color.yellow);
		g.drawString(" Escalador #: " + index, 5, 777);
		g.drawString(" cm Escalados : " + (getHeight() - cmAcendidos - 54), 5, 790);
		
	}

	private void DibujaJugador(Graphics g) {
		g.setColor(random);
		
		g.drawString("<" + Pais + ">", 55, cmAcendidos - 2);

		if ((cmAcendidos == 740)) {
			g.drawImage(Rutinas.AjustarImagen("src/sprite/player/mono00.png", 60, 70).getImage(), 50, cmAcendidos,
					null);

		}
		if (!(cmAcendidos == 740)) {
			g.drawImage(Rutinas
					.AjustarImagen(caer ? "src/sprite/monoCaida.png"
							: "src/sprite/player/mono0" + (cmAcendidos % 2 == 0 ? "1" : "2") + ".png", 50, 50)
					.getImage(), 50, cmAcendidos, null);

		}
		
	}

	private void DibujaPuntaje(Graphics g) {
		
			g.setColor(!caer ? Color.white : Color.red);
			g.setFont(fuente);
		
			if (!(cmAcendidos == 740)) {

			if (cm > 40) {
				g.setFont(new Font("Monospaced", Font.BOLD, 18));
				g.setColor(Color.yellow);
				g.drawString(caer ? "" + cm : "+" + cm, 100, cmAcendidos + 25);
			} else

				g.drawString(caer ? "" + cm : "+" + cm, 100, cmAcendidos + 25);

		}
		
	}
		
	

	private void DibujaGanador(Graphics g) {
		if (band) {
			g.setFont(fuente);
			g.drawString("  ganador :", 5, 33);
			g.drawString("   " + Pais, 0, 45);

		}
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == T) {
			if (cmAcendidos <= 0) {
				T.stop();
				if (S.cruzarMeta()) {

					band = true;
					repaint();
					this.setBorder(new LineBorder(Color.yellow));

				}
				return;
			} else {

				cm = getAzar();
				cmAcendidos -= cm;
				repaint();
				return;

			}
		}

	}

	private int getAzar() {
		Random R = new Random();
		int resIntento;
		resIntento = R.nextInt(10);
		
		if (resIntento == 0) {
			caer=true;
			return (-1) * (R.nextInt(20) + 10);
		}
		caer=false;
		return R.nextInt(30) + 20;
	}
	
	
	public void componentResized(ComponentEvent e) {
		
	}
	public void componentMoved(ComponentEvent e) {
		x = getX();
		y = getY();
		cmAcendidos = y;
		
		
	}
	public void componentShown(ComponentEvent e) {
		
	}	
	public void componentHidden(ComponentEvent e) {
		
	}

}