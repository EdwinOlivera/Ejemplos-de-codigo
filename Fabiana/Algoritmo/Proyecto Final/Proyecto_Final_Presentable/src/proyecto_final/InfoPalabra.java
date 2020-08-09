
package proyecto_final;

public class InfoPalabra {

    private String termino;
    private String significado;
    private InfoCategoria categoria;
    private int numeroCorrelativo;

    public InfoPalabra() {
        this.termino = "";
        this.significado = "";
        this.categoria = null;
        this.numeroCorrelativo = 1;
    }

    public String getTermino() {
        return termino;
    }

    public void setTermino(String termino) {
        this.termino = termino;
    }

    public String getSignificado() {
        return significado;
    }

    public void setSignificado(String significado) {
        this.significado = significado;
    }

    public InfoCategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(InfoCategoria categoria) {
        this.categoria = categoria;
    }

    public int getNumeroCorrelativo() {
        return numeroCorrelativo;
    }

    public void setNumeroCorrelativo(int numeroCorrelativo) {
        this.numeroCorrelativo = numeroCorrelativo;
    }

}
