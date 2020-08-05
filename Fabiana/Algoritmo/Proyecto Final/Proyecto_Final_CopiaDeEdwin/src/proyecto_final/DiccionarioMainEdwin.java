package proyecto_final;

import java.util.Random;
import java.util.Scanner;

public class DiccionarioMainEdwin {

    public static void main(String[] args) {
        Menu();
    }

    public static void Menu() {
        String opcion;
        Scanner teclado = new Scanner(System.in); //Creación de un objeto Scanner
        TadListaDiccionario miLista = new TadListaDiccionario();

        InfoCategoria tmpCategoria;
        InfoPalabra Dato = new InfoPalabra();
        InfoCategoria Dato1 = new InfoCategoria();

//Llenar automaticamente de datos la lista
        int cantidadInicial = 8;

        System.out.print("Cantidad inicial de Terminos --> ");
        cantidadInicial = teclado.nextInt();
        MeterCategoriaN(miLista, cantidadInicial);

        MeterPalabraN(miLista, cantidadInicial);
        String tmpCadena;
////////////////////////////////////////////////////////////////

        int tmpNumero = 0;

        do {
            agregarLineas(2);
            System.out.println("------------<> Menu Principal <>------------");
            System.out.println("--------------<><>------------------");

            System.out.println("<-----------> CRUD de Palabras <----------->");
            System.out.println("0. Meter mas Terminos a la Lista");
            System.out.println("1. Ingresar Nueva Palabra");
            System.out.println("2. Ver Todas las palabras Registradas");
            System.out.println("3. Modificar Palabra");
            System.out.println("4. Eliminar palabra");

            System.out.println("<-----------> CRUD de Categoria <----------->");
            System.out.println("5. Ingresar Categoria nueva ");
            System.out.println("6. Eliminar Categoria ");
            System.out.println("7. Ver todas las Categorias ");
            System.out.println("8. Moidificar Categoria ");

            System.out.println("<-----------> MODIFICACIONES DE DATOS<----------->");
            System.out.println("9. Ordenar Terminos (ascendente y descendentemente)");
            System.out.println("10. Ordenado de Categoria y termino (ascendente y descendentemente) ");

            System.out.println("<-----------> REPORTES GENERALES (pendientes)<----------->");
            System.out.println("11. Busqueda simple - palabra que comiencen de forma indica (PENDIENTE)");
            System.out.println("12. Busqueda avanzada -  palabra que contenga los caracteres especificados (COMPLETADO)");
            System.out.println("13. Conteo de Categorias (COMPLETADO)");

            System.out.println("<-----------> FUNCIONES EXTRAS<----------->");
            System.out.println("14. Ordenar Categorias (ascendente y descendentemente) ");
            System.out.println("15. Cantidad de Terminos en generales registrados ");

            System.out.println("--------------<><>------------------");
            System.out.println("s. Salir");
            System.out.println("-----------------------------------------");
            System.out.print("INGRESE LA OPCION [1 - 11]: ");
            opcion = teclado.next();
            opcion = opcion.toLowerCase();
            agregarLineas(1);
            switch (opcion) {
                case "0":
                    System.out.print("Cantidad de palabras a ingresar --> ");
                    tmpNumero = teclado.nextInt();
                    MeterPalabraN(miLista, tmpNumero);
                    break;
                case "1":
                    Dato = PideDatosPalabra();
                    System.out.println("Ingrese la categoria a la cual pertenece la Palabra " + Dato.getTermino());
                    tmpCadena = teclado.next();
                    miLista.IntertarPalabra(Dato, tmpCadena);
                    break;
                case "2":
                    miLista.MostrarPalabras();
                    break;
                case "3":
                    System.out.print("Ingrese la palabra que quiera Modificar --> ");
                    tmpCadena = teclado.next();
                    miLista.ModificarPalabra(tmpCadena);
                    break;
                case "4":
                    System.out.print("Ingrese la palabra que quiera Eliminar --> ");
                    tmpCadena = teclado.next();
                    miLista.EliminarPalabra(tmpCadena);
                    break;
                case "5":
                    tmpCategoria = new InfoCategoria();
                    System.out.println("Ingrese la nueva categoria");
                    tmpCategoria.setNombreCategoria(teclado.next());
                    if (miLista.IntertarCategoria(tmpCategoria)) {
                        System.out.println("¡Categoria registrada exitosamente!");
                    } else {
                        System.out.println("¡La categoria ya estaba registrada!");
                    }
                    break;
                case "6":
                    miLista.EliminarCategoria("Categoria-5");
                    break;
                case "7":
                    miLista.MostrarCategorias();
                    break;
                case "8":
                    System.out.print("Ingrese el nombre de la categoria a modificar ---> ");
                    tmpCadena = teclado.next();
                    miLista.ModificarCategoria(tmpCadena);
                    break;
                case "9":
                    System.out.println("¿Cómo quiere ordenar los terminos?");
                    System.out.println(""
                            + "1.	Ascendente \n"
                            + "2.	Descendente");
                    tmpNumero = teclado.nextInt();
                    miLista.OrdenarTermino(tmpNumero);
                    break;
                case "10":
                    System.out.println("¿Cómo quiere ordenar Las Categorias y los terminos?");
                    System.out.println(""
                            + "1.	Ascendente \n"
                            + "2.	Descendente");
                    tmpNumero = teclado.nextInt();
                    System.out.println("<-Iniciando el ordenado->");
                    miLista.OrdenarCategoriaTermino(tmpNumero);
                    break;
                case "11":
                    System.out.println("¿Qué palabra quiere buscar?");
                    tmpCadena = teclado.next();
                    miLista.BusquedaSimples(tmpCadena);

                    break;
                case "12":
                    System.out.println("¿Qué palabra quiere buscar?");
                    tmpCadena = teclado.next();
                    miLista.BusquedaAvanzada(tmpCadena);
                    System.out.println("<-PENDIENTE->");
                    break;
                case "13":
                    miLista.ConteoCategoria();
                    break;
                case "14":
                    System.out.println("¿Cómo quiere ordenar Las Categorias?");
                    System.out.println(""
                            + "1.	Ascendente \n"
                            + "2.	Descendente");
                    tmpNumero = teclado.nextInt();
                    miLista.OrdenarCategorias(tmpNumero);
                    break;
                case "15":
                    System.out.println("Cantidad de terminos Registrados: " + miLista.getCantidadDeTerminos());
                    break;
                case "s":
                    System.exit(0);
                    break;
                default:
                    break;
            }
            pausa();
        } while (true); //-- SEGUIRA HASTA QUE OPCION SEA IGUAL A 5

    }

