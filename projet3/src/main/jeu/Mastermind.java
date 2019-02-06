package main.jeu;

import java.util.ArrayList;
import java.util.Random;

public class Mastermind extends Jeu {
	private ArrayList<Code> toutesPossibilites = new ArrayList<>();

	public Mastermind() {
		super();
	}
	

	/***
	 * Constructeur pour la classe Mastermind
	 * 
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
	 * retourne un résultat
	 */
	@Override
	public String comparerCode() {
		String resultat = comparerCode(propositionDuJoueur, codeATrouverParLeJoueur);

		String[] resultats = resultat.split(":");
		resultatPourLeJoueur = "Bien Placé :" + resultats[0] + "; malPlace : " + resultats[1];

		return resultat;

	}

	/**
	 * Méthode permet de comparer entre la proposition du joueur et le code de l'ordinateur
	 * pour les nombres bien placées et mal placées
	 * @param proposition:code
	 *            proposé par l'attaquant
	 * @param codeTofind:
	 *            code à trouver par l'attaquant
	 * @return la séquence bienPlace: malPlace
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
					break;
				}

			}
		}

		return bienPlace + ":" + malPlace;
	}

	@Override
	public boolean isGagne(String resultat) {
		return (resultat.matches(taille + ":0$"));
	}

	@Override
	public Code chercherSolution() {
		Random r = new Random();
		this.propositionOrdinateur.clear();
		if ((this.toutesPossibilites == null) || (this.toutesPossibilites.isEmpty())) {
			this.toutesPossibilites = Code.getAllPossibilities(taille, etendue);
		}
		// propositionOrdinateur est une valeur tirée au hasard dans
		if (!this.toutesPossibilites.isEmpty()) {
			propositionOrdinateur = toutesPossibilites.get(r.nextInt(toutesPossibilites.size()));
		}
		return propositionOrdinateur;
	}

	/**
	 * Méthode permettant de saisir le nombre de bienPlace et malPlace
	 * 
	 */
	public String demanderAnalyse() {
		int bp = Aide.demandeValeurEntier(0, 6, "Entrer le nombre de BienPlace");
		int mp = Aide.demandeValeurEntier(0, 6, "Entrer le nombre de MalPlace");
		String bpCommeChaine = Integer.toString(bp);
		String mpCommeChaine = Integer.toString(mp);
		return bpCommeChaine + ":" + mpCommeChaine;
	}

	/**
	 * Je prends les codes valables dans la liste et je les compare avec la liste
	 * des codes proposés par l'ordinatateur Si le résultat est le même que celui
	 * fourni par le joueur, alors c'est un code toujours valable, sinon on le
	 * supprime
	 * @param : resultat
	 */
	@Override
	public void analyserResultat(String resultat) {
		ArrayList<Code> suppress = new ArrayList<>();
		for (Code c : toutesPossibilites) {
			// Comparer c et le code proposé par l'ordinateur
			String res = comparerCode(c, propositionOrdinateur);
			if (!res.equalsIgnoreCase(resultat)) {
				suppress.add(c);
			}
		}
		toutesPossibilites.removeAll(suppress);

	}
}