/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenarreglos;

/**
 *
 * @author Ricardo Rivera
 */
public class cQuickSort {

    public void QuickSort(int[] arreglo, int izquierda, int derecha) {
        int pos;
        if (izquierda<derecha){
            pos=this.posicionParticion(arreglo, izquierda, derecha);
            QuickSort(arreglo, izquierda, pos);
            QuickSort(arreglo, pos+1, derecha);
        }

    }

    private int posicionParticion(int[] arreglo, int izq, int der) {
        int pivote;
        int tempo;
        pivote = arreglo[izq];
        while (true) {
            while (arreglo[izq] < pivote) {
                izq++;
            }
            while (arreglo[der] > pivote) {
                der--;
            }

            //fin del ciclo
            if (izq >= der) {
                return der;
            }

            //intercambiar
            tempo = arreglo[izq];
            arreglo[izq] = arreglo[der];
            arreglo[der] = tempo;
            
            //mover
            izq++;
            der--;
            
        }
    }
}
