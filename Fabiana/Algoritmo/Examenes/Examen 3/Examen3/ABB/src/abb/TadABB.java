
package abb;

/**
 *
 * @author Ricardo Rivera
 */
public class TadABB {

    int subizq = 0;
    int subder = 0;
    int altura;
    int cant;
    private TipoNodo Raiz;

    public TadABB() {
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
//----------------------------------------------------------------------------

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
        System.out.println("");
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

//----------------------------------------------------------------------------
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

    public TipoNodo InsertarNodo(TipoNodo NodoRaiz, TipoNodo NodoInserta, TipoInfo DatoIns) {
        TipoInfo tmpDato = new TipoInfo();
        if (this.esVacio()) {
            TipoNodo nuevo = new TipoNodo();
            nuevo.setInfo(DatoIns);
            this.Raiz = nuevo;
        } else {
            tmpDato = NodoRaiz.getInfo();
            if (DatoIns.getNumero() < tmpDato.getNumero()) {
                if (NodoRaiz.getIzq() == null) {
                    TipoNodo nuevo = new TipoNodo();
                    nuevo.setInfo(DatoIns);
                    NodoRaiz.setIzq(nuevo);
                } else {
                    NodoInserta = InsertarNodo(NodoRaiz.getIzq(), NodoInserta, DatoIns);
                }
            }
            if (DatoIns.getNumero() > tmpDato.getNumero()) {
                if (NodoRaiz.getDer() == null) {
                    TipoNodo nuevo = new TipoNodo();
                    nuevo.setInfo(DatoIns);
                    NodoRaiz.setDer(nuevo);
                } else {
                    NodoInserta = InsertarNodo(NodoRaiz.getDer(), NodoInserta, DatoIns);
                }
            }
        }
        return NodoInserta;
    }//fin insertar

//----------------------------------------------------------------------------
    public TipoNodo Buscar(int pDatoBusca) {
        TipoNodo Aux = null;
        Aux = BuscarNodo(this.Raiz, Aux, pDatoBusca);
        return Aux;
    }

    private TipoNodo BuscarNodo(TipoNodo NodoRaiz, TipoNodo NodoB, int DatoBusca) {
        int DatoLlave;
        if (NodoRaiz != null) {
            if (NodoB == null) {
                DatoLlave = NodoRaiz.getInfo().getNumero();
                if (DatoBusca == DatoLlave) {
                    NodoB = NodoRaiz;
                    return NodoB;
                }
                if (DatoBusca < DatoLlave) {
                    NodoB = BuscarNodo(NodoRaiz.getIzq(), NodoB, DatoBusca);
                } else {
                    NodoB = BuscarNodo(NodoRaiz.getDer(), NodoB, DatoBusca);
                }
            }
        }
        return NodoB;
    }//fin BusquedaNodo

//----------------------------------------------------------------------------
    public void Eliminar(TipoNodo NodoEliminar) {
        boolean eliminado = false;
        if (NodoEliminar == this.Raiz) {
            if (this.esHoja(NodoEliminar)) {
                this.Raiz = null;
            } else {
                if ((this.Raiz.getIzq() == null) || (this.Raiz.getDer() == null)) {
                    if (this.Raiz.getIzq() == null) {
                        this.Raiz = this.Raiz.getDer();
                    } else {
                        this.Raiz = this.Raiz.getIzq();
                    }
                } else {
                    TipoNodo NodoMax = null;
                    TipoNodo tmpArbolDer = null;
                    tmpArbolDer = NodoEliminar.getDer();
                    NodoEliminar.setDer(null);
                    NodoMax = NodoEliminar.getIzq();
                    NodoMax = this.BuscaMaximo(NodoEliminar.getIzq(), NodoMax);
                    this.Raiz=NodoEliminar.getIzq();
                    NodoMax.setDer(tmpArbolDer);                    
                }
            }
        } else {
            eliminado = EliminarNodo(this.Raiz, NodoEliminar, eliminado);
        } //fin si no es nodo raiz
    }//fin eliminar    

    public boolean EliminarNodo(TipoNodo NodoRaiz, TipoNodo NodoEliminar, boolean pEliminado) {
        if (!pEliminado) {
            TipoNodo NodoPadre;
            int DatoLlave;
            DatoLlave = NodoEliminar.getInfo().getNumero();
            NodoPadre = this.BuscarPadre(NodoRaiz, null, DatoLlave);
            if (this.esHoja(NodoEliminar)) {
                if (NodoPadre.getIzq() == NodoEliminar) {
                    NodoPadre.setIzq(null);
                } else {
                    NodoPadre.setDer(null);
                }
                pEliminado = true;
            } else {
                if ((NodoEliminar.getIzq() == null) || (NodoEliminar.getDer() == null)) {
                    if (NodoPadre.getIzq() == NodoEliminar) {
                        if (NodoEliminar.getIzq() != null) {
                            NodoPadre.setIzq(NodoEliminar.getIzq());
                        } else {
                            NodoPadre.setIzq(NodoEliminar.getDer());
                        }
                    } else {
                        if (NodoEliminar.getIzq() != null) {
                            NodoPadre.setDer(NodoEliminar.getIzq());
                        } else {
                            NodoPadre.setDer(NodoEliminar.getDer());
                        }
                    }
                    pEliminado = true;
                } else {
                    TipoNodo NodoMax = null;
                    TipoNodo tmpArbolDer = null;
                    tmpArbolDer = NodoEliminar.getDer();
                    NodoEliminar.setDer(null);

                    NodoMax = NodoEliminar.getIzq();
                    NodoMax = this.BuscaMaximo(NodoEliminar.getIzq(), NodoMax);
                    if (NodoPadre.getIzq() == NodoEliminar) {
                         NodoPadre.setIzq(NodoEliminar.getIzq());
                    } else {
                         NodoPadre.setDer(NodoEliminar.getIzq());
                    }
                    NodoMax.setDer(tmpArbolDer);
                }
            }
        }
        return pEliminado;
    } //fin si no es nodo raiz

    private boolean esHoja(TipoNodo Nodo) {
        if ((Nodo.getIzq() == null) && (Nodo.getDer() == null)) {
            return true;
        } else {
            return false;
        }
    }

    public TipoNodo BuscaMaximo(TipoNodo NodoRaiz, TipoNodo NodoMax) {
        int DatoLlave;
        int Maximo;
        if (NodoRaiz != null) {
            DatoLlave = NodoRaiz.getInfo().getNumero();
            Maximo = NodoMax.getInfo().getNumero();
            if (Maximo < DatoLlave) {
                NodoMax = NodoRaiz;
            }
            NodoMax = BuscaMaximo(NodoRaiz.getDer(), NodoMax);
        }
        return NodoMax;
    }//fin BuscaMaximo      

    private TipoNodo BuscarPadre(TipoNodo NodoRaiz, TipoNodo NodoB, int DatoBusca) {
        int DatoLlave;
        if (NodoRaiz != null) {
            if (NodoB == null) {
                if (NodoRaiz.getIzq() != null) {
                    DatoLlave = NodoRaiz.getIzq().getInfo().getNumero();
                    if (DatoBusca == DatoLlave) {
                        return NodoRaiz;
                    }
                }
                if (NodoRaiz.getDer() != null) {
                    DatoLlave = NodoRaiz.getDer().getInfo().getNumero();
                    if (DatoBusca == DatoLlave) {
                        return NodoRaiz;
                    }
                }
                DatoLlave = NodoRaiz.getInfo().getNumero();
                if (DatoBusca < DatoLlave) {
                    NodoB = BuscarPadre(NodoRaiz.getIzq(), NodoB, DatoBusca);
                } else {
                    NodoB = BuscarPadre(NodoRaiz.getDer(), NodoB, DatoBusca);
                }
            }
        }
        return NodoB;
    }//fin BusquedaNodo

//----------------------------------------------------------------------------
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
    
    public void imprimirBalance() {
        subizq = 0;
        subder = 0;

        Balance(this.Raiz, true, 0);
        System.out.println("lado Izquierdo " + subizq + " Lado Derecho " + subder);
        if (subizq - subder == 0) {
            System.out.println("El balance es: 0 ");
        } else if (subizq - subder == -1) {
            System.out.println("El balance es -1, derecha");
        } else if (subizq - subder == 1) {
            System.out.println("El balance 1, izquierda");

        } else {
            System.out.println("No es balanceado.."
                    + "porque es mas grande el lado "
                    + ((subizq > subder) ? "Izquierdo" : "Derecho"));
        }

    }

    public void Balance(TipoNodo reco, boolean lado, int i) {

        if (reco != null) {

            if (reco.getDer() == null && reco.getIzq() == null) {
                if (lado) {
                    subder = (i > subder) ? i : subder;
                } else {
                    subizq = (i > subizq) ? i : subizq;
                }
            }

            Balance(reco.getDer(), lado, i + 1);
            if (i == 0) {
                lado = false;
            }
            Balance(reco.getIzq(), lado, i + 1);
        }

    }
    
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
    
    


}
