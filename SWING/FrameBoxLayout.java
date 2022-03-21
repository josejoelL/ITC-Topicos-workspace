package material_clase;

import javax.swing.*; import java.awt.*; import java.awt.event.*;
class FrameBoxLayout extends JFrame {
	public FrameBoxLayout() {
		super("**Box**");
		// el marco por default tiene BorderLayout
		setSize( 500, 150 );
		setLocationRelativeTo(null);
		JPanel Panel1=new JPanel();
		Panel1.setLayout(new BoxLayout(Panel1,BoxLayout.Y_AXIS));
		JPanel Panel2=new JPanel();
		Panel2.setLayout(new BoxLayout(Panel2,BoxLayout.X_AXIS));
		Panel1.add(new JButton("Aceptar"));
		Panel1.add(new JButton("Cancelar"));
		Panel1.add(new JButton("Salir")); 
		add(Panel1,BorderLayout.EAST);
		Panel2.add(new JLabel("Nombre"));
		Panel2.add(new JTextField(10));
		Panel2.add(new JLabel("Sexo"));
		Panel2.add(new JTextField(2));
		
		Panel2.add(new JButton("btn1"));
		Panel2.add(new JButton("btn2"));
		Panel2.add(new JButton("btn3"));
		Panel2.add(new JButton("btn4"));
		Panel2.add(new JButton("btn5"));
		Panel2.add(new JButton("btn1"));
		Panel2.add(new JButton("btn2"));
		Panel2.add(new JButton("btn3"));
		Panel2.add(new JButton("btn4"));
		Panel2.add(new JButton("btn5"));
		
		add(Panel2,BorderLayout.CENTER);
		JPanel Panel3=new JPanel();
		Panel3.setLayout(new BoxLayout(Panel3,BoxLayout.Y_AXIS));
		JRadioButton Radio1=new JRadioButton("Mascúlino");
		JRadioButton Radio2=new JRadioButton("Femenino");
		Panel3.add(new JLabel("Seleccione sexo"));
		Panel3.add(Radio1);  
		Panel3.add(Radio2);
		add(Panel3,BorderLayout.WEST);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String [] a) {
		new FrameBoxLayout();

	}
}

