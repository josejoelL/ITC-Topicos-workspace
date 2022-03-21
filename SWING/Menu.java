
package clemente;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class Menu extends JFrame implements ActionListener{
	
	JMenuBar mb;
	JMenu    Colores,Dias,Autos,Estaciones,RGB;
	JMenuItem Naranja,Amarillo,Lila,Rojo,Verde,Azul,Salir;
	JMenuItem Lunes,Martes,Miercoles,Jueves,Viernes,Sabado,Domingo;
	
	JDialog Pan2;
	public Menu(){
		super("Manejo de menú");
		HazInterfaz();
		HazEscuchas();
	}
	private void HazInterfaz(){
		setSize(300,250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mb=new JMenuBar();
		setJMenuBar(mb);
		mb.setBackground(Color.cyan);
		
		Colores=new JMenu("Colores");
		Dias   =new JMenu("Dias");
		Autos  =new JMenu("Autos");
		Estaciones=new JMenu("Estaciones");
		
		mb.add(Colores);
		mb.add(Dias);
		mb.add(Autos);	
		mb.add(Estaciones);
		
		mb.add(Salir=new JMenuItem("Salir"));
		
		Naranja=new JMenuItem("Naranja");
		Amarillo=new JMenuItem("Amarillo");
		Lila=new JMenuItem("Lila");
		
		Colores.add(Naranja);
		Colores.add(Amarillo);
		Colores.add(Lila);
		RGB=new JMenu("RGB");
		RGB.add(Rojo=new JMenuItem("Rojo"));
		RGB.add(Verde=new JMenuItem("Verde"));		
		RGB.add(Azul=new JMenuItem("Azul"));
		Colores.add(RGB);

		Lunes=new JMenuItem("Lunes");
		Martes=new JMenuItem("Martes");
		Miercoles=new JMenuItem("Miercoles");
		Jueves=new JMenuItem("Jueves");
		Viernes=new JMenuItem("Viernes");
		Sabado=new JMenuItem("Sabado");
		Domingo=new JMenuItem("Domingo");
		
		Dias.add(Lunes);
		Dias.add(Martes);
		Dias.add(Miercoles);
		Dias.add(Jueves);
		Dias.add(Viernes);
		Dias.add(Sabado);
		Dias.add(Domingo);
		
		
		setResizable(false);
		setVisible(true);
		
		Pan2=new JDialog();
		Pan2.setSize(300,250);
		Pan2.setLocationRelativeTo(null);
		Pan2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Pan2.setModal(true);
	}
	private void HazEscuchas(){
		Salir.addActionListener(this);
		Naranja.addActionListener(this);
		Azul.addActionListener(this);
	}
	
	public static void main(String [] a){
		new Menu();
	}
	@Override
	public void actionPerformed(ActionEvent Evt) {
		
		if(Evt.getSource()== Salir ){
			System.exit(0);
			
		}
		if(Evt.getSource()==Naranja){
			System.out.print("aqui adamos");
			getContentPane().setBackground(Color.ORANGE);
			
			
			return;
			
		}
		if(Evt.getSource()==Azul){
			getContentPane().setBackground(Color.BLUE);
			
			Pan2.setVisible(true);
			return;
			
		}		
	}
}
