package ensambladora;

import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import HILOS.Semaforo;
import material_clase.Rutinas;


class E_VI extends JPanel implements Runnable{
  	private Semaforo s,s5,s6,r6;
  	private  sumar contProduccionI,contProduccionF;
  	private ImageIcon imgC1,imgR1;
  	private JLabel lab1,lab2;
	private int cont;
	public E_VI( Semaforo s,Semaforo s5,Semaforo s6,Semaforo  r6, sumar contProduccionF) {
		this.s=s;
		this.s5=s5;
		this.s6=s6;
		this.r6=r6;
	
		this.contProduccionF=contProduccionF;
		HazInterfaz();
	}
	public  void setCont(int cont) {

		this.cont= cont;

	}
	private void HazInterfaz() {
		this.setLayout(new GridLayout(1, 0));
		imgC1 =Rutinas.AjustarImagen( "src/sprite/image/carro_6.jpg", 25, 25) ;
		imgR1 =Rutinas.AjustarImagen( "src/sprite/image/robot_6.jpg", 25, 25) ;
		lab1= new JLabel();
		lab2= new JLabel();
		lab1.setOpaque(true);
		lab2.setOpaque(true);
	
		
		lab1.setBackground(Color.white);
		lab2.setBackground(Color.white);
		this.add(lab1);
		this.add(lab2);
		
		setVisible(true);
		
	}

	public void run() {
		while (true) {
	
			s6.Espera();
				lab1.setForeground(Color.LIGHT_GRAY);
				lab1.setIcon(imgC1); 
				lab1.setText("C#"+cont);
			s5.Libera();
			
				r6.Espera();
					lab2.setIcon(imgR1); 
					lab1.setForeground(Color.black);
					for (int i = 0; i <= 10; i++) {
						
						lab2.setText((10-i)+"s");
						try {
							Thread.sleep(800);
						} catch (InterruptedException er) {
							er.printStackTrace();
						}
						repaint();	//	update(getGraphics());
					}
					lab2.setIcon(null);
					lab2.setText("");
				r6.Libera();
	
			lab1.setText("");
			lab1.setIcon(null); 
		
			
			
		}
		
	}
}
class E_V extends JPanel implements Runnable{
  	private Semaforo s,s4,s5,s6,r5;
  	private  sumar contProduccionI;
  	private ImageIcon imgC1,imgC2,imgR1;
  	private JLabel lab1,lab2;
	private int cont,cont2;
  	private E_VI e6;
	public E_V( Semaforo s,Semaforo s4,Semaforo s5,Semaforo s6,Semaforo  r5, sumar contProduccionI,E_VI e6) {
		this.s=s;
		this.s4=s4;
		this.s5=s5;
		this.s6=s6;
		this.r5=r5;
		this.contProduccionI=contProduccionI;
		this.e6=e6;
		HazInterfaz();
	}
	public  void setCont(int cont) {
	
		this.cont= cont;
		
	}
	private void HazInterfaz() {
		this.setLayout(new GridLayout(1, 0));
		this.setBorder(new LineBorder(Color.orange));
		imgC1 =Rutinas.AjustarImagen( "src/sprite/image/carro_5.jpg", 25, 25) ;
		imgC2 =Rutinas.AjustarImagen( "src/sprite/image/carro_6.jpg", 25, 25) ;
		imgR1 =Rutinas.AjustarImagen( "src/sprite/image/robot_7.jpg", 25, 25) ;
		lab1= new JLabel();
		lab2= new JLabel();
		lab1.setOpaque(true);
		lab2.setOpaque(true);
	
	
		lab1.setBackground(Color.white);
		lab2.setBackground(Color.white);
		this.add(lab1);
		this.add(lab2);
		
		setVisible(true);
		
	}

