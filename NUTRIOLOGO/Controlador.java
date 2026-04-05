
/**
 * Fecha: 1 Abril 2026 autor: Landeros Santos Jose Joel
 * 
 **/
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controlador implements ActionListener {
	Vista Vista;
	Modelo Modelo;
	public Controlador(Vista Vista,Modelo Modelo){
		this.Vista=Vista;
		this.Modelo=Modelo;
	}
	
	
	public void actionPerformed(ActionEvent Evt) {
		if(Evt.getSource()==Vista.getBotonCalcular()){
			double Peso = Vista.getPeso();
                        double Estatura = Vista.getEstatura();
                        
			double IMC = Modelo.getIMC(Peso, Estatura); 
                        
                        String IMCtoString = String.format("%.1f", IMC); 
                        
                    ClasificacionIMC clasificacion = Modelo.getClasificacion(IMC);
			Vista.setResultado(IMCtoString, clasificacion.getTipo());
                        
                      

                        switch (clasificacion) {
                            case BAJO_PESO:
                                Vista.getResultado().setForeground(Color.blue);
                                break;
                            case PESO_NORMAL:
                                 Vista.getResultado().setForeground(Color.green);
                                break;
                            case SOBREPESO:
                                 Vista.getResultado().setForeground(Color.yellow);
                                break;
                            case OBESIDAD_I:
                                 Vista.getResultado().setForeground(Color.orange);
                                break;
                            case OBESIDAD_II:
                                 Vista.getResultado().setForeground(Color.red);
                                break;
                            case OBESIDAD_III:
                                 Vista.getResultado().setForeground(Color.red);
                                break;
                        }

                    }
	
	}
	
}