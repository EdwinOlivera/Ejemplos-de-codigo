package ppal;

import java.util.Scanner;
import listaDoble.ListaDoble;

public class Main {
    
    private static ListaDoble lista = new ListaDoble();
    
    public static void main(String[] args) {
        
        leerLista();
        
        System.out.println("La lista leída de izquierda a derecha es...");
        lista.imprimirDeIzqAder();
        
        System.out.println("La lista leída de derecha a izquierda es...");
        lista.imprimirDeDerAizq();
        
        lista.elimiarRepetidos();
        
        System.out.println("Después de borrar los elementos repetidos es...");
        
        System.out.println("La lista de izquierda a derecha es...");
        lista.imprimirDeIzqAder();
        
        System.out.println("La lista de derecha a izquierda es...");
        lista.imprimirDeDerAizq();
        
    }
    
    private static void leerLista() {
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Entre el número de elementos de la lista: ");
        int n = entrada.nextInt();
        
        for (int i = 0; i < n; i++) {
            System.out.print("Entre el elemento " + i + " de la lista: ");
            int elemento = entrada.nextInt();
            lista.agregarAlFinal(elemento);
        }
    }
}
