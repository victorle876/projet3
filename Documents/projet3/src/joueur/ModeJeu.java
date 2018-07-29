package joueur;

public class ModeJeu {
	
	    private String mode = "";
	    private String MsgMode = "";
	    
	    public void setModeJeuCombinaison() {
			this.mode = mode; 
	    }

	   public String toString() {
        switch(mode)
        {
            case "Challenger" :
            	MsgMode = "Challenger";
                break;
            case "Duel" :
            	MsgMode = "Duel";
                break;
        }
        System.out.println("Le mode de jeu "+MsgMode);
	   }  

}
