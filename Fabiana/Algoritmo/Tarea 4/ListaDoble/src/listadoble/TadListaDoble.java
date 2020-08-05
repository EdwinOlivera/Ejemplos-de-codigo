package listadoble;

//Definición del TAD y operaciones 
public class TadListaDoble {

    private TipoNodo inicio;
    private TipoNodo fin;
    private int contar;

    //constructores
    public TadListaDoble() {
        this.inicio = null;
        this.fin = null;
        this.contar = 0;
    }

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

    public void MostrarDesdeFin() {
        TipoNodo Aux;
        TipoInfo tmpDato;
        int contar = 0;
        if (this.Vacia()) {
            System.out.println("Lista vacía!!");
        } else {
            Aux = this.fin;
            while (Aux != null) {
                contar++;
                tmpDato = Aux.getInfo();
                System.out.println(contar + ") ID:" + tmpDato.getIdentidad() + " Nombre:" + tmpDato.getNombre() + " Edad:" + tmpDato.getEdad());
                Aux = Aux.getAnt();
            }//fin while
        }//fin si
    }

    public void IntertarInicio(TipoInfo pDato) {
        TipoNodo nuevo = new TipoNodo();
        nuevo.setInfo(pDato);
        if (this.Vacia()) {
            this.inicio = nuevo;
            this.fin = nuevo;
        } else {
            nuevo.setSig(this.inicio);
            this.inicio.setAnt(nuevo);
            this.inicio = nuevo;
        }

    }

    public void InsertarFinal(TipoInfo pDato) {
        TipoNodo nuevo = new TipoNodo();
        nuevo.setInfo(pDato);

        if (this.Vacia()) {
            this.inicio = nuevo;
            this.fin = nuevo;
        } else {
            this.fin.setSig(nuevo);
            nuevo.setAnt(this.fin);
            this.fin = nuevo;
        }

    }

    public void InsertarOrdenado(TipoInfo pDato) {
        TipoNodo nuevo = new TipoNodo();
        TipoNodo Aux, AuxAnt;
        boolean encontro = false;
        nuevo.setInfo(pDato);
        String tmpNombreNodo, tmpNombreP;
        //si no hay ningún dato
        if (this.Vacia()) {
            this.inicio = nuevo;
            this.fin = nuevo;
            return;
        }

        //evaluar si al inicio
        tmpNombreP = pDato.getNombre();
        tmpNombreNodo = this.inicio.getInfo().getNombre();
        if (tmpNombreNodo.compareTo(tmpNombreP) >= 0) {
            this.IntertarInicio(pDato);
            return;
        }

        //evaluar si al final
        tmpNombreP = pDato.getNombre();
        tmpNombreNodo = this.fin.getInfo().getNombre();
        if (tmpNombreNodo.compareTo(tmpNombreP) < 0) {
            this.InsertarFinal(pDato);
            return;
        }

        //es en medio
        Aux = this.inicio.getSig();
        while ((Aux != null) && (!encontro)) {
            tmpNombreNodo = Aux.getInfo().getNombre();
            if (tmpNombreNodo.compareTo(tmpNombreP) >= 0) {
                AuxAnt = Aux.getAnt();
                AuxAnt.setSig(nuevo);
                Aux.setAnt(nuevo);
                nuevo.setAnt(AuxAnt);
                nuevo.setSig(Aux);
                encontro = true;

                return;
            }
            Aux = Aux.getSig();
        }

    }//fin meter ordenado

    public TipoNodo BuscarID(String pID) {
        TipoInfo tmpDato = null;
        TipoNodo Aux;
        if (this.Vacia()) {
            return null;
        } else {
            Aux = this.inicio;
            while (Aux != null) {
                tmpDato = Aux.getInfo();
                if (tmpDato.getIdentidad().equals(pID)) {
                    return Aux;
                }
                Aux = Aux.getSig();
            }//fin while
        }//fin si        
        return null;
    }//fin buscar

    //Metodo busca edad
    public TipoNodo BuscarEdad(int pEdad) {
        TipoInfo tmpDato = null;
        TipoNodo Aux;
        if (this.Vacia()) {
            return null;
        } else {
            Aux = this.inicio;
            while (Aux != null) {
                tmpDato = Aux.getInfo();
                if (tmpDato.getIdentidad().equals(pEdad)) {
                    return Aux;
                }
                Aux = Aux.getSig();
            }//fin while
        }//fin si        
        return null;

    }

