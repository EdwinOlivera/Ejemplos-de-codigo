package proyecto_final;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TadListaDiccionario {

    private TipoNodoPalabra finalPalabras;
    private TipoNodoPalabra inicioPalabras;
    private TipoNodoCategoria inicioCategoria;
    private TipoNodoCategoria finalCategoria;

    private boolean categoriaExiste = false;
    private int numeroCorrelativoCategoria = 0;
    private int numeroCorrelativoPalabra = 0;
    private Scanner teclado = new Scanner(System.in);
    private BufferedReader tecladoBuffer = new BufferedReader(new InputStreamReader(System.in));
    private String tmpCadena = "";
    private int tmpNumero = 0;

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
                if (this.BuscarPalabra(pDato) == false) {
                    nuevo.setInfoPalabra(pDato);
                    nuevo.setSig(this.inicioPalabras);
                    this.inicioPalabras.setAnt(nuevo);
                    this.inicioPalabras = nuevo;
                }else{
                    System.out.println("No se guardo la palabra debido a que ya existe el termino");
                }
            }
                
        } else {
            System.out.println("No se guardo la palabra debido a que no existe la categoria para dicha palabra" + categoriAsingada);
        }

    }
    
     public void IntertarPalabraN(InfoPalabra pDato, String categoriAsingada) {
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
        TipoNodoPalabra aux, auxAnt, auxSigui;
        aux = this.BuscarNodoPalabra(pTermino);

        if (aux == null) {
            System.out.println("No exite dato");
        } else {
            System.out.println("¿Desea eliminar el termino " + pTermino + "?");
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
        return infoTerminoDeseado;

    }//fin eliminar

//Buscar
    public boolean BuscarPalabra(InfoPalabra info) {
        TipoNodoPalabra aux;
        boolean exito = false;
        String infoPalabra;
        if (Vacia()) {
            exito = false;
        } else {
            aux = this.inicioPalabras;
            while (aux != null) {
                infoPalabra = aux.getInfoPalabra().getTermino();
                if (infoPalabra.equals(info.getTermino())) {
                    exito = true;
                }
                aux = aux.getSig();
            }
        }
        return exito;
    }

//Modificar
    public void ModificarPalabra(String palabraRequerida) throws IOException {
        Scanner teclado = new Scanner(System.in);
        InfoCategoria tmpInfoCategoria;

        InfoPalabra palabraAModificar = null;
        TipoNodoPalabra nodoPalabra;
        nodoPalabra = this.inicioPalabras;

        while (nodoPalabra != null) {
            palabraAModificar = nodoPalabra.getInfoPalabra();
            if (palabraAModificar.getTermino().equals(palabraRequerida)) {

                System.out.print("Ingrese la categoria a la que pertenecera --> ");
                tmpInfoCategoria = this.getCategoriaSolicitada(this.tecladoBuffer.readLine());
                if (tmpInfoCategoria != null) {
                    palabraAModificar.setCategoria(tmpInfoCategoria);
                } else {
                    palabraAModificar = null;
                    break;
                }
                System.out.print("Ingrese nuevo termino --> ");
                palabraAModificar.setTermino(teclado.next());
                System.out.print("Ingrese el nuevo significado --> ");
                palabraAModificar.setSignificado(teclado.next());

            }
            nodoPalabra = nodoPalabra.getSig();
        }

        if (palabraAModificar == null) {
            System.out.println("No se modifico el termino deseado. :'o");
        }

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
                aux = aux.getSig();
            }
        }
        return aux;
    }

