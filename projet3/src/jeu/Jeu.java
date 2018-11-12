package jeu;

import java.util.Scanner;

public abstract class Jeu {
	protected Code propositionDuJoueur;
	protected Code propositionOrdinateur;
	protected String resultatPourLeJoueur;
	protected Code codeATrouverParLeJoueur;
	protected Code codeATrouverParLOrdinateur;
	protected Code codeRestant;
	Code Code = new Code();
	protected int etendue, taille;

	protected Code getPropositionDuJoueur() {
		return propositionDuJoueur;
	}

	protected void setPropositionDuJoueur(Code propositionDuJoueur) {
		this.propositionDuJoueur = propositionDuJoueur;
	}

	protected Code getPropositionOrdinateur() {
		return propositionOrdinateur;
	}

	protected void setPropositionOrdinateur(Code propositionOrdinateur) {
		this.propositionOrdinateur = propositionOrdinateur;
	}

	protected String getResultatPourLeJoueur() {
		return resultatPourLeJoueur;
	}

	protected void setResultatPourLeJoueur(String resultatPourLeJoueur) {
		this.resultatPourLeJoueur = resultatPourLeJoueur;
	}

	protected Code getCodeATrouverParLeJoueur() {
		return codeATrouverParLeJoueur;
	}

	protected Code getCodeATrouverParLOrdinateur() {
		return codeATrouverParLOrdinateur;
	}

	protected void setCodeATrouverParLeJoueur(Code codeATrouverParLeJoueur) {
		this.codeATrouverParLeJoueur = codeATrouverParLeJoueur;
	}

	protected void setcodeATrouverParLOrdinateur(Code codeATrouverParLOrdinateur) {
		this.codeATrouverParLOrdinateur = codeATrouverParLOrdinateur;
	}

	protected Code getCodeRestant() {
		return codeRestant;
	}

	protected void setCodeRestant(Code codeRestant) {
		this.codeRestant = codeRestant;
	}

	protected Code getCode() {
		return Code;
	}

	protected void setCode(Code code) {
		Code = code;
	}

	protected int getEtendue() {
		return etendue;
	}

	protected void setEtendue(int etendue) {
		this.etendue = etendue;
	}

	protected int getTaille() {
		return taille;
	}

	protected void setTaille(int taille) {
		this.taille = taille;
	}

	public abstract String comparerCode();

	public abstract boolean isWon(String resultat);

	public void enterCode() {
		System.out.println("Entrer le code");
		Scanner sc = new Scanner(System.in);
		String prop = sc.nextLine();
		propositionDuJoueur = jeu.Code.extractCode(prop);
	}

	public abstract Code chercherSolution();

	public abstract void analyserResultat(String resultat);

}
