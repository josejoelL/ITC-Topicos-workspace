package HILOS;
class PingS extends Thread {
	private Semaforo SPing,SPong;
	public PingS(Semaforo SPing,Semaforo SPong) {
		this.SPing=SPing;
		this.SPong=SPong;
	}
	public void run() {
		
		for(int i=0 ; i<10 ; i++) {
			
			SPing.Espera();
		       System.out.print("Ping ");
		    SPong.Libera();
		    
		}
		 
	}

}
class PongS extends Thread {
	private Semaforo SPing,SPong;
	public PongS(Semaforo SPing,Semaforo SPong) {
		this.SPing=SPing;
		this.SPong=SPong;
	}

	public void run() {
		
		for(int i=0 ; i<10 ; i++) {
			SPong.Espera();
		      System.out.print("Pong ");
		    SPing.Libera();
		}
		
	}
}
public class PingPongSemaforo {
	public static void main(String[] args) {
		Semaforo SPing=new Semaforo(0);
		Semaforo SPong=new Semaforo(1);

		PingS ping=new PingS(SPing,SPong);
		PongS pong=new PongS(SPing,SPong);
		
		ping.start();
		pong.start();
		
 
	}
}
