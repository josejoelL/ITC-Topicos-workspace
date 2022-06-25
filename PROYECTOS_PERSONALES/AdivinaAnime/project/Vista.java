package project;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

import Modelos.GanoLaRonda;
import Modelos.Rutinas;
import Vistas.PanelJuego;
import Vistas.PanelParticipante;
import Vistas.PantallaComenzar;



public class Vista implements ActionListener, MouseListener, ItemListener {
	private JButton btnSumar,btnRestar,btnJugar,btnR1,btnR5,btnR10;//max6 
	private ButtonGroup BG,BGR;
	private JButton btnFacil,btnDificil,btnNormal,btnExtremo,btnPesadilla;
	
	private JButton btnAcction,btnAventura,btnChoches,btnComedia,btnDemencia,Demonios;
	private JButton btnDrama,btnFantasia,btnEcchi,btnJuego,btnHarem,btnHistorico,btnTerror;
	private JButton btnOtroMundo,btnJosei,btnNiños,btnMagia,btnChicaMagica,btnArtesMarciales;
	private JButton btnMecha,btnMilitar,btnMusica,btnMisterio,btnParodia,btnPolicial,btnpsicologico;
	private JButton btnRomance,btnSamurai,btnEscuela,btnCienciaFiccion,btnSeinen,btnShoujo;
	private JButton btnShounenAi,btnRecuentoDeLaVida,btnEspacio,btnDeportes,btnSobreNatural;
	private JButton btnSuperPoder,btnThriller,btnVampiro;
	
	
	private JButton cerrar,config,btnJugadores,btnYear,btnGen,btnRondas,btnDifi;
	private JComboBox  yearIn,yearFin;
	//private int [] YI,YF;
	private int jugadores;
	private JPanel Panelmain,PerJg,PerDifi,PerYear,PerGnr,PerRonds;
	private JPanel PerJgC,PerDifiC,PerYearC,PerGnrC,PerRondsC;
	private JPanel  P1, P2, glass,P3,P4;
	private PantallaComenzar P0;
	private GanoLaRonda G;
	private boolean band;//lo hare arreglo[] si es por 10 rondas 
	//este band es solo para quitar el fondo de espera 
	private GridLayout Grid,GridPer;
	private FlowLayout Flow;
	private Window Main;
	private int w, h;
	private Vector<PanelParticipante> VJugadores = new Vector<PanelParticipante>();
	
	static String [] YI={"2000","2001","2002","2003","2004","2005","2006","2007","2008","2009"
	  		  ,"2010","2011","2012","2013","2014","2015","2016","2017","2018","2019"
	  		  ,"2020","2021","2022"};

	static String [] YF={"2022","2021","2020","2019","2018","2017","2016","2015","2014"
	  		  ,"2013","2012","2011","2010","2009","2008","2007","2006","2005"
	  		  ,"2004","2003","2002","2001","2000"};
	
	private UIManager.LookAndFeelInfo[] looks;
	private String [] lookNames;
	
	
	
	public Vista(){
		
		
		band=false;
		jugadores=1;
		 G = new GanoLaRonda();
		HazInterfaz();
		HazEscuchas(); 
		
	}
	
	

