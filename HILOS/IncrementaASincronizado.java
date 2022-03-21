package HILOS;
class IncrementaAS extends Thread{
    private static int A=0;
    public void run(){
       HazSuma();
    }
    public synchronized void HazSuma() {
	 A++;
   }
    public String toString() {
        return A+"";
    }
}

public class IncrementaASincronizado {
	public static void main(String [] a) {
/*		
		IncrementaAS H1=new IncrementaAS();
		IncrementaAS H2=new IncrementaAS();
		IncrementaAS H3=new IncrementaAS();
		
		H1.start();
		H2.start();
		H3.start();
		
		while(H1.isAlive() || H2.isAlive() || H3.isAlive())
;
		System.out.println(H1);
*/
		IncrementaAS Obj=new IncrementaAS();
		
		Thread H1=new Thread(Obj);
		Thread H2=new Thread(Obj);
		Thread H3=new Thread(Obj);
		
		H1.start();
		H2.start();
		H3.start();
		
		while(H1.isAlive() || H2.isAlive() || H3.isAlive());
		
		System.out.println(Obj);
	}
}
