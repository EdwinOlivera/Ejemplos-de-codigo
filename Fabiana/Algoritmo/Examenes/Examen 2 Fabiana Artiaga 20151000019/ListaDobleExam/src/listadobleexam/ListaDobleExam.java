package listadobleexam;

import java.util.Random;
import java.util.Scanner;

/**
 * Author: Fabiana Yamaly Artiaga Portillo cuenta:20151000019
 */
public class ListaDobleExam {

    public static void main(String[] args) {
        Menu();
    }

    public static void Menu() {
        String opcion;
        Scanner teclado = new Scanner(System.in); //Creación de un objeto Scanner
        ListaDobleTAD miLista = new ListaDobleTAD();
        DInfo Dato = new DInfo();
        String tmpCadena;
        int tmpNumero = 0;
        int CantidadInicial = 10;
        DNodo puntero;

        do {

            System.out.println("------------AGENDA------------");
            System.out.println("1. Ingresar valors entre 1 y 100 ");
            System.out.println("2.  Mover apuntadores (Izq y Der) ");
            System.out.println("s. Salir");
            System.out.println("-----------------------------------------");
            System.out.print("INGRESE LA OPCION [1 - 5]: ");
            opcion = teclado.next();
            opcion = opcion.toLowerCase();
            switch (opcion) {
                case "1":
                    System.out.print("Ingrese la cantidad de numeros que desea en la lista -> ");
                    CantidadInicial = teclado.nextInt();
                    MeterN(miLista, CantidadInicial);
                    break;
                case "2":
                    System.out.println("La sumatoria total del recorrido es " + miLista.DIniciarRecorrido());
                    System.out.println("La sumatoria parcial de Izquierda a Derecha es " + miLista.getSumaIzq());
                    System.out.println("La sumatoria parcial de Derecha a Izquierda es " + miLista.getSumaDer());
                    break;
                case "s":
                    System.exit(0);
                    break;
                default:
                    break;
            }
        } while (true); //-- SEGUIRA HASTA QUE OPCION SEA IGUAL A 5
    }//fin menu

    //otros métodos
    public final static void agregarLineas(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println();
        }
    }

    public final static void pausa() {
        System.out.print("Press Any Key To Continue...");
        new java.util.Scanner(System.in).nextLine();
    }

    public static String PideCadena(String pTexto) {
        String cadena;
        Scanner teclado = new Scanner(System.in);
        System.out.print(pTexto);
        cadena = teclado.nextLine();
        return cadena;
    }

    public static void MeterN(ListaDobleTAD miLista, int cantidadInicial) {
        int tmpNumero = 0;
        DInfo Datos;
        Random rnd = new Random();
        for (int i = 0; i < cantidadInicial; i++) {
            Datos = new DInfo();
            tmpNumero = 1 + rnd.nextInt(100);
            Datos.setNumero(tmpNumero);
            miLista.DIntertarInicio(Datos);
        }
        miLista.DMostrar();
    }
}
