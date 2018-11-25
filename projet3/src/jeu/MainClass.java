package jeu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {
	
	/**
	 * La classe principale permettant de choisir le jeu et son mode
	 * @param args
	 */

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		int etendue = 9;
		int taille = 4;
		int TypeChoixJeu = 2;
		int attackDefenseChoice;

		Jeu jeu = null;

		// Saisie des parametres de configuration
		etendue = Helper.demandeValeurEntier(1, 9, "Entrer l'étendue");
		taille = Helper.demandeValeurEntier(1, 6, "Entrer la taille");
		TypeChoixJeu = Helper.demandeValeurEntier(1, 2, "Quel jeu voulez vous jouer?\n1: Mastermind , 2: PlusouMoins");
		attackDefenseChoice = Helper.demandeValeurEntier(1, 2, "Ordinateur attaquant (1) ou défenseur (2) ?");

		// Creation du jeu
		switch (TypeChoixJeu) {
		case 1:
			jeu = new Mastermind(etendue, taille);
			break;

		case 2:
			jeu = new PlusouMoins(etendue, taille);
			break;
		default:
			System.out.println("Choix de jeu invalide");
		}

		// Resolution du jeu
		switch (attackDefenseChoice) {
		case 1: // Ordinateur attaque
			System.out.println(boucleJeuAttaquant(jeu, TypeChoixJeu, etendue, taille));
			break;
		case 2: // ordinateur défend
			System.out.println(boucleJeuDefenseur(jeu, TypeChoixJeu, etendue, taille));
			break;
		default:
			System.out.println("Mode de jeu invalide");
		}
	}

	// Méthode d'aide à la saisie d'un nombre entre min et max inclus
	private static int askIntegerValue(int min, int max, String msg) {
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

	private static String boucleJeuAttaquant(Jeu jeu, int choice, int etendue, int taille) {
		int NombreEssaiMax = 10;
		boolean trouve = false;
		int bp = 0;
		int mp = 0;
		String message;
		String resultat;
		for (int i = 0; i < NombreEssaiMax && !trouve; i++) {
			System.out.print("Le code proposé par l'ordinateur : ");
			System.out.println(jeu.chercherSolution());
			System.out.println("Quel est le resultat pour cette proposition ?");
			bp = askIntegerValue(0, 6, "Entrer le nombre de BienPlace");
			mp = askIntegerValue(0, 6, "Entrer le nombre de MalPlace");
			String bpAsString = Integer.toString(bp);
			String mpAsString = Integer.toString(mp);
			resultat = bpAsString + ":" + mpAsString;
			jeu.analyserResultat(resultat);
			trouve = jeu.isWon(resultat);
		}
		message = ("Vous avez " + ((trouve) ? "gagné" : "perdu"));
		return message;
	}

	private static String boucleJeuDefenseur(Jeu jeu, int choice, int etendue, int taille) {
		int NombreEssaiMax = 10;
		boolean trouve = false;
		String message;
		jeu.setCodeATrouverParLeJoueur(Code.genererNewCode(etendue, taille));

		// Boucle de recherche de la solution par le joueur
		for (int i = 0; i < NombreEssaiMax && !trouve; i++) {
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

}