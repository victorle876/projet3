package jeu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Helper {	
	/**
	 *  Méthode d'aide à la saisie d'un nombre entre min et max inclus
	 *  si ce n'est pas un entier, on ne prend pas en compte
	 * @param min
	 * @param max
	 * @param msg
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
	 * Mode de fonctionnement par l'attaquant, quel que soit le jeu choisi
	 * 
	 * @param jeu
	 * @param choice
	 * @param etendue
	 * @param taille
	 * @return
	 */
	public static String boucleJeuAttaquant(Jeu jeu, int choice, int etendue, int taille) {
		int nombreEssaiMax = 10;
		boolean trouve = false;
		int bp = 0;
		int mp = 0;
		String message;
		String resultat="";
		for (int i = 0; i < nombreEssaiMax && !trouve; i++) {
			System.out.print("Le code proposé par l'ordinateur : ");
			System.out.println(jeu.chercherSolution());
			System.out.println("Quel est le resultat pour cette proposition ?");
			jeu.demandeAnalyse();
			jeu.analyserResultat(resultat);
			trouve = jeu.isWon(resultat);

		}
		message = ("Vous avez " + ((trouve) ? "gagné" : "perdu"));
		return message;
	}
	
	
	/**
	 * Mode de fonctionnement par la défense,quel que soit le jeu choisi
	 * 
	 * @param jeu
	 * @param choice
	 * @param etendue
	 * @param taille
	 * @return
	 */
	public static String boucleJeuDefenseur(Jeu jeu, int choice, int etendue, int taille) {
		int nombreEssaiMax = 10;
		boolean trouve = false;
		String message;
		jeu.setCodeATrouverParLeJoueur(Code.genererNewCode(etendue, taille));

		// Boucle de recherche de la solution par le joueur
		for (int i = 0; i < nombreEssaiMax && !trouve; i++) {
			// On affiche le code à trouver
			System.out.println("Voici le code à deviner");
			System.out.println(jeu.getCodeATrouverParLeJoueur());

			if (!trouve) {
				System.out.println("Entrer un nouveau code?");
				jeu.enterCode();

				System.out.println("Le résultat est : " + jeu.comparerCode());
				trouve = jeu.isWon(jeu.getResultatPourLeJoueur());
			}

		}
		message = ("Vous avez " + ((trouve) ? "gagné" : "perdu"));
		return message;

	}
//

}
