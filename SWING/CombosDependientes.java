package clemente;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class CombosDependientes extends JFrame implements ItemListener,ActionListener {
	JPanel PanelRadios,PanelCombos;
	JTextField TxtId;
	JButton    BtnAvion,BtnTrilladora;
	JRadioButton RSoltero,RCasado;
	JComboBox   CmbEstados,CmbCiudades,CmbColonias;
	ButtonGroup Gpo;
	
	private UIManager.LookAndFeelInfo[] looks;
	private String [] lookNames;
	private JRadioButton [] radio;
	private ButtonGroup group;
	private JButton button;
	private JLabel label;
	
	
	
	
	
	String [] ve={"Selecccione","BCS","BC","SONORA","SINALOA",
			"DURANGO","CHIHUAHUA","nayarit","jalisco","colima","michoacan"};
	String [][] vc={{"CD1","CD2","CD3","CD4","CD5"},
			{"CD6","CD7","CD8","CD9"},
			{"CD10","CD11"},
			{"CD12"},
			{"CD13","CD14","CD15"},
			{},
			{}};
private String [][][] vcolonias ={
{{"Col1","Col2","Col3"},{"Col4","Col5"},{"Col6"},{"Col7","Col8","Col9"}   },
{},
{},
{}
};	
	
	
	public CombosDependientes(){
		super("Manejo combos radio button y botones co n imagen");
		HazInterfaz();
		HazEscuchas();
	}
	public void HazInterfaz(){
		setSize(750,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	setResizable(false);
		setLayout(new GridLayout(0,2,10,10));
		PanelRadios=new JPanel();
		PanelCombos=new JPanel();
		PanelRadios.setLayout(new GridLayout(0,1));
		PanelCombos.setLayout(new GridLayout(0,1,0,3));
		TxtId=new JTextField(20);
//		BtnAvion=new JButton("Aceptar",new ImageIcon("Avion.png"));
//		BtnTrilladora=new JButton(new ImageIcon("Maquina.gif"));
//		BtnAvion=new JButton("Aceptar",Rutinas.AjustarImagen("Avion.PNG", 80, 60));
//		BtnTrilladora=new JButton(Rutinas.AjustarImagen("Maquina.GIF", 80, 60));
		BtnAvion=new JButton();
		BtnTrilladora=new JButton();

		
		RSoltero=new JRadioButton("Soltero");
		RCasado=new JRadioButton("Casado");
		CmbEstados=new JComboBox<String>(ve);
		CmbCiudades=new JComboBox<String>();
		CmbColonias=new JComboBox<String>();
		
		Gpo=new ButtonGroup();
		Gpo.add(RSoltero);
		Gpo.add(RCasado);
		PanelRadios.add(RSoltero);
		PanelRadios.add(RCasado);
		PanelCombos.add(CmbEstados);
		PanelCombos.add(CmbCiudades);
		PanelCombos.add(CmbColonias);
		
		add(new JLabel("Id",SwingConstants.RIGHT));
		add(TxtId);
		add(new JLabel("Estado civil",SwingConstants.RIGHT));
		add(PanelRadios);
		add(new JLabel("edo-ciu-col",SwingConstants.RIGHT));
		add(PanelCombos);
	
		add(BtnAvion);
		add(BtnTrilladora);
		CmbEstados.setEditable(true);
		setVisible(true);
		BtnAvion.setIcon(Rutinas.AjustarImagen("Avion.PNG", BtnAvion.getWidth(), BtnAvion.getHeight()));
		
		
		
		looks = UIManager.getInstalledLookAndFeels();
		lookNames = new String [looks.length];
		
		for (int i = 0; i < lookNames.length; i++) {
			lookNames [i] = looks [i].getName();
		}
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(3,1));
		label = new JLabel(lookNames[3]);
		northPanel.add(label);
		add(northPanel);
		
		
		try {
			//UIManager.setLookAndFeel(null);
			UIManager.setLookAndFeel(looks[3].getClassName());
			SwingUtilities.updateComponentTreeUI(this);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
	}
	
	public void HazEscuchas(){
		CmbEstados.addItemListener(this);
		CmbCiudades.addItemListener(this);
		
		BtnTrilladora.addActionListener(this);
	}
	
	public static void main(String [] a){
		new CombosDependientes();
	}
	
	public void itemStateChanged(ItemEvent Evt) {
		if(Evt.getStateChange()!=ItemEvent.SELECTED)
			return;
		System.out.println("click en combo de estados");
		int Estado=CmbEstados.getSelectedIndex()-1;
		if(Evt.getSource()==CmbEstados){
		
			if(Estado==-1)
				return;

			CmbCiudades.removeItemListener(this);

			CmbCiudades.removeAllItems();
			CmbCiudades.addItem("Seleccione");
			CmbColonias.removeAllItems();
			
				
			for(int i=0 ; i<vc[Estado].length;i++){
				CmbCiudades.addItem(vc[Estado][i]);
			}
			CmbCiudades.addItemListener(this);
			return;
		}
		if(Evt.getSource()==CmbCiudades){
			int Ciudad=CmbCiudades.getSelectedIndex()-1;
			CmbColonias.removeAllItems();
			CmbColonias.addItem("Seleccione");
	System.out.println("Estado= "+Estado+" Ciudad "+Ciudad);
			for(int i=0 ; i<vcolonias[Estado][Ciudad].length ; i++){
				CmbColonias.addItem(vcolonias[Estado][Ciudad][i]);
				
			}
			
		}
	}
	@Override
	public void actionPerformed(ActionEvent Evt) {
		if(Evt.getSource()==BtnTrilladora){
			BtnTrilladora.setIcon(Rutinas.AjustarImagen("Maquina.GIF", BtnTrilladora.getWidth(), BtnTrilladora.getHeight()));
			BtnAvion.setEnabled(false);
			BtnAvion.setDisabledIcon(Rutinas.AjustarImagen("Avion.png", BtnAvion.getWidth(), BtnAvion.getHeight()));
			return;
			
		}
		
	}
}
