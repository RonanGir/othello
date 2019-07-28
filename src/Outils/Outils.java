package Outils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Outils {
	private static Scanner s = new Scanner(System.in);

	public static int saisie(String message, int min, int max) {
		System.out.printf("%s ", message);
		int val = 0;
		boolean ok;
		do {
			try {
				val = Outils.s.nextInt();
				ok = val >= min && val <= max;
			} catch (InputMismatchException e) {
				ok = false;
			} finally {
				Outils.s.nextLine();
			}
			if (!ok)
				System.err.printf("La valeur doit être un entier compris entre %d et %d%nRessaisissez... ", min, max);
		} while (!ok);
		return val;
	}
	
	
	public static String saisie(String message) {
		System.out.println(message);
		return Outils.s.nextLine();
		}
}