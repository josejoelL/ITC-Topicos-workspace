package material_clase;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Pan0V2 extends JFrame{
	private JPanel glass;
	private JButton btnGlass, Btn;
	public Pan0V2() {
		HazInterfaz();
		HazEscuchas();
	}
	private void HazInterfaz() {
        glass=(JPanel) getGlassPane();
    	glass.add(new JLabel("***PRUEBA DEL CRISTAL DEL CONTENEDOR PRINCIPAL (JFRAME y JDIALOG)***"));
    	btnGlass=new JButton("CONTINUAR");
    	glass.add(btnGlass);
    	//setLayout(new GridLayout(0,1));
        setSize(400,300);
        setTitle("PRIMER PANTALLA");
        setLocationRelativeTo(null);
        setResizable(false);
        Btn=new JButton("Aceptar");
        add(Btn);
        JButton Btn_NORTE=new JButton("Aceptar NORTE");
        add(Btn_NORTE,BorderLayout.NORTH); 
        JTextField Txt=new JTextField("200");
        add(Txt,BorderLayout.SOUTH);
        String [] Dias= {"Lun","Mar","Mie","Jue"};
        JComboBox CMB=new JComboBox(Dias);
        add(CMB,BorderLayout.EAST);
        setVisible(true);
        glass.setOpaque(true);
        glass.setVisible(true);
	}
	private void HazEscuchas() {
    	btnGlass.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent evt) { 
    			System.out.println("estoy tendiendo al botón del cristal");
    			glass.setVisible(false);
    		}
    	});
    	Btn.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent evt) { 
    			System.out.println("estoy tendiendo al botón de la pantalla");
    			Btn.setBackground(Color.PINK);

    		}
    	});		
	}
	
	public static void main(String [] a) {
		new Pan0V2();
		
	}
}
