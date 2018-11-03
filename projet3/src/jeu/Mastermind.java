package jeu;

import java.util.ArrayList;
import java.util.Random;

public class Mastermind extends Jeu {
	// protected Code codeATrouver;
	private ArrayList<Integer> bienPlace = new ArrayList<>();
	private ArrayList<Integer> malPlace = new ArrayList<>();
	
	// Constructeur
		public Mastermind(int etendue, int taille) {
			this.etendue = etendue;
			this.taille = taille;
			this.propositionOrdinateur = new Code();
		}

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
		for (int i = 0; i < this.taille; i++) {
			propositionOrdinateur.getAllPossibilities(taille, etendue);	
		}
		
		return propositionOrdinateur;
	}

	@Override
	public void analyserResultat(String resultat) {
		// TODO Auto-generated method stub
		// o : bien placé, # malplace et - non correcte
		Code prop = (Code) propositionOrdinateur.clone();
		Code cat = (Code) codeATrouverParLOrdinateur.clone();
		int MalPlace = 0;
		int BienPlace = 0;
		
		for (int i = 0; i < resultat.length(); i++) {
			
		}
		
		

	}
}
