package listadoble;

/**
 *
 * @author Ricardo Rivera
 */
public class TipoInfoJugador {

    String nombreJugador;
    int posicionActual;

    public TipoInfoJugador() {
        this.nombreJugador = "";
        this.posicionActual = 0;
    }

    public int getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(int posicionActual) {
        this.posicionActual = posicionActual;
    }


    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

}
