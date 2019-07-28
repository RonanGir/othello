package jeu;

public interface Joueur {
	static final int LIGNE = 0;
	static final int COLONNE = 1;
	
	int[] jouer(PlateauDeReversi p, Pion couleur);
	String getNom();

}
