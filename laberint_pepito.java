import java.util.Scanner;

public class laberint_pepito {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner teclat = new Scanner(System.in);

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

		int arrayNivells[]; 
		int arrayMoviments[];						//ARRAYS DE RESULTADOS
		boolean arrayArribat[];

		boolean sortirJoc = false;
		int moviments = 0;
		int numPartida = 0;							//CONTADORES PARA PONER EN CADA HUECO DE LOS ARRAYS DE ARRIBA

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

				boolean sortirPartida = false;

				System.out.println("Quin nivell de dificultat vols anar?(1,2,3)");
				int nivell = teclat.nextInt();
				teclat.nextLine();
				arrayNivells = new int[numPartida];
				arrayMoviments = new int[numPartida];
				//arrayArribat;

				if (nivell == 1) {

					numPartida++;

					trobarPosicioInicial(laberint1);

					// BUCLE PRIMER NIVELL
					while (!sortirPartida) {


						boolean arribat = false;
						mostrarMatriu(laberint1);
						System.out.println("Quina acció vols fer? w = pujar, s = baixar, a = esquerra, d = dreta, q = sortir ");
						String moviment = teclat.nextLine();
						if (moviment.equalsIgnoreCase("q") || arribat == true) {

							System.out.println("aaaaa");

							if (arribat == true) { // PONER ARRAY WINS arrayArribat

							}
							sortirPartida = true;
						} else {

							moviments++;
							System.out.println("bbbbbb");
							modificarPosicio(laberint1, moviment);

						}

					}

				//	arrayMoviments[numPartida] = moviments;

				} else if (nivell == 2) {

					numPartida++;

					trobarPosicioInicial(laberint2);

					// BUCLE SEGON NIVELL
					while (!sortirPartida) {

						boolean arribat = false;
						mostrarMatriu(laberint2);
						System.out.println("Quina acció vols fer? w = pujar, s = baixar, a = esquerra, d = dreta, q = sortir ");
						String moviment = teclat.nextLine();
						if (moviment.equalsIgnoreCase("q") || arribat == true) {

							if (arribat == true) { // PONER ARRAY WINS arrayArribat

							//	arrayArribat[numPartida] = true;

							}
							sortirPartida = true;
						} else {

							moviments++;
							System.out.println("cccccc");
							modificarPosicio(laberint2, moviment);
							
						}
					}


					//arrayMoviments



				} else if (nivell == 3) {

					numPartida++;

					trobarPosicioInicial(laberint3);


					// BUCLE TERCER NIVELL
					while (!sortirPartida) {

						boolean arribat = false;
						mostrarMatriu(laberint3);
						System.out.println("Quina acció vols fer? w = pujar, s = baixar, a = esquerra, d = dreta, q = sortir ");
						String moviment = teclat.nextLine();

						if (moviment.equalsIgnoreCase("q") || arribat == true) {

							if (arribat == true) { // PONER ARRAY WINS arrayArribat

							}
							sortirPartida = true;
						} else {

							moviments++;
							System.out.println("dddddd");
							modificarPosicio(laberint3, moviment);
							

						}

					}

				} else {

					System.out.println("Numero incorrecte!!");

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
		
			mouresAmunt(matriu,x,y);


		} else if (moviment.equalsIgnoreCase("S")) {

			y++;
			

			mouresAmunt(matriu,x,y);


		} else if (moviment.equalsIgnoreCase("D")) {
			x++;
			mouresAmunt(matriu,x,y);

		} else {

			System.out.println("Tecla incorrecte!");

		}


	}

	public static void mouresAmunt(String matriu[][], int x,int y) {


		if(x<0 && x>matriu.length || y<0 && y<matriu.length){

			System.out.println("Et surts del laberint!");

		} else {

			for(int i=0 ;i<matriu.length;i++){
				for(int j=0;j<matriu[i].length;j++){
	
					if(i == x && j == y){
						
						if(matriu[x][y-1].equalsIgnoreCase(" ")){
	
							matriu[x][y-1] = "P";
							matriu[x][y] = " ";
	
						} else {
	
							System.out.println("NO ES POT ANAR");
	
						}
	
					}
				}
			}

		}

	}

	public static char mouresAbaix(String matriu[][], int x,int y) {

		if(x<0 && x>matriu.length || y<0 && y<matriu.length){

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

	public static char mouresDreta(String matriu[][], int x,int y) {

	}

	public static char mouresEsquerra(String matriu[][], int x,int y) {

	}



	public static void resultats(int partides[], int moviments[], boolean sortit[]) {

		for (int i = 0; i < partides.length; i++) {
			System.out.println("partides: " + partides[i] + ", moviments: " + moviments[i] + ", ha sortit: " + sortit[i]);
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

		} else if(matriu[x-1][y].equalsIgnoreCase(" ")){


			matriu[x-1][y]= "P";

		} else if(matriu[x][y-1].equalsIgnoreCase(" ")){

			matriu[x][y-1] = "P";

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