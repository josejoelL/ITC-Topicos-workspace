package Modelos;

public class genero {
	private int genID;
	private String genNom;
	
	public int getGenID() {
		return genID;
	}

	public void setGenID(int genID) {
		this.genID = genID;
	}

	public String getGenNom() {
		return genNom;
	}

	public void setGenNom(String genNom) {
		this.genNom = genNom;
	}

	public genero(int genID, String genNom) {
		super();
		this.genID = genID;
		this.genNom = genNom;
	}
}
