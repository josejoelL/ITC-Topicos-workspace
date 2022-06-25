package mini_java;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import java.awt.Scrollbar;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.LineBorder;
public class vista extends JFrame  implements ActionListener,MouseListener  {
	private JButton btnCont,btnMenu,btnLexico,btnSemantico,btnSintactico,btnEjecuta,btnCierra,btnMin,btnMax;
	private JLabel LblResultado;
	private JMenuBar mb;
	private JMenu    Archivos;
	private JMenuItem Abrir_Archivo,Guardar_Archivo;
	private JTextArea Txt, txtScan;
	private JLabel Llexico,LSemantico,LSintactico;
	private JPanel P1,P2,P3,Pmenu1,Pmenu2,PmenuGrid,PbarHorizontal,PLexico,PSemantico,PSintactico,Ptxt,Pindex;
	
	private JButton [] indexButton;
	private JLabel []  indexLabel;
	
	
	private Window Main;
	private GridLayout GridMenu,GridPaneles;
	private FlowLayout MenuNorte1,MenuNorte2;

    JScrollPane  JS,JSlexico,JSsemantico,JSsimantico;
    private UIManager.LookAndFeelInfo[] looks;
	private String [] lookNames;
    
	

	 private Dimension dim;
	 
	public vista(){
		super("Identificador de codigo");
		HazInterfaz();
	}
	private void HazInterfaz(){
		UIWindows_10();
				
		setSize(1400/2,720);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setResizable(false);
		
		
				
		 P1 = new JPanel();
		 P2 = new JPanel();
		 setP3(new JPanel());
		 Pmenu1 = new JPanel();
		 Pmenu2 = new JPanel();
		 PmenuGrid = new JPanel();
		 setPLexico(new JPanel());
		 PSemantico = new JPanel();
		 PSintactico = new JPanel();
		 Ptxt = new JPanel();
		 Pindex = new JPanel();
		 GridPaneles = new GridLayout(1,2,10,10);
		 
			P1.setLayout(new GridLayout(8,1));
			P2.setLayout(new BorderLayout());
			getP3().setLayout(GridPaneles);
			Ptxt.setLayout(new BorderLayout());
			Pindex .setLayout( new GridLayout(0,1));
			   setLayout(new BorderLayout());
			PmenuGrid.setLayout(new GridLayout(1,2));
			   MenuNorte2 = new FlowLayout(FlowLayout.RIGHT);
			   MenuNorte1 = new FlowLayout(FlowLayout.LEFT);
			   Pmenu1.setLayout(MenuNorte1);
			   Pmenu2.setLayout(MenuNorte2);
			  // Pmenu1.setBackground(new Color(30, 81, 40));
			  // Pmenu2.setBackground(new Color(30, 81, 40));
			   
			   PbarHorizontal =(JPanel) this.getGlassPane(); 
			   PbarHorizontal.setLayout(new GridLayout(0,5));
				 
			   
			   //•••
			   btnLexico=new JButton("<html><body>\r\n"
			   		+ "\r\n"
			   		+ "<p style=\"color:blue;font-size:15px;\">Analisis Lexico</p>\r\n"
			   		+ "\r\n"
			   		+ "</body>\r\n"
			   		+ "</html>");
			   btnLexico.setBorderPainted(false);
			   btnSemantico=new JButton("<html><body>"
			   		+ "<p style=\"color:red;font-size:15px;\">Analisis Semantico</p"
			   		+ "</body></html>");//Analisis Semantico
			 btnSemantico.setBorderPainted(false);
			   btnSintactico=new JButton("<html><body>"
			   		+ "<p style=\"color:green;font-size:15px;\">Analisis sintactico</p>"
			   		+ "</body></html>");//Analisis Sintactico
			  btnSintactico.setBorderPainted(false);
			   btnCont=new JButton("contar");
			   btnMenu=new JButton(
					  "<html><body>"
			   		+ "<span style=\"color:blue;font-size:16px;\">a</span>"
			   		+"<span style=\"color:red;font-size:16px;\">b</span>"
			   		+"<span style=\"color:green;font-size:16px;\">c</span>"
			   		+ "</body></html>"
			   		);
			   btnMenu .setFocusPainted(false);
			   btnMenu.setBorderPainted(false);
			   setBtnEjecuta(new JButton(
					  "<html><body>"
				   	+ "<p style=\"color:green;font-size:16px;\"> ► </p>"
				 	+ "</body></html>"
				   	));
			   getBtnEjecuta().setBorderPainted(false);
			   //button.setFocusable(false)
			   btnCierra =new JButton(
						  "<html><body>"
								   	+ "<p style=\"color:red;font-size:16px;\"> ✕ </p>"
								 	+ "</body></html>"
								   	);
			   
			   btnCierra.setBorderPainted(false);
			   btnMin =new JButton(
						  "<html><body>"
								   	+ "<p style=\"color:green;font-size:16px;\"> ─ </p>"
								 	+ "</body></html>"
								   	);
			   btnMin.setBorderPainted(false);
			  
			   btnMax =new JButton(
						  "<html><body>"
								   	+ "<p style=\"color:green;font-size:16px;\"> ☐ </p>"
								 	+ "</body></html>"
								   	);
			   btnMax .setBorderPainted(false);
			  
		txtScan=new JTextArea();

		Llexico =new JLabel("<html><p style=\"font-size:10px;\">lexico</p><body>");
		Llexico.setForeground(Color.white);
		getPLexico().setBackground(Color.darkGray);
		
		LSemantico =new JLabel("<html><p style=\"font-size:10px;\">Semantico</p><body>");
		LSemantico.setForeground(Color.white);
		PSemantico.setBackground(Color.black);
		
		LSintactico =new JLabel("<html><p style=\"font-size:10px;\">Sintactico</p><body>");
		LSintactico.setForeground(Color.white);
		PSintactico.setBackground(Color.blue);
		
		 getPLexico().add(Llexico);
		 PSemantico.add(LSemantico);
		 PSintactico.add(LSintactico);
		 
		 
		 
		 
			setTxt(new JTextArea());
			getTxt().setFont(new Font("arial", 1, 38));
			getTxt().setWrapStyleWord(true);
			txtScan.setWrapStyleWord(true);
			
			mb=new JMenuBar();
			Archivos=new JMenu("Archivos");
			setAbrir_Archivo(new JMenuItem("Abrir Archivo"));
			setGuardar_Archivo(new JMenuItem("Guardar Archivo"));
			Archivos.add(getAbrir_Archivo());
			Archivos.add(getGuardar_Archivo());
			mb.add(Archivos);
			mb.setBackground(Color.YELLOW);
			
			Ptxt.add(mb,BorderLayout.NORTH);
			//this.setJMenuBar(mb);	
			//p3 es el del texto
		
		//P3.add(Txt);
		//P3.add(txtScan);
		//P3.add(Identficador);
	//	S=new Scrollbar(); 
			nuevoIndex(14);
		
			
			
		JS=new JScrollPane(getTxt());
		JS.createHorizontalScrollBar();
		Ptxt.add(JS);
		Ptxt.add(Pindex,BorderLayout.WEST);
		getP3().add(Ptxt);
		//P1.add(new JLabel("  Codigo: ",SwingConstants.LEFT));
		//P1.add(LblResultado=new JLabel("",SwingConstants.CENTER));
		//P1.setBackground(new Color(30, 81, 40));
		P1.add(btnLexico);
		P1.add(btnSemantico);
		P1.add(btnSintactico);
		//add(P1,BorderLayout.NORTH);
		PbarHorizontal.add(P1);
		add(PmenuGrid,BorderLayout.NORTH);
		PmenuGrid.add(Pmenu1 );
		PmenuGrid.add(Pmenu2 );
		Pmenu1.add(btnMenu);//btnCont
		Pmenu1.add(getBtnEjecuta());
		Pmenu2.add(btnMin);
		Pmenu2.add(btnMax);
		Pmenu2.add(btnCierra);
		add(P2,BorderLayout.SOUTH);
		add(getP3(),BorderLayout.CENTER);
		setUndecorated(true);

		setVisible(true);
	}
	private void nuevoIndex(int size) {
		//int size = Txt.getRows()!=0 ? Txt.getRows() : 14;
		indexLabel = new JLabel[size];
		Pindex.removeAll();
		//System.out.println(Txt.getRows());
		for (int i = 0; i < indexLabel.length; i++) {
			indexLabel[i] = new JLabel((i+1) + "", SwingConstants.RIGHT);
			indexLabel[i].setFont(new Font("arial", 0, 16));
			indexLabel[i].setForeground(Color.DARK_GRAY);
			Pindex.add(indexLabel[i]);
		
		}
		
	}
	private void UIWindows_10() {
		looks = UIManager.getInstalledLookAndFeels();
		lookNames = new String [looks.length];
		//for (int i = 0; i < lookNames.length; i++) {lookNames [i] = looks [i].getName();}
		try {UIManager.setLookAndFeel(looks[3].getClassName());} catch (Exception e) {}
	}

