package HILOS;

class Ping implements Runnable {
	private Semaforo s1,s2;
	public Ping(Semaforo s1, Semaforo s2) {
		this.s1=s1;
		this.s2=s2;
		
	}
    public void run() {
    	
		for(int i=0 ; i<20 ;i++) {
			s1.Espera();
			System.out.println("ping ");
			s2.Libera();
		}	
		
	}
	
}
class Pong implements Runnable {
  	private Semaforo s1,s2;
	public Pong(Semaforo s1, Semaforo s2) {
		this.s1=s1;
		this.s2=s2;
		
	}
	public void run() {
		
		for(int i=0 ; i<20 ;i++) {
			s2.Espera();
			System.out.println("PONG ");
			s1.Libera();
		}
		
	}
	
}

public class PingPongV2 {

	
	
	public static void main(String[] args) {

		Semaforo s1=new Semaforo(1);
		Semaforo s2=new Semaforo(0);
	
		Ping pi=new Ping(s1,s2);
		Pong po=new Pong(s1,s2);

		Thread ping=new Thread(pi);
		Thread pong=new Thread(po);
		
	System.out.println("inician hilos");	
		ping.start();
		pong.start();
		

	}

}
