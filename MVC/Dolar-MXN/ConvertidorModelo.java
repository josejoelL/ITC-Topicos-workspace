package clemente;
public class ConvertidorModelo  {
	private double Cotizacion;
	public ConvertidorModelo(){
		Cotizacion=24.06;
	}
	public ConvertidorModelo(double Cotizacion){
		this.Cotizacion=Cotizacion;
	}
	public double Pesos(double Cantidad){
		return Cantidad*Cotizacion;
	}
	public double Dolares(double Cantidad){
		return Cantidad/Cotizacion;
	}
}
