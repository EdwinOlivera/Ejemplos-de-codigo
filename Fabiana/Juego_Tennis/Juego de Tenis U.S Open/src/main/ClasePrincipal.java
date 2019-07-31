//Laura Karina Chincilla Chincilla 20152100165
//Fabiana Yamaly Artiaga Portillo 20151000019

package main;

import java.util.Random;
import java.util.Scanner;

import clasesImplementadas.Clase_de_Enums;
import clasesImplementadas.Clase_de_Enums.Estados;
import clasesImplementadas.Clase_de_Enums.Golpes;
import clasesImplementadas.Clase_de_Enums.JuegosRealizados;
import clasesImplementadas.Clase_de_Enums.JugadorConVentajas;
import clasesImplementadas.Clase_de_Enums.JugadorGanadores;
import clasesImplementadas.Clase_de_Enums.Lados;
import clasesImplementadas.Clase_de_Enums.PuntosAsignados;
import clasesImplementadas.Clase_de_Enums.SaqueInciales;
import clasesImplementadas.Clase_de_Enums.SetJugados;
import clasesImplementadas.Clase_de_Enums.TipoJuegos;
import clasesImplementadas.Clase_de_Enums.Turnos;
import clasesImplementadas.Clase_de_Enums.cantidadDeVentajas;
import clasesImplementadas.Deuce;


public class ClasePrincipal {
	static int VentajaPC = 0;
	static int VentajaUSUARIO = 0;

	static String NombrePC = null;// Son las variables los que se usan para determinar el nombre de los jugadores
	static String NombreUsuario = null;

	// Variables para los puntos globales
	static int GameGanadoPC = 0;
	static int GameGanadoUSUARIO = 0;
	static int puntosUsuario = 0;
	static int puntosPC = 0;
	// Estas variable realizan el conteo de los Set ganado por cada jugador
	static int SetGanadoPC = 0;
	static int SetGanadoUsuario = 0;
	// Estas variables realizan el conteo general de cuantos Game lleva ganado los
	// jugadores y no se muestran en pantalla
	static int marcadorPC = 0;
	static int marcadorUsuario = 0;

	// Random
	static Random rdm = new Random();
	static Scanner entrada = new Scanner(System.in);

	static int DireccionDegolpe = 0;

	// Declaraciones de Objetos
	static Clase_de_Enums LosEnums = new Clase_de_Enums();
	static Deuce Deuces = new Deuce();

	// Variables de saque
	private static int OrdenDeSaque = 1;

	// Variables De direccion Para la PC en random y el usuario lo ingresa
	private static int Direccion = 0;

	public ClasePrincipal() {

	}

	public static void main(String[] args) {

		// ArregloJugadores para la PC
		String[] JugadoresTenis = { "Alexander Zverev", "Serena Williams", "Rafael Nadal", "Naomi Osaka",
				"Kei Nishikori" };

		// ConfiguracionDeLosJUGADORES
		NombreUsuario = "Edwin"; // ColocarNombreDeUsuario(NombreUsuario, entrada);
		NombrePC = ColocarNombreDePC(NombrePC, JugadoresTenis);
		realizarPrimerSaque(OrdenDeSaque, Direccion);
	}

	// Las siguiente Funciones hace que se realice el juego normal
	private static void realizarPrimerSaque(int OrdenDeSaque, int Direccion) {
		do {// Realiza la asignacion del orden de saque de los jugadores
			OrdenDeSaque = rdm.nextInt(3);
		} while (OrdenDeSaque < 1);
		RealizarPausa();

		if (OrdenDeSaque == 1) {
			LosEnums.setPrimerSaque(SaqueInciales.USUARIO);
			System.out.println("\nSaca Incialmente: " + NombreUsuario);
		} else {
			LosEnums.setPrimerSaque(SaqueInciales.PC);
			System.out.println("\nSaca Incialmente: " + NombrePC);
		}
		// Este switch realiza el primer saque
		switch (LosEnums.getPrimerSaque()) {
		case USUARIO:
			SaqueUsuario(Direccion, entrada);
			break;
		case PC:
			SaquePC(Direccion);
			break;
		}
		GameActual(Direccion);// Esta funcion realiza los game de cada partido
	}

