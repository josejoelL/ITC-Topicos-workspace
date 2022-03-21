package GRUD;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import clemente.Rutinas;
public class ConvertidorVista extends JFrame {
	
	private Window	Main,Sec;
	private JPanel Panelmain,Paneltabla;
	 JButton recuperar,grabar,borrar,modificar,BtnConsultas,BtnRegresa,consultarCtas;
	 JTextField txtRFC,txtNombre,txtedad,txtIdCiudad;
	 JTable tbl ;
	 DefaultTableModel modelo;
	private byte Sub=0;	
	String [] datos ={"W","X","Y","Z"};
	public ConvertidorVista(){
		super();
		HazInterfaz();
		
	}

	private void HazInterfaz(){
		UIManager.LookAndFeelInfo[] looks;
		String [] lookNames;
		looks = UIManager.getInstalledLookAndFeels();
		lookNames = new String [looks.length];
		for (int i = 0; i < lookNames.length; i++) {lookNames [i] = looks [i].getName();}
		try {UIManager.setLookAndFeel(looks[1].getClassName());} catch (Exception e) {}
		
		Main=new JFrame("***Mantenimiento al cátalogo de clientes GRUD***");
	
		Sec=new JDialog();
		Main.setSize(600,800);
		Main.setLocationRelativeTo(null);
		Sec.setSize(600,800);	
		Sec.setLocationRelativeTo(null);
	
		
		((JDialog) Sec).setModal(true);
		((JDialog) Sec).setTitle("CONSULTAS");
		((JDialog) Sec).setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		BtnConsultas=new JButton("consultar Clientes");
		BtnConsultas.setBackground(new Color(63,114,175));
		BtnConsultas.setForeground(Color.white); 
		BtnConsultas.setPreferredSize(new Dimension(80,100));
		Main.add(BtnConsultas,BorderLayout.SOUTH);
		
		BtnRegresa=new JButton("Regresa");
		BtnRegresa.setBackground(new Color(63,114,175));
		BtnRegresa.setForeground(Color.white); 
		BtnRegresa.setPreferredSize(new Dimension(80,100));
		Sec.add(BtnRegresa,BorderLayout.NORTH);
		
		Main.add(	Panelmain=new JPanel() );
		
		Panelmain.setLayout(new GridLayout(0,2,5,5));
		
		txtRFC=new JTextField(" capturar",20);
		txtRFC.setForeground(new Color(63,114,175)); 
		
		txtNombre=new JTextField(" capturar",20);
		txtNombre.setForeground(new Color(63,114,175)); 
		
		txtedad=new JTextField(" capturar",20);
		txtedad.setForeground(new Color(63,114,175)); 
		
		txtIdCiudad=new JTextField(" capturar",20);
		txtIdCiudad.setForeground(new Color(63,114,175)); 
		
		Panelmain.add(new JLabel("RFC",SwingConstants.RIGHT)).setForeground(new Color(249,247,247));
		Panelmain.add(txtRFC);
		
		Panelmain.add(new JLabel("Nombre",SwingConstants.RIGHT)).setForeground(new Color(249,247,247));
		Panelmain.add(txtNombre);
		
		Panelmain.add(new JLabel("Edad",SwingConstants.RIGHT)).setForeground(new Color(249,247,247));
		Panelmain.add(txtedad);
		
		Panelmain.add(new JLabel("id Ciudad",SwingConstants.RIGHT)).setForeground(new Color(249,247,247));
		Panelmain.add(txtIdCiudad);
		
		recuperar=new JButton("recuperar");
		recuperar.setBackground(new Color(63,114,175));
		recuperar.setForeground(Color.white); 
		Panelmain.add(recuperar );
		
		grabar=new JButton(" grabar");
		grabar.setBackground(new Color(63,114,175));
		grabar.setForeground(Color.white); 
		Panelmain.add( grabar);
			
		borrar=new JButton("borrar");
		borrar.setBackground(new Color(63,114,175));
		borrar.setForeground(Color.white); 
		Panelmain.add(borrar);
		
		modificar=new JButton("modificar");
		modificar.setBackground(new Color(63,114,175));
		modificar.setForeground(Color.white); 
		Panelmain.add( modificar);
	
		Panelmain.setBackground(new Color(17,45,78));
	
	
		 
	    Image icon = new ImageIcon(getClass().getResource("ico.png")).getImage();
	    Main.setIconImage(icon);
	    Sec.setIconImage(icon);
	
	    //AQUI AGREGO EL ARREGLO DE STRING XXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		Sec.add(Paneltabla=new JPanel());
			Paneltabla.setBackground(new Color(17,45,78));
		String [] col={"RFC","Nombre","Edad","ID Ciudad"};
		tbl = new JTable();
        modelo=new DefaultTableModel();
        modelo.setColumnIdentifiers(col);
        tbl.setModel(modelo);
        tbl.setSize(100, 100);
        //AQUI AGREGO EL ARREGLO DE STRING XXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		// datos={"W","X","Y","Z"};
		modelo.addRow(datos);		
		 //AQUI AGREGO EL ARREGLO DE STRING XXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		JScrollPane panel =new JScrollPane(tbl);
		Paneltabla.add(panel);
		
		Main.setVisible(true);
		Sec.setVisible(false);
	}

