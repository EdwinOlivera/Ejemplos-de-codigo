package listasimple;

import java.util.Random;
import java.util.Scanner;

public class ListaSimple {

    public static void main(String[] args) {
        Menu();
    }

    public static void Menu() {
        String opcion;
        Scanner teclado = new Scanner(System.in);
        TadListaSimple miLista = new TadListaSimple();
        TipoInfo Dato = new TipoInfo();
        int cantidadElementosInciales = 5;

        System.out.println("INTRODUCIENDO #" + cantidadElementosInciales + " DE DATOS AUTOMATICAMENTE");
        agregarLineas(1);
        for (int i = 0; i < cantidadElementosInciales; i++) {
            Dato = DatosAutomaticos();
            miLista.InsertarOrdenado(Dato);
        }

        String tmpCadena;
        do {
            agregarLineas(2);
            System.out.println("------------AGENDA------------");
            System.out.println("1. Nuevo ");
            System.out.println("2. Ver datos");
            System.out.println("3. Buscar ");
            System.out.println("4. Eliminar uno ");
            System.out.println("5. Eliminar varios ");
            System.out.println("6. Modificar ");
            System.out.println("7. Operaciones (Tarea Parte - 1)");
            System.out.println("11. Ver edades");

            System.out.println("s. Salir");
            System.out.println("-----------------------------------------");
            System.out.print("INGRESE LA OPCION [1 - 7, 11]: ");
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
                    tmpCadena = PideCadena("Identidad: ");
                    Dato = miLista.Buscar(tmpCadena);
                    if (Dato == null) {
                        System.out.println("Dato no existe");
                    } else {
                        System.out.println("Dato encontrado:" + Dato.getNombre());
                    }
                    pausa();
                case "4":
                    System.out.println("** pendiente **");
                    break;
                case "5":
                    System.out.println("** pendiente **");
                    break;
                case "6":
                    System.out.println("** pendiente **");
                    break;
                case "7":
                    MenuOperacion(miLista);
                    break;
                case "11":
                    miLista.MostrarEdades();
                    break;
                case "s":
                    System.exit(0);
                    break;
                default:
                    break;
            }
        } while (true); //-- SEGUIRA HASTA QUE OPCION SEA IGUAL A 7, 11
    }

    public static String MenuOperacion(TadListaSimple miLista) {
        String opcion;

        boolean Regresar = true;
        Scanner teclado = new Scanner(System.in); //Creación de un objeto Scanner
        float resultado = 0;
        do {
            System.out.println("------------OPERACIONES------------");
            System.out.println("1. Contar elementos");
            System.out.println("2. Máximo");
            System.out.println("3. Mínimo");
            System.out.println("4. Promedio");
            System.out.println("5. Mediana");
            System.out.println("r. regresar");
            System.out.println("-------------------------------------");
            System.out.print("INGRESE LA OPCION: ");
            opcion = teclado.next();
            opcion = opcion.toLowerCase();

            switch (opcion) {
                case "1":
                    resultado = miLista.operar("contar");
                    System.out.println("La cantidad de datos en la lista son: " + resultado);
                    pausa();
                    break;
                case "2":
                    resultado = miLista.operar("max");
                    System.out.println("La edad máxima en la lista es:" + resultado);
                    pausa();
                    break;
                case "3":
                    resultado = miLista.operar("min");
                    System.out.println("La edad mínima en la lista es:" + resultado);
                    pausa();
                    break;
                case "4":
                    resultado = miLista.operar("Promedio");
                    System.out.println("El promedio de las edades es:" + resultado);
                    pausa();
                    break;
                case "5":
                    resultado = miLista.operar("mediana");
                    System.out.println("La Meddiana de las edades es:" + resultado);
                    pausa();
                    break;
                case "r":
                    Regresar = false;
                    break;
                default:
                    break;
            }
        } while (Regresar); //-- SEGUIRA HASTA QUE OPCION SEA IGUAL A 5
        return opcion;
    }//fin MenuOperacionMat      

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

    public static TipoInfo DatosAutomaticos() {
        Random rnd = new Random();

        TipoInfo Datos = new TipoInfo();
        Datos.setIdentidad("ID" + rnd.nextInt(100) + 1);
        Datos.setNombre("N" + rnd.nextInt(100) + 1);

        Datos.setEdad(rnd.nextInt(65) + 1);
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

    private void MetodoPrincipal() {
        metodo1();
    }

    private void metodo1() {

    }
        private void metodo2() {

    }
            private void metodo3() {

    }
                private void metodo4() {

    }
                    private void metodo5() {

    }

    private int metodo6() {
        return 2;
    }

    private void MetodoPrincipal(int metodo2) {

    }

}
