package material_clase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class MuestraOyente extends JFrame {
   JButton Boton1=new JButton("Boton 1");
   JButton Boton2=new JButton("Boton 2");
   JButton Boton3=new JButton("Boton 3");
   public MuestraOyente() {
      setBounds(100,100,500,300);
      setVisible(true);
      setLayout(new FlowLayout(FlowLayout.LEFT));
      add(Boton1);
      add(Boton2);
      add(Boton3);
      Oyente Oye=new Oyente();
      Boton1.addActionListener(Oye);
      Boton2.addActionListener(Oye);
      Boton3.addActionListener( Oye );
   }
   class Oyente implements ActionListener {
      public void actionPerformed(ActionEvent  Evento) {
          if (Evento.getSource()==Boton1)
        	  Boton1.setBackground(Color.BLUE);
          else 
             if (Evento.getSource()==Boton2)
            	 Boton2.setBackground(Color.YELLOW);
             else
                if (Evento.getSource()==Boton3)
                	Boton3.setBackground(Color.RED);
      }
   }
    public static void main(String [] arg) {  MuestraOyente Obj=new MuestraOyente();
	  Obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}
