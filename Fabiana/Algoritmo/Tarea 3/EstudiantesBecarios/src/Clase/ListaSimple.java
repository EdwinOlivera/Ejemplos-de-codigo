package Clase;

import java.util.Random;
import java.util.Scanner;

public class ListaSimple {

    public static void main(String[] args) {
        Menu();
    }

    public static void Menu() {
        String opcion;
        Scanner teclado = new Scanner(System.in);

        //Estas son los Conjuntos necesarias para realizar lo que es necesario
        TadListaSimple ConjuntoAlumnosBecas = new TadListaSimple();
        TadListaSimple ConjuntoAlumnosSistema = new TadListaSimple();
        TadListaSimple tmpConjuntoAlumnos = new TadListaSimple();

        String[] carreraEstudiada = {"Sistema", "Otra"};

        TipoInfo Dato = new TipoInfo();
        int cantidadElementosInciales = 5;

        System.out.println("INTRODUCIENDO #" + (cantidadElementosInciales * 2) + " DE ALUMNOS AUTOMATICAMENTE");
        agregarLineas(1);
//Agregando alumnos becarios
        for (int i = 0; i < cantidadElementosInciales; i++) {
            Dato = DatosAutomaticosBecarios(carreraEstudiada);
            ConjuntoAlumnosBecas.Insertar(Dato);
        }
//Agregar alumnos a la Conjunto de Alumnos de Sistema
        for (int i = 0; i < cantidadElementosInciales; i++) {
            Dato = DatosAutomaticosSistema(carreraEstudiada);
            ConjuntoAlumnosSistema.Insertar(Dato);
        }

        do {
            agregarLineas(2);
            System.out.println("------------AGENDA------------");
            System.out.println("1. Ingresar Alumno ");
            System.out.println("2. Mostrar Union");
            System.out.println("3. Mostrar Interseccion");
            System.out.println("4. Mostrar Diferencia - solamente Sistema ");
            System.out.println("5. Mostrar Diferencia - solamente Becario ");
            System.out.println("6. Mostrar Diferencia simetrica ");

            System.out.println("s. Salir");
            System.out.println("-----------------------------------------");
            System.out.print("INGRESE LA OPCION [1 - 6]: ");
            opcion = teclado.next();
            opcion = opcion.toLowerCase();

            //Con esta funcion se limpia la Conjunto temporal
            VaciarConjunto(tmpConjuntoAlumnos);
            switch (opcion) {
                case "1":
                    Dato = PideDatos(carreraEstudiada);

                    if (Dato.getEstudioCarrera().equals(carreraEstudiada[1]) && Dato.isBeca()) {
                        //Este bloque es para alumnos que tiene BECA y no Estudian Sistema
                        ConjuntoAlumnosBecas.Insertar(Dato);
                    } else if (Dato.getEstudioCarrera().equals(carreraEstudiada[0]) && !Dato.isBeca()) {
                        //Este bloque es para alumnos que NO tiene BECA y Estudian Sistema
                        ConjuntoAlumnosSistema.Insertar(Dato);
                    }
                    pausa();
                    break;
                case "2":
                    MostrarUnion(Dato, ConjuntoAlumnosBecas, ConjuntoAlumnosSistema, tmpConjuntoAlumnos);

                    pausa();
                    break;
                case "3":
                    agregarLineas(1);
                    MostrarIntercepcion(Dato, ConjuntoAlumnosBecas, ConjuntoAlumnosSistema, tmpConjuntoAlumnos);
                    pausa();
                    break;
                case "4":
                    DiferenciaConjuntoSistema(Dato, ConjuntoAlumnosSistema, tmpConjuntoAlumnos);
                    pausa();
                    break;
                case "5":
                    DiferenciaConjuntoBecarios(Dato, ConjuntoAlumnosBecas, tmpConjuntoAlumnos);
                    pausa();
                    break;
                case "6":
                    MostrarDiferenciaSimetrica(Dato, ConjuntoAlumnosBecas, ConjuntoAlumnosSistema, tmpConjuntoAlumnos);
                    pausa();
                    break;
                case "s":
                    System.out.println("********>>>>>>Saliendo del sistema");
                    System.exit(0);
                    break;
                default:
                    break;
            }
        } while (true);
    }

