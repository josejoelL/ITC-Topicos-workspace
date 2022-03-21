package HILOS;

class Tarea1 implements Runnable{
	public void run() {
		for(int i=0 ; i<20 ; i++)
		  System.out.println((i+1)+"tarea uno");
	}
}
class Tarea2 implements Runnable {
	public void run() {
		for(int i=0 ; i<20 ; i++)
		   System.out.println((i+1)+"tarea dos");
	}
}
class Tarea3 implements Runnable {
	public void run() {
		for(int i=0 ; i<20 ; i++)
		   System.out.println((i+1)+"tarea tres");
	}
}
public class HilosRunnable {
	public static void main(String [] a) {
		Tarea1 t1=new Tarea1();
		Tarea2 t2=new Tarea2();
		Tarea3 t3=new Tarea3();

		Thread H1=new Thread(t1);
		Thread H2=new Thread(t2);
		Thread H3=new Thread(t3);
		
		H1.start();
		H2.start();
		H3.start();

		while (H1.isAlive() || H2.isAlive() || H3.isAlive());

		System.out.println("*** fin main***");
	}
}
