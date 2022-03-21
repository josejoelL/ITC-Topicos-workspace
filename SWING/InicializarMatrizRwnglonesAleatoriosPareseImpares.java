package HILOS;

import java.util.Arrays;
import java.util.Random;

public class InicializarMatrizRwnglonesAleatoriosPareseImpares {
	static class HiloParAleatorio extends Thread {
		int [][] m;
		Random r=new Random();
		Semaforo [] s;
		static boolean [] band=null;

		public HiloParAleatorio(int [][] m,Semaforo [] s) {
			this.m=m;
			this.s=s;
			if(band==null) {
				band=new boolean[m.length];
				Arrays.fill(band, false);
			}
		}
		public void run() {
			// trabaja con los renglone pares
			int renglon;
			while(HayaRenglones(0)) {
				renglon=r.nextInt(m.length);
				if( renglon % 2 !=0 ) {//no es par
					continue;
				}
				s[renglon].Espera();
				if(band[renglon]) {
					s[renglon].Libera();
					continue;
				}	
				band[renglon]=true;
				s[renglon].Libera();
				for(int j=0 ; j<m[renglon].length ; j++)
				   m[renglon][j]+=7;
			}
		}
		public boolean HayaRenglones(int renglon) {
			
			for(int i=renglon ; i<m.length; i+=2) {
				if(m[i][0]==0)
					return true;
			}
			return false;
			
		}
	}
	static class HiloImParAleatorio extends Thread {
		int [][] m;
		Random r=new Random();
		Semaforo [] s;
		public HiloImParAleatorio(int [][] m, Semaforo [] s) {
			this.m=m;
			this.s=s;
		}
		public void run() {
			// trabaja con los renglone pares
			int renglon;
			while(HayaRenglones(1)) {
				renglon=r.nextInt(m.length);
				if( renglon % 2 ==0 ) {//no es par
					continue;
				}
				s[renglon].Espera();
				if(m[renglon][0]>0) {
					s[renglon].Libera();
					continue;
				}
				for(int j=0 ; j<m[renglon].length ; j++)
				   m[renglon][j]+=2;
				s[renglon].Libera();
			}

		}
		public boolean HayaRenglones(int renglon) {
			
			for(int i=renglon ; i<m.length; i+=2) {
				if(m[i][0]==0)
					return true;
			}
			return false;
			
		}
	}
	
	
	public static void main(String[] args) {
		int [][] m=new int[100][100];
		Semaforo [] s=new Semaforo[m.length];
		for(int i=0 ; i<m.length ; i++)
			s[i]=new Semaforo(1);
		
		HiloParAleatorio hpar=new HiloParAleatorio(m,s);
		HiloParAleatorio hpar2=new HiloParAleatorio(m,s);
		HiloParAleatorio hpar3=new HiloParAleatorio(m,s);

		
		HiloImParAleatorio himpar2=new HiloImParAleatorio(m,s);
		HiloImParAleatorio himpar3=new HiloImParAleatorio(m,s);

		
		HiloImParAleatorio himpar=new HiloImParAleatorio(m,s);

		
		hpar.start();
		himpar.start();

		
		hpar2.start();
		himpar2.start();
		
		hpar3.start();
		himpar3.start();
		
		while(hpar.isAlive() || himpar.isAlive() || hpar2.isAlive() || himpar2.isAlive()
				|| hpar3.isAlive() || himpar3.isAlive());
		// imprimir el contenido de la matriz
		
		for(int i=0 ; i<m.length ; i++) {
			System.out.printf("%4d : ",i);
			for(int j=0 ; j<m[i].length ; j++) {
				System.out.printf("%4d",m[i][j]);
			}
			System.out.println();
		}

	}
	
	
}
