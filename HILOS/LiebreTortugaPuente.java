package HILOS;
import java.util.Random;

class Liebre extends Thread{
	private int kmRecorridos;
	private Semaforo S;
	boolean Tiene;
	Random R;
	public Liebre(Semaforo S) {
		kmRecorridos=0;
		R=new Random();
		this.S=S;
		Tiene=false;
	}
	public void run() {
		int Cont=0;
		while (kmRecorridos<100) {
			kmRecorridos+= 1;// R.nextInt(2)+2 ;
			System.out.println("Liebre Km "+kmRecorridos);
//			Cont++;
//			if(Cont % 5 == 0) {
//				try {
//					sleep(500);
//				} catch (Exception e ) {}   
//			}
			if(  !Tiene &&  kmRecorridos>=20 && kmRecorridos<=30  ) {
				S.Espera();
				Tiene=true;
			}
			if(kmRecorridos>30 && Tiene) {
				S.Libera();
				Tiene=false;
			}

		}
	}
}
class Tortuga extends Thread{
	private int kmRecorridos;
	private Semaforo S;
	private boolean Tiene;
	public Tortuga(Semaforo S) {
		kmRecorridos=0;
		this.S=S;
		Tiene=false;
	}
	public void run() {

		while (kmRecorridos<100) {
			kmRecorridos+= 1;
			System.out.println("Tortuga Km "+kmRecorridos);
			if(  !Tiene &&  kmRecorridos>=20 && kmRecorridos<=30  ) {
				S.Espera();
				Tiene=true;
			}
			if(kmRecorridos>30 && Tiene) {
				S.Libera();
				Tiene=false;
			}
		}
	}		
}

public class LiebreTortugaPuente {

	public static void main(String[] args) {
		Semaforo S=new Semaforo(1);

		Liebre liebre=new Liebre(S);
		Tortuga tortuga=new Tortuga(S);
		
		liebre.start();
		tortuga.start();

		while(liebre.isAlive() && tortuga.isAlive());
		if(!liebre.isAlive())
			System.out.println("ganador liebre");
		if(!tortuga.isAlive())
			System.out.println("ganador TORTUGA");

		
	}
}