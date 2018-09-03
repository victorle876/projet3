package jeu;


public class Mastermind extends Jeu {
	protected Code codeATrouver;
	
	@Override
	public String comparerCode() {
		String result = "";
		
		int bienPlacé=0;
		for (int i = 0; i < codeATrouver.size(); i++) {
			int propositionAttaquant = proposition.get(i);
			int propositionDefenseur = codeATrouver.get(i);
			if (propositionAttaquant == propositionDefenseur) {
				bienPlacé++;
			//	result = result + "=";

			}
		}
		
		
		return result;
	}
	@Override
	public boolean isWon(String resultat)
	{
		return(resultat.equals("===="));
	}
	

}
