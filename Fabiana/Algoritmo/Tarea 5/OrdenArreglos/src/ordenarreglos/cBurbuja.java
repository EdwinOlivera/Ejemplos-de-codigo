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
public class cBurbuja {
    
    public void o_burbuja(int[] arreglo){
        int i, j;
        int tempo;
        for (i = 0; i < arreglo.length - 1 ; i++) {
            for (j=i+1; j < arreglo.length; j++){
                if (arreglo[i]>arreglo[j]){
                    tempo=arreglo[i];
                    arreglo[i]=arreglo[j];
                    arreglo[j]=tempo;
                }
            }
        }
    }
    
}
