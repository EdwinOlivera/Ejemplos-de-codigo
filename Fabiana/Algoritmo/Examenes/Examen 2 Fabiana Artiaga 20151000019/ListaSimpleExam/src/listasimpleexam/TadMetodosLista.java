package listasimpleexam;

import java.util.Scanner;

/**
 * Author:Fabiana Yamaly Artiaga Portillo Cuenta:20151000019
 */
//Operaciones
public class TadMetodosLista {

    private Nodo primero;
    private boolean registroLleno = false;
    private int contadorDeSemanas;

    //Contructor
    public TadMetodosLista() {
        this.primero = null;
        contadorDeSemanas = 0;
    }

    //Metodo para saber si esta vacia
    public boolean ComVacia() {
        if (this.primero == null) {
            return true;
        } else {
            return false;
        }
    }

    //Metodo para Mostrar 
    public void MostrarLista() {
        Nodo Aux;
        InfoSemana tmpDato;
        int contar = 0;
        if (this.ComVacia()) {
            System.out.println("Lista vacía!!");
        } else {
            Aux = this.primero;
            while (Aux != null) {
                contar++;
                tmpDato = Aux.getArchivo();
                System.out.println("Semena) " + tmpDato.getNumeroDesemana());
                for (int i = 0; i < tmpDato.getEstudiante().length; i++) {
                    System.out.println("Num de cuenta " + tmpDato.getEstudiante()[i].getNumeroDecuenta());
                    System.out.println("Nota 1 " + tmpDato.getEstudiante()[i].getNota1());
                    System.out.println("Nota 2 " + tmpDato.getEstudiante()[i].getNota2());

                }
                Aux = Aux.getSiguiente();
            }//fin while
        }//fin si
    }

    //Metodo que inserta al inicio
    public void Insertar(InfoSemana pDato) {
        Nodo nuevo = new Nodo();
        nuevo.setArchivo(pDato);
        if (this.ComVacia()) {
            this.primero = nuevo;
        } else {
            nuevo.setSiguiente(this.primero);
            this.primero = nuevo;
        }
        this.contadorDeSemanas++;
        if (this.contadorDeSemanas >= 7) {
            this.registroLleno = true;
        }
    }

    public boolean CambiarNota(String numCuenta, int opcionNotaAModificar) {
        boolean encontrado = false;
        Scanner teclado = new Scanner(System.in);
        int tmpNumero = 0;
        Nodo Aux;
        InfoSemana tmpDato;
        if (this.ComVacia()) {
            System.out.println("Lista vacía!!");
        } else {
            Aux = this.primero;
            while (Aux != null) {

                tmpDato = Aux.getArchivo();
                for (int i = 0; i < tmpDato.getEstudiante().length; i++) {
                    if (tmpDato.getEstudiante()[i].getNumeroDecuenta().equals(numCuenta)) {
                        encontrado = true;
                        System.out.println("Ingrese el valor de la nota ");

                        if (opcionNotaAModificar == 1) {

                            tmpNumero = teclado.nextInt();
                            tmpDato.getEstudiante()[i].setNota1(tmpNumero);
                        } else {
                            tmpNumero = teclado.nextInt();
                            tmpDato.getEstudiante()[i].setNota2(tmpNumero);
                        }

                    }

                }
                Aux = Aux.getSiguiente();
            }//fin while
        }//fin si

        return encontrado;

    }
//    public void Ordenado(InfoSemana pDato) {
//        Nodo nuevo = new Nodo();
//        Nodo Aux, AuxAnt;
//        String tmpNombreNodo, tmpNombreP;
//        boolean exito = false;
//        nuevo.setArchivo(pDato);
//        if (this.ComVacia()) {
//            this.primero = nuevo;
//        } else {
//            tmpNombreP = pDato.getNombre();
//            tmpNombreNodo = this.primero.getArchivo().getNombre();
//            if (tmpNombreNodo.compareTo(tmpNombreP) > 0) {
//                nuevo.setSiguiente(this.primero);
//                this.primero = nuevo;
//            } else {
//                AuxAnt = this.primero;
//                Aux = this.primero.getSiguiente();
//                while ((Aux != null) && (exito == false)) {
//                    tmpNombreNodo = Aux.getArchivo().getNombre();
//                    if (tmpNombreNodo.compareTo(tmpNombreP) > 0) {
//                        AuxAnt.setSiguiente(nuevo);
//                        nuevo.setSiguiente(Aux);
//                        exito = true;
//                    }
//                    AuxAnt = Aux;
//                    Aux = Aux.getSiguiente();
//                }//fin while
//                if (!exito) {
//                    AuxAnt.setSiguiente(nuevo);
//                }
//            }
//        }
//    }//fin ordenado
    //Metodo para buscar en la lista
//    public Info BuscarLista(String pID) {
//        Nodo Aux;
//        Info tmpDato = null;
//        boolean encontro = false;
//
//        if (!this.ComVacia()) {
//            Aux = this.primero;
//            while (Aux != null) {
//                tmpDato = Aux.getArchivo();
//                if (tmpDato.getNumCuenta().equals(pID)) {
//                    encontro = true;
//                    break;
//                }
//                Aux = Aux.getSiguiente();
//            }//fin while
//        }//fin si
//
//        if (encontro) {
//            return tmpDato;
//        } else {
//            return null;
//        }
//    }//fin buscar
    //Método que indica si el ID ya existe

