package HILOS;

class Suma extends Thread {
	static private long A;
	
	public void run() {
		
	/*	--
		---
		---- 12 MINUTOS
		----*/
		// semaforo A
		A++; // recurso compartido entre dif hilos, atómico, sección(región) crítica
		//SEMAFORO A EN VERDE

		/*	-- 8 MINUTOS
		---*/
		
	}
	public String toString() {
		return A+"";
	}
}

public class IncrementaA {
	
	public static void main(String [] a) {
/*		
		Suma H1=new Suma();
		Suma H2=new Suma();
		Suma H3=new Suma();
		Suma H4=new Suma();
		Suma H5=new Suma();

		H1.start();
		H2.start();
		H3.start();
		H4.start();
		H5.start();
		
		while(H1.isAlive() || H2.isAlive() || H3.isAlive()|| H4.isAlive() || H5.isAlive());
		
		System.out.println("A= "+H1);
*/
		Suma [] v=new Suma[5];
		for(int i=0 ; i < v.length ; i++)
			v[i]=new Suma();
		for(int i=0 ; i < v.length ; i++)
		    v[i].start();
		
		while(Verifica(v));
		
		System.out.println("A= "+v[0]);
	
		
	}
	static private boolean Verifica(Suma [] a) {
		for(int i=0 ; i<a.length ; i++)
			if(a[i].isAlive())
				return true;
		
		return false;
	}
}
