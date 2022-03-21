	package componentes;
	
	import java.awt.Canvas;
	import java.awt.Graphics;
	import java.awt.Image;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.ComponentEvent;
	import java.awt.event.ComponentListener;
	
	import javax.swing.Timer;
	
	public class hannoiCanvas extends Canvas implements ActionListener, ComponentListener {
	
		private Graphics g;
		private Image backbuffer;
		private int w, h, discos;
		private Timer T;
	
		public void run() {
			if (!T.isRunning()) {
				// reset();
			}
			T.start();
		}
	
		public hannoiCanvas(int discos) {
			this.discos = discos;
			
			HazInterfaz();
			HazEscuchas();
			g = null;
	
		}
	
		public void HazInterfaz() {
			w = getWidth();
			h = getHeight();
			// setLayout(null);
			setSize(100, 100);
			// setBorder(new LineBorder(Color.yellow));
		
			// this.setPreferredSize(new Dimension(w, h));
			 update( g);
		
		}
	
		public void paint(Graphics g) {
			System.out.println("entre");
			if (g == null) {
				w = getWidth();
				h = getHeight();
				System.out.println(w + "  " + h);
				this.backbuffer = createImage(w, h);
				System.out.println(backbuffer);
				this.g = this.backbuffer.getGraphics();
	
				// return;
			}
	
			// super.paint(this.g);
			Dibuja();
			this.g.drawImage(backbuffer, 0, 0, this.getWidth(), this.getHeight(), this);
	
			g.drawString("ya sirve", 5, 5);
			repaint();
			setVisible(true);
		}
	
		private void Dibuja() {
			super.paint(g);
	
			g.drawString("ya sirve", 10, 10);
	
			// repaint();
		}
	
		public void update(Graphics g) {
		//	System.out.println("entre al update");
			paint(g);
		}
	
		private void HazEscuchas() {
			this.addComponentListener(this);
			// T.addActionListener(this);
		}
	
		@Override
		public void componentResized(ComponentEvent e) {
			w = getWidth();
			h = getHeight();
			// paint(g);
			// System.out.println(w + " " + h);
			// System.out.println(this);
			// repaint();
	
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
	
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == T) {
	
				return;
			}
	
		}
	}
	

