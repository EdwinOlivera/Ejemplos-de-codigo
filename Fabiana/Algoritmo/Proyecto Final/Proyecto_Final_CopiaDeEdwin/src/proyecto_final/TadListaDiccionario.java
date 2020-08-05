package proyecto_final;

import java.util.Scanner;

public class TadListaDiccionario {

    private TipoNodoPalabra finalPalabras;
    private TipoNodoPalabra inicioPalabras;
    private TipoNodoCategoria inicioCategoria;
    private TipoNodoCategoria finalCategoria;

    private boolean categoriaExiste = false;
    private int numeroCorrelativoCategoria = 0;
    private int numeroCorrelativoPalabra = 0;

    public TadListaDiccionario() {
        this.finalPalabras = null;
        this.inicioPalabras = null;
        this.inicioCategoria = null;
    }

    public boolean Vacia() {
        if (this.inicioPalabras == null) {
            return true;
        } else {
            return false;
        }
    }

    //METODOS PARA EL CRUD DE LAS PALABRAS
//Crear
    public void IntertarPalabra(InfoPalabra pDato, String categoriAsingada) {
        TipoNodoPalabra nuevo = new TipoNodoPalabra();
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
            System.out.println("No se guardo la palabra debido a que no existe la categoria para dicha palabra" + categoriAsingada);
        }

    }

//Mostrar
    public void MostrarPalabras() {
        TipoNodoPalabra aux;
        InfoPalabra info;
        if (Vacia()) {
            System.out.println("No hay datos");
        } else {
            aux = this.finalPalabras;
            while (aux != null) {
                info = aux.getInfoPalabra();
                System.out.println("--------------------------------");
                System.out.println("ID          " + info.getNumeroCorrelativo());
                System.out.println("Termino     " + info.getTermino());
                System.out.println("Significado " + info.getSignificado());
                System.out.println("Categoria   " + info.getCategoria().getNombreCategoria());
                System.out.println("<-------------------------------->");
                aux = aux.getAnt();
            }
        }

    }

//Eliminar
    public InfoPalabra EliminarPalabra(String pTermino) {

        boolean bTerminoElimanda = false;
        InfoPalabra infoTerminoDeseado = null;

        TipoNodoPalabra nodoTermino;

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

//Buscar
    public boolean BuscarPalabra(InfoPalabra info) {
        TipoNodoPalabra aux;
        boolean exito = false;
        InfoPalabra infoPalabra;
        if (Vacia()) {
            exito = false;
        } else {
            aux = this.inicioPalabras;
            while (aux != null) {
                info = aux.getInfoPalabra();
                if (info.equals(info)) {
                    exito = true;
                }
            }
        }
        return exito;
    }

//Modificar
    public void ModificarPalabra(String palabraRequerida) {
        Scanner teclado = new Scanner(System.in);
        boolean bPalabraModificada = false;
        InfoPalabra palabraAModificar = null;
        TipoNodoPalabra nodoPalabra;
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
    public TipoNodoPalabra BuscarNodoPalabra(String termino) {
        TipoNodoPalabra aux;
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
            }
        }
        return aux;
    }
