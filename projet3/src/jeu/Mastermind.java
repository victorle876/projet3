package jeu;

public class Mastermind extends Jeu {
	 protected Code codeATrouver;

	@Override
	public String comparerCode() {
		String result = "";
		Code prop = (Code) proposition.clone();
		Code cat = (Code) codeATrouver.clone();

		int bienPlacé = 0;
		int MalPlacé = 0;
		for (int i = prop.size()-1; i >= 0; i--) {
			int propositionAttaquant = prop.get(i);
			int propositionDefenseur = cat.get(i);
			if (propositionAttaquant == propositionDefenseur) {
				prop.remove(i);
				cat.remove(i);
				bienPlacé++;
				
			}
			
			for (int j = prop.size()-1; j >= 0; j--) {
				int propositionAttaquantRestant = prop.get(i);
				for (int k = prop.size()-1; k >= 0; k--) {
					int propositionDefenseurRestant = cat.get(i);  
					if (propositionAttaquantRestant == propositionDefenseurRestant) {
						prop.remove(i);
						cat.remove(i);
						MalPlacé++;
					}
						
				
				}	
				}
	

		}
		System.out.println("Bien Placé :" + bienPlacé + "; MalPlacé : " + MalPlacé);

		return result;
	}

	@Override
	public boolean isWon(String resultat) {
		return (resultat.matches("????"));
	}

}
