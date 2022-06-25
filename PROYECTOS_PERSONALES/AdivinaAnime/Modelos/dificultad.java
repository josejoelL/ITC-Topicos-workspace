package Modelos;

public class dificultad {
	private int difiID;
	private String difiNom;

	public dificultad(int difiID, String difiNom) {
		super();
		this.difiID = difiID;
		this.difiNom = difiNom;
	}

	public int getDifiID() {
		return difiID;
	}

	public void setDifiID(int difiID) {
		this.difiID = difiID;
	}

	public String getDifiNom() {
		return difiNom;
	}

	public void setDifiNom(String difiNom) {
		this.difiNom = difiNom;
	}
}