//*****************************************************************************************************************************
//*****************************************************************************************************************************
//*****************************************************************************************************************************
//*****************************************************************************************************************************
    //METODOS PARA EL CRUD DE LAS CATEGORIAS

    public boolean IntertarCategoria(InfoCategoria cDato) {
        this.categoriaExiste = false;

        TipoNodoCategoria nuevo = new TipoNodoCategoria();
        nuevo.setInfoCategoria(cDato);
        TipoNodoCategoria Aux;
        InfoCategoria tmpDato;

        if (getCategoriaVacia()) {

            numeroCorrelativoCategoria++;
            nuevo.getInfoCategoria().setNumeroCorrelativo(numeroCorrelativoCategoria);
            this.inicioCategoria = nuevo;
            this.finalCategoria = nuevo;
        } else {

            Aux = this.inicioCategoria;
            while (Aux != null) {
                tmpDato = Aux.getInfoCategoria();
                if (tmpDato.getNombreCategoria().equals(cDato.getNombreCategoria())) {
                    this.categoriaExiste = true;
                }

                Aux = Aux.getSig();
            }//fin while

            //Aqui se verefica para ingresar o no la categoria
            if (!this.categoriaExiste) {
                numeroCorrelativoCategoria++;
                nuevo.getInfoCategoria().setNumeroCorrelativo(numeroCorrelativoCategoria);
                //<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL
                nuevo.setSig(this.inicioCategoria);
                this.inicioCategoria.setAnt(nuevo);
                this.inicioCategoria = nuevo;
            }
        }
        return this.categoriaExiste;
    }

    public boolean getCategoriaVacia() {
        if (this.inicioCategoria == null) {
            return true;
        } else {
            return false;
        }
    }

    public InfoCategoria getCategoriaSolicitada(String categoriaPedida) {
        InfoCategoria categoriaAEnviar = null;
        TipoNodoCategoria nodoCategoria;
        boolean categoriaEncontrada = false;
        nodoCategoria = this.inicioCategoria;
        while (nodoCategoria != null) {

            categoriaAEnviar = nodoCategoria.getInfoCategoria();
            if (categoriaAEnviar.getNombreCategoria().equals(categoriaPedida)) {
                categoriaEncontrada = true;
                return categoriaAEnviar;
            }
            nodoCategoria = nodoCategoria.getSig();
        }

        if (categoriaEncontrada == false) {
            categoriaAEnviar = null;

            System.out.println("No se encontro la Categoria solicitada. " + categoriaPedida);
        }
        return categoriaAEnviar;
    }

    public void MostrarCategorias() {
        InfoCategoria categoriaAEnviar = null;
        TipoNodoCategoria nodoCategoria;
        nodoCategoria = this.finalCategoria;
        while (nodoCategoria != null) {

            categoriaAEnviar = nodoCategoria.getInfoCategoria();
            System.out.println("ID - " + categoriaAEnviar.getNumeroCorrelativo() + ") Nombre de categoria = " + categoriaAEnviar.getNombreCategoria());
            nodoCategoria = nodoCategoria.getAnt();
        }

    }

    public boolean ModificarCategoria(String categoriaRequerida) {
        Scanner teclado = new Scanner(System.in);
        boolean bCategoriaModificada = false;
        InfoCategoria categoriaAModificar = null;
        TipoNodoCategoria nodoCategoria;
        nodoCategoria = this.inicioCategoria;
        while (nodoCategoria != null) {

            categoriaAModificar = nodoCategoria.getInfoCategoria();
            if (categoriaAModificar.getNombreCategoria().equals(categoriaRequerida)) {
                bCategoriaModificada = true;
                System.out.println("Ingrese el nuevo nombre que tendra la categoria");
                categoriaAModificar.setNombreCategoria(teclado.next());
            }
            nodoCategoria = nodoCategoria.getSig();
        }

        if (categoriaAModificar == null) {
            System.out.println("No se encontro la Categoria solicitada");
        }
        return bCategoriaModificada;
    }

    public boolean EliminarCategoria(String categoriaAEliminar) {
        //CODIGO DEFECTUOSO NO DESCOMENTAR
        Scanner teclado = new Scanner(System.in);
        boolean bCategoriaElimanda = false;

        InfoCategoria categoriaDeseada = null;

        TipoNodoCategoria nodoCategoria;

        nodoCategoria = this.inicioCategoria;
        while (nodoCategoria != null) {

            categoriaDeseada = nodoCategoria.getInfoCategoria();
            if (categoriaDeseada.getNombreCategoria().equals(categoriaAEliminar)) {
                bCategoriaElimanda = true;
                nodoCategoria = nodoCategoria.getAnt();
//              System.out.println("nodoCategoria " + nodoCategoria.getSig().getInfoCategoria().getNombreCategoria());
                nodoCategoria.setSig(nodoCategoria.getSig().getSig());
                break;
            }
            nodoCategoria = nodoCategoria.getSig();
        }

        if (bCategoriaElimanda == false) {
            System.out.println("No se elimino la Categoria solicitada");
        }
        return bCategoriaElimanda;
    }

