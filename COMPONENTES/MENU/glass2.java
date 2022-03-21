package Menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import Escalador.RegistrarParticipante;
import Escalador.PanelMontaña;
import componentes.HannoiGrafico;
import componentes.LeeTexto;
import componentes.ListaMexico;
import componentes.MyPanel;
import componentes.MyPanelAbsolute2;
import componentes.meta;

/*
 * Demonstrate use of GlassPane in JWindow & friends. Buttons enable/disable it.
 * @author Eckstein et al, in the O'Reilly book "Java Swing"
 */
public class glass2 {
	  componentes.meta S;
  /** Construct a Splash screen with the given image */
  public static void main(String[] args) {
    JFrame f = new JFrame("GlassPane");
  
    meta S = new meta();
    final JPanel p1 = new JPanel();
    p1.add(new JLabel("GlassPane Example"));
    JButton show = new JButton(" + ");
   
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
   // p2.setSize(100,100);							//aqui andamos con los paneles
    final Box boxButton = Box.createVerticalBox();
 //   boxButton.add(new RegistrarParticipante());
      boxButton.add( new HannoiGrafico(3) );

    JButton b = new JButton("Add Button");
   
    
  
    p2.setPreferredSize(new Dimension(600, 600));
    p2.setLayout(new BorderLayout());
    p2.add(b, BorderLayout.NORTH);
    p2.add(glassButton,BorderLayout.SOUTH);
    
    JScrollPane sp = new JScrollPane(
       
          new JScrollPane(boxButton)
            );
    
    p2.add(sp, BorderLayout.CENTER);
  
   p2.setBackground(new Color(114, 63, 75));
   p1.setBackground(new Color(114, 63, 75));
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
    //    p1.revalidate();
      }
    });
    b.addActionListener( new ActionListener() {
        int count = 2;
        public void actionPerformed(ActionEvent ae) {


        //  boxButton.add(new MyPanel());
   //     	 boxButton.add(     	new ListaMexico() );
        	 boxButton.add(new HannoiGrafico(3) );
        //	 boxButton.revalidate();
            count++;
            boxButton.revalidate();
            boxButton.repaint();
            sp.revalidate();
            sp.repaint();
            p1.repaint();
            p1.revalidate();
            
        }
    });
  }

}

