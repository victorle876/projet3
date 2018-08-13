package jeu;

import java.util.ArrayList;
import java.util.Scanner;

public class PlusouMoins extends Jeu {


	@Override
	public String ComparerCode() {
		String result = "";
		for (int i = 0; i < codeATrouver.size(); i++)
		{
			//
			int propositionAttaquant = proposition.get(i);
			int propositionDefenseur = codeATrouver.get(i);
			if (propositionAttaquant = propositionDefenseur) 
			{
				result +=  "=" ;
			}
			else if (propositionAttaquant > propositionDefenseur) 
			{	
			     
				result = result + "+";
			     
			     else {
				 result += "-";				
			     }
		     }

	     }
		return result;
		
	 }

	}

//	@Override
//	public static Code ProposerCode(int NombreEssaiPlus) {
//		for (int i = 0; i < Code.size(); i++) {
//			Code.add();
//		}
//
//	}

	
