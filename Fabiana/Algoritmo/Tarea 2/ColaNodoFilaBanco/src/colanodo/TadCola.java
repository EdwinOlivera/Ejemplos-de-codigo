/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colanodo;

/**
 *
 * @author Ricardo Rivera
 */
public class TadCola {

    private TipoNodo inicio;
    private TipoNodo fin;
    private int ulTicketNormal;
    private int ulTicketPrioridad;
private int contar;
    //operaciones fundamentales
    //constructor
    public TadCola() {
        this.contar= 0;
        this.inicio = null;
        this.fin = null;
        this.ulTicketPrioridad = 1000;
        this.ulTicketNormal = 2000;
    }

    //ColaVacia
    public boolean ColaVacia() {
        if (this.inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    //meter
    public void Meter(TipoInfo pDatos) {
        TipoNodo nuevo;
        nuevo = new TipoNodo();
        nuevo.setInfo(pDatos);
        pDatos.setTicket(AsignarTicket(pDatos));
        nuevo.setSig(null);
        if (this.ColaVacia()) {
            this.inicio = nuevo;
            this.fin = nuevo;
        } else {
            this.fin.setSig(nuevo);
            this.fin = nuevo;
        }
        this.contar++;
    }

    private int AsignarTicket(TipoInfo Datos) {

        int tickeAsignado = 0;
        switch (Datos.getCondicion()) {
            case "Normal":
                this.ulTicketNormal++;
                tickeAsignado = this.ulTicketNormal;
                break;
            case "Priodidad":
                this.ulTicketPrioridad++;
                tickeAsignado = this.ulTicketPrioridad;
                break;
        }

        return tickeAsignado;
    }

    //ver inicio
    public TipoInfo verInicio() {
        TipoInfo temp;
        if (this.ColaVacia()) {
            return null;
        } else {
            temp = this.inicio.getInfo();
        }
        return temp;
    }

    //sacar
    public TipoInfo Sacar() {
        TipoInfo temp;
        TipoNodo aux;
        if (this.ColaVacia()) {
            return null;
        } else {
            temp = this.inicio.getInfo();
            aux = this.inicio.getSig();
            this.inicio = aux;
        }
        return temp;
    }

    
    public TipoNodo getInicio() {
        return inicio;
    }
//Funcion creada con el objetivo de retornar un objeto del conjunto para ser guardado en un conjunto temporal
    public TipoInfo RetornarElementoInversa( int numeroDeObjeto) {
        TipoInfo dato = new TipoInfo();
        int objetoLimite = 0;
        TipoNodo Aux;
        if (!this.ColaVacia()) {
            Aux = this.inicio;
            while (objetoLimite <= numeroDeObjeto) {
                objetoLimite++;
                
                dato = Aux.getInfo();
                Aux = Aux.getSig();
            }
        }
        return dato;
    }
    public int CantidadElementos() {
        return this.contar;
    }

}
