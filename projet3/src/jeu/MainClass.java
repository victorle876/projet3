package jeu;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class MainClass {

	private static int etendue = 9;
	private static int taille = 4;
	private static int typeChoixJeu = 2;
	private static int attaqueDefenseChoix =1;
	private static int confirmParametres = 1;
	private static int nombreEssaiMax = 10;
    private static Jeu jeu;
	/**
	 * La classe principale permettant de saisir l'étendue et la taille, et ensuite
	 * de choisir le jeu et son mode Saisie des parametres de configuration
	 * 
	 * @param args
	 */

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Jeu jeu = null;
		Properties configuration = null;
		confirmParametres = Aide.demandeValeurEntier(1, 2, "Voulez vous changer la configuration du jeu?Non (1) ou oui (2)");
		switch (confirmParametres) {
		case 1:
			configuration = lireConfiguration();
			
		    break;

		case 2:
			configuration = creerConfiguration();
			break;
		default:
			System.out.println("Configuration invalide");
		} 
		    etendue = Integer.parseInt(configuration.getProperty("etendue"));
			taille = Integer.parseInt(configuration.getProperty("taille"));
			typeChoixJeu = Integer.parseInt(configuration.getProperty("typeChoixJeu"));
		    attaqueDefenseChoix = Integer.parseInt(configuration.getProperty("attaqueDefenseChoix"));
		    nombreEssaiMax = Integer.parseInt(configuration.getProperty("nombreEssaiMax"));
			
		// Si config non valable, on récupère une exception => try...catch
		// Le try contient l'appel standard et fonctionnel
		// Le catch sort en affichant une information à l'utilisateur


		// Creation du jeu
		switch (typeChoixJeu) {
		case 1:
			jeu = new Mastermind(etendue, taille);
			break;

		case 2:
			jeu = new PlusouMoins(etendue, taille);
			break;
		default:
			System.out.println("Choix de jeu invalide");
		}

		// Resolution du jeu
		switch (attaqueDefenseChoix) {
		case 1: // Ordinateur attaque
			System.out.println(boucleJeuAttaquant(jeu, typeChoixJeu, etendue, taille, nombreEssaiMax));
			break;
		case 2: // ordinateur défend
			System.out.println(boucleJeuDefenseur(jeu, typeChoixJeu, etendue, taille, nombreEssaiMax));
			break;
		case 3 : // attaque/defense
			System.out.println(boucleJeuMixte(jeu, typeChoixJeu, etendue, taille));
			break;
			
		default:
			System.out.println("Mode de jeu invalide");
		}
	}

	/**
	 * Mode de fonctionnement par l'attaquant, quel que soit le jeu choisi
	 * 
	 * @param jeu:
	 *            choix entre le PlusouMoins (1) et mastermind (2)
	 * @param choice:
	 *            mode choisi entre le mode attaquant et le mode défenseur
	 * @param etendue:
	 *            la plage définie sur le jeu à 1 chiffres
	 * @param taille:
	 *            nombre de chiffres que comporte le code
	 * @return
	 */
	public static String boucleJeuAttaquant(Jeu jeu, int typeChoixJeu, int etendue, int taille, int nombreEssaiMax) {
		boolean trouve1 = false;
		String message = "";
		String resultat = "";
//		int nombreEssaiMax = 10;
		for (int i = 0; i < nombreEssaiMax && !trouve1; i++) {
//			System.out.print("Le code proposé par l'ordinateur : ");
//			System.out.println(jeu.chercherSolution());
//			System.out.println("Quel est le resultat pour cette proposition ?");
//			resultat = jeu.demandeAnalyse();
//			jeu.analyserResultat(resultat);
//			trouve = jeu.isWon(resultat);
			trouve1 = boucleJeuAttaquantbis(jeu, typeChoixJeu, etendue,taille);
			

		}
		message = ("Vous avez " + ((trouve1) ? "gagné" : "perdu"));
		return message;
	}
	
	public static boolean boucleJeuAttaquantbis(Jeu jeu, int typeChoixJeu, int etendue, int taille) {

			System.out.print("Le code proposé par l'ordinateur : ");
			System.out.println(jeu.chercherSolution());
			System.out.println("Quel est le resultat pour cette proposition ?");
			String resultat = jeu.demandeAnalyse();
			jeu.analyserResultat(resultat);
			boolean trouve1a = jeu.isWon(resultat);
			
			return trouve1a;
	
	}
	
		
	public static String boucleJeuMixte(Jeu jeu, int typeChoixJeu, int etendue, int taille) {
		boolean trouve1 = false;
		boolean trouve2 = false;
		//boolean trouve= false;
		String message2;
		String resultat = "";
		jeu.setCodeATrouverParLeJoueur(Code.genererNewCode(etendue, taille));
		
		//while (!trouve1 || !trouve2) 
		for (int i = 0; i < nombreEssaiMax && (!trouve1|| !trouve2) ; i++){
			
		 //attaque
		 if (!trouve1) {
		 	 trouve1 = boucleJeuAttaquantbis(jeu, typeChoixJeu, etendue, taille);
		 }
			//defense
		 if (!trouve2) {
			 trouve2 = boucleJeuDefensebis(jeu, typeChoixJeu, etendue, taille); 
		 }
					
		}
			
		message2 = ("Vous avez " + ((trouve1 || trouve2) ? "gagné" : "perdu"));
		return message2;
		
	}

	/**
	 * Mode de fonctionnement par la défense,quel que soit le jeu choisi
	 * 
	 * @param jeu
	 * @param choice
	 * @param etendue
	 * @param taille
	 * @return
	 */
	public static String boucleJeuDefenseur(Jeu jeu, int typeChoixJeu, int etendue, int taille, int nombreEssaiMax ) {
//		int nombreEssaiMax = 10;
		boolean trouve2 = false;
		String message = "" ;
		jeu.setCodeATrouverParLeJoueur(Code.genererNewCode(etendue, taille));

		// Boucle de recherche de la solution par le joueur
		for (int i = 0; i < nombreEssaiMax && !trouve2; i++) {
			// On affiche le code à trouver
//			System.out.println("Voici le code à deviner");
//			System.out.println(jeu.getCodeATrouverParLeJoueur());
//
//			if (!trouve) {
//				System.out.println("Entrer un nouveau code?");
//				jeu.enterCode();
//
//				System.out.println("Le résultat est : " + jeu.comparerCode());
//				trouve = jeu.isWon(jeu.getResultatPourLeJoueur());
//			}
			trouve2 = boucleJeuDefensebis(jeu, typeChoixJeu, etendue, taille);

		}
		message = ("Vous avez " + ((trouve2) ? "gagné" : "perdu"));
		return message;

	}
	
	public static boolean boucleJeuDefensebis(Jeu jeu, int typeChoixJeu,int etendue, int taille) {
		
		boolean trouve2a = false;

		System.out.println("Voici le code à deviner");
		System.out.println(jeu.getCodeATrouverParLeJoueur());

		if (!trouve2a) {
			System.out.println("Entrer un nouveau code?");
			jeu.enterCode();

			System.out.println("Le résultat est : " + jeu.comparerCode());
			trouve2a = jeu.isWon(jeu.getResultatPourLeJoueur());
		}
		
		return trouve2a;

}

	
    private static Properties lireConfiguration () {
		Properties prop = new Properties();
//		InputStream input = null;

		try (FileInputStream input = new FileInputStream("config.properties")){
			// load a properties file				
			prop.load(input);
			int etendue1 = Integer.parseInt(prop.getProperty("etendue"));
			int taille1 = Integer.parseInt(prop.getProperty("taille"));
			int typeChoixJeu1 = Integer.parseInt(prop.getProperty("typeChoixJeu"));
			int attaqueDefenseChoix1 = Integer.parseInt(prop.getProperty("attaqueDefenseChoix"));
		    int nombreEssaiMax1 = Integer.parseInt(prop.getProperty("nombreEssaiMax"));
			
		} catch (IOException ex) {
			System.out.println("Fichier de configuration introuvable. Il faut le recréer.");
			prop = creerConfiguration();
		} 
		catch (NumberFormatException ex) {
			System.out.println("Le fichier est corrompu. Il faut le recréer.");
			prop = creerConfiguration();
		} 
		
		return prop;	
	}

	private static Properties creerConfiguration() {
		Properties prop = new Properties();
		OutputStream writer = null;
		String comments = " ";

		try {
			writer = new FileOutputStream("config.properties");
			// Demander les 4 paramètres à l'utilisateur
			// avec les méthodes de Helper
			etendue = Aide.demandeValeurEntier(1, 9, "Entrer l'étendue");
			taille = Aide.demandeValeurEntier(1, 6, "Entrer la taille");
			typeChoixJeu = Aide.demandeValeurEntier(1, 2, "Quel jeu voulez vous jouer?\n1: Mastermind , 2: PlusouMoins");
			attaqueDefenseChoix = Aide.demandeValeurEntier(1, 3, "Ordinateur attaquant (1) ou défenseur (2) ?");
			nombreEssaiMax = Aide.demandeValeurEntier(1, 10, "Entrer le nombre d'essais max");
			
			prop.setProperty("etendue", "" + etendue);
			prop.setProperty("taille", "" + taille);
			prop.setProperty("typeChoixJeu",  "" + typeChoixJeu);
			prop.setProperty("attaqueDefenseChoix", "" + attaqueDefenseChoix);
			prop.setProperty("nombreEssaiMax", "" + nombreEssaiMax);
            
			prop.store(writer, comments);
			
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			
			}
		}
		
		return prop;
	}
}