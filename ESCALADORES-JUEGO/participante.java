package Escalador;

import java.util.Random;

public class participante extends Thread{

		private int cmAcendidos,distancia;
		private String nombre;
		private MontañaTorneo MT;
		Random R;
		
		public participante(String nombre) {
			this.nombre=nombre;
			
			cmAcendidos=0;
			R=new Random();
		}
		public void run() {
			
			while (cmAcendidos<1000) {
				int resIntento=R.nextInt(10);     
				if (resIntento==0) {
					int perdidos=R.nextInt(10)+10;
					cmAcendidos-= perdidos;
					System.out.println("participante cm.perdidos "+perdidos+" esta en "+cmAcendidos);
					continue;
				}
				cmAcendidos+= R.nextInt(30)+20 ;
				System.out.println("participante cm.Acendidos : "+cmAcendidos);

				
			}
		}
	public int	getCmAcendidos(){
			return this.cmAcendidos;
		}
	public String getNombre() {
		
	}
	void setMontaña(MontañaTorneo MT) {
		this.MT=MT;
	}
	}

