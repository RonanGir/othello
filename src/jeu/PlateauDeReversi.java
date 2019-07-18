package jeu;

public class PlateauDeReversi {
	
	// Attributs
	private Pion[][] plateau;
	private static final int LIGNES = 8;
	private static final int COLONNES = 8;
	

	// Constructeurs
	public PlateauDeReversi() {
		
	}

	public PlateauDeReversi(Pion p) {
		// TODO
		this.plateau = new Pion[LIGNES][COLONNES];
	}
	
	
	public void afficher() {
		// TODO écrire les scores et dessiner le plateau
		System.out.println();
	}
	
	public int tester(Pion p, Pion[] numLigne, Pion[][] numColonne) {
		// TODO donne une indication au joueur du nomnbre de pion qu'il mange, avant qu' il joue son coup
		return 0;
	}
	
	public void peutJouer(Pion p) {
		// TODO Teste s'il existe au moins une position où il est possible de poser le pion du joueur 
	}
	
	public void poser(Pion p, Pion[] numLigne, Pion[][] numColonne) {
		// TODO Positionne et change la couleur de tous les pions capturer par le coup
	}

	public void jouer() {
		// TODO Créer deux joueurs et les faire jouer à tour de rôle
	}
	

}
