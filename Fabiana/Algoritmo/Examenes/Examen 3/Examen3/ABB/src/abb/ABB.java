
package abb;

import java.util.Scanner;

/**
 *
 * @author Ricardo Rivera
 */
public class ABB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Menu();
    }

    public static void Menu() {
        String opcion;
        Scanner teclado = new Scanner(System.in); //Creación de un objeto Scanner
        TipoInfo Dato = new TipoInfo();
        String tmpCadena;
        int tmpNumero=0;
        TipoNodo Aux;
        
        TadABB ArbolBinBusq = new TadABB();
        
        CreaArbolManual(ArbolBinBusq);
        
        do {
            agregarLineas(2);
            System.out.println("------------ARBOL BINARIO------------");
            System.out.println("1. Nuevo ");
            System.out.println("2. Pre-Orden");
            System.out.println("3. In-Orden");
            System.out.println("4. Post-Orden");
            System.out.println("5. Peso ");
            System.out.println("6. Buscar ");
            System.out.println("7. Eliminar");
            System.out.println("**TAREA***");
            System.out.println("8. Nodos hojas del árbol");
            System.out.println("9. Altura del árbol");
            System.out.println("10. Balancear árbol");
            System.out.println("s. Salir");
            System.out.println("-----------------------------------------");
            System.out.print("INGRESE LA OPCION [1 - 5]: ");
            opcion = teclado.next();
            opcion = opcion.toLowerCase();
            switch (opcion) {
                case "1":
                    Dato = PideDatos();
                    ArbolBinBusq.Insertar(Dato);
                    pausa();
                    break;
                case "2":
                    ArbolBinBusq.Mostrar("pre");
                    pausa();
                    break;
                case "3":
                    ArbolBinBusq.Mostrar("in");
                    pausa();
                    break;
                case "4":
                    ArbolBinBusq.Mostrar("post");
                    pausa();
                    break;
                case "5":
                    tmpNumero=ArbolBinBusq.Peso();
                    System.out.println("El perso del árbol es:" +tmpNumero);
                    pausa();
                    break;
                case "6":
                    tmpNumero=PideEntero("Número a buscar: ");
                    Aux = ArbolBinBusq.Buscar(tmpNumero);
                    if (Aux==null){
                         System.out.println("Dato no encontrado");
                    }else{
                        System.out.println(Aux.getInfo().getPalabra()+" ("+Aux.getInfo().getNumero()+")");
                    }
                    System.out.println("--->Pendiente<---");
                    pausa();
                    break;
                case "7":
                    tmpNumero=PideEntero("Número a Eliminar: ");
                    Aux = ArbolBinBusq.Buscar(tmpNumero);
                    if (Aux==null){
                         System.out.println("Dato no encontrado");
                    }else{
                        System.out.println(Aux.getInfo().getPalabra()+" ("+Aux.getInfo().getNumero()+")");
                        ArbolBinBusq.Eliminar(Aux);
                    }
                    pausa();
                    break;
                case "8":
                    System.out.println("Cantidas de nodos hojas del árbol es: "+ArbolBinBusq.cantidadNodosHoja());
                    pausa();
                    break;
                case "9":
                    System.out.println("La altura del arbol es: "+ArbolBinBusq.retornarAltura());
                    pausa();
                    break;
                case "10":
                    System.out.println("Balance");
                    ArbolBinBusq.imprimirBalance();
                    pausa();
                    break;
                case "s":
                    System.exit(0);
                    break;
                default:
                    break;
            }
        } while (true); //-- SEGUIRA HASTA QUE OPCION SEA IGUAL A 5
    }//fin menu
    
    

    public static void MeterN(TadABB pAB, int pTotal) {
        TipoInfo temp;
        char data = ' ';
        String cadena = "";
        for (int x = 1; x <= pTotal; x++) {
            temp = new TipoInfo();
            //aleatorio para el ID
            cadena = "D" + x;
            temp.setPalabra(cadena);
            temp.setNumero(x);
            pAB.Insertar(temp);
        }
    };    
    
        
    private static void CreaArbolManual(TadABB pABB) {
        TipoNodo N1 = new TipoNodo();
        TipoNodo N2 = new TipoNodo();
        TipoNodo N3 = new TipoNodo();
        TipoNodo N4 = new TipoNodo();
        TipoNodo N5 = new TipoNodo();
        TipoNodo N6 = new TipoNodo();
        TipoNodo N7 = new TipoNodo();
        TipoNodo N8 = new TipoNodo();
        TipoNodo N9 = new TipoNodo();
        TipoNodo N10 = new TipoNodo();
        TipoNodo N11 = new TipoNodo();
        
        pABB.setRaiz(N1);
        N1.setInfo(PreparaDatos("V", 12));
        N1.setIzq(N2);
        N1.setDer(N3);

        N2.setInfo(PreparaDatos("V", 5));
        N2.setIzq(N4);
        N2.setDer(N5);        

        N3.setInfo(PreparaDatos("V", 25));
        N3.setIzq(N6);
        N3.setDer(N7);  
        
        
        N4.setInfo(PreparaDatos("V", 3));
        N4.setIzq(N8);

        N5.setInfo(PreparaDatos("V", 8));

        N6.setInfo(PreparaDatos("V", 20));
        N6.setIzq(N9);
        N6.setDer(N10);  
        
        N7.setInfo(PreparaDatos("V", 55));
        N7.setDer(N11);  

        N8.setInfo(PreparaDatos("V", 1));
        N9.setInfo(PreparaDatos("V", 18));
        N10.setInfo(PreparaDatos("V", 23));
        N11.setInfo(PreparaDatos("V", 60));

        System.out.println("Arbol temporal creado!!!!");
    }

    private static TipoInfo PreparaDatos(String pTexto, int pNum) {
        TipoInfo Datos = new TipoInfo();
        Datos.setPalabra(pTexto);
        Datos.setNumero(pNum);
        return Datos;
    }
    
    //otros métodos
    public static TipoInfo PideDatos() {
        TipoInfo Datos = new TipoInfo();
        Scanner teclado = new Scanner(System.in);
        System.out.println("INTRODUZCA LOS DATOS");
        System.out.print("--Texto: ");
        Datos.setPalabra(teclado.nextLine());
        System.out.print("--Numero: ");
        Datos.setNumero(teclado.nextInt());
        return Datos;
    }
    
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
