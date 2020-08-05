package mostrar_impares;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author yamap
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Numeros numero;
        Numeros numeroCuadrados;
        Scanner teclado = new Scanner(System.in);

        int cantidadDeNumerosIniciales = 100;

        PilaNum pilaNumeroNormales = new PilaNum(cantidadDeNumerosIniciales);
        PilaNum pilaNumerosPares = new PilaNum(cantidadDeNumerosIniciales);
        PilaNum pilaNumerosCuadraticos = new PilaNum(cantidadDeNumerosIniciales);

        int OpcionIngresada = -1;
        do {
            System.out.println(">>>>Escoja una opcion<<<<");
            System.out.println("1 - Ingresar los numeros aleatorios entre 1 y 100");
            System.out.println("2 - Sacar todos los numero primos en de la fila");
            System.out.println("3 - Mostrar los cuadrados de la Pila de numeros");
            System.out.println("0 - Salir");
            OpcionIngresada = teclado.nextInt();

            switch (OpcionIngresada) {
                case 1:
                    for (int i = 0; i < cantidadDeNumerosIniciales; i++) {
                        numero = new Numeros();
                        numeroCuadrados = new Numeros();

                        numero = IngresarNumerosAleatorio();
                        numeroCuadrados.setNumeroIngresado(numero.getNumeroIngresado() * numero.getNumeroIngresado());
                        pilaNumeroNormales.Meter(numero);
                        pilaNumerosCuadraticos.Meter(numeroCuadrados);
                    }
                    System.out.println("Se han ingresado " + cantidadDeNumerosIniciales + " de numeros en la Pila");
                    break;
                case 2:
                    OrdenarNumerosNoPrimos(pilaNumeroNormales, pilaNumerosPares, cantidadDeNumerosIniciales);
                    break;
                case 3:
                    if (pilaNumeroNormales.Vacia()) {
                        for (int i = 0; i < cantidadDeNumerosIniciales; i++) {
                            numero = new Numeros();
                            numeroCuadrados = new Numeros();

                            numero = IngresarNumerosAleatorio();
                            numeroCuadrados.setNumeroIngresado(numero.getNumeroIngresado() * numero.getNumeroIngresado());
                            pilaNumeroNormales.Meter(numero);
                            pilaNumerosCuadraticos.Meter(numeroCuadrados);
                        }
                        System.out.println("Se han ingresado " + cantidadDeNumerosIniciales + " de numeros en la Pila");
                    } else {
                        System.out.println("Pila Normal de los numeros Sin modificaciones");
                        pilaNumeroNormales.Mostrar();
                        System.out.println("Pila Normal de los numeros Elevados al cuadrado");
                        pilaNumerosCuadraticos.Mostrar();
                    }
                    break;
                case 0:
                    break;
            }

        } while (OpcionIngresada < 3 || OpcionIngresada > 0);

    }
    //Ejercicio No. 2 del Examen
    // Esta es la funcion encargada de mostrar los numeros no primos de la pila ingresada

    public static void OrdenarNumerosNoPrimos(PilaNum pilaNumeroNormales, PilaNum pilaNumerosPrimos, int cantidadDeNumerosIniciales) {
        Numeros objnumero;
        int numeroDivisible = 0;
        int numeroAnclado = -1;
        boolean NumeroNoPrimo = false;
        for (int j = 0; j < cantidadDeNumerosIniciales; j++) {
            numeroAnclado = pilaNumeroNormales.RetorNumeros(j);
            for (int i = 1; i < cantidadDeNumerosIniciales; i++) {
                if (numeroAnclado % i == 0) {

                    numeroDivisible++;
                }
                if (numeroDivisible > 2) {
                    NumeroNoPrimo = true;
                }
            }
            numeroDivisible = 0;
            if (!NumeroNoPrimo) {
                objnumero = new Numeros();
                objnumero.setNumeroIngresado(numeroAnclado);
                pilaNumerosPrimos.Meter(objnumero);
            }
            NumeroNoPrimo = false;
        }
        System.out.println();
        System.out.println("Pila de numeros normales (Primos y complejos)");
        pilaNumeroNormales.Mostrar();
        System.out.println("Pila solmente de numeros primos");
        pilaNumerosPrimos.Mostrar();

    }

    //Ejerciico No. 2 del Examen
    //Esta funcion retorna un numero aleatorio entre 0 y 100 cada vez que es llamada;
    public static Numeros IngresarNumerosAleatorio() {
        Numeros nuevosNumeros = new Numeros();
        Random rnd = new Random();
        int NumeroNuevoAleatorio;
        NumeroNuevoAleatorio = rnd.nextInt(99) + 1;
        nuevosNumeros.setNumeroIngresado(NumeroNuevoAleatorio);
        return nuevosNumeros;

    }

}
