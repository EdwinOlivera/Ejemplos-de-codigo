package poo;

import java.util.Scanner;

public class Veterinaria {

	private static Scanner scEntrada = new Scanner(System.in);
	private static int iPosicionX = 0, iPosicionY = 0;

	public static void main(String[] args) {

		Visita[][] oVisitante;
		Visita oPet = new Visita();

		boolean Diurno, Venenosa;
		String sNombre, sEspecie, sGenero, sSintomas, sRaza, sHabitad;
		double dPeso = 0.0;
		int iDias = 0, iDia = 0;
		int Vanh = 0, iEdad = 0;

		getBienvenida();

		System.out.println("Dias a ejecutar");
		iDias = scEntrada.nextInt();
		oVisitante = new Visita[iDias][10];

		do {

			for (iPosicionX = 0; iPosicionX < iDias; iPosicionX++) {

				for (iPosicionY = 0; iPosicionY < 10; iPosicionY++) {

					switch (Vanh) {

					case 1: {
						oVisitante[iPosicionX][iPosicionY] = oPet.DeliverBird(sNombre, sEspecie, sGenero, sSintomas,
								iEdad, dPeso, Diurno);
						break;
					}
					case 2: {
						oVisitante[iPosicionX][iPosicionY] = oPet.DeliverDogString(sNombre, sEspecie, sGenero,
								sSintomas, iEdad, dPeso, sRaza);
						break;
					}
					case 3: {
						oVisitante[iPosicionX][iPosicionY] = oPet.DeliverSnake(sNombre, sEspecie, sGenero, sSintomas,
								iEdad, dPeso, Venenosa);
						break;
					}
					case 4: {
						oVisitante[iPosicionX][iPosicionY] = oPet.DeliverFish(sNombre, sEspecie, sGenero, sSintomas,
								iEdad, dPeso, sHabitad);
						break;
					}
					}
				}
			}

			iDia++;
		} while (iDia < iDias);

	}

	public static void getBienvenida() {
		System.out.println("------- Bienvenido a la veterianaria -------\n");
		System.out.println("******* El animal es primero *******");

	}

	public void setDatos() {

	}

}
