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
	private static int attackDefenseChoice =1;
	private static int confirmParametres = 1;

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
		System.out.println("Voulez vous changer la configuration du jeu?Non (1) ou oui (2)");
		confirmParametres = Helper.demandeValeurEntier(1, 2, "Voulez vous changer la configuration du jeu?Non (1) ou oui (2)");
		switch (confirmParametres) {
		case 1:
			try {
		    configuration = lireConfiguration();
		    etendue = Integer.parseInt(configuration.getProperty("etendue"));
			taille = Integer.parseInt(configuration.getProperty("taille"));
			typeChoixJeu = Integer.parseInt(configuration.getProperty("typeChoixJeu"));
		    attackDefenseChoice = Integer.parseInt(configuration.getProperty("attackDefenseChoice"));
			} 
			catch (NumberFormatException ie) {
				System.out.println("le fichier de configuration est corrompue");
			}
		    break;

		case 2:
			try {
			configuration = creerConfiguration();
			} 
			catch (NumberFormatException ie) {
				System.out.println("Configuration invalide");
			}
			break;
		default:
			System.out.println("Configuration invalide");
		} 
		
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
		switch (attackDefenseChoice) {
		case 1: // Ordinateur attaque
			System.out.println(boucleJeuAttaquant(jeu, typeChoixJeu, etendue, taille));
			break;
		case 2: // ordinateur défend
			System.out.println(boucleJeuDefenseur(jeu, typeChoixJeu, etendue, taille));
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
	public static String boucleJeuAttaquant(Jeu jeu, int choice, int etendue, int taille) {
		int nombreEssaiMax = 10;
		boolean trouve = false;
		String message;
		String resultat = "";
		for (int i = 0; i < nombreEssaiMax && !trouve; i++) {
			System.out.print("Le code proposé par l'ordinateur : ");
			System.out.println(jeu.chercherSolution());
			System.out.println("Quel est le resultat pour cette proposition ?");
			resultat = jeu.demandeAnalyse();
			jeu.analyserResultat(resultat);
			trouve = jeu.isWon(resultat);

		}
		message = ("Vous avez " + ((trouve) ? "gagné" : "perdu"));
		return message;
	}
	
	public static String boucleJeuMixte(Jeu jeu, int choice, int etendue, int taille) {
		int nombreEssaiMax = 10;
		boolean trouve1 = false;
		boolean trouve2 = false;
		String message;
		String resultat = "";
		jeu.setCodeATrouverParLeJoueur(Code.genererNewCode(etendue, taille));
		for (int i = 0; i < nombreEssaiMax && !trouve1; i++) {
			
			//attaque
			System.out.print("Le code proposé par l'ordinateur : ");
			System.out.println(jeu.chercherSolution());
			System.out.println("Quel est le resultat pour cette proposition ?");
			resultat = jeu.demandeAnalyse();
			jeu.analyserResultat(resultat);
			trouve1 = jeu.isWon(resultat);
			
			//defense
			
			System.out.println("Voici le code à deviner");
			System.out.println(jeu.getCodeATrouverParLeJoueur());

			if (!trouve2) {
				System.out.println("Entrer un nouveau code?");
				jeu.enterCode();

				System.out.println("Le résultat est : " + jeu.comparerCode());
				trouve2 = jeu.isWon(jeu.getResultatPourLeJoueur());
			}
		}
			
		message = ("Vous avez " + ((trouve1 || trouve2) ? "gagné" : "perdu"));
		return message;
		
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
	public static String boucleJeuDefenseur(Jeu jeu, int choice, int etendue, int taille) {
		int nombreEssaiMax = 10;
		boolean trouve = false;
		String message;
		jeu.setCodeATrouverParLeJoueur(Code.genererNewCode(etendue, taille));

		// Boucle de recherche de la solution par le joueur
		for (int i = 0; i < nombreEssaiMax && !trouve; i++) {
			// On affiche le code à trouver
			System.out.println("Voici le code à deviner");
			System.out.println(jeu.getCodeATrouverParLeJoueur());

			if (!trouve) {
				System.out.println("Entrer un nouveau code?");
				jeu.enterCode();

				System.out.println("Le résultat est : " + jeu.comparerCode());
				trouve = jeu.isWon(jeu.getResultatPourLeJoueur());
			}

		}
		message = ("Vous avez " + ((trouve) ? "gagné" : "perdu"));
		return message;

	}

	
    private static Properties lireConfiguration () {
		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream("config.properties");
			
			// load a properties file				
			prop.load(input);
		
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
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
			etendue = Helper.demandeValeurEntier(1, 9, "Entrer l'étendue");
			taille = Helper.demandeValeurEntier(1, 6, "Entrer la taille");
			typeChoixJeu = Helper.demandeValeurEntier(1, 2, "Quel jeu voulez vous jouer?\n1: Mastermind , 2: PlusouMoins");
			attackDefenseChoice = Helper.demandeValeurEntier(1, 2, "Ordinateur attaquant (1) ou défenseur (2) ?");
			
			prop.setProperty("etendue", "" + etendue);
			prop.setProperty("taille", "" + taille);
			prop.setProperty("typeChoixJeu",  "" + typeChoixJeu);
			prop.setProperty("attackDefenseChoice", "" + attackDefenseChoice);
            
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