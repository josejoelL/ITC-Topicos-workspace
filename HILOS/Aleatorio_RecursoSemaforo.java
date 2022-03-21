package HILOS;
import java.util.Arrays;
import java.util.Random;

class RenglonAleatorioSem extends Thread {
	int [][] m;
	Random R;
	static boolean [] Band;
	static Semaforo [] S=null;
	public RenglonAleatorioSem(int [][] m) {
		this.m=m;
		R=new Random();
		
		if(S==null) {
			Band=new boolean[m.length];
			System.out.println("creando los semaforos de la aplicación "+m.length);			
			Arrays.fill(Band,true);// todos los renglones de la matriz están disponible para calcularse
			S=new Semaforo[m.length];
			for(int i=0 ; i<m.length ; i++)
				S[i]=new Semaforo(1);
		}
	}
	public void run() {
		

		while(Verifica()) {
			int Renglon=R.nextInt(m.length);
			S[Renglon].Espera();
			if( ! Band[Renglon] ) {
				S[Renglon].Libera();
				continue;
			}
			Band[Renglon]=false;
			S[Renglon].Libera();
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
public class Aleatorio_RecursoSemaforo {
	public static void main(String [] a) {
		int [][] m=new int[10][10];

		RenglonAleatorioSem Obj1=new RenglonAleatorioSem(m);
		RenglonAleatorioSem Obj2=new RenglonAleatorioSem(m);
		RenglonAleatorioSem Obj3=new RenglonAleatorioSem(m);

		Obj3.start();
		Obj1.start();
		Obj2.start();
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
