package jeu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Aide {
	/**
	 * Méthode d'aide à la saisie d'un nombre entre min et max inclus si ce n'est
	 * pas un entier, on ne prend pas en compte
	 * 
	 * @param min:
	 *            valeur minimale de la saisie
	 * @param max:
	 *            valeur maximale de la saisie
	 * @param msg
	 *            : message correspondant
	 * @return
	 */
	public static int demandeValeurEntier(int min, int max, String msg) {

		int value = 0;
		boolean valide = false;
		Scanner scanner = new Scanner(System.in);

		while (!valide) {
			try {
				System.out.println(msg);
				value = scanner.nextInt();
				if ((value >= min) && (value <= max)) {
					valide = true;
				} else {
					System.out.println("value incorrecte (entre " + min + " et " + max + ")");
				}
			} catch (InputMismatchException ime3) {
				System.out.println("Ce n'est pas un entier !");
				valide = false;
			} finally {
				scanner.nextLine();
			}

		}
		return value;
	}

	/**
	 * Méthode contrôlant la saisie d'une chaîne avec les seuls caractères autorisés
	 * +, -, =
	 * 
	 * @param msg
	 *            Le message informatif à afficher à l'utilisateur
	 * @return
	 */

	public static String demandeValeurString(String msg) {

		boolean nok;
		String propositionUtilisateur;
		Scanner scanner = new Scanner(System.in);

		do {
			nok = false; // On arme le drapeau
			System.out.println(msg);
			propositionUtilisateur = scanner.nextLine();
			for (Character c : propositionUtilisateur.toCharArray()) {
				if ((c != '+') && (c != '-') && (c != '=')) {
					nok = true;
				}
			}
		} while (nok);
		return propositionUtilisateur;
	}

}
