package listadoble;

import java.util.Random;
import java.util.Scanner;

public class JuegoMain {

    public static void main(String[] args) {
        Menu();
    }

    public static void Menu() {

        int numeroDeCasillas = 10;

        String opcion;
        Scanner teclado = new Scanner(System.in);
        TadListaDoble miLista = new TadListaDoble();

        do {
            System.out.println("Ingrese el numero de casillas que desea en el juego (mayor a 10)");
            numeroDeCasillas = teclado.nextInt();
            if (numeroDeCasillas < 10) {
                System.out.println("Se ha ingresado un valor menor a 10. Intentelo de nuevo Burro");
            }
        } while (numeroDeCasillas < 10);

        MeterN(miLista, numeroDeCasillas);

//Esta es la funcion que registra los nombre de los jugadores
        miLista.IngresarNombreJugadores();

        do {
            agregarLineas(2);
            System.out.println("------------AGENDA------------");
            System.out.println("1. Iniciar el Juego");

            System.out.println("s. Salir");
            System.out.println("-----------------------------------------");
            System.out.print("INGRESE LA OPCION [1 o s]: ");
            opcion = teclado.next();
            opcion = opcion.toLowerCase();
            switch (opcion) {

                case "1":
                    IniciarJuego(miLista);
                    miLista.ReinicarEstado();
                    break;
                case "s":
                    System.exit(0);
                    break;
                default:
                    break;
            }

        } while (true);
    }

    // Metodo que ejecuta todo el juego. Require como parametro la lista principal de las casillas y donde estan los jugadores
    // En el metodo se encuentra el bucle principal del juego y se sale del metodo cuando se retira algun jugador o gana alguien
    public static void IniciarJuego(TadListaDoble miLista) {
        miLista.MostrarEstadoActualDelJuego();
        String proximoTurnoJugador = "A";
        int opcionSeguirJugador = 0;
        do {
            switch (proximoTurnoJugador) {
                case "A":
                    System.out.println("<<<<<<<<< Turno de " + miLista.getNombreJugadorA() + "<<<<<<<<<");

                    if (SeguirJugando("B")) {

                        proximoTurnoJugador = "B";

                        turnoJugadorA(miLista);
                    } else {
                        opcionSeguirJugador = 2;
                    }
                    break;
                case "B":
                    System.out.println("<<<<<<<<< Turno de " + miLista.getNombreJugadorB() + "  <<<<<<<<<");

                    if (SeguirJugando("A")) {

                        proximoTurnoJugador = "A";

                        turnoJugadorB(miLista);
                    } else {
                        opcionSeguirJugador = 2;
                    }
                    break;
            }
            miLista.MostrarEstadoActualDelJuego();
            pausa();
            if (miLista.getJuegoTerminado() == true) {
                opcionSeguirJugador = 2;
            }
        } while (opcionSeguirJugador != 2);
        System.out.println(">>>>>>>>>Juego terminado<<<<<<<<<");

        if (miLista.getJuegoTerminado() == true) {
            if (miLista.getPosicionJugadorA() > miLista.getPosicionJugadorB()) {
                System.out.println("El ganador es ---->>>>>> "+miLista.getNombreJugadorA());
            } else {
                System.out.println("El ganador es ---->>>>>> "+miLista.getNombreJugadorB());
            }
        } else {
            if (proximoTurnoJugador.equals("A")) {
                System.out.println("Ha ganado " + miLista.getNombreJugadorB() + " El juego");
            } else {
                System.out.println("Ha ganado " + miLista.getNombreJugadorA() + " El juego");
            }
        }

    }

    //Este metodo es el que pregunta si se quiere seguir jugando o no
    public static boolean SeguirJugando(String nombreJugador) {
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        do {

            System.out.println(
                    "1.	Lanzar el Dado\n"
                    + "2.	Abandonar el juego (Gana el jugador " + nombreJugador + " )");

            opcion = teclado.nextInt();
        } while (opcion < 1 || opcion > 2);
        if (opcion == 1) {
            return true;
        } else {
            return false;
        }
    }

    //Este metodo es el que ejecuta el turno del jugador A
    public static void turnoJugadorA(TadListaDoble miLista) {

        int DADO = PausaParaLanzarDado();
        System.out.println("Espacios que avanzara " + miLista.getNombreJugadorA() + " = + DADO");
        agregarLineas(1);
        miLista.AvanzarJugadorA(DADO);

    }

    //Este metodo es el que ejecuta el turno del jugador B
    public static void turnoJugadorB(TadListaDoble miLista) {

        int DADO = PausaParaLanzarDado();
        System.out.println("Espacios que avanzara " + miLista.getNombreJugadorB() + " = + DADO");

        agregarLineas(1);
        miLista.AvanzarJugadorB(DADO);

    }

    // Metodo encargado de ingresar las casillas en donde se juegan
    public static void MeterN(TadListaDoble pLista, int pTotal) {
        TipoInfo temp;

        String cadena = "";

        for (int x = pTotal; x >= 0; x--) {
            temp = new TipoInfo();

            cadena = "";
            if (x != 0) {
                cadena = "Casilla" + x;
            } else {
                cadena = "Inicio";
            }

            temp.setNombreCasilla(cadena);
            pLista.Intertar(temp);

        }
    }

    //método de apoyo 
    public final static void agregarLineas(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println();
        }
    }

    public final static void pausa() {
        System.out.print("Press Any Key To Continue...");
        new java.util.Scanner(System.in).nextLine();
    }

    // Pausa implementada para el lanzamiento del dado
    public final static int PausaParaLanzarDado() {
        System.out.print("Precione enter (Entrar) para lanzar el Dado...");
        new java.util.Scanner(System.in).nextLine();
        Random rnd = new Random();
        return 1 + rnd.nextInt(6);
    }

}
