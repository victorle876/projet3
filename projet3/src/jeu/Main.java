package jeu;
import java.util.Scanner;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Code code = new Code();
		Code CodeaTrouver = new Code() ;
		int NombreEssaiMax;
		int etendue;
		boolean trouve = false;
		int choice;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Quel jue voulez vous jouer?");
		System.out.println("1: Mastermind , 2: PlusouMoins");
		switch (choice) {
        case 1:  Mastermind();
                 break;
        case 2:  PlusouMoins();
                 break;

		
		}
		
}
