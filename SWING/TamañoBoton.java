package clemente;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
public class Tama�oBoton extends JFrame {
   private JButton boton,botonDisminuye;
   public Tama�oBoton(){
      HazInterfaz();
      HazEscuchas();
   }
   public void HazInterfaz(){
       add(new JLabel("Este bot�n aumenta 50 pixeles por dimensi�n"));
       setLayout(new FlowLayout());
  
       boton = new JButton("Aumenta");
       botonDisminuye=new JButton("Disminuye");
 //      boton.setSize(550,100);
       boton.setPreferredSize(new Dimension(80,60));
       add(boton);
       add(botonDisminuye);
       setSize(350, 500);
       setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLocationRelativeTo(null);
   }	
   public void HazEscuchas(){
	      boton.addActionListener(new ActionListener()
	      {   public void actionPerformed(ActionEvent evt)
	          {  boton.setSize(boton.getWidth() + 50, boton.getHeight() + 50);
	          	 botonDisminuye.requestFocus();
	          }
	       });
	      
	      botonDisminuye.addActionListener(new ActionListener()
	      {   public void actionPerformed(ActionEvent evt)
	          {  boton.setSize(boton.getWidth() - 50, boton.getHeight() - 50);
	          botonDisminuye.requestFocus();
	          }
	       });   
	      
	   }
    public static void main(String[] args) {
       new Tama�oBoton();
    }
}
