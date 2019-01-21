package jeu;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainClass {

	private static int etendue = 9;
	private static int taille = 4;
	private static int typeChoixJeu = 2;
	private static int attaqueDefenseChoix = 1;
	private static int confirmParametres = 1;
	private static int nombreEssaiMax = 10;
	private static boolean debug = false;
	private static Jeu jeu;

	public final static Logger LOGGER = LogManager.getLogger(jeu.MainClass.class.getName());

	/*
	 * TODO remettre GIT en état (transformer new-master en master d'une façon ou
	 * d'une autre)
	 * 
	 * TODO ajouter les fichiers log4japi et log4jcore au projet OU donner un lien
	 * de téléchargement de ces fichiers
	 * 
	 * TODO GIT : faire un README.md qui indique qu'on doit référencer les fichier
	 * log4j-api et log4jcore
	 * 
	 * TODO passer les variables en globales => supprimer les passages en paramètre
	 * de toutes les variables globales OU passer toutes les variables en local =>
	 * pas grand chose d'autre à modifier
	 * 
	 * TODO vérifier toutes les javadocs : les @param, les @return qui doivent être
	 * pertinents et remplis
	 * 
	 * TODO vérifier les noms des variables : on passe tout en français pur (cf.
	 * confirmParametres)
	 */

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
		boolean continuer = true;
		// TODO boucle jusqu'à ce que l'utilisateur choisisse de ne pas continuer à
		// jouer
		do {
			confirmParametres = Aide.demandeValeurEntier(1, 2,
					"Voulez vous changer la configuration du jeu ? Non (1) ou oui (2)");
			switch (confirmParametres) {
			case 1:
				configuration = lireConfiguration();

				break;

			case 2:
				configuration = creerConfiguration();
				break;
			default:
				LOGGER.warn("Configuration invalide"); //
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
				LOGGER.warn("Choix de jeu invalide");

			}

			// Resolution du jeu
			switch (attaqueDefenseChoix) {
			case 1: // Ordinateur attaque
				System.out.println(boucleJeu(jeu, typeChoixJeu, etendue, taille, nombreEssaiMax, false, true));
				break;
			case 2: // ordinateur défend
				System.out.println(boucleJeu(jeu, typeChoixJeu, etendue, taille, nombreEssaiMax, true, false));
				break;
			case 3: // attaque/defense
				System.out.println(boucleJeu(jeu, typeChoixJeu, etendue, taille, nombreEssaiMax, true, true));
				break;

			default:
				LOGGER.warn("Mode de jeu invalide");
			}
			// TODO demander à l'utilisateur s'il veut continuer à jouer
			continuer = Aide.demanderOuiNon("Voulez-vous continuer ?");
		} while (continuer);

	}

	/**
	 * Méthode utilisé soit par l'attaque, soit par la défense, soit l'attaque vs la
	 * défense
	 * 
	 * @param jeu
	 * @param typeChoixJeu
	 * @param etendue
	 * @param taille
	 * @return
	 */

	public static String boucleJeu(Jeu jeu, int typeChoixJeu, int etendue, int taille, int nombreEssaiMax,
			boolean ordinateurDefenseur, boolean ordinateurAttaquant) {
		boolean trouve1 = false;
		boolean trouve2 = false;
		String message = "";
		if (ordinateurDefenseur) {
			jeu.setCodeATrouverParLeJoueur(Code.genererNewCode(etendue, taille));
		}

		// Boucle de recherche de la solution
		for (int i = 0; i < nombreEssaiMax && (!trouve1 && !trouve2); i++) {
			if (ordinateurDefenseur) {
				trouve1 = coupAttaque(jeu, typeChoixJeu, etendue, taille);
			}
			if (ordinateurAttaquant) {
				trouve2 = coupDefense(jeu, typeChoixJeu, etendue, taille);
			}
		}
		if (ordinateurAttaquant) {
			message += ("Le défenseur a " + ((trouve2) ? "gagné" : "perdu") + "\n");
		}
		if (ordinateurDefenseur) {
			message += ("L'attaquant a " + ((trouve1) ? "gagné" : "perdu"));
		}
		return message;

	}

	/**
	 * Méthode utilisée pour la défense du code
	 * 
	 * @param jeu
	 * @param typeChoixJeu
	 * @param etendue
	 * @param taille
	 * @return
	 */
	public static boolean coupDefense(Jeu jeu, int typeChoixJeu, int etendue, int taille) {
		Code code1 = jeu.getCodeATrouverParLeJoueur();
		// Si en mode développeur on triche
		// TODO ajouter un paramètre debug dans le fichier de configuration
		if (debug) {
			LOGGER.info("Voici le code à deviner");
			LOGGER.info(code1);
		}
		LOGGER.info("Entrer un nouveau code?");
		jeu.enterCode();
		String resultat = jeu.comparerCode();
		String res = jeu.getResultatPourLeJoueur();
		LOGGER.info("Le résultat est : " + res);
		return jeu.isGagne(resultat);
	}

	/**
	 * Méthode utilisée pour l'attaque du code
	 * 
	 * @param jeu
	 * @param typeChoixJeu
	 * @param etendue
	 * @param taille
	 * @return
	 */
	public static boolean coupAttaque(Jeu jeu, int typeChoixJeu, int etendue, int taille) {
		LOGGER.info("Le code proposé par l'ordinateur : ");
		// System.out.println(jeu.chercherSolution());
		Code code2 = jeu.chercherSolution();
		// LOGGER.info(jeu.chercherSolution());
		LOGGER.info(code2);
		LOGGER.info("Quel est le resultat pour cette proposition ?");
		String resultat = jeu.demanderAnalyse();
		jeu.analyserResultat(resultat);
		return jeu.isGagne(resultat);
	}

	/**
	 * Méthode permettant de lire un fichier de configuration pour chacun des jeux
	 * et de conserver afin de jouer sur un des deux jeux
	 * 
	 * @return
	 */

	private static Properties lireConfiguration() {
		Properties prop = new Properties();

		try (FileInputStream input = new FileInputStream("config.properties")) {
			// load a properties file
			prop.load(input);
			// Vérification de la validité des données
			Integer.parseInt(prop.getProperty("etendue"));
			Integer.parseInt(prop.getProperty("taille"));
			Integer.parseInt(prop.getProperty("typeChoixJeu"));
			Integer.parseInt(prop.getProperty("attaqueDefenseChoix"));
			Integer.parseInt(prop.getProperty("nombreEssaiMax"));

		} catch (IOException ex) {
			LOGGER.error("Fichier de configuration introuvable. Il faut le recréer.");
			prop = creerConfiguration();
		} catch (NumberFormatException ex) {
			LOGGER.error("Le fichier est corrompu. Il faut le recréer.");
			prop = creerConfiguration();
		}

		return prop;
	}

	/**
	 * Méthode permettant de créer un fichier de configuration pour chacun des jeux
	 * si le fichier de configuration est corrompue si on veut saisir des nouveaux
	 * paramètres
	 * 
	 * @return
	 */
	private static Properties creerConfiguration() {
		Properties prop = new Properties();
		String comments = " ";

		try (OutputStream writer = new FileOutputStream("config.properties")) {
			// Demander les 4 paramètres à l'utilisateur
			// avec les méthodes de Helper
			etendue = Aide.demandeValeurEntier(1, 9, "Entrer l'étendue");
			taille = Aide.demandeValeurEntier(1, 6, "Entrer la taille");
			typeChoixJeu = Aide.demandeValeurEntier(1, 2,
					"Quel jeu voulez vous jouer?\n1: Mastermind , 2: PlusouMoins");
			attaqueDefenseChoix = Aide.demandeValeurEntier(1, 3,
					"Ordinateur attaquant (1) ou défenseur (2) ou Mixte (3) ?");
			nombreEssaiMax = Aide.demandeValeurEntier(1, 10, "Entrer le nombre d'essais max");

			prop.setProperty("etendue", "" + etendue);
			prop.setProperty("taille", "" + taille);
			prop.setProperty("typeChoixJeu", "" + typeChoixJeu);
			prop.setProperty("attaqueDefenseChoix", "" + attaqueDefenseChoix);
			prop.setProperty("nombreEssaiMax", "" + nombreEssaiMax);

			prop.store(writer, comments);

		} catch (IOException io) {
			io.printStackTrace();
		}

		return prop;
	}

}