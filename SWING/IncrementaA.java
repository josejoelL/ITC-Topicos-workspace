package HILOS;

import java.math.BigInteger;

class Suma extends Thread {
	//static long A;
	static BigInteger A;
	public Suma() {
		//A=0;
		A=BigInteger.ZERO;
		A= new BigInteger ("1234567890123456789012345678901234567000");
	}
    public void run() {
    	incrementa();// está instruccion no es atómica, se devide en tres instruccione de bajo nivel
    	// A = A.add(BigInteger.valueOf(1));
    }
    static public  void incrementa() {
    	//A++;
    	A = A.add(BigInteger.valueOf(1));
    }
    public String toString() {
    	return A+"";
    }
}
public class IncrementaA {
	
	public static void main(String [] a) {
		
		Suma H1=new Suma();
		Suma H2=new Suma();
		Suma H3=new Suma();

		H1.start();
		H2.start();
		H3.start();
		
		while(H1.isAlive() || H2.isAlive() || H3.isAlive());
		
		System.out.println("A después de tres sumas de 1 = "+H1);
		
		Suma [] v=new Suma[100];
		for(int i=0 ; i<v.length ; i++)
			v[i]=new Suma();
		System.out.println("valor inicial de A del vectro de hilos "+v[0]);
		for(int i=0 ; i<v.length ; i++)
			v[i].start();

		while (HayVivos(v));
		System.out.println("valor final de A del vectro de hilos "+v[0]);
	
	}
	private static boolean HayVivos(Suma [] v) {
		for(int i=0 ; i<v.length ; i++)
			if(v[i].isAlive())
				return true;
		return false;
	}
}
