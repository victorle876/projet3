package jeu;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Code code = new Code();
		// Code CodeaTrouver = new Code();
		int NombreEssaiMax = 10;
		int etendue;
		int taille;
		boolean trouve = false;
		int choice;
		int i = 0;

		Jeu jeu;

		Scanner scanner = new Scanner(System.in);

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
			System.out.println("Mauvais choix de jeu");
			return;
		}

		System.out.println("Entrer l'étendue");
		etendue = scanner.nextInt();
		System.out.println("Entrer la taille");
		taille = scanner.nextInt();
		//String resultat;
		jeu.setCodeATrouver(Code.genererNewCode(etendue, taille));
		System.out.println("Voici le code à deviner");
		System.out.println(jeu.getCodeATrouver());

		while ((i < NombreEssaiMax) && (!trouve)) {
			// On affiche le code à trouver
	//		System.out.println("Voici le code à deviner");
	//		System.out.println(jeu.getCodeATrouver());
			
			if (!trouve) {
				
				System.out.println("Entrer un nouveau code?");
				jeu.enterCode();
				
				System.out.println("Le résultat est : " +jeu.comparerCode());
				trouve = jeu.isWon(jeu.getResultat());
				i += 1;
			}

			
		}

		System.out.println("Vous avez "+ ((trouve)?"gagné":"perdu"));

	}	
}