package jeu;

public class jeu {
	
	private String TypeJeu = "";
	private String ModeJeu = "";
	private String Joueur = "" ;
	
	
	
	public void choisirJeu() {
		if (TypeJeu == "PLUSOUMOINS") {
			PlusouMoins();
		} 
		else if (TypeJeu == "MASTERMIND") {
			Mastermind();
		}
	}
	
	

}
