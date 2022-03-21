package clemente;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UnoV3 extends JFrame{
	
	private Button BtnEste,BtnEsteMorbo;
	
	public UnoV3(){
		super("ITC");
		HazInterfaz();
		HazEscuchadores();
		
		
	}
	private void HazInterfaz(){
		
		setSize(500,200);
		setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.BLUE);
	
		add(new JButton("swing centro"));
		add(new Button("awt norte"),BorderLayout.NORTH);
	add(new JButton("SWING sur"),BorderLayout.SOUTH);
		add(BtnEste=new Button("awt ESTE"),BorderLayout.EAST);;;;;	;	
		add(new JButton("Oeste"),BorderLayout.WEST);
	
		BtnEste.setBackground(Color.PINK);
		setIconImage (new ImageIcon("maquina.gif").getImage());
		
		setVisible(true);
	}
	private void HazEscuchadores(){
		
	}
	public static void main(String [] codo){
		new UnoV3();
		
	}
}
