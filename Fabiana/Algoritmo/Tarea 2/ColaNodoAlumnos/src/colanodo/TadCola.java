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
    private int ulTicketOT;
    private int ulTicketEH;
    private int ulTicketEC;
    private int ulTicketRN;
    private int ulTicketCA;

    //operaciones fundamentales
    //constructor
    public TadCola() {
        this.inicio = null;
        this.fin = null;
        this.ulTicketEH = 1000;
        this.ulTicketEC = 2000;
        this.ulTicketRN = 3000;
        this.ulTicketOT = 5000;
        this.ulTicketCA = 4000;
    }

    //ColaVacia
    public boolean ColaVacia() {
        if(this.inicio == null) {
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
    }

    //meter prioridad
    public void MeterP(TipoInfo pDatos) {
        TipoNodo nuevo;
        TipoInfo DatoNodo;
        TipoNodo aux, auxAnt;
        boolean encontro = false;
        nuevo = new TipoNodo();
        nuevo.setInfo(pDatos);

        nuevo.setSig(null);
        if (this.ColaVacia()) {
            this.Meter(pDatos); //Caso 1 
        } else {
            //Caso 2
            aux = this.inicio;
            DatoNodo = aux.getInfo();
            if (DatoNodo.getPrioridad() > pDatos.getPrioridad()) {

                pDatos.setTicket(AsignarTicket(pDatos));
                nuevo.setSig(aux);
                this.inicio = nuevo;
            } else {
                //Caso 3
                aux = this.inicio.getSig();
                auxAnt = this.inicio;
                while ((aux != null) && (encontro == false)) {
                    //meter en medio
                    DatoNodo = aux.getInfo();
                    if (DatoNodo.getPrioridad() > pDatos.getPrioridad()) {

                        pDatos.setTicket(AsignarTicket(pDatos));
                        nuevo.setSig(aux);
                        auxAnt.setSig(nuevo);
                        encontro = true;
                    }
                    auxAnt = aux;
                    aux = aux.getSig();
                }
                if (!encontro) {
                    this.Meter(pDatos);
                }
            }
        }

    }

    private int AsignarTicket(TipoInfo Datos) {

        int tickeAsignado = 0;
        switch (Datos.getTipoDeOperacion()) {
            case "OT":
                this.ulTicketOT++;
                tickeAsignado = this.ulTicketOT;
                break;
            case "EC":
                this.ulTicketEC++;
                tickeAsignado = this.ulTicketEC;
                break;
            case "RN":
                this.ulTicketRN++;
                tickeAsignado = this.ulTicketRN;
                break;

            case "CA":
                this.ulTicketCA++;
                tickeAsignado = this.ulTicketCA;
                break;
            case "EH":
                this.ulTicketEH++;
                tickeAsignado = this.ulTicketEH;
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

    //contar (recorrido)
    public int Contar() {
        TipoNodo aux;
        int contar = 0;
        if (this.ColaVacia()) {
            return 0;
        } else {
            aux = this.inicio;
            while (aux != null) {
                //código 
                contar++;
                aux = aux.getSig();
            }

        }
        return contar;
    }

    public TipoNodo getInicio() {
        return inicio;
    }

}
