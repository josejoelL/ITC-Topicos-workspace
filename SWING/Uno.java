package clemente;
import java.awt.BorderLayout;
import java.awt.*;

import javax.swing.*;
public class Uno {
    public static void main(String[] args) {
       JFrame Marco = new JFrame("ITC");
  //     Marco.setSize(300,200);
  //     Marco.setLocation(300,100);
       Marco.setBounds(300,100,500,200);

     JLabel Etiqueta = new JLabel("HOLA MUNDO, hecho con SWING" ,SwingConstants.CENTER);
     
       Marco.add(new JButton("Centro"));
      Marco.add(new JButton("Norte"),BorderLayout.NORTH);
       Marco.add(new JButton("Sur"),BorderLayout.SOUTH);
       Marco.add(new JButton("este"),BorderLayout.EAST);
       Marco.add(new JButton("oeste"),BorderLayout.WEST);
       
       Marco.setVisible(true);
   }
}
