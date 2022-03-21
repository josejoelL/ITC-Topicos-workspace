package HILOS;
import java.util.*;

// EN LA CARRETERA DONDE ES LA CARRERA SE ENCUENTRA UN PUENTE QUE VA DEL KM 100 AL 2O0.
// EL PUENTE SÓLO SOPORTA A UN ANIMAL.


class Liebre extends Thread {
	private int kmAvanzados;
	private Random r;
	public Liebre() {
		kmAvanzados=0;
		r=new Random();
	}
	public void run() {
		int veces=0;
		// TOMA EL TIRMPO DE INICIAL
		while (kmAvanzados<1000) {
			kmAvanzados += r.nextInt(3)+1;
			veces++;
			System.out.println(" Liebre Km # "+kmAvanzados);
			if(veces%200==0) {
				try {
					System.out.println("LA LIEBRE SE DURMIO DESPUES DE SPRINT # "+veces);
				   sleep(5);
			    } catch (Exception e) {
			    	System.out.println("LA LIEBRE HA DESPERTADO PARA SEGUIE EN LA CARRERA");
			    }
			}
		}
		// TIEMPO FINAL
		System.out.println("La liebre ha GANADO LA CARRERA ");
	}
	
}
class Tortuga extends Thread {
	private int kmAvanzados;
	public Tortuga() {
		kmAvanzados=0;
	}
	public void run() {
		while (kmAvanzados<1000) {
			kmAvanzados++;
			System.out.println("TORTUGA KM # "+kmAvanzados);
		}
		System.out.println("LA TORTUGA HA GANADO LA CARRERA");
	}
	
}
public class LiebreCarreraTortuga {
	public static void main(String [] a) {
		Liebre lie=new Liebre();
		Tortuga tor=new Tortuga();
		
		lie.start();
		tor.start();
		
		//SACAR QUE HILO TIENE EL MENOR TIEMPO.
	}
}
