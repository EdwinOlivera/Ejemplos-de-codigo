//Laura Karina Chincilla Chincilla 20152100165
//Fabiana Yamaly Artiaga Portillo 20151000019

package main.Manual;

import java.util.Random;
import java.util.Scanner;

public class ClasePrincipal_Manual {
	// Definiendo a los Enum con sus difernete estados y objetos
	public enum TipoJuegos {
		NORMAL, DEUCE;
	}

	public enum JugadorConVentajas {
		NINGUNO, PC, USUARIO;
	}

	public enum cantidadDeVentajas {
		NIGUNA, PRIMERA, SEGUNDA;
	}

	public enum JuegosRealizados {
		NINGUNO, PRIMERO, SEGUNDO, TERCERO, CUARTO, QUINTO, SEXTO, SEPTIMO, OCTAVO, NOVENO, DECIMO, UNDECIMO,
		DECIMOSEGUNDO, DECIMOTERCERO, FINSET;
	}

	public enum PuntosAsignados {
		NINGUNO, PRIMERO, SEGUNDO, TERCERO;
	}

	public enum Lados {
		IZQUIERDA, DERECHA;
	}

	public enum Estados {
		INDEFINIDO, GANO, EMPATE;
	}

	public enum Turnos {
		USUARIO, PC;
	}

	public enum SaqueInciales {
		USUARIO, PC;
	}

	public enum Golpes {
		ACERTO, FALLO;
	}

	public enum JugadorGanadores {
		INDEFINIDO, PC, USUARIO;
	}

	public enum SetJugados {
		PRIMERO, SEGUNDO, TERCERO, FINMATCH;
	}

	static SetJugados SetJugado = SetJugados.PRIMERO;

	static JuegosRealizados games = JuegosRealizados.NINGUNO;

	static TipoJuegos tipoDeJuego = TipoJuegos.NORMAL;
	static JugadorConVentajas JugadorConLaVentaja = JugadorConVentajas.NINGUNO;
	static cantidadDeVentajas NumeroDeVentaja = cantidadDeVentajas.NIGUNA;
	static int VentajaPC = 0;
	static int VentajaUSUARIO = 0;

	static JugadorGanadores jugadorQueGano = JugadorGanadores.INDEFINIDO;
	static Lados ladoPC = Lados.DERECHA; // Lado de lanzamiento de la PC
	static Lados ladoUsuario = Lados.DERECHA; // Lado de lanzamiento del Usuario
	static Estados estado = Estados.INDEFINIDO;
	static Turnos turnoActual; // Establece el turno del lanzador que sigue
	static SaqueInciales primerSaque;
	static Golpes golpe; // Define si acierta o falla un golpe
	static PuntosAsignados sumarPuntosPC = PuntosAsignados.NINGUNO;
	static PuntosAsignados sumarPuntosUsuario = PuntosAsignados.NINGUNO;
	// ***************************

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
	// Estas variables realizan el conteo general de cuantos Game lleva ganado los jugadores y no se muestran en pantalla
	static int marcadorPC = 0;
	static int marcadorUsuario = 0;

	// Random
	static Random rdm = new Random();
	static Scanner entrada = new Scanner(System.in);

	static int DireccionDegolpe = 0;

	public static void main(String[] args) {

		// Variables de saque
		int OrdenDeSaque = 1;

		// Variables De direccion Para la PC en random y el usuario lo ingresa
		int Direccion = 0;

		// ArregloJugadores para la PC
		String[] JugadoresTenis = { "Alexander Zverev", "Serena Williams", "Rafael Nadal", "Naomi Osaka",
				"Kei Nishikori" };

		// ConfiguracionDeLosJUGADORES
		NombreUsuario = "Edwin"; // ColocarNombreDeUsuario(NombreUsuario, entrada);
		NombrePC = ColocarNombreDePC(NombrePC, JugadoresTenis);
		realizarPrimerSaque(OrdenDeSaque, Direccion);
	}