    //Funcion encargada de la mostrar la Diferencia Simetrica y requiere de los 2 conjuntos y el conjunto temporal
    public static void MostrarDiferenciaSimetrica(TipoInfo Dato, TadListaSimple ConjuntoAlumnosBecas, TadListaSimple ConjuntoAlumnosSistema, TadListaSimple tmpConjuntoAlumnos) {

        for (int indice = 0; indice < ConjuntoAlumnosBecas.CantidadElementos(); indice++) {
            Dato = ConjuntoAlumnosBecas.RetornarElemento(indice);
            if (Dato.getEstudioCarrera().equals("Otra") && Dato.isBeca()) {
                tmpConjuntoAlumnos.Insertar(Dato);
            }
        }

        for (int indice = 0; indice < ConjuntoAlumnosSistema.CantidadElementos(); indice++) {
            Dato = ConjuntoAlumnosSistema.RetornarElemento(indice);
            if (Dato.getEstudioCarrera().equals("Sistema") && !Dato.isBeca()) {
                tmpConjuntoAlumnos.Insertar(Dato);
            }
        }

        System.out.println("******Conjunto de Diferencias simetricas de los conjuntos A y B "
                + "(Todos los que son estudiantes de ingeniería en sistemas o becarios, pero no al mismo tiempo.******");

        tmpConjuntoAlumnos.Mostrar();
    }

    public static void DiferenciaConjuntoBecarios(TipoInfo Dato, TadListaSimple ConjuntoAlumnosBecas, TadListaSimple tmpConjuntoAlumnos) {

        for (int indice = 0; indice < ConjuntoAlumnosBecas.CantidadElementos(); indice++) {
            Dato = ConjuntoAlumnosBecas.RetornarElemento(indice);
            if (Dato.getEstudioCarrera().equals("Otra") && Dato.isBeca()) {
                tmpConjuntoAlumnos.Insertar(Dato);
            }
        }
        System.out.println("******Conjunto de Diferencia de B-A (Todos los estudiantes becados que no son de Sistemas)******");

        tmpConjuntoAlumnos.Mostrar();
    }

    public static void DiferenciaConjuntoSistema(TipoInfo Dato, TadListaSimple ConjuntoAlumnosSistema, TadListaSimple tmpConjuntoAlumnos) {

        for (int indice = 0; indice < ConjuntoAlumnosSistema.CantidadElementos(); indice++) {
            Dato = ConjuntoAlumnosSistema.RetornarElemento(indice);
            if (Dato.getEstudioCarrera().equals("Sistema") && !Dato.isBeca()) {
                tmpConjuntoAlumnos.Insertar(Dato);
            }
        }
        System.out.println("******Conjunto de Diferencia de A-B (Todos los estudiantes de sistemas que no están becados)******");

        tmpConjuntoAlumnos.Mostrar();
    }

    //En la funcion se ejecuta un cliclo FOR para que se elimen todos los elementos de una Conjunto que se mande como parametro
    public static void VaciarConjunto(TadListaSimple tmpConjuntoAlumnos) {
        for (int i = 0; i < tmpConjuntoAlumnos.CantidadElementos(); i++) {
            tmpConjuntoAlumnos.Eliminar();
        }
    }

    public static void MostrarIntercepcion(TipoInfo Dato, TadListaSimple ConjuntoAlumnosBecas, TadListaSimple ConjuntoAlumnosSistema, TadListaSimple tmpConjuntoAlumnos) {

        for (int indice = 0; indice < ConjuntoAlumnosBecas.CantidadElementos(); indice++) {
            Dato = ConjuntoAlumnosBecas.RetornarElemento(indice);
            if (Dato.getEstudioCarrera().equals("Sistema") && Dato.isBeca()) {
                tmpConjuntoAlumnos.Insertar(Dato);
            }
        }
        for (int indice = 0; indice < ConjuntoAlumnosSistema.CantidadElementos(); indice++) {
            Dato = ConjuntoAlumnosSistema.RetornarElemento(indice);
            if (Dato.getEstudioCarrera().equals("Sistema") && Dato.isBeca()) {
                tmpConjuntoAlumnos.Insertar(Dato);
            }

        }
        System.out.println("******Conjunto de Intercepcion de los Conjuntos A y B******");

        tmpConjuntoAlumnos.Mostrar();
    }

