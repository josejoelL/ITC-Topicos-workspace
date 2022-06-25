package Vistas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.geom.AffineTransform;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import Modelos.Rutinas;

public class EtiquetaGirada extends JButton
{
public void paint (Graphics g)
{
// Para girar
AffineTransform at = new AffineTransform();
at.scale(0.5,0.5); // Se reduce el tamaño para que quepa girado
at.translate (400,-100); // Se traslada para que quede centrado
at.rotate(90*Math.PI/180); // Se rota 45 grados
((Graphics2D)g).setTransform(at);
super.paint(g);
}
/*
public Dimension getPreferredSize()
{
return new Dimension (560,200);
}
*/
public static void main(String [] args)
{
JFrame v = new JFrame();
v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
EtiquetaGirada l= new EtiquetaGirada();
EtiquetaGirada l2= new EtiquetaGirada();
EtiquetaGirada l3= new EtiquetaGirada();
EtiquetaGirada l4= new EtiquetaGirada();
/*
l.setText("hola");
l2.setText("hola 2");
l3.setText("hola 3");
l4.setText("hola 4");
*/

l.setIcon(Rutinas.AjustarImagen("src/Sprite/Dororo.jpg", 460, 600 ));
l2.setIcon(Rutinas.AjustarImagen("src/Sprite/durara.png", 460, 600 ));
l3.setIcon(Rutinas.AjustarImagen("src/Sprite/Black Clover.png", 460, 600 ));
l4.setIcon(Rutinas.AjustarImagen("src/Sprite/Boku no Hero Academia.png", 460, 600 ));
/*
l.setFont(l.getFont().deriveFont((float)30.0));
l2.setFont(l.getFont().deriveFont((float)30.0));
l3.setFont(l.getFont().deriveFont((float)30.0));
l4.setFont(l.getFont().deriveFont((float)30.0));
*/

l4.setBorder(null);
l4.setBorderPainted(false);
v.getContentPane().setLayout(new GridLayout(0,1,5,5));
v.getContentPane().add(l);
v.getContentPane().add(l2);
v.getContentPane().add(l3);
v.getContentPane().add(l4);
v.pack();
v.setVisible(true);
}
}