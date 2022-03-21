package clemente;


public class ConvertidorApl {
	public ConvertidorApl(){
		ConvertidorVista Vista=new ConvertidorVista();
		ConvertidorModelo Modelo=new ConvertidorModelo(24.06);
		ConvertidorControlador Controlador=new ConvertidorControlador(Vista,Modelo);
		Vista.setControlador(Controlador);
	}
	public static void main(String [] a){
		new ConvertidorApl();
	}
}
