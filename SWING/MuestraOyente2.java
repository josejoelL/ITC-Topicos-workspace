package material_clase;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MuestraOyente2 extends JFrame {
   JButton Boton1=new JButton("Boton 1");
   JButton Boton2=new JButton("Boton 2");
   JButton Boton3=new JButton("Boton 3");
   public MuestraOyente2() {
	   setBounds(100,100,500,300);
      setVisible(true);
      setLocationRelativeTo(null);
	  setLayout(new FlowLayout(FlowLayout.CENTER));
      add(Boton1);  add(Boton2); add(Boton3); 
      Boton1.addActionListener( new Oyente1() );
      Boton2.addActionListener( new Oyente2() ); 
      Boton3.addActionListener( new Oyente3() );
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   public static void main(String [] arg) {
	   new MuestraOyente2(); 
	   
   }
   class Oyente1 implements ActionListener {
      public void actionPerformed(ActionEvent  Evento) {  
    	  Boton1.setBackground(Color.BLUE);
      }
   }
   class Oyente2 implements ActionListener {
      public void actionPerformed(ActionEvent  Evento) {
         Boton2.setBackground(Color.YELLOW);
      }
   }
   class Oyente3 implements ActionListener {
      public void actionPerformed(ActionEvent  Evento) {
         Boton3.setBackground(Color.RED);
      }
   }
}

