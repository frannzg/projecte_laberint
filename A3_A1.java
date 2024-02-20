import java.util.Scanner;

public class A3_A1 {

	public static void main(String[] args) {
		Scanner teclat = new Scanner(System.in);

		// Escriu un programa que demani 2 números i digui si els dos són parells, o un
		// o els dos són senars.

		// Demanem el 1r numero:

		System.out.println("Introdeix el primer numero: ");
		int num1 = teclat.nextInt();

		// Demanem el 2n numero:

		System.out.println("Introdueix el segon numero: ");
		int num2 = teclat.nextInt();

		// Digui si:
		// + Els dos són parells
		// + 0 un és senar
		// + 0 els dos són senars
		// PARELL -> x % 2 == 0

		if (((num1 % 2) == 0) && ((num2 % 2) == 0)) {      // Els dos són parells
			System.out.println("Els dos numeros son parells.");

		} else if ((num1 % 2 != 0) && (num2 % 2 != 0)) {
			System.out.println("Els dos numeros son senars"); // Els dos són senars

		} else {
			System.out.println("Un es senar i l'altre parell");
		}

		teclat.close();

	}

}