	private static void GameActual(int DireccionDeTiro) {

		LosEnums.getGames();
		do {
			LosEnums.getEstado();
			do {
				switch (LosEnums.getTurnoActual()) {
				case USUARIO:
					TurnoUsuario(DireccionDeTiro, entrada);
					break;
				case PC:
					TurnoPC(DireccionDeTiro);
					break;
				}
			} while (LosEnums.getEstado() == Estados.INDEFINIDO);

			MostrarPuntosDeGAME();
			SumarMarcadorGame();
			if (LosEnums.getGames() == JuegosRealizados.FINSET) {
				CambioDeGames();
			}
			if (LosEnums.getEstado() != Estados.INDEFINIDO) {
				System.out.println("Se hara un cambio de GAME");
				CambioDeGames();
			}
		} while (LosEnums.getGames() != JuegosRealizados.FINSET);
	}

	private static void CambioDeGames() {

		RealizarPausa();
		switch (LosEnums.getGames()) {
		case NINGUNO:
			System.out.println("Se ha terminado el PRIMER GAME, se comenzara el SEGUNDO------>");
			LosEnums.setGames(JuegosRealizados.PRIMERO);
			break;
		case PRIMERO:
			System.out.println("Se ha terminado el SEGUNDO GAME, se comenzara el TERCERO------>");
			LosEnums.setGames(JuegosRealizados.SEGUNDO);
			break;
		case SEGUNDO:
			System.out.println("Se ha terminado el TERCER GAME, se comenzara el CUARTO------>");
			LosEnums.setGames(JuegosRealizados.TERCERO);
			break;
		case TERCERO:
			System.out.println("Se ha terminado el CUARTO GAME, se comenzara el QUINTO------>");
			LosEnums.setGames(JuegosRealizados.CUARTO);
			break;
		case CUARTO:
			System.out.println("Se ha terminado el QUINTO GAME, se comenzara el SEXTO------>");
			LosEnums.setGames(JuegosRealizados.QUINTO);
			break;
		case QUINTO:
			System.out.println("Se ha terminado el SEXTO GAME, se comenzara el SEPTIMO------>");
			LosEnums.setGames(JuegosRealizados.SEXTO);
			break;
		case SEXTO:
			System.out.println("Se ha terminado el SEPTIMO GAME, se comenzara el OCTAVO------>");
			LosEnums.setGames(JuegosRealizados.SEPTIMO);
			break;
		case SEPTIMO:
			System.out.println("Se ha terminado el OCTAVO GAME, se comenzara el NOVENO------>");
			LosEnums.setGames(JuegosRealizados.OCTAVO);
			break;
		case OCTAVO:
			System.out.println("Se ha terminado el NOVENO GAME, se comenzara el DECIMO------>");
			LosEnums.setGames(JuegosRealizados.NOVENO);
			break;
		case NOVENO:
			System.out.println("Se ha terminado el DECIMO GAME, se comenzara el UNDECIMO------>");
			LosEnums.setGames(JuegosRealizados.DECIMO);
			break;
		case DECIMO:
			System.out.println("Se ha terminado el UNDECIMO GAME, se comenzara el DECIMOSEGUNDO------>");
			LosEnums.setGames(JuegosRealizados.UNDECIMO);
			break;
		case UNDECIMO:
			System.out.println("Se ha terminado el DECIMOSEGUNDO GAME, se comenzara el DECIMOTERCERO------>");
			LosEnums.setGames(JuegosRealizados.DECIMOSEGUNDO);
			break;
		case DECIMOSEGUNDO:
			System.out.println(
					"Se ha terminado el DECIMOTERCERO GAME. Y este es el ultimo GAME, y el final del SET Actual------>");
			LosEnums.setGames(JuegosRealizados.FINSET);
			LosEnums.setEstado(Estados.INDEFINIDO);
			CambioDeGames();
			break;
		case FINSET:
			ComprobrarSetJugado();
			if (LosEnums.getSetJugado() != SetJugados.FINMATCH) {
				System.out.println("Se hara el cambio de de SET");
				CambioDeSet();
			} else {
				CambioDeSet();
			}

			break;
		default:
			System.out.println("Fuera del rango del Game");
			break;
		}
		if (LosEnums.getGames() != JuegosRealizados.FINSET) {
			RestablecerGAME();
		}

	}

