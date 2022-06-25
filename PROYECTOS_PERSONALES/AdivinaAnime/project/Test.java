package project;

public class Test {
/*
	public Test() {
		// TODO Auto-generated constructor stub
		
	}*/

	public static void main(String[] args) {
		int rondas =5;
		int Dificultad =1;
		Modelo AdivinaAnime =new Modelo();
		System.out.println("se genero una ronda de "+rondas+" animes de nivel :"+ Dificultad);
		AdivinaAnime.iniciaRonda(rondas, Dificultad);
		
	}

}
