package jeu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {
	
	 private static int etendue = 9;
	 private static int taille = 4;
	 private static int typeChoixJeu = 2;
	 private static int attackDefenseChoice;
	
	/**
	 * La classe principale permettant de saisir l'étendue et la taille, et ensuite de
	 * choisir le jeu et son mode
	 * Saisie des parametres de configuration
	 * @param args
	 */

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Jeu jeu = null;

		etendue = Helper.demandeValeurEntier(1, 9, "Entrer l'étendue");
		taille = Helper.demandeValeurEntier(1, 6, "Entrer la taille");
		typeChoixJeu = Helper.demandeValeurEntier(1, 2, "Quel jeu voulez vous jouer?\n1: Mastermind , 2: PlusouMoins");
		attackDefenseChoice = Helper.demandeValeurEntier(1, 2, "Ordinateur attaquant (1) ou défenseur (2) ?");

		// Creation du jeu
		switch (typeChoixJeu) {
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
			System.out.println(boucleJeuAttaquant(jeu, typeChoixJeu, etendue, taille));
			break;
		case 2: // ordinateur défend
			System.out.println(boucleJeuDefenseur(jeu, typeChoixJeu, etendue, taille));
			break;
		default:
			System.out.println("Mode de jeu invalide");
		}
	}
	
	/**
	 * Mode de fonctionnement par l'attaquant, quel que soit le jeu choisi
	 * 
	 * @param jeu: choix entre le plusou moins (1) et mastermind (2)
	 * @param choice: mode choisi entre le mode attaquant et le mode défenseur
	 * @param etendue: la plage définie sur le jeu à 1 chiffres
	 * @param taille: nombre de chiffres que comporte le code
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
			resultat=jeu.demandeAnalyse();
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


}