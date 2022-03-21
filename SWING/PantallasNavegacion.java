package material_clase;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//public class PantallasNavegacion  implements ActionListener, WindowListener {
public class PantallasNavegacion extends ClaseAdaptadora implements ActionListener{
	final int NP=10;
	Window [] vp;
	int sub=0;
	JButton btnSiguiente,btnAnterior;
	
	public PantallasNavegacion() {
		HazInterfaz();
		HazEscuchas();
	}
	private void HazInterfaz() {
		vp=new Window[NP];
		vp[0]=new JFrame("Pantalla # 1");
		vp[0].setSize(400,300);
		vp[0].setLocationRelativeTo(null);
		
		((JFrame)vp[0]).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnSiguiente=new JButton("Siguiente");
		btnAnterior=new JButton("Anterior");
		for(int i=1 ; i<vp.length ; i++) {
			vp[i]=new JDialog();
			vp[i].setSize(400,300);
			vp[i].setLocationRelativeTo(null);
			((JDialog) vp[i]).setTitle("Pantalla # "+(i+1));
			((JDialog) vp[i]).setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
		}
		vp[0].add(btnSiguiente,BorderLayout.SOUTH);
		vp[0].setVisible(true);
	}
	private void HazEscuchas() {
		btnSiguiente.addActionListener(this);
		btnAnterior.addActionListener(this);
		for(int i=1 ; i<vp.length ; i++)
		   vp[i].addWindowListener(this);
	}
	public static void main(String[] args) {
		new PantallasNavegacion();
		System.out.println("main finalizando ***********");
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource()==btnSiguiente) {
			vp[sub].setVisible(false);
			sub++;
			if (sub!=vp.length-1 )
				vp[sub].add(btnSiguiente,BorderLayout.SOUTH);
			vp[sub].add(btnAnterior,BorderLayout.NORTH);
			vp[sub].setVisible(true);
			return;
		}
		if(evt.getSource()==btnAnterior) {
			regresoPantalla();
			return;
		
		}
		
	}
	private void regresoPantalla() {
		vp[sub].setVisible(false);
		sub--;
		if(sub !=0)
			vp[sub].add(btnAnterior,BorderLayout.NORTH);
		vp[sub].add(btnSiguiente,BorderLayout.SOUTH);
			
		vp[sub].setVisible(true);
		return;		
	}

	public void windowClosing(WindowEvent e) {
		regresoPantalla();
		return;		
	}

	

}
