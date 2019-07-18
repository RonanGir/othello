package jeu;

public enum Pion {
	 LIBRE('·'),
	 BLANC('o'),
	 NOIR( '●');
	
	// Attributs
	private char symbol;
	private int nombre;
	
	
	// Constructeurs
	private Pion(char symbol) {
		this.setSymbol(symbol);
		nombre = 64;
	}
	
	
	// Accesseurs
	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}


	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	
	public Pion autrePion() {
		// TODO
		return null;
		
	}
	
	public int gagne(int nombre) {
		// TODO
		return nombre;
		
	}

}
