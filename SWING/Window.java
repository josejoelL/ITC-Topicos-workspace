package tarea;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.Random;

//Yosemit Salvador RodrÃ­guez LÃ³pez
//TÃ³picos avanzados de programacÃ³n 8:00 - 9:00

public class Window extends JFrame implements ActionListener{
	
	JButton [][] caracol;
	JButton extIZQ, extDCA, cntIZQ, cntDCA, limpiar;
	int N;
	
	public Window() {
				
		N = new Random().nextInt(6)+4;
		caracol = new JButton[N][N];
		
		Interfaz();
		Listener();
	

		
	}
	
	public void Interfaz() {
		
		setTitle("Caracol");
		setSize(500,500);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setLayout(new GridLayout(0,N,5,10));
		

		
		for(int i = 0; i < N; i++) 
			for(int j = 0; j < N; j++) 
				caracol[i][j] = new JButton();
		
		for(int i = 0; i < N; i++) 
			for(int j = 0; j < N; j++) 
				add(caracol[i][j]);
		
		add(extIZQ = new JButton("ext Izquierda"));
		add(extDCA = new JButton("ext Derecha"));
		add(cntIZQ = new JButton("cntr Izquierda"));
		add(cntDCA = new JButton("cntr Derecha"));
		
		add(limpiar = new JButton("Clean"));
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void Listener() {
		
		extIZQ.addActionListener(this);
		limpiar.addActionListener(this);
		extDCA.addActionListener(this);
		cntIZQ.addActionListener(this);
		cntDCA.addActionListener(this);
		
		
	}

	public static void main(String args[]) {
		new Window();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == extIZQ) {
		
			izquierda();
			
		}
		
		if(e.getSource() == extDCA) {
			
			derecha();
			
		}
		
		if(e.getSource() == cntIZQ) {
			
			ctrIzquierda();
			
		}
		
		if(e.getSource() == cntDCA) {
			
			ctrDerecha();
			
		}
		
		if(e.getSource() == limpiar) {
			
			clean();
			
		}
		
		
	}
	
	
	public void izquierda() {

		int a = 0;
		int b = N-1;
		int count = 1;
		int j = 0;

		
		while (j < caracol.length) {

			for (int i = a; i <= b; i++) {
				
				caracol[b][i].setText("" + count);
				caracol[b][i].setBackground(new Color(new Random().nextInt(2147483647)));
				caracol[b][i].update(caracol[b][i].getGraphics());
				count++;
				try {
					Thread.sleep(200);
				} catch(InterruptedException e) {
				}
			
			}
		

			for (int i = b - 1; i >= a; i--) {
				caracol[i][b].setText("" + count);
				caracol[i][b].setBackground(new Color(new Random().nextInt(2147483647)));
				caracol[i][b].update(caracol[i][b].getGraphics());
				count++;
				try {
					Thread.sleep(200);
				} catch(InterruptedException e) {
				}
				
			}

			for (int i = b - 1; i >= a; i--) {
				caracol[a][i].setText("" + count);
				caracol[a][i].setBackground(new Color(new Random().nextInt(2147483647)));
				caracol[a][i].update(caracol[a][i].getGraphics());
				count++;
				try {
					Thread.sleep(200);
				} catch(InterruptedException e) {
				}
				
			}

			for (int i = a + 1; i <= b - 1; i++) {
				caracol[i][a].setText("" + count);
				caracol[i][a].setBackground(new Color(new Random().nextInt(2147483647)));
				caracol[i][a].update(caracol[i][a].getGraphics());
				count++;
				try {
					Thread.sleep(200);
				} catch(InterruptedException e) {
				}
				
			}

			a++;
			b--;

			j++;
			
		}

	}

