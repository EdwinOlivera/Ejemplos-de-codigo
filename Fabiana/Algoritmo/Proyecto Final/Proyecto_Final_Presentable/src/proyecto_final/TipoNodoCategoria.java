
package proyecto_final;

public class TipoNodoCategoria {

    private TipoNodoCategoria sig;
    private TipoNodoCategoria ant;

    private InfoCategoria infoCategoria;

    public InfoCategoria getInfoCategoria() {
        return infoCategoria;
    }

    public void setInfoCategoria(InfoCategoria infoCategoria) {
        this.infoCategoria = infoCategoria;
    }

    public TipoNodoCategoria() {

        this.sig = null;
        this.ant = null;

    }

    public TipoNodoCategoria getSig() {
        return sig;
    }

    public void setSig(TipoNodoCategoria sig) {
        this.sig = sig;
    }

    public TipoNodoCategoria getAnt() {
        return ant;
    }

    public void setAnt(TipoNodoCategoria ant) {
        this.ant = ant;
    }


}
