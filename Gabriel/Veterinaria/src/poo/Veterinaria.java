package poo;

import java.util.Scanner;

public class Veterinaria {

	private static Scanner scEntrada = new Scanner(System.in);
	private static int iPosicionX = 0, iPosicionY = 0;

	public static void main(String[] args) {

		//
		Visita[][] oVisitante;
		Visita oPet = new Visita();
		//

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

			for ( iPosicionX = 0; iPosicionX < iDias; iPosicionX++) {

				for (iPosicionY = 0; iPosicionY < 10; iPosicionY++) {

					
					
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