// FUNCIONES PARA ORDENAR LISTAS
    public void OrdenarTermino(int intOpcion) {
        TipoNodoPalabra AuxI, AuxJ;
        boolean palabrasOrdenadas = false;
        String ID1, ID2;
        int multiplicador = 1;
        if (this.Vacia()) {
            System.out.println("No hay terminos registrados");

            return;
        }

        if (intOpcion == 1) {
            multiplicador = -1;
        }

        AuxI = this.inicioPalabras;
        while (AuxI.getSig() != null) {
            AuxJ = AuxI.getSig();
            while (AuxJ != null) {
                ID1 = AuxI.getInfoPalabra().getTermino();
                ID2 = AuxJ.getInfoPalabra().getTermino();
                if ((ID1.compareTo(ID2) * multiplicador) > 0) {
                    palabrasOrdenadas = true;
                    this.IntercambioTermino(AuxI, AuxJ);
                }
                AuxJ = AuxJ.getSig();
            }//fin j
            AuxI = AuxI.getSig();
        }//fin i
        if (palabrasOrdenadas) {
            System.out.println("Se ha ordenado Todos los terminos");
        }

    }

    public void OrdenarCategorias(int intOpcion) {
        TipoNodoCategoria AuxI, AuxJ;

        boolean palabrasOrdenadas = false;
        String ID1, ID2;
        int multiplicador = 1;
        if (this.Vacia()) {
            System.out.println("No hay Categorias registradas");

            return;
        }

        if (intOpcion == 1) {
            multiplicador = -1;
        }

        AuxI = this.inicioCategoria;
        while (AuxI.getSig() != null) {
            AuxJ = AuxI.getSig();
            while (AuxJ != null) {
                ID1 = AuxI.getInfoCategoria().getNombreCategoria();
                ID2 = AuxJ.getInfoCategoria().getNombreCategoria();
                if ((ID1.compareTo(ID2) * multiplicador) > 0) {
                    palabrasOrdenadas = true;
                    this.IntercambioCategoria(AuxI, AuxJ);
                }
                AuxJ = AuxJ.getSig();
            }//fin j
            AuxI = AuxI.getSig();
        }//fin i
        if (palabrasOrdenadas) {
            System.out.println("Se ha ordenado Todas las Categorias");
        }

    }

    public void OrdenarCategoriaTermino(int intOpcion) {

        //Codigo que ordena Los Terminos duspues de Organizar la Categorias
        TipoNodoPalabra AuxI, AuxJ;
        boolean palabrasOrdenadas = false;
        String info1, info2;
        int multiplicador = 1;

        if (intOpcion == 1) {
            multiplicador = -1;
        }

        AuxI = this.inicioPalabras;
        while (AuxI.getSig() != null) {
            AuxJ = AuxI.getSig();
            while (AuxJ != null) {

                info1 = AuxI.getInfoPalabra().getCategoria().getNombreCategoria();
                info2 = AuxJ.getInfoPalabra().getCategoria().getNombreCategoria();

                if ((info1.compareTo(info2) * multiplicador) > 0) {
                    palabrasOrdenadas = true;
                    this.IntercambioTermino(AuxI, AuxJ);
                }

                AuxJ = AuxJ.getSig();
            }//fin j
            AuxI = AuxI.getSig();
        }//fin i
//Seccion en donde se organizan los terminos dentro de las categorias
        AuxI = this.inicioPalabras;
        while (AuxI.getSig() != null) {
            AuxJ = AuxI.getSig();
            while (AuxJ != null) {
                if (AuxI.getInfoPalabra().getCategoria().getNombreCategoria() == AuxJ.getInfoPalabra().getCategoria().getNombreCategoria()) {

                    info1 = AuxI.getInfoPalabra().getTermino();
                    info2 = AuxJ.getInfoPalabra().getTermino();
                    if ((info1.compareTo(info2) * multiplicador) > 0) {
                        palabrasOrdenadas = true;
                        this.IntercambioTermino(AuxI, AuxJ);
                    }
                }

                AuxJ = AuxJ.getSig();
            }//fin j
            AuxI = AuxI.getSig();
        }//fin i

        if (palabrasOrdenadas) {
            System.out.println("Se ha ordenado Todos los terminos");
        }
    }