	private static void TurnoPC(int DireccionDeSalida) {
		System.out.println("Turno de la PC");
		RealizarPausa();

		do {// Realiza la asignacion la direccion en que le pega a la bola
			DireccionDeSalida = rdm.nextInt(100);
		} while (DireccionDeSalida < 1);

		if (DireccionDeSalida <= 50) {
			LosEnums.setLadoPC(Lados.DERECHA);
		} else {
			LosEnums.setLadoPC(Lados.IZQUIERDA);
		}

		if (LosEnums.getLadoPC() == LosEnums.getLadoUsuario()) {
			LosEnums.setGolpe(Golpes.ACERTO);
			LosEnums.setTurnoActual(Turnos.USUARIO);
			System.out.println(NombrePC + " ha hacertado el golpe.");
		} else {
			System.out.println(NombrePC + " ha fallado el golpe.");
			LosEnums.setGolpe(Golpes.FALLO);
			AsignarPuntosUsuario();
			if (LosEnums.getEstado() == Estados.INDEFINIDO) {
				RealizarSaque(DireccionDeSalida);
			}
		}
	}

	private static void TurnoUsuario(int DireccionDeSalida, Scanner entrada) {
		System.out.printf("\nIngrese el numero de la Direccion deseada Pegar: \n1.DERECHA \n2.IZQUIERDA\n");
		do {
			DireccionDeSalida = 2; // entrada.nextInt();
			if (DireccionDeSalida > 2 || DireccionDeSalida < 1) {
				System.out.println("Ha ingresado una opcion no valida");
			}
		} while (DireccionDeSalida > 2 || DireccionDeSalida < 1);

		if (DireccionDeSalida == 1) {

			LosEnums.setLadoUsuario(Lados.DERECHA);
		} else {
			LosEnums.setLadoUsuario(Lados.IZQUIERDA);
		}

		if (LosEnums.getLadoUsuario() == LosEnums.getLadoPC()) {
			LosEnums.setTurnoActual(Turnos.PC);
			LosEnums.setGolpe(Golpes.ACERTO);
			System.out.println(NombreUsuario + " ha hacertado el golpe. :-)");
			System.out.println("\nDireccion del Golpe: " + LosEnums.getLadoUsuario());
		} else {
			LosEnums.setGolpe(Golpes.FALLO);
			System.out.println(NombreUsuario + " ha Fallado el golpe. :-(");
			System.out.println("\nDireccion del Golpe: " + LosEnums.getLadoUsuario());
			AsignarPuntosPC();
			if (LosEnums.getEstado() == Estados.INDEFINIDO) {
				RealizarSaque(DireccionDeSalida);
			}
		}

	}

	public static void RealizarSaque(int DireccionDeSalida) {
		switch (LosEnums.getPrimerSaque()) {
		case USUARIO:
			SaqueUsuario(DireccionDeSalida, entrada);
			break;
		case PC:
			SaquePC(DireccionDeSalida);
			break;

		default:
			break;
		}

	}

