package Hanoi;
import java.awt.GridLayout;
import javax.swing.*;

import m.StatusPanel;
import m.ToolbarPanel;

public class Vista extends JFrame {
	PanelMovimientos MovPanel;
	PanelOpciones OpPanel;

	
	public Vista(){
		super("torres de hanoi");
		HazInterfaz();
	}
	private void HazInterfaz(){
		setSize(700,700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		setVisible(true);
	}



}
