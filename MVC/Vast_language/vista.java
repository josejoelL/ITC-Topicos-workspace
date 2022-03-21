package Vast_language;


import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
public class vista extends JFrame  implements ActionListener  {
	 JButton btnCont;
	private JLabel LblResultado;
	private JMenuBar mb;
	private JMenu    Archivos;
	private JMenuItem Abrir_Archivo,Guardar_Archivo;
	private JTextArea Txt, txtScan;
	private JPanel P1,P2,P3;
    Scrollbar S;
	public vista(){
		super("Vast");
		HazInterfaz();
	}
	private void HazInterfaz(){
		setSize(1400,720);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setResizable(false);
		 P1 = new JPanel();
		 P2 = new JPanel();
		 P3 = new JPanel();
		
			P1.setLayout(new GridLayout(0,2));
			P2.setLayout(new FlowLayout(FlowLayout.CENTER));
			P3.setLayout(new GridLayout(0,2,10,10));
			   setLayout(new BorderLayout());
			   
			   
			   
		btnCont=new JButton("contar");
		txtScan=new JTextArea();
			Txt=new JTextArea();
			Txt.setWrapStyleWord(true);
			txtScan.setWrapStyleWord(true);
			mb=new JMenuBar();
			Archivos=new JMenu("Archivos");
			Abrir_Archivo=new JMenuItem("Abrir Archivo");
			Guardar_Archivo=new JMenuItem("Guardar Archivo");
			Archivos.add(Abrir_Archivo);
			Archivos.add(Guardar_Archivo);
			mb.add(Archivos);
			
			this.setJMenuBar(mb);	
			
		
		P3.add(Txt);
		P3.add(txtScan);
		S=new Scrollbar(); 
		
		P1.add(new JLabel("  Codigo: ",SwingConstants.LEFT));
		
		P1.add(LblResultado=new JLabel("",SwingConstants.CENTER));
		add(P1,BorderLayout.NORTH);
		P2.add(btnCont);
		add(P2,BorderLayout.SOUTH);
		add(P3,BorderLayout.CENTER);
	
		setVisible(true);
	}
	public void setControlador(controlador C){
		
		btnCont.addActionListener(C);
		Abrir_Archivo.addActionListener(this);
		Guardar_Archivo.addActionListener(this);
	}
	public String getTexto() {
		return Txt.getText();
	}
	
	
	public void setResultado(int palabras){
		LblResultado.setText(palabras+"");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Guardar_Archivo){
			FileDialog fileDialog = new FileDialog(this,"Guardar", FileDialog.SAVE);
			System.out.println("****"+fileDialog.getName());
            fileDialog.setSize(400,400);
            fileDialog.setVisible(true);
            
            return;
		}
		if(e.getSource()==Abrir_Archivo){
			FileDialog fileDialog = new FileDialog(this,"Abrir", FileDialog.LOAD);
			System.out.println("****"+fileDialog.getName());
			fileDialog.setSize(400,400);
			fileDialog.setVisible(true);
			
			
			
			FileReader f=null;
			BufferedReader b = null;
			try {
				 f = new FileReader(fileDialog.getFile());
				 b = new BufferedReader(f);
	
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
					try {
						Txt.setText(b.readLine());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			
			
            
            return;
		}
		
	}
}
