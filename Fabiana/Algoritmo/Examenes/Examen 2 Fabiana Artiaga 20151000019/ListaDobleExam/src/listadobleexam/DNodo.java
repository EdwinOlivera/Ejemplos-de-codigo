
package listadobleexam;

/**
 * Author:Fabiana Yamaly Artiaga Portillo
 * Cuenta:20151000019
 */
public class DNodo {
    private DInfo info;
    private DNodo siguiente;
    private DNodo anterior;
    

    public DNodo() {
        this.info = null;
        this.siguiente = null;
        this.anterior = null;    
    }

    public DInfo getInfo() {
        return info;
    }

    public void setInfo(DInfo info) {
        this.info = info;
    }

    public void setSiguiente(DNodo siguiente) {
        this.siguiente = siguiente;
    }

    public DNodo getSiguiente() {
        return siguiente;
    }

    public DNodo getAnterior() {
        return anterior;
    }

    public void setAnterior(DNodo anterior) {
        this.anterior = anterior;
    }
    
}
