package Hanoi;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelMovimientos extends JPanel{
	
	private JLabel NumMovimientos;
	private JLabel Movimientos;
	
	
	
	PanelMovimientos(){
		setLayout(new GridLayout(0,2));
		
		JPanel msgBar = new JPanel(new GridLayout(1,2));
		msgBar.add(new JLabel("Movimientos:"));
		msgBar.add(Movimientos = new JLabel());
		Movimientos.setHorizontalAlignment(JLabel.LEFT);
		
		JPanel infoBar = new JPanel(new GridLayout(1, 4));
		infoBar.add(new JLabel("Numero de Movimientos :"));
		infoBar.add(NumMovimientos = new JLabel());
		NumMovimientos.setHorizontalAlignment(JLabel.LEFT);
		
		
		
		add(msgBar);
		add(infoBar);
		resetStatus();
	}
	public void resetStatus() {
	NumMovimientos.setText("0");
	Movimientos.setText("0");
	}
	public void setNumMovimientos(int x) {
		NumMovimientos.setText(Integer.toString(x));
	}
	public void Movimientos(int x) {
		Movimientos.setText(Integer.toString(x));
	}
	
}
