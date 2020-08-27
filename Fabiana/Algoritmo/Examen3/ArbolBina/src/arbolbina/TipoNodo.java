/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbina;

/**
 *
 * @author Ricardo Rivera
 */
public class TipoNodo {
    
    private TipoInfo info;
    private TipoNodo izq;
    private TipoNodo der;

    public TipoNodo() {
        this.info = null;
        this.izq = null;
        this.der = null;
    }

    public TipoInfo getInfo() {
        return info;
    }

    public TipoNodo getIzq() {
        return izq;
    }

    public TipoNodo getDer() {
        return der;
    }

    public void setInfo(TipoInfo info) {
        this.info = info;
    }

    public void setIzq(TipoNodo izq) {
        this.izq = izq;
    }

    public void setDer(TipoNodo der) {
        this.der = der;
    }

}
