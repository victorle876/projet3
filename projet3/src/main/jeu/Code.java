package main.jeu;

import java.util.ArrayList;
import java.util.Random;

/*
 * TODO vérifier les @param et @return de la javadoc
 * TODO mettre la javadoc en français
 */

public class Code extends ArrayList<Integer> {
	private static final long serialVersionUID = -7028121193663088447L;
	int taille;
	int etendue;

	public Code() {
		super();
	}

	/**
	 * Méthode permet de controler la saisie entre 2 valeurs
	 * 
	 * @param value
	 * @param etendue
	 */
	public Code(int value, int etendue) {
		this.clear();
		if ((value >= 0) && (value <= etendue)) {
			this.add(value);
			this.etendue = etendue;
		}
	}

	/**
	 * Constructeur pour la classe Code
	 * 
	 * @param chiffres
	 * @param etendue
	 */
	public Code(ArrayList<Integer> chiffres, int etendue) {
		super(chiffres);
		this.taille = chiffres.size();
		this.etendue = etendue;
	}

	public int getEtendue() {
		return etendue;
	}

	/**
	 * Méthode générant des chiffres alléatoires et on les ajoute à la liste des
	 * codes
	 * 
	 * @param etendue
	 * @param taille
	 * @return retourne le code
	 */
	public static Code genererNewCode(int etendue, int taille) {
		Random r = new Random();
		Code code = new Code();

		for (int i = 0; i < taille; i++) {
			code.add(r.nextInt(etendue));
		}

		return code;

	}

	/**
	 * elle doit retourner un code extrait d'une chaine de caractères
	 * 
	 * @param prop
	 * @return retourne le code
	 * @throws IllegalArgumentException
	 */
	public static Code extraireCode(String prop) throws IllegalArgumentException {
		Code code = new Code();
		for (int i = 0; i < prop.length(); i++) {
			if ((prop.charAt(i) >= '0') && (prop.charAt(i) <= '9')) {
				code.add(prop.charAt(i) - '0');
			}

			else {
				throw new IllegalArgumentException();
			}

		}
		return code;
	}

	/**
	 * Generate all possible codes with the given size and max value.
	 *
	 * @param taille
	 *            Code's size
	 * @param etendue
	 *            Code's components max value
	 * @return An ArrayList of all possible codes with the given parameters
	 */
	public static ArrayList<Code> getAllPossibilities(int taille, int etendue) {
		ArrayList<Code> toutesPossibilites = new ArrayList<>();
		for (int value = 0; value <= etendue; value++) {
			if (taille > 1) {
				for (Code c : getAllPossibilities(taille - 1, etendue)) {
					ArrayList<Integer> Possibilite = new ArrayList<>();
					Possibilite.add(value);
					Possibilite.addAll(c);
					toutesPossibilites.add(new Code(Possibilite, etendue));
				}
			} else {
				if (taille == 1) {
					for (int i = 0; i <= etendue; i++) {
						toutesPossibilites.add(new Code(i, etendue));
					}
				}
			}

		}

		return toutesPossibilites;
	}

}
