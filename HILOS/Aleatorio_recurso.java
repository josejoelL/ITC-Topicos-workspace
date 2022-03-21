package HILOS;
import java.util.Arrays;
import java.util.Random;

class RenglonAleatorio extends Thread {
	int [][] m;
	Random R;
	static boolean [] Band;

	public RenglonAleatorio(int [][] m) {
		this.m=m;
		R=new Random();
		Band=new boolean[m.length];

		Arrays.fill(Band,true);// todos los renglones de la matriz están disponible para calcularse
	}
	public void run() {
		

		while(Verifica()) {
			int Renglon=R.nextInt(m.length);
// semaforo del renglon ccorrespondiente
			if( ! Band[Renglon])
				continue;
			Band[Renglon]=false;
// terminar la seccion critica
			for(int j=0 ; j<m.length ; j++) {
			   m[Renglon][j]+=1;//    R.nextInt(100)+1;
			}  
		}	

	}
	private boolean Verifica() {
		for(int i=0 ; i<Band.length ; i++)
			if(Band[i])
				return true;
		return false;
	}
}
public class Aleatorio_recurso {
	public static void main(String [] a) {
		int [][] m=new int[10][10];

		RenglonAleatorio Obj1=new RenglonAleatorio(m);
		RenglonAleatorio Obj2=new RenglonAleatorio(m);
		RenglonAleatorio Obj3=new RenglonAleatorio(m);

		Obj1.start();
		Obj2.start();
		Obj3.start();

		while(Obj1.isAlive() || Obj2.isAlive() || Obj3.isAlive());

		Imprime(m);
	}
	static private void Imprime(int [][] m) {
		for(int i=0 ; i<m.length ; i++) {
			for(int j=0 ; j<m.length ; j++) {
				System.out.printf("%4d ",m[i][j]);
			}
			System.out.println();
		}
	}	
}
