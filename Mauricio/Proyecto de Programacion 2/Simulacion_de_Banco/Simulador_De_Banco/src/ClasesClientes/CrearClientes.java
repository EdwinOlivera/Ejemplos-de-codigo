
package ClasesClientes;

  
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;


public class CrearClientes extends PropiedadesClientes {

    // Objetos 
    PropiedadesClientes Clientes;
    //ArrayList
    private static ArrayList<PropiedadesClientes> GrupoClientes = new ArrayList<>();
    //Variables de usos
    private static Random RMD = new Random(System.currentTimeMillis());//La variable de Randon
    private static Random RandoMonto = new Random(System.currentTimeMillis());//La variable de Randon

    int MONTO = 0;
    private static int TurnosNormales = 0, TurnosEspeciales = 10, EspacioDeGuardado=0;
    int DesignarTranaccion = -1;
    int DesignarTipoDeClientes = -1;

    public void CreandoCliente() throws InterruptedException {
        Clientes = new PropiedadesClientes();

        System.out.println("Se esta Creando un Cliente Nuevo");
        EstablecerTipoDeCliente();
        EstablcerTurno();
        EstablcerColor();
        EstablecerTransaccion();
        EstablecerMonto();

        GrupoClientes.add(Clientes);
 
         
        if (!GrupoClientes.isEmpty()) {
            System.out.println("La cantidad de Clientes Actuales son " + getGrupoClientes().size());
            System.out.println("Se han guardado exitosamente un cliente");
        }
    }

    public ArrayList<PropiedadesClientes> RecuperarClientes() {
        System.out.println("\nSe esta enviando el ArrayList de Clientes\n");
        return getGrupoClientes();
    }

    private void EstablecerTransaccion() {
        System.out.println("*******************************************");
        System.out.println("Se esta Asignado La Transaccion");
        DesignarTranaccion = RMD.nextInt(3);

        switch (DesignarTranaccion) {
            case 0:
                Clientes.setTransaccion(TipoDeTransacciones.DEPOSITO);
                break;
            case 1:
                Clientes.setTransaccion(TipoDeTransacciones.PAGO);
                break;
            case 2:
                Clientes.setTransaccion(TipoDeTransacciones.RETIRO);
                break;
            default:
                System.out.println("La Asignacion de la Transaccion esta fuera de Rango");
                break;
        }
        System.out.println("\nLa Transaccion que se establecio es: " + Clientes.getTransaccion() + "\n");
        System.out.println("*******************************************");
    }

    private void EstablecerMonto() {
        System.out.println("*******************************************");
        System.out.println("Se esta Asignado El Monto");
        RMD.setSeed(System.currentTimeMillis());
        RandoMonto.setSeed(System.currentTimeMillis());
        MONTO = RMD.nextInt(6);
        MONTO++;

        System.out.println("La opcion establecida es: " + MONTO);

        switch (MONTO) {
            case 1:
                MONTO = RMD.nextInt(501);
              
                break;
            case 2:
                MONTO = RandoMonto.nextInt(501);
                break;
            case 3:
                MONTO = RMD.nextInt(502 + 2001);
                break;
            case 4:
                MONTO = RandoMonto.nextInt(2002 + 5001);
                break;
            case 5:
                MONTO = RandoMonto.nextInt(5002 + 10001);
                break;
            case 6:
                MONTO = RandoMonto.nextInt(10002 + 15001);
                break;
            default:
                System.out.println("La asignacion de monto se ha salido del rango");
                MONTO = 0;
                break;
        }
        MONTO += 50;
        System.out.println("\nEl monto que se establecido es: " + MONTO + "\n");

        System.out.println("*******************************************");
        Clientes.setDienero(MONTO);
    }

    private void EstablecerTipoDeCliente() throws InterruptedException {
        System.out.println("*******************************************");
        System.out.println("Se esta Asignado El Tipo de Cliente");
        Thread.sleep(50);
        RMD.setSeed(System.currentTimeMillis());
        DesignarTipoDeClientes = RMD.nextInt()%5-1;


        switch (DesignarTipoDeClientes) {
            case 0:
                Clientes.setTipoDeCliente(TipoDeClientes.NORMAL);
                break;
            case 1:
                Clientes.setTipoDeCliente(TipoDeClientes.DISCAPACITADO);
                break;
            case 2:
                Clientes.setTipoDeCliente(TipoDeClientes.MUJER_EMBARAZADA);
                break;
            case 3:
                Clientes.setTipoDeCliente(TipoDeClientes.TERCERA_EDAD);
                break;
            default:
                System.out.println("La Asignacion del Tipo de Cliente esta fuera de Rango");
                break;

        }
        System.out.println("\nEl Tipo de Cliente que se establecio es: " + Clientes.getTipoDeCliente() + "\n");

        System.out.println("*******************************************");
    }

    private void EstablcerTurno() {
        System.out.println("Se Esta Estableciendo El Turno del Cliente");
        if (Clientes.getTipoDeCliente() != TipoDeClientes.NORMAL) {
            Clientes.setTurno(TurnosEspeciales);
            for (int i = 0; i < getGrupoClientes().size(); i++) {
                getGrupoClientes().get(i).setTurno(getGrupoClientes().get(i).getTurno() - 1);
            }
            TurnosEspeciales--;
        } else {
            Clientes.setTurno(TurnosNormales);
            TurnosNormales++;
        }

        if (TurnosEspeciales < 0) {
            TurnosEspeciales = 10;
        }
        if (TurnosNormales > 10) {
            TurnosNormales = 0;
        }
    }

    private void EstablcerColor() {
        switch (Clientes.getTipoDeCliente()) {
            case NORMAL:
                Clientes.setColores(Color.ORANGE);
                break;
            case DISCAPACITADO:
                Clientes.setColores(Color.red);
                break;
            case MUJER_EMBARAZADA:
                Clientes.setColores(Color.GREEN);
                break;
            case TERCERA_EDAD:
                Clientes.setColores(Color.YELLOW);
                break;
            default:
                System.err.println("Se ha salido del Rango El establecimeinto de Colores");
                Clientes.setColores(Color.BLACK);
                break;
        }
        System.out.println("\nEl color que se establecio es: " + Clientes.getColores() + "\n");
    }

    /**
     * @return the GrupoClientes
     */
    public static ArrayList<PropiedadesClientes> getGrupoClientes() {
        return GrupoClientes;
    }

    /**
     * @param aGrupoClientes the GrupoClientes to set
     */
    public static void setGrupoClientes(ArrayList<PropiedadesClientes> aGrupoClientes) {
        GrupoClientes = aGrupoClientes;
    }
}
