package clemente;
import javax.swing.*;
import javax.swing.border.MatteBorder;

import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Grafico1 extends JFrame implements ActionListener,MouseListener{
	JButton BtnAvanzar;
	JButton BtnPrueba;
	JButton [] Figuras;
	boolean [] VBand;
	int Posiciones;
	boolean Band;
	Timer T;
	public Grafico1(){
		super("Gráficos en java");
		Posiciones=0;
		Band=false;
		T=new Timer(200,this);
		
		HazInterfaz();
		HazEscuchas();
		T.start();
		
	}
	private void HazInterfaz(){
		
		UIManager.LookAndFeelInfo[] looks;
		String [] lookNames;
		looks = UIManager.getInstalledLookAndFeels();
		lookNames = new String [looks.length];
		for (int i = 0; i < lookNames.length; i++) {lookNames [i] = looks [i].getName();}
		try {UIManager.setLookAndFeel(looks[1].getClassName());} catch (Exception e) {}
		
		
		
		setSize(600,400);
		setLocationRelativeTo(null);
		BtnAvanzar=new JButton("Avanzar");
				BtnAvanzar.setBackground(new Color(255,00,200)  );
		add(BtnAvanzar,BorderLayout.SOUTH);
		JPanel PWEST=new JPanel(new GridLayout(0,1));
		String [] Des={"Circulo","Triángulo","Polígono"};
		Figuras=new JButton[3];
		VBand=new boolean[Des.length];
		Arrays.fill(VBand,false);
		for(int i=0 ; i<Figuras.length ; i++){
			Figuras[i]=new JButton(Des[i]);
			Figuras[i].setBackground(new Color(240,200,240) );
			
			PWEST.add(Figuras[i]);
		}
		Figuras[2].setBorder(new MatteBorder(null));
		//Figuras[2].setBorder(null);
		add(PWEST,BorderLayout.WEST);
		JPanel PCENTER=new JPanel(new GridLayout(0,1));
		
		
		
		
		PCENTER.setBackground(new Color(240,220,240));

		add(PCENTER,BorderLayout.CENTER);
		
		
		
		setVisible(true);
	}
	private void HazEscuchas(){
		BtnAvanzar.addActionListener(this);
		for(int i=0 ; i<Figuras.length ; i++)
			Figuras[i].addMouseListener(this);
	}
	public static void main(String [] a){
		new Grafico1();
	}
	public void paint( Graphics g) 	{
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
//	    			g.drawLine(200,300,150,400);
//	    			g.drawLine(200,300,250,400);
//	    			g.drawLine(250,400,150,400);
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
	@Override
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
		//repaint();
		this.repaint(10, 150, this.getWidth(), 130);
		
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
