package Menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import Escalador.RegistrarParticipante;
import Escalador.PanelMontaña;
import componentes.ListaMexico;
import componentes.ListaMexico2;
import componentes.MyPanelAbsolute2;
import componentes.meta;

public class glass {
	  componentes.meta S;
  /** Construct a Splash screen with the given image */
  public static void main(String[] args) {
    JFrame f = new JFrame("GlassPane");
  
    meta S = new meta();
    final JPanel p1 = new JPanel();
    p1.add(new JLabel("GlassPane Example"));
    JButton show = new JButton(" + ");
    show.setBackground(Color.orange);
    p1.add(show);
    p1.add(new JButton(" - "));
    f.getContentPane().add(p1);
 
    final JPanel glass = (JPanel) f.getGlassPane();
   
    glass.setVisible(true);
    glass.setLayout(new FlowLayout());
    
    
    JButton glassButton = new JButton("Actualizar");
    glassButton.setBackground(Color.black);
    glassButton.setForeground(Color.white);
    
    
    final JPanel p2 = new JPanel();

    		
   			//aqui andamos con los paneles
 

    
    final JPanel gridButton = new JPanel(new GridLayout(0,1,2,2));
    gridButton.add(new ListaMexico2());
    
        JPanel gridConstrain = new JPanel(new BorderLayout());
    gridConstrain.add(gridButton, BorderLayout.NORTH);
    
    
    JButton b = new JButton("Add Button");
    b.addActionListener( new ActionListener() {
        int count = 2;
        public void actionPerformed(ActionEvent ae) {
            gridButton.add((new ListaMexico() ));

      

            count++;
            glass.revalidate();
        }
    });
    
  
    p2.setPreferredSize(new Dimension(600, 500));
    p2.setLayout(new BorderLayout());
    p2.add(b, BorderLayout.NORTH);
    p2.add(glassButton,BorderLayout.SOUTH);
    b.setBackground(Color.red);
    JScrollPane sp = new JScrollPane(       new JScrollPane(gridConstrain)          );
    
    p2.add(sp, BorderLayout.CENTER);
    p2.setBackground(new Color(114, 63, 75));
    glass.add(p2);
  
    f.setSize(1500, 800);
    f.setVisible(true);

    boolean debug = false;
    if (debug) {
      System.out.println("Button is " + glassButton);
      System.out.println("GlassPane is " + glass);
    }

  
    show.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        glass.setVisible(true);
        p1.repaint();
      }
    });
   
    glassButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        glass.setVisible(false);
        p1.repaint();
      }
    });
  }

}