	private static void realizarPrimerSaque(int OrdenDeSaque, int Direccion) {
		do {// Realiza la asignacion del orden de saque de los jugadores
			OrdenDeSaque = rdm.nextInt(3);
		} while (OrdenDeSaque < 1);
		RealizarPausa();

		if (OrdenDeSaque == 1) {
			primerSaque = SaqueInciales.USUARIO;
			System.out.println("\nSaca Incialmente: " + NombreUsuario);
		} else {
			primerSaque = SaqueInciales.PC;
			System.out.println("\nSaca Incialmente: " + NombrePC);
		}
		// Este switch realiza el primer saque
		switch (primerSaque) {
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
		do {
			do {
				switch (turnoActual) {
				case USUARIO:
					TurnoUsuario(DireccionDeTiro, entrada);
					break;
				case PC:
					TurnoPC(DireccionDeTiro);
					break;
				}
			} while (estado == Estados.INDEFINIDO);
			SumarMarcador();
			MostrarPuntosDeGAME();
			if(games == JuegosRealizados.FINSET) {
				CambioDeGames();
			}
			if (estado != Estados.INDEFINIDO) {
				System.out.println("Se hara un cambio de GAME");
				CambioDeGames();
			}
		} while (games != JuegosRealizados.FINSET);
	}

	private static void CambioDeGames() {

		RealizarPausa();
		switch (games) {
		case NINGUNO:
			System.out.println("Se ha terminado el PRIMER GAME, se comenzara el SEGUNDO------>");
			games = JuegosRealizados.PRIMERO;
			break;
		case PRIMERO:
			System.out.println("Se ha terminado el SEGUNDO GAME, se comenzara el TERCERO------>");
			games = JuegosRealizados.SEGUNDO;
			break;
		case SEGUNDO:
			System.out.println("Se ha terminado el TERCER GAME, se comenzara el CUARTO------>");
			games = JuegosRealizados.TERCERO;
			break;
		case TERCERO:
			System.out.println("Se ha terminado el CUARTO GAME, se comenzara el QUINTO------>");
			games = JuegosRealizados.CUARTO;
			break;
		case CUARTO:
			System.out.println("Se ha terminado el QUINTO GAME, se comenzara el SEXTO------>");
			games = JuegosRealizados.QUINTO;
			break;
		case QUINTO:
			System.out.println("Se ha terminado el SEXTO GAME, se comenzara el SEPTIMO------>");
			games = JuegosRealizados.SEXTO;
			break;
		case SEXTO:
			System.out.println("Se ha terminado el SEPTIMO GAME, se comenzara el OCTAVO------>");
			games = JuegosRealizados.SEPTIMO;
			break;
		case SEPTIMO:
			System.out.println("Se ha terminado el OCTAVO GAME, se comenzara el NOVENO------>");
			games = JuegosRealizados.OCTAVO;
			break;
		case OCTAVO:
			System.out.println("Se ha terminado el NOVENO GAME, se comenzara el DECIMO------>");
			games = JuegosRealizados.NOVENO;
			break;
		case NOVENO:
			System.out.println("Se ha terminado el DECIMO GAME, se comenzara el UNDECIMO------>");
			games = JuegosRealizados.DECIMO;
			break;
		case DECIMO:
			System.out.println("Se ha terminado el UNDECIMO GAME, se comenzara el DECIMOSEGUNDO------>");
			games = JuegosRealizados.DECIMO;
			break;
		case UNDECIMO:
			System.out.println("Se ha terminado el DECIMOSEGUNDO GAME, se comenzara el DECIMOTERCERO------>");
			games = JuegosRealizados.DECIMO;
			break;
		case DECIMOSEGUNDO:
			System.out.println(
					"Se ha terminado el DECIMOTERCERO GAME. Y este es el ultimo GAME, y el final del SET Actual------>");
			games = JuegosRealizados.FINSET;
			estado = Estados.INDEFINIDO;
			CambioDeGames();
			break;
		case FINSET:
			ComprobrarSetJugado();
			if(SetJugado != SetJugados.FINMATCH) {
				System.out.println("Se hara el cambio de de SET");
				CambioDeSet();	
			}else {
				CambioDeSet();
			}
			
			break;
		default:
			System.out.println("Fuera del rango del Game");
			break;
		}
		if(games != JuegosRealizados.FINSET) {
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
			ladoPC = Lados.DERECHA;
		} else {
			ladoPC = Lados.IZQUIERDA;
		}

		if (ladoPC == ladoUsuario) {
			golpe = Golpes.ACERTO;
			turnoActual = Turnos.USUARIO;
			System.out.println(NombrePC + " ha hacertado el golpe.");
		} else {
			System.out.println(NombrePC + " ha fallado el golpe.");
			golpe = Golpes.FALLO;
			AsignarPuntosUsuario();
			if (estado == Estados.INDEFINIDO) {
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
			ladoUsuario = Lados.DERECHA;
		} else {
			ladoUsuario = Lados.IZQUIERDA;
		}

		if (ladoUsuario == ladoPC) {
			turnoActual = Turnos.PC;
			golpe = Golpes.ACERTO;
			System.out.println(NombreUsuario + " ha hacertado el golpe. :-)");
			System.out.println("\nDireccion del Golpe: " + ladoUsuario);
		} else {
			golpe = Golpes.FALLO;
			System.out.println(NombreUsuario + " ha Fallado el golpe. :-(");
			System.out.println("\nDireccion del Golpe: " + ladoUsuario);
			AsignarPuntosPC();
			if (estado == Estados.INDEFINIDO) {
				RealizarSaque(DireccionDeSalida);
			}
		}

	}

	private static void JugarDeuce() {
		tipoDeJuego = TipoJuegos.DEUCE;
		estado = Estados.EMPATE;
		System.out.println("Se ha empatado el partido");
		RealizarPausa();
		System.out.println("*******Se realizara el Deuce*******");
		do {
			switch (turnoActual) {
			case USUARIO:
				TurnoUsuarioDEUCE(DireccionDegolpe, entrada);
				break;
			case PC:
				TurnoPCDEUCE(DireccionDegolpe);
				break;
			}
		} while (estado == Estados.EMPATE);
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
			ladoUsuario = Lados.DERECHA;
		} else {
			ladoUsuario = Lados.IZQUIERDA;
		}

		if (ladoUsuario == ladoPC) {
			turnoActual = Turnos.PC;
			golpe = Golpes.ACERTO;
			System.out.println(NombreUsuario + " ha hacertado el golpe. :-)");
			System.out.println("\nDireccion del Golpe: " + ladoUsuario);
		} else {
			golpe = Golpes.FALLO;
			turnoActual = Turnos.PC;
			System.out.println(NombreUsuario + " ha Fallado el golpe. :-(");
			System.out.println("\nDireccion del Golpe: " + ladoUsuario);

			switch (JugadorConLaVentaja) {
			case USUARIO:
				VentajaPC = 0;
				VentajaUSUARIO = 0;
				JugadorConLaVentaja = JugadorConVentajas.NINGUNO;
				break;
			case NINGUNO:
				VentajaPC += 1;
				JugadorConLaVentaja = JugadorConVentajas.PC;
				break;
			case PC:
				VentajaPC += 1;
				break;
			default:
				System.out.println("Se ha salido del Rango de las posibilidades en el DEUCE");
				break;
			}
			MostrarPuntosDeuce();
			ComprobarDEUCE();
			if (estado == Estados.EMPATE) {
				RealizarSaque(DireccionDeSalida);
			}
		}

	}

	private static void TurnoPCDEUCE(int DireccionDeSalida) {
		System.out.println("Turno de la PC en el DEUCE");
		RealizarPausa();
		do {// Realiza la asignacion la direccion en que le pega a la bola
			DireccionDeSalida = rdm.nextInt(100);
		} while (DireccionDeSalida < 1);

		if (DireccionDeSalida <= 50) {
			ladoPC = Lados.DERECHA;
		} else {
			ladoPC = Lados.IZQUIERDA;
		}

		if (ladoPC == ladoUsuario) {
			golpe = Golpes.ACERTO;
			turnoActual = Turnos.USUARIO;
			System.out.println(NombrePC + " ha Acertado el golpe.");
		} else {
			golpe = Golpes.FALLO;
			turnoActual = Turnos.USUARIO;
			System.out.println(NombrePC + " ha Fallado el golpe.");
			switch (JugadorConLaVentaja) {
			case PC:
				VentajaPC = 0;
				VentajaUSUARIO = 0;
				JugadorConLaVentaja = JugadorConVentajas.NINGUNO;
				break;
			case NINGUNO:
				VentajaUSUARIO += 1;
				JugadorConLaVentaja = JugadorConVentajas.USUARIO;
				break;
			case USUARIO:
				VentajaUSUARIO += 1;
				break;
			default:
				System.out.println("Se ha salido del Rango de las posibilidades en el DEUCE");
				break;
			}
			MostrarPuntosDeuce();
			ComprobarDEUCE();
			if (estado == Estados.EMPATE) {
				RealizarSaque(DireccionDeSalida);
			}
		}
	}

	private static void ComprobarDEUCE() {
		if (VentajaPC == 2) {
			System.out.println("Ha gando en el DUECE el jugador " + NombrePC);
			estado = Estados.GANO;
			tipoDeJuego = TipoJuegos.NORMAL;
			GameGanadoPC += 1;
			jugadorQueGano = JugadorGanadores.PC;
		} else if (VentajaUSUARIO == 2) {
			tipoDeJuego = TipoJuegos.NORMAL;
			estado = Estados.GANO;
			GameGanadoUSUARIO += 1;
			jugadorQueGano = JugadorGanadores.USUARIO;
			System.out.println("Ha gando  en el DUECE el jugador " + NombreUsuario);
		}

	}

	private static void MostrarPuntosDeuce() {
		if (VentajaPC == 0 && VentajaUSUARIO == 0) {
			System.out.println("*-*-*-*-*-*-*-*-Se ha vuelto a tener el EMPATE. Se sigue jugando*-*-*-*-*-*-*-*-");
			System.out.println("\nLos puntos actuales del Deuce de " + NombrePC + " son : " + puntosPC);
			System.out.println("Los puntos actuales del Deuce de " + NombreUsuario + " son : " + puntosUsuario);
		}
		if (VentajaPC == 1) {
			System.out.println("\nLos puntos actuales del Deuce de " + NombrePC + " son : AD");
			System.out.println("Los puntos actuales del Deuce de " + NombreUsuario + " son : " + puntosUsuario);
		} else if (VentajaUSUARIO == 1) {
			System.out.println("\nLos puntos actuales del Deuce de " + NombreUsuario + " son : AD");
			System.out.println("Los puntos actuales del Deuce de " + NombrePC + " son : " + puntosPC);

		}
	}

	private static void RealizarSaque(int DireccionDeSalida) {
		switch (primerSaque) {
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
		if (tipoDeJuego != TipoJuegos.DEUCE) {
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
			ladoUsuario = Lados.DERECHA;
		} else {
			ladoUsuario = Lados.IZQUIERDA;
		}
		turnoActual = Turnos.PC;

		System.out.println("\nDireccion de saque: " + ladoUsuario);
	}

	private static void SaquePC(int DireccionDeSalida) {
		if (tipoDeJuego != TipoJuegos.DEUCE) {
			MostrarPuntos();
		}
		System.out.println("El jugador " + NombrePC + " esta realizando el SAQUE");
		RealizarPausa();
		do {// Realiza la asignacion la direccion en que sale la bola
			DireccionDeSalida = rdm.nextInt(100);
		} while (DireccionDeSalida < 1);

		if (DireccionDeSalida <= 50) {
			ladoPC = Lados.DERECHA;
		} else {
			ladoPC = Lados.IZQUIERDA;
		}
		turnoActual = Turnos.USUARIO;

	}

	// Conjunto de Funciones que solo sirve para operaciones recurentes
	private static void RestablecerGAME() {
		estado = Estados.INDEFINIDO; // Esto hace que no tenga ningun ganador del GAME actual.
		// Estos son los enum que tienen que reestablcerse para el gamen actual
		jugadorQueGano = JugadorGanadores.INDEFINIDO;
		sumarPuntosPC = PuntosAsignados.NINGUNO;
		sumarPuntosUsuario = PuntosAsignados.NINGUNO;
		puntosPC = 0;
		puntosUsuario = 0;
		// *******************************
		if (games != JuegosRealizados.FINSET) {
			switch (primerSaque) {// Aqui se hace el cambio de SAQUE despues de terminar un GAME
			case PC:
				primerSaque = SaqueInciales.USUARIO;
				RealizarSaque(DireccionDegolpe);
				break;
			case USUARIO:
				primerSaque = SaqueInciales.PC;
				RealizarSaque(DireccionDegolpe);
				break;
			default:
				break;
			}
		}
	}

	private static void AsignarPuntosUsuario() {
		switch (sumarPuntosUsuario) {
		case NINGUNO:
			puntosUsuario = 15;
			sumarPuntosUsuario = PuntosAsignados.PRIMERO;
			break;
		case PRIMERO:
			puntosUsuario = 30;
			sumarPuntosUsuario = PuntosAsignados.SEGUNDO;
			break;
		case SEGUNDO:
			puntosUsuario = 40;
			sumarPuntosUsuario = PuntosAsignados.TERCERO;
			if (puntosPC < 30) {
				System.out.println(NombrePC + " ganara si anota un punto mas. A menos que " + NombreUsuario
						+ " anote un punto mas.\n");
			}
			if (puntosPC == 40) {
				MostrarPuntos();

				JugarDeuce();
				}
			break;
		case TERCERO:
			if (puntosPC <= 30) {
				GameGanadoUSUARIO += 1;
				System.out.println("Ha ganado " + NombreUsuario);
				jugadorQueGano = JugadorGanadores.USUARIO;
				estado = Estados.GANO;
			} else if (puntosUsuario == puntosPC) {
				JugarDeuce();
			}
			break;
		default:
			break;
		}

	}

	private static void AsignarPuntosPC() {
		switch (sumarPuntosPC) {
		case NINGUNO:
			puntosPC = 15;
			sumarPuntosPC = PuntosAsignados.PRIMERO;
			break;
		case PRIMERO:
			puntosPC = 30;
			sumarPuntosPC = PuntosAsignados.SEGUNDO;
			break;
		case SEGUNDO:
			puntosPC = 40;
			sumarPuntosPC = PuntosAsignados.TERCERO;
			if (puntosUsuario < 30) {
				System.out.println(NombrePC + " ganara si anota un punto mas. A menos que " + NombreUsuario
						+ " anote un punto mas.\n");
			}
			if (puntosUsuario == 40) {
				MostrarPuntos();
				JugarDeuce();
				}
			break;
		case TERCERO:
			puntosPC += 0;
			if (puntosUsuario <= 30) {
				System.out.println("Ha ganado " + NombrePC);
				GameGanadoPC += 1;
				jugadorQueGano = JugadorGanadores.PC;
				estado = Estados.GANO;
			} else if (puntosUsuario == puntosPC) {
				JugarDeuce();
			}

			break;

		default:
			break;
		}
	}

	private static void SumarMarcador() {
		switch (jugadorQueGano) {
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
			SetGanadoPC +=1;
			System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
			System.out.println("Gano el SET actual " + NombrePC);
			System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
			games = JuegosRealizados.FINSET;
			estado = Estados.INDEFINIDO;
			MostrarPuntosDeSet();
		} else if ((PuntosUsuario && DiferenciaPC) || (Puntuacion7Usuario)) {
			SetGanadoUsuario +=1;
			System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
			System.out.println("Gano el SET acutal " + NombreUsuario);
			System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
			games = JuegosRealizados.FINSET;
			estado = Estados.INDEFINIDO;
			MostrarPuntosDeSet();
		}

	}

	private static void MostrarPuntosDeGAME() {
		System.out.println("******--------********_******--------********_******--------********");
		System.out.println("Los puntos de " + NombreUsuario + " al final del GAME son :" + puntosUsuario);
		System.out.println("Los puntos de " + NombrePC + " al final del GAME son :" + puntosPC);
		System.out.println("******--------********_******--------********_******--------********");
		System.out.println("Resultado General:");
		System.out.println("Los GAME ganado por " + NombreUsuario + " son: " + GameGanadoUSUARIO);
		System.out.println("Los GAME ganado por " + NombrePC + " son: " + GameGanadoPC);

	}

	private static void MostrarPuntosDeSet() {
		System.out.println("Falta definir como mostrar los puntos al final de los SETs");
	}

	private static void RealizarPausa() {
		System.out.println();
		int TiempoDeEspera = 1000;
		try {
			for (int i = 0; i < 10; i++) {
				Thread.sleep(TiempoDeEspera / 10);
				System.out.printf(" * ");
			}
			System.out.println();
			Thread.sleep(TiempoDeEspera); // Con esto se realiza la pausa del programa.
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	private static void MostrarPuntos() {
		System.out.println("\nLos puntos actuales de " + NombreUsuario + " son : " + puntosUsuario);
		System.out.println("Los puntos actuales de " + NombrePC + " son : " + puntosPC);
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

	//Funciones que se usan cuando termina un Set y hace el cambio respectivo
	private static void CambioDeSet() {
		switch (SetJugado) {
		case PRIMERO:
			SetJugado = SetJugados.SEGUNDO;
			break;
			
		case SEGUNDO:
			SetJugado = SetJugados.TERCERO;
			break;

		case TERCERO:
			SetJugado = SetJugados.FINMATCH;
			break;
			
		case FINMATCH:
			System.out.println("Se ha terminado el MATCH");
			ResultadoDelMatch();
			break;
			
		default:
			
			break;
		}
		if(SetJugado != SetJugados.FINMATCH) {
			RestablecerSet();
		}
	}
	private static void ResultadoDelMatch() {
		if(SetGanadoPC > SetGanadoUsuario) {
			System.out.println("Ha hagado el jugador "+ NombrePC+ " el MATCH, con "+ SetGanadoPC +" Set ganados");
			System.out.println("El jugador "+ NombreUsuario + " tiene "+ SetGanadoUsuario+" Set ganados");
		}else if(SetGanadoUsuario > SetGanadoPC) {
			System.out.println("Ha hagado el jugador "+ NombreUsuario+ " el MATCH, con "+ SetGanadoUsuario+" Set ganados");
			System.out.println("El jugador "+ NombrePC+ " tiene "+ SetGanadoPC+" Set ganados");
		}
		
	}

	private static void RestablecerSet() {
		int OrdenDeSaque=0 ,Direccion=0;
		games = JuegosRealizados.NINGUNO;
		tipoDeJuego = TipoJuegos.NORMAL;
		
		JugadorConLaVentaja = JugadorConVentajas.NINGUNO;
		NumeroDeVentaja = cantidadDeVentajas.NIGUNA;
		VentajaPC = 0;
		VentajaUSUARIO = 0;
		
		jugadorQueGano = JugadorGanadores.INDEFINIDO;
		ladoPC = Lados.DERECHA; // Lado de lanzamiento de la PC
		ladoUsuario = Lados.DERECHA; // Lado de lanzamiento del Usuario
		estado = Estados.INDEFINIDO;
		sumarPuntosPC = PuntosAsignados.NINGUNO;
		sumarPuntosUsuario = PuntosAsignados.NINGUNO;

		GameGanadoPC = 0;
		GameGanadoUSUARIO = 0;
		
		puntosUsuario = 0;
		puntosPC = 0;
		marcadorPC = 0;
		marcadorUsuario = 0;
		realizarPrimerSaque(OrdenDeSaque,Direccion);
	}
	private static void ComprobrarSetJugado() {
		if(SetGanadoPC ==2) {
			SetJugado = SetJugados.FINMATCH;
		}
		if(SetGanadoUsuario ==2) {
			SetJugado = SetJugados.FINMATCH;
		}
		
	}
}
