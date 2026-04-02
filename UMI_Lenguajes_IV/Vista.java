
/**
 * Fecha: 1 Abril 2026 autor: Landeros Santos Jose Joel
 * 
 **/
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.CSS;
public class Vista extends JFrame {
	private int w, h;
        
	private JLabel LblResultado;
	private JTextArea Txt;
	private JPanel P1,P2;
        
        
        private UIManager.LookAndFeelInfo[] looks;
	private String [] lookNames;
        
    private JButton BotonCalcular;
    private JLabel LabelEstatura;
    private JLabel LabelPeso;
    private JLabel LabelTitulo;
    private JPanel PanelCalcular;
    private JPanel PanelEstatura;
    private JPanel PanelPeso;
    private JPanel PanelTitulo;
    private JTextField TextFieldEstatura;
    private JTextField TextFieldPeso;
        
      

	public Vista(){
		super(" HOSPITAL IMC ");
                UIWindows_10();
               
		HazInterfaz();
	}
	private void HazInterfaz(){
		setSize(300,250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               

		 P1 = new JPanel();
		 P2 = new JPanel();
                 
		PanelPeso = new JPanel();
		PanelEstatura = new JPanel();
                
                
		P1.setLayout(new GridLayout(0,1,0,5));
		P2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		setLayout(new BorderLayout());
                
                PanelPeso.setLayout(new FlowLayout(FlowLayout.LEFT));
                PanelEstatura.setLayout(new FlowLayout(FlowLayout.LEFT));
                
                // PanelPeso.setBorder(new EmptyBorder(0, 20, 0, 0));
                 P1.setBorder(new EmptyBorder(0, 20, 0, 0));
                 
		BotonCalcular=new JButton("Aceptar");
                BotonCalcular.setBackground(Color.DARK_GRAY);
                BotonCalcular.setForeground(Color.white);
                BotonCalcular.setFont(new Font("arial", 1, 12));
		BotonCalcular.setBorderPainted(false);
		
		    
		P1.add(new JLabel("<html><p style=\"font-size:14px;\">Introduzca su Peso y Estatura</p><body>",SwingConstants.CENTER));
		
		P1.add(LabelPeso=new JLabel("<html><p style=\"font-size:12px;\">Peso en kilogramos: </p><body>",SwingConstants.LEFT));
                
                TextFieldPeso = new JTextField("ej. 80",12);
                 
		TextFieldPeso.setBackground(Color.white);
                TextFieldPeso.setFont(new Font("arial", 1, 12));
                 TextFieldPeso.setForeground(Color.gray);    
                 
                //w = PanelPeso.getWidth();
		//h = PanelPeso.getHeight();
                        
           
                PanelPeso.add(TextFieldPeso);
                P1.add(PanelPeso);
                
                P1.setBackground(Color.white);
                P2.setBackground(Color.white);
                PanelPeso.setBackground(Color.white);
                PanelEstatura.setBackground(Color.white);
                
            
                
                
                P1.add(LabelEstatura=new JLabel("<html><p style=\"font-size:12px;\">Estatura en metros: </p><body>",SwingConstants.LEFT));
                
                TextFieldEstatura = new JTextField("ej. 1.73",12);
                TextFieldEstatura.setBackground(Color.white);
                TextFieldEstatura.setFont(new Font("arial", 1, 12));
                 TextFieldEstatura.setForeground(Color.gray);        
                
                PanelEstatura.add(TextFieldEstatura);
                P1.add(PanelEstatura);
                
                LblResultado =new JLabel("",SwingConstants.CENTER);
                LblResultado.setBackground(Color.white);
                LblResultado.setFont(new Font("arial", 1, 12));
                LblResultado.setForeground(Color.gray);   
                
                P1.add(LblResultado);
		add(P1,BorderLayout.CENTER);
                
	//	P2.add(new JLabel("Donde estas ",SwingConstants.CENTER),BorderLayout.CENTER);
                P2.add(BotonCalcular,BorderLayout.EAST);
		add(P2,BorderLayout.SOUTH);
                
                
               
                 
                 
		setVisible(true);
	}
        
   
	public void setControlador(Controlador C){
		BotonCalcular.addActionListener((ActionListener) C);

	}

	
	
	public void setResultado(String IMC,String Clasificacion){

		LblResultado.setText("tu IMC es de: "+IMC+" Clasificacion: "+Clasificacion+"");
	}

        	private void UIWindows_10() {
		looks = UIManager.getInstalledLookAndFeels();
		lookNames = new String [looks.length];
		//for (int i = 0; i < lookNames.length; i++) {lookNames [i] = looks [i].getName();}
		try {UIManager.setLookAndFeel(looks[3].getClassName());} catch (Exception e) {}
	}

        double getPeso() {
        try {
            return Double.parseDouble(TextFieldPeso.getText());
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
    

        double getEstatura() {
        try {
            return Double.parseDouble(TextFieldEstatura.getText());
        } catch (NumberFormatException e) {
            return 0.0;
        }
  
    }
        JButton getBotonCalcular (){
             return BotonCalcular;
         } 

        JLabel getResultado() {
       return LblResultado;
    }

  
}


