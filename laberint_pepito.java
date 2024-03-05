import java.util.IntSummaryStatistics;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class laberint_pepito {

	public static int x = 0;
	public static int y = 0;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		Scanner teclat = new Scanner(System.in);
		/*
		 * File fitxer = new File("C:\\Users\\Albert\\Desktop\\M3\\Laberint.txt");
		 * PrintWriter fitxerSortida = new PrintWriter(fitxer);
		 */
		// CERRAR fitxerSortida!!!!

		// LABERINTOS
		String laberint1[][] = {
				{ "M ", "M", " ", " ", " " },
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
		int arrayMoviments[] = new int[0]; // ARRAYS DE RESULTADOS
		boolean arrayArribat[];

		boolean sortirJoc = false;
		int numPartida = 0;
		int quantitatPartidesMax = 10; //POR PREGUNTAR AL PROFE SI ES PREGUNTANDO AL USUARIO
		// CONTADORES PARA PONER EN CADA HUECO DE LOS ARRAYS DE ARRIBA

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

				if (numPartida <= quantitatPartidesMax) {

					boolean sortirPartida = false;
					System.out.println("Quin nivell de dificultat vols anar?(1,2,3)");
					int nivell = teclat.nextInt();
					teclat.nextLine();
					arrayNivells = new int[numPartida+1]; //ESTA MAL, esta por cambiar
					arrayMoviments = new int[numPartida+1];
					// arrayArribat;

					// POR PONER MODULARMENTE
					String laberint[][] = new String[1][1];

					if (nivell == 1 || nivell == 2 || nivell == 3) { //TODO ESTA SECCION ESTA PENDIENTE
																	// DE QUE SE CARGUE CORRECTAMENTE EL LABERINTO DE FORMA MODULAR 

						// ATENCION!!!!!!!!!!! -> si repites otra vez el mismo nivel "peta" al no cargar el laberintoX al laberinto global "laberint"

						if (nivell == 1) {
							//carregarLaberint(laberint, laberint1); //CARGAR LABERINTO MONTADO AL LABERINTO "GENERAL"
							partida(laberint1, numPartida, arrayNivells, arrayMoviments, teclat); 
							arrayNivells[numPartida] = 1; //*SETEO DE NUMERO DE PARTIDA EN EL ARRAY RESULTADOS ----PROVISIONAL */

						} else if (nivell == 2) {
							arrayNivells[numPartida] = 2; //*SETEO DE NUMERO DE PARTIDA EN EL ARRAY RESULTADOS ----PROVISIONAL *//
							//carregarLaberint(laberint, laberint2); //CARGAR LABERINTO MONTADO AL LABERINTO "GENERAL"
							partida(laberint2, numPartida, arrayNivells, arrayMoviments, teclat);

						} else {
							arrayNivells[numPartida] = 3; //*SETEO DE NUMERO DE PARTIDA EN EL ARRAY RESULTADOS ----PROVISIONAL */

							//carregarLaberint(laberint, laberint3); //CARGAR LABERINTO MONTADO AL LABERINTO "GENERAL"
							partida(laberint3, numPartida, arrayNivells, arrayMoviments, teclat); 
						}

						//partida(laberint, arrayNivells, arrayMoviments, teclat); --> EJECUCION DE LA PARTIDA CON EL LABERINTO "GENERAL" CARGADO
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
				resultats(arrayNivells,arrayMoviments);

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

	public static void mostrarMatriu(String matriu[][]) {

		for (int i = 0; i < matriu.length; i++) {
			for (int j = 0; j < matriu[i].length; j++) {

				System.out.print(matriu[i][j] + " ");

			}
			System.out.println();
		}
	}

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

		}	else if (moviment.equalsIgnoreCase("q")) {

				System.out.println("HAS SORTIT");

		} else {
			System.out.println("Tecla incorrecte!");
		}
		return arribat;
	}

	public static boolean mouresEsquerra(String[][] matriu) {
		boolean arribat=false;
		if (y > 0 && !matriu[x][y - 1].equals("M")) {
			matriu[x][y] = " ";
			if(matriu[x][y-1].equalsIgnoreCase("S")){

				arribat = true;

				System.out.println("ARRIBAAAATTTTT");
			}
			y--;
			matriu[x][y] = "P";
		} else {
			System.out.println("Moviment no vàlid!");
			
		}
		return arribat;
	}

	public static boolean mouresAmunt(String[][] matriu) {
		boolean arribat=false;

		if (x > 0 && !matriu[x - 1][y].equals("M")) {
			matriu[x][y] = " ";
			if(matriu[x-1][y].equalsIgnoreCase("S")){

				arribat = true;
				System.out.println("ARRIBAAAATTTTT");

			}
			x--;
			matriu[x][y] = "P";

		} else {
			System.out.println("Moviment no vàlid!");
		}
		return arribat;
	}

	public static boolean mouresAbaix(String[][] matriu) {
		boolean arribat=false;
		if (x < matriu[x].length - 1 && !matriu[x + 1][y].equals("M")) {
			matriu[x][y] = " ";
			if(matriu[x+1][y].equalsIgnoreCase("S")){

				arribat = true;
				System.out.println("ARRIBAAAATTTTT");

			}
			x++;
			matriu[x][y] = "P";
		} else {
			System.out.println("Moviment no vàlid!");
		}
		return arribat;
	}

	public static boolean mouresDreta(String[][] matriu) {
		boolean arribat=false;
		if (y < matriu.length - 1 && !matriu[x][y + 1].equals("M")) {
			matriu[x][y] = " ";
			if(matriu[x][y+1].equalsIgnoreCase("S")){

				arribat = true;
				System.out.println("ARRIBAAAATTTTT");

			}
			y++;
			matriu[x][y] = "P";


		} else {
			if(!matriu[x][y - 1].equals("M")){
				System.out.println("Moviment no vàlid!");
				}
			System.out.println("aaa");
		}
		return arribat;
	}
		
	public static void resultats(int partides[], int moviments[]) { //A LA ESPERA PARA MODIFICAR LOS ARRAYS DE PUNTUACION Y PONER ARRAY BOOLEANS + ", ha sortit: " + sortit[i]

		for (int i = 0; i < partides.length; i++) {
			System.out.println("Nivell partida " + partides[i] + ", moviments: " + moviments[i]);
		}

	}

	public static void partida(String matriu[][], int numPartida, int nivells[], int moviments[], Scanner teclat) {
		
	/* 	x=0;
		y=0; //SETEO INICIO PARTIDA AL 0 0, porque al iniciar el siguiente laberinto el pepito se posiciona en la ultima posicion de la partida anterior --> PROVISIONAL
*/
		boolean sortirPartida = false;
		int movimentsPartida = 0;
		boolean arribat = false;

/* 			COMPROBACIÓN SI SE HA CARGADO LA MATRIZ DE FORMA MODULAR 

		for (int i = 0; i < matriu.length; i++) { 
			for (int j = 0; j < matriu[i].length; j++) {

				matriu[i][j] = matriu[i][j];

				System.out.print(matriu[i][j] + " ");
			}
			System.out.println();

		}
		*/
		trobarPosicioInicial(matriu, x, y);
		mostrarMatriu(matriu);
		System.out.println("Quina acció vols fer? w = pujar, s = baixar, a = esquerra, d = dreta, q = sortir ");
		String moviment = teclat.nextLine();

		while (!sortirPartida) {
		
	
				if (moviment.equalsIgnoreCase("q") || arribat == true) {

					System.out.println("LLEGADO");
					if (arribat == true) { // PONER SETEO EN "TRUE" ARRAY WINS arrayArribat 

					}

					//System.out.println("Has acabat el nivell"); --> IGNORA DE MOMENTO

					sortirPartida = true;

				} else {

					mostrarMatriu(matriu);
					System.out.println("Quina acció vols fer? w = pujar, s = baixar, a = esquerra, d = dreta, q = sortir ");
					moviment = teclat.nextLine();

					movimentsPartida++;
					System.out.println("CAMINANDO");
					arribat = modificarPosicio(matriu, moviment);

				}
	
		} 

		moviments[numPartida] = movimentsPartida; //SETEAR NUM MOVIMIENTOS EN ARRAY MOVIMIENTOS

		//PEGAR Y RESETEAR MATRIZ 


	}

	public static void carregarLaberint(String matriu1[][], String matriu2[][]) {

		int filas = matriu2.length;
		int columnas = matriu2[0].length;

		matriu1 = new String[filas][columnas];

		for (int i = 0; i < matriu2.length; i++) {
			for (int j = 0; j < matriu2[i].length; j++) {

				matriu1[i][j] = matriu2[i][j];

				System.out.print(matriu1[i][j] + " ");
			}
			System.out.println();

		}
	}

	public static int quantitatPartidesPerJugar(Scanner teclat){



		System.out.println("Quantes partides vols jugar?");//POR PREGUNTAR AL PROFE SI ES PREGUNTANDO AL USUARIO
		int quantitatPartides = teclat.nextInt();
		teclat.nextLine();

		return quantitatPartides;
	}

	

	public static void trobarPosicioInicial(String matriu[][], int x, int y) {

		if (matriu[x][y].equalsIgnoreCase(" ")) {

			matriu[x][y] = "P";

		} else if (matriu[x + 1][y].equalsIgnoreCase(" ")) {

			matriu[x + 1][y] = " ";
			x++;
		} else if (matriu[x][y + 1].equalsIgnoreCase(" ")) {

			matriu[x][y + 1] = "P";
			y++;

		} else if (matriu[x + 1][y + 1].equalsIgnoreCase(" ")) {

			matriu[x + 1][y + 1] = "P";
			x++;
			y++;

		} else {

			System.err.println("Entrada invalida");

		}

	}

}