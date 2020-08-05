/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colanodo;

import java.util.Calendar;
import java.util.GregorianCalendar;
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

        int numeroCorrelativoPersona = 40;

        String[] arregloDeEstado = {"Pendiente Auotorizacion Policial", "Pendiente Auotorizacion SINAGER", "APROBADO", "DENEGADO"};

        TadCola ColaEstu = new TadCola();
        MeterN(ColaEstu, numeroCorrelativoPersona, arregloDeEstado);
        do {
            agregarLineas(2);
            System.out.println("---------COLA DE DE ATENCIÓN----------");
            System.out.println("1. Agregar nueva Persona a la Cola");
            System.out.println("2. Atender ");
            System.out.println("3. Ver siguiente persona");
            System.out.println("4. Ver Datos de las peticiones de la Cola");
            System.out.println("5. Cantidad de personas en cola ");
            System.out.println("s. Salir");
            System.out.println("-----------------------------------------");
            System.out.print("INGRESE LA OPCION [1 - 5]: ");
            opcion = teclado.next();
            opcion = opcion.toLowerCase();
            switch (opcion) {
                case "1":
                    numeroCorrelativoPersona++;
                    Dato = PideDatos(arregloDeEstado, ColaEstu, numeroCorrelativoPersona);
                    ColaEstu.MeterP(Dato);
                    System.out.println("****Dato Registrados correctamente****");
                    break;
                case "2":
                    if (ColaEstu.ColaVacia()) {
                        System.out.println("No hay datos en la cola");
                    } else {
                        System.out.println("Se ha realizados : " + RealizarPeticiones(ColaEstu, Dato, teclado, arregloDeEstado) + " solicitudes de personas");
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
                    MostrarDatosCola(ColaEstu, arregloDeEstado);
                    System.out.println("****Listo****");
                    break;
                case "5":
                    conteo = ColaEstu.Contar();
                    System.out.println("La cantidad de personas en cola son: " + conteo);
                    System.out.println("****Listo****");
                    break;

                case "s":
                    System.exit(0);
                    break;
                default:
                    break;
            }
            pausa();
        } while (true);
    }//fin menu
