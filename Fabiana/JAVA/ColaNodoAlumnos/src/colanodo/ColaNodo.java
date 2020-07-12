/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colanodo;

import java.util.Scanner;
import java.util.Random;

/**
 * @author Ricardo Rivera
 */
public class ColaNodo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Menu();
    }

    public static void Menu() {
        String opcion;
        Scanner teclado = new Scanner(System.in); //Creación de un objeto Scanner
        TipoInfo Dato = new TipoInfo();
        String tempString = "";
        int conteo = 0;

        int numeroCorrelativoAlumno = 40;

        String[] arregloDePeticiones = {"EH", "EC", "RN", "CA", "OT"};

        TadCola ColaEstu = new TadCola();
        MeterN(ColaEstu, numeroCorrelativoAlumno, arregloDePeticiones);
        do {
            agregarLineas(2);
            System.out.println("---------COLA DE DE ATENCIÓN----------");
            System.out.println("1. Nueva solicitud");
            System.out.println("2. Atender");
            System.out.println("3. Ver siguiente estudiante");
            System.out.println("4. Ver toda las solicitudes");
            System.out.println("5. Cantidad de estudiantes en cola ");
            System.out.println("6. Verificar solicitud por parte de algun Alumno segun ID");
            System.out.println("7. Verificar cuantas solicitudes hay (Segun tipo de Peticion)");
            System.out.println("s. Salir");
            System.out.println("-----------------------------------------");
            System.out.print("INGRESE LA OPCION [1 - 7]: ");
            opcion = teclado.next();
            opcion = opcion.toLowerCase();
            switch (opcion) {
                case "1":
                    numeroCorrelativoAlumno++;
                    Dato = PideDatos(arregloDePeticiones, ColaEstu);
                    ColaEstu.MeterP(Dato);
                    System.out.println("****Dato grabado****");
                    break;
                case "2":
                    if (ColaEstu.ColaVacia()) {
                        System.out.println("No hay datos en la cola");
                    } else {
                        System.out.println("Se ha realizados : " + RealizarPeticiones(ColaEstu, Dato, teclado) + " solicitudes de estudiantes");
                    }
                    System.out.println("****Datos que salió****");
                    break;
                case "3":
                    Dato = ColaEstu.verInicio();
                    if (Dato == null) {
                        System.out.println("No hay datos");
                    } else {
                        MostrarDato(Dato);
                    }
                    System.out.println("****Listo****");
                    break;
                case "4":
                    MostrarCola(ColaEstu);
                    System.out.println("****Listo****");
                    break;
                case "5":
                    conteo = ColaEstu.Contar();
                    System.out.println("La cantidad de estudiantes en cola son: " + conteo);
                    System.out.println("****Listo****");
                    break;
                case "6":
                    System.out.print("Ingrese el ID del Alumno a Buscar -> ");
                    tempString = teclado.next();
                    VerificarExistenciaSolictud(tempString, ColaEstu);
                    break;
                case "7":

                    System.out.print("Ingrese el tipo de solicitud que desea saber la cantidad pendientes a resolver");
                    tempString = SeleccionarSolicitud(teclado, arregloDePeticiones);
                    ContarSolicitudes(tempString, ColaEstu, arregloDePeticiones);

                    break;
                case "s":
                    System.exit(0);
                    break;
                default:
                    break;
            }
            pausa();
        } while (true); //-- SEGUIRA HASTA QUE OPCION SEA IGUAL A 5
    }//fin menu

    public static void MostrarCola(TadCola pCola) {
        TipoNodo aux;
        TipoInfo temp;
        int contar = 0;
        if (pCola.ColaVacia()) {
            System.out.println("No hay datos que mostrar!!!!!");
        } else {
            aux = pCola.getInicio();
            while (aux != null) {
                //código
                contar++;
                temp = aux.getInfo();
                if (contar < 10) {
                    System.out.println("0" + contar + ") Operacion:" + temp.getTipoDeOperacion() + " P:" + temp.getPrioridad() + " T:" + temp.getTicket() + " ID:" + temp.getID() + "---" + temp.getNombre());
                } else {
                    System.out.println(contar + ") Operacion:" + temp.getTipoDeOperacion() + " P:" + temp.getPrioridad() + " T:" + temp.getTicket() + " ID:" + temp.getID() + "---" + temp.getNombre());
                }
                aux = aux.getSig();
            }
        }
    }

    //Esta funcion verifica si existe algun operacion pendiente segun se el ID de algun Alumno
    public static Boolean VerificarExistenciaSolictud(String IDEstudiante, TadCola pCola) {
        TipoNodo aux;
        TipoInfo temp;

        aux = pCola.getInicio();
        while (aux != null) {
            temp = aux.getInfo();

            if (temp.getID().contains(IDEstudiante)) {
                if (temp.getTicket() == 0) {

                    return false;
                }
                System.out.println("Este Alumno todavia tienen alguna operacion pendiente");
                return true;
            }
            aux = aux.getSig();
        }

        return false;
    }

    public static TipoInfo PideDatos(String[] arregloDePeticiones, TadCola ColaEstu) {
        String tempString = "";
        TipoInfo Datos = new TipoInfo();
        Scanner teclado = new Scanner(System.in);
        System.out.println("INTRODUZCA LOS DATOS");
        System.out.print("--ID: ");
        do {
            tempString = teclado.nextLine();
            Datos.setID(tempString);

            //Este ciclo Do{}While() se estara ejecutando hasta que se ingrese un ID diferente a los ya ingresados
        } while (VerificarExistenciaSolictud(tempString, ColaEstu));

        System.out.print("--Nombre: ");
        Datos.setNombre(teclado.nextLine());
//  
        Datos.setTipoDeOperacion(SeleccionarSolicitud(teclado, arregloDePeticiones));
//  
        System.out.print("--Prioridad: ");
        Datos.setPrioridad(teclado.nextInt());
        return Datos;
    }

    public static String SeleccionarSolicitud(Scanner teclado, String[] arregloDePeticiones) {
        String opcionSeleccionada = "OT";
        int solicitudSeleccionada = 0;

        do {

            System.out.println("1. Emisión historial\n"
                    + "2. Emisión certificación\n"
                    + "3. Reclamos por nota\n"
                    + "4. Cancelación de asignatura\n"
                    + "5. Otros \n"
                    + " ");

            System.out.print("-> ");
            solicitudSeleccionada = teclado.nextInt();
            if (solicitudSeleccionada < 1 || solicitudSeleccionada > 5) {
                System.out.println("No se ha seleccionado una opcion valida");
            }

        } while (solicitudSeleccionada < 1 || solicitudSeleccionada > 5);

        opcionSeleccionada = arregloDePeticiones[solicitudSeleccionada - 1];
        return opcionSeleccionada;
    }

    public static void MostrarDato(TipoInfo tmpDato) {
        if (tmpDato == null) {
            System.out.println("----> LA COLA ESTA VACIA <----");
        } else {
            System.out.println("Ticket:" + tmpDato.getTicket());
            System.out.println("ID:" + tmpDato.getID());
            System.out.println("Nombre:" + tmpDato.getNombre());
        }
    }

    //otros métodos
    public final static void agregarLineas(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println();
        }
    }

    public final static void pausa() {
        System.out.print("Presione Entrar(Enter)...");
        new java.util.Scanner(System.in).nextLine();
    }

    public static void MeterN(TadCola pCola, int pTotal, String[] arregloDePeticiones) {
        TipoInfo temp;
        int x = 0;

        Random rnd = new Random();
        int prioridad = 0;
        for (x = 1; x <= pTotal; x++) {

            temp = new TipoInfo();
            temp.setID(String.valueOf(rnd.nextInt(8999) + 1000));
            temp.setNombre("E" + String.valueOf(rnd.nextInt(9000) + 1000));
            temp.setTipoDeOperacion(arregloDePeticiones[rnd.nextInt(5)]);
            prioridad = (int) (Math.floor(Math.random() * 5 + 1));

            temp.setPrioridad(prioridad);
            pCola.MeterP(temp);
        }
    }

    public static int ContarSolicitudes(String inicalesDeSolicitud, TadCola pCola, String[] arregloDePeticiones) {
//        1. Emisión historial = 1000
//2. Emisión certificación     = 2000
//3. Reclamos por nota         = 3000
//4. Cancelación de asignatura = 4000
//5. Otros (en este caso se debe de pedir que otro trámite desea)

        int solicitudesEncontradas = 0;
        String peticionAMostrar = "";
        switch (inicalesDeSolicitud) {
            case "OT":
                peticionAMostrar = "Otros";
                break;
            case "EC":
                peticionAMostrar = "Emisión certificación";
                break;
            case "RN":
                peticionAMostrar = "Reclamos por nota";
                break;
            case "CA":
                peticionAMostrar = "Cancelación de asignatura";
                break;
            case "EH":
                peticionAMostrar = "Emisión historial";
                break;
        }
        TipoNodo aux;
        TipoInfo temp;

        aux = pCola.getInicio();
        while (aux != null) {
            temp = aux.getInfo();
            // 0
            // arregloDePeticiones[numeroDeSolicitud] = EH
            // 1
            // arregloDePeticiones[numeroDeSolicitud] = EC
            // 2
            // arregloDePeticiones[numeroDeSolicitud] = RN
            // 3 
            // arregloDePeticiones[numeroDeSolicitud] = CA
            // 4
            // arregloDePeticiones[numeroDeSolicitud] = OT
            if (temp.getTipoDeOperacion().contains(inicalesDeSolicitud)) {
                solicitudesEncontradas++;
            }
            aux = aux.getSig();
        }
        System.out.println(peticionAMostrar + " ----- " + solicitudesEncontradas);
        return solicitudesEncontradas;
    }

    public static int RealizarPeticiones(TadCola ColaEstu, TipoInfo Dato, Scanner teclado) {
        char mantenerOperaciones = 's';
        int cantidadRealizadas = 0;
        do {
            System.out.println("\n¿Desea tramitar la siguitnete solicitud?\n"
                    + "s - Si\n"
                    + "n - No");
            mantenerOperaciones = teclado.next().charAt(0);
            if (mantenerOperaciones == 's' || mantenerOperaciones == 'S') {
                cantidadRealizadas++;
                Dato = ColaEstu.Sacar();
                
                System.out.println("\nSe ha realizado una solicitud con los siguientes datos: ");
                MostrarDato(Dato);
                Dato = ColaEstu.verInicio();
                System.out.println("\nEl siguiente tramite es: ");
                MostrarDato(Dato);
                pausa();

            } else {
                System.out.println("\nNo se realizara ninguna solicitud pendiente");
            }

        } while (mantenerOperaciones == 's' || mantenerOperaciones == 'S');
        return cantidadRealizadas;
    }

}
