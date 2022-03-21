package HILOS;

class Tarea1 extends Thread{
   public void run(){
	   for(int i=0 ; i<50 ; i++)
          System.out.println((i+1)+" *** PROCESO UNO TRABAJANDO ");
   }
}

class Tarea2 extends Thread{
   public void run(){
	   for(int i=0 ; i<50 ; i++) {
		   System.out.println((i+1)+" *** PROCESO DOS TRABAJANDO *");
		   if(i % 5==0) {
			   try {
			   sleep(500);
			   } catch (Exception e) {
				   
			   }
		   }   
	   }
   }
}
class Tarea3 extends Thread{
   public void run(){
	   for(int i=0 ; i<50 ; i++)
		      System.out.println((i+1)+" *** PROCESO TRES TRABAJANDO ***");
   }
}

public class Hilos1 {
	   public static void main(String [] a){
	      Tarea1 t1 = new Tarea1();
	      Tarea2 t2 = new Tarea2();
	      Tarea3 t3 = new Tarea3();

	      t1.start();
	      t2.start();
	      t3.start();
	      
	      while (t1.isAlive() || t2.isAlive() || t3.isAlive());

	      
	      System.out.println("________main___________");
	   }
	}

