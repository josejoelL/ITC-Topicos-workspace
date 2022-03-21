package material_clase;
import javax.swing.*;import java.awt.*;import java.awt.event.*;
class FrameBoxLayoutBox extends JFrame {
	public FrameBoxLayoutBox() {
	    super("**BOXlayoutbox**"); 
	    setSize( 800, 500 );
	    setLocationRelativeTo(null);
        Box H=Box.createHorizontalBox();
        Box V=Box.createVerticalBox();
        JLabel Etiqueta1 = new JLabel("No.Control",SwingConstants.RIGHT);
        H.add(Etiqueta1);
        H.add(Box.createHorizontalStrut(10));
        JTextField NoControl=new JTextField(10);
        H.add(NoControl);
        JLabel Etiqueta2 = new JLabel("Nombre",SwingConstants.RIGHT);
        H.add(Box.createHorizontalStrut(10));
        H.add(Etiqueta2);
        JTextField Nombre=new JTextField(10);
        H.add(Box.createHorizontalStrut(10));
        H.add(Nombre);
        JButton Grabar=new JButton("Grabar");
        V.add(Grabar);
        V.add(Box.createVerticalStrut(10));
        JButton Cancelar=new JButton("Cancelar");
        V.add(Cancelar);
        V.add(Box.createVerticalStrut(10));
        V.add(new JButton("Limpiar"));
        V.add(Box.createVerticalStrut(10));
        add(H,BorderLayout.NORTH); 
        
        for(int i=0 ; i<20 ; i++) {
        	V.add(new JButton("Btn # "+(i+1)));
        	 V.add(Box.createVerticalStrut(10));
        }       
        add(V,BorderLayout.EAST);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String [] a) {
        new FrameBoxLayoutBox();
	}
}
