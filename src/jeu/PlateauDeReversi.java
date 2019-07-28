package jeu;

import javax.sound.midi.Soundbank;

import Outils.Outils;

public class PlateauDeReversi {

	// Attributs
	static final int TAILLE = 8;
	private Pion[][] plateau;

	// Constructeur
	public PlateauDeReversi() {
		this.plateau = new Pion[TAILLE][TAILLE];
		for (int j = 0; j < TAILLE; j++) {
			for (int i = 0; i < TAILLE; i++) {
				plateau[j][i] = Pion.LIBRE;
			}
		}
		this.plateau[TAILLE / 2][TAILLE / 2] = Pion.BLANC;
		this.plateau[TAILLE / 2 - 1][TAILLE / 2] = Pion.NOIR;
		this.plateau[TAILLE / 2][TAILLE / 2 - 1] = Pion.NOIR;
		this.plateau[TAILLE / 2 - 1][TAILLE / 2 - 1] = Pion.BLANC;
	}

	// Méthodes

	public void afficher() {
		// TODO écrire les scores et dessiner le plateau
		// Affichage des scores
		System.out.printf("%2d %s%n%2d %s%n", Pion.NOIR.getNombre(), Pion.NOIR.getSymbole(), Pion.BLANC.getNombre(),
				Pion.BLANC.getSymbole());
		// Affichage du plateau de jeu
		System.out.print(" ");
		for (int i = 1; i <= TAILLE; i++)
			System.out.printf("%d ", i);
		System.out.println();
		for (int j = 0; j < TAILLE; j++) {
			System.out.printf("%d ", j + 1);
			for (int i = 0; i < TAILLE; i++) {
				System.out.printf("%s ", plateau[j][i].getSymbole());
			}
			System.out.println();
		}
	}

	public int tester(Pion couleur, int y, int x) {
		// TODO donne une indication au joueur du nombre de pion qu'il mange, avant qu'
		// il joue son coup
		int nbPions = 0;
		if (plateau[y][x] == Pion.LIBRE)
			for (int dy = -1; dy <= 1; dy++)
				for (int dx = -1; dx <= 1; dx++)
					if (dx != 0 || dy != 0)
						nbPions += testerDirection(couleur, y, x, dy, dx);
		return nbPions;
	}

	public boolean peutJouer(Pion joueur) {
		boolean positionJouable = false;
		int j = 0;
		while (j < TAILLE && !positionJouable) {
			int i = 0;
			while (i < TAILLE && !positionJouable) {
				positionJouable = tester(joueur, j, i) > 0;
				i++;
			}
			j++;
		}
		return positionJouable;

	}

	public void poser(Pion couleur, int x, int y) {
		this.plateau[y][x] = couleur;
		int nbPions;
		for (int dy = -1; dy <= 1; dy++)
			for (int dx = -1; dx <= 1; dx++) {
				nbPions = 0;
				if (dx != 0 || dy != 0) {
					nbPions += testerDirection(couleur, y, x, dy, dx);
					for (int k = 1; k <= nbPions; k++)
						this.plateau[y + dy * k][x + dx * k] = couleur;
				}
			}

	}

	

	private int testerDirection(Pion couleur, int y, int x, int dy, int dx) {
		Pion couleurOpp = couleur.autrePion();
		int nbAutres = 0;
		int i = x + dx;
		int j = y + dy;
		while (0 <= i && i < TAILLE && 0 <= j && j < TAILLE && this.plateau[j][i] == couleurOpp) {
			nbAutres++;
			i += dx;
			j += dy;
		}
		if (i < 0 || i >= TAILLE || j < 0 || j >= TAILLE || this.plateau[j][i] != couleur)
			nbAutres = 0;
		return nbAutres;
	}

	public void jouer() {
		Pion.NOIR.choixJoueur();
		Pion.BLANC.choixJoueur();
		Pion courant = Pion.NOIR;
		int nbPasseTour = 0;
		while (nbPasseTour < 2 && Pion.BLANC.getNombre() + Pion.NOIR.getNombre() < TAILLE * TAILLE) {
			System.out.printf("Au tour de %s (%s)...%n", courant.getJoueur().getNom(), courant.getSymbole());
			int nbRetournes = 0;
			boolean ok = false;
			do {
				this.afficher();
				if (this.peutJouer(courant)) {
					int[] coord = courant.getJoueur().jouer(this, courant);
					nbRetournes = this.tester(courant, coord[Joueur.LIGNE], coord[Joueur.COLONNE]);
					if (nbRetournes > 0) {
						this.poser(courant, coord[Joueur.LIGNE], coord[Joueur.COLONNE]);
						courant.gagne(nbRetournes);
						nbPasseTour = 0;
						ok = true;
					} else {
						System.err.println("Position illégale");
					}
				} else {
					System.out.printf("%s n'a aucune position où poser " + "un de ses pions. Il passe sont tour.%n",
							courant.getSymbole());
					nbPasseTour++;
					ok = true;
				}
			} while (!ok);
			// changement de joueur
			courant = courant.autrePion();
		}
		if (Pion.BLANC.getNombre() > Pion.NOIR.getNombre()) {
			System.out.printf("%s (%s) gagne !%n", Pion.BLANC.getJoueur().getNom(), Pion.BLANC.getSymbole());
		} else if (Pion.BLANC.getNombre() < Pion.NOIR.getNombre()) {
			System.out.printf("%s (%s) gagne !%n", Pion.NOIR.getJoueur().getNom(), Pion.NOIR.getSymbole());
		} else {
			System.out.println("Égalité !");
		}
		this.afficher();
	}

}
