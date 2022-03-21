package HILOS;

import java.math.BigInteger;
class SumaSemV2 extends Thread {
	static Semaforo S=null;
	static BigInteger A;
	public SumaSemV2() {
		if(S==null)
		   this.S=new Semaforo(1);
		A=BigInteger.ZERO;
		A= new BigInteger ("1234567890123456789012345678901234567000");
	}
    public void run() {
    	incrementa();
    }
    public  void incrementa() {
    	S.Espera();
    	A = A.add(BigInteger.valueOf(1));// REGION,SECCION CRITICA
    	S.Libera();
    	
    }
    public String toString() {
    	return A+"";
    }
}
public class IncrementeASemaforoV2 {


	public static void main(String [] a) {
		
		SumaSemV2 H1=new SumaSemV2();
		SumaSemV2 H2=new SumaSemV2();
		SumaSemV2 H3=new SumaSemV2();

		H1.start();
		H2.start();
		H3.start();
		
		while(H1.isAlive() || H2.isAlive() || H3.isAlive());
		
		System.out.println("A después de tres sumas de 1 = "+H1);
		
		SumaSemV2 [] v=new SumaSemV2[100];
		for(int i=0 ; i<v.length ; i++) {
			v[i]=new SumaSemV2();
//			v[i].start();
		}
		System.out.println("valor inicial de A del vectro de hilos "+v[0]);
		for(int i=0 ; i<v.length ; i++)
			v[i].start();

		while (HayVivos(v));
		System.out.println("valor final de A del vectro de hilos "+v[0]);
	
	}
	private static boolean HayVivos(SumaSemV2 [] v) {
		for(int i=0 ; i<v.length ; i++)
			if(v[i].isAlive())
				return true;
		return false;
	}
}
