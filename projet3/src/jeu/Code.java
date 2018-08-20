package jeu;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Code extends ArrayList<Integer> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7028121193663088447L;
	int taille;
	int etendue;

	public int getEtendue() {
		return etendue;
	}

//	public void setEtendue() {
//		this.etendue = etendue;
//	}

	public static Code genererNewCode(int etendue, int taille) {
		Random r = new Random();
		Code code = new Code();

		for (int i = 0; i < taille; i++) {
			code.add(r.nextInt(etendue));
		}
		
		return code;

	}
	
	
}
