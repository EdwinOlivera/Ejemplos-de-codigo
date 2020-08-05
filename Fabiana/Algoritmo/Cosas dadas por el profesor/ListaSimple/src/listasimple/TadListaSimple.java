package listasimple;

//Definición del TAD y operaciones 
public class TadListaSimple {

    private TipoNodo inicio;
    private int contar;

    //constructores
    public TadListaSimple() {
        this.inicio = null;
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
        if (!this.Vacia()) {
            Aux = this.inicio;
            while (Aux != null) {
                tmpDato = Aux.getInfo();
                System.out.println("ID:" + tmpDato.getIdentidad() + " Nombre:" + tmpDato.getNombre() + " -> Edad:" + tmpDato.getEdad());
                Aux = Aux.getSig();
            }
        }
    }

    public void MostrarEdades() {
        TipoNodo Aux;
        TipoInfo tmpDato;
        if (!this.Vacia()) {
            Aux = this.inicio;
            while (Aux != null) {
                tmpDato = Aux.getInfo();
                System.out.println(" -> Edad:" + tmpDato.getEdad());
                Aux = Aux.getSig();
            }
        }
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
            }
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
                }
                if (!exito) {
                    AuxAnt.setSig(nuevo);
                }
            }
        }
        contar++;
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
            }
        }

        if (encontro) {
            return tmpDato;
        } else {
            return null;
        }
    }//fin buscar

    public TipoInfo Eliminar(TipoInfo DatosBusca) {
        return null;
    }//fin sacar

    public boolean Modificar(TipoInfo DatosBusca, TipoInfo DatoNuevo) {
        return false;
    }//fin sacar

    public float operar(String operacion) {
        TipoNodo Aux;
        TipoInfo tmpDato;
        float elementoAComprobar = 0;

        TipoInfo tmpDatoAComprobar;
        TipoNodo AuxAComprobar;

        switch (operacion) {
            case "contar":
                return contar;
            case "max":
                float maximoEncontrado = 0;
                if (!this.Vacia()) {
                    Aux = getInicio();
                    tmpDato = Aux.getInfo();
                    elementoAComprobar = tmpDato.getEdad();
                    while (Aux != null) {
                        tmpDato = Aux.getInfo();
                        AuxAComprobar = getInicio();
                        for (int i = 0; i < contar; i++) {
                            tmpDatoAComprobar = AuxAComprobar.getInfo();
                            if (elementoAComprobar < tmpDatoAComprobar.getEdad()) {
                                elementoAComprobar = tmpDato.getEdad();
                            }
                            AuxAComprobar = AuxAComprobar.getSig();
                        }
                        Aux = Aux.getSig();
                    }
                }
                maximoEncontrado = elementoAComprobar;
                return maximoEncontrado;
            case "min":
                float minEncontrado = 0;

                if (!this.Vacia()) {
                    Aux = getInicio();
                    tmpDato = Aux.getInfo();
                    elementoAComprobar = tmpDato.getEdad();
                    while (Aux != null) {
                        tmpDato = Aux.getInfo();
                        AuxAComprobar = this.inicio;
                        for (int i = 0; i < contar; i++) {
                            tmpDatoAComprobar = AuxAComprobar.getInfo();
                            if (elementoAComprobar > tmpDatoAComprobar.getEdad()) {
                                elementoAComprobar = tmpDato.getEdad();
                            }
                            AuxAComprobar = AuxAComprobar.getSig();
                        }
                        Aux = Aux.getSig();
                    }
                }
                minEncontrado = elementoAComprobar;
                return minEncontrado;
            case "Promedio":
                float promedioGeneral = 0;
                float elementosSumados = 0;
                if (!this.Vacia()) {
                    Aux = getInicio();
                    while (Aux != null) {
                        tmpDato = Aux.getInfo();
                        elementosSumados += tmpDato.getEdad();
                        Aux = Aux.getSig();
                    }
                }
                promedioGeneral = (elementosSumados / contar);
                return promedioGeneral;
            case "mediana":
                float[] edadesGuardadas = new float[contar];
                int condaroElementos = 0;

                if (!this.Vacia()) {
                    Aux = getInicio();
                    while (Aux != null) {
                        tmpDato = Aux.getInfo();
                        edadesGuardadas[condaroElementos] = tmpDato.getEdad();
                        condaroElementos++;
                        Aux = Aux.getSig();
                    }
                }
                int mitadArreglo = edadesGuardadas.length / 2;
                if (edadesGuardadas.length % 2 == 1) {
                    return edadesGuardadas[mitadArreglo];
                } else {
                    return (edadesGuardadas[mitadArreglo - 1] + edadesGuardadas[mitadArreglo]) / 2;
                }
            default:
                return 0;
        }
    }

    public TipoNodo getInicio() {
        return this.inicio;
    }

}
