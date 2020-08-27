package arbolbina;

class TadAB {

    private TipoNodo Raiz;
    int altura;
    int cant;
    

    public TadAB() {
        this.Raiz = null;
    }

    public TipoNodo getRaiz() {
        return Raiz;
    }

    //método temporal solo para pruebas
    public void setRaiz(TipoNodo Raiz) {
        this.Raiz = Raiz;
    }

    public boolean esVacio() {
        if (this.Raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    public void Mostrar(String pTipo) {
        if (pTipo.equalsIgnoreCase("in")) {
            System.out.println("-->IN ORDEN <--");
            this.inOrden(this.Raiz);
        } else {
            if (pTipo.equalsIgnoreCase("post")) {
                System.out.println("-->POST ORDEN <--");
                this.postOrden(this.Raiz);
            } else {
                System.out.println("-->PRE ORDEN <--");
                this.preOrden(this.Raiz);
            }
        }
    }

    public void preOrden(TipoNodo Aux) {
        if (Aux != null) {
            TipoInfo tmpDato;
            tmpDato = Aux.getInfo();
            System.out.println(tmpDato.getPalabra() + "(" + tmpDato.getNumero() + ")");
            preOrden(Aux.getIzq());
            preOrden(Aux.getDer());
        }
    }

    public void inOrden(TipoNodo Aux) {
        if (Aux != null) {
            TipoInfo tmpDato;
            tmpDato = Aux.getInfo();
            inOrden(Aux.getIzq());
            System.out.println(tmpDato.getPalabra() + "(" + tmpDato.getNumero() + ")");
            inOrden(Aux.getDer());
        }
    }

    public void postOrden(TipoNodo Aux) {
        if (Aux != null) {
            TipoInfo tmpDato;
            tmpDato = Aux.getInfo();
            postOrden(Aux.getIzq());
            postOrden(Aux.getDer());
            System.out.println(tmpDato.getPalabra() + "(" + tmpDato.getNumero() + ")");
        }
    }

    public int Peso() {
        int conteo = 0;
        conteo = this.contar(this.Raiz, 0);
        return conteo;
    }

    public int contar(TipoNodo Aux, int pConteo) {
        if (Aux != null) {
            pConteo++;
            pConteo = contar(Aux.getIzq(), pConteo);
            pConteo = contar(Aux.getDer(), pConteo);
        }
        return pConteo;
    }

    public void Insertar(TipoInfo pDato) {
        TipoNodo Aux = null;
        if (this.esVacio()) {
            TipoNodo nuevo = new TipoNodo();
            nuevo.setInfo(pDato);
            this.Raiz = nuevo;
        } else {
            Aux = this.InsertarNodo(this.Raiz, null, pDato);
         }
    }

    public TipoNodo InsertarNodo(TipoNodo nuevaRaiz, TipoNodo Aux, TipoInfo pDato) {

        if (Aux == null) {
            if ((nuevaRaiz.getIzq() == null) || (nuevaRaiz.getDer() == null)) {
                TipoNodo nuevo = new TipoNodo();
                nuevo.setInfo(pDato);
                if (nuevaRaiz.getIzq() == null) {
                    nuevaRaiz.setIzq(nuevo);
                } else {
                    nuevaRaiz.setDer(nuevo);
                }
                Aux=nuevo;
            } else {
                int pesoIzq = this.contar(nuevaRaiz.getIzq(), 0);
                int pesoDer = this.contar(nuevaRaiz.getDer(), 0);
                if (pesoIzq <= pesoDer) {
                    Aux = this.InsertarNodo(nuevaRaiz.getIzq(), null, pDato);
                } else {
                    Aux = this.InsertarNodo(nuevaRaiz.getDer(), null, pDato);
                }
            }
        }
        return Aux;
    }

    public TipoNodo Buscar(int pNumero) {
        TipoNodo Aux = null;
        System.out.println("pendiente");
        return Aux;
    }

    public void Eliminar(TipoNodo NodoEliminar) {
        TipoNodo NodoHoja;
        System.out.println("pendiente");

    }//fin eliminar    

    public int retornarAltura() {
        altura = 0;
        retornarAltura(Raiz, 1);
        return altura;
    }

    private void retornarAltura(TipoNodo reco, int nivel) {
        if (reco != null) {
            retornarAltura(reco.getIzq(), nivel + 1);
            if (nivel > altura) {
                altura = nivel;
            }
            retornarAltura(reco.getDer(), nivel + 1);
        }
    }
    
    
    public int alturaArbol() {
        altura = 0;
        alturaArbol(Raiz, 0);
        return altura;
    }
    private void alturaArbol(TipoNodo pivote, int nivel) {
        if (pivote != null) {
            alturaArbol(pivote.getIzq(), nivel + 1);
            if (nivel > altura) {
                altura = nivel;
            }
            alturaArbol(pivote.getDer(), nivel + 1);
        }
    }//Fin altura
    
    private void cantidadNodosHoja(TipoNodo reco) {
        if (reco != null) {
            if (reco.getIzq() == null && reco.getDer() == null) {
                cant++;
            }
            cantidadNodosHoja(reco.getIzq());
            cantidadNodosHoja(reco.getDer());
        }
    }

    public int cantidadNodosHoja() {
        cant = 0;
        cantidadNodosHoja(Raiz);
        return cant;
    }
    
    
}