//*****************************************************************************************************************************
//*****************************************************************************************************************************
//*****************************************************************************************************************************
//*****************************************************************************************************************************
    //METODOS PARA EL CRUD DE LAS CATEGORIAS
    public boolean InsertarCategoria(InfoCategoria cDato) {
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
        int opcSelec = -1;
        Scanner teclado = new Scanner(System.in);

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
            System.out.println("No se ha encontrado la categoria solicitada");
            System.out.println("¿Desea registrar la categoria " + categoriaPedida + "?");
            do {
                System.out.println(""
                        + "1.	Si\n"
                        + "2.	No");

                opcSelec = teclado.nextInt();
            } while (opcSelec < 1 || opcSelec > 2);
            if (opcSelec == 1) {
                InfoCategoria cDato = new InfoCategoria();

                cDato.setNombreCategoria(categoriaPedida);
                this.InsertarCategoria(cDato);
                System.out.println("¡Nueva categoria agregada exitosamente!");
                categoriaAEnviar = cDato;

            } else {
                categoriaAEnviar = null;

            }

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
        Scanner teclado = new Scanner(System.in);
        boolean bCategoriaElimanda = false;

        InfoCategoria categoriaDeseada = null;

        TipoNodoCategoria nodoCategoria;
        TipoNodoCategoria aux, auxAnt, auxSigui;

        nodoCategoria = this.inicioCategoria;
        while (nodoCategoria != null) {

            categoriaDeseada = nodoCategoria.getInfoCategoria();
            if (categoriaDeseada.getNombreCategoria().equals(categoriaAEliminar)) {
                if (EliminacionTerminosAsociadosCategoria(categoriaDeseada.getNumeroCorrelativo())) {

                    bCategoriaElimanda = true;
                    if (this.inicioCategoria == this.finalCategoria) {
                        this.inicioCategoria = null;
                        this.finalCategoria = null;
                    } else if (nodoCategoria == this.inicioCategoria) {
                        this.inicioCategoria = this.inicioCategoria.getSig();
                        this.inicioCategoria.setAnt(null);
                    } else if (nodoCategoria == this.finalCategoria) {
                        this.finalCategoria = this.finalCategoria.getAnt();
                        this.finalCategoria.setSig(null);
                    } else {
                        auxAnt = nodoCategoria.getAnt();
                        auxSigui = nodoCategoria.getSig();
                        auxAnt.setSig(auxSigui);
                        auxSigui.setAnt(auxAnt);
                    }

                } else {
                    bCategoriaElimanda = false;
                }
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
        TipoNodoPalabra aux;
        String termino;
        aux = this.inicioPalabras;
        if (this.Vacia()) {
            System.out.println("No hay datos");
        } else {
            while (aux != null) {
                termino = aux.getInfoPalabra().getTermino();
                if (termino.startsWith(palabraCriterio)) {
                    System.out.println("-" + termino);
                }
                aux = aux.getSig();
            }
        }
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

    public void ConteoGeneralDeCategorias() {

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
//if(AuxPI.getInfoPalabra().getCategoria().getNombresCategoria() ==)
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

    public String[] getNombresCategoria() {
        String[] strNombreCategoria = new String[this.numeroCorrelativoCategoria];

        TipoNodoCategoria nodoCategoria;
        int indiceReccorido = 0;
        nodoCategoria = this.inicioCategoria;
        while (nodoCategoria != null) {

            strNombreCategoria[indiceReccorido] = nodoCategoria.getInfoCategoria().getNombreCategoria();
            nodoCategoria = nodoCategoria.getSig();
            indiceReccorido++;
        }

        return strNombreCategoria;
    }

    public boolean EliminacionTerminosAsociadosCategoria(int IDCategoria) {
        int numeroDeterminosAsociados = 0;
        boolean terminosEliminados = false;
        TipoNodoPalabra AuxPI;

        AuxPI = this.inicioPalabras;

        while (AuxPI != null) {

            if (AuxPI.getInfoPalabra().getCategoria().getNumeroCorrelativo() == IDCategoria) {
                numeroDeterminosAsociados++;
            }
            AuxPI = AuxPI.getSig();
        }//fin i
        System.out.println("Hay " + numeroDeterminosAsociados + " asociada a la categoria a eliminar.");
        System.out.println("¿desea eliminar la categoria, ya que existen " + numeroDeterminosAsociados + " de términos asociados?");
        System.out.println(""
                + "1.	Si\n"
                + "2.	No");
        this.tmpNumero = this.teclado.nextInt();
        if (this.tmpNumero == 1) {
            terminosEliminados = true;
            AuxPI = this.inicioPalabras;

            while (AuxPI != null) {

                if (AuxPI.getInfoPalabra().getCategoria().getNumeroCorrelativo() == IDCategoria) {
                    this.EliminarPalabra(AuxPI.getInfoPalabra().getTermino());
                }
                AuxPI = AuxPI.getSig();
            }//Fin while
            System.out.println("Se han elimnado todos los terminos asociados a la categoria");
        } else {
            terminosEliminados = false;
        }
        return terminosEliminados;
    }

}
