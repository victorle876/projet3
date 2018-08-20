package jeu;
import java.util.ArrayList;
import java.util.Scanner;

public class Mastermind {
	
	@Override
	public String ComparerCode() {
//		String result = "";
		boolean[] Place = new boolean[codeATrouver.size()];
		boolean[] MalPlace = new boolean[codeATrouver.size()];

		for (int i = 0; i < codeATrouver.length(); i++) {
			Place[i] = true;
			MalPlace[i] = true;
		}
		

		for (int i = 0; i < codeATrouver.size(); i++) {
			int propositionAttaquant = proposition.get(i);
			int propositionDefenseur = codeATrouver.get(i);
			if (propositionAttaquant == propositionDefenseur) {
//				result = result + "=";
				Place[i] = false;
				MalPlace[i] = false;
			}
		}
		
		
		// 2nd tour pour vérifier les couleurs à la mauvaise place (-)
		for (int i = 0; i < codeATrouver.size(); i++) {
			if (Place[i]) {
				for (int j = 0; j < codeATrouver.size(); j++) {
					int propositionAttaquant = proposition.get(i);
					int propositionDefenseur = codeATrouver.get(i);

					if (propositionAttaquant == propositionDefenseur && MalPlace[j]) {
//						result = result + "-";
						MalPlace[j] = false;
						j = codeATrouver.length();
					}
				}
			}
		}
//		return result;
	}


}
