package HILOS;


public class Hilos1 {
	static class Tarea1 extends Thread {
		public void run() {
			for(int i=0 ; i<20 ; i++)
			  System.out.println((i+1)+"tarea uno");
		}
	}

	static class Tarea2 extends Thread {
		public void run() {
			for(int i=0 ; i<20 ; i++)
			   System.out.println((i+1)+"tarea dos");
		}
	}
	static class Tarea3 extends Thread {
		public void run() {
			for(int i=0 ; i<20 ; i++)
			   System.out.println((i+1)+"tarea tres");
		}
	}
	public static void main(String[] args) {
		Tarea1 t1=new Tarea1();
		Tarea2 t2=new Tarea2();
		Tarea3 t3=new Tarea3();
		
		t1.start();
		t2.start();
		t3.start();
		
		while (t1.isAlive() || t2.isAlive() || t3.isAlive());
		
		System.out.println("*** fin main***");
		

	}

}
