
package proyecto_final;


public class TipoNodoPalabra {

    private TipoNodoPalabra sig;
    private TipoNodoPalabra ant;
    private InfoPalabra infoPalabra;

    public TipoNodoPalabra() {
        this.infoPalabra = null;
        this.sig = null;
        this.ant = null;

    }

    public TipoNodoPalabra getSig() {
        return sig;
    }

    public void setSig(TipoNodoPalabra sig) {
        this.sig = sig;
    }

    public TipoNodoPalabra getAnt() {
        return ant;
    }

    public void setAnt(TipoNodoPalabra ant) {
        this.ant = ant;
    }

    public InfoPalabra getInfoPalabra() {
        return infoPalabra;
    }

    public void setInfoPalabra(InfoPalabra infoPalabra) {
        this.infoPalabra = infoPalabra;
    }
}