	private static void SaqueUsuario(int DireccionDeSalida, Scanner entrada) {
		if (LosEnums.getTipoDeJuego() != TipoJuegos.DEUCE) {
			MostrarPuntos();
		}

		System.out.println("El jugador " + NombreUsuario + " esta realizando el SAQUE");
		System.out.printf("\nIngrese el numero de la Direccion deseada hacer el SAQUE: \n1.DERECHA \n2.IZQUIERDA\n");
		do {
			DireccionDeSalida = 1;// entrada.nextInt();

			if (DireccionDeSalida < 1 || DireccionDeSalida > 2) {
				System.out.println("Ha ingresado un valor fuera de rango");
			}
		} while (DireccionDeSalida < 1 || DireccionDeSalida > 2);

		if (DireccionDeSalida == 1) {
			LosEnums.setLadoUsuario(Lados.DERECHA);
		} else {
			LosEnums.setLadoUsuario(Lados.IZQUIERDA);
		}
		LosEnums.setTurnoActual(Turnos.PC);

		System.out.println("\nDireccion de saque: " + LosEnums.getLadoUsuario());
	}

	private static void SaquePC(int DireccionDeSalida) {
		if (LosEnums.getTipoDeJuego() != TipoJuegos.DEUCE) {
			MostrarPuntos();
		}

		System.out.println("El jugador " + NombrePC + " esta realizando el SAQUE");
		RealizarPausa();
		do {// Realiza la asignacion la direccion en que sale la bola
			DireccionDeSalida = rdm.nextInt(100);
		} while (DireccionDeSalida < 1);

		if (DireccionDeSalida <= 50) {
			LosEnums.setLadoUsuario(Lados.DERECHA);
		} else {
			LosEnums.setLadoUsuario(Lados.IZQUIERDA);
		}
		LosEnums.setTurnoActual(Turnos.USUARIO);

	}
//*****************************************************************************************/

	// Conjunto de Funciones que solo sirve para operaciones recurentes
	private static void RestablecerGAME() {

		LosEnums.setEstado(Estados.INDEFINIDO);// Esto hace que no tenga ningun ganador del GAME actual.
		// Estos son los enum que tienen que reestablcerse para el gamen actual
		LosEnums.setJugadorQueGano(JugadorGanadores.INDEFINIDO);
		LosEnums.setSumarPuntosPC(PuntosAsignados.NINGUNO);
		LosEnums.setSumarPuntosUsuario(PuntosAsignados.NINGUNO);

		puntosPC = 0;
		puntosUsuario = 0;
		// *******************************
		if (LosEnums.getGames() != JuegosRealizados.FINSET) {
			switch (LosEnums.getPrimerSaque()) {// Aqui se hace el cambio de SAQUE despues de terminar un GAME
			case PC:
				LosEnums.setPrimerSaque(SaqueInciales.USUARIO);
				RealizarSaque(DireccionDegolpe);
				break;
			case USUARIO:
				LosEnums.setPrimerSaque(SaqueInciales.PC);
				RealizarSaque(DireccionDegolpe);
				break;
			default:
				break;
			}
		}
	}

	private static void AsignarPuntosUsuario() {
		switch (LosEnums.getSumarPuntosUsuario()) {
		case NINGUNO:
			puntosUsuario = 15;
			LosEnums.setSumarPuntosUsuario(PuntosAsignados.PRIMERO);
			break;
		case PRIMERO:
			puntosUsuario = 30;
			LosEnums.setSumarPuntosUsuario(PuntosAsignados.SEGUNDO);
			break;
		case SEGUNDO:
			puntosUsuario = 40;
			LosEnums.setSumarPuntosUsuario(PuntosAsignados.TERCERO);
			if (puntosPC < 30) {
				System.out.println(NombrePC + " ganara si anota un punto mas. A menos que " + NombreUsuario
						+ " anote un punto mas.\n");
			}
			if (puntosPC == 40) {
				MostrarPuntos();

				Deuces.JugarDeuce();
			}
			break;
		case TERCERO:
			if (puntosPC <= 30) {
				GameGanadoUSUARIO += 1;
				System.out.println("Ha ganado " + NombreUsuario);
				LosEnums.setJugadorQueGano(JugadorGanadores.USUARIO);
				LosEnums.setEstado(Estados.GANO);
			} else if (puntosUsuario == puntosPC) {
				Deuces.JugarDeuce();
			}
			break;
		default:
			break;
		}

	}