	public void setControlador(ConvertidorControlador C){
		
		BtnConsultas.addActionListener(C);
		BtnRegresa.addActionListener(C);
		Sec.addWindowListener(C);
		recuperar.addActionListener(C);
		grabar.addActionListener(C);
		borrar.addActionListener(C);
		modificar.addActionListener(C);
		
	}
	
	public String getRFC() {
		String RFC = null;
			RFC=txtNombre.getText();
		return RFC;
	}
	public String getNombre() {
		String Nombre = null;
			Nombre=txtNombre.getText();
		return Nombre;
	}
	public int getEdad() {
		int Edad=0;
		try{
			Edad=Integer.parseInt((txtedad.getText()));
		} catch (Exception E){
			
		}
		return Edad;
	}
	public int getIdCiudad() {
		int IdCiudad=0;
		try{
			IdCiudad=Integer.parseInt((txtIdCiudad.getText()));
		} catch (Exception E){	
		}
		return IdCiudad;
	}
	public void setTabla(Vector <formatoTabla>t) {
		modelo.fireTableDataChanged();	
		modelo.addRow(t);//le puedo agregar un vector completo
		/*
		modelo.addRow(datos);		

		for(int i=0 ; i<100 ; i++){

			datos[0]="Cod"+i;
			datos[1]=Rutinas.nextNombre(3);
			datos[2]=i+"";

			modelo.addRow(datos);	

		}*/
	
		
		
		
		
		
	//	 modelo.addRow(new Object[] {I.getRfc(),c.getNombre(), c.getEdad(), c.getIdCiudad() });
	}
	public void setInconveniente(int problema){
	
		switch (problema) {
		case 1:
			txtRFC.setText("RFC invalido");	
		case 2:
			txtNombre.setText("Nombre invalido");	
		case 3:
			txtedad.setText("edad invalido");	
		case 4:
			txtIdCiudad.setText("id Ciudad invalido");	
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + problema);
		}
		
	}
	public void setNombre(String nombre) {
	
			txtNombre.setText(nombre);
		
	}
	public void setEdad(int edad) {
		txtedad.setText(edad+"");
	}
	public void setidCiudad(int idCiudad) {
		txtIdCiudad.setText(idCiudad+"");
	}
	public void paginaSec(boolean cambiar) {
		if (cambiar) {
			
		Main.setVisible(false);
		Sec.setVisible(true);		
		}
		else
		Main.setVisible(true);
		Sec.setVisible(false);
	}

	

}
