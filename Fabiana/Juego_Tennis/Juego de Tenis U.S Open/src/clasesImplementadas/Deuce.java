package clasesImplementadas;

import java.util.Random;
import java.util.Scanner;

import clasesImplementadas.Clase_de_Enums.Estados;
import clasesImplementadas.Clase_de_Enums.Golpes;
import clasesImplementadas.Clase_de_Enums.JugadorConVentajas;
import clasesImplementadas.Clase_de_Enums.JugadorGanadores;
import clasesImplementadas.Clase_de_Enums.Lados;
import clasesImplementadas.Clase_de_Enums.TipoJuegos;
import clasesImplementadas.Clase_de_Enums.Turnos;
import main.ClasePrincipal;


public class Deuce {
	


	// Random
	static Random rdm = new Random();
	static Scanner entrada = new Scanner(System.in);
	private static int AumentadorVentajaPC=0, AumentadorVentajaUsuario=0, SetGanadosPC=0, SetGanadosUsuario=0;
	private static ClasePrincipal PrincipalClase = new ClasePrincipal();
	private static Clase_de_Enums Enums = PrincipalClase.RecuperarEnums();

	public void JugarDeuce() {
		Enums.setTipoDeJuego(TipoJuegos.DEUCE);
		Enums.setEstado(Estados.EMPATE); 
		System.out.println("Se ha empatado el partido");
		ClasePrincipal.RealizarPausa();
		System.out.println("*******Se realizara el Deuce*******");
		do {
			switch (Enums.getTurnoActual()) {
			case USUARIO:
				TurnoUsuarioDEUCE(PrincipalClase.getDireccionDegolpe(), PrincipalClase.getEntrada());
				break;
			case PC:
				TurnoPCDEUCE(PrincipalClase.getDireccionDegolpe());
				break;
			}
		} while (Enums.getEstado() == Estados.EMPATE);
	}

	private static void TurnoUsuarioDEUCE(int DireccionDeSalida, Scanner entrada) {
		System.out.printf("\nIngrese el numero de la Direccion deseada Pegar en el Deuce: \n1.DERECHA \n2.IZQUIERDA\n");
		do {
			DireccionDeSalida = 2; // entrada.nextInt();
			if (DireccionDeSalida > 2 || DireccionDeSalida < 1) {
				System.out.println("Ha ingresado una opcion no valida");
			}
		} while (DireccionDeSalida > 2 || DireccionDeSalida < 1);

		if (DireccionDeSalida == 1) {
			Enums.setLadoUsuario(Lados.DERECHA);
		} else {
			Enums.setLadoUsuario(Lados.IZQUIERDA);
		}

		if (Enums.getLadoUsuario() == Enums.getLadoPC()) {
			Enums.setTurnoActual(Turnos.PC);
			Enums.setGolpe(Golpes.ACERTO);
			System.out.println(PrincipalClase.getNombreUsuario() + " ha hacertado el golpe. :-)");
			System.out.println("\nDireccion del Golpe: " + Enums.getLadoUsuario());
		} else {
			Enums.setGolpe(Golpes.FALLO);
			Enums.setTurnoActual(Turnos.PC); 
			System.out.println(PrincipalClase.getNombreUsuario() + " ha Fallado el golpe. :-(");
			System.out.println("\nDireccion del Golpe: " + Enums.getLadoUsuario());

			switch (Enums.getJugadorConLaVentaja()) {
			case USUARIO:
				AumentadorVentajaPC=0;
				AumentadorVentajaUsuario=0;
				PrincipalClase.setVentajaPC(AumentadorVentajaPC);
				PrincipalClase.setVentajaUSUARIO(AumentadorVentajaUsuario);
				Enums.setJugadorConLaVentaja(JugadorConVentajas.NINGUNO);
				break;
			case NINGUNO:
				AumentadorVentajaPC+=1;
				PrincipalClase.setVentajaPC(AumentadorVentajaPC);
				Enums.setJugadorConLaVentaja(JugadorConVentajas.PC);
				break;
			case PC:
				AumentadorVentajaPC+=1;
				PrincipalClase.setVentajaPC(AumentadorVentajaPC);
				break;
			default:
				System.out.println("Se ha salido del Rango de las posibilidades en el DEUCE");
				break;
			}
			MostrarPuntosDeuce();
			ComprobarDEUCE();
			if (Enums.getEstado() == Estados.EMPATE) {
				ClasePrincipal.RealizarSaque(DireccionDeSalida);
			}
		}

	}

