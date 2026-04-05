/**
 * Fecha: 4 Abril 2026 autor: Landeros Santos Jose Joel
 * 
 **/

package sistemabancario;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;






public class Controlador implements ActionListener,FocusListener {
	Vista Vista;
	Modelo Modelo;
	
	public Controlador(Vista Vista,Modelo Modelo){
		this.Vista=Vista;
		this.Modelo=Modelo;
	}
	
	
	public void actionPerformed(ActionEvent Evt) {
		if(Evt.getSource()==Vista.getBotonRegresar()){
                    //se le agrego un Indice dependiendo de cual Vista.abrir para saber cual se remueve
                    Vista.RegresarPaginaInicio(Vista.getPanelactual());
                }
                
                
		if(Evt.getSource()==Vista.getBotonContinuar()){
			int opcion = Vista.getOpcion();
			switch (opcion){
                            case 1 -> Vista.abrirPanelDepocito();
                            case 2 -> Vista.abrirPanelRetiro();
                            case 3 -> AbrirPanelConsultarSaldo();
                            case 4 -> Vista.abrirPanelSalir();
                        }	
			 return;
		}
                if(Evt.getSource() == Vista.getBotonDepositar() ){
                    
                    if(Vista.getCantDepocito() > 0){
                    
                    int cantidadDepocito = Vista.getCantDepocito();
                    
                    Modelo.setDeposito(cantidadDepocito);
                     Vista.abrirDepocitoExitoso(cantidadDepocito);
                    }
                }
		 if(Evt.getSource() == Vista.getBotonRetirar() ){
                     System.out.println("Funciona el metodo getBotonRetirar");
                     if(Vista.getCantRetiro() > 0){
                         System.out.println("botonRetirar reconoce mas de $0");
                         int SaldoActual = Modelo.getSaldo();
                         
                         if(Vista.getCantRetiro() > SaldoActual ){
                              Vista.abrirRetiroFallido(SaldoActual, Vista.getCantRetiro() );
                         }else {
                         int cantidadRetiro = Vista.getCantRetiro();
                          Modelo.setRetiro(cantidadRetiro);
                          
                          Vista.abrirRetiroExitoso(SaldoActual, cantidadRetiro, Modelo.getSaldo() );
                         }
                         
                         
                         
                         
                     }
                  
                 
                }

	}

    
    public void focusGained(FocusEvent Evt) {
           if( Evt.getSource() == Vista.getTextFieldOpciones() ){
            Vista.getTextFieldOpciones().setText("");
     }
        if( Evt.getSource() == Vista.getTextFieldDepocito() ){
            System.out.println("Entre al texto deposito");
            
             if (Vista.getTextFieldDepocito().getText().equals("$")) {
            
            Vista.getTextFieldDepocito().setText("");
             Vista.getTextFieldDepocito().setForeground(Color.BLACK); // Cambiamos a color normal
        }        
          if( Evt.getSource() == Vista.getTextFieldRetiro() ){
              System.out.println("Entre al texto retiro");
          }
            
     }
       
    }

   
    public void focusLost(FocusEvent Evt) {
               if( Evt.getSource() == Vista.getTextFieldOpciones() ){
            System.out.println("Me sali del menu principal");
          //  Vista.getTextFieldOpciones().setText("1-4");
     }
        
        
   if (Vista.getTextFieldDepocito().getText().isEmpty()) {
            Vista.getTextFieldDepocito().setForeground(Color.GRAY); 
            Vista.getTextFieldDepocito().setText("$");
            
    }
    }

    private void AbrirPanelConsultarSaldo() {
       int saldoActual = Modelo.getSaldo();
        Vista.setLabelSaldo(saldoActual);
        Vista.abrirPanelSaldo(); 
    }
}



	
	
