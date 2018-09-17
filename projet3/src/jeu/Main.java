package jeu;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Code code = new Code();
		// Code CodeaTrouver = new Code();
		int NombreEssaiMax = 10;
		int etendue = 0;
		int taille = 0;
		boolean trouve = false;
		int choice;

		Jeu jeu = null;

		Scanner scanner = new Scanner(System.in);

		boolean valide_jeu;
		do {
			// Penser à réarmer les flags
			valide_jeu = true;
			System.out.println("Quel jeu voulez vous jouer?");
			System.out.println("1: Mastermind , 2: PlusouMoins");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				jeu = new Mastermind();
				break;

			case 2:
				jeu = new PlusouMoins();
				break;

			default:
				System.out.println("Choix de jeu invalide");
				valide_jeu = false;
			}
		} while (!valide_jeu);

		// Saisie de la taille et de l'étendue avec vérification de la validité des
		// entrées
		boolean valide_etendue = false;
		while (!valide_etendue) {
			// Penser à réarmer les flags
			valide_etendue = false;
			System.out.println("Entrer l'étendue");
			etendue = scanner.nextInt();
			if ((etendue > 0) && (etendue < 10)) {
				valide_etendue = true;
			} else {
				System.out.println("Etendue incorrecte (entre 1 et 9)");
			}
		}

		boolean valide_taille = false;
		while (!valide_taille) {
			// Penser à réarmer les flags
			valide_taille = false;
			System.out.println("Entrer la taille");
			taille = scanner.nextInt();
			if ((taille > 0) && (taille < 7)) {
				valide_taille = true;
			} else {
				System.out.println("Taille incorrecte (entre 1 et 6)");
			}
		}

		// Ici la taille et l'étendue sont vérifiées et valides, ainsi que le jeu
		// On positionne le code à trouver après l'avoir généré aléatoirement
		jeu.setCodeATrouver(Code.genererNewCode(etendue, taille));

		// Boucle de recherche
		for (int i = 0; i < NombreEssaiMax && !trouve; i++) {
			// On affiche le code à trouver
			System.out.println("Voici le code à deviner");
			System.out.println(jeu.getCodeATrouver());

			if (!trouve) {
				System.out.println("Entrer un nouveau code?");
				jeu.enterCode();

				System.out.println("Le résultat est : " + jeu.comparerCode());
				trouve = jeu.isWon(jeu.getResultat());
			}

		}

		System.out.println("Vous avez " + ((trouve) ? "gagné" : "perdu"));

	}
}