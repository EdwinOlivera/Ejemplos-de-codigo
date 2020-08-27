package proyecto_final;

import java.util.Scanner;

public class TadListaDiccionario {

    private TipoNodo finalPalabras;
    private TipoNodo inicioPalabras;
    private TipoNodoCategoria categoriaInicio;
    private boolean categoriaExiste = false;
    private int numeroCorrelativoCategoria = 0;
    private int numeroCorrelativoPalabra = 0;

    public TadListaDiccionario() {
        this.finalPalabras = null;
        this.inicioPalabras = null;
        this.categoriaInicio = null;
    }

    public boolean Vacia() {
        if (this.finalPalabras == null) {
            return true;
        } else {
            return false;
        }
    }

    public void IntertarPalabra(InfoPalabra pDato, String categoriAsingada) {
        TipoNodo nuevo = new TipoNodo();
        InfoCategoria categoriaAGuardar = getCategoriaSolicitada(categoriAsingada);
        if (categoriaAGuardar != null) {
            this.numeroCorrelativoPalabra++;
            pDato.setNumeroCorrelativo(numeroCorrelativoPalabra);
            pDato.setCategoria(categoriaAGuardar);
            if (this.Vacia()) {
                nuevo.setInfoPalabra(pDato);
                this.inicioPalabras = nuevo;
                this.finalPalabras = nuevo;
            } else {
                nuevo.setInfoPalabra(pDato);
                nuevo.setSig(this.inicioPalabras);
                this.inicioPalabras.setAnt(nuevo);
                this.inicioPalabras = nuevo;
            }
        } else {
            System.out.println("No se guardo la palabra debido a que no existe la categoria para dicha palabra");
        }

    }

    public void MostrarPalabras() {
        InfoPalabra infoPalabra = null;
        TipoNodo nodoPalabra;
        nodoPalabra = this.inicioPalabras;
        while (nodoPalabra != null) {
            infoPalabra = nodoPalabra.getInfoPalabra();
            System.out.println("#" + infoPalabra.getNumeroCorrelativo() + ") Termino: " + infoPalabra.getTermino() + ", significado: " + infoPalabra.getSignificado() + ", Categoria: " + infoPalabra.getCategoria().getNombreCategoria());
            nodoPalabra = nodoPalabra.getSig();
        }

    }

    public void ModificarLaPalabra(String palabraRequerida) {
        Scanner teclado = new Scanner(System.in);
        boolean bPalabraModificada = false;
        InfoPalabra palabraAModificar = null;
        TipoNodo nodoPalabra;
        nodoPalabra = this.inicioPalabras;

        while (nodoPalabra != null) {
            palabraAModificar = nodoPalabra.getInfoPalabra();
            if (palabraAModificar.getTermino().equals(palabraRequerida)) {
                bPalabraModificada = true;
                System.out.println("Ingrese el nuevo nombre que tendra la categoria");
                palabraAModificar.setTermino(teclado.next());
            }
            nodoPalabra = nodoPalabra.getSig();
        }

        if (palabraAModificar == null) {
            System.out.println("No se encontro la Categoria solicitada");
        }
        System.out.println(bPalabraModificada);
        //return bPalabraModificada;
    }

    //buscar el termino y returnar el nodo
    public TipoNodo BuscarNodo(String termino) {
        TipoNodo aux;
        InfoPalabra info;
        if (Vacia()) {
            aux = null;
        } else {
            aux = this.inicioPalabras;
            while (aux != null) {
                info = aux.getInfoPalabra();
                if (info.getTermino().equals(termino)) {
                    return aux;
                }
                aux = aux.getAnt();
            }
        }
        return aux;
    }

