package jeu;

import java.util.Scanner;

public abstract class Jeu {
	protected Code propositionDuJoueur;
	protected Code propositionJoueur;
	protected Code propositionOrdinateur;
	protected Code propositionHumain;
	protected String resultatPourLeJoueur;
	protected Code codeATrouverParLeJoueur;
	protected Code codeATrouverParLOrdinateur;
	protected Code codeRestant;
	Code code = new Code();
	protected int etendue, taille;

	protected Code getPropositionDuJoueur() {
		return propositionDuJoueur;
	}

	protected void setPropositionDuJoueur(Code propositionDuJoueur) {
		this.propositionDuJoueur = propositionDuJoueur;
	}
	
	protected Code getPropositionJoueur() {
		return propositionJoueur;
	}

	protected void setPropositionJoueur(Code propositionJoueur) {
		this.propositionJoueur = propositionJoueur;
	}

	protected Code getPropositionOrdinateur() {
		return propositionOrdinateur;
	}

	protected void setPropositionOrdinateur(Code propositionOrdinateur) {
		this.propositionOrdinateur = propositionOrdinateur;
	}
	
	protected Code getPropositionHumain() {
		return propositionHumain;
	}

	protected void setPropositionHumain(Code propositionHumain) {
		this.propositionHumain = propositionHumain;
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
		return code;
	}

	protected void setCode(Code code) {
		this.code = code;
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
	
	 /**
	 * Pour le jeu PlusouMoins
     * Méthode permettant de comparer le code à trouver avec celui des différntes
     * propositions de l'ordinateur
     * Et ensuite, de donner le résultat à l'ordinateur
     */
	public abstract String comparerCode();

	public abstract boolean isGagne(String resultat);
	
	/**
	 * Méthode permettant d'entrer les caractères à la console
	 * et d'en faire une extraction via une autre méthode
	 * 
	 */

	public void enterCode() {
		System.out.println("Entrer le code");
		Scanner sc = new Scanner(System.in);
		String prop = sc.nextLine();
		propositionDuJoueur = jeu.Code.extraireCode(prop);
	}

	/**
	 * Jeu PlusouMoins:
	 * Pour chaque chiffre du code, je propose la moitié entre le min et le max de
	 * ce chiffre Je construit donc un code proposé à partir de ces valeurs
	 * Mastermind:
	  * Methode permettant de construire une liste de codes proposées par l'ordinateur
     * et de sélectionner par rapport à la liste de codes existants à trouver
	 */
	public abstract Code chercherSolution();
	public abstract String demanderAnalyse();

	/**
	 * Jeu PlusouMoins: 
	 * pour chaque chiffre du code, selon la valeur du résultat correspondant, je
	 * repositionne mon min ou mon max si le chiffre est trop grand, le max devient
	 * ce chiffre si le chiffre est trop petit, le min devient ce chiffre si le
	 * chiffre est le bon, min et max deviennent ce chiffre
	 * Mastermind:
	 * Méthode permettant de trouver les chiffres bien placés par comparaison et les 
	 * supprimer
	 * si les chiffres sonnt malplacés, on les comptabilie et les supprime
	 * @param proposition: code proposé par l'attaquant
	 * @param codeTofind: code à trouver par l'attaquant
	 * @return
	 */
	public abstract void analyserResultat(String resultat);

}
 