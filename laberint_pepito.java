import java.util.IntSummaryStatistics;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class laberint_pepito {

	public static int x = 0;
	public static int y = 0;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner teclat = new Scanner(System.in);

		String laberint1[][] = { // Laberints
				{ "M", "M", " ", " ", " " },
				{ " ", "M", " ", "M", " " },
				{ " ", " ", " ", "M", " " },
				{ " ", "M", " ", "M", "S" },
				{ "M", "M", " ", "M", "M" } };

		String laberint2[][] = {
				{ "M", " ", "M", "M", " ", "M", "S" },
				{ "M", " ", "M", " ", " ", "M", " " },
				{ " ", " ", "M", " ", "M", "M", " " },
				{ " ", "M", "M", " ", " ", " ", " " },
				{ " ", " ", " ", " ", "M", "M", "M" } };

		String laberint3[][] = {
				{ " ", "M", "M", "M", " ", " ", " ", "M" },
				{ " ", " ", "M", " ", " ", "M", " ", "M" },
				{ "M", " ", "M", " ", "M", "M", " ", "S" },
				{ "M", " ", "M", " ", " ", "M", "M", "M" },
				{ " ", " ", " ", " ", " ", " ", " ", "M" } };

		int arrayNivells[] = new int[0];
		int arrayMoviments[] = new int[0]; // Arrays de resultats
		boolean arrayArribat[] = new boolean[0];

		boolean sortirJoc = false;
		boolean primeraVegada = true;
		int numPartida = 0;
		int quantitatPartidesMax = 0;

		System.out.println("Benvingut al laberint de pepito");

		do {
			// MENU PRINCIPAL
			System.out.println("1.Jugar partida");
			System.out.println("2.Resultat partides");
			System.out.println("3.Sortir");
			int resposta = teclat.nextInt();
			teclat.nextLine();

			// CAS DE JUGAR PARTIDA
			if (resposta == 1) {

				if (primeraVegada) { // Delimitació de partides màximes

					primeraVegada = false;

					quantitatPartidesMax = quantitatPartidesPerJugar(teclat);
					arrayNivells = new int[quantitatPartidesMax];
					arrayMoviments = new int[quantitatPartidesMax];
					arrayArribat = new boolean[quantitatPartidesMax];

				}

				if (numPartida < quantitatPartidesMax) { // Mentres no superi les partides màximes

					System.out
							.println("Quin nivell de dificultat vols anar?(1,2,3) o carregar laberint d'un fitxer (0)");
					int nivell = teclat.nextInt();
					teclat.nextLine();
					String laberint[][] = new String[0][0];

					if (nivell == 1 || nivell == 2 || nivell == 3 || nivell == 0) { // Selecció del nivell per
																					// carregar-lo al laberint "genèric"

						if (nivell == 1) {
							arrayNivells[numPartida] = 1;

							laberint = carregarLaberint(laberint, laberint1);

						} else if (nivell == 2) {
							arrayNivells[numPartida] = 2;

							laberint = carregarLaberint(laberint, laberint2);

						} else if (nivell == 3) {
							arrayNivells[numPartida] = 3;

							laberint = carregarLaberint(laberint, laberint3);

						} else { // En cas de carregar laberint des de fitxer.txt
							arrayNivells[numPartida] = 0;

							System.out.println("Digues el nom del fitxer que vols carregar:");
							String nomFitxer = teclat.nextLine();

							laberint = carregarLaberintFitxer(laberint, nomFitxer);

						}

						partida(laberint, numPartida, arrayNivells, arrayMoviments, arrayArribat, teclat); // Execució
																											// de la
																											// partida
						numPartida++;

					} else {
						System.out.println("Numero incorrecte!!");
					}

				} else {

					System.out.println("Partides màximes complertes!!");
				}
				// Cas de MIRAR la llista de partides
			} else if (resposta == 2) {

				System.out.println("RESULTATS");
				resultats(arrayNivells, arrayMoviments, arrayArribat);

				// SORTIDA DEL JOC
			} else if (resposta == 3) {

				sortirJoc = true;

				// NUMERO INCORRECTE
			} else {

				System.out.println("Reposta incorrecte!");
			}

		} while (!sortirJoc);

		System.out.println("Gràcies per jugar amb pepito el perdut!");

	}

	/**
	 * Mostra el laberint per pantalla
	 * 
	 * @param matriu
	 */
	public static void mostrarMatriu(String matriu[][]) {

		for (int i = 0; i < matriu.length; i++) {
			for (int j = 0; j < matriu[i].length; j++) {

				System.out.print(matriu[i][j] + " ");

			}
			System.out.println();
		}
	}

	/**
	 * Modifica la posició de pepito per cada volta del bucle del joc
	 * 
	 * @param matriu
	 * @param moviment
	 * @return si ha arribat al destí
	 */
	public static boolean modificarPosicio(String matriu[][], String moviment) {
		boolean arribat = false;
		if (moviment.equalsIgnoreCase("W")) {

			arribat = mouresAmunt(matriu);
		} else if (moviment.equalsIgnoreCase("A")) {

			arribat = mouresEsquerra(matriu);
		} else if (moviment.equalsIgnoreCase("S")) {

			arribat = mouresAbaix(matriu);
		} else if (moviment.equalsIgnoreCase("D")) {

			arribat = mouresDreta(matriu);

		} else if (moviment.equalsIgnoreCase("q")) {

			System.out.println("Has sortit");

		} else {
			System.out.println("Tecla incorrecte!");
		}
		return arribat;
	}

	/**
	 * Moviment del pepito
	 * 
	 * @param matriu
	 * @return si ha arribat al destí
	 */
	public static boolean mouresEsquerra(String[][] matriu) {

		boolean arribat = false;

		if (y > 0 && !matriu[x][y - 1].equals("M")) {
			matriu[x][y] = " ";
			if (matriu[x][y - 1].equalsIgnoreCase("S")) {
				matriu[x][y - 1] = "P";
				arribat = true;
			} else {
				y--;
				matriu[x][y] = "P";

			}

		} else {
			System.out.println("Moviment no vàlid!");

		}
		return arribat;
	}

	/**
	 * Moviment del pepito
	 * 
	 * @param matriu
	 * @return si ha arribat al destí
	 */
	public static boolean mouresAmunt(String[][] matriu) {
		boolean arribat = false;

		if (x > 0 && !matriu[x - 1][y].equals("M")) {
			matriu[x][y] = " ";
			if (matriu[x - 1][y].equalsIgnoreCase("S")) {
				matriu[x - 1][y] = "P";
				arribat = true;
			} else {

				x--;
				matriu[x][y] = "P";
			}

		} else {
			System.out.println("Moviment no vàlid!");
		}
		return arribat;
	}

	/**
	 * Moviment del pepito
	 * 
	 * @param matriu
	 * @return si ha arribat al destí
	 */
	public static boolean mouresAbaix(String[][] matriu) {
		boolean arribat = false;
		if (x < matriu.length - 1 && !matriu[x + 1][y].equals("M")) { // matriu[x].length - 1
			matriu[x][y] = " ";
			if (matriu[x + 1][y].equalsIgnoreCase("S")) {
				matriu[x + 1][y] = "P";
				arribat = true;
			} else {
				x++;
				matriu[x][y] = "P";
			}
		} else {
			System.out.println("Moviment no vàlid!");
		}
		return arribat;
	}

	/**
	 * Moviment del pepito
	 * 
	 * @param matriu
	 * @return si ha arribat al destí
	 */
	public static boolean mouresDreta(String[][] matriu) {
		boolean arribat = false;
		if (y < matriu[0].length - 1 && !matriu[x][y + 1].equals("M")) {
			matriu[x][y] = " ";
			if (matriu[x][y + 1].equalsIgnoreCase("S")) {
				matriu[x][y + 1] = "P";
				arribat = true;
			} else {
				y++;
				matriu[x][y] = "P";
			}
		} else {

			System.out.println("Moviment no vàlid!");

		}
		return arribat;
	}

	/**
	 * Mostra els resultats de les partides jugades
	 * 
	 * @param partides
	 * @param moviments
	 * @param arribat
	 */
	public static void resultats(int partides[], int moviments[], boolean arribat[]) {

		try {

			File fitxer = new File("C:\\Users\\Albert\\Desktop\\M3\\Resultats.txt");
			PrintWriter pwFitxer = new PrintWriter(fitxer);

				pwFitxer.println("Resultats de les partides jugades:");

			for (int i = 0; i < partides.length; i++) {
				System.out.println("Nivell de partida " + partides[i] + ", moviments: " + moviments[i] + ", arribat: "
						+ arribat[i]);

				pwFitxer.println("Nivell de partida " + partides[i] + ", moviments: " + moviments[i] + ", arribat: "
						+ arribat[i]);

			}

			pwFitxer.close();

		} catch (Exception e) {

			System.out.println(e);

		}
	}

	/**
	 * Partida principal amb el laberint carregat
	 * 
	 * @param matriu
	 * @param numPartida
	 * @param arrayNivells
	 * @param arrayMoviments
	 * @param arrayArribat
	 * @param teclat
	 */
	public static void partida(String matriu[][], int numPartida, int arrayNivells[], int arrayMoviments[],
			boolean arrayArribat[], Scanner teclat) {

		x = 0;
		y = 0;

		boolean sortirPartida = false;
		int movimentsPartida = 0;
		boolean arribat = false;

		trobarPosicioInicial(matriu, x, y);

		do {

			mostrarMatriu(matriu);

			System.out.println("Quina acció vols fer? w = pujar, s = baixar, a = esquerra, d = dreta, q = sortir ");
			String moviment = teclat.nextLine();

			if (!moviment.equalsIgnoreCase("q")) {

				movimentsPartida++;
				System.out.println("Caminant");
				arribat = modificarPosicio(matriu, moviment);

			}

			if (moviment.equalsIgnoreCase("q") || arribat == true) {
				if (arribat == true) { //
					System.out.println("Has arribat");
				}
				sortirPartida = true;
			}

		} while (!sortirPartida);

		arrayMoviments[numPartida] = movimentsPartida; // Seteig moviments en els resultats
		arrayArribat[numPartida] = arribat; // Seteig si ha arribat o no
		guardaNivell(matriu, numPartida, arrayNivells, arrayMoviments, arrayArribat); // Desa la matriu al fitxer

	}

	/**
	 * Carrega les dades del laberint desat al codi a un laberint "generic" per
	 * jugar la partida
	 * 
	 * @param matriu1
	 * @param matriu2
	 */
	public static String[][] carregarLaberint(String matriu1[][], String matriu2[][]) {

		int filas = matriu2.length;
		int columnas = matriu2[0].length;

		matriu1 = new String[filas][columnas];

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {

				matriu1[i][j] = matriu2[i][j];
			}

		}
		return matriu1;
	}

	/**
	 * Carrega laberint des de un fitxer.txt
	 * 
	 * @param matriu
	 * @param nomFitxer
	 * @return
	 */
	public static String[][] carregarLaberintFitxer(String matriu[][], String nomFitxer) {

		int dimensioX = 0;
		int dimensioY = 0;

		try {

			File fitxer = new File("C:\\Users\\Albert\\Desktop\\M3\\" + nomFitxer);

			Scanner scFitxer = new Scanner(fitxer);

			if (scFitxer.hasNextInt()) {
				dimensioX = scFitxer.nextInt();
			}
			if (scFitxer.hasNextInt()) {
				dimensioY = scFitxer.nextInt();
				scFitxer.nextLine();
			}

			System.out.print(dimensioX);
			System.out.println(dimensioY);

			matriu = new String[dimensioX][dimensioY];

			while (scFitxer.hasNextLine()) {

				for (int i = 0; i < matriu.length; i++) {
					for (int j = 0; j < matriu[i].length; j++) {

						matriu[i][j] = scFitxer.next();
						System.out.println("Proba_matriu");

					}
				}
			}
			scFitxer.close();
			return matriu;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	/**
	 * Pregunta per la quantitat de partides màximes que es jugarán
	 * 
	 * @param teclat
	 * @return quantitat de partides màximes
	 */
	public static int quantitatPartidesPerJugar(Scanner teclat) {

		System.out.println("Quantes partides vols jugar?");
		int quantitatPartides = teclat.nextInt();
		teclat.nextLine();

		return quantitatPartides;
	}

	/**
	 * Guarda l'últim nivell jugat al fitxer.txt
	 * 
	 * @param matriu
	 * @param numPartida
	 * @param arrayNivells
	 * @param arrayMoviments
	 * @param arrayArribat
	 */
	public static void guardaNivell(String matriu[][], int numPartida, int arrayNivells[],
			int arrayMoviments[], boolean arrayArribat[]) {

		try {

			File fitxer = new File("C:\\Users\\Albert\\Desktop\\M3\\Laberint.txt");

			PrintWriter pwFitxer = new PrintWriter(fitxer);

			pwFitxer.print(matriu.length);
			pwFitxer.print(" ");

			pwFitxer.println(matriu[0].length);

			for (int i = 0; i < matriu.length; i++) {
				for (int j = 0; j < matriu[i].length; j++) {

					pwFitxer.print(matriu[i][j] + " ");

				}

				pwFitxer.println();

			}
			pwFitxer.println("Ha sortit?: " + arrayArribat[numPartida]);

			pwFitxer.close();

		} catch (Exception e) {

			System.out.println("NO HI HA ARXIU");
			System.out.println(e);

		}

	}

	/**
	 * Troba la posició inicial del pepito a on hi ha espai buit a prop de la
	 * posició 0,0
	 * 
	 * @param matriu
	 * @param x
	 * @param y
	 */
	public static void trobarPosicioInicial(String matriu[][], int x, int y) {


		if (matriu[x][y].equalsIgnoreCase(" ")) {

			matriu[x][y] = "P";

		} else if (matriu[x + 1][y].equalsIgnoreCase(" ")) {
			matriu[x + 1][y] = "P";
			x++;
		} else if (matriu[x][y + 1].equalsIgnoreCase(" ")) {

			matriu[x][y + 1] = "P";
			y++;

		} else if (matriu[x + 1][y + 1].equalsIgnoreCase(" ")) {

			matriu[x + 1][y + 1] = "P";
			x++;
			y++;

		} else {

			System.out.println("Entrada invàlida");

		}


	}

}