    public static InfoPalabra PideDatosPalabra() {
        InfoPalabra Datos = new InfoPalabra();
        Scanner teclado = new Scanner(System.in);
        System.out.println("INTRODUZCA LOS DATOS");
        System.out.print("--Ingrese Palabra: ");
        Datos.setTermino(teclado.nextLine());
        System.out.print("--Ingrese Significado: ");
        Datos.setSignificado(teclado.nextLine());

        return Datos;
    }

    public static void MeterPalabraN(TadListaDiccionario miLista, int cantidadInicial) {
        Random rnd = new Random();
        String[] arregloDeCategorias = {"aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg", "hhh"};
        InfoPalabra temp;
        int intLetra = 0;
        String cadenaTermino = "";
        String cadenaSignificado = "";
        for (int x = 1; x <= cantidadInicial; x++) {
            temp = new InfoPalabra();
            //aleatorio para el Termino de la palabra
            cadenaTermino = "";
            for (int i = 1; i <= 2; i++) {
                intLetra = (int) (Math.floor(Math.random() * 25 + 1)) + 97;
                cadenaTermino = cadenaTermino + (char) intLetra;
            }
            temp.setTermino(cadenaTermino);

            cadenaSignificado = "";
            for (int i = 1; i <= 11; i++) {
                intLetra = (int) (Math.floor(Math.random() * 25 + 1)) + 97;
                cadenaSignificado = cadenaSignificado + (char) intLetra;
            }
            temp.setSignificado(cadenaSignificado);
            miLista.IntertarPalabra(temp, arregloDeCategorias[rnd.nextInt(arregloDeCategorias.length)]);
        }
    }

    public static InfoCategoria PideCategoria() {
        InfoCategoria Datos1 = new InfoCategoria();
        Scanner teclado = new Scanner(System.in);
        System.out.print("--Ingrese Categoria: ");
        Datos1.setNombreCategoria(teclado.nextLine());
        return Datos1;
    }

    public static void MeterCategoriaN(TadListaDiccionario miLista, int cantidadInicial) {
        Random rnd = new Random();
        String[] arregloDeCategorias = {"aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg", "hhh"};
        int opcionCategoria = 0;
        InfoCategoria objtCategoria = new InfoCategoria();
//        miLista.IntertarPalabra(objPalabra);
        for (int i = 0; i < cantidadInicial; i++) {
            objtCategoria = new InfoCategoria();

            objtCategoria.setNombreCategoria(arregloDeCategorias[opcionCategoria]);
            miLista.IntertarCategoria(objtCategoria);
            opcionCategoria++;
            if (opcionCategoria >= arregloDeCategorias.length) {
                opcionCategoria = 0;
            }
        }

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

}
