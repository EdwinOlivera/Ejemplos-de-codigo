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

        int numeroCorrelativoCliente = 40;

        String[] arregloTipoCliente = {"Normal", "Priodidad"};

        TadCola ColaNormal = new TadCola();
        TadCola ColaPrioridad = new TadCola();

        MeterN(ColaNormal, ColaPrioridad, numeroCorrelativoCliente, arregloTipoCliente);

        do {
            agregarLineas(2);
            System.out.println("---------COLA DE DE ATENCIÓN A CLIENTES----------");
            System.out.println("1. Nueva solicitud");
            System.out.println("2. Atender");
            System.out.println("3. Ver siguiente cliente");
            System.out.println("4. Ver toda las solicitudes");

            System.out.println("s. Salir");
            System.out.println("-----------------------------------------");
            System.out.print("INGRESE LA OPCION [1 - 7]: ");
            opcion = teclado.next();
            opcion = opcion.toLowerCase();

            switch (opcion) {
                case "1":
                    Dato = PideDatos();
                    if (Dato.getPrioridad() == 1) {
                        ColaPrioridad.Meter(Dato);
                    } else {
                        ColaNormal.Meter(Dato);
                    }

                    System.out.println("**** Dato grabado ****");
                    break;
                case "2":
                    if (ColaNormal.ColaVacia() && ColaPrioridad.ColaVacia()) {
                        System.out.println("No hay datos en la Cola de clientes Normal y tampoco en el de Prioridades");

                    } else if (ColaPrioridad.ColaVacia()) {
                        System.out.println("No hay datos en la Cola de clientes de Prioridad");
                        System.out.println("Se ha realizados : " + RealizarPeticionesNormal(ColaNormal, Dato, teclado) + " solicitudes de estudiantes");

                    } else if (ColaNormal.ColaVacia()) {
                        System.out.println("No hay datos en la Cola de clientes Normales");

                        System.out.println("Se ha realizados : " + RealizarPeticionesPrioridad(ColaPrioridad, Dato, teclado) + " solicitudes de estudiantes");

                    } else {
                        System.out.println("Se ha realizados : " + RealizarPeticionesGenerales(ColaNormal, ColaPrioridad, Dato, teclado) + " solicitudes de estudiantes");
                    }
                    System.out.println("****Datos que salió****");
                    break;
                case "3":
                    Dato = ColaNormal.verInicio();
                    if (Dato == null) {
                        System.out.println("No hay datos");
                    } else {
                        System.out.println("El siguiente cliente normal es: ");
                        MostrarDato(Dato);
                    }

                    Dato = ColaPrioridad.verInicio();
                    if (Dato == null) {
                        System.out.println("No hay datos");
                    } else {
                        System.out.println("El siguiente cliente de Prioridad es: ");
                        MostrarDato(Dato);
                    }
                    System.out.println("****Listo****");
                    break;
                case "4":
                    MostrarCola(ColaNormal, ColaPrioridad);
                    System.out.println("****Listo****");
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

    public static void MostrarCola(TadCola ColaNormal, TadCola ColaPrioridad) {
        TipoNodo aux;
        TipoInfo temp;
        int contar = 0;
        if (ColaPrioridad.ColaVacia()) {
            System.out.println("No hay datos que mostrar!!!!!");
        } else {
            aux = ColaPrioridad.getInicio();
            System.out.println(">>>>>>>>>>>Cola actual de clientes de Tipo Prioridad<<<<<<<<<<<");

            while (aux != null) {
                //código
                contar++;
                temp = aux.getInfo();
                if (contar < 10) {
                    System.out.println("0" + contar + ") Tipo de cliente:" + temp.getCondicion() + " P:" + temp.getPrioridad() + " T:" + temp.getTicket() + " ID:" + temp.getID() + "---" + temp.getNombre());
                } else {
                    System.out.println(contar + ") Tipo de cliente:" + temp.getCondicion() + " P:" + temp.getPrioridad() + " T:" + temp.getTicket() + " ID:" + temp.getID() + "---" + temp.getNombre());
                }
                aux = aux.getSig();
            }
        }
        agregarLineas(1);
        if (ColaNormal.ColaVacia()) {
            System.out.println("No hay datos que mostrar!!!!!");
        } else {
            aux = ColaNormal.getInicio();
            System.out.println(">>>>>>>>>>>Cola actual de clientes de Tipo Normal<<<<<<<<<<<");
            while (aux != null) {
                //código
                contar++;
                temp = aux.getInfo();
                if (contar < 10) {
                    System.out.println("0" + contar + ") Tipo de cliente:" + temp.getCondicion() + " P:" + temp.getPrioridad() + " T:" + temp.getTicket() + " ID:" + temp.getID() + "---" + temp.getNombre());
                } else {
                    System.out.println(contar + ") Tipo de cliente:" + temp.getCondicion() + " P:" + temp.getPrioridad() + " T:" + temp.getTicket() + " ID:" + temp.getID() + "---" + temp.getNombre());
                }
                aux = aux.getSig();
            }
        }

    }

    //Esta funcion verifica si existe algun operacion pendiente segun se el ID de algun Alumno
    public static TipoInfo PideDatos() {
        String tempString = "";
        int seleccionCondicion = -1;
        int edadRegistrada = -1;
        TipoInfo Datos = new TipoInfo();
        Scanner teclado = new Scanner(System.in);

        System.out.println("INTRODUZCA LOS DATOS ");

        System.out.print("--ID: ");
        tempString = teclado.nextLine();
        Datos.setID(tempString);

        System.out.print("--Nombre: ");
        Datos.setNombre(teclado.nextLine());

        System.out.print("--Edad: ");

        Datos.setEdad(IngresarEdad(edadRegistrada, teclado, tempString, Datos));

        System.out.print("--Seleccione su condicion: ");
        do {
            System.out.println(""
                    + "\n"
                    + "1 - Normal (Ninguna condición)\n"
                    + "2 - Embarazada\n"
                    + "3 - Discapacidad\n");

            seleccionCondicion = teclado.nextInt();
            switch (seleccionCondicion) {
                case 1:
                    tempString = "Normal";
                    break;
                case 2:
                    tempString = "Embarazada";
                    break;
                case 3:
                    tempString = "Discapacidad";
                    break;
                default:
                    tempString = "No registrada";
            }
        } while (seleccionCondicion < 1 || seleccionCondicion > 3);
        Datos.setCondicion(tempString);

        System.out.print("--Prioridad: ");
        if (Datos.getEdad() > 65 || !tempString.equals("Normal")) {
            Datos.setPrioridad(1);

        } else {
            Datos.setPrioridad(2);

        }

        return Datos;
    }

    public static int IngresarEdad(int edadRegistrada, Scanner teclado, String tempString, TipoInfo Datos) {
        do {
            edadRegistrada = teclado.nextInt();

            if (edadRegistrada < 0 || edadRegistrada > 100) {
                System.out.println("\nSe ha ingresado una edad no valida\n");
            }

        } while (edadRegistrada <= 17 || edadRegistrada >= 100);
        return edadRegistrada;
    }

    public static void MostrarDato(TipoInfo tmpDato) {
        if (tmpDato == null) {
            System.out.println("----> LA COLA ESTA VACIA <----");
        } else {
            System.out.println("Ticket:" + tmpDato.getTicket());
            System.out.println("Tipo: P" + tmpDato.getPrioridad());

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

    public static void MeterN(TadCola ColaNormal, TadCola ColaPrioridad, int pTotal, String[] arregloTipoCliente) {
        TipoInfo temp;
        int x = 0;

        Random rnd = new Random();
        int prioridad = 0;
        for (x = 1; x <= pTotal; x++) {
            temp = new TipoInfo();
            temp.setID(String.valueOf(rnd.nextInt(8999) + 1000));
            temp.setNombre("E" + String.valueOf(rnd.nextInt(8999) + 1000));
            temp.setCondicion(arregloTipoCliente[0]);
            prioridad = 2;
            temp.setEdad(rnd.nextInt(99) + 17);
            temp.setPrioridad(prioridad);
            ColaNormal.Meter(temp);
        }

        for (x = 1; x <= pTotal; x++) {
            temp = new TipoInfo();
            temp.setID(String.valueOf(rnd.nextInt(8999) + 1000));
            temp.setNombre("E" + String.valueOf(rnd.nextInt(8999) + 1000));
            temp.setCondicion(arregloTipoCliente[1]);
            temp.setEdad(rnd.nextInt(99) + 17);
            prioridad = 1;
            temp.setPrioridad(prioridad);
            ColaPrioridad.Meter(temp);
        }
    }


    //Funciones que son utilizadas para retirar clientes de las filas
    public static int RealizarPeticionesGenerales(TadCola ColaNormal, TadCola ColaPrioridad, TipoInfo Dato, Scanner teclado) {
        char mantenerOperaciones = 's';
        int cantidadRealizadas = 0;
        TipoInfo Dato2 = new TipoInfo();
        int prioridadesRealizadas = 0;
        int operacionTripel = 0;

        do {
            System.out.println("\n¿Desea tramitar la siguitnete solicitud?\n"
                    + "s - Si\n"
                    + "n - No");
            mantenerOperaciones = teclado.next().charAt(0);
            if (mantenerOperaciones == 's' || mantenerOperaciones == 'S') {
                do {

                    cantidadRealizadas++;
                    operacionTripel++;
                    if (prioridadesRealizadas < 2) {
                        if (ColaPrioridad.ColaVacia()) {
                            cantidadRealizadas--;
                            System.out.println("No hay mas clientes de tipo Prioridad.");
                        } else {

                            Dato = ColaPrioridad.Sacar();
                            Dato2 = ColaPrioridad.verInicio();
                            System.out.println("Se ha realizado una solicitud con los siguientes datos: ");
                            MostrarDato(Dato);
                            System.out.println("*****Se ha atendido un cliente de tipo Prioridad.*****");

                        }
                        prioridadesRealizadas++;
                    } else {
                        if (ColaNormal.ColaVacia()) {
                            cantidadRealizadas--;
                            System.out.println("No hay mas clientes de tipo Normal");

                        } else {

                            Dato = ColaNormal.Sacar();
                            Dato2 = ColaNormal.verInicio();
                            System.out.println("Se ha realizado una solicitud con los siguientes datos: ");
                            MostrarDato(Dato);
                            System.out.println("*****Se ha atendido un cliente de tipo Normal*****");

                        }
                        prioridadesRealizadas = 0;
                    }
                    agregarLineas(1);

                } while (operacionTripel < 3);
                operacionTripel = 0;
                agregarLineas(2);
                System.out.println(">>>>>>>El siguiente cliente es: <<<<<<<<");
                MostrarDato(Dato2);

                System.out.println("\nSe han realizado 3 solictudes de clientes");
                pausa();

            } else {
                System.out.println("\nNo se realizara ninguna solicitud pendiente");
            }

        } while (mantenerOperaciones == 's' || mantenerOperaciones == 'S');
        return cantidadRealizadas;
    }

    public static int RealizarPeticionesPrioridad(TadCola ColaPrioridad, TipoInfo Dato, Scanner teclado) {
        char mantenerOperaciones = 's';
        int cantidadRealizadas = 0;
        do {
            System.out.println(
                    "\n¿Desea tramitar la siguitnete solicitud?\n"
                    + "s - Si\n"
                    + "n - No");
            mantenerOperaciones = teclado.next().charAt(0);
            if (mantenerOperaciones == 's' || mantenerOperaciones == 'S') {
                cantidadRealizadas++;
                Dato = ColaPrioridad.Sacar();

                System.out.println("\nSe ha realizado una solicitud con los siguientes datos: ");
                MostrarDato(Dato);
                Dato = ColaPrioridad.verInicio();
                System.out.println("\nEl siguiente tramite es: ");
                MostrarDato(Dato);
                pausa();

            } else {
                System.out.println("\nNo se realizara ninguna solicitud pendiente");
            }

        } while (mantenerOperaciones == 's' || mantenerOperaciones == 'S');
        return cantidadRealizadas;
    }

    public static int RealizarPeticionesNormal(TadCola ColaNormal, TipoInfo Dato, Scanner teclado) {
        char mantenerOperaciones = 's';
        int cantidadRealizadas = 0;
        do {
            System.out.println("\n¿Desea tramitar la siguitnete solicitud?\n"
                    + "s - Si\n"
                    + "n - No");
            mantenerOperaciones = teclado.next().charAt(0);
            if (mantenerOperaciones == 's' || mantenerOperaciones == 'S') {
                cantidadRealizadas++;
                Dato = ColaNormal.Sacar();

                System.out.println("\nSe ha realizado una solicitud con los siguientes datos: ");
                MostrarDato(Dato);
                Dato = ColaNormal.verInicio();
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
