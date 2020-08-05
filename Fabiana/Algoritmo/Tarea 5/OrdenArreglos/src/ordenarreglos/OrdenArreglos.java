package ordenarreglos;
import java.util.Scanner;

/**
 * @author Ricardo Rivera
 */
public class OrdenArreglos {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in); //Creación de un objeto Scanner
        int numero = 0, x = 0;
        int cantidad = 0;
        
        cantidad=PideEntero("Cantidad de datos a generar: ");
        agregarLineas(2);
        
        int[] ArrOrig = new int[cantidad];
        int[] ArrQuickSort= new int[cantidad];
        int[] ArrBurbuja= new int[cantidad];

        //llenar con datos de prueba
        for (x = 0; x < cantidad; x++) {
            //aleatorio para la edad
            numero = (int) (Math.floor(Math.random() * 98 + 1)) + 1;
            ArrOrig[x] = numero;
            ArrQuickSort[x] = numero;
            ArrBurbuja[x] = numero;
        }

        //mostrar Original
        System.out.println("Datos Originales");
        for (x = 0; x < cantidad; x++) {
            System.out.print(ArrOrig[x] + " ");
        }
        agregarLineas(2);

        //mostrar Arreglo Burbuja
        System.out.println("Burbuja");
        cBurbuja ordenb = new cBurbuja();
        ordenb.o_burbuja(ArrBurbuja);
        for (x = 0; x < cantidad; x++) {
            System.out.print(ArrBurbuja[x] + " ");
        }
        agregarLineas(2);

        //mostrar QS
        System.out.println("Quick Sort");
        cQuickSort qs = new cQuickSort();
        qs.QuickSort(ArrQuickSort, 0, ArrQuickSort.length-1);
        for (x = 0; x < cantidad; x++) {
            System.out.print(ArrQuickSort[x] + " ");
        }
        agregarLineas(3);

    }//fin main




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

}
