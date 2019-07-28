package jeu;

import java.util.Random;

public class IAalea implements Joueur {
	private static Random r = new Random();

	@Override
	public int[] jouer(PlateauDeReversi p, Pion couleur) {
		int[] coord = new int[2];
		do {
			coord[LIGNE] = r.nextInt(PlateauDeReversi.TAILLE);
			coord[COLONNE] = r.nextInt(PlateauDeReversi.TAILLE);
		} while (p.tester(couleur, coord[LIGNE], coord[COLONNE]) == 0);

		return coord;
	}


	@Override
	public String getNom() {
		return "IA Aléatoire";
	}

}