// FUNCIONES PARA INFORMES 
    public void BusquedaSimples(String palabraCriterio) {

    }

    public void BusquedaAvanzada(String palabraCriterio) {
        TipoNodoPalabra aux;
        boolean encontradoUnTermino = false;
        InfoPalabra infoPalabra;
        if (Vacia()) {
            System.out.println("¡No hay Terminos registrados!");
        } else {
            aux = this.finalPalabras;
            while (aux != null) {
                infoPalabra = aux.getInfoPalabra();
                if (infoPalabra.getTermino().contains(palabraCriterio)) {
                    if (!encontradoUnTermino) {
                        encontradoUnTermino = true;
                        System.out.println("---> Terminos encontrados: <---");
                    }
                    System.out.println(infoPalabra.getTermino());

                }
                aux = aux.getAnt();
            }
        }
        if (!encontradoUnTermino) {
            System.out.println("No se ha encontrado ningun termino");
        }
    }

    public void ConteoCategoria() {

        TipoNodoPalabra AuxPI, AuxPJ;

        TipoNodoCategoria AuxCI, AuxCJ;
        System.out.println("Categoria       Cantidad de terminos");
        int tmpConteoDeCategoria = 0;
        boolean palabrasOrdenadas = false;
        String info1, info2;

        AuxCI = this.inicioCategoria;
        while (AuxCI != null) {

            AuxPI = this.inicioPalabras;

            while (AuxPI != null) {

                if (AuxPI.getInfoPalabra().getCategoria().getNombreCategoria() == AuxCI.getInfoCategoria().getNombreCategoria()) {
                    tmpConteoDeCategoria++;
                }
                AuxPI = AuxPI.getSig();
            }//fin i
            System.out.println(AuxCI.getInfoCategoria().getNombreCategoria() + "-----------------" + tmpConteoDeCategoria);
            tmpConteoDeCategoria = 0;
            AuxCI = AuxCI.getSig();//Siguiente categoria
        }
        AuxPI = this.inicioPalabras;
        while (AuxPI.getSig() != null) {
            AuxPJ = AuxPI.getSig();
            while (AuxPJ != null) {
//if(AuxPI.getInfoPalabra().getCategoria().getNombreCategoria() ==)
                AuxPJ = AuxPJ.getSig();
            }//fin j
            AuxPI = AuxPI.getSig();
        }//fin i
    }

    public int getCantidadTerminos() {
        return this.numeroCorrelativoPalabra;
    }

//FUNCIONES DE APOYO
    private void IntercambioTermino(TipoNodoPalabra Nodo1, TipoNodoPalabra Nodo2) {
        InfoPalabra tmpDato;
        tmpDato = Nodo1.getInfoPalabra();
        Nodo1.setInfoPalabra(Nodo2.getInfoPalabra());
        Nodo2.setInfoPalabra(tmpDato);
    }

    private void IntercambioCategoria(TipoNodoCategoria Nodo1, TipoNodoCategoria Nodo2) {
        InfoCategoria tmpDato;
        tmpDato = Nodo1.getInfoCategoria();
        Nodo1.setInfoCategoria(Nodo2.getInfoCategoria());
        Nodo2.setInfoCategoria(tmpDato);
    }

    public int getCantidadDeTerminos() {
        return this.numeroCorrelativoPalabra;
    }
}
