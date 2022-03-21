package HILOS;

public class PingPong {
	static Semaforo s1=new Semaforo(1);
	static Semaforo s2=new Semaforo(0);

	static class Ping implements Runnable {

	    public void run() {
			for(int i=0 ; i<20 ;i++) {
				s1.Espera();
				System.out.println("ping ");
				s2.Libera();
			}	
		}
		
	}
	static class Pong implements Runnable {
		public void run() {
			for(int i=0 ; i<20 ;i++) {
				s2.Espera();
				System.out.println("PONG ");
				s1.Libera();
			}
		}
		
	}
	
	
	public static void main(String[] args) {

		
		Ping pi=new Ping();
		Pong po=new Pong();

		Thread ping=new Thread(pi);
		Thread pong=new Thread(po);
	System.out.println("inician hilos");	
		ping.start();
		pong.start();
		

	}

}
