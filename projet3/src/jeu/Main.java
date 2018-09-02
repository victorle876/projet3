package jeu;

import java.util.Scanner;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Code code = new Code();
		Code CodeaTrouver = new Code();
		int NombreEssaiMax;
		int etendue;
		int taille;
		boolean trouve = false;
		int choice;
		int i, j;
		
		Jeu jeu;
		

		Scanner scanner = new Scanner(System.in);

		System.out.println("Quel jue voulez vous jouer?");
		System.out.println("1: Mastermind , 2: PlusouMoins");
		choice = scanner.nextInt();
		switch (choice) {

		case 1:
		   jeu = new Mastermind();
		   j = 0 ;
			NombreEssaiMax = 10;
			while ((j < NombreEssaiMax) || (!trouve) ) {
		    etendue = scanner.nextInt();
		    taille = scanner.nextInt();
		    code.genererNewCode(etendue, taille);
			
		       if (!trouve)
		       {
		    	       
		    	       jeu.enterCode();
		    	       jeu.ComparerCode();
		    	       trouve = false;
		    	       j+=1;
		       }
		       
		       else
		       {
		    	      trouve = true;
		       }

				
//
			}
			break;
		
		case 2:
			jeu = new PlusouMoins();
			i = 0 ;
			NombreEssaiMax = 10;
			while ((i < NombreEssaiMax) || (!trouve) ) {
		    etendue = scanner.nextInt();
		    taille = scanner.nextInt();
		    code.genererNewCode(etendue, taille);
			
		       if (!trouve)
		       {
		    	       
		    	       jeu.enterCode();
		    	       jeu.ComparerCode();
		    	       trouve = false;
		    	       i+=1;
		       }
		       
		       else
		       {
		    	      trouve = true;
		       }

				

			}
			break;

		}

	}
}