	public void run() {
		while (true) {
			
			s5.Espera();
		
		
			
				cont2=cont;
				lab2.setForeground(Color.lightGray);
				lab2.setIcon(imgC1); 
				lab2.setText("C#"+cont);
				
			s4.Libera();
			
				r5.Espera();
	
					lab1.setIcon(imgR1); 
					lab2.setForeground(Color.black);
					for (int i = 0; i <= 2; i++) {
						
						lab1.setText((2-i)+"s");
						try {
							Thread.sleep(500);
						} catch (InterruptedException er) {
							er.printStackTrace();
						}
						repaint();//update(getGraphics());
					}
					lab2.setText("C#"+cont2+" Esperando");
					lab2.setForeground(Color.red);
					lab2.setIcon(imgC2);
					lab1.setIcon(null);
					lab1.setText("");
				r5.Libera();
				
			e6.setCont(cont2);	
			s6.Libera();
			
			s5.Espera();
			if (cont2==cont) {
				lab2.setText("");
				lab2.setIcon(null);
				update(getGraphics());
			}
			
		}
		
	}
}
class E_IV extends JPanel implements Runnable{
  	private Semaforo s,s3,s4,s5,r4;
  	private  sumar contProduccionI;
  	private ImageIcon imgC1,imgC2,imgR1;
  	private JLabel lab1,lab2;
	private int cont,cont2;
	private E_V e5;
	public E_IV( Semaforo s,Semaforo s3,Semaforo s4,Semaforo s5,Semaforo  r4, sumar contProduccionI,E_V e5) {
		this.s=s;
		this.s3=s3;
		this.s4=s4;
		this.s5=s5;
		this.r4=r4;
		this.contProduccionI=contProduccionI;
		this.e5=e5;
		HazInterfaz();
	}
	public  void setCont(int cont) {
	
		this.cont= cont;
		
	}
	private void HazInterfaz() {
	
		this.setLayout(new GridLayout(1, 0));
		imgC1 =Rutinas.AjustarImagen( "src/sprite/image/carro_4.jpg", 25, 25) ;
		imgC2 =Rutinas.AjustarImagen( "src/sprite/image/carro_5.jpg", 25, 25) ;
		imgR1 =Rutinas.AjustarImagen( "src/sprite/image/robot_4.jpg", 25, 25) ;
		lab1= new JLabel();
		lab2= new JLabel();
		lab1.setOpaque(true);
		lab2.setOpaque(true);
		
		
		lab1.setBackground(Color.white);
		lab2.setBackground(Color.white);
		this.add(lab1);
		this.add(lab2);
		
		setVisible(true);
	}