	public void setControlador(controlador C){
		getTxt().addKeyListener(C);
		//txtScan.addKeyListener(C);

		getBtnEjecuta().addActionListener(C);
		btnCont.addActionListener(C);
		getAbrir_Archivo().addActionListener(C);
		getGuardar_Archivo().addActionListener(C);
		
		
		btnMenu.addActionListener(this);
		btnLexico.addActionListener(this);
		/**
		btnSemantico.addActionListener(this);
		btnSintactico.addActionListener(this);
		*/
		btnCierra.addActionListener(this);
		btnMax.addActionListener(this);
		btnMin.addActionListener(this);
		
		btnSemantico.addMouseListener(this);
		btnSintactico.addMouseListener(this);
		btnLexico.addMouseListener(this);
		btnCierra.addMouseListener(this);
		btnMax.addMouseListener(this);
		btnMin.addMouseListener(this);
		getBtnEjecuta().addMouseListener(this);
		btnMenu.addMouseListener(this);
	}
	public String getTexto() {
		return getTxt().getText();
	}
	public JTextArea getTxtScan() {
		return getTxt();
	}
	public void setTxtScan(JTextArea Txt) {
		this.setTxt(Txt);
	}
	public JLabel getIdentficador() {
		return Llexico;
	}
	public void setIdentficador(JLabel identficador) {
		Llexico = identficador;
	}
	public void setResultado(int palabras){
		LblResultado.setText("Cantidad de palabras : "+palabras+"");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnMenu){
			PbarHorizontal.setVisible(true);
            
            return;
		}
		if(e.getSource()==btnLexico){
			
			getP3().add(getPLexico());
			
			
			PbarHorizontal.setVisible(false);
            
            return;
		}
		if(e.getSource()==btnSemantico){
			getP3().add(PSemantico);
			PbarHorizontal.setVisible(false);
            
            return;
		}
		if(e.getSource()==btnSintactico){
		//	GridPaneles.setColumns(2);
		//GridPaneles.setRows(2);
			P2.add(PSintactico);
			PbarHorizontal.setVisible(false);
            return;
		}   
		if(e.getSource()==btnCierra){
			System.exit(0);
			
			return;
		}
		if(e.getSource()==btnMax){
			 if (getLocation().x!=0) {
			dim=super.getToolkit().getScreenSize();
			 super.setSize(dim);
			 
			 setLocation(0,0);
			 return;
			 }
			 if (getLocation().x==0) {
				 setSize(1400/2,720);
				 setLocationRelativeTo(null);
			}
		//	setLocationRelativeTo(Abrir_Archivo);
			 nuevoIndex(17);
			 revalidate();
			return;
		}
		if(e.getSource()==btnMin){
			setState(this.ICONIFIED);


		}
		
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		JButton Aux=(JButton) e.getSource();
		Aux.setFocusPainted(false);
		Aux.setBackground(Color.gray);
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		JButton Aux=(JButton) e.getSource();
		Aux.setFocusPainted(false);
		Aux.setBackground(Color.LIGHT_GRAY);
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		JButton Aux=(JButton) e.getSource();
		Aux.setFocusPainted(false);
		Aux.setBackground(Color.LIGHT_GRAY);
		
		

	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		JButton Aux=(JButton) e.getSource();
		Aux.setBackground(null);

	}
	public JMenuItem getGuardar_Archivo() {
		return Guardar_Archivo;
	}
	public void setGuardar_Archivo(JMenuItem guardar_Archivo) {
		Guardar_Archivo = guardar_Archivo;
	}
	public JMenuItem getAbrir_Archivo() {
		return Abrir_Archivo;
	}
	public void setAbrir_Archivo(JMenuItem abrir_Archivo) {
		Abrir_Archivo = abrir_Archivo;
	}
	public JTextArea getTxt() {
		return Txt;
	}
	public void setTxt(JTextArea txt) {
		Txt = txt;
	}
	public JButton getBtnEjecuta() {
		return btnEjecuta;
	}
	public void setBtnEjecuta(JButton btnEjecuta) {
		this.btnEjecuta = btnEjecuta;
	}
	public JPanel getP3() {
		return P3;
	}
	public void setP3(JPanel p3) {
		P3 = p3;
	}
	public JPanel getPLexico() {
		return PLexico;
	}
	public void setPLexico(JPanel pLexico) {
		PLexico = pLexico;
	}
}








