/**
 * Fecha: 3 Abril 2026 autor: Landeros Santos Jose Joel
 * 
 **/
package sistemabancario;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class Vista extends JFrame {  
    private UIManager.LookAndFeelInfo[] looks;
    private String [] lookNames;
    private int IdPanel;
        
    private JPanel principal,panelSur,panelDepocito,PanelRetiro;
    private JPanel pTextosDepocito;
    private JPanel pCentroDepocito,pSurDepocito;
    private JLabel LabelInfo, labelTitulo;
    
    private JButton BotonContinuar,BotonDepocitar,BotonRegresarDepocito;
    
    private JTextField TextFieldOpciones,TextFieldDepocito;
   
         private JPanel pCentroRetiro,pSurRetiro;
         private JPanel pTextosRetiro;
         private JButton BotonRetirar;
         private JTextField TextFieldRetiro;
         
         private JButton BotonRegresar;
         
         
         private JPanel PanelSaldo;
         private JLabel LabelSaldo;

	public Vista(){
		super("banco msql");
                UIWindows_10();
                IdPanel = 0;
               
		HazInterfazMain();
                HazInterfazDepocito();
                HazInterfazRetiro();
                HazInterfazSaldo();
	}
	private void HazInterfazMain(){
		setSize(400,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               

		 principal = new JPanel();
		 panelSur = new JPanel();
                 panelDepocito= new JPanel();
		PanelRetiro= new JPanel();
                
                
                BotonContinuar=new JButton("Continuar");
                BotonContinuar.setBackground(Color.DARK_GRAY);
                BotonContinuar.setForeground(Color.white);
                BotonContinuar.setFont(new Font("arial", 1, 12));
		BotonContinuar.setBorderPainted(false);
		
                
                BotonRegresar = new JButton("Regresar");  
                BotonRegresar.setBackground(Color.DARK_GRAY);
                BotonRegresar.setForeground(Color.white);
                BotonRegresar.setBorderPainted(false);
                
                
                BotonDepocitar=new JButton("Depocitar");  
                BotonDepocitar.setBackground(Color.DARK_GRAY);
                BotonDepocitar.setForeground(Color.white);
                BotonDepocitar.setBorderPainted(false);	
                
                BotonRetirar = new JButton("Retirar");  
                BotonRetirar.setBackground(Color.DARK_GRAY);
                BotonRetirar.setForeground(Color.white);
                BotonRetirar.setBorderPainted(false);
                
                
                    pCentroDepocito = new JPanel(new FlowLayout());
                      panelDepocito.setLayout(new FlowLayout());
                      
                    pTextosDepocito = new JPanel(new GridLayout(2, 1));
                   pTextosDepocito.add(new JLabel("<html><p style='font-size:14px;'>Deposito</p></html>", SwingConstants.CENTER));
                   pTextosDepocito.add(new JLabel("<html><p style='font-size:14px;'>Introduzca Cantidad: </p></html>", SwingConstants.CENTER));

      
       
	   
                TextFieldDepocito = new JTextField("$", 12);
                
                
                pTextosRetiro = new JPanel(new GridLayout(2, 1));
                pTextosRetiro.add(new JLabel("<html><p style='font-size:14px;'>Retiro</p></html>", SwingConstants.CENTER));
                pTextosRetiro.add(new JLabel("<html><p style='font-size:14px;'>Introduzca el monto a retirar: </p></html>", SwingConstants.CENTER));
    
                
                
                PanelRetiro.setLayout(new FlowLayout());
                pCentroRetiro = new JPanel(new FlowLayout());
                 
                PanelSaldo= new JPanel(new FlowLayout());
                PanelSaldo.setBackground(Color.white);
                PanelSaldo.add(new JLabel("<html><p style='font-size:14px;'>Monto actual de su saldo: </p></html>", SwingConstants.CENTER));
                   
                LabelSaldo = new JLabel("$             ", 
                    SwingConstants.LEFT
                );
                LabelSaldo.setBackground(Color.white);
                LabelSaldo.setFont(new Font("arial", 1, 18));
                LabelSaldo.setForeground(new Color(0, 102, 51)); 
                
                PanelSaldo.add(LabelSaldo);
                
           
      
                
              
                
                TextFieldRetiro = new JTextField("$", 12);
                

		principal.setLayout(new GridLayout(0,1,0,5));
		panelSur.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
                
               
                
               
                principal.setBorder(new EmptyBorder(0, 20, 0, 0));
                 
		
		    
		
		
		
               
                        
           
              
                
                principal.setBackground(Color.white);
                panelSur.setBackground(Color.white);
          
                
            
                
                
               
                TextFieldOpciones = new JTextField("Introduzca un numero del 1-4 ",12);
                TextFieldOpciones.setBackground(Color.white);
                TextFieldOpciones.setFont(new Font("arial", 1, 12));
                 TextFieldOpciones.setForeground(Color.gray);        
                
                
                
             LabelInfo = new JLabel(
                    "<html><table style='width: 100%; font-size:14px;'>" +
                    "<tr><td style='color: blue;'>1.- Deposito.</td></tr>" +
                    "<tr><td style='color: red;'>2.- Retiro. </td></tr>" +
                    "<tr><td style='color: green;'>3.- Saldo </td></tr>" +
                    "<tr><td style='color: gray;'>4.- Salir </td></tr>" +
                    "</table></html>", 
                    SwingConstants.LEFT
                );
                
                
                LabelInfo.setBackground(Color.white);
                LabelInfo.setFont(new Font("arial", 1, 12));
                LabelInfo.setForeground(Color.gray);   
                String textoBanco = "<html><body style='background-color: white; padding: 10px;'>" +
                        "<h2 style='margin: 0;'>" +
                            "<span style='color: #006847;'>BANCO</span>" + 
                            "<span style='color: #333333;'> MEXI</span>" + 
                            "<span style='color: #CE1126;'>CANO</span>" +
                        "</h2>" +
                        "<hr style='border: 1; height: 4px; background: #006847;'>" +
                    "</body></html>";
                labelTitulo = new JLabel(textoBanco, SwingConstants.LEFT);

            
              labelTitulo.setOpaque(true); 
              labelTitulo.setBackground(Color.WHITE); 

              add(labelTitulo, BorderLayout.NORTH);
               
                principal.add(LabelInfo);
                
		add(principal,BorderLayout.CENTER);
                panelSur.add(TextFieldOpciones,BorderLayout.LINE_START);
                panelSur.add(BotonContinuar,BorderLayout.LINE_END);
              
                 
		principal.add(panelSur,BorderLayout.SOUTH);
		setVisible(true);
	}
        
   
	public void setControlador(Controlador C){
		BotonContinuar.addActionListener((ActionListener) C);
                BotonDepocitar.addActionListener((ActionListener) C);
                 BotonRetirar.addActionListener((ActionListener) C);
                 BotonRegresar.addActionListener((ActionListener) C);
                TextFieldDepocito.addFocusListener( (FocusListener)C);
                TextFieldOpciones.addFocusListener((FocusListener) C);
                TextFieldRetiro.addFocusListener((FocusListener) C);
                
	}
           

    private void UIWindows_10() {
		looks = UIManager.getInstalledLookAndFeels();
		lookNames = new String [looks.length];
		//for (int i = 0; i < lookNames.length; i++) {lookNames [i] = looks [i].getName();}
		try {UIManager.setLookAndFeel(looks[3].getClassName());} catch (Exception e) {}
	}


        int getOpcion() {
        try {
            return Integer.parseInt(TextFieldOpciones.getText().trim());
        } catch (NumberFormatException e) {
              JOptionPane.showMessageDialog(this, 
                        "Error: Introduzca un numero del 1-4", 
                        "Error de Sistema", 
                        JOptionPane.ERROR_MESSAGE);
            return 0;
        }
  
    }
        JButton getBotonContinuar (){
             return BotonContinuar;
         } 

        JLabel getinfo() {
       return LabelInfo;
    }

 void abrirPanelDepocito() {
    IdPanel = 1;
    remove(principal);
    panelDepocito.removeAll(); 
    HazInterfazDepocito();
    add(panelDepocito);
    revalidate(); 
    repaint();
    //TextFieldDepocito.requestFocusInWindow();
}

    public void abrirPanelRetiro() {
    IdPanel = 2;
     remove(principal);
    PanelRetiro.removeAll(); 
    HazInterfazRetiro();
    add(PanelRetiro);
    revalidate(); 
    repaint();
    }
    
    public void abrirPanelSaldo(){
    IdPanel = 3;
    
    remove(principal);
    PanelSaldo.removeAll(); 
    HazInterfazSaldo();
    add(PanelSaldo);
    revalidate(); 
    repaint();
    
    }
    public void abrirPanelSalir(){
     int respuesta = JOptionPane.showConfirmDialog(this, 
            "Esta apunto de cerrar la aplicacion \n\n¿Esta Seguro que decea Salir?", 
            "Se ha guardado Datos Correctamente", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.INFORMATION_MESSAGE);

        
        if (respuesta == JOptionPane.YES_OPTION) {

            System.exit(0); 
        }
    }       
            
            
    JTextField getTextFieldDepocito() {
    return TextFieldDepocito;
    }
    JTextField getTextFieldOpciones(){
        return TextFieldOpciones;
    }

    private void HazInterfazDepocito() {

      panelDepocito.add(pTextosDepocito);
    pCentroDepocito.add(TextFieldDepocito);
   
    pCentroDepocito.add(BotonDepocitar); 
    pCentroDepocito.add(BotonRegresar); 
    panelDepocito.add(pCentroDepocito);
    
    
    }
     private void HazInterfazRetiro() {

      PanelRetiro.add(pTextosRetiro);
    pCentroRetiro.add(TextFieldRetiro);
    pCentroRetiro.add(BotonRetirar); 
     pCentroRetiro.add(BotonRegresar); 
    PanelRetiro.add(pCentroRetiro);
    
    
    }

    JButton getBotonDepositar() {
        return BotonDepocitar;
          }

    public int getCantDepocito() {
        
            try {
            return Integer.parseInt(TextFieldDepocito.getText().trim());
        } catch (NumberFormatException e) {
           JOptionPane.showMessageDialog(this, 
                        "Error: El depósito debe ser mayor a $0", 
                        "Error de Sistema", 
                        JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    void abrirDepocitoExitoso(int cantidadDepocito) {
    
        int respuesta = JOptionPane.showConfirmDialog(this, 
            "Se realizó su abono con éxito.\nSu depósito fue de: $" + cantidadDepocito + "\n\n¿Desea realizar otro deposito?", 
            "Depósito Exitoso", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.INFORMATION_MESSAGE);

        
        if (respuesta == JOptionPane.YES_OPTION) {
                
        } else {
            
             remove(panelDepocito);
           // principal.removeAll(); 
            //HazInterfazDepocito();
            add(principal);
            revalidate(); 
            repaint();
            
            
           // System.exit(0); 
        }
    }

    public JButton getBotonRetirar() {
        return BotonRetirar ;
    }

    public JTextField getTextFieldRetiro() {
     return TextFieldRetiro;
    }

    public int getCantRetiro() {
        
            try {
            return Integer.parseInt(TextFieldRetiro.getText().trim());
        } catch (NumberFormatException e) {
           JOptionPane.showMessageDialog(this, 
                        "Error: El depósito debe ser mayor a $0", 
                        "Error de Sistema", 
                        JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    void abrirRetiroFallido(int SaldoActual, int cantRetiro) {
      JOptionPane.showMessageDialog(this, 
                        "Error: Saldo Insuficiente su Saldo actual es de: "+SaldoActual+"\n\nUsted no cuenta con: "+cantRetiro, 
                        "Error de Sistema", 
                        JOptionPane.ERROR_MESSAGE);
    }

    void abrirRetiroExitoso(int SaldoActual, int cantidadRetiro, int saldo) {
        int respuesta = JOptionPane.showConfirmDialog(this, 
                        "Se realizó su retiro de "+cantidadRetiro+" con éxito.\nSu anterior saldo de "+SaldoActual+" ahora es de: $" + saldo + "\n\nSe regresara al panel principal", 
                   "Retiro Exitoso",  
                        JOptionPane.OK_OPTION);
        
                if(respuesta == JOptionPane.OK_OPTION )  {
                    remove(PanelRetiro);
                    // principal.removeAll(); 
                     //HazInterfazDepocito();
                     add(principal);
                     revalidate(); 
                     repaint();
                }
                     
         
    }

    public JButton getBotonRegresar() {
        return BotonRegresar ;
    }

  public  void RegresarPaginaInicio(int panelactual) {
                    if (panelactual == 1){
                    remove(panelDepocito);
                    }
                    if (panelactual == 2){
                    remove(PanelRetiro);
                    }
                     if (panelactual == 3){
                    remove(PanelSaldo);
                    }
                     add(principal);
                     revalidate(); 
                     repaint();
                     
    }
    
  public int  getPanelactual(){
   
        return IdPanel;
  }
   public void  setPanelactual(int idActual){
   
        IdPanel = idActual;
  }      
  public void setLabelSaldo (int SaldoActual){
      LabelSaldo.setText("$: "+SaldoActual+".00");
  }

    private void HazInterfazSaldo() {
    PanelSaldo.add(new JLabel("<html><p style='font-size:14px;'>Monto actual de su saldo: </p></html>", SwingConstants.CENTER));
    PanelSaldo.add(LabelSaldo);
    PanelSaldo.add(BotonRegresar); 
    
      }
}


