package jeu;

import java.util.ArrayList;

public class PlusouMoins extends Jeu {
	private ArrayList<Integer> min = new ArrayList<>();
	private ArrayList<Integer> max = new ArrayList<>();

	// Constructeur
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
	public boolean isWon(String resultat) {
		return (resultat.matches("^=+$"));
	}

	@Override
	public Code chercherSolution() {
		/*
		 * Pour chaque chiffre du code, je propose la moitié entre le min et le max de
		 * ce chiffre Je construit donc un code proposé à partir de ces valeurs
		 */
		Integer chiffre;
		this.propositionOrdinateur.clear();
		for (int i = 0; i < this.taille; i++) {
			chiffre = new Integer((min.get(i) + max.get(i)) / 2);
			this.propositionOrdinateur.add(chiffre);
		}
		return this.propositionOrdinateur;
	}
	public void demandeAnalyse() {
		//todo
	}

	@Override
	public void analyserResultat(String resultat) {
		/*
		 * pour chaque chiffre du code, selon la valeur du résultat correspondant, je
		 * repositionne mon min ou mon max si le chiffre est trop grand, le max devient
		 * ce chiffre si le chiffre est trop petit, le min devient ce chiffre si le
		 * chiffre est le bon, min et max deviennent ce chiffre
		 * 
		 */

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
