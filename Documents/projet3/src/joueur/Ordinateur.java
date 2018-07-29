package joueur;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Ordinateur extends Joueur {
	private static final Logger logger = LogManager.getLogger();
	private int rechercheCode[][];
	List<String> l = new LinkedList<String>();

	public Ordinateur() {
		super();
	}
	
	@Override
	public void creerNouveauCombinaison() {
		if (TypeJeu == TypeJeu.PLUSOUMOINS) {
			int nbrChrCode = Options.getlongueurCodeP();

			double c = Math.random();
			String combinaison = "";
			for (int i = 0; i < nbrChrCode; i++) {
				c = c * 10;
			}
			combinaison = String.valueOf((int) c);
			while (combinaison.length() < nbrChrCode) {
				combinaison = "0" + combinaison;
			}
			logger.debug("Nouveau code Plus ou Moins généré par l'ordinateur : " + combinaison);
			combinaisonATrouver = code;
		} else if (TypeJeu == TypeJeu.MASTERMIND) {
			String code = "";
			int nbrChrCode = Parametres.getlongueurCodeMaster();
			
			do {
				Integer c = (int) (Math.random() * 10);
				if (c < nbrCouleurs) {
					code = code + c;
				}
			} while (code.length() < nbrChrCode);
			combinaisonATrouver = code;
			logger.debug("Nouveau code Mastermind généré par l'ordinateur : " + code);
		}
	}
	@Override
	public void chercherCombinaison() {
		if (TypeJeu == TypeJeu.PLUSOUMOINS) {
			chercherCodeP();
		} else if (typeJeu == TypeJeu.MASTERMIND) {
			chercherCodeMaster();
		}
	}
	private void chercherCodeP() {
		if (emptyRowTableauJeu != 0) {
			// si il y a déjà un résultat, mettre à jour le tableau de recherche avec de
			// nouvelles bornes
			String resultat = tableauJeu[emptyRowTableauJeu - 1][1];
			for (int i = 0; i < Options.getInstance().getlongueurCodePlus(); i++) {
				String c = "" + tableauJeu[emptyRowTableauJeu - 1][0].charAt(i);
				if (resultat.charAt(i) == '+') {
					rechercheCombinaison[i][0] = Integer.parseInt(c);
				} else if (resultat.charAt(i) == '-') {
					rechercheCombinaison[i][1] = Integer.parseInt(c);
				} else if (resultat.charAt(i) == '=') {
					rechercheCombinaison[i][0] = Integer.parseInt(c);
					rechercheCombinaison[i][1] = Integer.parseInt(c);
				}
			}
		} else {
			// initialise le tableau permettant la recherche de code au début de la partie
			rechercheCombinaison = new int[Options.getlongueurCodeP()][2];
			for (int i = 0; i < Options.getlongueurCodeP(); i++) {
				rechercheCombinaison[i][0] = 0;
				rechercheCombinaison[i][1] = 10;
			}
		}
}
