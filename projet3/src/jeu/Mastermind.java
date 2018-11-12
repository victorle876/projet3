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
		String resultat = comparerCode(propositionDuJoueur, codeATrouverParLeJoueur);

		String[] resultats = resultat.split(":");
		resultatPourLeJoueur = "Bien Placé :" + resultats[0] + "; MalPlacé : " + resultats[1];

		return resultat;

	}

	private String comparerCode(Code proposition, Code codeTofind) {
		Code prop = (Code) proposition.clone();
		Code cat = (Code) codeTofind.clone();

		int bienPlacé = 0;
		int malPlacé = 0;
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
					malPlacé++;
					System.out.println(malPlacé);
					System.out.println(k);
					break;
				}

			}
		}

		return bienPlacé + ":" + malPlacé;
	}

	@Override
	public boolean isWon(String resultat) {
		return (resultat.matches(taille + ":0$"));
	}

	@Override
	public Code chercherSolution() {
		Random r = new Random();
		this.propositionOrdinateur.clear();
		if ((this.allPossibilities == null) || (this.allPossibilities.isEmpty())) {
			this.allPossibilities = jeu.Code.getAllPossibilities(taille, etendue);
		}
		// propositionOrdinateur est une valeur tirée au hasard dans
		// this.allpossibilities
		if (!this.allPossibilities.isEmpty()) {
			propositionOrdinateur = allPossibilities.get(r.nextInt(allPossibilities.size()));
		}
		return propositionOrdinateur;
	}

	@Override
	public void analyserResultat(String resultat) {

		// Je prends tous les codes encore possiblement valables, et je les
		// compare avec le code proposé par l'ordinateur.
		// Si le résultat est le même que celui fourni par le joueur, alors c'est un
		// code toujours valable, sinon on le supprime
		ArrayList<Code> suppress = new ArrayList<>();
		for (Code c : allPossibilities) {
			// Comparer c et le code proposé par l'ordinateur
			String res = comparerCode(c, propositionOrdinateur);
			if (!res.equalsIgnoreCase(resultat)) {
				suppress.add(c);
			}
		}
		allPossibilities.removeAll(suppress);

	}
}