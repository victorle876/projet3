package jeu;

public class PlusouMoins extends Jeu {


	@Override
	public String comparerCode() {
		String result = "";
		for (int i = 0; i < codeATrouver.size(); i++)
		{
			//
			int propositionAttaquant = proposition.get(i);
			int propositionDefenseur = codeATrouver.get(i);
			if (propositionAttaquant == propositionDefenseur) 
			{
				result +=  "=" ;
			}
			else 
				if (propositionAttaquant > propositionDefenseur) 
			     {	
			     
				result += "-";
			     }
			     else 
			     {
				 result += "+";				
			     }
//		     }

	     }
		return result;
		
	 }
	
	@Override
	public boolean isWon(String resultat)
	{
		return(resultat.equals("===="));
	}

	}


	
