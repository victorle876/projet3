package joueur;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Paramètres {
	
	private Integer nbrEssaisPlus, nbrEssaisMaster, longueurCodePlus, longueurCodeMaster, nbrCouleursMaster;
	private Boolean dev;
	private static final Logger logger = LogManager.getLogger();
	
	public Paramètres(Integer nbrEssaisPlus, Integer nbrEssaisMaster, Integer longueurCodeP, Integer longueurCodeMaster,
			Integer nbrCouleursMaster, Boolean dev) {
		this.nbrEssaisPlus = nbrEssaisPlus;
		this.nbrEssaisMaster = nbrEssaisMaster;
		this.longueurCodePlus = longueurCodePlus;
		this.longueurCodeMaster = longueurCodeMaster;
//		this.nbrCouleursMaster = nbrCouleursMaster;
		this.dev = dev;
	}
	
	public void setNbrEssaisPlus(int i) {
		this.nbrEssaisPlus = i;
	}

	/**
	 * @param i
	 *            Nombres d'essais pour le jeu mastermind
	 */
	public void setNbrEssaisMaster(int i) {
		this.nbrEssaisMaster = i;
	}

	/**
	 * @param i
	 *            longueur de la combinaison du jeu Plus ou Moins
	 */
	public void setlongueurCodeP(int i) {
		this.longueurCodeP = i;
	}

	/**
	 * @param i
	 *            longueur de la combinaison du mastermind
	 */
	public void setlongueurCodeMaster(int i) {
		this.longueurCodeMaster = i;
	}

	/**
	 * @param i
	 *            Nombre de couleurs utilisés par le mastermind
	 */
	public void setNbrCouleursMaster(int i) {
		this.nbrCouleursMaster = i;
	}

	/**
	 * @return mode développeur (pour afficher le résultat dès le début du jeu)
	 */
	public boolean getDev() {
		return this.dev;
	}

	/**
	 * @return Nombres d'essais pour le jeu Plus ou Moins
	 */
	public int getNbrEssaisPlus() {
		return this.nbrEssaisPlus;
	}


	public int getNbrEssaisMaster() {
		return this.nbrEssaisMaster;
	}


	public int getlongueurCodePlus() {
		return this.longueurCodePlus;
	}

	
	public int getlongueurCodeMaster() {
		return this.longueurCodeMaster;
	}


	public int getNbrCouleursMaster() {
		return this.nbrCouleursMaster;
	}


}
