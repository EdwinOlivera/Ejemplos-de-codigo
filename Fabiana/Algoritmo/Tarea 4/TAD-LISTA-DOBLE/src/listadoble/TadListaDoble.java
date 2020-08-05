package listadoble;

//Definición del TAD y operaciones 
import java.util.Scanner;

public class TadListaDoble {

    private TipoNodo inicio;
    private TipoNodo fin;
    private int contarCasilla;//Variable que cuenta cuantas casillas hay que recorrer
    private final TipoInfo tmpInfoJugador; //Objeto que guarda temporal la informacion de los jugadores
    private final TipoInfoJugador jugadorA = new TipoInfoJugador();
    private final TipoInfoJugador jugadorB = new TipoInfoJugador();
    private boolean juegoTerminado;//Variable que controla el estado del juego (Si termino o no)

    //constructores
    public TadListaDoble() {
        this.juegoTerminado = false;
        this.inicio = null;
        this.fin = null;
        this.contarCasilla = 0;
        tmpInfoJugador = new TipoInfo();
    }

    //operaciones TAD
    public boolean Vacia() {
        if (this.inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    //Por motivos esteticos esta funcion ingresa las casillas desde el inicia y crea una conexion con los espacios Null del Ant del Inicio
    //De esta forma se puede mostrar el Inicio del juego en la parte inferior y los calculos de movimiento son mas faciles de lograr
    public void Intertar(TipoInfo pDato) {
        TipoNodo nuevo = new TipoNodo();
        nuevo.setInfo(pDato);
        if (this.Vacia()) {
            this.inicio = nuevo;
            this.fin = nuevo;
        } else {
            nuevo.setSig(this.inicio);
            this.inicio.setAnt(nuevo);
            this.inicio = nuevo;
        }

    }

    // FUNCIONES CREADAS PARA EL JUEGO
    //Metodo encargado de hacer que los jugadores ingresen sus nombres
    public void IngresarNombreJugadores() {
        String tmpString = "";
        Scanner teclado = new Scanner(System.in);

        //Bloque que guarda el nombre de los jugadores
        System.out.println("Ingrese nombre de jugador A");
        tmpString = teclado.nextLine();
        this.jugadorA.setNombreJugador(tmpString);
        this.tmpInfoJugador.setJugadorA(jugadorA);

        System.out.println("Ingrese nombre de jugador B");
        tmpString = teclado.nextLine();
        this.jugadorB.setNombreJugador(tmpString);
        this.tmpInfoJugador.setJugadorB(jugadorB);
        ////********************************************************

        tmpInfoJugador.setNombreCasilla("Inicio");//Este es mensaje que indica donde comienza el juego

        this.inicio.setInfo(tmpInfoJugador);

    }

    //Metodo encargado de mostrar la posicion actual de los jugadores y de cuantas casillas son las que hay que recorrer
    public void MostrarEstadoActualDelJuego() {
        TipoNodo Aux;
        TipoInfo tmpDato;
        int contar = getCantidadCasillas();
        if (this.Vacia()) {
            System.out.println("Lista vacía!!");
        } else {
            Aux = this.fin;
            while (Aux != null) {
                contar--;
                tmpDato = Aux.getInfo();
                if (tmpDato.getJugadorA() == null && tmpDato.getJugadorB() == null) {
                    System.out.println("   -->  " + tmpDato.getNombreCasilla() + "   <--  ");
                } else if (tmpDato.getJugadorA() == null) {
                    System.out.println("   -->  " + tmpDato.getNombreCasilla() + " --> " + tmpDato.getJugadorB().getNombreJugador());
                } else if (tmpDato.getJugadorB() == null) {
                    System.out.println("   -->  " + tmpDato.getNombreCasilla() + " --> " + tmpDato.getJugadorA().getNombreJugador());
                } else {
                    System.out.println("   -->  " + tmpDato.getNombreCasilla() + " --> " + tmpDato.getJugadorA().getNombreJugador() + ", " + tmpDato.getJugadorB().getNombreJugador());
                }

                Aux = Aux.getAnt();
            }//fin while
        }//fin si
    }

    //Este metodo hace avanzar al jugador A la cantidad que se le indique el paramentro "posicionAvanzar"
    //Y ademas verifica si se encuentra el jugador B en la misma casilla en la que se coloca al jugador A
    public void AvanzarJugadorA(int posicionAvanzar) {

        int posicionActualJuagadorA = this.jugadorA.getPosicionActual();
        TipoNodo Aux;
        TipoInfo tmpDato;
        Aux = this.fin;
        while (Aux != null) {
            tmpDato = Aux.getInfo();

            if (tmpDato.getJugadorA() != null) {
                Aux.getInfo().setJugadorA(null);
                break;
            }
            Aux = Aux.getAnt();
        }//fin while

        if ((posicionAvanzar + posicionActualJuagadorA) < getCantidadCasillas()) {

            this.jugadorA.setPosicionActual(posicionActualJuagadorA + posicionAvanzar);
        } else {
            posicionAvanzar = (getCantidadCasillas() - 1) - posicionActualJuagadorA;

            this.jugadorA.setPosicionActual(posicionActualJuagadorA + posicionAvanzar);
        }

        posicionActualJuagadorA = this.jugadorA.getPosicionActual();

        int objetoLimite = getCantidadCasillas() - 1;

        if (!this.Vacia()) {
            Aux = this.fin;
            while (objetoLimite > posicionActualJuagadorA) {

                objetoLimite--;
                Aux = Aux.getAnt();
            }
            Aux.getInfo().setJugadorA(jugadorA);
        }
        if (Aux.getInfo().getJugadorA() != null && Aux.getInfo().getJugadorB() != null) {
            RegresarAlInicio(posicionActualJuagadorA, "jugadorB");
        }
        VerificarPosicion(posicionActualJuagadorA);

    }

    //Este metodo hace avanzar al jugador B la cantidad que se le indique el paramentro "posicionAvanzar"
    //Y ademas verifica si se encuentra el jugador A en la misma casilla en la que se coloca al jugador B
    public void AvanzarJugadorB(int posicionAvanzar) {

        int posicionActualJuagadorB = this.jugadorB.getPosicionActual();
        TipoNodo Aux;
        TipoInfo tmpDato;

        Aux = this.fin;
        while (Aux != null) {
            tmpDato = Aux.getInfo();

            if (tmpDato.getJugadorB() != null) {
                Aux.getInfo().setJugadorB(null);
                break;
            }
            Aux = Aux.getAnt();
        }//fin while

        if ((posicionAvanzar + posicionActualJuagadorB) < getCantidadCasillas()) {

            this.jugadorB.setPosicionActual(posicionActualJuagadorB + posicionAvanzar);
        } else {
            posicionAvanzar = (getCantidadCasillas() - 1) - posicionActualJuagadorB;

            this.jugadorB.setPosicionActual(posicionActualJuagadorB + posicionAvanzar);

        }

        posicionActualJuagadorB = this.jugadorB.getPosicionActual();

        int objetoLimite = getCantidadCasillas() - 1;

        if (!this.Vacia()) {

            Aux = this.fin;
            while (objetoLimite > posicionActualJuagadorB) {

                objetoLimite--;
                Aux = Aux.getAnt();
            }
            Aux.getInfo().setJugadorB(jugadorB);
        }
        if (Aux.getInfo().getJugadorA() != null && Aux.getInfo().getJugadorB() != null) {
            RegresarAlInicio(posicionActualJuagadorB, "jugadorA");
        }
        VerificarPosicion(posicionActualJuagadorB);
    }

    // Este metodo verifica si la posicion del jugador actual esta en la casilla final
    public void VerificarPosicion(int posicionAVerificar) {
        if (posicionAVerificar == getCantidadCasillas() - 1) {
            this.juegoTerminado = true;

        }
    }

    // Con este metodo retorna al jugador que fue "botado" de su posicion y es enviado al inicio
    // para que comienze de nuevo desde la posicion inicial
    public void RegresarAlInicio(int posicionJuagador, String jugadorAReiniciar) {
        TipoNodo Aux = new TipoNodo();

        int objetoLimite = getCantidadCasillas() - 1;
        if (!this.Vacia()) {

            Aux = this.fin;
            while (objetoLimite > posicionJuagador) {

                objetoLimite--;
                Aux = Aux.getAnt();
            }

        }
        switch (jugadorAReiniciar) {
            case "jugadorA":
                Aux.getInfo().setJugadorA(null);
                this.jugadorA.setPosicionActual(0);
                this.inicio.getInfo().setJugadorA(this.jugadorA);
                break;
            case "jugadorB":
                Aux.getInfo().setJugadorB(null);
                this.jugadorB.setPosicionActual(0);
                this.inicio.getInfo().setJugadorB(this.jugadorB);
                break;
        }

    }
    
    //Este es el metodo que restaura todos los valores importanes a su estado orginal una vez 
    //que se acaba el juego
    public void ReinicarEstado() {

        TipoNodo Aux;
        TipoInfo tmpDato;
        Aux = this.fin;

        //Ciclo que elimina la referencias de los jugadores donde hayan quedado
        while (Aux != null) {
            tmpDato = Aux.getInfo();

            if (tmpDato.getJugadorA() != null) {
                Aux.getInfo().setJugadorA(null);

            }
            if (tmpDato.getJugadorB() != null) {
                Aux.getInfo().setJugadorA(null);
            }
            Aux = Aux.getAnt();
        }//fin while

        //Reiniciando posicion de los jugadores
        this.jugadorA.setPosicionActual(0);
        this.jugadorB.setPosicionActual(0);

        this.inicio.getInfo().setJugadorA(jugadorA);
        this.inicio.getInfo().setJugadorB(jugadorB);

    }
    // gets

    //Retorna el valor de la Variable "juegoTerminado" el cual verifica el estado actual del juego
    public boolean getJuegoTerminado() {
        return this.juegoTerminado;
    }

    //Este metodo retorna el inicio del camino (casillas)
    public TipoNodo getInicio() {
        return this.inicio;
    }

    // Este metodo retorna el final del camino (casillas)
    public TipoNodo getFinal() {
        return this.fin;
    }

    //Este metodo retorna la posicion actual del jugador A
    public int getPosicionJugadorA() {
        return this.jugadorA.getPosicionActual();
    }

    //Este metodo retorna la posicion actual del jugador B
    public int getPosicionJugadorB() {
        return this.jugadorB.getPosicionActual();
    }

    //Este metodo envia el nombre del jugador A
    public String getNombreJugadorA() {
        return this.jugadorA.getNombreJugador();
    }

    //Este metodo envia el nombre del jugador B
    public String getNombreJugadorB() {
        return this.jugadorB.getNombreJugador();
    }

    //Metodo que cuenta la cantidad de casillas que se tiene en el juego
    public int getCantidadCasillas() {
        TipoNodo Aux;
        this.contarCasilla = 0;
        if (this.Vacia()) {
            System.out.println("Lista vacía!!");
        } else {
            Aux = this.inicio;
            while (Aux != null) {
                this.contarCasilla++;

                Aux = Aux.getSig();
            }//fin while
        }
        return this.contarCasilla;
    }

}
