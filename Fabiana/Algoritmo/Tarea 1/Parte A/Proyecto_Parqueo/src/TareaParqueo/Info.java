/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TareaParqueo;

/**
 *
 * @author yamap
 */
public class Info {
    private String placa;
    private int apartamento;
    
    public Info() {
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
