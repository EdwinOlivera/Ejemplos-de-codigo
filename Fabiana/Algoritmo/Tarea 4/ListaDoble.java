package listadoble;

import java.util.Scanner;

/**
 *
 * @author Ricardo Rivera
 */
public class ListaDoble {

    public static void main(String[] args) {
        Menu();
    }

    public static void Menu() {

        int numeroDeCasillas = 10;

        String opcion;
        Scanner teclado = new Scanner(System.in); //Creación de un objeto Scanner
        TadListaDoble miLista = new TadListaDoble();
        TipoInfo Dato = new TipoInfo();

        String tmpCadena;
        int tmpNumero = 0;
        int opcionNavegacion = 0;
        TipoNodo puntero;

        do {
            System.out.println("Ingrese el numero de casillas que desea en el juego (mayor a 10)");
//            numeroDeCasillas = teclado.nextInt();
            numeroDeCasillas = 20;
            if (numeroDeCasillas < 10) {
                System.out.println("Se ha ingresado un valor menor a 10. Intentelo de nuevo Burro");
            }
        } while (numeroDeCasillas < 10);

//Codigo para hacer pruebas.ELIMINAR ANTES DE ENVIAR
        tmpCadena = "Edwin";
        tmpCadena = "Olivera";
        //miLista.IngresarNombreJugadores("JugadorB");
////////////////////////////////////////////////////////////////////////

        //llenar con datos de prueba
        MeterN(miLista, numeroDeCasillas);
        miLista.IngresarNombreJugadores();

        do {
            agregarLineas(2);
            System.out.println("------------AGENDA------------");
            System.out.println("1. Iniciar el juego");
            System.out.println("2. Avanzar Jugador A");
            System.out.println("3. Avanzar Jugador B");

            System.out.println("s. Salir");
            System.out.println("-----------------------------------------");
            System.out.print("INGRESE LA OPCION [1 - 3]: ");
            opcion = teclado.next();

            switch (opcion) {

                case "1":
                    miLista.MostrarEstadoInicial();
                    pausa();
                    break;
                case "2":
                    miLista.AvanzarJugadorA(7);
                    break;
                case "3":
                    miLista.AvanzarJugadorB(7);
                    break;
                case "s":
                    System.exit(0);
                    break;
                default:
                    break;
            }

        } while (true); //-- SEGUIRA HASTA QUE OPCION SEA IGUAL A 5
    }//fin menu

    public static TipoInfo PideDatos() {
        TipoInfo Datos = new TipoInfo();
        Scanner teclado = new Scanner(System.in);
        System.out.println("INTRODUZCA LOS DATOS");
        System.out.print("--Identidad: ");

        System.out.print("--Nombre: ");
        Datos.setNombreCasilla(teclado.nextLine());
        System.out.print("--Edad: ");

        return Datos;
    }

    //otros métodos
    public static int Navegacion(TadListaDoble miLista, int opcionNavegacion) {
        int opcion = 0;
        int cantidadDeElementos = miLista.getCantidadCasillas();
        TipoNodo Dato = new TipoNodo();
        Scanner teclado = new Scanner(System.in);
        do {

            System.out.println("Navegacion:\n"
                    + "1.	Ir al principio\n"
                    + "2.	Ir al ultimo\n"
                    + "3.	Siguiente elemento\n"
                    + "4.	Anterior elemento");
            opcion = teclado.nextInt();
        } while (opcion < 1 || opcion > 4);
        switch (opcion) {
            case 1:
                opcionNavegacion = 0;
                Dato = miLista.getInicio();
                break;
            case 2:
                opcionNavegacion = miLista.getCantidadCasillas() - 1;
                Dato = miLista.getFinal();
                break;
            case 3:
                opcionNavegacion++;
                if (opcionNavegacion >= cantidadDeElementos) {
                    opcionNavegacion = miLista.getCantidadCasillas() - 1;
                    Dato = miLista.getFinal();
                    if (Dato != null) {

                        System.out.println(">>>>>>>>>No hay mas elementos Despues del actual. Esta en el final");
                        System.out.println("Y el ultimo elemento es: ");

                        System.out.println(Dato.getInfo().getNombreCasilla());
                    } else {
                        System.out.println("La lista esta vacia");
                    }
                    return opcionNavegacion;

                } else {
                    System.out.println("El siguiente es: ");
                    Dato.setInfo(miLista.getObjetoLista(opcionNavegacion));

                }
                break;
            case 4:
                opcionNavegacion--;
                if (opcionNavegacion < 1) {
                    opcionNavegacion = 1;
                    Dato = miLista.getInicio();
                    if (Dato != null) {

                        System.out.println(">>>>>>>>>> No hay elementos anterio al actual");
                        System.out.println("Y el primer elemento es: ");

                        System.out.println(" Nombre:" + Dato.getInfo().getNombreCasilla());
                        return opcionNavegacion;
                    } else {
                        System.out.println("La lista esta vacia");
                    }
                } else {
                    System.out.println(">>>>> El Anterior es: ");
                    Dato.setInfo(miLista.getObjetoLista(opcionNavegacion));
                }
                break;
        }
        if (Dato != null) {

            System.out.println(" Nombre:" + Dato.getInfo().getNombreCasilla());
        } else {
            System.out.println("La lista esta vacia");
        }
        return opcionNavegacion;
    }

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

    public static int PideEntero(String pTexto) {
        int numero;
        Scanner teclado = new Scanner(System.in);
        System.out.print(pTexto);
        numero = teclado.nextInt();
        return numero;
    }

    //método de apoyo
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

}
