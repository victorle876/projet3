package jeu;

import java.util.ArrayList;
import java.util.Random;

public class Mastermind extends Jeu {
	// protected Code codeATrouver;
	private ArrayList<Integer> bienPlace = new ArrayList<>();
	private ArrayList<Integer> malPlace = new ArrayList<>();

	@Override
	public String comparerCode() {
		String result = "";
		Code prop = (Code) propositionDuJoueur.clone();
		Code cat = (Code) codeATrouverParLeJoueur.clone();

		int bienPlacé = 0;
		int MalPlacé = 0;
		for (int i = prop.size()-1; i >= 0; i--) {
			int propositionAttaquant = prop.get(i);
			int propositionDefenseur = cat.get(i);
			if (propositionAttaquant == propositionDefenseur) {
				prop.remove(i);
				cat.remove(i);
				bienPlacé++;
				
			}
		}	
			for (int j = prop.size()-1; j >= 0; j--) {
				int propositionAttaquantRestant = prop.get(j);
				for (int k = prop.size()-1; k >= 0; k--) {
					int propositionDefenseurRestant = cat.get(k);  
					if (propositionAttaquantRestant == propositionDefenseurRestant) {
						prop.remove(j);
						cat.remove(k);
						MalPlacé++;
						System.out.println(MalPlacé);
						System.out.println(k);
					break ;	
					}
		
				}	
		//		resultat="Bien Placé :"+bienPlacé+"; MalPlacé : "+MalPlacé;
				}
	
			
			resultatPourLeJoueur="Bien Placé :"+bienPlacé+"; MalPlacé : "+MalPlacé;

	return resultatPourLeJoueur;

	}

	@Override
	public boolean isWon(String resultat) {
//		return (resultat.matches("^\"Bien Placé :\" + bienPlacé + \"; MalPlacé : \" + MalPlacé+$"));
		return (resultat.matches("^Bien Placé :" + codeATrouverParLeJoueur.size() + "; MalPlacé : 0$"));
	}

	@Override
	public Code chercherSolution() {
		// TODO Auto-generated method stub
		int bienPlacé = 0;
		Code prop = (Code) propositionOrdinateur.clone();
		Code cat = (Code) codeATrouverParLOrdinateur.clone();
		Random r = new Random();
		for (int i = prop.size()-1; i >= 0; i--) {
			int propositionAttaquant = prop.get(i);
			int propositionDefenseur = cat.get(i);
			if (propositionAttaquant != propositionDefenseur) {
				prop.remove(i);
	//			prop.add(r.nextInt(etendue));
				
			}
			else 
			if (propositionAttaquant == propositionDefenseur)
			{
				prop.remove(i);
				cat.remove(i);
				bienPlacé++;

			}
				
		}	
		return null;
	}

	@Override
	public void analyserResultat(String resultat) {
		// TODO Auto-generated method stub
		// o : bien placé, # malplace et - non correcte
		Code prop = (Code) propositionOrdinateur.clone();
		Code cat = (Code) codeATrouverParLOrdinateur.clone();
		int MalPlacé = 0;
		
		for (int i = 0; i < resultat.length(); i++) {
			if (resultat.charAt(i) == 'o') {
				System.out.println("Le chiffre est bien placé");

			} else if (resultat.charAt(i) == '#') {
				for (int j = prop.size()-1; j >= 0; j--) {
					int propositionAttaquantRestant = prop.get(j);
					for (int k = prop.size()-1; k >= 0; k--) {
						int propositionDefenseurRestant = cat.get(k);  
						if (propositionAttaquantRestant == propositionDefenseurRestant) {
							prop.remove(j);
							cat.remove(k);
							malPlace.set(k,this.propositionOrdinateur.get(k));
							MalPlacé++;
							System.out.println(MalPlacé);
							System.out.println(k);
						break ;	
						}
			
					}		

			} 
			}
				else if (resultat.charAt(i) == '-') {
					Random r = new Random();
					this.propositionOrdinateur.add(r.nextInt(etendue));
				}
				
			}

	}
}
