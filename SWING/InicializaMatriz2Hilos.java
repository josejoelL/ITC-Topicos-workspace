package HILOS;

public class InicializaMatriz2Hilos {

	static class HiloRenPar extends Thread {
		int [][] m;
		
		public HiloRenPar(int [][] m) {
			this.m=m;
		}
		public void run() {
			for(int ren=0 ; ren<m.length ; ren+=2) {
				for(int col=0 ; col < m[ren].length ; col++) {
					m[ren][col]=1;
				}
			}
			
		}
	}
	static class HiloRenImPar extends Thread {
		int [][] m;
		
		public HiloRenImPar(int [][] m) {
			this.m=m;
		}
		public void run() {
			for(int ren=1 ; ren<m.length ; ren+=2) {
				for(int col=0 ; col < m[ren].length ; col++) {
					m[ren][col]=2;
				}
			}
			
		}
	}
	
	public static void main(String[] args) {
		int [][] m=new int[10][10];
		
		HiloRenPar hpar=new HiloRenPar(m);

		
		HiloRenImPar himpar=new HiloRenImPar(m);

		
		hpar.start();
		himpar.start();


		
		while(hpar.isAlive() || himpar.isAlive() );
		// imprimir el contenido de la matriz
		
		for(int i=0 ; i<m.length ; i++) {
			for(int j=0 ; j<m[i].length ; j++) {
				System.out.printf("%4d",m[i][j]);
			}
			System.out.println();
		}

	}

}
