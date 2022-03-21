package clemente;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class PESTAÑAS extends JFrame implements ActionListener {
	JPanel Panel1, Panel2, Panel3,Panel4;
	JButton BtnGira,BtnArchivo;
	JLabel LblTexto;
	JScrollPane JS;
	Timer T;
	private PESTAÑAS(){
		super("Manejo de pestañas");
		HazInterfaz();
		HazEscuchas();
		T=new Timer(100,this);
	}
	private void HazInterfaz(){
		
		UIManager.LookAndFeelInfo[] looks;
		String [] lookNames;
		looks = UIManager.getInstalledLookAndFeels();
		lookNames = new String [looks.length];
		for (int i = 0; i < lookNames.length; i++) {lookNames [i] = looks [i].getName();}
		try {UIManager.setLookAndFeel(looks[3].getClassName());} catch (Exception e) {}
		
		
		setSize(600,300);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane P=new JTabbedPane();
		Panel1=new JPanel();
		Panel1.setLayout(new GridLayout(0,8));
		for(int i=0; i<170 ; i++){
			Panel1.add(new JButton((i+1)+""));
		}
		JS=new JScrollPane(Panel1);

		Panel2=new JPanel();
		Panel2.setLayout(new GridLayout(0,2,5,5));
		for(int i=0 ; i<10; i++){
			Panel2.add(new JLabel("Dato # "+(i+1), SwingConstants.RIGHT));
			Panel2.add(new JTextField());
		}
		Panel3=new JPanel();
		Panel4=new JPanel();
		P.addTab("Datos Generales", Rutinas.AjustarImagen("DG.GIF",40,30), JS, "información del empleado");

		P.addTab("Finanzas", Rutinas.AjustarImagen("BILLETES.JPG",40,30), Panel2, "situación económica");

		P.addTab("Abrir archivo", null, Panel3, "FileDialog");
		Panel3.add(BtnArchivo=new JButton("Abrir archivo"));
		Panel4.setLayout(new BorderLayout());
		P.addTab("Texto", null, Panel4, "Texto Girando");		
		Panel4.add(BtnGira=new JButton("Gira Texto"),BorderLayout.NORTH);
		Panel4.add(LblTexto=new JLabel("Este es el texto que quiero que gire for ever",SwingConstants.CENTER),BorderLayout.SOUTH);

		add(P);
	//	P.setSelectedIndex(2);
		setVisible(true);
		
	}
	private void HazEscuchas(){
		BtnGira.addActionListener(this);
		BtnArchivo.addActionListener(this);
	}
	public static void main(String[] args) {
		new PESTAÑAS();
	}
	@Override
	public void actionPerformed(ActionEvent Evt) {
		
		if(Evt.getSource()==BtnGira){
//			Temporizador Obj=new Temporizador("EJEMPLO DE UN TEMPORIZADOR  ");
//			Obj.setVisible(true);
			T.start();
			return;
		
		}
		if(Evt.getSource()==BtnArchivo){
			FileDialog fileDialog = new FileDialog(this,"Guardar", FileDialog.SAVE);
			System.out.println("****"+fileDialog.getName());
            fileDialog.setSize(400,400);
            fileDialog.setVisible(true);
            
            return;

		}
		if(Evt.getSource()==T){
			String Texto=LblTexto.getText();
		    LblTexto.setText(Texto.substring(1)+Texto.charAt(0));	
		    
		    
		}
	}

}
