package listadoble;

/**
 *
 * @author Ricardo Rivera
 */
public class TipoInfo {

    String nombreCasilla;
    TipoInfoJugador jugadorA;
    TipoInfoJugador jugadorB;

    public TipoInfo() {
        this.nombreCasilla = "";

    }

    public TipoInfoJugador getJugadorB() {
        return jugadorB;
    }

    public void setJugadorB(TipoInfoJugador jugadorB) {
        this.jugadorB = jugadorB;
    }

    public TipoInfoJugador getJugadorA() {
        return jugadorA;
    }

    public void setJugadorA(TipoInfoJugador jugadorA) {
        this.jugadorA = jugadorA;
    }

    public String getNombreCasilla() {
        return nombreCasilla;
    }

    public void setNombreCasilla(String nombreCasilla) {
        this.nombreCasilla = nombreCasilla;
    }

}
