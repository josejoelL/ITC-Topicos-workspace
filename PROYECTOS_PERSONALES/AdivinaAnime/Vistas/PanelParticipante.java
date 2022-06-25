package Vistas;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.text.IconView;

import Modelos.GanoLaRonda;
import Modelos.Rutinas;



public class PanelParticipante extends JPanel implements ActionListener,ComponentListener {
	private GanoLaRonda G;
	//como recibire las 10 rolas?
	private int index,CantJg;
	private GridLayout GridP;
	private JButton Q1,Q2,Q3,Q4;
	private Color rosaFeo;
	public PanelParticipante(int index, GanoLaRonda G,int CantJg ) {
		this.G=G;
		this.index=index;
		this.CantJg=CantJg;
		hazinterfaz();
		HazEscuchas();
		
	}
	
	private void hazinterfaz() {
		
		GridP = new GridLayout(2,2,0,0);
		//GridP.setColumns(2);
	//	GridP.setRows(2);
	
		setLayout(GridP);
		
		if(CantJg==1){
			GridP.setColumns(0);
				GridP.setRows(1);
		}
		
		
		if(CantJg==2) {
			GridP.setColumns(2);
			GridP.setRows(2);
			/*
			
			double X = getWidth() / 2.0;
            double Y = getHeight() / 2.0;
            AffineTransform at = new AffineTransform();
           
          
           at.rotate(Math.toRadians(180), X, Y);*/
		}
		
		if(CantJg==3) {
			GridP.setColumns(1);
			GridP.setRows(0);
		};
		if(CantJg==4) {
			GridP.setColumns(2);
			GridP.setRows(2);
		}
		
		
		if(CantJg==5) {
			GridP.setColumns(1);
			GridP.setRows(0);
		};
		
		
		if(CantJg==6) {
			GridP.setColumns(2);
			GridP.setRows(2);
		};
		
		rosaFeo = new Color(240,220,240);
		
		
		Q1 = new JButton();
		//Q1.setText("Respuesta 1");
		Q1.setBackground(rosaFeo);
		Q1.setForeground(Color.white);
		Q1.setBorder(null);
		Q1.setBorderPainted(false);
		//Q1.setIcon(new ImageIcon("src/Sprite/durara.png"));
		//Q1.setIcon(Rutinas.AjustarImagen("src/Sprite/durara.png", 460, 600 ));
	//	Q1.setIcon(Rutinas.AjustarImagen("src/Sprite/durara.png", 460/CantJg, 600/ CantJg ));
		 
			
			
		Q2 = new JButton();
		//Q2.setText("Respuesta 2");
		Q2.setBackground( rosaFeo );
		Q2.setForeground(Color.white);
		Q2.setBorder(null);
		Q2.setBorderPainted(false);
		//Q2.setIcon(new ImageIcon("src/Sprite/Dororo.jpg"));
		
	//	Q2.setIcon(Rutinas.AjustarImagen("src/Sprite/Dororo.jpg", 460, 600 ));
		/*
			if(CantJg>=3) {
			Q2.setIcon(new ImageIcon("src/Sprite/Dororo.jpg"));
		}
			
			else {
			Q2.setIcon(Rutinas.AjustarImagen("src/Sprite/Dororo.jpg", 460/CantJg, 600/ CantJg ));
		
			}
		
		*/
		
		
		Q3 = new JButton();
	//	Q3.setText("Respuesta 3");
		Q3.setBackground(rosaFeo);
		Q3.setForeground(Color.white);
		Q3.setBorder(null);
		Q3.setBorderPainted(false);
		//Q3.setIcon(new ImageIcon("src/Sprite/Black Clover.png"));
		//Q3.setIcon(Rutinas.AjustarImagen("src/Sprite/Black Clover.png", 460/CantJg, 600/ CantJg ));
		//Q3.setIcon(Rutinas.AjustarImagen("src/Sprite/Black Clover.png", 460, 600 ));
		
		
		Q4 = new JButton();
	//	Q4.setText("Respuesta 4");
		Q4.setBackground(rosaFeo);
		Q4.setForeground(Color.white);
		Q4.setBorder(null);
		Q4.setBorderPainted(false);
		//Q4.setIcon(new ImageIcon("src/Sprite/Boku no Hero Academia.png"));
		//Q4.setIcon(Rutinas.AjustarImagen("src/Sprite/Boku no Hero Academia.png", 460, 600 ));
		//Q4.setIcon(Rutinas.AjustarImagen("src/Sprite/Boku no Hero Academia.png", 460/CantJg, 600/ CantJg ));
		 	
		
		
		this.add(Q1);
		this.add(Q2);
		this.add(Q3);
		this.add(Q4);
		
		revalidate();
	}
	
	

	public int getIndex() {
		return index;
	}
/*
	public void setIndex(int index) {
		this.index = index;
	}
*/
	public int getCantJg() {
		return CantJg;
	}

	public void setCantJg(int cantJg) {
		CantJg = cantJg;
		this.removeAll();
		hazinterfaz();
		this.revalidate();
		this.repaint();
	}

	private void HazEscuchas() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

	public void run() {
		// TODO Auto-generated method stub
		
	}
}	
	
	