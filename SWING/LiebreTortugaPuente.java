package HILOS;

import java.util.Random;

class Liebre1 extends Thread {
	private int kmAvanzados;
	private Random r;
	private Semaforo s;
	private boolean tienePuente;
	public Liebre1(Semaforo s) {
		this.s=s;
		kmAvanzados=0;
		r=new Random();
		tienePuente=false;
	}
	public void run() {
		int veces=0;
		// TOMA EL TIRMPO DE INICIAL
		while (kmAvanzados<1000) {
			kmAvanzados += 1;//r.nextInt(3)+1;
			if(kmAvanzados>=100 && kmAvanzados<200 && !tienePuente) {
				s.Espera();
				tienePuente=true;
			}
			if(kmAvanzados>=200 && tienePuente) {
				
				s.Libera();
				tienePuente=false;
			}
			
			veces++;
			System.out.println(" Liebre Km # "+kmAvanzados);
//			if(veces%500==0) {
//				try {
//					System.out.println("LA LIEBRE SE DURMIO DESPUES DE SPRINT # "+veces);
//				   sleep(5);
//			    } catch (Exception e) {
//			    	System.out.println("LA LIEBRE HA DESPERTADO PARA SEGUIE EN LA CARRERA");
//			    }
//			}
		}
		// TIEMPO FINAL
		System.out.println("La liebre ha GANADO LA CARRERA ");
	}
	
}
class Tortuga1 extends Thread {
	private int kmAvanzados;
	private Semaforo s;
	public Tortuga1(Semaforo s) {
		this.s=s;
		kmAvanzados=0;
	}
	public void run() {
		while (kmAvanzados<1000) {
			kmAvanzados++;
			if(kmAvanzados == 100   )
				s.Espera();
			if(kmAvanzados==200)
				s.Libera();
			System.out.println("TORTUGA KM # "+kmAvanzados);
		}
		System.out.println("LA TORTUGA HA GANADO LA CARRERA");
	}
	
}
public class LiebreTortugaPuente {
	
	public static void main(String [] a) {
		Semaforo s=new Semaforo(1);
		
		
		Liebre1 lie=new Liebre1(s);
		Tortuga1 tor=new Tortuga1(s);
		
		lie.start();
		tor.start();
		
		//SACAR QUE HILO TIENE EL MENOR TIEMPO.
	}
}
