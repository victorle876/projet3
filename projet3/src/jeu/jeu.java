package jeu;

import java.util.Scanner;

public class Jeu {
	protected Code proposition ;
	protected String resultat;
	protected Code CodeaTrouver;
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



	public Code getCodeaTrouver() {
		return CodeaTrouver;
	}



	public void setCodeaTrouver(Code codeaTrouver) {
		CodeaTrouver = codeaTrouver;
	}



	public Code getCode() {
		return Code;
	}



	public void setCode(Code code) {
		this.Code = Code;
	}



public abstract Code ComparerCode();
	

}