    //método que indica si el ID ya existe
    public boolean ExisteID(String pID) {
        return false;
    }//fin buscar

    public boolean ModificarPorID(String pID, TipoInfo DatoNuevo) {
        TipoNodo Aux;
        Aux = this.BuscarID(pID);
        if (Aux == null) {
            return false;
        } else {
            Aux.setInfo(DatoNuevo);
        }
        return true;
    }//fin modifica*/    

    public TipoInfo EliminarPorID(String pID) {
        TipoNodo Aux, AuxAnt, AuxSig;
        TipoInfo tmpDato = null;
        Aux = this.BuscarID(pID);
        if (Aux == null) {
            return null;
        }

        tmpDato = Aux.getInfo();

        //unico nodo de mi lista
        if (this.inicio == this.fin) {
            this.inicio = null;
            this.inicio = null;
            return tmpDato;
        }

        //es el primero?
        if (Aux == this.inicio) {
            this.inicio = this.inicio.getSig();
            this.inicio.setAnt(null);
            return tmpDato;
        }

        //es el último?
        if (Aux == this.fin) {
            this.fin = this.fin.getAnt();
            this.fin.setSig(null);
            return tmpDato;
        }

        //medio
        AuxAnt = Aux.getAnt();
        AuxSig = Aux.getSig();
        AuxAnt.setSig(AuxSig);
        AuxSig.setAnt(AuxAnt);
        return tmpDato;

    }//fin eliminar

    //eliminar N cantidad de nodos
    public int EliminarPorEdad(int pEdad) {

        TipoNodo Aux1;
        int edadAComprobar;
        int contador = 0;
        if (this.inicio == null) {
            System.out.println("La lista actual esta vacia");
            return 0;
        }
        Aux1 = this.inicio;

        while (Aux1 != null) {
            edadAComprobar = Aux1.getInfo().getEdad();
            if (pEdad == edadAComprobar) {
                contador++;
                //Esta verificacion es por si el primer elemento esta al inicio
                if (Aux1.getAnt() != null) {

                    //Este es el caso cuando el elemento es el ultimo de la lista
                    if (Aux1 == this.fin) {
                        this.fin = Aux1.getAnt();
                        this.fin.setSig(null);
                    } else {
                        (Aux1.getAnt()).setSig(Aux1.getSig());
                        (Aux1.getSig()).setAnt(Aux1.getAnt());
                    }

                } else if (Aux1.getSig() != null) {

                    //Esto elimina el primero de la lista 
                    this.inicio = Aux1.getSig();
                    this.inicio.setAnt(null);

                } else {
//Esto se ejecuta cuando solo se tiene un elemente restante en la lista
                    this.inicio = null;
                    this.fin = null;

                    System.out.println("Se ha vaciado la lista completamente.");
                }
            }
            Aux1 = Aux1.getSig();
        }

        return contador;
    }//fin eliminar N

    // gets
    public TipoNodo getInicio() {
        return this.inicio;
    }

    public TipoNodo getFinal() {
        return this.fin;
    }
    //Hace una sumatoria de los objetos en la lista y retorna la cantdad

    public int getCantidad() {
        TipoNodo Aux;
        this.contar = 0;
        if (this.Vacia()) {
            System.out.println("Lista vacía!!");
        } else {
            Aux = this.inicio;
            while (Aux != null) {
                this.contar++;

                Aux = Aux.getSig();
            }//fin while
        }
        return this.contar;
    }
    //Esta funcion retora un objeto dependiente del paramentro "numeroDeObjeto"

    public TipoInfo getObjetoLista(int numeroDeObjeto) {
        TipoInfo dato = new TipoInfo();
        int objetoLimite = 0;
        TipoNodo Aux;

        if (!this.Vacia()) {
            Aux = this.inicio;
            while (objetoLimite <= numeroDeObjeto) {
                objetoLimite++;

                dato = Aux.getInfo();

                Aux = Aux.getSig();

            }

        }

        return dato;
    }
}
