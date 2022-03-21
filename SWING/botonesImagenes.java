package material_clase;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class botonesImagenes extends JFrame implements ActionListener, MouseListener {
	JButton [] btns;
	String [] vi;
//	String [] vi= {"Caballo.jpg","Grabar.png","Maquina.gif","verano.gif","avion.png","primavera.gif"};
	
	
	Icon original=null;
	public botonesImagenes() {
		super("Botones con imagenes");
		hazInterfaz();
		hazEscuchadores();
	}
	private void hazInterfaz() {
		btns=new JButton[6];
		vi=new String[6];
		for(int i=0 ; i<vi.length ; i++) {
			vi[i]=new String((i+1)+".jpg");
		}
		for(int i=0 ; i<btns.length ; i++) {
			btns[i]=new JButton("Btn#"+(i+1),Rutinas.AjustarImagen(vi[i], 80, 100));
	//		btns[i].setRolloverIcon(Rutinas.AjustarImagen("ojo.jpg", 50,50));
	//		btns[i].setPressedIcon(Rutinas.AjustarImagen("dg.gif",50,50));			

		
		}
		setSize(400,350);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setLayout(new GridLayout(0,2));
		
		for(int i=0 ; i<btns.length ; i++)
			add(btns[i]);
		
		setVisible(true);
		
		


	}
	public void hazEscuchadores() {
		for(int i=0 ; i<btns.length ; i++) {
			btns[i].addActionListener(this);
			btns[i].addMouseListener(this);
		}
	}
	public static void main(String [] a) {
		new botonesImagenes();
	}

	public void actionPerformed(ActionEvent evt) {
/* Version 1
		if(evt.getSource()==btns[0]) {
			btns[0].setEnabled(false);
			return;
		}
		if(evt.getSource()==btns[1]) {
			btns[1].setEnabled(false);
			return;
		}
		if(evt.getSource()==btns[2]) {
			btns[2].setEnabled(false);
			return;
		}
		if(evt.getSource()==btns[3]) {
			btns[3].setEnabled(false);
			return;
		}
		if(evt.getSource()==btns[4]) {
			btns[4].setEnabled(false);
			return;
		}
		if(evt.getSource()==btns[5]) {
			btns[5].setEnabled(false);
			return;
		}
*/
/*      versiín 2		
		int Sub=0;
		for(int i=0 ; i<btns.length ; i++) {
			if(evt.getSource()==btns[i]) {
				Sub=i;
				break;
			}
		}
		btns[Sub].setEnabled(false);
		btns[Sub].setDisabledIcon(Rutinas.AjustarImagen(vi[Sub],100,40));

*/

  		JButton aux=(JButton)evt.getSource();
		aux.setEnabled(false);
		aux.setDisabledIcon(aux.getIcon());


	
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent evt) {
		// TODO Auto-generated method stub
		
		JButton aux=(JButton)evt.getSource();
		original=aux.getIcon();
		aux.setIcon(new ImageIcon("ojo.jpg"));
		
		
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent evt) {
		// TODO Auto-generated method stub
		JButton aux=(JButton)evt.getSource();
		original=aux.getIcon();
		aux.setIcon(new ImageIcon("dg.gif"));		
	}
	@Override
	public void mouseExited(MouseEvent evt) {
		// TODO Auto-generated method stub
		JButton aux=(JButton) evt.getSource();
		aux.setIcon(original);
		
	}
}
