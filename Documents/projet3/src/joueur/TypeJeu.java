package joueur;

public class TypeJeu {
	private String type = "";
    private String MsgType = "";
    
    public void setModeJeuCombinaison() {
		this.type = type; 
    }

   public String toString() {
    switch(type)
    {
        case "Mastermind" :
        	MsgType = "Mastermind";
            break;
        case "CodeP" :
        	MsgType = "CodeP";
            break;
    }
    System.out.println("Le mode de jeu "+ MsgType);
   }  

}
