package jeu;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MainClass {

	private static int etendue = 9;
	private static int taille = 4;
	private static int typeChoixJeu = 2;
	private static int attackDefenseChoice;

	/**
	 * La classe principale permettant de saisir l'étendue et la taille, et ensuite
	 * de choisir le jeu et son mode Saisie des parametres de configuration
	 * 
	 * @param args
	 */

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Jeu jeu = null;
		Properties configuration = lireConfiguration();
		int etendue1 = Integer.parseInt(configuration.getProperty("etendue"));
		int taille1 = Integer.parseInt(configuration.getProperty("taille"));
		int typeChoixJeu1 = Integer.parseInt(configuration.getProperty("typeChoixJeu"));
		int attackDefenseChoice1 = Integer.parseInt(configuration.getProperty("attackDefenseChoice"));
		

<<<<<<< HEAD
//		etendue = Helper.demandeValeurEntier(1, 9, "Entrer l'étendue");
//		taille = Helper.demandeValeurEntier(1, 6, "Entrer la taille");
//		typeChoixJeu = Helper.demandeValeurEntier(1, 2, "Quel jeu voulez vous jouer?\n1: Mastermind , 2: PlusouMoins");
//		attackDefenseChoice = Helper.demandeValeurEntier(1, 2, "Ordinateur attaquant (1) ou défenseur (2) ?");
=======
		// TODO
		// Demander à l'utilisateur s'il veut jouer avec la config actuelle ou la
		// changer
		// Si changer => appeler la méthode creerConfiguration
		// Sinon on continue "comme avant"

		// On peut imaginer vérifier si la config est valable dans la méthode
		// lireConfiguration.
		// Si config non valable, on récupère une exception => try...catch
		// Le try contient l'appel standard et fonctionnel
		// Le catch sort en affichant une information à l'utilisateur
		Properties configuration = lireConfiguration();

		etendue = Integer.parseInt(configuration.getProperty("etendue"));
		taille = Integer.parseInt(configuration.getProperty("taille"));
		typeChoixJeu = Integer.parseInt(configuration.getProperty("typeChoixJeu"));
		attackDefenseChoice = Integer.parseInt(configuration.getProperty("attackDefenseChoice"));
>>>>>>> branch 'new-master' of https://github.com/victorle876/projet3.git

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
<<<<<<< HEAD
	
	private static Properties creerConfiguration() {
		//todo
		Properties prop = new Properties();
	//	 int etendue1 = Integer.parseInt(prop.getProperty("etendue"));
	//	 int taille1 = Integer.parseInt(prop.getProperty("taille"));
	//	 int typeChoixJeu1 = Integer.parseInt(prop.getProperty("typeChoixJeu"));
	//	 int attackDefenseChoice1 = Integer.parseInt(prop.getProperty("attackDefenseChoice"));
		etendue = Helper.demandeValeurEntier(1, 9, "Entrer l'étendue");
		taille = Helper.demandeValeurEntier(1, 6, "Entrer la taille");
		typeChoixJeu = Helper.demandeValeurEntier(1, 2, "Quel jeu voulez vous jouer?\n1: Mastermind , 2: PlusouMoins");
		attackDefenseChoice = Helper.demandeValeurEntier(1, 2, "Ordinateur attaquant (1) ou défenseur (2) ?");
		 
		 return prop;
	}
	
	private static Properties lireConfiguration() {
=======

	public static Properties lireConfiguration() {
>>>>>>> branch 'new-master' of https://github.com/victorle876/projet3.git
		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream("config.properties");
			// load a properties file
			prop.load(input);
<<<<<<< HEAD

			// get the property value and print it out
	//		System.out.println(prop.getProperty("taille"));
	//		System.out.println(prop.getProperty("etendue"));
	//		System.out.println(prop.getProperty("typeChoixJeu"));
	//		System.out.println(prop.getProperty("attackDefenseChoice"));
=======
>>>>>>> branch 'new-master' of https://github.com/victorle876/projet3.git
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
<<<<<<< HEAD
		
=======
>>>>>>> branch 'new-master' of https://github.com/victorle876/projet3.git
	}

	private static Properties creerConfiguration() {
		Properties prop = new Properties();
		// Demander les 4 paramètres à l'utilisateur
		// avec les méthodes de Helper
		// TODO
		// prop.store(writer, comments);
		// écrire le fichier de configuration

		// retourner la configuration
		return prop;
	}
}