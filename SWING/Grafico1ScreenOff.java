package clemente;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Grafico1ScreenOff extends JFrame implements ActionListener,MouseListener{
	JButton BtnAvanzar;
	JButton [] Figuras;
	boolean [] VBand;
	int Posiciones;
	boolean Band;
	Timer T;
	
	Graphics g;
	Image backbuffer = null;
	
	public Grafico1ScreenOff(){
		super("Gráficos en java");
		Posiciones=0;
		Band=false;
		T=new Timer(200,this);
		
		
		HazInterfaz();
		
	backbuffer = createImage(getWidth(), getHeight());
		
		
		System.out.println(backbuffer);
		g =backbuffer.getGraphics();

		HazEscuchas();
		
		T.start();
		
	}
	private void HazInterfaz(){
		setSize(600,400);
		setLocationRelativeTo(null);
		BtnAvanzar=new JButton("Avanzar");
		
		add(BtnAvanzar,BorderLayout.SOUTH);
		JPanel PWEST=new JPanel(new GridLayout(0,1));
		String [] Des={"Circulo","Triángulo","Polígono"};
		Figuras=new JButton[3];
		VBand=new boolean[Des.length];
		Arrays.fill(VBand,false);
		for(int i=0 ; i<Figuras.length ; i++){
			Figuras[i]=new JButton(Des[i]);
			PWEST.add(Figuras[i]);
		}
		add(PWEST,BorderLayout.WEST);
		
		
		
		
		
		
		
		setVisible(true);
	}
	private void HazEscuchas(){
		BtnAvanzar.addActionListener(this);
		for(int i=0 ; i<Figuras.length ; i++)
			Figuras[i].addMouseListener(this);
	}
	public static void main(String [] a){
		new Grafico1ScreenOff();
	}
	public void paint( Graphics g) 	{
		if(this.g==null)
			return;
		//super.paint(this.g);
		Dibuja();
	
		g.drawImage(backbuffer, 0, 0, getWidth(), getHeight(), this);
	}
	private void Dibuja(){
		 	super.paint(g);
	       g.drawString("INSTITUTO TECNOLÓGICO DE CULIACÁN",50,40);
	        g.drawLine(20,45,300,45);
	        g.drawString("INGENIERÍA EN SISTEMAS COMPUTACIONALES",50,60);
	        g.setColor(Color.BLUE);
	        g.fillRect(50,70,100,50);
	        g.fillRoundRect(250, 70,100, 50, 20, 20);
	        Color CAFE=new Color(192,128,64);
	        g.setColor(CAFE);
	        g.fillRect(50+Posiciones,150,200,100);
	        g.setColor(Color.RED);
	        g.fillOval(60+Posiciones,220,60,60);
            g.fillOval(190+Posiciones,220,50,60);

	        g.setColor(Color.WHITE);
	        g.fillRect(200+Posiciones,160,50,30);
	        if(VBand[0]){
	        	g.setColor(Color.RED);
	        	g.fillOval(200, 300, 100, 100);
	        	
	        } else{
	        	if (VBand[1]){
	        		g.setColor(Color.RED);

	    			int [] VX={150,200,250};
	    			int [] VY={400,300,400};
	    		//	g.drawPolygon(VX, VY, VX.length);   
	    			g.fillPolygon(VX, VY, VX.length);
	        		
	        	} else {
	        		if(VBand[2]){
	        			g.setColor(Color.RED);
	        			int [] VX={150,200,300,50};
	        			int [] VY={400,400,500,500};
	        			g.fillPolygon(VX, VY, VX.length);
	        		}
	        	}
	        }
	        
	        
	        
	}
	public void actionPerformed(ActionEvent Evt) {
		if(Posiciones+50+200>=this.getWidth())
			Band=true;
		if(Posiciones<-50){
			Band=false;
			Posiciones=0;
		}
		if(Band)
		   Posiciones-=20;
		else
			Posiciones+=20;
		repaint();

		//this.repaint(10, 150, this.getWidth(), 130);
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent Evt) {
		if(Evt.getSource()==Figuras[0]){
			VBand[0]=true;
		
			repaint();
			return;
		}
		if(Evt.getSource()==Figuras[1]){
			VBand[1]=true;
			
			repaint();
			return;
		}
		if(Evt.getSource()==Figuras[2]){
			VBand[2]=true;
			
			repaint();
			return;
		}
		
	}
	@Override
	public void mouseExited(MouseEvent Evt) {
		if(Evt.getSource()==Figuras[0]){
			VBand[0]=false;
			
			repaint();
			return;
		}
		if(Evt.getSource()==Figuras[1]){
			VBand[1]=false;
			
			repaint();
			return;
		}
		if(Evt.getSource()==Figuras[2]){
			VBand[2]=false;
			
			repaint();
			return;
		}
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
