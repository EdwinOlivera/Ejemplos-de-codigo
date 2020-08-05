
package mostrar_impares;

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
        int cantidadDeNumeros = 10;
        int numeroIngresado;
        
        PilaNum pilaNumero = new PilaNum(cantidadDeNumeros);
        Scanner teclado = new Scanner(System.in);
        
        
        System.out.println("Ingrese " + cantidadDeNumeros + " numeros");
        for (int i = 0; i < cantidadDeNumeros; i++) {
            System.out.print("#" + (i + 1) + " -> ");
            numeroIngresado = teclado.nextInt();

            numero = new Numeros();
            numero.setNumeroIngresado(numeroIngresado);
            pilaNumero.Meter(numero);
        }

        pilaNumero.Mostrar();

    }

}