	private static void AsignarPuntosPC() {
		switch (LosEnums.getSumarPuntosPC()) {
		case NINGUNO:
			puntosPC = 15;
			LosEnums.setSumarPuntosPC(PuntosAsignados.PRIMERO);
			break;
		case PRIMERO:
			puntosPC = 30;
			LosEnums.setSumarPuntosPC(PuntosAsignados.SEGUNDO);
			break;
		case SEGUNDO:
			puntosPC = 40;
			LosEnums.setSumarPuntosPC(PuntosAsignados.TERCERO);
			if (puntosUsuario < 30) {
				System.out.println(NombrePC + " ganara si anota un punto mas. A menos que " + NombreUsuario
						+ " anote un punto mas.\n");
			}
			if (puntosUsuario == 40) {
				MostrarPuntos();
				Deuces.JugarDeuce();
			}
			break;
		case TERCERO:
			puntosPC += 0;
			if (puntosUsuario <= 30) {
				System.out.println("Ha ganado " + NombrePC);
				GameGanadoPC += 1;
				LosEnums.setJugadorQueGano(JugadorGanadores.PC);
				LosEnums.setEstado(Estados.GANO);
			} else if (puntosUsuario == puntosPC) {
				Deuces.JugarDeuce();
			}

			break;

		default:
			break;
		}
	}

	private static void SumarMarcadorGame() {
		switch (LosEnums.getJugadorQueGano()) {
		case PC:
			marcadorPC += 1;
			break;
		case USUARIO:
			marcadorUsuario += 1;
			break;

		default:
			break;
		}
		int Punt7 = 7;
		boolean Puntuacion7Usuario = Punt7 == marcadorUsuario, Puntuacion7PC = Punt7 == marcadorPC;
		boolean DiferenciaPC = marcadorPC <= (marcadorUsuario - 2),
				DiferenciaUsuario = marcadorUsuario <= (marcadorPC - 2);
		boolean PuntosPC = marcadorPC == 6, PuntosUsuario = marcadorUsuario == 6;

		if ((PuntosPC && DiferenciaUsuario) || (Puntuacion7PC)) {
			SetGanadoPC += 1;
			System.out.println(
					"/////////////////////////////////////////////////////////////////////////////////////////");
			System.out.println("Gano el SET actual " + NombrePC);
			System.out.println(
					"/////////////////////////////////////////////////////////////////////////////////////////");
			LosEnums.setGames(JuegosRealizados.FINSET);
			LosEnums.setEstado(Estados.INDEFINIDO);

		} else if ((PuntosUsuario && DiferenciaPC) || (Puntuacion7Usuario)) {
			SetGanadoUsuario += 1;
			System.out.println(
					"/////////////////////////////////////////////////////////////////////////////////////////");
			System.out.println("Gano el SET acutal " + NombreUsuario);
			System.out.println(
					"/////////////////////////////////////////////////////////////////////////////////////////");
			LosEnums.setGames(JuegosRealizados.FINSET);
			LosEnums.setEstado(Estados.INDEFINIDO);

		}

	}

	private static void MostrarPuntosDeGAME() {
		System.out.println("\n******--------********_******--------********_******--------********");
		System.out.println("Los puntos de " + NombreUsuario + " al final del GAME son :" + puntosUsuario);
		System.out.println("Los puntos de " + NombrePC + " al final del GAME son :" + puntosPC);
		System.out.println("******--------********_******--------********_******--------********");
		System.out.println("Resultado General:");
		System.out.println("Los GAME ganado por " + NombreUsuario + " son: " + GameGanadoUSUARIO);
		System.out.println("Los GAME ganado por " + NombrePC + " son: " + GameGanadoPC+"\n");

	}

