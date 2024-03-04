import java.util.IntSummaryStatistics;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class laberint_pepito {


	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		Scanner teclat = new Scanner(System.in);
		File fitxer = new File("C:\\Users\\Albert\\Desktop\\M3\\Laberint.txt");
		PrintWriter fitxerSortida = new PrintWriter(fitxer);

		//CERRAR fitxerSortida!!!!

		String laberint1[][] = { { "M", "M", " ", " ", " " },			//LABERINTOS
				{ " ", "M", " ", "M", " " },	
				{ " ", " ", " ", "M", " " },
				{ " ", "M", " ", "M", "S" },
				{ "M", "M", " ", "M", "M" } };

		String laberint2[][] = { { "M", " ", "M", "M", " ", "M", "S" },
				{ "M", " ", "M", " ", " ", "M", " " },
				{ " ", " ", "M", " ", "M", "M", " " },
				{ " ", "M", "M", " ", " ", " ", " " },
				{ " ", " ", " ", " ", "M", "M", "M" } };

		String laberint3[][] = { { " ", "M", "M", "M", " ", " ", " ", "M" },
				{ " ", " ", "M", " ", " ", "M", " ", "M" },
				{ "M", " ", "M", " ", "M", "M", " ", "S" },
				{ "M", " ", "M", " ", " ", "M", "M", "M" },
				{ " ", " ", " ", " ", " ", " ", " ", "M" } };

		int arrayNivells[] = new int[0]; 
		int arrayMoviments[]= new int[0];						//ARRAYS DE RESULTADOS
		boolean arrayArribat[];

		boolean sortirJoc = false;
		int moviments = 0;
		int numPartida = 10;		
					//CONTADORES PARA PONER EN CADA HUECO DE LOS ARRAYS DE ARRIBA

		System.out.println("Benvingut al laberint de pepito");

		do {
			// MENU PRINCIPAL
			System.out.println("1.Jugar partida");
			System.out.println("2.Resultat partides");
			System.out.println("3.Sortir");
			int resposta = teclat.nextInt();
			teclat.nextLine();

			// CAS DE JUGAR PARTIDA
			if (resposta == 1 ) {

				if(numPartida <=10){

				String laberint[][] = new String[1][1];
				boolean sortirPartida = false;
				System.out.println("Quin nivell de dificultat vols anar?(1,2,3)");
				int nivell = teclat.nextInt();
				teclat.nextLine();
				arrayNivells = new int[numPartida];
				arrayMoviments = new int[numPartida];
				//arrayArribat;

				//                                          POR PONER MODULARMENTE
				if (nivell == 1 || nivell == 2 || nivell == 3) {
						
					if (nivell == 1) {
						carregarLaberint(laberint, laberint1);
					}
					else if (nivell == 2) {
						carregarLaberint(laberint, laberint2);
					} else {
						carregarLaberint(laberint, laberint3);
					}

				 partida(laberint, arrayNivells, arrayMoviments, teclat);

				} else {
							System.out.println("Numero incorrecte!!");
				}

			} else {

				System.out.println("Partides màximes complertes!!");
			}
				// Cas de MIRAR la llista de partides
			} else if (resposta == 2) {

				System.out.println("RESULTATS");
				// resultats(arrayNivells,arrayMoviments,arrayArribat);


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
	public static void modificarPosicio(String matriu[][], String moviment) {

		int x=0;
		int y=0;

		if (moviment.equalsIgnoreCase("W")) {
			y--;
			mouresAmunt(matriu,x,y);
		} else if (moviment.equalsIgnoreCase("A")) {
			x--;
			mouresEsquerra(matriu, x, y);
		} else if (moviment.equalsIgnoreCase("S")) {
			y++;
			mouresAbaix(matriu,x,y);
		} else if (moviment.equalsIgnoreCase("D")) {
			x++;
			mouresDreta(matriu,x,y);

		} else {
			System.out.println("Tecla incorrecte!");
		}
	}

	public static void mouresAmunt(String matriu[][], int x,int y) {

		if(x<0 && x>matriu.length || y<0 && y>matriu[0].length){

			System.out.println("Et surts del laberint!");

		} else {

			for(int i=0 ;i<matriu.length;i++){
				for(int j=0;j<matriu[i].length;j++){
	
					if(i == x && j == y){
						
						if(matriu[x][y-1].equalsIgnoreCase(" ") || matriu[x][y-1].equalsIgnoreCase("S")){
	
							matriu[x][y-1] = "P";
							matriu[x][y] = " ";

							if(matriu[x][y-1].equalsIgnoreCase("S")){ //si ha arribat


							}

						} else {
	
							System.out.println("NO ES POT ANAR");
	
						}
	
					}
				}
			}

		}

	}

	public static void mouresAbaix(String matriu[][], int x,int y) {

		if(x<0 && x>matriu.length || y<0 && y>matriu[0].length){

			System.out.println("Et surts del laberint!");

		} else {

			for(int i=0 ;i<matriu.length;i++){
				for(int j=0;j<matriu[i].length;j++){
	
					if(i == x && j == y){
						
						if(matriu[x][y+1].equalsIgnoreCase(" ")){
	
							matriu[x][y+1] = "P";
							matriu[x][y] = " ";
	
						} else {
	
							System.out.println("NO ES POT ANAR");
	
						}
	
					}
				}
			}

		}

	}

	public static void mouresDreta(String matriu[][], int x,int y) {

		if(x<0 && x>matriu.length || y<0 && y>matriu[0].length){

			System.out.println("Et surts del laberint!");

		} else {

			for(int i=0 ;i<matriu.length;i++){
				for(int j=0;j<matriu[i].length;j++){
	
					if(i == x && j == y){
						
						if(matriu[x][y+1].equalsIgnoreCase(" ")){
	
							matriu[x][y+1] = "P";
							matriu[x][y] = " ";
	
						} else {
	
							System.out.println("NO ES POT ANAR");
	
						}
	
					}
				}
			}

		}

	}

	public static void mouresEsquerra(String matriu[][], int x,int y) {

		if(x<0 && x>matriu.length || y<0 && y>matriu[0].length){

			System.out.println("Et surts del laberint!");

		} else {

			for(int i=0 ;i<matriu.length;i++){
				for(int j=0;j<matriu[i].length;j++){
	
					if(i == x && j == y){
						
						if(matriu[x][y+1].equalsIgnoreCase(" ")){
	
							matriu[x][y+1] = "P";
							matriu[x][y] = " ";
	
						} else {
	
							System.out.println("NO ES POT ANAR");
	
						}
	
					}
				}
			}

		}

	}

	public static void resultats(int partides[], int moviments[], boolean sortit[]) {

		for (int i = 0; i < partides.length; i++) {
			System.out.println("partides: " + partides[i] + ", moviments: " + moviments[i] + ", ha sortit: " + sortit[i]);
		}

	}

	public static void partida(String matriu[][], int nivells[], int moviments[], Scanner teclat){

		int numPartida=0;
		boolean sortirPartida=false;
		int movimentsPartida=0;

		trobarPosicioInicial(matriu);

		// BUCLE PRIMER NIVELL
		while (!sortirPartida) {

			boolean arribat = false;
			mostrarMatriu(matriu);
			System.out.println("Quina acció vols fer? w = pujar, s = baixar, a = esquerra, d = dreta, q = sortir ");
			String moviment = teclat.nextLine();
			if (moviment.equalsIgnoreCase("q") || arribat == true) {

				System.out.println("aaaaa");
				if (arribat == true) { // PONER ARRAY WINS arrayArribat

				}
				sortirPartida = true;

		
			} else {

				movimentsPartida++;
				System.out.println("bbbbbb");
				modificarPosicio(matriu, moviment);

			}
		}


	//	arr

	}

	public static void carregarLaberint(String matriu1[][], String matriu2[][]){

		int filas = matriu2.length;
        int columnas = matriu2[0].length;

		matriu1 = new String[filas][columnas];
		
		for (int i = 0; i < matriu2.length; i++) {
			for (int j = 0; j < matriu2[i].length; j++) {

				matriu1[i][j] = matriu2[i][j];

				System.out.print(matriu1[i][j]+ " ");
			}
			System.out.println();

		}
	}


	public static void trobarPosicioInicial(String matriu[][]){

		int x = 0;
		int y = 0;
	
		if(matriu[x][y].equalsIgnoreCase(" ")){

			matriu[x][y] = "P";

		} else if (matriu[x+1][y].equalsIgnoreCase(" ")){

			matriu[x+1][y] = "P";

		} else if (matriu[x][y+1].equalsIgnoreCase(" ")){

			matriu[x][y+1] = "P";

		} else if(matriu[x+1][y+1].equalsIgnoreCase(" ")){

			matriu[x+1][y+1]= "P";

		} else {

			System.err.println("Entrada invalida");

		}
	
	}

	/*						if (moviment.equalsIgnoreCase("W")) {

							} else if (moviment.equalsIgnoreCase("A")) {

							} else if (moviment.equalsIgnoreCase("S")) {

							} else if (moviment.equalsIgnoreCase("D")) {

							} else {

								System.out.println("Tecla incorrecte!");

							} */
	

}