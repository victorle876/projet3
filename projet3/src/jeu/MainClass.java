package jeu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {
	
	 private static int etendue = 9;
	 private static int taille = 4;
	 private static int TypeChoixJeu = 2;
	 private static int attackDefenseChoice;
	
	/**
	 * La classe principale permettant de choisir le jeu et son mode
	 * Saisie des parametres de configuration
	 * @param args
	 */

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Jeu jeu = null;

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
			System.out.println(Helper.boucleJeuAttaquant(jeu, TypeChoixJeu, etendue, taille));
			break;
		case 2: // ordinateur défend
			System.out.println(Helper.boucleJeuDefenseur(jeu, TypeChoixJeu, etendue, taille));
			break;
		default:
			System.out.println("Mode de jeu invalide");
		}
	}


}