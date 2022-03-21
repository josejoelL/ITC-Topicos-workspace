package material_clase;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pan0V3 extends JFrame implements ActionListener, KeyListener{
	private JPanel glass;
	private JButton btnGlass, Btn, Btn_NORTE;	
	JTextField Txt;
	public Pan0V3() {
		HazInterfaz();
		HazEscuchas();
	}
	private void HazInterfaz() {
        glass=(JPanel) getGlassPane();
    	glass.add(new JLabel("***PRUEBA DEL CRISTAL DEL CONTENEDOR PRINCIPAL (JFRAME y JDIALOG)***"));
    	btnGlass=new JButton("CONTINUAR");
    	glass.add(btnGlass);
    	setLayout(new GridLayout(0,2));
        setSize(400,300);
        setTitle("PRIMER PANTALLA");
        setLocationRelativeTo(null);
        //setResizable(false);
        Btn=new JButton("Aceptar");
        add(Btn);
        Btn_NORTE=new JButton("Aceptar NORTE");
        add(Btn_NORTE,BorderLayout.NORTH); 
        Txt=new JTextField("200");
        add(Txt,BorderLayout.SOUTH);
        String [] Dias= {"Lun","Mar","Mie","Jue"};
        JComboBox CMB=new JComboBox(Dias);
        add(CMB,BorderLayout.EAST);
        setIconImage (new ImageIcon("caballo.jpg").getImage());    
        
 //       add(new JLabel("se agregó al final",SwingConstants.CENTER),2);      
        setVisible(true);
        glass.setOpaque(true);
        glass.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void HazEscuchas() {
    	btnGlass.addActionListener(this);
    	Btn.addActionListener(this);
    	Btn_NORTE.addActionListener(this);
    	Txt.addActionListener(this);
    	Txt.addKeyListener(this);
    }	

	public void actionPerformed(ActionEvent evt) { 
		if(evt.getSource()==btnGlass) {
			System.out.println("estoy tendiendo al botón del cristal");
			glass.setVisible(false);
			return;
		}
		if(evt.getSource()==Btn) {
			Btn.setBackground(Color.PINK);
			return;
		}
		System.out.println("_________________");
		if(evt.getSource()==Btn_NORTE) {
		       glass.setOpaque(true);
		        glass.setVisible(true);
		        System.out.println("************");
		        return;
		}
		if(evt.getSource()==Txt) {
			if(Txt.getText().length()==0) {
				System.out.println("NO SE PERMITE CAJA VACÍA");
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null,"No se perite cajas vacias","Captura",JOptionPane.ERROR_MESSAGE);
				Txt.requestFocus();
				return;

			}
			
			
			
		}

	}
	public static void main(String [] a) {
		new Pan0V3();
	}
	@Override
	public void keyTyped(KeyEvent evt) {

		if(Txt.getText().length()==5) {
			System.out.println("no se permiten mas de 5 caracteres");
			evt.consume();
			return;
		}
		if(evt.getKeyChar()<48 || evt.getKeyChar()>'9') {
			evt.consume();
			return;
			
		}
	}
	@Override
	public void keyPressed(KeyEvent evt) {
		if(evt.isControlDown()) {
			evt.consume();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("donde LIBERA la tecla");
	}
}
