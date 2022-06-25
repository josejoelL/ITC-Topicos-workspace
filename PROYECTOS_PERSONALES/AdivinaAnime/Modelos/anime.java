package Modelos;

public class anime {
private int animeID;
private String animeNom;
private int animeYear;
private String animeFotoRuta;
private dificultad dificultad;
private genero genero;


public anime(int animeID, String animeNom, int animeYear, String animeFotoRuta, Modelos.dificultad dificultad,
		Modelos.genero genero) {
	super();
	this.animeID = animeID;
	this.animeNom = animeNom;
	this.animeYear = animeYear;
	this.animeFotoRuta = animeFotoRuta;
	this.dificultad = dificultad;
	this.genero = genero;
}


public int getAnimeID() {
	return animeID;
}


public void setAnimeID(int animeID) {
	this.animeID = animeID;
}


public String getAnimeNom() {
	return animeNom;
}


public void setAnimeNom(String animeNom) {
	this.animeNom = animeNom;
}


public int getAnimeYear() {
	return animeYear;
}


public void setAnimeYear(int animeYear) {
	this.animeYear = animeYear;
}


public String getAnimeFotoRuta() {
	return animeFotoRuta;
}


public void setAnimeFotoRuta(String animeFotoRuta) {
	this.animeFotoRuta = animeFotoRuta;
}


public dificultad getDificultad() {
	return dificultad;
}


public void setDificultad(dificultad dificultad) {
	this.dificultad = dificultad;
}


public genero getGenero() {
	return genero;
}


public void setGenero(genero genero) {
	this.genero = genero;
}


}
