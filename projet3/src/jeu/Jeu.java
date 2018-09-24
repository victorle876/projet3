package jeu;

import java.util.Scanner;


public abstract class Jeu {
	protected Code propositionDuJoueur;
	protected String resultatPourLeJoueur;
	protected Code codeATrouverParLeJoueur;
	protected Code codeRestant;
	Code Code = new Code();
	protected int etendue, taille;

	public Code getProposition() {
		return propositionDuJoueur;
	}

	public void setProposition(Code proposition) {
		this.propositionDuJoueur = proposition;
	}

	public String getResultat() {
		return resultatPourLeJoueur;
	}

	public void setResultat(String resultat) {
		this.resultatPourLeJoueur = resultat;
	}

	public Code getCodeATrouver() {
		return codeATrouverParLeJoueur;
	}

	public void setCodeATrouver(Code codeATrouver) {
		this.codeATrouverParLeJoueur = codeATrouver;
	}
	
	public Code getcodeRestant() {
		return codeRestant;
	}

	public void setCodeRestant(Code codeRestant) {
		this.codeRestant = codeRestant;
	}

	public abstract String comparerCode();
	// public abstract String CreerCode();
	public abstract boolean isWon(String resultat);

	public void enterCode() {
		System.out.println("Entrer le code");
		Scanner sc = new Scanner(System.in);
		String prop = sc.nextLine();
		 propositionDuJoueur = Code.extractCode(prop);
	}
	
	public abstract Code chercherSolution();
	public abstract void analyserResultat(String resultat);

}
