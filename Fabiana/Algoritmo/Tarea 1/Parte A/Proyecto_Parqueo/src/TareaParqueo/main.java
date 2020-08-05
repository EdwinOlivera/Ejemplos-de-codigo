/*
 * To change this license tecladoer, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TareaParqueo;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author yamap
 */
public class main {

    public static void main(String[] args) {
        final int MAXAUTOS = 20;
        Opciones(MAXAUTOS);
    }

    public static void Opciones(int MaxAutos) {
        String seleccionar;
        Scanner teclado = new Scanner(System.in); 
        Info Datos = new Info();
        Pila Parqueo;

        Parqueo = new Pila(MaxAutos);
        int datosAutomaticos = MaxAutos / 2;
        for (int i = 0; i < datosAutomaticos; i++) {
            Datos = PideDatos();
            Parqueo.Meter(Datos);
        }
        do {

            System.out.println("*******PARQUEO*******");
            System.out.println("1. Espacios Disponibles");
            System.out.println("2. Numero De Autos En El Parqueo");
            System.out.println("3. Mostrar Datos");
            System.out.println("4. Retirar vehiculo del sistema");
            System.out.println("5. Salir");
            System.out.println("-----------------------------------------");
            System.out.print("INGRESE SU OPCION : ");
            seleccionar = teclado.next();
            seleccionar = seleccionar.toLowerCase();
            switch (seleccionar) {
                case "1":
                    System.out.println("Espacios disponibles actualmente: " + Parqueo.EspaciosDisponibles());
                    pausa();
                    break;
                case "2":
                    System.out.println("Vehiculos parqueados: " + Parqueo.EspaciosDisponibles());
                    break;
                case "3":
                    System.out.println("Estos son los vehiculos estacionados");
                    Parqueo.Mostrar();
                    break;
                case "4":
                    System.out.println("Estos son los vehiculos estacionados");
                    Parqueo.Mostrar();
                    System.out.println("Ingrese la placa del auto que quiera quitar");
                    int placaTemporal = teclado.nextInt();

                    Parqueo.Sacar(String.valueOf(placaTemporal));
                    pausa();
                    break;
                case "5":
                    System.exit(0);
                    break;
                default:
                    break;
            }
        } while (true); 
    }


    public final static void pausa() {
        System.out.print("Presione ENTER para continuar...");
        new java.util.Scanner(System.in).nextLine();
    }



    public static Info PideDatos() {
        Random numRandom = new Random();
        int valorDado = numRandom.nextInt(9000) + 1000;
        Info Datos = new Info();
        System.out.println("INTRODUCIENDO DATOS AUTOMATIZADOS");
        Datos.setPlaca(String.valueOf(valorDado));
        valorDado = numRandom.nextInt(100) + 1;
        Datos.setApartamento(valorDado);

        return Datos;
    }
}
