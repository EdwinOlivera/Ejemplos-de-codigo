/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesClientes;

import java.awt.Color;

/**
 *
 * @author Edwin
 */
public class PropiedadesClientes {

    public PropiedadesClientes() {
    }

    public Color Colores;
    public int Dienero = 0;
    public int Turno = -1;

    public enum TipoDeClientes {
        NORMAL, TERCERA_EDAD, MUJER_EMBARAZADA, DISCAPACITADO;
    }

    public enum TipoDeTransacciones {
        DEPOSITO, RETIRO, PAGO;
    }

    //set y get

    public TipoDeClientes getTipoDeCliente() {
        return TipoDeCliente;
    }

    public void setTipoDeCliente(TipoDeClientes TipoDeCliente) {
        this.TipoDeCliente = TipoDeCliente;
    }

    public Color getColores() {
        return Colores;
    }

    public void setColores(Color Colores) {
        this.Colores = Colores;
    }

    public TipoDeTransacciones getTransaccion() {
        return Transaccion;
    }

    public void setTransaccion(TipoDeTransacciones Transaccion) {
        this.Transaccion = Transaccion;
    }

    public int getDienero() {
        return Dienero;
    }

    public void setDienero(int Dienero) {
        this.Dienero = Dienero;
    }

    public int getTurno() {
        return Turno;
    }

    public void setTurno(int Turno) {
        this.Turno = Turno;
    }
    //objetos 
    TipoDeClientes TipoDeCliente = TipoDeClientes.NORMAL;
    TipoDeTransacciones Transaccion = TipoDeTransacciones.DEPOSITO;
}