    public boolean ExisteSemana(int pID) {
        Nodo Aux;
        InfoSemana tmpDato = null;
        boolean encontro = false;
        if (!this.ComVacia()) {
            Aux = this.primero;
            while (Aux != null) {
                tmpDato = Aux.getArchivo();
                if (tmpDato.getNumeroDesemana() == (pID)) {
                    encontro = true;
                    break;
                }
                Aux = Aux.getSiguiente();
            }//fin while
        }//fin si
        return encontro;
    }//fin buscar

//    public Info EliminarPorID(String pID) {
//        Nodo Aux;
//        Nodo AuxAnt;
//        Info tmpDato = null;
//        boolean Encontro = false;
//
//        if (this.ComVacia()) {
//            return null;
//        } else {
//            //revisar si el la primera posición
//            Aux = this.primero;
//            tmpDato = Aux.getArchivo();
//            if (tmpDato.getNumCuenta().equals(pID)) {
//                this.primero = Aux.getSiguiente();
//                Encontro = true;
//            } else {
//                Aux = this.primero.getSiguiente();
//                AuxAnt = this.primero;
//                while ((Aux != null) && (!Encontro)) {
//                    tmpDato = Aux.getArchivo();
//                    if (tmpDato.getNumCuenta().equals(pID)) {
//                        AuxAnt.setSiguiente(Aux.getSiguiente());
//                        Encontro = true;
//                        break;
//                    }
//                    AuxAnt = Aux;
//                    Aux = Aux.getSiguiente();
//                }
//            }
//            if (Encontro) {
//                return tmpDato;
//            } else {
//                return null;
//            }
//        }//fin no esta vacia 
//    }//fin eliminar
//    //Metodo que elimina por edad
//    public int EliminarPorEdad(int pEdad) {
//        Nodo Aux;
//        Nodo AuxAnt;
//        InfoSemana tmpDato = null;
//        int contar = 0;
//
//        if (this.ComVacia()) {
//            return 0;
//        } else {
//            Aux = this.primero;
//            AuxAnt = null;
//            while ((Aux != null)) {
//                tmpDato = Aux.getArchivo();
//                if (tmpDato.getNotaExamen() == pEdad) {
//                    contar++;
//                    if (AuxAnt == null) {//verificar si es el primer nodo
//                        this.primero = Aux.getSiguiente();
//                        Aux = this.primero;
//                    } else {
//                        AuxAnt.setSiguiente(Aux.getSiguiente());
//                        Aux = Aux.getSiguiente();
//                    }
//                } else {
//                    AuxAnt = Aux;
//                    Aux = Aux.getSiguiente();
//                }
//            }//fin while
//            return contar;
//        }//fin no esta vacia 
//    }//fin eliminar N
//    //Metodo que modifica por ID
//    public boolean ModificarPorID(String pID, Info DatoNuevo) {
//        Nodo Aux;
//        Info tmpDato = null;
//        boolean Encontro = false;
//        if (this.ComVacia()) {
//            return true;
//        } else {
//            //recorrer para buscar
//            Aux = this.primero;
//            while (Aux != null) {
//                tmpDato = Aux.getArchivo();
//                if (tmpDato.getNumCuenta().equals(pID)) {
//                    Aux.setArchivo(DatoNuevo);
//                    Encontro = true;
//                    break;
//                }
//                Aux = Aux.getSiguiente();
//            }
//            if (Encontro) {
//                return true;
//            } else {
//                return false;
//            }
//        }//fin no esta vacia 
//    }//fin modifica*/
    // gets
    public Nodo getInicio() {
        return this.primero;
    }

    public boolean getTodasLasSemanasRegistradas() {
        return this.registroLleno;
    }
}
