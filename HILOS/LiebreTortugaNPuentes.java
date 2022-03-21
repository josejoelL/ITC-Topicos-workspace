package HILOS;

import java.util.Random;

class LiebreP extends Thread{
	private int kmRecorridos,NoPuente;
	Puente [] VP;
	Random R;
	boolean Tiene;
	public LiebreP(Puente [] VP) {
		kmRecorridos=0;
		NoPuente=0;
		this.VP=VP;
		Tiene=false;
	}
	public void run() { 
		int Cont=0;
		while (kmRecorridos<100) {
			kmRecorridos+= 1;// R.nextInt(2)+2 ;
			System.out.println(this.getName()+", Km "+kmRecorridos+"  puente--> "+ NoPuente);
			if(NoPuente<VP.length ) {
				switch ( VP[NoPuente].Verifica(kmRecorridos,Tiene)) {
				     case 1: Tiene=true;
				             break;
				     case 2:NoPuente++;
				            Tiene=false;
				            break;
				}
			}	
		}
	}
}
	class TortugaP extends Thread{
		private int kmRecorridos,NoPuente;
		private Puente [] VP;
		private boolean Tiene;
		public TortugaP(Puente [] VP) {
			kmRecorridos=0;
			NoPuente=0;
			this.VP=VP;
			Tiene=false;
		}
		public void run() {

			while (kmRecorridos<100) {
				kmRecorridos+= 1;
				System.out.println(this.getName()+",  Km "+kmRecorridos+"  puente--> "+ NoPuente);
				if(NoPuente<VP.length ) {
					switch ( VP[NoPuente].Verifica(kmRecorridos,Tiene)) {
					   case 1: Tiene=true;
					           break;
					   case 2:	NoPuente++;
					            Tiene=false;
					            break;
					}
				}
			}
		}		
	}
public class LiebreTortugaNPuentes {

	public static void main(String [] a) {
		Puente [] VP=new Puente[4];
		VP[0]=new Puente(2,35,2);
		VP[1]=new Puente(50,60);
		VP[2]=new Puente(75,85);
		VP[3]=new Puente(92,98);

		LiebreP Lie=new LiebreP(VP);
		Lie.setName("Liebre # 1 ");
		LiebreP Lie2=new LiebreP(VP);
		Lie2.setName("Liebre # 2 ");
		TortugaP Tor=new TortugaP(VP);
		Tor.setName("Tortuga # 1 ");
		Lie.start();
		Tor.start();
		Lie2.start();
	}
	
	
}