	private void HazInterfaz(){
		
		Main = new JFrame(" Adivina el Anime ");
		
		looks = UIManager.getInstalledLookAndFeels();
		lookNames = new String [looks.length];
		for (int i = 0; i < lookNames.length; i++) {lookNames [i] = looks [i].getName();}
		try {UIManager.setLookAndFeel(looks[0].getClassName());} catch (Exception e) {}
		Main.setSize(1080, 720);
		
		Panelmain = new JPanel();
		
		((Frame) Main).setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		P0 = new PantallaComenzar(); 
		Main.add(P0);  
		
		 P1 = new JPanel();//seguro este es el de los personajes
		
		 P2 = new JPanel();
		 P3 = new JPanel();
		 P4 = new JPanel();
		 
		 PerJg	  	 = new JPanel();
		 PerJg.setLayout(new BorderLayout());
		 
		 PerJgC	  	 = new JPanel();
		 PerJgC.setBackground(Color.gray);
		 PerJg.add( PerJgC,BorderLayout.CENTER);
		 
		 
		 
		 PerDifi	 = new JPanel();
		 PerDifi.setLayout(new BorderLayout());
		 
		 PerDifiC	 = new JPanel();
		 PerDifiC.setBackground(Color.gray);
		 PerDifi.add( PerDifiC,BorderLayout.CENTER);
		 
		 
		 
		 PerYear	 = new JPanel();
		 PerYear.setLayout(new BorderLayout());
		 
		 PerYearC	 = new JPanel();
		 PerYearC.setBackground(Color.gray);
		 PerYear.add( PerYearC,BorderLayout.CENTER);
		 
		 
		 
		 PerGnr		 = new JPanel();
		 PerGnr.setLayout(new BorderLayout());
		 
		 PerGnrC		 = new JPanel();
		 PerGnrC.setBackground(Color.gray);
		 
		 PerGnr.add(PerGnrC,BorderLayout.CENTER);
		 
		 
		 PerRonds	 = new JPanel();
		 PerRonds.setLayout(new BorderLayout());
		 
		 PerRondsC	 = new JPanel();
		 PerRondsC.setBackground(Color.gray);
		 
		 PerRonds.add(PerRondsC,BorderLayout.CENTER);
		// GridPer.layoutContainer(Main);
		 
		 
		Grid = new GridLayout(1, 0, 30, 30);
		GridPer = new GridLayout(0, 1, 10, 10);
		Flow = new FlowLayout();//no lo estoy usando
		
		  P1.setLayout(Grid);
		  
		  for (int i = 0; i < jugadores; i++) {
				
				VJugadores.addElement(new PanelParticipante(i + 1, G,jugadores));
				P1.add(VJugadores.lastElement());
			}
		 
			 
		// P2.setLayout(new FlowLayout(FlowLayout.CENTER));
		  P2.setLayout(GridPer);
				 
		  P2.add(PerJg);
		  P2.add(PerDifi);
		  P2.add(PerYear);
		  P2.add(PerGnr);
		  P2.add(PerRonds);
		  
	
		 
		 
		 Panelmain.setLayout(new BorderLayout());
		 
		 glass=(JPanel) ((JFrame) Main).getGlassPane();
		 //algo de prueba 186
		 glass.setLayout(new GridLayout(0,7));
		 
		 	P3.setLayout(new BorderLayout());
		 	w = P0.getWidth();
			h = P0.getHeight();
		 	
		 	P3.setPreferredSize(new Dimension( (int) (w*0.25) ,(int) (h*0.75) ));
		 
		 	 P4.setLayout(new FlowLayout(FlowLayout.RIGHT));
		 	 
		 	 	btnJugadores=new JButton("Jugadores");
		 	 	btnJugadores.setBackground(Color.black);
		 	 	btnJugadores.setForeground(Color.white);
		 	 	P3.add(btnJugadores,BorderLayout.NORTH);
		 	 	btnJugadores.setBorder(null);
		 	 	
		 	 	
		 	 	btnYear =new JButton("Año de Lanzamiento");
		 	 	btnYear.setBackground(Color.black);
		 	 	btnYear.setForeground(Color.white);
		 	 	PerYear.add(btnYear,BorderLayout.NORTH);
		 	 	btnYear.setBorder(null);
		 	 	
		 	 	
		 	 	btnGen =new JButton("Genero");
		 	 	btnGen.setBackground(Color.black);
		 	 	btnGen.setForeground(Color.white);
		 	 	PerGnr.add(btnGen,BorderLayout.NORTH);
		 	 	btnGen.setBorder(null);
		 	 	
		 	 	
		 	 	
		 	 	btnRondas =new JButton("Numero de juegos");
		 	 	btnRondas.setBackground(Color.black);
		 	 	btnRondas.setForeground(Color.white);
		 	 	PerRonds.add(btnRondas,BorderLayout.NORTH);
		 	 	btnRondas.setBorder(null);
		 	 	
		 	 	
		 	 	btnDifi =new JButton("Dificultad");
		 	 	btnDifi.setBackground(Color.black);
		 	 	btnDifi.setForeground(Color.white);
		 	 	PerDifi.add(btnDifi,BorderLayout.NORTH);
		 	 	btnDifi.setBorder(null);
		 	 	
		 	 	
		 	 	
		 	 	
		 	 cerrar = new JButton(" cerrar ");
			 cerrar.setBackground(Color.black);
			 cerrar.setForeground(Color.white);
			 P3.add(cerrar,BorderLayout.SOUTH);
			 cerrar.setBorder(null);
			 
			 config = new JButton();
			
			 config.setIcon(Modelos.Rutinas.AjustarImagen("src/Sprite/config2.png", 25*2, 25*2));
			 config.setBorderPainted(false);
			 config.setBorder(null);
			 config.setBackground(Color.gray);
			 
			 P4.add(config);
			 
			 
			 	glass.add(P3);
			 	
			 	
			 	P3.add(P2);
			 	
			 	
			 	
				Panelmain.add(P1, BorderLayout.CENTER);
			 
			 	//cambio tonto 257
				Panelmain.add(P4, BorderLayout.NORTH);
			 
				btnSumar = new JButton();
				btnSumar.setBackground(new Color(17, 45, 78));
				btnSumar.setBorderPainted(false);
				btnSumar.setIcon(Rutinas.AjustarImagen("src/Sprite/mas.png", 25, 25));
				btnSumar.setPreferredSize(new Dimension(25, 25));
				
				
				btnRestar = new JButton();
				btnRestar.setBackground(new Color(17, 45, 78));
				btnRestar.setBorderPainted(false);
				btnRestar.setIcon(Rutinas.AjustarImagen("src/Sprite/menos.png", 25, 25));
				btnRestar.setPreferredSize(new Dimension(25, 25));
				
				
				btnJugar = new JButton();
				btnJugar.setBackground(Color.darkGray);
				btnJugar.setIcon(Rutinas.AjustarImagen("src/Sprite/play.png", 840/10, 497/10));
				btnJugar.setBorderPainted(false);
				btnJugar.setPreferredSize(new Dimension(56, 50));
				
				BG = new ButtonGroup();
				BGR= new ButtonGroup();
				
				
				btnFacil = new JButton();
				btnFacil.setBackground(Color.green);
				btnFacil.setText("Facil");
				btnFacil.setForeground(Color.white);
				//btnFacil.setBorder(null);//la descripcion dice que fallan los borders
				btnFacil.setBorderPainted(false);
				btnFacil.setPreferredSize(new Dimension(60,30));
	
				btnNormal = new JButton();
				btnNormal.setBackground(Color.darkGray);
				btnNormal.setText("Normal");
				btnNormal.setForeground(Color.white);
				 
				 
				btnDificil = new JButton();
				btnDificil.setBackground(Color.darkGray);
				btnDificil.setText("Dificil");
				btnDificil.setForeground(Color.white);
				 
				 
				btnExtremo = new JButton();
				btnExtremo.setBackground(Color.darkGray);
				btnExtremo.setText("Extremo");
				btnExtremo.setForeground(Color.white);
				 
				 
				btnPesadilla = new JButton();
				btnPesadilla.setBackground(Color.darkGray);
				btnPesadilla.setText("Pesadilla");
				btnPesadilla.setForeground(Color.white);
				
				btnShoujo = new JButton();
				btnShoujo.setBackground(Color.darkGray);
				btnShoujo.setText("Shoujo");
				btnShoujo.setForeground(Color.white);
				
				btnAcction = new JButton();
				btnAcction.setBackground(Color.darkGray);
				btnAcction.setText("Acction");
				btnAcction.setForeground(Color.white);

				btnComedia = new JButton();
				btnComedia.setBackground(Color.darkGray);
				btnComedia.setText("Comedia");
				btnComedia.setForeground(Color.white);
				
				btnParodia = new JButton();
				btnParodia.setBackground(Color.darkGray);
				btnParodia.setText("Parodia");
				btnParodia.setForeground(Color.white);
				
				btnEscuela = new JButton();
				btnEscuela.setBackground(Color.darkGray);
				btnEscuela.setText("Escolar");
				btnEscuela.setForeground(Color.white);
				
				btnOtroMundo = new JButton();
				btnOtroMundo.setBackground(Color.darkGray);
				btnOtroMundo.setText("Isekai");
				btnOtroMundo.setForeground(Color.white);
				
				btnRecuentoDeLaVida = new JButton();
				btnRecuentoDeLaVida.setBackground(Color.darkGray);
				btnRecuentoDeLaVida.setText("Recuentos De La Vida");
				btnRecuentoDeLaVida.setForeground(Color.white);
				
				btnDrama = new JButton();
				btnDrama.setBackground(Color.darkGray);
				btnDrama.setText("Drama");
				btnDrama.setForeground(Color.white);
				
				btnSeinen = new JButton();
				btnSeinen.setBackground(Color.darkGray);
				btnSeinen.setText("Seinen");
				btnSeinen.setForeground(Color.white);
				
				btnAventura = new JButton();
				btnAventura.setBackground(Color.darkGray);
				btnAventura.setText("Aventura");
				btnAventura.setForeground(Color.white);
			
				yearIn = new JComboBox<String>(YI);
				yearIn.setBackground(Color.darkGray);
				yearIn.setForeground(Color.white);
				yearIn.setBorder(null);
				//componentUi
				//yearIn.setAutoscrolls(true);
				
				
				yearFin= new JComboBox<String>(YF);
				yearFin.setBackground(Color.darkGray);
				yearFin.setForeground(Color.white);
				yearFin.setBorder(null);
				
				
				btnR1= new JButton();
				btnR1.setBackground(Color.darkGray);
				btnR1.setText("1 Ronda");
				btnR1.setForeground(Color.white);
				
				btnR5= new JButton();
				btnR5.setBackground(Color.darkGray);
				btnR5.setText("5 Rondas");
				btnR5.setForeground(Color.white);
				
				btnR10= new JButton();
				btnR10.setBackground(Color.darkGray);
				btnR10.setText("10 Rondas");
				btnR10.setForeground(Color.white);
				
				BG.add(btnFacil);
				BG.add(btnNormal);
				BG.add(btnDificil);
				BG.add(btnExtremo);
				BG.add(btnPesadilla);
				
				BGR.add(btnR1);
				BGR.add(btnR5);
				BGR.add(btnR10);
				
				PerDifiC.add(btnFacil);
				PerDifiC.add(btnNormal);
				PerDifiC.add(btnDificil);
				PerDifiC.add(btnExtremo);
				PerDifiC.add(btnPesadilla);
				
							
				PerGnrC.add(btnComedia);	
				PerGnrC.add(btnAcction);	
				PerGnrC.add(btnAventura);	
				PerGnrC.add(btnParodia);	
				PerGnrC.add(btnSeinen);	
				PerGnrC.add(btnDrama);	
				PerGnrC.add(btnRecuentoDeLaVida);	
				PerGnrC.add(btnOtroMundo);	
				PerGnrC.add(btnEscuela);	
				
				
				
				PerYearC.add(yearIn);
				PerYearC.add(yearFin);
				
				P1.setBackground(Color.darkGray);
				P2.setBackground(Color.darkGray);
				P4.setBackground(Color.darkGray);
				
				PerJgC.add(btnRestar);
				PerJgC.add(btnJugar);
				PerJgC.add(btnSumar);
				
				PerRondsC.add(btnR1);
				PerRondsC.add(btnR5);
				PerRondsC.add(btnR10);
				

				((JFrame) Main).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				Main.setVisible(true);
				
			
				
			//	Image icon = new ImageIcon(getClass().getResource("ico.png")).getImage();
			//	Main.setIconImage(icon);
	
	
}
private void HazEscuchas() {
	P0.addMouseListener(this);
	btnRestar.addActionListener(this);
	btnJugar.addActionListener(this);
	btnSumar.addActionListener(this);
	cerrar.addActionListener(this);
	config.addActionListener(this);
	
	yearIn.addActionListener(this);
	yearFin.addActionListener(this);
	
	yearIn.addItemListener(this);
	yearFin.addItemListener(this);
	
	}
public void setControlador(Controlador C){
//	BtnPesos.addActionListener(C);
//	BtnDolares.addActionListener(C);
}



public void actionPerformed(ActionEvent e) {
	if (e.getSource()==btnJugar) {
			for (int i = 0; i < VJugadores.size(); i++) 
			VJugadores.get(i).run();
			glass.setVisible(false);	
			P1.revalidate();
		return;
	}
	if (e.getSource()==btnSumar) {
		if (jugadores >= 6)
			return;
		jugadores++;
		VJugadores.addElement(new PanelParticipante(jugadores, G, jugadores));
		P1.add(VJugadores.lastElement());
		
		
		if (jugadores%2==0 && jugadores!=2) {
			Grid.setColumns(2);
			Grid.setRows(2);
		}else {
			Grid.setColumns(0);
			Grid.setRows(1);
		}
		
	
		  for (int i = 1; i < VJugadores.size(); i++) {
			  VJugadores.elementAt(i-1).setCantJg(jugadores);
		  }
		P1.revalidate();
		return;
	}
	if (e.getSource()==btnRestar) {
		if (jugadores < 1)
			return;
		P1.remove(jugadores - 1);
	
		VJugadores.removeElementAt(jugadores - 1);
		jugadores--;
		
		if (jugadores%2==0 && jugadores!=2) {
			Grid.setColumns(2);
			Grid.setRows(2);
		}else {
			Grid.setColumns(0);
			Grid.setRows(1);
		}
			 
		/*
		for (int i = VJugadores.size(); 0 < VJugadores.size()-2 ; i--) {
			System.out.println("entro ");
			VJugadores.elementAt(i).setCantJg(jugadores);
		}
		*/
		P1.revalidate();
		
		
		return;
	}
	if ( e.getSource()== cerrar) {

		glass.setVisible(false);			

		return;
	}
	if (e.getSource()== config) {
		glass.setVisible(true);
		return;
	}
	
	if (e.getSource()==yearIn) {
		System.out.println("e");
		return;
	}
	
	
}	



@Override
public void mouseClicked(MouseEvent e) {

	if (!band) {
		band = true;
		Main.remove(P0);
		Main.add(Panelmain);
		Main.revalidate();
	}
	
}



@Override
public void mousePressed(MouseEvent e) {
	
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



@Override
public void itemStateChanged(ItemEvent e) {
	//if(e.getStateChange()!=ItemEvent.SELECTED)
		//return;
	
	System.out.println("click en combo de estados");
	if(e.getSource()==yearIn){
		System.out.println("si escuche");
		yearIn.revalidate();
			return;
	}
	if(e.getSource()==yearFin){
		yearFin.revalidate();
		System.out.println("si escuche");
			return;
	}
	
}
}


