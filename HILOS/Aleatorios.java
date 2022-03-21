package HILOS;

import java.util.Random;

class Par extends Thread {
	int [][] m;
	Random R;
	public Par(int [][] m) {
		this.m=m;
		R=new Random();
	}
	public void run() {
		for(int i=0 ; i<m.length ; i+=2)
			for(int j=0 ; j<m.length ; j++) {
			   m[i][j]=R.nextInt(100)+1;
			}  
	}
}
class Impar extends Thread {
	int [][] m;
	Random R;
	public Impar(int [][] m) {
		this.m=m;
		R=new Random();
	}
	public void run() {
		for(int i=1 ; i<m.length ; i+=2)
			for(int j=0 ; j<m.length ; j++)
			   m[i][j]=R.nextInt(100)+1;
	}
}
public class Aleatorios {
	public static void main(String [] a) {
		int [][] m=new int[10][10];
		
		Par par=new Par(m);
		Impar impar=new Impar(m);
		impar.start();
		par.start();
		while(par.isAlive() || impar.isAlive());
		
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
