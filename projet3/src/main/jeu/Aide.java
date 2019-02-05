package main.jeu;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Aide {
	public final static Logger LOGGER = LogManager.getLogger(main.jeu.Aide.class.getName());

	public static Scanner scanner = new Scanner(System.in);
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

		while (!valide) {
			try {
				System.out.println(msg);
				value = scanner.nextInt();
				if ((value >= min) && (value <= max)) {
					valide = true;
				} else {
					// System.out.println("value incorrecte (entre " + min + " et " + max + ")");
					Aide.LOGGER.info("value incorrecte (entre " + min + " et " + max + ")");
				}
			} catch (InputMismatchException ime3) {
				// System.out.println("Ce n'est pas un entier !");
				Aide.LOGGER.error("Ce n'est pas un entier !");
				valide = false;
			} finally {
				scanner.nextLine();
				//
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

		do {
			nok = false; // On arme le drapeau
			// System.out.println(msg);
			Aide.LOGGER.info(msg);
			propositionUtilisateur = scanner.nextLine();
			for (Character c : propositionUtilisateur.toCharArray()) {
				if ((c != '+') && (c != '-') && (c != '=')) {
					nok = true;
				}
			}
		} while (nok);
		return propositionUtilisateur;
	}

	/**
	 * Méthode d'aide à la saisie d'une chaîne composée uniquement des caractères
	 * passés dans la premier paramètre
	 * 
	 * @param values
	 *            Les caractères acceptés dans la saisie de l'utilisateur
	 * @param msg
	 *            Le message d'information à fournir à l'utilisateur
	 * @return : retourne la chaîne valide saisie
	 */
	public final static String askString(String values, String msg) {
		String saisie;
		boolean valide;

		do {
			valide = true; // Positionnement du drapeau
			System.out.println(msg);
			saisie = scanner.next();
			valide = saisie.matches("^[" + values + "]*$");
		} while (!valide);
		return saisie;
		//1
	}

	/**
	 * Méthode de choix du débuggage ou non en mode developpeur
	 * 
	 * @param msg
	 *            Le message d'information à fournir à l'utilisateur
	 * @return : retourne la chaîne valide saisie
	 */
	public final static boolean demanderOuiNon(String msg) {
		String reponse = "";
		boolean valide = false;
		boolean nok ;
		do {
		nok = false;
		System.out.println(msg);		
		reponse = scanner.nextLine();
		if (reponse.equals("oui")) {
             valide = true;
			 nok = true;
		} else {
			if (reponse.equals("non")) {
				valide = false;
				nok = true;
			}	
		}
		} while (nok);	
		return valide;
				
}
}