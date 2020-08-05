package listaDoble;

public class ListaDoble {

    Nodo cabIzq;
    Nodo cabDer;

    public ListaDoble() {
        cabIzq = cabDer = null;
    }

    public void agregarAlComienzo(int dato) {
        Nodo n = new Nodo(dato);

        if (cabIzq == null) {
            // La lista esta vacía
            cabIzq = cabDer = n;
        } else {
            // La lista tiene almenos un nodo
            n.sig = cabIzq;
            cabIzq.ant = n;
            cabIzq = n;
        }
    }

    public void agregarAlFinal(int dato) {
        Nodo n = new Nodo(dato);

        if (cabDer == null) {
            // La lista esta vacía
            cabIzq = cabDer = n;
        } else {
            // La lista tiene almenos un nodo
            n.ant = cabDer;
            cabDer.sig = n;
            cabDer = n;
        }
    }

    public void imprimirDeIzqAder() {
        Nodo t = cabIzq;

        while (t != null) {
            System.out.println(t.info);
            t = t.sig;
        }
    }

    public void imprimirDeDerAizq() {
        Nodo t = cabDer;

        while (t != null) {
            System.out.println(t.info);
            t = t.ant;
        }
    }

    public void borrar(int dato) {
        // Ubicar el apuntador t en el nodo a borrar
        Nodo t = cabIzq;
        boolean esta = false;
        while (t != null && !esta) {
            if (t.info == dato) {
                esta = true;
            } else {
                t = t.sig;
            }
        }

        if (esta) {
            if (cabIzq == cabDer) {
                // Borrar único nodo de la lista
                cabIzq = cabDer = null;
            } else if (cabIzq == t) {
                // Borrar el nodo del extremo izquierdo
                cabIzq = cabIzq.sig;
                cabIzq.ant = null;
            } else if (cabDer == t) {
                // Borrar nodo del extremo derecho
                cabDer = cabDer.ant;
                cabDer.sig = null;
            } else {
                // Borrar nodo intermedio
                (t.ant).sig = t.sig;
                (t.sig).ant = t.ant;
            }
        }
    }

    public void elimiarRepetidos() {
        Nodo t1, t2;

        t1 = cabIzq;

        while (t1 != null) {
            // Por cada nodo de la lista, se mira si esta en los restantes
            t2 = t1.sig;
            while (t2 != null) {
                if (t1.info == t2.info) {
                    if (t2 == cabDer) {
                        // Borra último nodo
                        cabDer = t2.ant;
                        cabDer.sig = null;
                    } else {
                        // Borrar nodo intermedio
                        (t2.ant).sig = t2.sig;
                        (t2.sig).ant = t2.ant;
                    }
                }
                t2 = t2.sig;
            }
            t1 = t1.sig;
        }
    }
}
