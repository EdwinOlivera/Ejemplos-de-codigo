package listasimpleexam;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Scanner;

/**
 * Author:Fabiana Yamaly Artiaga Portilo Cuenta: 20151000019
 */
public class ListaSimpleExam {

    public static void main(String[] args) {
        opciones();
    }

    public static void opciones() {
        String opcion;
        int cantidadInicialDeEstudiantes = 5;
        int numeroDeSemanasIniciales = 2;
        Scanner teclado = new Scanner(System.in); //Creación de un objeto Scanner
        TadMetodosLista miLista = new TadMetodosLista();
        InfoSemana Dato = new InfoSemana();
        String tmpCadena;
        int tmpNumero = 0;

        //Aqui se ingresan la cantidad incial de datos
        MeterN(miLista, cantidadInicialDeEstudiantes, numeroDeSemanasIniciales);
        pausa();
        do {

            System.out.println("------------AGENDA------------");
            System.out.println("1. Nuevo ");
            System.out.println("2. Ver datos");
            System.out.println("3. Cambiar nota de alumno");
            System.out.println("4. <-PENDIENTE-> ");
            System.out.println("5. <-PENDIENTE->");
            System.out.println("6. <-PENDIENTE->");
            System.out.println("7. <-PENDIENTE->");
            System.out.println("s. Salir");
            System.out.println("-----------------------------------------");
            System.out.print("INGRESE LA OPCION [1 - 5]: ");
            opcion = teclado.next();
            opcion = opcion.toLowerCase();
            switch (opcion) {
                case "1":
                    Dato = PideDatos(miLista);
                    if (Dato != null) {

                    } else {
                        System.out.println("El registro de semenas ya esta lleno, solo puede modificar los existentes");
                    }
                    pausa();
                    break;
                case "2":
                    miLista.MostrarLista();
                    pausa();
                    break;
                case "3":
                    System.out.println("Ingrese el numero de cuenta del estudiante ");
                    tmpCadena = teclado.next();
                    do {
                        System.out.println("1.	Cambiar nota 1\n"
                                + "2.	Cambiar nota 2");
                        tmpNumero = teclado.nextInt();
                    } while (tmpNumero < 1 || tmpNumero > 2);
                    if (!miLista.CambiarNota(tmpCadena, tmpNumero)) {
                        System.out.println("No se encontra al estudiante");
                    }
                    break;
                case "4":

                    break;
                case "5":

                    break;
                case "6":

                    break;
                case "7":

                    break;
                case "s":
                    System.exit(0);
                    break;
                default:
                    break;
            }
        } while (true); //-- SEGUIRA HASTA QUE OPCION SEA IGUAL A 5
    }//fin menu