    public static void MostrarUnion(TipoInfo Dato, TadListaSimple ConjuntoAlumnosBecas, TadListaSimple ConjuntoAlumnosSistema, TadListaSimple tmpConjuntoAlumnos) {

        for (int i = 0; i < ConjuntoAlumnosSistema.CantidadElementos(); i++) {
            Dato = ConjuntoAlumnosSistema.RetornarElemento(i);

            tmpConjuntoAlumnos.Insertar(Dato);
        }
        for (int i = 0; i < ConjuntoAlumnosBecas.CantidadElementos(); i++) {
            Dato = ConjuntoAlumnosBecas.RetornarElemento(i);
            tmpConjuntoAlumnos.Insertar(Dato);
        }

        System.out.println("******Conjunto de Union de Conjunto A y B******");

        tmpConjuntoAlumnos.Mostrar();
    }

    public static TipoInfo PideDatos(String[] carreraEstudiada) {
        int opcionIngresada = -1;

        TipoInfo Datos = new TipoInfo();
        Scanner teclado = new Scanner(System.in);
        System.out.println("INTRODUZCA LOS DATOS");
        System.out.print("--Numero de cuenta: ");
        Datos.setNumeroCuenta(teclado.nextInt());
        System.out.print("--Edad: ");
        Datos.setEdad(teclado.nextInt());

        System.out.println("--Beca: ");
        do {
            System.out.println("1 - SI tiene beca el alumno");
            System.out.println("2 - NO tiene beca el alumno");
            opcionIngresada = teclado.nextInt();
            if (opcionIngresada <= 0 || opcionIngresada > 2) {
                System.out.println("Se ha ingreado una opcion no validad. INTENTELO de nuevo.");
            }
        } while (opcionIngresada <= 0 || opcionIngresada > 2);
        switch (opcionIngresada) {

            case 1:
                Datos.setBeca(true);
                break;
            case 2:
                Datos.setBeca(false);
                break;
        }
        System.out.println("--Lo que estudia: ");
        do {
            System.out.println("1 - Estudia Sistema");
            System.out.println("2 - Estudia otra carrera");
            opcionIngresada = teclado.nextInt();
            if (opcionIngresada <= 0 || opcionIngresada > 2) {
                System.out.println("Se ha ingreado una opcion no validad. INTENTELO de nuevo.");
            }
        } while (opcionIngresada <= 0 || opcionIngresada > 2);
        switch (opcionIngresada) {

            case 1:
                Datos.setEstudioCarrera(carreraEstudiada[0]);
                break;
            case 2:
                Datos.setEstudioCarrera(carreraEstudiada[1]);
                break;
        }

        return Datos;
    }
//Esta funcion es la encargada de ingresar los datos de los Becarios de forma automatica

    public static TipoInfo DatosAutomaticosBecarios(String[] carreraEstudiada) {
        boolean[] estadoBeca = {true, false};
        Random rnd = new Random();
        TipoInfo Datos = new TipoInfo();
        Datos.setNumeroCuenta(rnd.nextInt(9000) + 1000);

        Datos.setEdad(rnd.nextInt(65) + 17);
        Datos.setBeca(estadoBeca[0]);
        Datos.setEstudioCarrera(carreraEstudiada[rnd.nextInt(2)]);

        return Datos;
    }
//Esta funcion es la encargada de ingresar los datos de los Estudiantes de Sistema de forma automatica

    public static TipoInfo DatosAutomaticosSistema(String[] carreraEstudiada) {
        boolean[] estadoBeca = {true, false};
        Random rnd = new Random();
        TipoInfo Datos = new TipoInfo();
        Datos.setNumeroCuenta(rnd.nextInt(9000) + 1000);

        Datos.setEdad(rnd.nextInt(65) + 17);
        Datos.setBeca(estadoBeca[rnd.nextInt(2)]);
        Datos.setEstudioCarrera(carreraEstudiada[0]);

        return Datos;
    }

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

    public static int PideNumero(String pTexto) {
        int IDAretornar;
        Scanner teclado = new Scanner(System.in);
        System.out.print(pTexto);
        IDAretornar = teclado.nextInt();
        return IDAretornar;
    }

}
