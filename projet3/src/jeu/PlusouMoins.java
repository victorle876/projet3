package jeu;

public class PlusouMoins extends Jeu {

	@Override
	public String comparerCode() {
		resultat = "";
		for (int i = 0; i < codeATrouver.size(); i++) {
			int propositionAttaquant = proposition.get(i);
			int propositionDefenseur = codeATrouver.get(i);
			if (propositionAttaquant == propositionDefenseur) {
				resultat += "=";
			} else if (propositionAttaquant > propositionDefenseur) {

				resultat += "-";
			} else {
				resultat += "+";
			}
			// }

		}
		return resultat;

	}

	@Override
	public boolean isWon(String resultat) {
		return (resultat.matches("^=+$"));
	}

}
