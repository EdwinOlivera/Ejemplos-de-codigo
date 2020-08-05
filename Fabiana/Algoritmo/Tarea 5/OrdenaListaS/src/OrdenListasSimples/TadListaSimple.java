package OrdenListasSimples;

//Definición del TAD y operaciones 
public class TadListaSimple {

    private TipoNodo inicio;

    //constructores
    public TadListaSimple() {
        this.inicio = null;
    }

    private void intercambio(TipoNodo Nodo1, TipoNodo Nodo2) {
        TipoInfo tmpDato;
        tmpDato = Nodo1.getInfo();
        Nodo1.setInfo(Nodo2.getInfo());
        Nodo2.setInfo(tmpDato);
    }

    //**************************************************************************        
    //Ordenamiento por burbuja
    public void OrdenPorID(int pTipoOrden) {
        TipoNodo AuxI, AuxJ;
        String ID1, ID2;
        int multiplicador = 1;
        if (this.Vacia()) {
            return;
        }

        if (pTipoOrden == 2) {
            multiplicador = -1;
        }

        AuxI = this.inicio;
        while (AuxI.getSig() != null) {
            AuxJ = AuxI.getSig();
            while (AuxJ != null) {
                ID1 = AuxI.getInfo().getIdentidad();
                ID2 = AuxJ.getInfo().getIdentidad();
                if ((ID1.compareTo(ID2) * multiplicador) > 0) {
                    this.intercambio(AuxI, AuxJ);
                }
                AuxJ = AuxJ.getSig();
            }//fin j
            AuxI = AuxI.getSig();
        }//fin i
    }

    //ordenamiento por quicksort
    public void OrdenPorEdadQuickSort() {
        if (this.Vacia()) {
            return;
        }
        int i, cant;
        TipoNodo Aux;
        cant = this.CantidadNodos();

        //crear un arreglo con las direcciones de todos los nodos
        TipoNodo[] Arreglo = new TipoNodo[cant];
        Aux = this.inicio;
        i = -1;
        while (Aux != null) {
            i++;
            Arreglo[i] = Aux;
            Aux = Aux.getSig();
        }
        this.QuickSortEdad(Arreglo, 0, Arreglo.length - 1);

    }

    private void QuickSortEdad(TipoNodo[] arreglo, int izquierda, int derecha) {
        int pos;
        if (izquierda < derecha) {
            pos = this.posicionParticionEdad(arreglo, izquierda, derecha);
            QuickSortEdad(arreglo, izquierda, pos);
            QuickSortEdad(arreglo, pos + 1, derecha);
        }

    }

    private int posicionParticionEdad(TipoNodo[] arreglo, int izq, int der) {
        int pivote;
        pivote = arreglo[izq].getInfo().getEdad();
        while (true) {
            while (arreglo[izq].getInfo().getEdad() < pivote) {
                izq++;
            }
            while (arreglo[der].getInfo().getEdad() > pivote) {
                der--;
            }

            //fin del ciclo
            if (izq >= der) {
                return der;
            }

            //intercambiar
            this.intercambio(arreglo[izq], arreglo[der]);
            //mover
            izq++;
            der--;

        }
    }

    // ************************************************************************
    //Ejercicio No.1 Tarea 
    public void OrdenPorEdad_xx(int pTipoOrden) {

        TipoNodo AuxI, AuxJ;
        String Edad1, Edad2;
        int multiplicador = 1;
        if (this.Vacia()) {
            return;
        }

        if (pTipoOrden == 2) {
            multiplicador = -1;
        }

        AuxI = this.inicio;
        while (AuxI.getSig() != null) {
            AuxJ = AuxI.getSig();
            while (AuxJ != null) {
                Edad1 = String.valueOf(AuxI.getInfo().getEdad());
                Edad2 = String.valueOf(AuxJ.getInfo().getEdad());
                if ((Edad1.compareTo(Edad2) * multiplicador) > 0) {
                    this.intercambio(AuxI, AuxJ);
                }
                AuxJ = AuxJ.getSig();
            }//fin j
            AuxI = AuxI.getSig();
        }//fin i
    }