	public void derecha() {

		int a = 0;
		int b = N-1;
		int count = 1;
		int j = 0;

		while (j < caracol.length) {

				
			for (int i = a; i <= b; i++) {
				caracol[a][i].setText("" + count);
				caracol[a][i].setBackground(new Color(new Random().nextInt(2147483647)));
				caracol[a][i].update(caracol[a][i].getGraphics());
				count++;
				try {
					Thread.sleep(200);
				} catch(InterruptedException e) {
				}
			}

			for (int i = a + 1; i <= b; i++) {
				caracol[i][b].setText("" + count);
				caracol[i][b].setBackground(new Color(new Random().nextInt(2147483647)));
				caracol[i][b].update(caracol[i][b].getGraphics());
				count++;
				try {
					Thread.sleep(200);
				} catch(InterruptedException e) {
				}
			}

			for (int i = b - 1; i >= a; i--) {
				caracol[b][i].setText("" + count);
				caracol[b][i].setBackground(new Color(new Random().nextInt(2147483647)));
				caracol[b][i].update(caracol[b][i].getGraphics());
				count++;
				try {
					Thread.sleep(200);
				} catch(InterruptedException e) {
				}
			}

			for (int i = b - 1; i >= a + 1; i--) {
				caracol[i][a].setText("" + count);
				caracol[i][a].setBackground(new Color(new Random().nextInt(2147483647)));
				caracol[i][a].update(caracol[i][a].getGraphics());
				count++;
				try {
					Thread.sleep(200);
				} catch(InterruptedException e) {
				}
			}

			a++;
			b--;

			j++;
			

		}
		
	}
	
	public void clean() {
		
		for(int i = 0; i < N; i++) 
			for(int j = 0; j < N; j++) {
				caracol[i][j].setText("");
				caracol[i][j].setBackground(null);
			}
	}
	
