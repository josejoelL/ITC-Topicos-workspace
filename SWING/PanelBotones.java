package clemente;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PanelBotones extends JFrame{

	public PanelBotones(){
		super("Manejo de botones en panel");
		HazInterfaz();
		HazEscuchadores();
	}
	public void HazInterfaz(){
		setSize(300,200);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		JPanel P=new JPanel();
//		P.setLayout(new GridLayout(0,1));
		for(int i=0 ; i<105; i++)
			P.add(new JButton("Btn #"+(i+1)));
		add(P,BorderLayout.NORTH);
		
		add(new JButton("Btncento"));
		add(new JButton("Btncento"),BorderLayout.EAST);
		add(new JButton("Btncento"),BorderLayout.SOUTH);
		add(new JButton("Btncento"),BorderLayout.WEST);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	
	}
	public void HazEscuchadores(){
		
	}
	public static void main(String[] args) {
		new PanelBotones();
	}

}
