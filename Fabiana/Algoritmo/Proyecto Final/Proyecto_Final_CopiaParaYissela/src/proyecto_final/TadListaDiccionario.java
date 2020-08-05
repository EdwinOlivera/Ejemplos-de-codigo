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

            pDato.setCategoria(categoriaAGuardar);
            if (this.Vacia()) {
                this.numeroCorrelativoPalabra++;
                pDato.setNumeroCorrelativo(numeroCorrelativoPalabra);
                nuevo.setInfoPalabra(pDato);

                this.inicioPalabras = nuevo;
                this.finalPalabras = nuevo;
            } else if (this.BuscarTermino(pDato)){
                this.numeroCorrelativoPalabra++;
                pDato.setNumeroCorrelativo(numeroCorrelativoPalabra);
                nuevo.setInfoPalabra(pDato);
                nuevo.setSig(this.inicioPalabras);
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

    //METODOS PARA CRUD DE DICCIONARIO
    // buscar termino
    public boolean BuscarTermino(InfoPalabra info) {
        TipoNodo aux;
        boolean exito = false;
        String infoPalabra;
        if (Vacia()) {
            exito = false;
        } else {
            aux = this.inicioPalabras;
            while (aux != null) {
                infoPalabra = aux.getInfoPalabra().getTermino();
                if (info.getTermino().equals(infoPalabra)) {
                    exito = true;
                }
                
                aux = aux.getSig();
            }
        }
        return exito;
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
                aux = aux.getSig();
            }
        }
        return aux;
    }

    //eliminar un termino
    public void EliminarTermino(String termino) {
        TipoNodo aux, auxAnt, auxSigui;
        aux = this.BuscarNodo(termino);

        if (aux == null) {
            System.out.println("No exite dato");
        } else {
            System.out.println("¿Desea eliminar el termino " + termino + "?");
            System.out.println("Ingresar");
            System.out.println("1. Si");
            System.out.println("2. No");
            Scanner teclado = new Scanner(System.in);
            String opcion = teclado.next();
            if (opcion.equals("1")) {

                if (this.inicioPalabras == this.finalPalabras) {
                    this.inicioPalabras = null;
                    this.finalPalabras = null;
                } else if (aux == this.inicioPalabras) {
                    this.inicioPalabras = this.inicioPalabras.getSig();
                    this.inicioPalabras.setAnt(null);

                } else if (aux == this.finalPalabras) {
                    this.finalPalabras = this.finalPalabras.getAnt();
                    this.finalPalabras.setSig(null);
                } else {
                    auxAnt = aux.getAnt();
                    auxSigui = aux.getSig();
                    auxAnt.setSig(auxSigui);
                    auxSigui.setAnt(auxAnt);
                }
                

            }

        }

    }

    // Insertar Palabra
  

    // Mostrar el diccionario
    public void MostrarDiccionario() {
        TipoNodo aux;
        InfoPalabra info;
        if (Vacia()) {
            System.out.println("No hay datos");
        } else {
            aux = this.inicioPalabras;
            while (aux != null) {
                info = aux.getInfoPalabra();
                System.out.println("--------------------------------");
                System.out.println("Termino     " + info.getTermino());
                System.out.println("Significado " + info.getSignificado());
                System.out.println("Categoria   " + info.getCategoria().getNombreCategoria());
                System.out.println("--------------------------------");
                aux = aux.getSig();
            }
        }
    }

    public void ModificarTermino(String termino) {
        TipoNodo aux;
        InfoPalabra info;
        aux = this.BuscarNodo(termino);
        if (aux == null) {
            System.out.println("No se encontro termino");
        } else {
            info = aux.getInfoPalabra();
            String palabra, significado, categoria;
            Scanner teclado = new Scanner(System.in);
            System.out.println("Termino " + info.getTermino());
            System.out.println("Ingrese nuevo termino");
            palabra = teclado.next();
            info.setTermino(palabra);
            System.out.println("Ingrese nuevo significado");
            significado = teclado.next();
            info.setSignificado(significado);
            categoria = info.getCategoria().getNombreCategoria();
            this.ModificarCategoria(categoria);
            
        }
        

    }

    
    
}
