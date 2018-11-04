package jeu;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Mastermind extends Jeu {
	// protected Code codeATrouver;
	private ArrayList<Integer> bienPlace = new ArrayList<>();
	private ArrayList<Integer> malPlace = new ArrayList<>();
	
		public Mastermind () {
			super();
		}
	
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
			System.out.println(propositionOrdinateur.getAllPossibilities(taille, etendue));
		}
		
		return propositionOrdinateur;
	}

	@Override
	public void analyserResultat(String resultat) {
		// TODO Auto-generated method stub
		Code prop = (Code) propositionOrdinateur.clone();
		Code cat = (Code) codeATrouverParLOrdinateur.clone();
		ArrayList<Code> allPossibilities = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		int MalPlacé=0;
		int bienPlacé=0;
		
		for (int i = 0; i < propositionOrdinateur.size(); i++) {
			System.out.println("Bien Placé :"+bienPlacé+"; MalPlacé : "+MalPlacé);
			int bienPlace = scanner.nextInt();
			int MalPlace = scanner.nextInt();
			for (Code c : Code.getAllPossibilities(taille - 1, etendue)) {
				ArrayList<Integer> Possibility = new ArrayList<>();
			    this.comparerCode();	
			    if ((MalPlacé == 0) && (bienPlacé == 0)) {
			        	allPossibilities.remove(propositionOrdinateur);
			    }
			    else {
			    	Possibility.add(propositionOrdinateur.get(i));
			    	allPossibilities.add((Code) Possibility);
			    	
			    }
		
			
		}
		
		

	}
}
}