package clemente;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
public class UnoV2 {
	public UnoV2(){
		HazInterfaz();
		HazEscuchadores();
	}
	public void HazInterfaz(){
		JFrame Marco = new JFrame("ITC");

		Marco.setBounds(300, 100, 500, 200);

		JLabel Etiqueta = new JLabel("HOLA MUNDO, hecho con SWING",
				SwingConstants.CENTER);

		Marco.add(new JButton("Centro"));
		Marco.add(new JButton("Norte"), BorderLayout.NORTH);
		Marco.add(new JButton("Sur"), BorderLayout.SOUTH);
		Marco.add(new JButton("este"), BorderLayout.EAST);
		Marco.add(new JButton("oeste"), BorderLayout.WEST);
	    Marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Marco.setVisible(true);
	
	}
	public void HazEscuchadores(){
		
	}
	public static void main(String [] a){
		if(a.length==0)
			return;
		System.out.println("ELEMENTOS DEL PARÁMETRO "+a.length);
		new UnoV2();
		for(int i=0 ; i<a.length ; i++)
			System.out.println(a[i]);
	}
}
