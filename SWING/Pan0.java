package material_clase;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Pan0 extends JFrame{
	JButton btnGlass;
    public Pan0() {
    	JPanel glass=(JPanel) getGlassPane();
    	
    	glass.add(new JLabel("***PRUEBA DEL CRISTAL DEL CONTENEDOR PRINCIPAL (JFRAME y JDIALOG)***"));
    	btnGlass=new JButton("CONTINUAR");
    	glass.add(btnGlass);
    	
    	btnGlass.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent evt) { 
    			System.out.println("estoy tendiendo al botón del cristal");
    			glass.setVisible(false);
    		}
    	});


    	//setLayout(new GridLayout(0,1));
        setSize(400,300);
        setTitle("PRIMER PANTALLA");
        setLocationRelativeTo(null);
        setResizable(false);
        
        JButton Btn=new JButton("Aceptar");
        add(Btn);
    	Btn.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent evt) { 
    			System.out.println("estoy tendiendo al botón de la pantalla");
    			Btn.setBackground(Color.PINK);

    		}
    	});     
        
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
	public static void main(String [] a) {
		new Pan0();
	}
}
