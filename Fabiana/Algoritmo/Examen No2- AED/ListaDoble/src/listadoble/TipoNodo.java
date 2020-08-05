/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listadoble;
/**
 *
 * @author Ricardo Rivera
 */
public class TipoNodo {
    TipoInfo info;
   private TipoNodo sig;
    private TipoNodo ant;
    

    public TipoNodo() {
        this.info = null;
        this.sig = null;
        this.ant = null;    
    }

    public TipoInfo getInfo() {
        return info;
    }

    public void setInfo(TipoInfo info) {
        this.info = info;
    }

    public void setSig(TipoNodo sig) {
        this.sig = sig;
    }

    public TipoNodo getSig() {
        return sig;
    }

    public TipoNodo getAnt() {
        return ant;
    }

    public void setAnt(TipoNodo ant) {
        this.ant = ant;
    }
    
    
    

}
