import java.util.Scanner;

public class laberint_pepito {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner teclat = new Scanner(System.in);

		String laberint1[][] = { { "P", "M"," ", " ", " " },
				{ " ", "M", " ", "M", " " },
				{ " ", " ", " ", "M", " " },
				{ " ", "M", " ", "M", "S" },
				{ "M", "M", " ", "M", "M" } };

		String laberint2[][] = { { "P", " ", "M", "M", " ", "M", "S" },
				{ "M", " ", "M", " ", " ", "M", " " },
				{ " ", " ", "M", " ", "M", "M", " " },
				{ " ", "M", "M", " ", " ", " ", " " },
				{ " ", " ", " ", " ", "M", "M", "M" } };

		String laberint3[][] = { { "P", "M", "M", "M", " ", " ", " ", "M" },
				{ " ", " ", "M", " ", " ", "M", " ", "M" },
				{ "M", " ", "M", " ", "M", "M", " ", "S" },
				{ "M", " ", "M", " ", " ", "M", "M", "M" },
				{ " ", " ", " ", " ", " ", " ", " ", "M" } };

		int arrayNivells[];
		int arrayMoviments[];
		boolean arrayArribat[];

		boolean sortirJoc = false;
		int moviments = 0;
		int numPartida = 0;

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

				if (nivell == 1) {

					numPartida++;

					// BUCLE PRIMER NIVELL
					while (!sortirPartida) {

						boolean arribat=false;
						mostrarMatriu(laberint1);
						System.out.println("Quina acció vols fer? w = pujar, s = baixar, a = esquerra, d = dreta| q = sortir ");
						String moviment = teclat.nextLine();
						if(moviment.equalsIgnoreCase("q") || arribat == true){

							if(arribat == true){ //PONER ARRAY WINS arrayArribat
								
			
							}
							sortirPartida = true;
						} else {
							
							if (moviment.equalsIgnoreCase("W")) {

								mouresAmunt(laberint1, 1);


							} else if (moviment.equalsIgnoreCase("A")) {

						  
							} else if (moviment.equalsIgnoreCase("S")) {

					
							} else if (moviment.equalsIgnoreCase("D")) {

							} else {
					
								System.out.println("Tecla incorrecte!");
					
							}

						}

					}
					
				} else if (nivell == 2) {

					numPartida++;

					// BUCLE SEGON NIVELL
					while (!sortirPartida) {

						boolean arribat=false;
						mostrarMatriu(laberint2);
						System.out.println("Quina acció vols fer? w = pujar, s = baixar, a = esquerra, d = dreta| q = sortir ");
						String moviment = teclat.nextLine();
						if(moviment.equalsIgnoreCase("q") || arribat == true){

							if(arribat == true){ //PONER ARRAY WINS arrayArribat
								
			
							}
							sortirPartida = true;
						} else {
							
							if (moviment.equalsIgnoreCase("W")) {

								

							} else if (moviment.equalsIgnoreCase("A")) {

						  
							} else if (moviment.equalsIgnoreCase("S")) {

					
							} else if (moviment.equalsIgnoreCase("D")) {

							} else {
					
								System.out.println("Tecla incorrecte!");
					
							}

						}

						

					}

				} else if (nivell == 3) {

					numPartida++;

					// BUCLE TERCER NIVELL
					while (!sortirPartida) {

						boolean arribat=false;
						mostrarMatriu(laberint3);
						System.out.println("Quina acció vols fer?");
						String moviment = teclat.nextLine();

						if(moviment.equalsIgnoreCase("q") || arribat == true){

							if(arribat == true){ //PONER ARRAY WINS arrayArribat
								
			
							}
							sortirPartida = true;
						} else {
							
							if (moviment.equalsIgnoreCase("W")) {



							} else if (moviment.equalsIgnoreCase("A")) {

						  
							} else if (moviment.equalsIgnoreCase("S")) {

					
							} else if (moviment.equalsIgnoreCase("D")) {

							} else {
					
								System.out.println("Tecla incorrecte!");
					
							}

						}
 
					}

				} else {

					System.out.println("Numero incorrecte!!");

				}

				//Cas de MIRAR la llista de partides
			} else if (resposta == 2) {

				System.out.println("RESULTATS");
				//resultats(arrayNivells,arrayMoviments,arrayArribat);

			//SORTIDA DEL JOC
			} else if (resposta == 3){

				sortirJoc = true;

			//NUMERO INCORRECTE
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

	public static char mouresAmunt(String matriu[][], int moviment) {


		

	}
	public static char mouresAbaix(String matriu[][], int moviment) {

		

	}
	public static char mouresDreta(String matriu[][], int moviment) {

		

	}
	public static char mouresEsquerra(String matriu[][], int moviment) {

		

	}

	public static void resultats(int partides[], int moviments[], boolean sortit[]) {

		for(int i=0;i<partides.length;i++){

			System.out.println("partides: "+partides[i]+", moviments: "+moviments[i]+", ha sortit: "+sortit[i]);

		}
		
	}

	public static boolean sortirPartida(){

	return true;	

	}

	public static int modificarPosicio(char matriu[][], int moviment){


	}

}