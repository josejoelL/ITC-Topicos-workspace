package Modelos;

 public class GanoLaRonda {

	private boolean hayGanador = false;
	
	public synchronized boolean DecidioAnime() {
		
    if(!hayGanador) {
	        hayGanador = true;  
	       return true; 
	    }
    return false;
	}
	public void setHayGanador(){
		 hayGanador = false;
	}
}
