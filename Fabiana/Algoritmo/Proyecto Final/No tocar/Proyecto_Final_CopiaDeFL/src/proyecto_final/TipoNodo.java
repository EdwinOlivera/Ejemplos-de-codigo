
package proyecto_final;

/**
 *
 * @author Olivera
 */
public class TipoNodo {

    private TipoNodo sig;
    private TipoNodo ant;
    private InfoPalabra infoPalabra;
    private InfoCategoria categoria;

    public InfoCategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(InfoCategoria categoria) {
        this.categoria = categoria;
    }

    public TipoNodo() {
        this.infoPalabra = null;
        this.sig = null;
        this.ant = null;

    }

    public TipoNodo getSig() {
        return sig;
    }

    public void setSig(TipoNodo sig) {
        this.sig = sig;
    }

    public TipoNodo getAnt() {
        return ant;
    }

    public void setAnt(TipoNodo ant) {
        this.ant = ant;
    }

    public InfoPalabra getInfoPalabra() {
        return infoPalabra;
    }

    public void setInfoPalabra(InfoPalabra infoPalabra) {
        this.infoPalabra = infoPalabra;
    }
}
