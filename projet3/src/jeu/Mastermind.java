package jeu;

public class Mastermind extends Jeu {
	// protected Code codeATrouver;
	// protected Code codeRestant;

	public class Code implements Cloneable {
		protected Code codeATrouver;
		protected Code codeRestant;

		public Object clone() {
			Code codeATrouver  = null;
			Code codeRestant  = null;
			try {
				codeATrouver = (Code) super.clone();
				codeRestant = (Code) super.clone();
			} catch (CloneNotSupportedException cnse) {
				cnse.printStackTrace(System.err);
			}
			// on renvoie le clone
			return codeATrouver;
		}

	}

	@Override
	public String comparerCode() {
		String result = "";

		int bienPlacé = 0;
		int MalPlacé = 0;
		for (int i = 0; i < proposition.size(); i++) {
			int propositionAttaquant = proposition.get(i);
			int propositionDefenseur = codeATrouver.get(i);
			if (propositionAttaquant == propositionDefenseur) {
				proposition.remove(propositionAttaquant);
				codeATrouver.remove(propositionDefenseur);
				bienPlacé++;
				codeRestant = codeATrouver;
			}
			for (int j = 0; i < codeRestant.size(); j++) {
				int propositionAttaquantRestant = proposition.get(i);
				int propositionDefenseurRestant = codeRestant.get(i);
				if (propositionAttaquantRestant == propositionDefenseurRestant) {
					proposition.remove(propositionAttaquant);
					codeATrouver.remove(propositionDefenseur);
					MalPlacé++;
				}

			}

		}
		System.out.println("Bien Placé :" + bienPlacé + "; MalPlacé : " + MalPlacé);

		return result;
	}

	@Override
	public boolean isWon(String resultat) {
		return (resultat.equals("????"));
	}

}
