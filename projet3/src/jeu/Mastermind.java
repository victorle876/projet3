package jeu;

import java.util.ArrayList;
import java.util.Random;

public class Mastermind extends Jeu {
	private ArrayList<Code> allPossibilities = new ArrayList<>();

	public Mastermind() {
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
		for (int i = prop.size() - 1; i >= 0; i--) {
			int propositionAttaquant = prop.get(i);
			int propositionDefenseur = cat.get(i);
			if (propositionAttaquant == propositionDefenseur) {
				prop.remove(i);
				cat.remove(i);
				bienPlacé++;

			}
		}
		for (int j = prop.size() - 1; j >= 0; j--) {
			int propositionAttaquantRestant = prop.get(j);
			for (int k = prop.size() - 1; k >= 0; k--) {
				int propositionDefenseurRestant = cat.get(k);
				if (propositionAttaquantRestant == propositionDefenseurRestant) {
					prop.remove(j);
					cat.remove(k);
					MalPlacé++;
					System.out.println(MalPlacé);
					System.out.println(k);
					break;
				}

			}
			// resultat="Bien Placé :"+bienPlacé+"; MalPlacé : "+MalPlacé;
		}

		resultatPourLeJoueur = "Bien Placé :" + bienPlacé + "; MalPlacé : " + MalPlacé;

		return resultatPourLeJoueur;

	}

	@Override
	public boolean isWon(String resultat) {
		// return (resultat.matches("^\"Bien Placé :\" + bienPlacé + \"; MalPlacé : \" +
		// MalPlacé+$"));
		return (resultat.matches("^Bien Placé :" + codeATrouverParLeJoueur.size() + "; MalPlacé : 0$"));
	}

	@Override
	public Code chercherSolution() {
		// TODO Auto-generated method stub
		if (this.allPossibilities == null) {
			this.allPossibilities = jeu.Code.getAllPossibilities(taille, etendue);
		}
		// TODO propositionOrdinateur est une valeur tirée au hasard dans
		// this.allpossibilities
		Random r = new Random();

		propositionOrdinateur = allPossibilities.get(r.nextInt(allPossibilities.size()));

		return propositionOrdinateur;
	}

	@Override
	public void analyserResultat(String resultat) {

		// extraire le nb de bp et le nb de mp depuis la String passée en
		// paramètre au format "bp|mp"
		String[] resultats = resultat.split("|");
		int malPlacé = new Integer(resultats[1]);
		int bienPlacé = new Integer(resultats[0]);

		Code prop = (Code) propositionOrdinateur.clone();
		Code cat = (Code) codeATrouverParLOrdinateur.clone();

		for (int i = 0; i < propositionOrdinateur.size(); i++) {
			System.out.println("Bien Placé :" + bienPlacé + "; MalPlacé : " + malPlacé);
			for (Code c : jeu.Code.getAllPossibilities(taille - 1, etendue)) {
				ArrayList<Integer> Possibility = new ArrayList<>();
				this.comparerCode();
				if ((malPlacé == 0) && (bienPlacé == 0)) {
					allPossibilities.remove(propositionOrdinateur);
				} else {
					Possibility.add(propositionOrdinateur.get(i));
					allPossibilities.add((Code) Possibility);

				}

			}

		}
	}
}