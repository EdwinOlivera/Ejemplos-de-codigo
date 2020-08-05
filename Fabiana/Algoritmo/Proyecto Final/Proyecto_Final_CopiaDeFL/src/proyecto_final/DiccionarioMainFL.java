package proyecto_final;

import java.util.Scanner;

public class DiccionarioMainFL {

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
        int cantidadInicial = 10;
        MeterNDePrueba(miLista, cantidadInicial);

        String tmpCadena;
        String tmpTermino;
        int tmpNumero = 0;

        //llenar con datos de prueba
        int cantidad = 0;

        do {
            agregarLineas(2);
            System.out.println("------------<> Menu Principal <>------------");
            System.out.println("--------------<><>------------------");
            System.out.println("<-----------> CRUD de Palabras <----------->");
            System.out.println("0. Meter conjunto de palabras");
            System.out.println("1. Ingresar Nueva Palabra");
            System.out.println("2. Ver Todas las palabras Registradas");
            System.out.println("3. Modificar Palabra");
            System.out.println("4. Eliminar palabra");
            System.out.println("<-----------> CRUD de Categoria <----------->");
            System.out.println("5. Ingresar Categoria nueva ");
            System.out.println("6. Eliminar Categoria ");
            System.out.println("7. Ver todas las Categorias ");
            System.out.println("8. Moidificar Categoria ");
            System.out.println("<-----------> REPORTES GENERALES(pendientes)<----------->");
            System.out.println("9. Ordenar Terminos (ascendente y descendentemente)");
            System.out.println("10. Ordenado de Categorio y termino (ascendente y descendentemente) ");
            System.out.println("11. Busqueda simple - palabra que comiencen de forma indica");
            System.out.println("12. Busqueda avanzada -  palabra que contenga los caracteres especificados");

            System.out.println("--------------<><>------------------");
            System.out.println("s. Salir");
            System.out.println("-----------------------------------------");
            System.out.print("INGRESE LA OPCION [1 - 11]: ");
            opcion = teclado.next();
            opcion = opcion.toLowerCase();
            switch (opcion) {
                case "0":
                    System.out.print("Cantidad de palabras a ingresar --> ");
                    tmpNumero = teclado.nextInt();
                    MeterPalabraN(miLista, tmpNumero);
                    pausa();
                    break;
                case "1":
                    Dato = PideDatosPalabra();
                    System.out.println("Ingrese la categoria a la cual pertenece la Palabra " + Dato.getTermino());
                    tmpCadena = teclado.next();
                    miLista.IntertarPalabra(Dato, tmpCadena);
                    pausa();
                    break;
                case "2":
                    miLista.MostrarPalabras();
                    pausa();
                    break;
                case "3":
                    System.out.print("Ingrese el nombre de la palabra a modificar ---> ");
                    tmpCadena = teclado.next();
                    miLista.ModificarLaPalabra(tmpCadena);
                    pausa();
                    break;
                case "4":
                    System.out.print("Ingrese la palabra a eliminar ---> ");
                    tmpTermino = teclado.next();
                    miLista.EliminarPalabra(tmpTermino);
                    pausa();
                    
                    break;
                case "5":
                    tmpCategoria = new InfoCategoria();
                    System.out.println("Ingrese la nueva categoria");
                    tmpCategoria.setNombreCategoria(teclado.next());
                    miLista.IntertarCategoria(tmpCategoria);
                    pausa();
                    break;
                case "6":

                    pausa();
                    break;
                case "7":
                    miLista.MostrarCategorias();
                    pausa();
                    break;
                case "8":
                    System.out.print("Ingrese el nombre de la categoria a modificar ---> ");
                    tmpCadena = teclado.next();
                    miLista.ModificarCategoria(tmpCadena);
                    pausa();
                    break;

                case "s":
                    System.exit(0);
                    break;
                default:
                    break;
            }
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

    public static void MeterPalabraN(TadListaDiccionario miLista, int pTotal) {
        InfoPalabra temp;
        int intLetra = 0;
        String cadenaTermino = "";
        String cadenaSignificado = "";
        for (int x = 1; x <= pTotal; x++) {
            temp = new InfoPalabra();
            //aleatorio para el Termino de la palabra
            cadenaTermino = "";
            for (int i = 1; i <= 5; i++) {
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
            miLista.IntertarPalabra(temp, "Algo4");
        }
    }

    public static InfoCategoria PideCategoria() {
        InfoCategoria Datos1 = new InfoCategoria();
        Scanner teclado = new Scanner(System.in);
        System.out.print("--Ingrese Categoria: ");
        Datos1.setNombreCategoria(teclado.nextLine());
        return Datos1;
    }

    public static void MeterNDePrueba(TadListaDiccionario miLista, int cantidadInicial) {

        Scanner teclado = new Scanner(System.in);

        int numeroCorrelativoPalabra = 0;

        InfoPalabra objPalabra = new InfoPalabra();
        InfoCategoria objtCategoria = new InfoCategoria();

        objtCategoria.setNombreCategoria("Algo");
        objPalabra.setCategoria(objtCategoria);

        numeroCorrelativoPalabra++;

        objPalabra.setNumeroCorrelativo(numeroCorrelativoPalabra);
        objPalabra.setSignificado("Algo importante");
        objPalabra.setTermino("Relevante");

//        miLista.IntertarPalabra(objPalabra);
        for (int i = 0; i < cantidadInicial; i++) {
            objtCategoria = new InfoCategoria();
            objtCategoria.setNombreCategoria("Algo" + i);
            miLista.IntertarCategoria(objtCategoria);
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
