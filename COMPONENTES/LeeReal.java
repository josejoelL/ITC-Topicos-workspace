package componentes;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LeeReal  extends LeeEntero {
	public LeeReal(){
		this(5);
	}
	public LeeReal(int Longitud){
		super(Longitud);
	}

	public void keyTyped(KeyEvent Evt) {

		if(getText().indexOf(".") ==-1 && Evt.getKeyChar() !='.' ){
			super.keyTyped(Evt);
			return;
		}
		// validar la parte fraccionaria
		if(getText().length()==Longitud){
			Evt.consume();
			Toolkit.getDefaultToolkit().beep();
			return;
		}
		if(Evt.getKeyChar() == '.' ){
			if(getText().length()==0){
				setText("0.");
				Evt.consume();
				return;
			}
			if(getText().length()==1 && getText().charAt(0)=='-'){
				setText(getText()+"0.");
				Evt.consume();
				return;
				
			}
			if(getText().indexOf(".")>=0){
				Evt.consume();
				return;
			}
			return;
		}
		if("0123456789".indexOf(Evt.getKeyChar())<0){
			Evt.consume();
			return;
		}
		int PosPunto=getText().indexOf(".");
		int largo=getText().length();
		if(largo-PosPunto > 2){
			Evt.consume();
			return;
		}
	}
	public double getCantidad(){
		return Double.parseDouble(getText());
	}
}
