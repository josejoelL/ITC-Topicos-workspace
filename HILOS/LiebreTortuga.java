package HILOS;

import java.util.Random;

public class LiebreTortuga {
	static class Liebre extends Thread{
		private int kmRecorridos;
		Random R;
		public Liebre() {
			kmRecorridos=0;
			R=new Random();
		}
		public void run() {
			int Cont=0;
			while (kmRecorridos<100) {
				kmRecorridos+= R.nextInt(2)+2 ;
				System.out.println("Liebre Km "+kmRecorridos);
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
		private int kmRecorridos;
		public Tortuga() {
			kmRecorridos=0;
		}
		public void run() {

			while (kmRecorridos<100) {
				kmRecorridos+= 1;
				System.out.println("Tortuga Km "+kmRecorridos);

			}
		}		
	}
	public static void main(String[] args) {
		Liebre liebre=new Liebre();
		Tortuga tortuga=new Tortuga();
		
		liebre.start();
		tortuga.start();

		while(liebre.isAlive() && tortuga.isAlive());
		if(!liebre.isAlive())
			System.out.println("ganador liebre");
		if(!tortuga.isAlive())
			System.out.println("ganador TORTUGA");

		
	}

}