	public void ctrDerecha() {
	
		if(N %2 == 0) {
			
			int a = (N/2) - 1;
			int b = (N/2);
			int count = 1;
			int j = 0;
			
			while(j < caracol.length) {
				for (int i = a; i <= b; i++) { 			// â†’ â†’ â†’
					caracol[b][i].setText("" + count);
					caracol[b][i].setBackground(new Color(new Random().nextInt(2147483647)));
					caracol[b][i].update(caracol[b][i].getGraphics());
					count++;
					try {
						Thread.sleep(200);
					} catch(InterruptedException e) {
					}
				}

				for (int i = b - 1; i >= a; i--) { 		// â†‘ â†‘ â†‘
					caracol[i][b].setText("" + count);
					caracol[i][b].setBackground(new Color(new Random().nextInt(2147483647)));
					caracol[i][b].update(caracol[i][b].getGraphics());
					count++;
					try {
						Thread.sleep(200);
					} catch(InterruptedException e) {
					}
				}

				for (int i = b - 1; i >= a; i--) { 		// â†� â†� â†�
					caracol[a][i].setText("" + count);
					caracol[a][i].setBackground(new Color(new Random().nextInt(2147483647)));
					caracol[a][i].update(caracol[a][i].getGraphics());
					count++;
					try {
						Thread.sleep(200);
					} catch(InterruptedException e) {
					}
				}

				a--;
				b++;
				
				if(a < 0 || b > caracol.length) {
					break;
				}
				
				for (int i = a + 1; i <= b - 1; i++) { 	// â†“ â†“ â†“
					caracol[i][a].setText("" + count);
					caracol[i][a].setBackground(new Color(new Random().nextInt(2147483647)));
					caracol[i][a].update(caracol[i][a].getGraphics());
					count++;
					try {
						Thread.sleep(200);
					} catch(InterruptedException e) {
					}
				}
				
				j++;
			}

			
		} else {
			
			int a = (N/2)   ;
			int b = (N/2)   ;
			int count = 1;
			int j = 0;
			
			while(j < caracol.length) {
			
			for (int i = a; i <= b; i++) { 			// â†’ â†’ â†’
				caracol[b][i].setText("" + count);
				caracol[b][i].setBackground(new Color(new Random().nextInt(2147483647)));
				caracol[b][i].update(caracol[b][i].getGraphics());
				count++;
				try {
					Thread.sleep(200);
				} catch(InterruptedException e) {
				}
			}
			
			a--;
			b++;
			
			if(a < 0 || b > caracol.length) {
				break;
			}
			
			
			for (int i = b - 1; i >= a; i--) { 		// â†‘ â†‘ â†‘
				caracol[i][b].setText("" + count);
				caracol[i][b].setBackground(new Color(new Random().nextInt(2147483647)));
				caracol[i][b].update(caracol[i][b].getGraphics());
				count++;
				try {
					Thread.sleep(200);
				} catch(InterruptedException e) {
				}
			}
			
			
			for (int i = b - 1; i >= a; i--) { 		// â†� â†� â†�
				caracol[a][i].setText("" + count);
				caracol[a][i].setBackground(new Color(new Random().nextInt(2147483647)));
				caracol[a][i].update(caracol[a][i].getGraphics());
				count++;
				try {
					Thread.sleep(200);
				} catch(InterruptedException e) {
				}
			}
			
			
			
			for (int i = a + 1; i <= b - 1; i++) { 	// â†“ â†“ â†“
				caracol[i][a].setText("" + count);
				caracol[i][a].setBackground(new Color(new Random().nextInt(2147483647)));
				caracol[i][a].update(caracol[i][a].getGraphics());
				count++;
				try {
					Thread.sleep(200);
				} catch(InterruptedException e) {
				}
				}
			
			j++;
			
			}
			
		}
	
	}
	
	
	public void ctrIzquierda() {
		
		if(N %2 == 0) {
			
			int a = (N/2) - 1;
			int b = (N/2);
			int count = 1;
			int j = 0;
			
			while(j < caracol.length) {
				
				for (int i = a; i <= b; i++) { 			// â†’ â†’ â†’
					caracol[a][i].setText("" + count);
					caracol[a][i].setBackground(new Color(new Random().nextInt(2147483647)));
					caracol[a][i].update(caracol[a][i].getGraphics());
					count++;
					try {
						Thread.sleep(200);
					} catch(InterruptedException e) {
					}
				}

				for (int i = a + 1; i <= b; i++) { 		// â†“ â†“ â†“
					
					caracol[i][b].setText("" + count);
					caracol[i][b].setBackground(new Color(new Random().nextInt(2147483647)));
					caracol[i][b].update(caracol[i][b].getGraphics());
					count++;
					try {
						Thread.sleep(200);
					} catch(InterruptedException e) {
					}
				}

				for (int i = b - 1; i >= a; i--) { 		// â†� â†� â†�
					caracol[b][i].setText("" + count);
					caracol[b][i].setBackground(new Color(new Random().nextInt(2147483647)));
					caracol[b][i].update(caracol[b][i].getGraphics());
					count++;
					try {
						Thread.sleep(200);
					} catch(InterruptedException e) {
					}
				}


				a--;
				b++;
				
				if(a < 0 || b > caracol.length) {
					break;
				}
				
				for (int i = b - 1; i >= a + 1; i--) { 	// â†‘ â†‘ â†‘
					caracol[i][a].setText("" + count);
					caracol[i][a].setBackground(new Color(new Random().nextInt(2147483647)));
					caracol[i][a].update(caracol[i][a].getGraphics());
					count++;
					try {
						Thread.sleep(200);
					} catch(InterruptedException e) {
					};
				}
				
				j++;
			}

			
		} else {
			
			int a = (N / 2);
			int b = (N / 2);
			int count = 1;
			int j = 0;

			while (j < caracol.length) {

				for (int i = a; i <= b; i++) { // â†’ â†’ â†’
					caracol[a][i].setText("" + count);
					caracol[a][i].setBackground(new Color(new Random().nextInt(2147483647)));
					caracol[a][i].update(caracol[a][i].getGraphics());
					count++;
					try {
						Thread.sleep(200);
					} catch(InterruptedException e) {
					}
				}

				a--;
				b++;

				if (a < 0 || b > caracol.length) {
					break;
				}

				for (int i = a + 1; i <= b; i++) { // â†“ â†“ â†“
					caracol[i][b].setText("" + count);
					caracol[i][b].setBackground(new Color(new Random().nextInt(2147483647)));
					caracol[i][b].update(caracol[i][b].getGraphics());
					count++;
					try {
						Thread.sleep(200);
					} catch(InterruptedException e) {
					}
				}

				for (int i = b - 1; i >= a; i--) { // â†� â†� â†�
					caracol[b][i].setText("" + count);
					caracol[b][i].setBackground(new Color(new Random().nextInt(2147483647)));
					caracol[b][i].update(caracol[b][i].getGraphics());
					count++;
					try {
						Thread.sleep(200);
					} catch(InterruptedException e) {
					}
				}

				for (int i = b - 1; i >= a + 1; i--) { // â†‘ â†‘ â†‘
					caracol[i][a].setText("" + count);
					caracol[i][a].setBackground(new Color(new Random().nextInt(2147483647)));
					caracol[i][a].update(caracol[i][a].getGraphics());
					count++;
					try {
						Thread.sleep(200);
					} catch(InterruptedException e) {
					}
				}

				j++;

			}

		}
	
	}
	
}
