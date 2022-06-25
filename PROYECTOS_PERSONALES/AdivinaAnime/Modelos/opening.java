package Modelos;

public class opening {
	private int opID;
	private String	opNom;
	private String opRuta;
	private anime anime;
	public opening(int opID, String opNom, String opRuta, Modelos.anime anime) {
		super();
		this.opID = opID;
		this.opNom = opNom;
		this.opRuta = opRuta;
		this.anime = anime;
	}
	public int getOpID() {
		return opID;
	}
	public void setOpID(int opID) {
		this.opID = opID;
	}
	public String getOpNom() {
		return opNom;
	}
	public void setOpNom(String opNom) {
		this.opNom = opNom;
	}
	public String getOpRuta() {
		return opRuta;
	}
	public void setOpRuta(String opRuta) {
		this.opRuta = opRuta;
	}
	public anime getAnime() {
		return anime;
	}
	public void setAnime(anime anime) {
		this.anime = anime;
	}
	
}
