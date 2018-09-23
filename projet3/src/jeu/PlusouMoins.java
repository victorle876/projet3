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

//	@Override
//	 public String RechercheDichotomie() {
//	 boolean trouve2 = false;
//	 for (int i = codeATrouver.size(); i >= 0; i++) {
//		 int propositionDefenseur = codeATrouver.get(i);
//		 int propositionAttaquant = proposition.get(i);
//		 if (propositionAttaquant > propositionDefenseur) {
//			 System.out.println("Le chiffre proposé de l'attaquant doit être dans la premiere moitié )");
//			 propositionAttaquant =  propositionDefenseur - ((propositionAttaquant - propositionDefenseur) / 2)   ;
//		 } 
//		 else {
//			 if (propositionAttaquant < propositionDefenseur) {
//				 System.out.println("Le chiffre proposé de l'attaquant )");
//				 propositionAttaquant = propositionAttaquant + ((propositionDefenseur - propositionAttaquant) / 2);
//			 }
//	
//	 }
//	 return;
//	 }

}
