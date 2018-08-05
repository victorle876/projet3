package jeu;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class code {
	
	private Integer longueurCodePlus, longueurCodeMaster;
	private int rechercheCode[][];
	protected String proposition = "";
	protected String resultat = "";
	protected String combinaisonATrouver = "";
	protected String combinaisonATrouver2 = "";
//	List<String> l = new LinkedList<String>();
	
	
	public int getlongueurCodePlus() {
		return this.longueurCodePlus;
	}

	
	public int getlongueurCodeMaster() {
		return this.longueurCodeMaster;
	}
	
	public void setlongueurCodePlus(int longueurCodePlus) {
		this.longueurCodePlus = longueurCodePlus;
	}

	/**
	 * @param i
	 *            longueur de la combinaison du mastermind
	 */
	public void setlongueurCodeMaster(int longueurCodeMaster) {
		this.longueurCodeMaster = longueurCodeMaster;
	}
	
	public void creerNouveauCode() {

		    Scanner sc = new Scanner(System.in);
		    String combinaison = "";
		    System.out.println("Saisissez un entier : ");
		    int NbreChiffresMax = sc.nextInt();
		    String code = "";
		    int[] solution = new int[NbreChiffresMax];
			for (int i = 0; i < NbreChiffresMax; i++) {
			 System.out.println("Saisissez un entier : ");
			 double ChiffresSaisie = sc.nextInt();
				if ((ChiffresSaisie > 0 ) && (ChiffresSaisie < 10 ))
				{
					System.out.println("Le chiffre est valide : ");
				}
			}
			combinaison = String.valueOf(ChiffresSaisie);
			while (combinaison.length() < NbreChiffresMax) {
				combinaison = "0" + combinaison;
			}
			combinaisonATrouver = combinaison;
		
		   }
	public void genererNouveauCombinaison() {
		
		   Scanner sc2 = new Scanner(System.in);
		   System.out.println("Saisissez un entier : ");
	       int NbreChiffresMax2 = sc2.nextInt();
			double c = Math.random();
			String combinaison2 = "";
			for (int i = 0; i < NbreChiffresMax2; i++) {
				c = c * 10;
			}
			combinaison2 = String.valueOf((int) c);
			while (combinaison2.length() < NbreChiffresMax2) {
				combinaison2 = "0" + combinaison2;
			}
			
			combinaisonATrouver2 = combinaison2;
		}	
		
}
