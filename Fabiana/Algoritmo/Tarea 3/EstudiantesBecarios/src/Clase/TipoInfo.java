package Clase;

public class TipoInfo {

    private int numeroCuenta;


    private String estudioCarrera;
    private int edad;
    private boolean Beca;

    public TipoInfo() {

        this.numeroCuenta = 0;
        this.edad = 0;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }


    public int getEdad() {
        return edad;
    }


    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEstudioCarrera() {
        return estudioCarrera;
    }

    public void setEstudioCarrera(String estudioCarrera) {
        this.estudioCarrera = estudioCarrera;
    }

    public boolean isBeca() {
        return Beca;
    }

    public void setBeca(boolean Beca) {
        this.Beca = Beca;
    }

}
