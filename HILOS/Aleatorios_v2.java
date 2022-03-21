package HILOS;
import java.util.Random;


class Renglon extends Thread {
	int [][] m;
	int Ini;
	Random R;
	public Renglon(int [][] m,int Ini) {
		this.m=m;
		this.Ini=Ini;
		R=new Random();
	}
	public void run() {
		for(int i=Ini ; i<m.length ; i+=2)
			for(int j=0 ; j<m.length ; j++) {
			   m[i][j]=R.nextInt(100)+1;
			}  
	}
}
public class Aleatorios_v2 {
	public static void main(String [] a) {
		int [][] m=new int[10][10];
		
		Renglon par=new Renglon(m,0);
		Renglon impar=new Renglon(m,1);
		
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
