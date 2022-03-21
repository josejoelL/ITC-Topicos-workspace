package material_clase;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Combos extends JFrame implements ItemListener{
	JComboBox cmbEdos,cmbCds,cmbCols;
	
	String [] edos= {"BC","BCS","Sonora","Sinaloa","Durango","Chihuahua","Nayarit","Colima","Jalisco","Michuacan"};
	String [][] cds= { 
			{"Tijuana","Mexicali","Tecate","Ensenada","Rosarito"},
			{"La Paz","Los Cabos","Cabos san Lucas","Esperanza"},
			{"Hermosillo","Guaymas","Obregon"},
			{"Culiacan","Mazatlan","LosMochis","Guasave"}
	};
	String [][][] cols= {

			{{"Col1","Col2","Col3"},{"Col4","Col5"},{"Col6"},{"Col7","Col8","Col9"},{"ros1","ros2"}  },
			{{"Col10","Col20","Col30"},{"Col40","Col50"},{"Col60"},{"Col70","Col8","Col9"}   },
			{ {"colher01","colher02"},{"colgua01","colgua02","colgua03"},{"colobr01"}                }  ,
			{},
			{}
			
		
	};
	public Combos() {
		super("Manejo de combos");
		HazInterfaz();
		HazEscuchas();
	}
	private void HazInterfaz() {
		setLayout(new GridLayout(0,2,5,5));
		setSize(400,200);
		setLocationRelativeTo(null);
		
		cmbEdos=new JComboBox(edos);
		cmbEdos.insertItemAt("SELECCIONE", 0);
		cmbEdos.setSelectedIndex(0);
		

		cmbCds=new JComboBox();
		cmbCols=new JComboBox();
		
		add(new JLabel("Estados",JLabel.RIGHT));
		add(cmbEdos);
		add(new JLabel("Ciudades",JLabel.RIGHT));
		add(cmbCds);
		add(new JLabel("Colonias",JLabel.RIGHT));
		add(cmbCols);
		setVisible(true);
	}
	private void HazEscuchas() {
		cmbEdos.addItemListener(this);
		cmbCds.addItemListener(this);
//		cmbCols.addItemListener(this);
	}
	public static void main(String [] a) {
		new Combos();
	}
	@Override
	public void itemStateChanged(ItemEvent evt) {
		if(evt.getStateChange()!=ItemEvent.SELECTED)
			return;
		
		
		if(evt.getSource()==cmbEdos) {
			System.out.println("*******"+cmbEdos.getSelectedItem());
			String Cadena=(String)cmbEdos.getSelectedItem();

			if(Cadena.compareTo("SELECCIONE")==0)
				return;
			int Estado=cmbEdos.getSelectedIndex()-1;
			cmbCds.removeItemListener(this);
			cmbCds.removeAllItems();
			cmbCols.removeAllItems();
			cmbCds.addItem("seleccione");
			for(int i=0 ; i< cds[Estado].length ; i++) {
				cmbCds.addItem(cds[Estado][i]);
			}
			cmbCds.addItemListener(this);
			return;
		}
		if(evt.getSource()==cmbCds) {
			String Cadena=(String)cmbEdos.getSelectedItem();
			if(Cadena.compareTo("SELECCIONE")==0)
				return;
			int Estado=cmbEdos.getSelectedIndex()-1;
			int Cd    =cmbCds.getSelectedIndex()-1;
			cmbCols.removeAllItems();
			for(int i=0 ; i< cols[Estado][Cd].length ; i++) {
				cmbCols.addItem(cols[Estado][Cd][i]); 
			}
			
		}
	
	}
}
