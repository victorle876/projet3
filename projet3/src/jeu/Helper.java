package jeu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Helper {	
	/**
	 *  Méthode d'aide à la saisie d'un nombre entre min et max inclus
	 *  si ce n'est pas un entier, on ne prend pas en compte
	 * @param min: valeur minimale de la saisie
	 * @param max: valeur maximale de la saisie
	 * @param msg : message correspondant
	 * @return
	 */
	public static int demandeValeurEntier(int min, int max, String msg) {

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
	
	/**
	 * Méthode contrôlant la saisie du résultat pour le jeu PlusouMoins
	 * @param chaine: saisie du résultat à n caractères: + -=
	 * @param msg
	 * @return
	 */
	
	public static String demandeValeurString(String chaine, String msg) {

		boolean valide = false;
		
		Scanner scanner = new Scanner(System.in);

		while (!valide) {
			try {
				System.out.println(msg);
				chaine = scanner.nextLine();
				for (char c : chaine.toCharArray())
				{
					if (((c == '=') || (c == '-') || (c == '+')))  {
					valide = true;
					}
				} 
					
			} catch (InputMismatchException ime3) {
				System.out.println("LA chaîne n'est pas valide");
				valide = false;
			} finally {
				scanner.nextLine();
			}

		}
		return chaine;
	}

//

}
