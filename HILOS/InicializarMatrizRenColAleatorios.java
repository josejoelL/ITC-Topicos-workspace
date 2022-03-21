package HILOS;
import java.util.Arrays;
import java.util.Random;
class HiloRenColAleatorio extends Thread {
	int [][] m;
	Random r=new Random();
	static Semaforo [][] s;
	static boolean [][] band=null;
	static Semaforo sinc;
	static int cont=0;
	public HiloRenColAleatorio(int [][] m) {
		this.m=m;
		sinc=new Semaforo(1);
		if(band==null) {
			band=new boolean[m.length][m[0].length];;
			s=new Semaforo[m.length][m[0].length];
			for(int i=0 ; i<s.length ; i++)
				for(int j=0 ; j<s[i].length ; j++) {
					s[i][j]=new Semaforo(1);
					band[i][j]=false;
				}
		}
	}
	public void run() {
		// trabaja con los renglone pares
		int renglon,columna;
		while(HayaRenglones()) {
			renglon=r.nextInt(m.length);
			columna=r.nextInt(m.length);
			s[renglon][columna].Espera();
			if(band[renglon][columna]) {
				sinc.Espera();
				cont++;
				System.out.printf("Re: %4d ",cont);
				sinc.Libera();
				
				if(cont % 20==0)
					System.out.println();
				s[renglon][columna].Libera();
				continue;
			}	
			band[renglon][columna]=true;
			s[renglon][columna].Libera();
			m[renglon][columna]+=(renglon % 2 ==0 ? 7 : 2);
		}
	}
	public boolean HayaRenglones() {
		for(int i=0 ; i<m.length; i++) {
			for(int j=0 ; j<m[0].length ; j++)
				if(m[i][j]==0)
					return true;
		}
		return false;
	}
}
public class InicializarMatrizRenColAleatorios {
	public static void main(String[] args) {
		int [][] m=new int[10][10];
		HiloRenColAleatorio [] h=new HiloRenColAleatorio[100];
		for(int i=0 ; i<h.length ; i++)
			h[i]=new HiloRenColAleatorio(m);
		for(int i=0 ; i<h.length ; i++)
			h[i].start();
		while(HayaVivos(h));
		System.out.println("\n____________________________________");
		for(int i=0 ; i<m.length ; i++) {
			System.out.printf("%4d : ",i);
			for(int j=0 ; j<m[i].length ; j++) {
				System.out.printf("%4d",m[i][j]);
			}
			System.out.println();
		}
	}
	static private boolean HayaVivos(HiloRenColAleatorio [] h) {
		for(int i=0 ; i<h.length ; i++)
				if(h[i].isAlive())
					return true;
		return false;
	}
}
