package joueur;

public class joueur {

	protected joueur adversaire;
	protected ModeJeu ModeJeu;
	protected TypeJeu TypeJeu;
	
	protected String proposition = "";
	protected String resultat = "";
	protected String combinaisonATrouver = "";
	protected int toursRestants = 0;
	protected boolean gagnant = false;
	protected String[][] RecapitulatifCombinaison;

	
	private static final Logger logger = LogManager.getLogger();
	
	public Joueur() {

	}
	
	public void DebutPartie(TypeJeu t, ModeJeu m) {
		
	    adversaire.TypeJeu = t;
		adversaire.ModeJeu = m;
	    adversaire.gagnant = false;
		adversaire.resultat = "";
	    adversaire.proposition = "";
	    
	    if (TypeJeu == "MASTERMIND") {
			RecapitulatifCombinaison = new String[Parametres.getNbrEssaisMasterMind()][Options.getlongueurCodeM()];
			adversaire.RecapitulatifCombinaison = new String[Parametres.getNbrEssaisMasterMind()][Parametres.getlongueurCodeM()];
			adversaire.toursRestants = Parametres.getNbrEssaisMasterMind();
			toursRestants = Parametres.getNbrEssaisMaster();
		} else if (TypeJeu == "PLUSOUMOINS") {
			RecapitulatifCombinaison = new String[Parametres.getNbrEssaisP()][Options.getInstance()
					.getlongueurCodeP()];
			adversaire.RecapitulatifCombinaison = new String[Parametres.getNbrEssaisP()][Options
					.getlongueurCodeP()];
			toursRestants = Parametres.getNbrEssaisMasterMind();
		
	}
	
	protected abstract void DevinerCode();
	
	public abstract void creerNouveauCombinaison();
	
	public String proposerCombinaisonP(String combinaison) {
		String resultat = "";
		for (int i = 0; i < combinaisonATrouver.length(); i++) {
			int j = combinaisonATrouver.charAt(i);
			int k = combinaison.charAt(i);
			if (j == k) {
				resultat = resultat + "=";
			} else if (j > k) {
				resultat = resultat + "+";
			} else {
				resultat = resultat + "-";
			}
		}
		return resultat;

	}
	
	public String proposerCombinaisonM(String combinaison) {
		String result = "";
		boolean[] recap= new boolean[combinaison.length()];
		boolean[] recap2 = new boolean[combinaison.length()];

		// initialise les tableaux (pour empecher l'utilisation si déja comparé)
		for (int i = 0; i < combinaison.length(); i++) {
			recap[i] = true;
			recap2[i] = true;
		}

		// premier tours pour verifier les couleurs à la bonne place (=)
		for (int i = 0; i < combinaison.length(); i++) {
			if (combinaison.charAt(i) == combinaisonATrouver.charAt(i)) {
				result = result + "=";
				recap[i] = false;
				recap2[i] = false;
			}
		}

		// 2nd tour pour vérifier les couleurs à la mauvaise place (-)
		for (int i = 0; i < combinaison.length(); i++) {
			if (recap[i]) {
				for (int j = 0; j < combinaison.length(); j++) {

					if (combinaisonATrouver.charAt(i) == combinaisonATrouver.charAt(j) && recap2[j]) {
						resultat = resultat + "-";
						recap2[j] = false;
					

					}

				}
			}

		}
		return resultat;
	}
	
	public boolean isHuman() {
		if (this.getClass() == Humain.class) {
			return true;
		} else {
			return false;
		}
	}

	
	public void finPartie() {
		String message = "";
		if (ModeJeu == "CHALLENGER") {
			if (gagnant) {
				message = "Vous avez gagné !";
			} else {
				message = "Vous avez perdu !";
			}
		} else if (ModeJeu == "DEFENSEUR") {
			if (gagnant) {
				message = "L'ordinateur a gagné !";
			} else {
				message = "L'ordinateur a perdu !";
			}
		} else if (modeJeu == ModeJeu.DUEL) {
			if (gagnant && adversaire.gagnant) {
				message = "Gagné Ex Aequo!";
			} else if ((isHuman() && gagnant) || (adversaire.isHuman() && adversaire.gagnant)) {
				message = "Vous avez gagné !";
			} else {
				message = "Vous avez perdu !";
			}
		}
		logger.info(message);
		message = message + "\n Voulez-vous recommencer la partie ?";

	}
		
	}
	
	public String[][] getRecapitulatifCombinaison() {
		return RecapitulatifCombinaison;
	}

	/**
	 * @param tab
	 *            le tableau de jeu (toutes les proposition et les réponses reçues)
	 */
	public void setRecapitulatifCombinaison(String[][] recap) {
		this.RecapitulatifCombinaison = recap;
	}
}
