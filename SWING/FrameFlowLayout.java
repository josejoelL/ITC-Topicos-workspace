package clemente;
import javax.swing.*;
import java.awt.*;
class FrameFlowLayout extends JFrame {
   public FrameFlowLayout() {
      super("**Layout**");HazInterfaz();
   }
   public void HazInterfaz(){
	     
      setLayout(new FlowLayout(FlowLayout.CENTER));
      setSize( 350, 150 );
      setLocationRelativeTo(null);
      JLabel Etiqueta1 = new JLabel("No.Control",SwingConstants.CENTER);
      add(Etiqueta1);
      JLabel Etiqueta2 = new JLabel("Nombre",SwingConstants.CENTER);
      add(Etiqueta2);
 
      add(new JButton("Edad"));
      add(new JButton("EC"));
      add(new JButton("SEXO"));
      
      add(new JTextField("proporciona edad"),1);
      
      	remove(Etiqueta2);

      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      setVisible(true);
          
   }
   public static void main(String [] a) {
      new FrameFlowLayout();
   }
}

