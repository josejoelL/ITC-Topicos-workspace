package HILOS;
import java.util.Arrays;
import java.util.Random;

class RenglonAleatorioRenCol extends Thread {
	long [][] m;
	Random R;
	static boolean [][] Band;
	static Semaforo [][] S=null;

	public RenglonAleatorioRenCol(long [][] m) {
		this.m=m;
		R=new Random();
		if(S==null) {
			Band=new boolean[m.length][m.length];
			S=new Semaforo[m.length][m.length];
			for(int i=0 ; i<m.length ; i++)
				for(int j=0 ; j<m.length ; j++) {
					Band[i][j]=true;
					S[i][j]=new Semaforo(1);
				}	
		}
	}
	public void run() {
		int Renglon,Columna;

		while(Verifica()) {
			Renglon=R.nextInt(m.length);
			Columna=R.nextInt(m.length);
			S[Renglon][Columna].Espera();
			if( ! Band[Renglon][Columna]   ) {
				S[Renglon][Columna].Libera();
				continue;
			}	
			Band[Renglon][Columna]=false;
			S[Renglon][Columna].Libera();

			m[Renglon][Columna]+=1;//    R.nextInt(100)+1;

		}	
	}
	private boolean Verifica() {
		for(int i=0 ; i<Band.length ; i++)
			for(int j=0 ; j<m.length ; j++)
			if(Band[i][j])
				return true;
		return false;
	}
}
public class Aleatorio_recursoRenCol {
	public static void main(String [] a) {
		long [][] m=new long[20][20];
/*
		RenglonAleatorioRenCol Obj1=new RenglonAleatorioRenCol(m);
		RenglonAleatorioRenCol Obj2=new RenglonAleatorioRenCol(m);
		RenglonAleatorioRenCol Obj3=new RenglonAleatorioRenCol(m);

		Obj1.start();
		Obj2.start();
		Obj3.start();

		while(Obj1.isAlive() || Obj2.isAlive() || Obj3.isAlive());

		Imprime(m);
*/
		RenglonAleatorioRenCol [] H=new RenglonAleatorioRenCol[1000];
		for(int i=0 ; i<H.length ; i++)
			H[i]=new RenglonAleatorioRenCol(m);
		for(int i=0 ; i<H.length ; i++)
			H[i].start();
		while(Verifica(H));
		Imprime(m);
	}
	static private void Imprime(long [][] m) {
		for(int i=0 ; i<m.length ; i++) {
			for(int j=0 ; j<m.length ; j++) {
				System.out.printf("%4d ",m[i][j]);
			}
			System.out.println();
		}
	}
	static private boolean Verifica(RenglonAleatorioRenCol [] H) {
		for(int i=0 ; i<H.length ; i++)
			if(H[i].isAlive())
				return true;
		return false;
	}
}
