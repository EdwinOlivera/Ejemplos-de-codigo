/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OrdenListasSimples;

import java.util.Scanner;

/**
 *
 * @author Ricardo Rivera
 */
public class OrdenListaS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Menu();
    }

    public static void Menu() {
        String opcion;
        Scanner teclado = new Scanner(System.in); //Creación de un objeto Scanner
        TadListaSimple miLista = new TadListaSimple();
        TipoInfo Dato = new TipoInfo();
        String tmpCadena;
        int tmpNumero = 0;

        //llenar con datos de prueba
        int cantidad = 0;
        cantidad = PideEntero("Cantidad de datos de prueba: ");
        MeterN(miLista, cantidad);

        do {
            agregarLineas(2);
            System.out.println("------------AGENDA------------");
            System.out.println("1. Nuevo ");
            System.out.println("2. Ver datos");
            System.out.println("3. Buscar ");
            System.out.println("4. Eliminar uno ");
            System.out.println("5. Eliminar varios ");
            System.out.println("6. Modificar ");
            System.out.println("7. Ordenar por ID (Burbuja)");
            System.out.println("8. Ordenar por Edad (QuickSort)");
            System.out.println("--- Tarea ----");
            System.out.println("9. Ordenar por Edad - Burbuja");
            System.out.println("10. Ordenar por Edad y Nombre (Burbuja)");
            System.out.println("11. Ordenar por nombre (quickSort)");
            System.out.println("s. Salir");
            System.out.println("-----------------------------------------");
            System.out.print("INGRESE LA OPCION [1 - 11]: ");
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
                    tmpCadena = PideCadena("Identidad a buscar: ");
                    Dato = miLista.Buscar(tmpCadena);
                    if (Dato == null) {
                        System.out.println("Dato no existe");
                    } else {
                        System.out.println("Dato encontrado:" + Dato.getNombre());
                    }
                    pausa();
                    break;
                case "4":
                    tmpCadena = PideCadena("Identidad a eliminar: ");
                    Dato = miLista.EliminarPorID(tmpCadena);
                    if (Dato == null) {
                        System.out.println("Dato no existe");
                    } else {
                        System.out.println("Dato eliminado:" + Dato.getNombre());
                    }
                    pausa();
                    break;
                case "5":
                    tmpNumero = PideEntero("Edad: ");
                    tmpNumero = miLista.EliminarPorEdad(tmpNumero);
                    if (tmpNumero == 0) {
                        System.out.println("ninguna coincidencia");
                    } else {
                        System.out.println("Datos eliminados:" + tmpNumero);
                    }
                    pausa();
                    break;
                case "6":
                    tmpCadena = PideCadena("Identidad a modificar: ");
                    if (!miLista.ExisteID(tmpCadena)) {
                        System.out.println("Identidad no existe");
                    } else {
                        Dato = new TipoInfo();
                        Dato.setIdentidad(tmpCadena);
                        Dato.setNombre(PideCadena("Nombre: "));
                        Dato.setEdad(PideEntero("Edad: "));
                        miLista.ModificarPorID(tmpCadena, Dato);
                    }
                    break;
                case "7":
                    System.out.println("1. Ascendentemente");
                    System.out.println("2. Descendentemente");
                    tmpNumero = PideEntero("Opcion: ");
                    miLista.OrdenPorID(tmpNumero);
                    System.out.println("Datos ordenados");
                    pausa();
                    break;
                case "8":
                    miLista.OrdenPorEdadQuickSort();
                    System.out.println("Datos ordenados");
                    pausa();
                    break;
                case "9":

                    System.out.println("1. Ascendentemente");
                    System.out.println("2. Descendentemente");
                    tmpNumero = PideEntero("Opcion: ");
                    miLista.OrdenPorEdad_xx(tmpNumero);
                    System.out.println("Datos ordenados");
                    pausa();
                    break;
                case "10":

                    miLista.OrdenPorEdadNombre(1);
                    pausa();
                    break;
                case "11":
                    miLista.OrdenPorNombreQuickSort();
                    System.out.println("Datos ordenados");
                    pausa();
                    break;
                case "s":
                    System.exit(0);
                    break;
                default:
                    break;
            }
        } while (true); //-- SEGUIRA HASTA QUE OPCION SEA IGUAL A s
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
    public static void MeterN(TadListaSimple pLista, int pTotal) {
        TipoInfo temp;
        int edad = 0, id = 0, intLetra = 0;
        char data = ' ';
        String cadena = "";
        for (int x = 1; x <= pTotal; x++) {
            temp = new TipoInfo();
            //aleatorio para el ID
            id = (int) (Math.floor(Math.random() * 8999 + 1)) + 1000;
            temp.setIdentidad(String.valueOf(id));

            //aleatorio para el nombre
            cadena = "";
            for (int i = 1; i <= 2; i++) {
                intLetra = (int) (Math.floor(Math.random() * 25 + 1)) + 97;
                cadena = cadena + (char) intLetra;
            }
            temp.setNombre(cadena);

            //aleatorio para la edad
            edad = (int) (Math.floor(Math.random() * 10 + 1)) + 17;
            temp.setEdad(edad);
            if (!pLista.ExisteID(temp.getIdentidad())) {
                pLista.IntertarInicio(temp);
            }
        }
    }

}