    //Ejercicio No.2 Tarea 
    public void OrdenPorEdadNombre(int pTipoOrden) {

        OrdenPorEdad_xx(1);

        TipoNodo AuxI, AuxJ;
        String Nombre1, Nombre2;
        int multiplicador = 1;
        if (this.Vacia()) {
            return;
        }

        if (pTipoOrden == 2) {
            multiplicador = -1;
        }

        AuxI = this.inicio;
        while (AuxI.getSig() != null) {
            AuxJ = AuxI.getSig();
            while (AuxJ != null) {
                if (AuxJ.getInfo().getEdad() == AuxI.getInfo().getEdad()) {

                    Nombre1 = AuxI.getInfo().getNombre();
                    Nombre2 = AuxJ.getInfo().getNombre();
                    if ((Nombre1.compareTo(Nombre2) * multiplicador) > 0) {
                        this.intercambio(AuxI, AuxJ);
                    }
                }
                AuxJ = AuxJ.getSig();
            }//fin j
            AuxI = AuxI.getSig();
        }//fin i
    }

    //Ejercicio No.3 Tarea 
    private int posicionParticionNombre(TipoNodo[] arreglo, int izq, int der) {
        String pivote;
        pivote = arreglo[izq].getInfo().getNombre();
        while (true) {
            while (arreglo[izq].getInfo().getNombre().compareToIgnoreCase(pivote) < 0) {
                izq++;
            }
            while (arreglo[der].getInfo().getNombre().compareToIgnoreCase(pivote) > 1) {
                der--;
            }

            //fin del ciclo
            if (izq >= der) {
                return der;
            }

            //intercambiar
            this.intercambio(arreglo[izq], arreglo[der]);
            //mover
            izq++;
            der--;

        }
    }

    private void QuickSortNombre(TipoNodo[] arreglo, int izquierda, int derecha) {
        int pos;
        if (izquierda < derecha) {
            pos = this.posicionParticionNombre(arreglo, izquierda, derecha);
            QuickSortNombre(arreglo, izquierda, pos);
            QuickSortNombre(arreglo, pos + 1, derecha);
        }

    }

    public void OrdenPorNombreQuickSort() {
        if (this.Vacia()) {
            return;
        }
        int i, cant;
        TipoNodo Aux;
        cant = this.CantidadNodos();

        //crear un arreglo con las direcciones de todos los nodos
        TipoNodo[] Arreglo = new TipoNodo[cant];
        Aux = this.inicio;
        i = -1;
        while (Aux != null) {
            i++;
            Arreglo[i] = Aux;
            Aux = Aux.getSig();
        }
        this.QuickSortNombre(Arreglo, 0, Arreglo.length - 1);

    }

