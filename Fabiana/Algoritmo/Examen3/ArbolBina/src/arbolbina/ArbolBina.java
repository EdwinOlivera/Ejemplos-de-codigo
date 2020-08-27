package arbolbina;

import java.util.Scanner;

public class ArbolBina {

    public static void main(String[] args) {
        Menu();
    }

    
    public static void Menu() {
        String opcion;
        Scanner teclado = new Scanner(System.in); //Creación de un objeto Scanner
        TipoInfo Dato = new TipoInfo();
        String tmpCadena;
        int tmpNumero=0;
        TipoNodo Aux;
        
        TadAB ArbolBin = new TadAB();
        
        ///CreaArbolManual(ArbolBin);
        
        tmpNumero=PideEntero("Cuantos datos de prueba:");
        //llenar con datos de prueba
        MeterN(ArbolBin, tmpNumero);
        
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
            System.out.println("s. Salir");
            System.out.println("-----------------------------------------");
            System.out.print("INGRESE LA OPCION [1 - 5]: ");
            opcion = teclado.next();
            opcion = opcion.toLowerCase();
            switch (opcion) {
                case "1":
                    Dato = PideDatos();
                    ArbolBin.Insertar(Dato);
                    pausa();
                    break;
                case "2":
                    ArbolBin.Mostrar("pre");
                    pausa();
                    break;
                case "3":
                    ArbolBin.Mostrar("in");
                    pausa();
                    break;
                case "4":
                    ArbolBin.Mostrar("post");
                    pausa();
                    break;
                case "5":
                    tmpNumero=ArbolBin.Peso();
                    System.out.println("El perso del árbol es:" +tmpNumero);
                    pausa();
                    break;
                case "6":
                    tmpNumero=PideEntero("Número a buscar: ");
                    Aux = ArbolBin.Buscar(tmpNumero);
                    if (Aux==null){
                         System.out.println("Dato no encontrado");
                    }else{
                        System.out.println(Aux.getInfo().getPalabra()+" ("+Aux.getInfo().getNumero()+")");
                    }
                      pausa();
                    break;
                case "7":
                    tmpNumero=PideEntero("Número a Eliminar: ");
                    Aux = ArbolBin.Buscar(tmpNumero);
                    if (Aux==null){
                         System.out.println("Dato no encontrado");
                    }else{
                        System.out.println(Aux.getInfo().getPalabra()+" ("+Aux.getInfo().getNumero()+")");
                        ArbolBin.Eliminar(Aux);
                    }
                    System.out.println("--->Pendiente<---");

                    System.out.println("--->Pendiente<---");
                    pausa();
                    break;
                case "8":
                    System.out.println("Cantidas de nodos hojas del árbol es: "+ArbolBin.cantidadNodosHoja());
                    pausa();
                    break;
                case "9":
                    System.out.println("La altura del arbol es: "+ArbolBin.retornarAltura());
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
    
    

    public static void MeterN(TadAB pAB, int pTotal) {
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
    
        
    private static void CreaArbolManual(TadAB pAB) {
        TipoNodo N1 = new TipoNodo();
        TipoNodo N2 = new TipoNodo();
        TipoNodo N3 = new TipoNodo();
        TipoNodo N4 = new TipoNodo();
        TipoNodo N5 = new TipoNodo();
        TipoNodo N6 = new TipoNodo();
        TipoNodo N7 = new TipoNodo();
        TipoNodo N8 = new TipoNodo();
        TipoNodo N9 = new TipoNodo();
        
        pAB.setRaiz(N1);
        N1.setInfo(PreparaDatos("Tsunade", 1));
        N1.setIzq(N2);
        N1.setDer(N3);

        N2.setInfo(PreparaDatos("Kakashi", 2));
        N2.setIzq(N4);
        N2.setDer(N5);        

        N3.setInfo(PreparaDatos("Guy", 3));
        N3.setIzq(N6);
        N3.setDer(N7);  
        
        N4.setInfo(PreparaDatos("Naruto", 4));
        N4.setIzq(N8);

        N5.setInfo(PreparaDatos("Zakura", 5));

        N6.setInfo(PreparaDatos("Lee", 6));
        N6.setDer(N9);
        
        N7.setInfo(PreparaDatos("Tenten", 7));

        N8.setInfo(PreparaDatos("Voruto", 8));
        N9.setInfo(PreparaDatos("Metal Lee", 7));

        
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
    
    

}//fin clase

