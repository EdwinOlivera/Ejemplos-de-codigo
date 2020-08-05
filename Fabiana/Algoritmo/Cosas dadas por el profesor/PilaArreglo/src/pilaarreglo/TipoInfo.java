package pilaarreglo;
/**
 * Definición de datos del TAD
 * @author Ricardo López
 */
public class TipoInfo {

    private String placa;
    private int apartamento;

    public TipoInfo() {
        this.placa = "";
        this.apartamento = 0;
    }

    public String getPlaca() {
        return placa;
    }

    public int getApartamento() {
        return apartamento;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setApartamento(int apartamento) {
        this.apartamento = apartamento;
    }


}