	public void run() {
		while (true) {
	
			s4.Espera();
			
			cont2=cont;
			
				lab1.setForeground(Color.lightGray);
				lab1.setIcon(imgC1); 
				lab1.setText("C#"+cont);
				
			s3.Libera();
				
				r4.Espera();
					
					lab2.setIcon(imgR1); 
					lab1.setForeground(Color.black);
					for (int i = 0; i <= 5; i++) {
						
						lab2.setText((5-i)+"s");
						try {
							Thread.sleep(300);
						} catch (InterruptedException er) {
							er.printStackTrace();
						}
						repaint();	//	update(getGraphics());
					}
					lab2.setIcon(null);
					lab2.setText("");
					
				r4.Libera();
					lab1.setText("C#"+cont2+" Esperando");
					lab1.setForeground(Color.red);
					lab1.setIcon(imgC2);
					
			e5.setCont(cont2);	
			s5.Libera();
			
			s4.Espera();
			if (cont2==cont) {
				lab1.setText("");
				lab1.setIcon(null);
				update(getGraphics());
			}
			
			

		}
		
	}
}
class E_III extends JPanel implements Runnable{
  	private Semaforo s,s2,s3,s4,r3;
  	private  sumar contProduccionI;
  	private ImageIcon imgC1,imgC2,imgR1;
  	private JLabel lab1,lab2;
	private int cont,cont2;
	private E_IV e4;
	public E_III( Semaforo s,Semaforo s2,Semaforo s3,Semaforo s4,Semaforo  r3, sumar contProduccionI,E_IV e4) {
		this.s=s;
		this.s2=s2;
		this.s3=s3;
		this.s4=s4;
		this.r3=r3;
		this.contProduccionI=contProduccionI;
		this.e4=e4;
		HazInterfaz();
	}
	public  void setCont(int cont) {
	
		this.cont= cont;
	}
	private void HazInterfaz() {
		this.setLayout(new GridLayout(1, 0));
		this.setBorder(new LineBorder(Color.orange));
		imgC1 =Rutinas.AjustarImagen( "src/sprite/image/carro_3.jpg", 25, 25) ;
		imgC2 =Rutinas.AjustarImagen( "src/sprite/image/carro_4.jpg", 25, 25) ;
		imgR1 =Rutinas.AjustarImagen( "src/sprite/image/robot_3.jpg", 25, 25) ;
		lab1= new JLabel();
		lab2= new JLabel();
		lab1.setOpaque(true);
		lab2.setOpaque(true);
	
	
		lab1.setBackground(Color.white);
		lab2.setBackground(Color.white);
		this.add(lab1);
		this.add(lab2);
		
		setVisible(true);
		
	}
	public void run() {
		while (true) {
			
			
			s3.Espera();
		
				cont2=cont;
				
				lab1.setForeground(Color.lightGray);
				lab1.setIcon(imgC1); 
				lab1.setText("C#"+cont);
				
	
			
			s2.Libera();
			
			
				r3.Espera();
					lab2.setIcon(imgR1); 
					lab1.setForeground(Color.black);
					for (int i = 0; i <= 10; i++) {
						
						lab2.setText((10-i)+"s");
						try {
							Thread.sleep(200);
						} catch (InterruptedException er) {
							er.printStackTrace();
						}
						repaint();//update(getGraphics());
					}
					lab1.setIcon(imgC2);
					
					lab2.setIcon(null);
					lab2.setText("");
					
				r3.Libera();
				
					lab1.setForeground(Color.red);
					lab1.setText("C#"+cont2+" Esperando");
					lab1.update(lab1.getGraphics());
				
				e4.setCont(cont2);	
				
			  
			s4.Libera();   
			
			s3.Espera();
			if (cont2==cont) {
				lab1.setText("");
				lab1.setIcon(null);
				
			}
	
		}
		
	}
}

class E_II extends JPanel implements Runnable{
  	private Semaforo s,s1,s2,s3,r2,r2t;
  	private  sumar contProduccionI;
  	private ImageIcon imgC2,imgC3,imgR1,imgR2;
  	private JLabel lab1,lab2,lab3;
  	private  int cont,cont2;
  	private E_III e3;
	public E_II( Semaforo s,Semaforo s1,Semaforo s2,Semaforo s3,Semaforo  r2,Semaforo  r2t, sumar contProduccionI,E_III e3) {
		this.s=s;
		this.s1=s1;
		this.s2=s2;
		this.s3=s3;
		this.r2=r2;
		this.r2t=r2t;
		this.e3=e3;
		this.contProduccionI=contProduccionI;
		HazInterfaz();
		
	}
	public  void setCont(int cont) {
		this.cont= cont;
	
	}
	private void HazInterfaz() {
		this.setLayout(new GridLayout(1, 0));
		this.setBorder(new LineBorder(Color.orange));
		imgC2 =Rutinas.AjustarImagen( "src/sprite/image/carro_2.jpg", 25, 25) ;
		imgC3 =Rutinas.AjustarImagen( "src/sprite/image/carro_3.jpg", 25, 25) ;
		
		imgR1 =Rutinas.AjustarImagen( "src/sprite/image/robot_2.jpg", 25, 25) ;
		imgR2 =Rutinas.AjustarImagen( "src/sprite/image/robot_6.jpg", 25, 25) ;
		lab1= new JLabel();
		lab2= new JLabel();
		lab3= new JLabel();
		
		lab1.setOpaque(true);
		lab2.setOpaque(true);
		lab3.setOpaque(true);
		
	
		
		lab1.setBackground(Color.white);
		lab2.setBackground(Color.white);
		lab3.setBackground(Color.white);
		this.add(lab1);
		this.add(lab2);
		this.add(lab3);
		setVisible(true);
		
	}
	public void run() {
		while (true) {

			
			s2.Espera();
			

			cont2=cont;
			
			lab2.setForeground(Color.lightGray);
			lab2.setIcon(imgC2); 
			lab2.setText("C#"+cont);	
			
				

			
			s1.Libera();
				r2.Espera();
				
					lab1.setIcon(imgR1); 
					lab2.setForeground(Color.black);
					for (int i = 0; i <= 6; i++) {
						
						lab1.setText((6-i)+"s");
						try {
							Thread.sleep(500);
						} catch (InterruptedException er) {
							er.printStackTrace();
						}
						repaint();
					}
					lab2.setIcon(imgC3); 
					lab2.setForeground(Color.orange);
					lab1.setIcon(null);
					lab1.setText("");
					
				r2.Libera();
				
				r2t.Espera();
				lab3.setIcon(imgR2); 
					for (int i = 0; i <= 4; i++) {
						
						lab3.setText((4-i)+"s");
						try {
							Thread.sleep(500);
						} catch (InterruptedException er) {
							er.printStackTrace();
						}
						repaint();
					}
					
					
				
					lab3.setIcon(null);
					lab3.setText("");
				
				r2t.Libera();
				
					lab2.setForeground(Color.red);
					lab2.setText("C#"+cont2+"Esperando");
					lab2.update(lab2.getGraphics());
					
					e3.setCont(cont2);
					
				s3.Libera(); 
				
				s2.Espera();
				
				if (cont2==cont) {
					lab2.setText("");
					lab2.setIcon(null);
				}
				

		}
		
	}
}
class E_I extends JPanel implements Runnable{
  	private Semaforo s,s1,s2,r1;
  	private sumar contProduccionI;
  	private int cont,contProduccion;
  	private ImageIcon imgC1,imgC2,imgR1;
  	private JLabel lab1,lab2;
  	private E_II e2;
  	
