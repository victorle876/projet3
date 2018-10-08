package jeu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		int NombreEssaiMax = 10;
		int etendue = 9;
		int taille = 4;
		boolean trouve = false;
		int choice = 0;
		int choice_jeu = 0;
		int min=0;
		int value = 0;
		int max;
		//

		Jeu jeu = null;

		Scanner scanner = new Scanner(System.in);
		max = scanner.nextInt();

		// Saisie de la taille et de l'étendue avec vérification de la validité des
		// entrées
		boolean valide_etendue = false;
		while (!valide_etendue) {
			// Penser à réarmer les flags
//			valide_etendue = false;
//			System.out.println("Entrer l'étendue");
//			try {
//				etendue = scanner.nextInt();
//				if ((etendue > 0) && (etendue < 10)) {
//					valide_etendue = true;
//				} else {
//					System.out.println("Etendue incorrecte (entre 1 et 9)");
//				}
//			} catch (InputMismatchException ime2) {
//				System.out.println("Ce n'est pas un entier !");
//				valide_etendue = false;
//			} finally {
//				scanner.nextLine();
//			}
			askIntegerValue(min, max);
			etendue = value;
			valide_etendue = true;

		}

		boolean valide_taille = false;
		while (!valide_taille) {
			// Penser à réarmer les flags
			valide_taille = false;
//			System.out.println("Entrer la taille");
//			try {
//				taille = scanner.nextInt();
//				if ((taille > 0) && (taille < 7)) {
//					valide_taille = true;
//				} else {
//					System.out.println("Taille incorrecte (entre 1 et 6)");
//				}
//			} catch (InputMismatchException ime3) {
//				System.out.println("Ce n'est pas un entier !");
//				valide_taille = false;
//			} finally {
//				scanner.nextLine();
//			}
			askIntegerValue(min, max);
			taille = value;
			valide_taille = true;
		}

		boolean valide_jeu;
		do {
			// Penser à réarmer les flags
			valide_jeu = true;
			System.out.println("Quel jeu voulez vous jouer?");
			System.out.println("1: Mastermind , 2: PlusouMoins");
			try {
				choice = scanner.nextInt();
				switch (choice) {
				case 1:
					jeu = new Mastermind();
					break;

				case 2:
					jeu = new PlusouMoins(etendue, taille);
					break;

				default:
					System.out.println("Choix de jeu invalide");
					valide_jeu = false;
				}
			} catch (InputMismatchException ime) {
				System.out.println("Ce n'est pas un entier !");
				valide_jeu = false;
			} finally {
				scanner.nextLine();
			}
			// Fin des catch
		} while (!valide_jeu);

		System.out.println("Ordinateur attaquant (1) ou défenseur (2) ?");
		choice_jeu = scanner.nextInt();
		scanner.nextLine(); // Pour vider le buffer de saisie
		switch (choice_jeu) {
		// TODO Ajouter une question pour savoir dans quel mode on joue (ordi défenseur
		// ou attaquant)
		// .... (boucle de recherche de la solution par l'ordi)

		// Ici on est dans le cas de l'ordinateur attaquant
		// Faire une boucle de recherche de la solution par l'ordi
		// appeler la fonction de recherche
		// demander résultat au joueur (sous forme +-=)
		// analyser ce résultat
		case 1:


//			for (int i = 0; i < NombreEssaiMax && !trouve; i++) {
//				System.out.print("Le code proposé par l'ordinateur : ");
//				System.out.println(jeu.chercherSolution());
//				System.out.println("Quel est le resultat pour cette proposition ?");
//				boolean resultatValide = false;
//				while (!resultatValide) {
//					String resultat = scanner.nextLine();
//					try {
//						for (char c : resultat.toCharArray()) {
//							if (!((c == '=') || (c == '-') || (c == '+'))) {
//								throw new InputMismatchException();
//							}
//						}
//						jeu.analyserResultat(resultat);
//						resultatValide = true;
//						trouve = jeu.isWon(resultat);
//					} catch (InputMismatchException ime) {
//						System.out.println("Vous vous êtes trompé, veuillez ressaisir le résultat");
//					}
//				}
//			}
//			System.out.println("Vous avez " + ((trouve) ? "gagné" : "perdu"));
			ResultatJeuAttaquant(choice);
			break;
		case 2:
			// Ici on est dans le cas de l'ordinateur défenseur
			// Ici la taille et l'étendue sont vérifiées et valides, ainsi que le jeu
			// On positionne le code à trouver après l'avoir généré aléatoirement
//			jeu.setCodeATrouverParLeJoueur(Code.genererNewCode(etendue, taille));
//
//			// Boucle de recherche de la solution par le joueur
//			for (int i = 0; i < NombreEssaiMax && !trouve; i++) {
//				// On affiche le code à trouver
//				System.out.println("Voici le code à deviner");
//				System.out.println(jeu.getCodeATrouverParLeJoueur());
//
//				if (!trouve) {
//					System.out.println("Entrer un nouveau code?");
//					jeu.enterCode();
//
//					System.out.println("Le résultat est : " + jeu.comparerCode());
//					trouve = jeu.isWon(jeu.getResultatPourLeJoueur());
//				}
//
//			}
//
//			System.out.println("Vous avez " + ((trouve) ? "gagné" : "perdu"));
			ResultatJeuDefenseur(choice);

			break;
		default:
			System.out.println("Choix de jeu invalide");
		}
	}

	// Méthode d'aide à la saisie d'un nombre entre min et max
	private static int askIntegerValue(int min, int max) {
		int value = 0;
		boolean valide = false;
		Scanner scanner = new Scanner(System.in);
		
		// TODO boucle de saisie d'une valeur numérique entre min et max
		while (!valide) {
			try {
				value = scanner.nextInt();
				if ((value > min) && (value < 7)) {
					valide = true;
				} else {
					System.out.println("value incorrecte (entre min et max)");
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
	
	private static String ResultatJeuAttaquant (int choice) {
		int NombreEssaiMax=10;
		boolean trouve = false;
		String message;
		Scanner scanner = new Scanner(System.in);
		Jeu jeu= null;
		for (int i = 0; i < NombreEssaiMax && !trouve; i++) {
			System.out.print("Le code proposé par l'ordinateur : ");
			System.out.println(jeu.chercherSolution());
			System.out.println("Quel est le resultat pour cette proposition ?");
			boolean resultatValide = false;
			while (!resultatValide) {
				String resultat = scanner.nextLine();
				try {
					for (char c : resultat.toCharArray()) {
						if (!((c == '=') || (c == '-') || (c == '+'))) {
							throw new InputMismatchException();
						}
					}
					jeu.analyserResultat(resultat);
					resultatValide = true;
					trouve = jeu.isWon(resultat);
				} catch (InputMismatchException ime) {
					System.out.println("Vous vous êtes trompé, veuillez ressaisir le résultat");
				}
			}
		}
		System.out.println("Vous avez " + ((trouve) ? "gagné" : "perdu"));
		message = ("Vous avez " + ((trouve) ? "gagné" : "perdu"));
		return message;
		
	}
	private static String ResultatJeuDefenseur (int choice) {
		int NombreEssaiMax=10;
		boolean trouve = false;
		String message;
		Scanner scanner = new Scanner(System.in);
		Jeu jeu= null;
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

		System.out.println("Vous avez " + ((trouve) ? "gagné" : "perdu"));
		System.out.println("Vous avez " + ((trouve) ? "gagné" : "perdu"));
		message = ("Vous avez " + ((trouve) ? "gagné" : "perdu"));
		return message;
		
	}
}