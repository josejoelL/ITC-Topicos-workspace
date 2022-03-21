package componentes;

public class meta {

	private boolean hayGanador = false;
	
	public synchronized boolean cruzarMeta() {
		
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