	public E_I( Semaforo s,Semaforo s1,Semaforo s2,Semaforo  r1,sumar contProduccionI,E_II e2) {
		this.s=s;
		this.s1=s1;
		this.s2=s2;
		this.r1=r1;
		this.contProduccionI=contProduccionI;
		this.e2=e2;
		HazInterfaz();
		
	}

	private void HazInterfaz() {
		this.setLayout(new GridLayout(1, 0,5,5));
	
		imgC1 =Rutinas.AjustarImagen( "src/sprite/image/carro_1.jpg", 25, 25) ;
		imgC2 =Rutinas.AjustarImagen( "src/sprite/image/carro_2.jpg", 25, 25) ;
		imgR1 =Rutinas.AjustarImagen( "src/sprite/image/robot_1.jpg", 25, 25) ;
		lab1= new JLabel();
		lab2= new JLabel();
		lab1.setOpaque(true);
		lab2.setOpaque(true);
		
		 
		lab1.setBackground(Color.white);
		lab2.setBackground(Color.white);
		this.add(lab1);
		this.add(lab2);
		
		setVisible(true);
	}
	public void run() {
		while (true) {

			s.Espera();
            if(contProduccion>=1000) {
            	s.Libera();
            	return;
            }
			s1.Espera();
			lab1.setForeground(Color.LIGHT_GRAY);
		
			lab1.setText("");
			lab1.setIcon(null);
			cont=	contProduccionI.IncA();
		
				lab1.setIcon(imgC1); 
				lab1.setText("C#"+cont);
			r1.Espera();
				lab2.setIcon(imgR1);
				lab1.setForeground(Color.black);
						for (int i = 0; i <= 20; i++) {
								
								lab2.setText((20-i)+"s");
								try {
									Thread.sleep(100);
								} catch (InterruptedException er) {
									er.printStackTrace();
								}
								repaint();
							}
						lab1.setIcon(imgC2);
					
						lab2.setText("");
						lab2.setIcon(null);			
				r1.Libera();
				
						lab1.setText("C#"+cont+" Esperando");
						lab1.setForeground(Color.red);
						
				
						e2.setCont(cont);
						s2.Libera();	           
			
		}
		
	}
}
 class L extends JPanel{
	 private Semaforo s,s1,s2,s3,s4,s5,s6;
	private E_I e1;
	private E_II e2;
	private E_III e3;
	private E_IV e4;
	private E_V e5;
	private E_VI e6;
	
	
	static Semaforo r1,r2,r2t,r3,r4,r5,r6,ss;
	static sumar contProduccionI;
	
	public L()  {
	
			s1=new Semaforo(1);
			s2=new Semaforo(0);
			s3=new Semaforo(0);
			s4=new Semaforo(0);
			s5=new Semaforo(0);
			s6=new Semaforo(0);	
			s=new Semaforo(1);
			
		if(r1==null) {
			

			
			r1=new Semaforo(5);
			r2=new Semaforo(4);
			r2t=new Semaforo(2);
			r3=new Semaforo(3);
			r4=new Semaforo(3);
			r5=new Semaforo(2);
			r6=new Semaforo(5);
			ss=new Semaforo(1);
			
			contProduccionI = new sumar (ss);
		
			
		
			
		}
		HazInterfaz();
	}


	private void HazInterfaz() {
		
		
		e6=new E_VI (s, s5, s6, r6, contProduccionI);
		e5=new E_V  (s, s4, s5, s6, r5, contProduccionI,e6);
		e4=new E_IV (s, s3, s4, s5, r4, contProduccionI,e5);
		e3=new E_III(s, s2, s3, s4, r3, contProduccionI,e4);
		e2=new E_II (s, s1, s2, s3, r2,r2t, contProduccionI,e3);
		e1=new E_I  (s, s1, s2, r1, contProduccionI,e2);
		
		
		
		this.setLayout(new GridLayout(1, 0));
		this.setBackground(Color.white);
		this.add(e1);
		this.add(e2);
		this.add(e3);
		this.add(e4);
		this.add(e5);
		this.add(e6);
		
		
		Thread h1=new Thread(e1);
		Thread h2=new Thread(e2);
		Thread h3=new Thread(e3);
		Thread h4=new Thread(e4);
		Thread h5=new Thread(e5);
		Thread h6=new Thread(e6);
		
		h1.start();
		h2.start();
		h3.start();
		h4.start();
		h5.start();
		h6.start();
		
		setVisible(true);
	}

}
class sumar {
	Semaforo s;
	int contProduccionI=0;
	
