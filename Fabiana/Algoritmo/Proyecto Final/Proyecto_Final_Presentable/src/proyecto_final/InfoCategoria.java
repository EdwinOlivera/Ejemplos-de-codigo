
package proyecto_final;

public class InfoCategoria {

    private String nombreCategoria;
    private int numeroCorrelativo;

    public InfoCategoria() {
        this.nombreCategoria = "";
        this.numeroCorrelativo = 1;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public int getNumeroCorrelativo() {
        return numeroCorrelativo;
    }

    public void setNumeroCorrelativo(int numeroCorrelativo) {
        this.numeroCorrelativo = numeroCorrelativo;
    }
}
