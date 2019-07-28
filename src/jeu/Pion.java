package jeu;

import Outils.Outils;

public enum Pion {
	LIBRE, BLANC, NOIR;

	// Attributs
	private int nombre = 2;
	private Joueur joueur;

	// Constructeurs
	private Pion() {

	}

	// Accesseurs
	public int getNombre() {
		return nombre;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	// Méthodes
	public char getSymbole() {
		char ret;
		switch (this) {
		case BLANC:
			ret = '●';
			break;
		case NOIR:
			ret = 'o';
			break;
		default:
			ret = '·';
			break;
		}
		return ret;
	}

	public Pion autrePion() {
		Pion autre;
		switch (this) {
		case BLANC:
			autre = Pion.NOIR;
			break;
		case NOIR:
			autre = Pion.BLANC;
			break;
		default:
			autre = Pion.LIBRE;
			break;
		}
		return autre;

	}

	public void gagne(int nombre) {
		this.nombre += nombre + 1;
		this.autrePion().nombre -= nombre;
	}

	public void choixJoueur() {
		String m = String.format("Quel joueur pour les pions %s ?%n " + "1 - Humain%n 2 - Ordinateur",
				this.getSymbole());
		int c = Outils.saisie(m, 1, 2);
		if (c == 1)
			this.joueur = new JoueurHumain();
		else
			this.joueur = new IAalea();
	}

}
