package componentes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class ListaMexico extends JPanel implements ComponentListener,ItemListener,ActionListener{
	private int x,y,w,h;
	private JComboBox<String>   CmbEst,CmbMun,CombCiu;
	String [] E= {"Selecccione","BCS","BC","SONORA","SINALOA",
			"DURANGO","CHIHUAHUA","nayarit","jalisco","colima","michoacan"};
	String [][] M={{"CD1","CD2","CD3","CD4","CD5"},
			{"CD6","CD7","CD8","CD9"},
			{"CD10","CD11"},
			{"CD12"},
			{"CD13","CD14","CD15"},
			{},
			{}};
	String [][][] C={
			{{"Col1","Col2","Col3"},{"Col4","Col5"},{"Col6"},{"Col7","Col8","Col9"}   },
			{},
			{},
			{}
			};	
	public ListaMexico(){
		HazInterfaz();
		HazEscuchas();
	}
	private void HazInterfaz(){
		setLayout(null);
		this.setPreferredSize(new Dimension(100,100));
		//this.setSize(100,100);
		
		
		this.setBorder(new LineBorder(Color.cyan));
		
		w = getWidth();
		h = getHeight();

//			vc[i].setSize(w-20,20);
//			vc[i].setLocation(10,5+i*20);
//			add(vc[i]);
		CmbEst = new JComboBox<String>(E);
		CmbMun = new JComboBox<String>();
		CombCiu = new JComboBox<String>();

		CmbEst.setEditable(true);
		
	}
	private void HazEscuchas(){
	
		
		CmbEst.addItemListener(this); 
		CmbMun.addItemListener(this); 
		//CombCiu.addItemListener(this); 
			this.addComponentListener(this);
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void componentMoved(ComponentEvent e) {
		
		x = getX();
		y = getY();
	}
	@Override
	public void componentResized(ComponentEvent e) {
		//this.removeAll();
		w = getWidth();
		h = getHeight();
		CmbEst.setSize((int) (w*0.80),(int) (h*0.25));
		CmbEst.setLocation( (int)(w*0.10),(int)(h*0.10) );
		add(CmbEst);
		
		CmbMun.setSize((int) (w*0.80),(int) (h*0.25));
		CmbMun.setLocation( (int)(w*0.10 ),(int)(h*0.40));
		add(CmbMun);
		
		CombCiu.setSize((int) (w*0.80),(int) (h*0.25));
		CombCiu.setLocation( (int)(w*0.10 ),(int)(h*0.70));
		add(CombCiu);
	
	}
	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
//		if(e.getStateChange()!=ItemEvent.SELECTED)
//			return;
		System.out.println("click en combo de estados");
		int Estado=CmbEst.getSelectedIndex()-1;
		if(e.getSource()==CmbEst){
		
			if(Estado==-1)
				return;

			CmbMun.removeItemListener(this);

			CmbMun.removeAllItems();
			CmbMun.addItem("Seleccione");
			CmbMun.removeAllItems();
			
				
			for(int i=0 ; i<M[Estado].length;i++){
				CmbMun.addItem(M[Estado][i]);
			}
			CmbMun.addItemListener(this);
			return;
		}
		if(e.getSource()==CmbMun){
			int Mun=CmbMun.getSelectedIndex()-1;
			CombCiu.removeAllItems();
			CombCiu.addItem("Seleccione");
	System.out.println("Estado= "+Estado+" Ciudad "+Mun);
			for(int i=0 ; i<C[Estado][Mun].length ; i++){
				CombCiu.addItem(C[Estado][Mun][i]);
				
			}
			
		}
	}
	
	
	
	
	
	
}
