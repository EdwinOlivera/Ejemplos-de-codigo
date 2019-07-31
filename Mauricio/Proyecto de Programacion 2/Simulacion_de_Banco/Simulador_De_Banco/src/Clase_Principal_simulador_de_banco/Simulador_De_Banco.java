/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clase_Principal_simulador_de_banco;

import ClasesClientes.CrearClientes;
import ClasesClientes.PropiedadesClientes;
import Fomularios.SalaDeEspera;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class Simulador_De_Banco extends Thread {

    //Variables para el control de Cambio de Velocidad
    private static int Cambio_1 = 200;
    private static int Cambio_2 = 250;
    private static int Cambio_3 = 300;
    //Iniciadores de las Barras
    //Barra 1
    private static int ValorBarraCajero_1 = 0;
    private static int TiempoCajero_1 = 1;
    private static Thread Cajero1 = new Thread() {
        public void run() {
            System.out.println("Iniciando el proceso en el Cajero 1");
            try {
                for (ValorBarraCajero_1 = 0; ValorBarraCajero_1 <= 101; ValorBarraCajero_1++) {
                    BarrasDeProgreso.get(0).setValue(ValorBarraCajero_1);
                    EspaciosDeClientes.get(0).setForeground(Color.BLACK);
                    EspaciosDeClientes.get(0).setText("Completado: " + Integer.toString(ValorBarraCajero_1) + "%");
                    Cajero1.sleep(TiempoCajero_1 * Cambio_1);
                    if (ValorBarraCajero_1 == 101 - 1) {
                        ValorBarraCajero_1 = 0;
                        BarrasDeProgreso.get(0).setValue(ValorBarraCajero_1);
                        EspaciosDeClientes.get(0).setText("Completado: " + Integer.toString(ValorBarraCajero_1) + "%");

                        ContinuarProceso(1);
                    }
                }
            } catch (Exception e) {

            }
        }
    };
    //Barra 2
    private static int ValorBarraCajero_2 = 0;
    private static int TiempoCajero_2 = 1;
    private static Thread Cajero2 = new Thread() {
        public void run() {
            System.out.println("Iniciando el proceso en el Cajero 2");
            try {
                for (ValorBarraCajero_2 = 0; ValorBarraCajero_2 <= 101; ValorBarraCajero_2++) {
                    BarrasDeProgreso.get(1).setValue(ValorBarraCajero_2);
                    EspaciosDeClientes.get(1).setForeground(Color.BLACK);
                    EspaciosDeClientes.get(1).setText("Completado: " + Integer.toString(ValorBarraCajero_2) + "%");
                    Cajero2.sleep(TiempoCajero_2 * Cambio_2);
                    if (ValorBarraCajero_2 == 101 - 1) {
                        ValorBarraCajero_2 = 0;
                        BarrasDeProgreso.get(1).setValue(ValorBarraCajero_2);
                        EspaciosDeClientes.get(1).setText("Completado: " + Integer.toString(ValorBarraCajero_2) + "%");
                        ContinuarProceso(2);
                    }
                }
            } catch (Exception e) {

            }
        }
    };

    //Barra 3
    private static int ValorBarraCajero_3 = 0;
    private static int TiempoCajero_3 = 1;
    private static Thread Cajero3 = new Thread() {
        public void run() {
            System.out.println("Iniciando el proceso en el Cajero 3");
            try {
                for (ValorBarraCajero_3 = 0; ValorBarraCajero_3 <= 101; ValorBarraCajero_3++) {
                    BarrasDeProgreso.get(2).setValue(ValorBarraCajero_3);
                    EspaciosDeClientes.get(2).setForeground(Color.BLACK);
                    EspaciosDeClientes.get(2).setText("Completado: " + Integer.toString(ValorBarraCajero_3) + "%");
                    Cajero2.sleep(TiempoCajero_3 * Cambio_3);
                    if (ValorBarraCajero_3 == 101 - 1) {
                        ValorBarraCajero_3 = 0;
                        BarrasDeProgreso.get(2).setValue(ValorBarraCajero_3);
                        EspaciosDeClientes.get(2).setText("Completado: " + Integer.toString(ValorBarraCajero_3) + "%");
                        ContinuarProceso(3);
                    }
                }
            } catch (Exception e) {

            }
        }
    };
    //Variables PUBLIC STATIC
    public static int TiempoCajero1 = -1;
    public static int TiempoCajero2 = -1;
    public static int TiempoCajero3 = -1;
    public static int TurnoGlobales = -1;//Este determina quien es el siguien en la fila
    public static int CrearClientesNuevos = 0;//con esta variable se asegura nunca dejar de tener clientes nuevos

    //PRIVADAS STATIC
    //ArrayList
     private static ArrayList<PropiedadesClientes> TodosLosClientes = new ArrayList<PropiedadesClientes>();
    private static ArrayList<JLabel> Asientos = new ArrayList<>();
    private static ArrayList<JLabel> Montos = new ArrayList<>();
    private static ArrayList<JLabel> TipoDeClientes = new ArrayList<>();
    private static ArrayList<JLabel> Operaciones = new ArrayList<>();
    private static ArrayList<JLabel> EspaciosDeClientes = new ArrayList<>();
    private static ArrayList<JProgressBar> BarrasDeProgreso = new ArrayList<>();
    //objetos 
    private static SalaDeEspera Formulario = new SalaDeEspera();
    private static CrearClientes Clientes = new CrearClientes();
    private static PropiedadesClientes Cliente_de_Cajero_1 = new PropiedadesClientes();
    private static PropiedadesClientes Cliente_de_Cajero_2 = new PropiedadesClientes();
    private static PropiedadesClientes Cliente_de_Cajero_3 = new PropiedadesClientes();
    //Variables 
 
    private static int NumeroDeClientesACrear = 10;
    public static String MensajeFinal = "Este es el final del Programa>>>>>*****************";

    /**
     * ***********************************************
     * @param args
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        //For Para Crear Clientes a voluntad
        for (int i = 0; i < NumeroDeClientesACrear; i++) {
            System.out.println("Se esta creando el Cliente NUMERO: " + (i + 1));

            Thread.sleep(100);
            Clientes.CreandoCliente();
        }
        TodosLosClientes = Clientes.RecuperarClientes();
  
        CosasIniciales();

        System.out.println(MensajeFinal);
    }

    private static void CosasIniciales() throws InterruptedException//En esta funcion se realizan las operaciones basicas e iniciales de todo el sistema
    {
        System.out.println("Se Esta incializando el sistema. Haciendo las operaciones basicas");
        System.out.println("El tamaño de los clientes es: " + TodosLosClientes.size());

        Formulario.setVisible(true);
        Formulario.EstablecerCaracteristicas();//Establece la forma de verse inicialmente el formulario
        Asientos = Formulario.GuardarArrayListDeAsientos(Asientos);
        BarrasDeProgreso = Formulario.GuardarBarraDeProgresoDeCajeros(BarrasDeProgreso);

        //Las propiedades de los clientes (Son las etiquetas)
        Montos = Formulario.GuardarArrayListDeMonto(Montos);
        TipoDeClientes = Formulario.GuardarArrayListDeTipoDeCliente(TipoDeClientes);
        Operaciones = Formulario.GuardarArrayListDeOperacion(Operaciones);
        EspaciosDeClientes = Formulario.GuardarArrayListDeEspacioDeClientes(EspaciosDeClientes);

//Colocando a los clientes en los asientos
        for (int i = 0; i < 10; i++) {
            Asientos.get(i).setBackground(TodosLosClientes.get(i).getColores());
            Asientos.get(i).setForeground(Color.BLACK);
            Asientos.get(i).setOpaque(true);
            Thread.sleep(500);
        }
        IniciarLosCajeros();
    }

    private static void ContinuarProceso(int TurnoDecajero) throws InterruptedException {
        System.out.println("<*<*Se esta iniciando un proceso de CAJERO");
        if (TodosLosClientes.isEmpty()) {
            ComprobarTamanioDeClientes(TurnoDecajero);
        }
        switch (TurnoDecajero) {
            case 1:
                TurnoGlobales = TodosLosClientes.size() - 1;
                Cliente_de_Cajero_1 = TodosLosClientes.get(TurnoGlobales);
                EliminarClienteAtendido();
                System.out.println("Inciando las operaciones del Cajero 1");

                System.out.println("Colocando el espacio del cliente -Cajero 1");
                EspaciosDeClientes.get(0).setBackground(Cliente_de_Cajero_1.getColores());
                RealizarPausa(3);

                System.out.println("Colocando el tipo de cliente -Cajero 1");
                TipoDeClientes.get(0).setText(Cliente_de_Cajero_1.getTipoDeCliente().toString());
                RealizarPausa(3);

                System.out.println("Colocando el tipo de Operacion -Cajero 1");
                Operaciones.get(0).setText(Cliente_de_Cajero_1.getTransaccion().toString());
                RealizarPausa(3);

                Cambio_1 = Cambio_1 + ((Cliente_de_Cajero_1.getDienero()) / 25);
                System.out.println("El tiempo de espera es de: " + (Cambio_1 + TiempoCajero_1));

                System.out.println("Colocando el Monto -Cajero 1");
                Montos.get(0).setText("L. " + Integer.toString(Cliente_de_Cajero_1.getDienero()));
                RealizarPausa(3);
                System.out.println("Fin del proceso para el  Cajero 1");
                break;
            case 2:
                TurnoGlobales = TodosLosClientes.size() - 1;
                System.out.println("Inciando las operaciones del Cajero 2");
                Cliente_de_Cajero_2 = TodosLosClientes.get(TurnoGlobales);
                EliminarClienteAtendido();
                System.out.println("Colocando el espacio del cleinte -Cajero 2");

                System.out.println("Colocando el espacio del cliente -Cajero 2");
                EspaciosDeClientes.get(1).setBackground(Cliente_de_Cajero_2.getColores());
                RealizarPausa(3);

                System.out.println("Colocando el tipo de cliente -Cajero 2");
                TipoDeClientes.get(1).setText(Cliente_de_Cajero_2.getTipoDeCliente().toString());
                RealizarPausa(3);

                System.out.println("Colocando el tipo de Operacion -Cajero 2");
                Operaciones.get(1).setText(Cliente_de_Cajero_2.getTransaccion().toString());
                RealizarPausa(3);

                Cambio_2 = Cambio_2 + ((Cliente_de_Cajero_2.getDienero()) / 25);
                System.out.println("El tiempo de espera es de: " + (Cambio_2 + TiempoCajero_2));

                System.out.println("Colocando el Monto -Cajero 2");
                Montos.get(1).setText("L. " + Integer.toString(Cliente_de_Cajero_2.getDienero()));
                RealizarPausa(3);
                System.out.println("Fin del proceso para el  Cajero 2");
                break;
            case 3:
                TurnoGlobales = TodosLosClientes.size() - 1;
                System.out.println("Inciando las operaciones del Cajero 3");
                Cliente_de_Cajero_3 = TodosLosClientes.get(TurnoGlobales);
                EliminarClienteAtendido();
                System.out.println("Colocando el espacio del cliente -Cajero 3");
                EspaciosDeClientes.get(2).setBackground(Cliente_de_Cajero_3.getColores());
                RealizarPausa(3);

                System.out.println("Colocando el tipo de cliente -Cajero 3");
                TipoDeClientes.get(2).setText(Cliente_de_Cajero_3.getTipoDeCliente().toString());
                RealizarPausa(3);

                System.out.println("Colocando el tipo de Operacion -Cajero 3");
                Operaciones.get(2).setText(Cliente_de_Cajero_3.getTransaccion().toString());
                RealizarPausa(3);

                Cambio_3 = Cambio_3 + ((Cliente_de_Cajero_3.getDienero()) / 25);
                System.out.println("El tiempo de espera es de: " + (Cambio_3 + TiempoCajero_3));
                System.out.println("Colocando el Monto -Cajero 3");

                Montos.get(2).setText("L. " + Integer.toString(Cliente_de_Cajero_3.getDienero()));
                RealizarPausa(3);
                System.out.println("Fin del proceso para el  Cajero 3");
                break;
        }

    }

    private static void EliminarClienteAtendido() throws InterruptedException {

        Asientos.get(TurnoGlobales).setBackground(Color.DARK_GRAY);
        Asientos.get(TurnoGlobales).setForeground(Color.WHITE);
        Asientos.get(TurnoGlobales).setOpaque(true);

        TodosLosClientes.remove(TurnoGlobales);
        CambiarColorAsientos();

    }

    private static void CambiarColorAsientos() throws InterruptedException {

        System.out.println("Tamaño del Arreglo de Clientes: " + TodosLosClientes.size());
        ColocarLosClientesEnLosAsientos();

        if (TurnoGlobales < 3) {
            CrearClientesNuevos = 7;
            CrearClientesNuevos(CrearClientesNuevos);
        }

    }

    private static void CrearClientesNuevos(int NuevosClientes) throws InterruptedException {
        for (int i = 0; i < NuevosClientes; i++) {
            System.out.println("Se esta creando el Cliente Nuevo NUMERO: " + (i + 1));
            Thread.sleep(10);
            Clientes.CreandoCliente();
        }
        TodosLosClientes = Clientes.RecuperarClientes();
        ColocarLosClientesEnLosAsientos();
    }

    private static void IniciarLosCajeros() throws InterruptedException {

        //CambiarVelocidadDeCarga(1, 1);
        Thread.sleep(500);
        ContinuarProceso(1);
        Cajero1.start();

        Thread.sleep(500);
        ContinuarProceso(2);
        Cajero2.start();

        Thread.sleep(500);
        ContinuarProceso(3);
        Cajero3.start();
    }

    private static void ColocarLosClientesEnLosAsientos() {
        int RetrocederEspacios = 0;
//Probando el comportamiento
        for (int i = 9; i > 9 - TodosLosClientes.size(); i--) {
            RetrocederEspacios++;
            Asientos.get(i).setBackground(TodosLosClientes.get(TodosLosClientes.size() - RetrocederEspacios).getColores());
            Asientos.get(i).setForeground(Color.BLACK);
            Asientos.get(i).setOpaque(true);

        }
        RetrocederEspacios = 0;
        for (int K = 0; K <= 9 - TodosLosClientes.size(); K++) {
            Asientos.get(K).setBackground(Color.DARK_GRAY);
            Asientos.get(K).setForeground(Color.WHITE);
        }
    }

   
    private static void ComprobarTamanioDeClientes(int CajeroAComprobar) {

        switch (CajeroAComprobar) {
            case 1:
                System.out.println("El ArrayList de Clientes esta Vacio");

                Montos.get(0).setText("N/D");
                TipoDeClientes.get(0).setText("N/D");
                Operaciones.get(0).setText("N/D");
                Montos.get(0).setForeground(Color.red);
                TipoDeClientes.get(0).setBackground(Color.black);
                Operaciones.get(0).setOpaque(true);
                break;
            case 2:
                Montos.get(1).setText("N/D");
                TipoDeClientes.get(1).setText("N/D");
                Operaciones.get(1).setText("N/D");
                Montos.get(1).setForeground(Color.red);
                TipoDeClientes.get(1).setBackground(Color.black);
                Operaciones.get(1).setOpaque(true);
                break;
            case 3:
                Montos.get(2).setText("N/D");
                TipoDeClientes.get(2).setText("N/D");
                Operaciones.get(2).setText("N/D");
                Montos.get(2).setForeground(Color.red);
                TipoDeClientes.get(2).setBackground(Color.black);
                Operaciones.get(2).setOpaque(true);
                break;
        }

    }

    private static void RealizarPausa(int TiempoDePausa) throws InterruptedException {
        Thread.sleep(TiempoDePausa * 100);
    }
}
