package jeu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		int etendue = 9;
		int taille = 4;
		int gameTypeChoice = 2;
		int attackDefenseChoice;

		Jeu jeu = null;

		// Saisie des parametres de configuration
		etendue = askIntegerValue(1, 9, "Entrer l'étendue");
		taille = askIntegerValue(1, 6, "Entrer la taille");
		gameTypeChoice = askIntegerValue(1, 2, "Quel jeu voulez vous jouer?\n1: Mastermind , 2: PlusouMoins");
		attackDefenseChoice = askIntegerValue(1, 2, "Ordinateur attaquant (1) ou défenseur (2) ?");

		// Creation du jeu
		switch (gameTypeChoice) {
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
			System.out.println(boucleJeuAttaquant(jeu, gameTypeChoice, etendue, taille));
			break;
		case 2: // ordinateur défend
			System.out.println(boucleJeuDefenseur(jeu, gameTypeChoice, etendue, taille));
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
		Scanner scanner = new Scanner(System.in);
		int bp = 0;
		int mp = 0;
		String message , res;
		for (int i = 0; i < NombreEssaiMax && !trouve; i++) {
			System.out.print("Le code proposé par l'ordinateur : ");
			System.out.println(jeu.chercherSolution());
			System.out.println("Quel est le resultat pour cette proposition ?");
			// TODO : saisir le nombre de bien placés : bp
			// TODO : saisir le nombre de mal placé : mp
			// TODO : construire une String avec ces infos, par exemple res="<bp>|<mp>"
			// TODO : comparer avec les possiblités : jeu.analyserResultat(res)
			// TODO : positionner trouve à true si jeu.isWon() == true
			bp = scanner.nextInt();
			mp = scanner.nextInt();
			while (!trouve) {
				res = "<" + bp + ">" +"<" + mp + ">";
				jeu.analyserResultat(res);
			}
			
		}
		message = ("Vous avez " + ((trouve) ? "gagné" : "perdu"));
		return message;
	}

	private static String VerifieBoucleAttaquant(Jeu jeu, int choice, int etendue, int taille) {
		boolean resultatValide = false;
		Scanner scanner = new Scanner(System.in);
		String message = "";
		boolean trouve = false;
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