//Ejercicio No. 1 del Examen
//Esta funcion La cantidad de Operacion en la cola

    public static void MostrarDatosCola(TadCola pCola, String[] arregloDeEstados) {
        TipoNodo aux;
        TipoInfo temp;
        int contadorAprobadas = 0;
        int contadorDenegadas = 0;
        int contadorPolicia = 0;
        int contadorSinager = 0;

        if (pCola.ColaVacia()) {
            System.out.println("No hay datos que mostrar!!!!!");
        } else {
            aux = pCola.getInicio();
            while (aux != null) {

                temp = aux.getInfo();
                if (temp.getEstadoDelTramite().equals(arregloDeEstados[0])) {
                    contadorPolicia++;
                }
                if (temp.getEstadoDelTramite().equals(arregloDeEstados[1])) {
                    contadorSinager++;
                }
                if (temp.getEstadoDelTramite().equals(arregloDeEstados[2])) {
                    contadorAprobadas++;
                }
                if (temp.getEstadoDelTramite().equals(arregloDeEstados[3])) {
                    contadorDenegadas++;
                }
                System.out.println("Pendientes de autorizar Policía\n" + contadorPolicia + "Pendientes de autorizar SINAGER\n" + contadorSinager + "Aprobadas\n" + contadorAprobadas + "Rechazadas\n" + contadorDenegadas
                        + "Total general: " + (contadorAprobadas + contadorPolicia + contadorSinager + contadorDenegadas));
                aux = aux.getSig();
            }
        }
    }

    //Ejercicio No. 1 del Examen
    //Esta funcion verifica si existe alguna persona registrada
    //Recibe como paremetro el ID de la persona a registra y la cola de las Personas
    public static Boolean VerificarExistenciaSolictud(String IDPersona, TadCola pCola) {
        TipoNodo aux;
        TipoInfo temp;

        aux = pCola.getInicio();
        while (aux != null) {
            temp = aux.getInfo();

            if (temp.getID().contains(IDPersona)) {
                if (temp.getTicket() == 0) {

                    return false;
                }
                System.out.println("Esta persona ya esta registrada con este ID");
                return true;
            }
            aux = aux.getSig();
        }

        return false;
    }

    //Ejercicio No. 1 del Examen
    //Esta funcion es la encargada de registrar a las personas
    public static TipoInfo PideDatos(String[] arregloDeEstado, TadCola ColaEstu, int numeroCorrelativoPersona) {

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
        Datos.setNumeroCorrelativo(numeroCorrelativoPersona);
        Datos.setEstadoDelTramite(arregloDeEstado[0]);
        System.out.print("--Nombre: ");
        Datos.setNombre(teclado.nextLine());

        Datos.setEmpresa(IngresarEmpresa(teclado));

        System.out.print("--Rubro de la empresa: ");
        tempString = teclado.next();

        Datos.setRubro(tempString);

        System.out.println("-- Descripcion: ");
        tempString = teclado.next();

        Datos.setDescripcion(tempString);
        return Datos;
    }

    //Ejercicio No. 1 del Examen
    //Esta funcion registra la empresa de la persona
    public static String IngresarEmpresa(Scanner teclado) {
        System.out.println("Ingrese el nombre de la empresa");
        String opcionSeleccionada = "Olivera";
        opcionSeleccionada = teclado.next();
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

//        Random rnd = new Random();
//        int prioridad = 0;
//        for (x = 1; x <= pTotal; x++) {
//
//            temp = new TipoInfo();
//            temp.setID(String.valueOf(rnd.nextInt(8999) + 1000));
//            temp.setNombre("E" + String.valueOf(rnd.nextInt(9000) + 1000));
//            temp.setTipoDeOperacion(arregloDePeticiones[rnd.nextInt(5)]);
//            prioridad = (int) (Math.floor(Math.random() * 5 + 1));
//
//            temp.setPrioridad(prioridad);
//            pCola.MeterP(temp);
//        }
    }

    public static int ContarSolicitudes(String inicalesDeSolicitud, TadCola pCola, String[] arregloDePeticiones) {

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

    public static int RealizarPeticiones(TadCola ColaGeneral, TipoInfo Dato, Scanner teclado, String[] arregloDeEstado) {
        char mantenerOperaciones = 's';
        int cantidadRealizadas = 0;
        final String tramitePolcia = arregloDeEstado[0];
        do {
            System.out.println("\n¿Desea tramitar la siguitnete solicitud?\n"
                    + "s - Si\n"
                    + "n - No");
            mantenerOperaciones = teclado.next().charAt(0);
            if (mantenerOperaciones == 's' || mantenerOperaciones == 'S') {
                TipoNodo aux;
                TipoInfo temp;

                aux = ColaGeneral.getInicio();
                while (aux != null) {
                    temp = aux.getInfo();
                    //        String[] arregloDeEstado = {"Pendiente Auotorizacion Policial", "Pendiente Auotorizacion SINAGER", "APROBADO", "DENEGADO"};
                    switch (temp.getEstadoDelTramite()) {
                        case "Pendiente Auotorizacion Policial":
                            System.out.println("La persona actualmente necesita la aprovacion de la Policia en su salvaconducto");
                            Atendender("Policia", temp, arregloDeEstado);
                            break;
                        case "Pendiente Auotorizacion SINAGER":
                            System.out.println("La persona actualmente necesita la aprovacion de SINAGER en su salvaconducto");

                            Atendender("Sinager", temp, arregloDeEstado);
                            break;
                        case "APROBADO":
                            Atendender("Aprobado", temp, arregloDeEstado);
                            break;
                        case "DENEGADO":
                            Atendender("Denegado", temp, arregloDeEstado);
                            break;

                    }
                    aux = aux.getSig();
                }

                cantidadRealizadas++;

                Dato = ColaGeneral.Sacar();
                MostrarDato(Dato);
                pausa();

            } else {
                System.out.println("\nNo se realizara ninguna solicitud pendiente");
            }

        } while (mantenerOperaciones == 's' || mantenerOperaciones == 'S');
        return cantidadRealizadas;
    }

    private static void Atendender(String EstadoTramite, TipoInfo temp, String[] arregloDeEstado) {

        int SeguirTramite = 0;
        Scanner teclado = new Scanner(System.in);
        String tramiteSiguiente = "";
        do {

            if (SeguirTramite > 0) {
                System.out.println("¿Seguir el tramite con Sinager?");
                System.out.println("S - Continuar");
                System.out.println("Cualquier otra tecla - Declinar");
                tramiteSiguiente = teclado.next();
                if (tramiteSiguiente.equals("S")) {
                    EstadoTramite = "Sinager";
                }
            }
            switch (EstadoTramite) {
                case "Policia":
                    System.out.println("Se aprobo la peticion por parte de la policia");
                    SeguirTramite++;
                    break;
                case "Sinager":
                    break;
                case "Aceptado":
                    break;
                case "Denegado":
                    break;
            }
        } while (SeguirTramite < 3);
    }

}
