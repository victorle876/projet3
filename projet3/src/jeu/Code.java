package jeu;

import java.util.ArrayList;
import java.util.Random;

public class Code extends ArrayList<Integer> {
	private static final long serialVersionUID = -7028121193663088447L;
	int taille;
	int etendue;

	public Code() {
		super();
	}

	public Code(int value, int etendue) {
		this.clear();
		if ((value >= 0) && (value <= etendue)) {
			this.add(value);
			this.etendue = etendue;
		}
	}

	public Code(ArrayList<Integer> chiffres, int etendue) {
		super(chiffres);
		this.taille = chiffres.size();
		this.etendue = etendue;
	}

	public int getEtendue() {
		return etendue;
	}

	public static Code genererNewCode(int etendue, int taille) {
		Random r = new Random();
		Code code = new Code();

		for (int i = 0; i < taille; i++) {
			code.add(r.nextInt(etendue));
		}

		return code;

	}

	// elle doit retourner un code extrait d'une chaine de caractères
	public static Code extractCode(String prop) throws IllegalArgumentException {
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
		ArrayList<Code> allPossibilities = new ArrayList<>();
		// TODO !!!
		for (int value = 0; value <= etendue; value++) {
			if (taille > 1) {
				for (Code c : getAllPossibilities(taille - 1, etendue)) {
					ArrayList<Integer> Possibility = new ArrayList<>();
					Possibility.add(value);
					Possibility.addAll(c);
					allPossibilities.add(new Code(Possibility, etendue));
				}
			} else {
				for (int i = 0; i <= etendue; i++) {
					allPossibilities.add(new Code(i, etendue));
				}

			}

		}

		return allPossibilities;
	}

}