	public static void RealizarPausa() {
		System.out.println();
		int TiempoDeEspera = 1000;
		try {
			for (int i = 0; i < 10; i++) {
				Thread.sleep(TiempoDeEspera / 10);
				System.out.printf(" * ");
			}
			System.out.println("\n");
			Thread.sleep(TiempoDeEspera); // Con esto se realiza la pausa del programa.
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	private static void MostrarPuntos() {
		System.out.println("\nLos puntos actuales de " + NombreUsuario + " son : " + puntosUsuario);
		System.out.println("Los puntos actuales de " + NombrePC + " son : " + puntosPC+ "\n");
	}

	// Funciones que le colocan el nombre a los jugadores
	private static String ColocarNombreDePC(String NombrePC, String[] JugadoresTenis) {
		NombrePC = JugadoresTenis[rdm.nextInt(JugadoresTenis.length)];
		System.out.printf("\nEl jugador 2: " + NombrePC);
		System.out.printf("\n");
		return NombrePC;// Retorna el nombre del jugador de la PC
	}

	private static String ColocarNombreDeUsuario(String NombreUsuario, Scanner entrada) {
		System.out.print("¨US OPEN¨");
		System.out.print("\nIngrese SU nombre de jugador (Usuario): ");
		NombreUsuario = entrada.nextLine();
		System.out.print("\nEl jugador 1: " + NombreUsuario);
		return NombreUsuario; // Retorna el nombre del jugador del usuario

	}

	// Funciones que se usan cuando termina un Set y hace el cambio respectivo
	private static void CambioDeSet() {
		switch (LosEnums.getSetJugado()) {
		case PRIMERO:
			LosEnums.setSetJugado(SetJugados.SEGUNDO);
			break;

		case SEGUNDO:
			LosEnums.setSetJugado(SetJugados.TERCERO);
			break;

		case TERCERO:
			LosEnums.setSetJugado(SetJugados.FINMATCH);
			break;

		case FINMATCH:
			System.out.println("Se ha terminado el MATCH");
			ResultadoDelMatch();
			break;

		default:

			break;
		}
		if (LosEnums.getSetJugado() != SetJugados.FINMATCH) {
			RestablecerSet();
		}
	}

	private static void ResultadoDelMatch() {
		if (SetGanadoPC > SetGanadoUsuario) {
			System.out.println("\nHa hagado el jugador " + NombrePC + " el MATCH, con " + SetGanadoPC + " Set ganados");
			System.out.println("El jugador " + NombreUsuario + " tiene " + SetGanadoUsuario + " Set ganados\n");
		} else if (SetGanadoUsuario > SetGanadoPC) {
			System.out.println(
					"\nHa hagado el jugador " + NombreUsuario + " el MATCH, con " + SetGanadoUsuario + " Set ganados");
			System.out.println("El jugador " + NombrePC + " tiene " + SetGanadoPC + " Set ganados\n");
		}

	}

	private static void RestablecerSet() {
		int OrdenDeSaque = 0, Direccion = 0;
		LosEnums.setGames(JuegosRealizados.NINGUNO);
		LosEnums.setTipoDeJuego(TipoJuegos.NORMAL);

		LosEnums.setJugadorConLaVentaja(JugadorConVentajas.NINGUNO);
		LosEnums.setNumeroDeVentaja(cantidadDeVentajas.NIGUNA);
		VentajaPC = 0;
		VentajaUSUARIO = 0;

		LosEnums.setJugadorQueGano(JugadorGanadores.INDEFINIDO);
		LosEnums.setLadoPC(Lados.DERECHA); // Lado de lanzamiento de la PC
		LosEnums.setLadoUsuario(Lados.DERECHA); // Lado de lanzamiento del Usuario
		LosEnums.setEstado(Estados.INDEFINIDO);
		LosEnums.setSumarPuntosPC(PuntosAsignados.NINGUNO);
		;
		LosEnums.setSumarPuntosUsuario(PuntosAsignados.NINGUNO);

		GameGanadoPC = 0;
		GameGanadoUSUARIO = 0;

		puntosUsuario = 0;
		puntosPC = 0;
		marcadorPC = 0;
		marcadorUsuario = 0;
		realizarPrimerSaque(OrdenDeSaque, Direccion);
	}

	private static void ComprobrarSetJugado() {
		if (SetGanadoPC == 2) {
			LosEnums.setSetJugado(SetJugados.FINMATCH);
		}
		if (SetGanadoUsuario == 2) {
			LosEnums.setSetJugado(SetJugados.FINMATCH);
		}

	}

	// funciones necesarias para las otras clases
	public Clase_de_Enums RecuperarEnums() {
		return LosEnums;
	}

	// Los Get y Set de las variables
	// (encapsulamiento)*****************************************************
	public int getVentajaPC() {
		return VentajaPC;
	}

	public void setVentajaPC(int ventajaPC) {
		VentajaPC = ventajaPC;
	}

	public int getVentajaUSUARIO() {
		return VentajaUSUARIO;
	}

	public void setVentajaUSUARIO(int ventajaUSUARIO) {
		VentajaUSUARIO = ventajaUSUARIO;
	}

	public String getNombrePC() {
		return NombrePC;
	}

	public void setNombrePC(String nombrePC) {
		NombrePC = nombrePC;
	}

	public String getNombreUsuario() {
		return NombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		NombreUsuario = nombreUsuario;
	}

	public int getGameGanadoPC() {
		return GameGanadoPC;
	}

	public void setGameGanadoPC(int gameGanadoPC) {
		GameGanadoPC = gameGanadoPC;
	}

	public int getGameGanadoUSUARIO() {
		return GameGanadoUSUARIO;
	}

	public void setGameGanadoUSUARIO(int gameGanadoUSUARIO) {
		GameGanadoUSUARIO = gameGanadoUSUARIO;
	}

	public int getPuntosUsuario() {
		return puntosUsuario;
	}

	public void setPuntosUsuario(int puntosUsuario) {
		ClasePrincipal.puntosUsuario = puntosUsuario;
	}

	public int getPuntosPC() {
		return puntosPC;
	}

	public void setPuntosPC(int puntosPC) {
		ClasePrincipal.puntosPC = puntosPC;
	}

	public int getSetGanadoPC() {
		return SetGanadoPC;
	}

	public void setSetGanadoPC(int setGanadoPC) {
		SetGanadoPC = setGanadoPC;
	}

	public int getSetGanadoUsuario() {
		return SetGanadoUsuario;
	}

	public void setSetGanadoUsuario(int setGanadoUsuario) {
		SetGanadoUsuario = setGanadoUsuario;
	}

	public int getMarcadorPC() {
		return marcadorPC;
	}

	public void setMarcadorPC(int marcadorPC) {
		ClasePrincipal.marcadorPC = marcadorPC;
	}

	public int getMarcadorUsuario() {
		return marcadorUsuario;
	}

	public void setMarcadorUsuario(int marcadorUsuario) {
		ClasePrincipal.marcadorUsuario = marcadorUsuario;
	}

	public Random getRdm() {
		return rdm;
	}

	public void setRdm(Random rdm) {
		ClasePrincipal.rdm = rdm;
	}

	public Scanner getEntrada() {
		return entrada;
	}

	public void setEntrada(Scanner entrada) {
		ClasePrincipal.entrada = entrada;
	}

	public int getDireccionDegolpe() {
		return DireccionDegolpe;
	}

	public void setDireccionDegolpe(int direccionDegolpe) {
		DireccionDegolpe = direccionDegolpe;
	}

	public Deuce getDeuces() {
		return Deuces;
	}

	public void setDeuces(Deuce deuces) {
		Deuces = deuces;
	}


	public int getOrdenDeSaque() {
		return OrdenDeSaque;
	}

	public void setOrdenDeSaque(int ordenDeSaque) {
		OrdenDeSaque = ordenDeSaque;
	}

	public int getDireccion() {
		return Direccion;
	}

	public void setDireccion(int direccion) {
		Direccion = direccion;
	}

}