	private static void TurnoPCDEUCE(int DireccionDeSalida) {
		System.out.println("Turno de la PC en el DEUCE");
		ClasePrincipal.RealizarPausa();
		do {// Realiza la asignacion la direccion en que le pega a la bola
			DireccionDeSalida = rdm.nextInt(100);
		} while (DireccionDeSalida < 1);

		if (DireccionDeSalida <= 50) {
			Enums.setLadoPC(Lados.DERECHA);
		} else {
			Enums.setLadoPC(Lados.IZQUIERDA);
		}

		if (Enums.getLadoPC() == Enums.getLadoUsuario()) {
			Enums.setGolpe(Golpes.ACERTO);
			Enums.setTurnoActual(Turnos.USUARIO);
			System.out.println(PrincipalClase.getNombrePC() + " ha Acertado el golpe.");
		} else {
			Enums.setGolpe(Golpes.FALLO);
			Enums.setTurnoActual(Turnos.USUARIO);
			System.out.println(PrincipalClase.getNombrePC() + " ha Fallado el golpe.");
			switch (Enums.getJugadorConLaVentaja()) {
			case PC:
				AumentadorVentajaPC=0;
				AumentadorVentajaUsuario=0;
				PrincipalClase.setVentajaPC(AumentadorVentajaPC);
				PrincipalClase.setVentajaUSUARIO(AumentadorVentajaUsuario);
				Enums.setJugadorConLaVentaja(JugadorConVentajas.NINGUNO);
				break;
			case NINGUNO:
				AumentadorVentajaUsuario+=1;
				PrincipalClase.setVentajaUSUARIO(AumentadorVentajaUsuario);
				Enums.setJugadorConLaVentaja(JugadorConVentajas.USUARIO);
				break;
			case USUARIO:
				AumentadorVentajaUsuario+=1;
				PrincipalClase.setVentajaPC(AumentadorVentajaUsuario);
				break;
			default:
				System.out.println("Se ha salido del Rango de las posibilidades en el DEUCE");
				break;
			}
			MostrarPuntosDeuce();
			ComprobarDEUCE();
			if (Enums.getEstado() == Estados.EMPATE) {
				ClasePrincipal.RealizarSaque(DireccionDeSalida);
			}
		}
	}

	private static void ComprobarDEUCE() {
		if (PrincipalClase.getVentajaPC() == 2) {
			System.out.println("Ha gando en el DUECE el jugador " + PrincipalClase.getNombrePC());
			Enums.setEstado(Estados.GANO);
			Enums.setTipoDeJuego(TipoJuegos.NORMAL);
			SetGanadosPC +=1; 
			PrincipalClase.setGameGanadoPC(SetGanadosPC); 
			Enums.setJugadorQueGano(JugadorGanadores.PC);
		} else if (PrincipalClase.getVentajaUSUARIO() == 2) {
			SetGanadosUsuario +=1;
			Enums.setTipoDeJuego(TipoJuegos.NORMAL);
			Enums.setEstado(Estados.GANO);
			PrincipalClase.setGameGanadoUSUARIO(SetGanadosUsuario); 
			Enums.setJugadorQueGano(JugadorGanadores.USUARIO);			
			System.out.println("Ha gando  en el DUECE el jugador " + PrincipalClase.getNombreUsuario());
		}

	}

	private static void MostrarPuntosDeuce() {
		if (PrincipalClase.getVentajaPC() == 0 && PrincipalClase.getVentajaUSUARIO() == 0) {
			System.out.println("*-*-*-*-*-*-*-*-Se ha vuelto a tener el EMPATE. Se sigue jugando*-*-*-*-*-*-*-*-");
			System.out.println("\nLos puntos actuales del Deuce de " + PrincipalClase.getNombrePC() + " son : " + PrincipalClase.getPuntosPC());
			System.out.println("Los puntos actuales del Deuce de " + PrincipalClase.getNombreUsuario() + " son : " + PrincipalClase.getPuntosUsuario());
		}
		if (PrincipalClase.getVentajaPC() == 1) {
			System.out.println("\nLos puntos actuales del Deuce de " + PrincipalClase.getNombrePC() + " son : AD");
			System.out.println("Los puntos actuales del Deuce de " + PrincipalClase.getNombreUsuario() + " son : " + PrincipalClase.getPuntosUsuario());
		} else if (PrincipalClase.getVentajaUSUARIO() == 1) {
			System.out.println("\nLos puntos actuales del Deuce de " + PrincipalClase.getNombreUsuario() + " son : AD");
			System.out.println("Los puntos actuales del Deuce de " + PrincipalClase.getNombrePC() + " son : " + PrincipalClase.getPuntosPC());

		}
	}

	
}
