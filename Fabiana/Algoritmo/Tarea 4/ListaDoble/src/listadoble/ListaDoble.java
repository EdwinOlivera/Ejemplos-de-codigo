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
        String opcion;
        Scanner teclado = new Scanner(System.in); //Creación de un objeto Scanner
        TadListaDoble miLista = new TadListaDoble();
        TipoInfo Dato = new TipoInfo();
        String tmpCadena;
        int tmpNumero = 0;
        int opcionNavegacion = 0;

        TipoNodo puntero;

        //llenar con datos de prueba
        MeterN(miLista, 10, "O");

        do {
            agregarLineas(2);
            System.out.println("------------AGENDA------------");
            System.out.println("1. Nuevo ");
            System.out.println("2. Ver datos (inicio a fin)");
            System.out.println("3. Ver datos (fin a fin)");
            System.out.println("4. Buscar ");
            System.out.println("5. Modificar ");
            System.out.println("6. Eliminar uno ");
            System.out.println("7. Eliminar varios (Tarea Ejercicio 1)");
            System.out.println("8. Movimiento      (Tarea Ejercicio 2)");
            System.out.println("s. Salir");
            System.out.println("-----------------------------------------");
            System.out.print("INGRESE LA OPCION [1 - 8]: ");
            opcion = teclado.next();
            opcion = opcion.toLowerCase();
            switch (opcion) {
                case "1":
                    Dato = PideDatos();
                    miLista.InsertarOrdenado(Dato);
                    pausa();
                    break;
                case "2":
                    miLista.Mostrar();
                    pausa();
                    break;
                case "3":
                    miLista.MostrarDesdeFin();
                    pausa();
                    break;
                case "4":
                    tmpCadena = PideCadena("Identidad a buscar: ");
                    puntero = miLista.BuscarID(tmpCadena);
                    if (puntero == null) {
                        System.out.println("Dato no existe");
                    } else {
                        Dato = puntero.getInfo();
                        System.out.println("Dato encontrado:" + Dato.getNombre());
                    }
                    pausa();
                    break;
                case "5":
                    tmpCadena = PideCadena("Identidad a modificar: ");
                    Dato = new TipoInfo();
                    Dato.setIdentidad(tmpCadena);
                    Dato.setNombre(PideCadena("Nombre: "));
                    Dato.setEdad(PideEntero("Edad: "));
                    miLista.ModificarPorID(tmpCadena, Dato);
                    break;
                case "6":
                    tmpCadena = PideCadena("Identidad a eliminar: ");
                    Dato = miLista.EliminarPorID(tmpCadena);
                    if (Dato == null) {
                        System.out.println("Dato no existe");
                    } else {
                        System.out.println("Dato eliminado:" + Dato.getNombre());
                    }
                    pausa();
                    break;
                case "7":
                    tmpNumero = PideEntero("Edad:");
                    System.out.println("---------------> " + tmpNumero);
                    tmpNumero = miLista.EliminarPorEdad(tmpNumero);
                    if (tmpNumero == 0) {
                        System.out.println("Ninguna coincidencia");
                    } else {
                        System.out.println("Datos Eliminados = " + tmpNumero);
                    }
                    pausa();
                    break;
                case "8":
                    opcionNavegacion = Navegacion(miLista, opcionNavegacion);
                    pausa();
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
        Datos.setIdentidad(teclado.nextLine());
        System.out.print("--Nombre: ");
        Datos.setNombre(teclado.nextLine());
        System.out.print("--Edad: ");
        Datos.setEdad(teclado.nextInt());
        return Datos;
    }

    //otros métodos
    public static int Navegacion(TadListaDoble miLista, int opcionNavegacion) {
        int opcion = 0;
        int cantidadDeElementos = miLista.getCantidad();
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
                opcionNavegacion = miLista.getCantidad() - 1;
                Dato = miLista.getFinal();
                break;
            case 3:
                opcionNavegacion++;
                if (opcionNavegacion >= cantidadDeElementos) {
                    opcionNavegacion = miLista.getCantidad() - 1;
                    Dato = miLista.getFinal();
                    if (Dato != null) {

                        System.out.println(">>>>>>>>>No hay mas elementos Despues del actual. Esta en el final");

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

            System.out.println((opcionNavegacion + 1) + ") "
                    + "ID:" + Dato.getInfo().getIdentidad()
                    + " Nombre:" + Dato.getInfo().getNombre()
                    + " Edad:" + Dato.getInfo().getEdad());
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
    public static void MeterN(TadListaDoble pLista, int pTotal, String pTipo) {
        TipoInfo temp;
        int edad = 0, id = 0, intLetra = 0;
        char data = ' ';
        String cadena = "";
        for (int x = 1; x <= pTotal; x++) {
            temp = new TipoInfo();
            //aleatorio para el ID
            id = (int) (Math.floor(Math.random() * 200 + 1)) + 100;
            temp.setIdentidad(String.valueOf(id));

            //aleatorio para el nombre
            cadena = "";
            for (int i = 1; i <= 2; i++) {
                intLetra = (int) (Math.floor(Math.random() * 25 + 1)) + 97;
                cadena = cadena + (char) intLetra;
            }
            temp.setNombre(cadena);

            //aleatorio para la edad
            edad = (int) (Math.floor(Math.random() * 5 + 1)) + 17;
            temp.setEdad(edad);
            if (!pLista.ExisteID(temp.getIdentidad())) {
                if (pTipo.equals("I")) {
                    pLista.IntertarInicio(temp);
                }
                if (pTipo.equals("F")) {
                    pLista.InsertarFinal(temp);
                }
                if (pTipo.equals("O")) {
                    pLista.InsertarOrdenado(temp);
                }
            }
        }
    }
;
}