    //eliminar un termino
    public InfoPalabra EliminarPalabra(String pTermino) {

        boolean bTerminoElimanda = false;
        InfoPalabra infoTerminoDeseado = null;

        TipoNodo nodoTermino;

        nodoTermino = this.inicioPalabras;
        while (nodoTermino != null) {

            infoTerminoDeseado = nodoTermino.getInfoPalabra();
            if (infoTerminoDeseado.getTermino().equals(pTermino)) {
                bTerminoElimanda = true;

                if (nodoTermino != this.inicioPalabras && nodoTermino != this.finalPalabras) {
                    nodoTermino = nodoTermino.getAnt();

                    nodoTermino.setSig(nodoTermino.getSig().getSig());

                } else if (nodoTermino == this.finalPalabras) {

                    nodoTermino = nodoTermino.getAnt();

                    nodoTermino.setSig(null);

                } else if (nodoTermino == this.inicioPalabras) {
                    nodoTermino = nodoTermino.getSig();
                    nodoTermino.setAnt(null);
                    this.inicioPalabras = nodoTermino;

                }
                break;
            }
            nodoTermino = nodoTermino.getSig();
        }

        if (bTerminoElimanda == false) {
            System.out.println("No se elimino La palabra solicitada");
        }
        return infoTerminoDeseado;

    }//fin eliminar

   
    //METODOS PARA EL CRUD DE LAS CATEGORIAS
    public void IntertarCategoria(InfoCategoria cDato) {
        this.categoriaExiste = false;

        TipoNodoCategoria nuevo = new TipoNodoCategoria();
        nuevo.setInfoCategoria(cDato);
        TipoNodoCategoria Aux;
        InfoCategoria tmpDato;

        if (getCategoriaVacia()) {

            numeroCorrelativoCategoria++;
            nuevo.getInfoCategoria().setNumeroCorrelativo(numeroCorrelativoCategoria);
            this.categoriaInicio = nuevo;
        } else {

            Aux = this.categoriaInicio;
            while (Aux != null) {
                tmpDato = Aux.getInfoCategoria();
                if (tmpDato.getNombreCategoria().equals(cDato.getNombreCategoria())) {
                    this.categoriaExiste = true;
                }

                Aux = Aux.getAnt();
            }//fin while

            //Aqui se verefica para ingresar o no la categoria
            if (!this.categoriaExiste) {
                numeroCorrelativoCategoria++;
                nuevo.getInfoCategoria().setNumeroCorrelativo(numeroCorrelativoCategoria);
                nuevo.setAnt(this.categoriaInicio);
                this.categoriaInicio = nuevo;

            } else {
                System.out.println("La categoria ya estaba registrada.");
            }
        }

    }

    public boolean getCategoriaVacia() {
        if (this.categoriaInicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public InfoCategoria getCategoriaSolicitada(String categoriaPedida) {
        InfoCategoria categoriaAEnviar = null;
        TipoNodoCategoria nodoCategoria;
        boolean categoriaEncontrada = false;
        nodoCategoria = this.categoriaInicio;
        while (nodoCategoria != null) {

            categoriaAEnviar = nodoCategoria.getInfoCategoria();
            if (categoriaAEnviar.getNombreCategoria().equals(categoriaPedida)) {
                categoriaEncontrada = true;
                return categoriaAEnviar;
            }
            nodoCategoria = nodoCategoria.getAnt();
        }

        if (categoriaEncontrada == false) {
            categoriaAEnviar = null;
            System.out.println("No se encontro la Categoria solicitada");
        }
        return categoriaAEnviar;
    }

    public void MostrarCategorias() {
        InfoCategoria categoriaAEnviar = null;
        TipoNodoCategoria nodoCategoria;
        nodoCategoria = this.categoriaInicio;
        while (nodoCategoria != null) {

            categoriaAEnviar = nodoCategoria.getInfoCategoria();
            System.out.println("#" + categoriaAEnviar.getNumeroCorrelativo() + ") Nombre de categoria = " + categoriaAEnviar.getNombreCategoria());
            nodoCategoria = nodoCategoria.getAnt();
        }

    }

    public boolean ModificarCategoria(String categoriaRequerida) {
        Scanner teclado = new Scanner(System.in);
        boolean bCategoriaModificada = false;
        InfoCategoria categoriaAModificar = null;
        TipoNodoCategoria nodoCategoria;
        nodoCategoria = this.categoriaInicio;
        while (nodoCategoria != null) {

            categoriaAModificar = nodoCategoria.getInfoCategoria();
            if (categoriaAModificar.getNombreCategoria().equals(categoriaRequerida)) {
                bCategoriaModificada = true;
                System.out.println("Ingrese el nuevo nombre que tendra la categoria");
                categoriaAModificar.setNombreCategoria(teclado.next());
            }
            nodoCategoria = nodoCategoria.getAnt();
        }

        if (categoriaAModificar == null) {
            System.out.println("No se encontro la Categoria solicitada");
        }
        return bCategoriaModificada;
    }

    public boolean EliminarCategoria(String categoriaAEliminar) {
        //CODIGO DEFECTUOSO NO DESCOMENTAR
//        Scanner teclado = new Scanner(System.in);
//        boolean bCategoriaElimanda = false;
//        InfoCategoria categoriaAModificar = null;
//        TipoNodoCategoria nodoCategoria;
//        nodoCategoria = this.categoriaInicio;
//        while (nodoCategoria != null) {
//
//            categoriaAModificar = nodoCategoria.getInfoCategoria();
//            if (categoriaAModificar.getNombreCategoria().equals(categoriaAEliminar)) {
//                bCategoriaElimanda = true;
//                System.out.println("Ingrese el nuevo nombre que tendra la categoria");
//                categoriaAModificar.setNombreCategoria(teclado.next());
//            }
//            nodoCategoria = nodoCategoria.getAnt();
//        }
//
//        if (categoriaAModificar == null) {
//            System.out.println("No se encontro la Categoria solicitada");
//        }
//        return bCategoriaElimanda;
        return false;
    }
}
