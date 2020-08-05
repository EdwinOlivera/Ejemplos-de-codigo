package colanodo;

import java.util.Scanner;
import java.util.Random;

public class ColaNodo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Menu();
    }

    public static void Menu() {
        String opcion;
        Scanner teclado = new Scanner(System.in); //Creación de un objeto Scanner

        int cantidadInicial = 20;

        TadCola ColaNormal = new TadCola();
        TadCola ColaNormalInvertida = new TadCola();

        MeterN(ColaNormal, cantidadInicial);
        System.out.println("Se han ingresado " + cantidadInicial + " de elementos la Cola");
        do {
            agregarLineas(2);
            System.out.println("---------COLA DE DE ATENCIÓN A CLIENTES----------");
            System.out.println("1. Ver toda la Cola Normal");
            System.out.println("2. Invertir cola de cliente tipo Normal");

            System.out.println("s. Salir");
            System.out.println("-----------------------------------------");
            System.out.print("INGRESE LA OPCION [1 - 2]: ");
            opcion = teclado.next();
            opcion = opcion.toLowerCase();

            switch (opcion) {

                case "1":
                    MostrarCola(ColaNormal);
                    System.out.println("****Listo****");
                    break;
                case "2":

                    InverTirCola(ColaNormal, ColaNormalInvertida);
                    break;
                case "s":
                    System.exit(0);
                    break;
                default:
                    break;
            }
            pausa();
        } while (true); //-- SEGUIRA HASTA QUE OPCION SEA IGUAL A 5
    }//fin menu

    //Metodo encargado de hacer que una cola cualquiera se invierta de forma permanente
    //Recibe como parametro 2 elementos = La cola a invertir y una cola Temporal 
    public static void InverTirCola(TadCola colaRecibida, TadCola colaRecibidaAInvertir) {
        TipoNodo aux;
        TipoInfo temp;
        int contar = colaRecibida.CantidadElementos() + 1;
        int cantidadElementos = colaRecibida.CantidadElementos();
        TipoInfo Dato = new TipoInfo();

        //El siguiente ciclo FOR se encarga de vaciar la cola Temporal para su correcto uso
        cantidadElementos = colaRecibidaAInvertir.CantidadElementos();
        for (int elementoConteo = 0; elementoConteo < cantidadElementos; elementoConteo++) {
            colaRecibidaAInvertir.Sacar();

        }
        //Ciclo FOR encargado de revertir la lista recibida en esta funcion en una cola temporal
        for (int elementoConteo = colaRecibida.CantidadElementos() - 1; elementoConteo >= 0; elementoConteo--) {
            Dato = colaRecibida.RetornarElementoInversa(elementoConteo);
            colaRecibidaAInvertir.Meter(Dato);

        }

        //Con este ciclo se usa para limpiar la Cola Normal para ingresarle los datos en el orden inverso
        cantidadElementos = colaRecibida.CantidadElementos();
        for (int elementoConteo = 0; elementoConteo < cantidadElementos; elementoConteo++) {
            colaRecibida.Sacar();

        }
        cantidadElementos = colaRecibidaAInvertir.CantidadElementos();
        //Ciclo FOR encargado de revertir la lista recibida en la funcion
        for (int elementoConteo = 0; elementoConteo < cantidadElementos; elementoConteo++) {
            Dato = colaRecibidaAInvertir.RetornarElementoInversa(elementoConteo);
            colaRecibida.Meter(Dato);

        }

        if (colaRecibida.ColaVacia()) {
            System.out.println("No hay Clientes en la cola, por tanto no se Invirtio la Cola Normal!!!!!");
        } else {
            aux = colaRecibida.getInicio();
            System.out.println(">>>>>>>>>>>La Cola de cliente tipo Normal Invertida es: <<<<<<<<<<<");
            while (aux != null) {
                //código
                contar--;
                temp = aux.getInfo();
                if (contar < 10) {
                    System.out.println("0" + contar + ") " + " ID:" + temp.getID() + "---" + temp.getNombre());
                } else {
                    System.out.println(contar + ") " + " ID:" + temp.getID() + "---" + temp.getNombre());
                }
                aux = aux.getSig();
            }
        }
    }

    public static void MostrarCola(TadCola ColaNormal) {
        TipoNodo aux;
        TipoInfo temp;
        int contar = 0;

        agregarLineas(1);
        if (ColaNormal.ColaVacia()) {
            System.out.println("No hay Clientes de tipo Normal!!!!!");
        } else {
            aux = ColaNormal.getInicio();
            System.out.println(">>>>>>>>>>>Cola actual de clientes de Tipo Normal<<<<<<<<<<<");
            while (aux != null) {
                //código
                contar++;
                temp = aux.getInfo();
                if (contar < 10) {
                    System.out.println("0" + contar + ") " + " ID:" + temp.getID() + "---" + temp.getNombre());
                } else {
                    System.out.println(contar + ") " + " ID:" + temp.getID() + "---" + temp.getNombre());
                }
                aux = aux.getSig();
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
        System.out.print("Presione Entrar(Enter)...");
        new java.util.Scanner(System.in).nextLine();
    }

    public static void MeterN(TadCola ColaNormal, int pTotal) {
        TipoInfo temp;
        int x = 0;

        Random rnd = new Random();

        for (x = 1; x <= pTotal; x++) {
            temp = new TipoInfo();
            temp.setID(String.valueOf(rnd.nextInt(8999) + 1000));
            temp.setNombre("E" + String.valueOf(rnd.nextInt(8999) + 1000));

            ColaNormal.Meter(temp);

        }

    }

}