	public sumar(Semaforo s) {
	this.s=s;	
	
	}
	public int IncA(){

		s.Espera();
	contProduccionI++;
	if (contProduccionI<1000) {
		
		s.Libera();
		return contProduccionI;	
	}
		
	return contProduccionI;
		
	}
	public  int getSuma() {
		return contProduccionI;
	}
	
}
public class InterfazEnsambladora2 extends JFrame{
	private int Nlineas;
	private JPanel P1,P2;

	
	
	public InterfazEnsambladora2 () {
		
		super("Simulador Esambladora: NISSON");
		Nlineas=15;//8 a 15
		HazInterfaz();
		
		
	}
	
	
	
		private void HazInterfaz() {
				
			
				setSize(626*4,248*2);
				setLocationRelativeTo(null);
			
				
				 P1 = new JPanel();
				 P2 = new JPanel();
			
				 
				 P1.setLayout(new GridLayout(0, 1, 5, 5));
				 P2.setLayout(new GridLayout(1, 0, 10, 10));
				 
				 P1.setBackground(Color.black);
				 P2.setBackground(Color.orange);
				 
				 
				 add(P1, BorderLayout.CENTER);
				 add(P2, BorderLayout.NORTH);
				 
				 
				 
					P2.add( new JLabel("1. Chasis y cableado"));
					P2.add( new JLabel("2. Motor-transmisión"));
					P2.add( new JLabel("3. Carrocería"));
					P2.add( new JLabel("4. Interiores"));
					P2.add( new JLabel("5. Llantas"));
					P2.add( new JLabel("6. Pruebas"));
					
				
				
				
				for (int i = 0; i < Nlineas; i++) {
					P1.add(new L());
			
				}
				setVisible(true);
				Image icon = new ImageIcon(getClass().getResource("NISSON.png")).getImage();
				setIconImage(icon);

		}
	public static void main(String[] args) {
		new InterfazEnsambladora2();

	}
}
