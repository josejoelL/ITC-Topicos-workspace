package HILOS;

import java.util.Random;

import HILOS.LiebreTortuga.Liebre;
import HILOS.LiebreTortuga.Tortuga;

public class tortugaLiebrePuente {

	
	
	
	
		static class Liebre extends Thread{
			private Semaforo Puente;
			private int kmRecorridosL;
			Random R;
			public Liebre(Semaforo Puente) {
				this.Puente=Puente;
				kmRecorridosL=0;
				R=new Random();
			}
			public void run() {
				int Cont=0;
				while (kmRecorridosL<100) {
					
					if (kmRecorridosL>=5&&kmRecorridosL<=25) {
					
						  Puente.Espera();
						  while (kmRecorridosL<=25) {
							  kmRecorridosL+= R.nextInt(2)+2 ;
							  System.out.println("Liebre esta en el puente "+kmRecorridosL);
						}
					     
					      Puente.Libera();	
					}
					kmRecorridosL+= R.nextInt(2)+2 ;
					System.out.println("Liebre Km "+kmRecorridosL);
					Cont++;
					if(Cont % 5 == 0) {
						try {
							sleep(500);
						} catch (Exception e ) {}   

					}
				}
			}
		}
		static class Tortuga extends Thread{
			private Semaforo Puente;
			private int kmRecorridosT;
			public Tortuga(Semaforo Puente) {
				this.Puente=Puente;
				kmRecorridosT=0;
			}
			public void run() {

				while (kmRecorridosT<100) {
					
					if (kmRecorridosT>=5&&kmRecorridosT<=25) {
						  Puente.Espera();
						  while (kmRecorridosT<=25) {
							  kmRecorridosT+= 1;
							  System.out.println("Liebre esta en el puente "+kmRecorridosT);
						}
					     
					      Puente.Libera();	
					}
					
					
					kmRecorridosT+= 1;
					System.out.println("Tortuga Km "+kmRecorridosT);

				}
			}		
		}
		public static void main(String[] args) {
			
			
			Semaforo Puente=new Semaforo(1);
			
			Liebre liebre=new Liebre(Puente);
			Tortuga tortuga=new Tortuga(Puente);
			
			liebre.start();
			tortuga.start();

			while(liebre.isAlive() && tortuga.isAlive());
			if(!liebre.isAlive())
				System.out.println("ganador liebre");
			if(!tortuga.isAlive())
				System.out.println("ganador TORTUGA");

			
		}

	


}
