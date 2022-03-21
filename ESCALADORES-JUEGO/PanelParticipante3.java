package Escalador;

	import javax.swing.JPanel;
import javax.swing.Timer;

import componentes.Rutinas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
	import java.awt.Graphics;
	import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;
	public class PanelParticipante3 extends JPanel implements ActionListener, MouseListener {
		JButton btnNorte,btnContinuo;
		int inc,incAvion;
		boolean band=true;
		boolean bandAvion=true;
		Timer T,Tavion;
		int subAvion=0;
		Box vertical;
		JButton btnTriangulo,btnCirculo,btnRectangulo,btnPoligono;
		String [] nomAvion= {"avion.jpg","avionRegreso.jpg"};
		boolean [] vb;

		Graphics g;
		Image backbuffer = null;	
	

	    public PanelParticipante3() {
	    	incAvion=inc=0;
			T=new Timer(500,this);
			Tavion=new Timer(200,this);
			Tavion.start();
			//Tavion.setRepeats(true);
			HazInterfaz();
			HazEscuchas();
			
			backbuffer = createImage(getWidth(), getHeight());
			g =backbuffer.getGraphics();

			
			vb=new boolean[4];
			Arrays.fill(vb, false);
	        
	    }


		private void HazEscuchas() {
			btnNorte.addActionListener(this);
			btnContinuo.addActionListener(this);
			btnTriangulo.addMouseListener(this);
			btnPoligono.addMouseListener(this);
			btnCirculo.addMouseListener(this);
			btnRectangulo.addMouseListener(this);
		}


		private void HazInterfaz() {
			setSize(600,400);
			//setLocationRelativeTo(null);
			btnNorte=new JButton("Avanza");
			add(btnNorte,BorderLayout.SOUTH);
			btnContinuo=new JButton("Movimiento continuo");
			add(btnContinuo,BorderLayout.NORTH)	;	
			this.setVisible(true);
		//	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			vertical=Box.createVerticalBox();
			btnTriangulo=new JButton("Triangulo  ");
			btnCirculo=new JButton(  "Circulo    ");
			btnRectangulo=new JButton("Rectangulo");
		    btnPoligono=new JButton( "Poligono   ");
		    vertical.add(btnTriangulo);
		    vertical.add(btnCirculo);
		    vertical.add(btnRectangulo);
		    vertical.add(btnPoligono);
			add(vertical,BorderLayout.EAST);
			
			btnCirculo.grabFocus();
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
			g.setColor(Color.BLUE);
			g.fillRect(50,70,100,50);
			g.fillRoundRect(250, 70,100, 50, 20, 20);
			Color CAFE=new Color(192,128,64);
			g.setColor(CAFE);
			g.fillRect(50+inc,150,200,100);
			g.setColor(Color.RED);
			g.fillOval(60+inc,220,60,60);
			g.fillOval(190+inc,220,50,60);
			g.setColor(Color.WHITE);
	        g.fillRect(200+inc,160,50,30);
	        
			g.setColor(Color.orange);
			g.drawLine(50, 300, 390, 300);
			g.drawImage(Rutinas.AjustarImagen(nomAvion[subAvion], 100, 60).getImage(), incAvion+10, 300,null);
			g.setColor(Color.BLUE);
			if(vb[0]) {
			   g.drawLine( 500,100,400,200);
			   g.drawLine( 500,100,600,200);
			   g.drawLine( 400,200,600,200);
			}
			if(vb[1]) {
				g.fillOval(300, 300, 100, 100);			
			}
			if(vb[2]) {
				g.fillRect(450,200,50,50);
			}
			if(vb[3]) {
				g.setColor(Color.RED);
				//int [] VX={150,200,300,50};
				//int [] VY={400,400,500,500};
				
				int [] VX= {500,400,600};
				int [] VY= {100,200,200};
				
				g.fillPolygon(VX, VY, VX.length);
				
					
				
			}
			MetodoPintura(g);
		
		}
		private void MetodoPintura(Graphics grafico) {
			grafico.setColor(Color.RED);
			grafico.drawString("estoy en un método ",500,300);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}    
	    