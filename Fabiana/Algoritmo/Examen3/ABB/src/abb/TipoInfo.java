package abb;


public class TipoInfo {

    private String palabra;
    private int numero;

    public TipoInfo() {
        this.numero = 0;
        this.palabra="";
    }

    public int getNumero() {
        return numero;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }


}
