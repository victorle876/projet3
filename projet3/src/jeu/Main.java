package jeu;

import java.util.Scanner;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Code code = new Code();
		Code CodeaTrouver = new Code();
		int NombreEssaiMax;
		int etendue;
		boolean trouve = false;
		int choice;
		Jeu jeu;
		

		Scanner scanner = new Scanner(System.in);

		System.out.println("Quel jue voulez vous jouer?");
		System.out.println("1: Mastermind , 2: PlusouMoins");
		choice = scanner.nextInt();
		switch (choice) {

		case 1:
		   jeu = new Mastermind();
			
			break;
		case 2:
			jeu = new PlusouMoins();
			break;

		}

	}
}