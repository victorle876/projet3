package jeu;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;


public class Code extends ArrayList<Integer>()
 {
	ArrayList<Integer> Code = new ArrayList<Integer>();
	CodeATrouver Code = new Code();
	
	public static Code genererNewCode(int etendue)
	{
		Random r = new Random();
		for (int i = 0; i < Code.size(); i++) {
		Code.add(r.nextInt(etendue));
		}
		
		CodeaTrouver = Code;
		
		
	}	
	
	
	
}


