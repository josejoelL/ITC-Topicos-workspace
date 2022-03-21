package HILOS;
class IncrementaASemV2 extends Thread{
    private static long A=0;
    Semaforo S;
    public IncrementaASemV2(Semaforo S) {
   		this.S=S;
    }
    public void run(){
    	
    	S.Espera();
          A++;
        S.Libera();
    }

    public String toString() {
        return A+"";
    }
}
public class IncrementeASemaforoV2 {

	public static void main(String [] a) {

		Semaforo S=new Semaforo(0);
		
		IncrementaASemV2 H1=new IncrementaASemV2(S);
		IncrementaASemV2 H2=new IncrementaASemV2(S);
		IncrementaASemV2 H3=new IncrementaASemV2(S);

		H3.start();
		H1.start();
		H2.start();

		while(H1.isAlive() || H2.isAlive() || H3.isAlive()); 


		System.out.println(H1);
	}
}
