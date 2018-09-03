package jeu;

import java.util.Scanner;

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
			jeu = null;
			if (jeu == null) {
				System.out.println("Mauvais choix de jeu");
				return;
			}

		}

		System.out.println("Entrer l'étendue");
		etendue = scanner.nextInt();
		System.out.println("Entrer la taille");
		taille = scanner.nextInt();
		String resultat;
		code = Code.genererNewCode(etendue, taille);

		while ((i < NombreEssaiMax) && (!trouve)) {

			if (!trouve) {
				
				System.out.println("Entrer un nouveau code?");
				jeu.enterCode();
				jeu.setcodeATrouver(Code.genererNewCode(etendue, taille));
				jeu.comparerCode();
				trouve = jeu.isWon();
				i += 1;
			}

			scanner = null;
		}

	}	
}