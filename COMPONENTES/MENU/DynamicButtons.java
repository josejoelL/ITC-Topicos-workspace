package Menu;


	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
public class  DynamicButtons {

	  
	        final JPanel gui = new JPanel(new BorderLayout());

	        final JPanel gridButton = new JPanel(new GridLayout(0,1,2,2));
	        gridButton.add(new JButton("Button 1"));
	        JPanel gridConstrain = new JPanel(new BorderLayout());
	        gridConstrain.add(gridButton, BorderLayout.NORTH);

	        final Box boxButton = Box.createVerticalBox();
	        boxButton.add(new JButton("Button 1"));

	        JButton b = new JButton("Add Button");
	        
	        
	        b.addActionListener( new ActionListener() {
	            int count = 2;
	            public void actionPerformed(ActionEvent ae) {
	                gridButton.add(new JButton("Button " + count));

	                boxButton.add(new JButton("Button " + count));

	                count++;
	                gui.revalidate();
	            }
	        });

	        gui.add(b, BorderLayout.NORTH);
	        
	        
	        
	        JSplitPane sp = new JSplitPane(
	            JSplitPane.HORIZONTAL_SPLIT,
	            new JScrollPane(gridConstrain),
	            new JScrollPane(boxButton));
	        gui.add(sp, BorderLayout.CENTER);

	        gui.setPreferredSize(new Dimension(250,150));

	        JOptionPane.showMessageDialog(null, gui);
	  
}	
	public static void main(String[] args) {
		new DynamicButtons();
	}
	
	 

