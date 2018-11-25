package jeu;

import java.util.ArrayList;
import java.util.Random;

public class Mastermind extends Jeu {
	private ArrayList<Code> allPossibilities = new ArrayList<>();

	public Mastermind() {
		super();
	}

	/***
	 * Constructeur pour la classe Mastermind
	 * @param etendue
	 * @param taille
	 */
	public Mastermind(int etendue, int taille) {
		this.etendue = etendue;
		this.taille = taille;
		this.propositionOrdinateur = new Code();
	}
	
    /**
     * Classe permettant de faire l'extraction bienPlace : malPlace
     * 
     */
	@Override
	public String comparerCode() {
		String resultat = comparerCode(propositionDuJoueur, codeATrouverParLeJoueur);

		String[] resultats = resultat.split(":");
		resultatPourLeJoueur = "Bien Placé :" + resultats[0] + "; malPlace : " + resultats[1];

		return resultat;

	}
	
	/**
	 * Méthode permettant de trouver les chiffres bien placés par comparaison et les 
	 * supprimer
	 * si les chiffres sonnt malpacés, on les comptabilie et les upprime
	 * @param proposition
	 * @param codeTofind
	 * @return
	 */

	private String comparerCode(Code proposition, Code codeTofind) {
		Code prop = (Code) proposition.clone();
		Code cat = (Code) codeTofind.clone();

		int bienPlace = 0;
		int malPlace = 0;
		for (int i = prop.size() - 1; i >= 0; i--) {
			int propositionAttaquant = prop.get(i);
			int propositionDefenseur = cat.get(i);
			if (propositionAttaquant == propositionDefenseur) {
				prop.remove(i);
				cat.remove(i);
				bienPlace++;

			}
		}
		for (int j = prop.size() - 1; j >= 0; j--) {
			int propositionAttaquantRestant = prop.get(j);
			for (int k = prop.size() - 1; k >= 0; k--) {
				int propositionDefenseurRestant = cat.get(k);
				if (propositionAttaquantRestant == propositionDefenseurRestant) {
					prop.remove(j);
					cat.remove(k);
					malPlace++;
					System.out.println(malPlace);
					System.out.println(k);
					break;
				}

			}
		}

		return bienPlace + ":" + malPlace;
	}

	@Override
	public boolean isWon(String resultat) {
		return (resultat.matches(taille + ":0$"));
	}
	
	
    /**
     * Methode permmettant de construire une liste de codes proposées par l'ordinateur
     * et de sélectionner par rapport à la liste de codes existants à trouver
     */
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
	
	/**
	 * Méthode permettant de saisir le nombre de bienPlace et malPlace
	 * 
	 */
	public void demandeAnalyse() {
		int bp = Helper.demandeValeurEntier(0, 6, "Entrer le nombre de BienPlace");
		int mp = Helper.demandeValeurEntier(0, 6, "Entrer le nombre de MalPlace");
		String bpAsString = Integer.toString(bp);
		String mpAsString = Integer.toString(mp);
		String resultat = bpAsString + ":" + mpAsString;
	}
	
    /**
     * Je prends les codes valables dans la liste et je les compare avec la liste des 
     * codes proposés par l'ordinatateur
     * Si le résultat est le même que celui fourni par le joueur, alors c'est un
     * code toujours valable, sinon on le supprime
     */
	@Override
	public void analyserResultat(String resultat) {
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