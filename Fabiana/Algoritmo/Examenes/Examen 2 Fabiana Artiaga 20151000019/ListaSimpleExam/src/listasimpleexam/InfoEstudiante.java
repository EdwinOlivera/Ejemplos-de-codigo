/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listasimpleexam;

/**
 *
 * @author Olivera
 */
public class InfoEstudiante {

    private int nota1 ;
    private int nota2 ;
    private String numeroDecuenta;
    private int SemanaALaCualPertenece;

    public InfoEstudiante() {
        this.nota1 = 0;
        this.nota2 = 0;
        this.numeroDecuenta = "";
        this.SemanaALaCualPertenece = 0;
    }

    public int getNota1() {
        return nota1;
    }

    public void setNota1(int nota1) {
        this.nota1 = nota1;
    }

    public int getNota2() {
        return nota2;
    }

    public void setNota2(int nota2) {
        this.nota2 = nota2;
    }

    public String getNumeroDecuenta() {
        return numeroDecuenta;
    }

    public void setNumeroDecuenta(String numeroDecuenta) {
        this.numeroDecuenta = numeroDecuenta;
    }

    public int getSemanaALaCualPertenece() {
        return SemanaALaCualPertenece;
    }

    public void setSemanaALaCualPertenece(int SemanaALaCualPertenece) {
        this.SemanaALaCualPertenece = SemanaALaCualPertenece;
    }

}
