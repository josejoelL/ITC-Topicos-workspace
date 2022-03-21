package tarea;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Hanoi.Rutinas;
import tarea.src.Temporizador;

/*
Ncontrol:18170365
Materia: Topicos Avanzados De Programacion
autor: jose joel landeros santos 
*/

public class pares extends JFrame implements ActionListener,MouseListener  {
	JMenuBar mb;
	JMenu    Jugar,ayuda;
	JMenuItem facil,medio,dificil,ComoJugar,Salir;
	JPanel Panel1, Panel2, Panel3;
	int N,R;
	int Col,Ren;
	JButton Btns[][];
	int [][] imagenes, IdImagen;
	public pares(){
		super("Juego de pares");
		N=6;	
		R = 0;
		imagenes = new int[N][N];
		IdImagen=new int [N][N];
		Btns = new JButton[N][N];
	 ArregloImagenRandomPar();
		HazInterfaz();
		HazEscuchas();
		
	}
	private void HazInterfaz(){
		setSize(300,350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mb=new JMenuBar();
		setJMenuBar(mb);
		mb.setBackground(Color.white);
		
		
		
		setLayout(new GridLayout(0, N,1,1));
		
		for(int i=0 ; i< N ; i++)
			for(int j=0 ; j<N ; j++)
			{	IdImagen[i][j]=imagenes[i][j];
				//System.out.println(IdImagen[i][j]);
				Btns[i][j]=new JButton(Rutinas.AjustarImagen("images/"+imagenes[i][j]+".png",46,47));
				Btns[i][j].setBackground(Color.DARK_GRAY);
				
			//	System.out.println(ImagenRandom());
			}
		for(int i=0 ; i< N ; i++)
			for(int j=0 ; j<N ; j++)
				add(Btns[i][j]);		
		
		
		Jugar	=new JMenu("Jugar");
		ayuda   =new JMenu("ayuda");
		
		
		
		mb.add(Jugar);
		mb.add(ayuda);
		
		ayuda.add(ComoJugar=new JMenuItem("Como Jugar"));
		ayuda.add(Salir=new JMenuItem("Salir"));
		
		ComoJugar.setBackground(Color.cyan);
		Salir.setBackground(Color.red);
		
		Jugar.add(facil=new JMenuItem("facil"));
		Jugar.add(medio=new JMenuItem("medio"));
		Jugar.add(dificil=new JMenuItem("dificil"));
		
		facil.setBackground(Color.green);
		medio.setBackground(Color.orange);
		dificil.setBackground(Color.red);
		
		

		
		
		//setResizable(false);
		setVisible(true);
		
	}

	private void ArregloImagenRandomPar() {
	
		boolean par1;
		boolean par2;
		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 6; j++) {
				par1 = false;
				par2 = false;
				while (par2) {

					R = new Random().nextInt(17);

					for (int x = 0; x < 6; x++)
					{	for (int y = 0; y < 6; y++) {
							
							if (R == imagenes[x][y]) {
								if (par1) {
									par2 = true;
									break;
								}
								par1 = true;
								
							}
						}if (par2) break;
					}
				}imagenes[i][j] = R;
			}
		//return imagenes;
		for (int i = 0; i <imagenes.length; i++) {
			System.out.println();
			for (int j = 0; j < imagenes[i].length; j++) {
				System.out.print(imagenes[i][j] + " \t");
			}
		}
	}
	private String ImagenRandom() {
		int R=new Random().nextInt(17);
		return "images/"+R+".png";
	}
	private void HazEscuchas(){
		
		facil.addActionListener(this);
		medio.addActionListener(this);
		dificil.addActionListener(this);
		ComoJugar.addActionListener(this);
		Salir.addActionListener(this);
		
		
		for(int i=0 ; i<Btns.length ; i++)
			for(int j=0 ; j<Btns.length ; j++){
				Btns[i][j].addActionListener(this);
				Btns[i][j].addMouseListener(this);
				Btns[i][j].setVisible(true);
			}
	}
	
	public static void main(String [] a){
		new pares();
	}
	@Override
	public void actionPerformed(ActionEvent Evt) {
		
		if(Evt.getSource()== Salir ){
			System.exit(0);
			
		}
		if(Evt.getSource()==facil){
			getContentPane().setBackground(Color.green);
			return;
		}	
		if(Evt.getSource()==medio){
		
				System.out.print("aqui adamos");
				getContentPane().setBackground(Color.orange);
				return;			
		}
		
		if(Evt.getSource()==dificil){
		
			
			getContentPane().setBackground(Color.red);
			return;
			}	
		
		if(Evt.getSource()==ComoJugar){
			Temporizador Pan2=new Temporizador( 
					"el jugador voltear 2 cartas, sí son iguales, el jugador ha hecho una pareja");
			
			
			Pan2.setVisible(true);
			return;
		}	
		
		int Ren,Col;
		Ren=Col=-1;
		for(int i=0 ; i< Btns.length ; i++)
			for(int j=0 ; j<Btns.length ; j++)
				if(Evt.getSource()==Btns[i][j]){
					Ren=i;
					Col=j;
					break;
				}
	
		//Btns[Ren][Col].setIcon(Rutinas.AjustarImagen(ImagenRandom(), Btns[Ren][Col].getWidth(), Btns[Ren][Col].getHeight()));
		
	//	Btns[Ren][Col].setPressedIcon(new Icon("/Images/3.png"));
	//	Btns[Ren][Col].setEnabled(false);
		System.out.println(Ren+" "+Col);
		
	//	Btns[Ren][Col].setDisabledIcon(Rutinas.AjustarImagen(ImagenRandom(), Btns[Ren][Col].getWidth(), Btns[Ren][Col].getHeight()));
		Btns[Ren][Col].setBackground(Color.gray);
		
		if(Btns[Ren][Col].getIcon().equals(Btns[Ren][Col].getIcon())){
			if (Btns[Ren][Col].getHideActionText()) {
				Btns[Ren][Col].setDisabledIcon(null); 
			}
			
			System.out.println(Btns[Ren][Col].getClass().getName());
			
			return;
		}	
	}
	public void mouseClicked(MouseEvent e) {	
	}
	public void mousePressed(MouseEvent e) {	
	}
	public void mouseReleased(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
}
	
