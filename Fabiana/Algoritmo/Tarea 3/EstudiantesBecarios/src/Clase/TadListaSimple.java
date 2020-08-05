package Clase;

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
//Funcion que muestra todos los datos de requeridos
    public void Mostrar() {
        int numeroCorrelativoLista = 0;
        TipoNodo Aux;
        TipoInfo tmpDato;
        if (!this.Vacia()) {
            Aux = this.inicio;
            while (Aux != null) {
                numeroCorrelativoLista++;
                tmpDato = Aux.getInfo();
                System.out.println(
                        "#" + numeroCorrelativoLista
                        + " -> Numero de Cuenta: " + tmpDato.getNumeroCuenta()
                        + ", Carrera -> " + tmpDato.getEstudioCarrera()
                        + ", Beca -> " + tmpDato.isBeca());
                Aux = Aux.getSig();
            }
        }
    }
//Funcion creada con el objetivo de retornar un objeto del conjunto para ser guardado en un conjunto temporal
    public TipoInfo RetornarElemento( int numeroDeObjeto) {
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


    public void Insertar(TipoInfo pDato) {
        TipoNodo nuevo = new TipoNodo();
        TipoNodo Aux, AuxAnt;

        nuevo.setInfo(pDato);
        if (this.Vacia()) {
            this.inicio = nuevo;
        }  else {
                AuxAnt = this.inicio;
                Aux = this.inicio.getSig();
                while ((Aux != null) ) {                    
                    AuxAnt = Aux;
                    Aux = Aux.getSig();
                }
                    AuxAnt.setSig(nuevo);
        }
        contar++;
    }
    
//Funcion utilizada para eliminar un elemento a la vez
      public TipoInfo Eliminar() {
        TipoInfo temp;
        TipoNodo aux;
        if (this.Vacia()) {
            return null;
        } else {
            temp = this.inicio.getInfo();
            aux = this.inicio.getSig();
            this.inicio = aux;
            
        }
        return temp;
    }//fin sacar

    public TipoNodo getInicio() {
        return this.inicio;
    }

    public int CantidadElementos() {
        return this.contar;
    }

}
