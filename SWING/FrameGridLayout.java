package clemente;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

class FrameGridLayout extends JFrame implements ActionListener, 
												FocusListener,
												KeyListener{
	JTextField NoControl,Nombre;
	private JButton BtnLimpiar,BtnGrabar;
	private JCheckBox [] Cara;
	private Color FondoTxt;
	public FrameGridLayout() {
		super("**Grid**"); 
		HazInterfaz();
		HazEscuchadores();
	}
	public void HazEscuchadores(){
		BtnLimpiar.addActionListener(this);
		BtnGrabar.addActionListener(this);
		for(byte i=0 ; i<Cara.length ; i++)
		   Cara[i].addActionListener(this);
		
		Nombre.addActionListener(this);
		Nombre.addKeyListener(this);
		Nombre.addFocusListener(this);
		
		NoControl.addActionListener(this);
		NoControl.addKeyListener(this);
		NoControl.addFocusListener(this);
		
	}
	public void HazInterfaz(){
		Nombre=new JTextField(20);
		Cara=new JCheckBox[4];
		setLayout(new GridLayout(0,2,5,0));
		setSize( 350, 350 );
		setLocationRelativeTo(null);
		JLabel Etiqueta1 = new JLabel("No.Control",SwingConstants.RIGHT);
		add(Etiqueta1);
		NoControl=new JTextField(10);
		FondoTxt=NoControl.getBackground();
		add(NoControl);
		JLabel Etiqueta2 = new JLabel("Nombre",SwingConstants.RIGHT);
		add(Etiqueta2);
		add(Nombre);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String [] Cds={"Culiacan","Mazatlan","Guasave","Los Mochis"};

		add(new JLabel("Ciudades",SwingConstants.RIGHT));
		add(new JComboBox(Cds));
		JPanel Panel=new JPanel();
		Panel.setLayout(new GridLayout(0,1));
		Panel.add(Cara[0]=new JCheckBox("90-60-90",true));
		Panel.add(Cara[1]=new JCheckBox("rubia"));
		Panel.add(Cara[2]=new JCheckBox("millonaria"));
		add(new JLabel("CARACTERISTICAS",SwingConstants.RIGHT));
		add(Panel);
		BtnGrabar=new JButton("Grabar");
		add(BtnGrabar);
		BtnLimpiar=new JButton("Limpiar");
		add(BtnLimpiar);          

		setVisible(true); 
		//  this.setResizable(false);
		Panel.add(Cara[3]=new JCheckBox("Soltera"));
		

	}
	public static void main(String [] a) {
		new FrameGridLayout();      
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==BtnLimpiar){
		   Nombre.setText("");
		   NoControl.setText("");
		   NoControl.requestFocus();
		   for(byte i=0 ; i<Cara.length ; i++)
			   Cara[i].setSelected(false);
		   
		   return;
		}
		if(e.getSource()==BtnGrabar){
			
			
			return;
		}
		if(e.getSource()==Cara[1]){
			Cara[2].setSelected(true);
			return;
			
			
		}
		if(e.getSource()==NoControl){
			String Texto=NoControl.getText();
			if(Texto.length()==0){
				JOptionPane.showMessageDialog(null,
						"No se permite no control vacío", "ISC",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(Texto.length()>3){
				JOptionPane.showMessageDialog(null,
						"No se permite no control con mas de tres dígitos", "ISC",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			int Numero=Integer.parseInt(Texto);
			if(Numero<100 || Numero>200){
				JOptionPane.showMessageDialog(null,
						"No control fuera de rango (100-200)", "ISC",
						JOptionPane.ERROR_MESSAGE);
				return;
				
				
			}
			Nombre.requestFocus();
			return;
		}
		if(e.getSource()==Nombre){
			String Texto=Nombre.getText();
			if(Texto.length()>20){
				System.out.println("El nombre no debe ser tan largo");
				Nombre.selectAll();
				Nombre.requestFocus();
				return;
			}
			return;
		}
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		System.out.println("preionado");
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		System.out.println("liberado");
		
	}
	@Override
	public void keyTyped(KeyEvent Evt) {

		
		char Car=Evt.getKeyChar();
		if( "0123456789".indexOf(Car)==-1 ){
			Evt.consume();
			return;
		}

		
	}
	@Override
	public void focusGained(FocusEvent Evt) {
		System.out.println("tomo el foco");
		JTextField Aux=(JTextField) Evt.getSource();
		Aux.setBackground(Color.lightGray);
		
	}
	@Override
	public void focusLost(FocusEvent Evt) {
		System.out.println("perdió el foco");

		JTextField Aux=(JTextField) Evt.getSource();
		Aux.setBackground(FondoTxt);		
	}
}
