package HILOS;
import java.math.BigInteger;



class SumaSem extends Thread {
	Semaforo S;
	static BigInteger A;
	public SumaSem(Semaforo S) {
		this.S=S;
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
public class IncrementeASemaforo {
	public static void main(String [] a) {
		Semaforo S=new Semaforo(1);
		SumaSem H1=new SumaSem(S);
		SumaSem H2=new SumaSem(S);
		SumaSem H3=new SumaSem(S);

		H1.start();
		H2.start();
		H3.start();
		
		while(H1.isAlive() || H2.isAlive() || H3.isAlive());
		
		System.out.println("A después de tres sumas de 1 = "+H1);
		
		SumaSem [] v=new SumaSem[100];
		for(int i=0 ; i<v.length ; i++)
			v[i]=new SumaSem(S);
		System.out.println("valor inicial de A del vectro de hilos "+v[0]);
		for(int i=0 ; i<v.length ; i++)
			v[i].start();

		while (HayVivos(v));
		System.out.println("valor final de A del vectro de hilos "+v[0]);
	
	}
	private static boolean HayVivos(SumaSem [] v) {
		for(int i=0 ; i<v.length ; i++)
			if(v[i].isAlive())
				return true;
		return false;
	}
}
