package HILOS;
class IncrementaASem extends Thread{
    private static int A=0;
    static Semaforo S;
    public IncrementaASem() {
    	if(S==null) {
    		S=new Semaforo(1);
    	    System.out.println("creando semaforo ");
    	}
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
public class IncrementeASemaforo {
	public static void main(String [] a) {

		IncrementaASem H1=new IncrementaASem();
		H1.start();
		IncrementaASem H2=new IncrementaASem();
		H2.start();
		IncrementaASem H3=new IncrementaASem();
		H3.start();
		
		while(H1.isAlive() || H2.isAlive() || H3.isAlive()); 
		
		
		System.out.println(H1);
		
	}
}
