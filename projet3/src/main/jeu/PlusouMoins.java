package main.jeu;

import java.util.ArrayList;

public class PlusouMoins extends Jeu {
	private ArrayList<Integer> min = new ArrayList<>();
	private ArrayList<Integer> max = new ArrayList<>();

	/**
	 * Méthode permettant d'ajouter 0 à l'ArrayList Min et etendue ArrayListMax
	 *
	 * @param etendue: la plage définie sur le jeu à 1 chiffres
	 * @param taille: nombre de chiffres que comporte le code
	 */
	public PlusouMoins(int etendue, int taille) {
		this.etendue = etendue;
		this.taille = taille;
		this.propositionOrdinateur = new Code();
		for (int i = 0; i < taille; i++) {
			min.add(0);
			max.add(etendue);
		}
	}

	@Override
	public String comparerCode() {
		resultatPourLeJoueur = "";
		for (int i = 0; i < codeATrouverParLeJoueur.size(); i++) {
			int propositionAttaquant = propositionDuJoueur.get(i);
			int propositionDefenseur = codeATrouverParLeJoueur.get(i);
			if (propositionAttaquant == propositionDefenseur) {
				resultatPourLeJoueur += "=";
			} else if (propositionAttaquant > propositionDefenseur) {

				resultatPourLeJoueur += "-";
			} else {
				resultatPourLeJoueur += "+";
			}
			// }

		}
		return resultatPourLeJoueur;

	}

	@Override
	public boolean isGagne(String resultat) {
		return (resultat.matches("^=+$"));
	}

	@Override
	public Code chercherSolution() {

		Integer chiffre;
		this.propositionOrdinateur.clear();
		for (int i = 0; i < this.taille; i++) {
			chiffre = new Integer((min.get(i) + max.get(i)) / 2);
			this.propositionOrdinateur.add(chiffre);
		}
		return this.propositionOrdinateur;
	}

	public String demanderAnalyse() {
		// todo

		String resultatParAttaquant = Aide.askString("=+-", "Entrer le résultat de chaine");

		return resultatParAttaquant;
	}

	@Override
	public void analyserResultat(String resultat) {
		for (int i = 0; i < resultat.length(); i++) {
			if (resultat.charAt(i) == '-') {
				min.set(i, this.propositionOrdinateur.get(i) + 1);

			} else if (resultat.charAt(i) == '+') {
				max.set(i, this.propositionOrdinateur.get(i) - 1);

			} else if (resultat.charAt(i) == '=') {
				min.set(i, this.propositionOrdinateur.get(i));
				max.set(i, this.propositionOrdinateur.get(i));

			}
		}
	}

};
