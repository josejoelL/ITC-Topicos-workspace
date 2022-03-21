package HILOS;

public class Puente {
//	private boolean Tiene;
	private Semaforo S;
	private int KmIni,KmFin;
	
	public Puente(int KmIni,int KmFin) {
		this(KmIni,KmFin,1);

	}
	public Puente(int KmIni,int KmFin,int Capacidad) {
		this.KmIni=KmIni;
		this.KmFin=KmFin;
		S=new Semaforo(Capacidad);

	}
	public int Verifica(int KmActual,boolean Tiene) {
		int Accion=0; //0 no hizo nada, 1 asignó puente, 2 libero puente
		if(  !Tiene &&  KmActual>=KmIni && KmActual<=KmFin  ) {		
			S.Espera();
			Accion=1;
		}
		else
		   if(KmActual>KmFin && Tiene) {
			   S.Libera();
			   Accion=2;
		    }

		return Accion;
		
	}
	
	
}
