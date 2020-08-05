package pilaarreglo;
import java.util.Scanner;

public class PilaArreglo {

    public static void main(String[] args) {
        Menu();
    }

    
   public static void Menu() {
        String opcion;
        Scanner teclado = new Scanner(System.in); //Creación de un objeto Scanner
        TipoInfo Dato = new TipoInfo();
        TadPila Parqueo;
        int MaxAutos = 10;
        Parqueo = new TadPila(MaxAutos);
        int tmpPos;
        
        //cuando queremos llenar datos de prueba (quitarlos si no lo ocupan)
        //Dato = new TipoInfo(); Dato.setPlaca("A"); Dato.setApartamento(1); Parqueo.Meter(Dato); 
        //Dato = new TipoInfo(); Dato.setPlaca("B"); Dato.setApartamento(2); Parqueo.Meter(Dato); 
        //Dato = new TipoInfo(); Dato.setPlaca("C"); Dato.setApartamento(3); Parqueo.Meter(Dato); 
        
        do {
            agregarLineas(2);
            System.out.println("---------PILA (PARQUEO)----------");
            System.out.println("1. Meter");
            System.out.println("2. Sacar");
            System.out.println("3. Mostrar Pila");
            System.out.println("4. Ver posición carro");
            System.out.println("5. Cantidad de espacios disponibles -- TAREA EJ1");
            System.out.println("6. Sacar un carro específico (por placa)-- TAREA EJ2");
            System.out.println("7. Sacar X carro -- TAREA EJ3");
            System.out.println("s. Salir");
            System.out.println("-----------------------------------------");
            System.out.print("INGRESE LA OPCION [1 - 5]: ");
            opcion = teclado.next();
            opcion=opcion.toLowerCase();
            switch (opcion) {
                case "1":
                    Dato = PideDatos();
                    Parqueo.Meter(Dato);
                    break;
                case "2":
                    Dato = Parqueo.Sacar();
                    MostrarDato(Dato);
                    break;
                case "3":
                    Parqueo.Mostrar();
                    pausa();
                    break;
                case "4":
                    tmpPos=Parqueo.Posicion(PidePlaca());
                    if (tmpPos==0){
                        System.out.println("Carro no está en el parqueo");
                    }else{
                        System.out.println("Posición: "+tmpPos);
                    }
                    pausa();
                    break;
                case "5":
                    System.out.println("***Pendiente***");
                    pausa();
                    break;
                case "6":
                    System.out.println("***Pendiente***");
                    pausa();
                    break;
                case "7":
                    System.out.println("***Pendiente***");
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

   //métodos para comunicación con el usuario
    public static TipoInfo PideDatos() {
        TipoInfo Datos = new TipoInfo();
        Scanner teclado = new Scanner(System.in);
        System.out.println("INTRODUZCA LOS DATOS");
        System.out.print("--Placa: ");
        Datos.setPlaca(teclado.nextLine());
        System.out.print("--No. apartanto: ");
        Datos.setApartamento(teclado.nextInt());
        pausa();
        return Datos;
    }
    
    public static String PidePlaca() {
        String tmpPlaca;
        Scanner teclado = new Scanner(System.in);
        System.out.println("INTRODUZCA LOS DATOS");
        System.out.print("--Placa: ");
        tmpPlaca =teclado.nextLine();
        return tmpPlaca;
    }

    public static void MostrarDato(TipoInfo tmpDato) {
        if (tmpDato == null) {
            System.out.println("----> NO HAY DATOS QUE SACAR <----");
        } else {
            System.out.println("----> DATO QUE SALIÓ <----");
            System.out.println("Placa:" + tmpDato.getPlaca());
            System.out.println("Apartamento:" + tmpDato.getApartamento() );
        }
        pausa();
    }  
    
    //otros métodos
    public final static void pausa(){
        System.out.print("Presione ENTER para continuar...");
        new java.util.Scanner(System.in).nextLine();
    }
    
    public final static void agregarLineas(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println();
        }
    }    
}
