package jeu;
import java.util.ArrayList;
import java.util.Scanner;

public class PlusouMoins extends Jeu {
	
	protected Code CodeaTrouver ;
	private Code proposition;
	
	@Override
	public static Code ComparerReponse (int NombreEssaiPlus) {
		String result = "";
		boolean trouve = false;
		
		for (int j = 0; j < NombreEssaiPlus; j++)
		{	
	     	for (int i = 0; i < CodeaTrouver.length(); i++) 
	     	{
	     		// 
		     	int propositionJoueur = proposition.charAt(i);
		     	int propositionOrd = CodeaTrouver.charAt(i);
		     	if (propositionJoueur == propositionOrd ) {
			     	result = result + "=";
		     	} else if (propositionJoueur > propositionOrd) {
				   result = result + "+";
			          } else {
			         	result = result + "-";
			         	trouve = true;
			            }
		     }
		    
		 }

	}
	@Override
	public static Code CreerCode (int NombreEssaiPlus) {
		for (int i = 0; i < Code.length(); i++) {
			CodeaTrouver = Scanner.nextInt();
			}
		
	}
	
	@Override
	public static Code ProposerCode (int NombreEssaiPlus) {
		for (int i = 0; i < Code.size(); i++) {
			Code.add();
			}
		
	}

}
