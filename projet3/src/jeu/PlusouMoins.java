package jeu;

public class PlusouMoins extends jeu {
	
	protected String combinaisonATrouver = "";

	
	public String ProposerReponsePlusouMoins(String combinaison) {
		String result = "";
		for (int i = 0; i < combinaisonATrouver.length(); i++) {
			int j = combinaisonATrouver.charAt(i);
			int k = combinaison.charAt(i);
			if (j == k) {
				result = result + "=";
			} else if (j > k) {
				result = result + "+";
			} else {
				result = result + "-";
			}
		}
		return result;

	}
	
	

}
