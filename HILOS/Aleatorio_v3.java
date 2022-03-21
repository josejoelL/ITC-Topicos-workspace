package HILOS;
import java.util.Random;

class Renglonv2 extends Thread {
	int [][] m;
	int Ini,Inc;
	Random R;
	public Renglonv2(int [][] m,int Ini,int Inc) {
		this.m=m;
		this.Ini=Ini;
		this.Inc=Inc;
		R=new Random();
	}
	public void run() {
		for(int i=Ini ; i<m.length ; i+=Inc)
			for(int j=0 ; j<m.length ; j++) {
			   m[i][j]=R.nextInt(100)+1;
			}  
	}
}
public class Aleatorio_v3 {
	boolean Band=true;
	public static void main(String [] a) {
		int [][] m=new int[10][10];
/*		
		Renglonv2 Obj1=new Renglonv2(m,0,3);
		Renglonv2 Obj2=new Renglonv2(m,1,3);
		Renglonv2 Obj3=new Renglonv2(m,2,3);
		
		Obj1.start();
		Obj2.start();
		Obj3.start();

		while(Obj1.isAlive() || Obj2.isAlive() || Obj3.isAlive());
		
		Imprime(m);
*/
		Renglonv2 [] v=new Renglonv2[100];
		for(int i=0 ; i<v.length ; i++)
			v[i]=new Renglonv2(m,i,v.length);
		for(int i=0 ; i<v.length ; i++)
			v[i].start();
		while(Verifica(v));
		Imprime(m);
		
	}
	static private boolean Verifica(Renglonv2 [] a) {
		for(int i=0 ; i<a.length ; i++)
			if(a[i].isAlive())
				return true;
		return false;
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
