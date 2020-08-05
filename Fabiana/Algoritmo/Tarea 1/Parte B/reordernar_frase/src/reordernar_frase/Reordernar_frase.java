package reordernar_frase;

import java.util.Scanner;

/**
 *
 * @author yamap
 */
public class Reordernar_frase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        String oracionIngresada = "";
        String palabraTemporal = "";
        char oracionCopiada[];
        int pos;
        int indiceDePalabr = 0;
        
        
        System.out.println("Ingrese una oracion");
        oracionIngresada = teclado.nextLine();

        //Convertir el String en char
        oracionCopiada = oracionIngresada.toCharArray();

        LinkedList lista = new LinkedList(contarPalabras(oracionIngresada));

        oracionIngresada = oracionIngresada.trim();

        pos = oracionIngresada.indexOf(" ");

        while (pos != -1) {
            for (int j = indiceDePalabr; j < pos; j++) {
                palabraTemporal += oracionCopiada[j];
            }
            Palabra objPalabra = new Palabra();

            objPalabra.setPalbraAlmacenada(palabraTemporal);
            lista.Meter(objPalabra);
            palabraTemporal = "";
            indiceDePalabr = pos + 1;

            pos = oracionIngresada.indexOf(" ", pos + 1);
        }
        
        
        for (int i = indiceDePalabr; i < oracionIngresada.length(); i++) {
            palabraTemporal += oracionCopiada[i];
        }
        Palabra objPalabra = new Palabra();

        objPalabra.setPalbraAlmacenada(palabraTemporal);
        lista.Meter(objPalabra);
        lista.Mostrar();
    }

    public static int contarPalabras(String s) {
        int contador = 1, pos;
        s = s.trim();
        if (s.isEmpty()) {
            contador = 0;
        } else {
            pos = s.indexOf(" ");
            while (pos != -1) {
                contador++;
                pos = s.indexOf(" ", pos + 1);
            }
        }
        return contador;
    }

}
