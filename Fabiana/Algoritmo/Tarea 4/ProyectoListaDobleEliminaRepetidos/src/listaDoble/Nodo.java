package listaDoble;

public class Nodo {

    int info;
    Nodo sig;
    Nodo ant;

    public Nodo(int info) {
        this.info = info;
        sig = null;
        ant = null;
    }

}
