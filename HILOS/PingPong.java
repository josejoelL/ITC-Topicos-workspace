package HILOS;

class Ping extends Thread {
	public void run() {
		for(int i=0 ; i<10 ; i++) {
			// sem�foro A
		System.out.println("Ping ");
		    // SEMAFORO B PONLO EN VERDE
		}
	}
}
class Pong extends Thread {
	public void run() {
		for(int i=0 ; i<10 ; i++) {
			// sem�foro B
		    System.out.println("Pong ");
		    // SEM�FORO A en verde
		}
	}
}
public class PingPong {

	public static void main(String[] args) {
		// SEMAFORO A  EN VERDE Y SEM�FORO B EN ROJO
		Ping ping=new Ping();
		Pong pong=new Pong();
		
		ping.start();
		pong.start();
		

	}

}
