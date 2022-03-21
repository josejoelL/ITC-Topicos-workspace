package HILOS;

import java.util.Random;
/* PUENTES:
 * KMINICIO   KMTERMINO
 *    30        80 SE REQUIERE UN SEMAFORO BINARIO PARA CADA PUENTE
 *   100       200
 *   300       350
 *   500       700
 *   810       920
 */

class Puente {
/////////////////	private boolean tienePuente;
	private Semaforo s;
	private int kmInicia, kmTermina;
	
	public Puente(int kmInicia,int kmTermina) {
		s=new Semaforo(1);
		this.kmInicia=kmInicia;
		this.kmTermina=kmTermina;
///////////		tienePuente=false;
	}
	public int ChecaPuente(int kmActual,boolean tienePuente) {
		if(kmActual>=kmInicia && kmActual<=kmTermina && !tienePuente ) {
			s.Espera();
/////////			tienePuente=true;
			return 2; // tiene el punte
			
		}
		if(kmActual>kmTermina && tienePuente) {
/////////			tienePuente=false;
			s.Libera();
			return 1;// libero puente
		}
	    return 0;
	}
	
	
	
}
class Liebre2 extends Thread {
	private int kmAvanzados;
	private Random r;
	private Puente [] vPuentes;
	private boolean tienePuente;
	private int noPuente;
	public Liebre2(Puente [] vPuentes) {
		this.vPuentes=vPuentes;
		kmAvanzados=0;
		r=new Random();
		tienePuente=false;
		noPuente=0;
	}
	public void run(){
		int resultado;
		while (kmAvanzados<320) {
			kmAvanzados += 1;//r.nextInt(3)+1;
			if(noPuente<vPuentes.length) {
				resultado=vPuentes[noPuente].ChecaPuente(kmAvanzados,tienePuente);
				if(resultado==2) { // tomo el puente
					tienePuente=true;
				}
				else
					if(resultado==1) { // libero puente
						noPuente++;
						tienePuente=false;
					}
			}
			System.out.println( this.getName()+"  Km # "+kmAvanzados);

		}

		System.out.println("La liebre ha GANADO LA CARRERA ");
	}
	
}
class Tortuga2 extends Thread {
	private int kmAvanzados;
	private Puente [] vPuentes;
	private int noPuente;
	private boolean tienePuente;
	public Tortuga2(Puente [] vPuentes) {
		this.vPuentes=vPuentes;
		kmAvanzados=0;
		noPuente=0;
		tienePuente=false;
	}
	public void run() {
		int resultado;
		while (kmAvanzados<320) {
			kmAvanzados++;
			if(noPuente<vPuentes.length) {
				resultado=vPuentes[noPuente].ChecaPuente(kmAvanzados,tienePuente);
				if(resultado==2) { // tomo el puente
					tienePuente=true;
				}
				else
					if(resultado==1) { // libero puente
						noPuente++;
						tienePuente=false;
					}
			}
			System.out.println( this.getName()+"  KM # "+kmAvanzados);
		}
		System.out.println("LA TORTUGA HA GANADO LA CARRERA");
	}
	
}
public class LiebreTortugaNPuentes {
	public static void main(String [] a) {
		
		Puente [] vpuentes=new Puente[5];
		vpuentes[0]=new Puente(30,80);
		vpuentes[1]=new Puente(100,200);
		vpuentes[2]=new Puente(300,350);
		vpuentes[3]=new Puente(500,700);
		vpuentes[4]=new Puente(810,920);
	
		Liebre2 lie=new Liebre2(vpuentes);
		Tortuga2 tor=new Tortuga2(vpuentes);
		Liebre2 lie2=new Liebre2(vpuentes);
		Tortuga2 tor2=new Tortuga2(vpuentes);	
		tor2.setName("Tortuga CLONADA");
		lie2.setName("LIEBRE CLONADA");
		tor.setName("Tortuga original");
		lie.setName("Liebre ORIGINAL");
		lie.start();
		
		
		tor.start();
		

		lie2.start();
		
		
		tor2.start();		
		;

	}
}
