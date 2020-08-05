
package listasimpleexam;

/**
 * Author:Fabiana Yamaly Artiaga Portillo
 * Cuenta:20151000019
 */
public class Nodo {
    private InfoSemana archivo;
    private Nodo siguiente;

    public Nodo() {
        this.archivo = null;
        this.siguiente = null;
    }

    public InfoSemana getArchivo() {
        return archivo;
    }

    public void setArchivo(InfoSemana archivo) {
        this.archivo = archivo;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }
    
}
