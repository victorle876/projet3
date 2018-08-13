package jeu;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public abstract class Jeu {
	protected Code proposition ;
	protected String resultat;
	protected Code codeATrouver;
	Code Code = new Code();
	
public Code getProposition() {
		return proposition;
	}



	public void setProposition(Code proposition) {
		this.proposition = proposition;
	}



	public String getResultat() {
		return resultat;
	}



	public void setResultat(String resultat) {
		this.resultat = resultat;
	}



	public Code getcodeATrouver() {
		return codeATrouver;
	}



	public void setcodeATrouver(Code codeATrouver) {
		codeATrouver = codeATrouver;
	}



public abstract String ComparerCode();
//public abstract String CreerCode();	

}