    // ************************************************************************
    //operaciones TAD
    public boolean Vacia() {
        if (this.inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public void Mostrar() {
        TipoNodo Aux;
        TipoInfo tmpDato;
        int contar = 0;
        if (this.Vacia()) {
            System.out.println("Lista vacía!!");
        } else {
            Aux = this.inicio;
            while (Aux != null) {
                contar++;
                tmpDato = Aux.getInfo();
                System.out.println(contar + ") ID:" + tmpDato.getIdentidad() + " Nombre:" + tmpDato.getNombre() + " Edad:" + tmpDato.getEdad());
                Aux = Aux.getSig();
            }//fin while
        }//fin si
    }

    public int CantidadNodos() {
        TipoNodo Aux;
        int contar = 0;
        if (this.Vacia()) {
            System.out.println("Lista vacía!!");
        } else {
            Aux = this.inicio;
            while (Aux != null) {
                contar++;
                Aux = Aux.getSig();
            }//fin while
        }//fin si
        return contar;
    }

    public void IntertarInicio(TipoInfo pDato) {
        TipoNodo nuevo = new TipoNodo();
        nuevo.setInfo(pDato);
        if (this.Vacia()) {
            this.inicio = nuevo;
        } else {
            nuevo.setSig(this.inicio);
            this.inicio = nuevo;
        }
    }

    public void InsertarFinal(TipoInfo pDato) {
        TipoNodo nuevo = new TipoNodo();
        TipoNodo Aux, AuxAnt;
        nuevo.setInfo(pDato);
        if (this.Vacia()) {
            this.inicio = nuevo;
        } else {
            AuxAnt = this.inicio;
            Aux = this.inicio.getSig();
            while (Aux != null) {
                AuxAnt = Aux;
                Aux = Aux.getSig();
            }//fin while
            AuxAnt.setSig(nuevo);
        }
    }

    public void InsertarOrdenado(TipoInfo pDato) {
        TipoNodo nuevo = new TipoNodo();
        TipoNodo Aux, AuxAnt;
        String tmpNombreNodo, tmpNombreP;
        boolean exito = false;
        nuevo.setInfo(pDato);
        if (this.Vacia()) {
            this.inicio = nuevo;
        } else {
            tmpNombreP = pDato.getNombre();
            tmpNombreNodo = this.inicio.getInfo().getNombre();
            if (tmpNombreNodo.compareTo(tmpNombreP) > 0) {
                nuevo.setSig(this.inicio);
                this.inicio = nuevo;
            } else {
                AuxAnt = this.inicio;
                Aux = this.inicio.getSig();
                while ((Aux != null) && (exito == false)) {
                    tmpNombreNodo = Aux.getInfo().getNombre();
                    if (tmpNombreNodo.compareTo(tmpNombreP) > 0) {
                        AuxAnt.setSig(nuevo);
                        nuevo.setSig(Aux);
                        exito = true;
                    }
                    AuxAnt = Aux;
                    Aux = Aux.getSig();
                }//fin while
                if (!exito) {
                    AuxAnt.setSig(nuevo);
                }
            }
        }
    }//fin meter ordenado

    public TipoInfo Buscar(String pID) {
        TipoNodo Aux;
        TipoInfo tmpDato = null;
        boolean encontro = false;

        if (!this.Vacia()) {
            Aux = this.inicio;
            while (Aux != null) {
                tmpDato = Aux.getInfo();
                if (tmpDato.getIdentidad().equals(pID)) {
                    encontro = true;
                    break;
                }
                Aux = Aux.getSig();
            }//fin while
        }//fin si

        if (encontro) {
            return tmpDato;
        } else {
            return null;
        }
    }//fin buscar

    //método que indica si el ID ya existe
    public boolean ExisteID(String pID) {
        TipoNodo Aux;
        TipoInfo tmpDato = null;
        boolean encontro = false;
        if (!this.Vacia()) {
            Aux = this.inicio;
            while (Aux != null) {
                tmpDato = Aux.getInfo();
                if (tmpDato.getIdentidad().equals(pID)) {
                    encontro = true;
                    break;
                }
                Aux = Aux.getSig();
            }//fin while
        }//fin si
        return encontro;
    }//fin buscar

    public TipoInfo EliminarPorID(String pID) {
        TipoNodo Aux;
        TipoNodo AuxAnt;
        TipoInfo tmpDato = null;
        boolean Encontro = false;

        if (this.Vacia()) {
            return null;
        } else {
            //revisar si el la primera posición
            Aux = this.inicio;
            tmpDato = Aux.getInfo();
            if (tmpDato.getIdentidad().equals(pID)) {
                this.inicio = Aux.getSig();
                Encontro = true;
            } else {
                Aux = this.inicio.getSig();
                AuxAnt = this.inicio;
                while ((Aux != null) && (!Encontro)) {
                    tmpDato = Aux.getInfo();
                    if (tmpDato.getIdentidad().equals(pID)) {
                        AuxAnt.setSig(Aux.getSig());
                        Encontro = true;
                        break;
                    }
                    AuxAnt = Aux;
                    Aux = Aux.getSig();
                }
            }
            if (Encontro) {
                return tmpDato;
            } else {
                return null;
            }
        }//fin no esta vacia 
    }//fin eliminar

    //eliminar N cantidad de nodos
    public int EliminarPorEdad(int pEdad) {
        TipoNodo Aux;
        TipoNodo AuxAnt;
        TipoInfo tmpDato = null;
        int contar = 0;

        if (this.Vacia()) {
            return 0;
        } else {
            Aux = this.inicio;
            AuxAnt = null;
            while ((Aux != null)) {
                tmpDato = Aux.getInfo();
                if (tmpDato.getEdad() == pEdad) {
                    contar++;
                    if (AuxAnt == null) {//verificar si es el primer nodo
                        this.inicio = Aux.getSig();
                        Aux = this.inicio;
                    } else {
                        AuxAnt.setSig(Aux.getSig());
                        Aux = Aux.getSig();
                    }
                } else {
                    AuxAnt = Aux;
                    Aux = Aux.getSig();
                }
            }//fin while
            return contar;
        }//fin no esta vacia 
    }//fin eliminar N

    public boolean ModificarPorID(String pID, TipoInfo DatoNuevo) {
        TipoNodo Aux;
        TipoInfo tmpDato = null;
        boolean Encontro = false;
        if (this.Vacia()) {
            return true;
        } else {
            //recorrer para buscar
            Aux = this.inicio;
            while (Aux != null) {
                tmpDato = Aux.getInfo();
                if (tmpDato.getIdentidad().equals(pID)) {
                    Aux.setInfo(DatoNuevo);
                    Encontro = true;
                    break;
                }
                Aux = Aux.getSig();
            }
            if (Encontro) {
                return true;
            } else {
                return false;
            }
        }//fin no esta vacia 
    }//fin modifica*/

    // gets
    public TipoNodo getInicio() {
        return this.inicio;
    }

}