    //Esta funcion verifica si existe algun operacion pendiente segun se el ID de algun Alumno
    public static InfoSemana PideDatos(TadMetodosLista miLista) {
        if (!miLista.getTodasLasSemanasRegistradas()) {

            int tmpNumero = 0;
            int CantidadDeEstudiantes = -1;
            InfoSemana Datos = new InfoSemana();
            InfoEstudiante[] estudiantesDeLaSemana;
            String tmpString = "";

            Scanner teclado = new Scanner(System.in);
            System.out.println("INTRODUZCA LOS DATOS DE LA SEMANA ACTUAL");

            do {
                System.out.print("Ingrese el numero de semana en la que quiere meter los datos ==> ");
                tmpNumero = teclado.nextInt();
            } while (miLista.ExisteSemana(tmpNumero) || tmpNumero < 1 || tmpNumero > 7);

            Datos.setNumeroDesemana(tmpNumero);
            System.out.println("Ingrese la cantidad de Estudiante a ingresar en la semana>>>>>>>>");
            CantidadDeEstudiantes = teclado.nextInt();

            estudiantesDeLaSemana = new InfoEstudiante[CantidadDeEstudiantes];

            for (int i = 0; i < CantidadDeEstudiantes; i++) {

                do {
                    System.out.println("Ingres la Primera nota del estudiante [" + (i + 1) + "]");
                    tmpNumero = teclado.nextInt();

                } while (tmpNumero < 0 || tmpNumero > 100);

                estudiantesDeLaSemana[i].setNota1(tmpNumero);

                do {
                    System.out.println("Ingres la Segunda nota del estudiante [" + (i + 1) + "]");
                    tmpNumero = teclado.nextInt();

                } while (tmpNumero < 0 || tmpNumero > 100);
                estudiantesDeLaSemana[i].setNota1(tmpNumero);
                System.out.println("Ingres el numero de cuenta del estudiante [" + (i + 1) + "]");
                tmpString = teclado.nextLine();
                estudiantesDeLaSemana[i].setNumeroDecuenta(tmpString);

            }

            Datos.setEstudiante(estudiantesDeLaSemana);

            return Datos;

        } else {
            return null;
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

    public static void MeterN(TadMetodosLista miLista, int cantidadInicialDeEstudiantes, int numeroDeSemanasIniciales) {
        if (!miLista.getTodasLasSemanasRegistradas()) {

            int tmpNumero = 0;
            Random rnd = new Random();
            InfoSemana Datos;
            InfoEstudiante tmpEstudiante;
            InfoEstudiante[] estudiantesDeLaSemana;


            System.out.println("INTRODUZCA LOS DATOS DE LA SEMANA ACTUAL");
            for (int semanaActual = 1; semanaActual <= numeroDeSemanasIniciales; semanaActual++) {
                estudiantesDeLaSemana = new InfoEstudiante[cantidadInicialDeEstudiantes];
                Datos = new InfoSemana();
                System.out.println("Se a Ingrese el numero de semana ==> " + semanaActual);

                Datos.setNumeroDesemana(semanaActual);
                System.out.println("Ingrese la cantidad de Estudiante a ingresar en la semana");

                for (int i = 0; i < cantidadInicialDeEstudiantes; i++) {
                    tmpEstudiante = new InfoEstudiante();
                    do {
                        tmpNumero = 10 + rnd.nextInt(100);

                    } while (tmpNumero < 0 || tmpNumero > 100);

                    tmpEstudiante.setNota1(tmpNumero);

                    do {
                        tmpNumero = 10 + rnd.nextInt(100);

                    } while (tmpNumero < 0 || tmpNumero > 100);
                    tmpEstudiante.setNota2(tmpNumero);

                    System.out.println("Ingres el numero de cuenta del estudiante [" + (i + 1) + "]");
                    tmpNumero = 1000 + rnd.nextInt(9000);

                    tmpEstudiante.setNumeroDecuenta(String.valueOf(tmpNumero));
                    estudiantesDeLaSemana[i] = tmpEstudiante;
                }

                Datos.setEstudiante(estudiantesDeLaSemana);
                miLista.Insertar(Datos);
            }

        } else {
            System.out.println("El registro ya esta lleno");
        }

    }

//
//    public static int RealizarPeticionesGenerales(TadCola ColaNormal, TadCola ColaPrioridad, Info Dato, Scanner teclado) {
//        char mantenerOperaciones = 's';
//        int cantidadRealizadas = 0;
//        Info Dato2 = new Info();
//        int prioridadesRealizadas = 0;
//        int operacionTripel = 0;
//
//        do {
//            System.out.println("\n¿Desea tramitar la siguitnete solicitud?\n"
//                    + "s - Si\n"
//                    + "n - No");
//            mantenerOperaciones = teclado.next().charAt(0);
//            if (mantenerOperaciones == 's' || mantenerOperaciones == 'S') {
//                do {
//
//                    cantidadRealizadas++;
//                    operacionTripel++;
//                    if (prioridadesRealizadas < 2) {
//                        if (ColaPrioridad.ColaVacia()) {
//                            cantidadRealizadas--;
//                            System.out.println("No hay mas clientes de tipo Prioridad.");
//                        } else {
//
//                            Dato = ColaPrioridad.Sacar();
//                            Dato2 = ColaPrioridad.verInicio();
//                            System.out.println("Se ha realizado una solicitud con los siguientes datos: ");
//                            MostrarDato(Dato);
//                            System.out.println("*****Se ha atendido un cliente de tipo Prioridad.*****");
//
//                        }
//                        prioridadesRealizadas++;
//                    } else {
//                        if (ColaNormal.ColaVacia()) {
//                            cantidadRealizadas--;
//                            System.out.println("No hay mas clientes de tipo Normal");
//
//                        } else {
//
//                            Dato = ColaNormal.Sacar();
//                            Dato2 = ColaNormal.verInicio();
//                            System.out.println("Se ha realizado una solicitud con los siguientes datos: ");
//                            MostrarDato(Dato);
//                            System.out.println("*****Se ha atendido un cliente de tipo Normal*****");
//
//                        }
//                        prioridadesRealizadas = 0;
//                    }
//                    agregarLineas(1);
//
//                } while (operacionTripel < 3);
//                operacionTripel = 0;
//                agregarLineas(2);
//                System.out.println(">>>>>>>El siguiente cliente es: <<<<<<<<");
//                MostrarDato(Dato2);
//
//                System.out.println("\nSe han realizado 3 solictudes de clientes");
//                pausa();
//
//            } else {
//                System.out.println("\nNo se realizara ninguna solicitud pendiente");
//            }
//
//        } while (mantenerOperaciones == 's' || mantenerOperaciones == 'S');
//        return cantidadRealizadas;
//    }
}
