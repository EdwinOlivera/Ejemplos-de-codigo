package listadobleexam;

/**
 * Author: Fabiana Yamaly Artiaga Portillo Cuenta:20151000019
 */
public class ListaDobleTAD {

    private DNodo principio;
    private DNodo fin;
    private DNodo apuntadorDer;
    private DNodo apuntadorIzq;

    private int sumaDer;
    private int sumaIzq;

    //constructores
    public ListaDobleTAD() {
        this.principio = null;
        this.fin = null;
    }

    //operaciones TAD
    //Metodo para saber si esta vacia
    public boolean DVacia() {
        if (this.principio == null) {
            return true;
        } else {
            return false;
        }
    }

    //Metodo para mostrar en la lista 
    public void DMostrar() {
        DNodo Aux;
        DInfo tmpDato;
        int contar = 0;
        if (this.DVacia()) {
            System.out.println("Lista vacía!!");
        } else {
            Aux = this.principio;
            while (Aux != null) {
                contar++;
                tmpDato = Aux.getInfo();
                System.out.println("#)" + contar + " -> " + tmpDato.getNumero());
                Aux = Aux.getSiguiente();
            }//fin while
        }//fin si
    }

    //Metodo para insertar al inicio
    public void DIntertarInicio(DInfo pDato) {
        DNodo nuevo = new DNodo();
        nuevo.setInfo(pDato);
        if (this.DVacia()) {

            this.principio = nuevo;
            this.fin = nuevo;
            this.apuntadorDer = nuevo;
            this.apuntadorIzq = nuevo;

        } else {

            nuevo.setSiguiente(this.principio);
            this.principio.setAnterior(nuevo);
            this.principio = nuevo;
        }
    }

    public int DIniciarRecorrido() {
        int sumatoriaTotal = 0;

        int turnoDeAPuntador = 0;
        if (this.DVacia()) {
            System.out.println("Lista vacía!!");
        } else {
            this.apuntadorDer = this.fin;
            this.apuntadorIzq = this.principio;

            while (this.apuntadorDer.getAnterior() != this.apuntadorIzq.getAnterior()) {

                switch (turnoDeAPuntador) {
                    case 1:
                        turnoDeAPuntador = 2;
                        this.sumaIzq += apuntadorIzq.getSiguiente().getInfo().getNumero();
                        apuntadorIzq = apuntadorIzq.getSiguiente();

                        break;
                    case 2:
                        turnoDeAPuntador = 1;
                        this.sumaDer += apuntadorDer.getSiguiente().getInfo().getNumero();
                        apuntadorDer = apuntadorDer.getAnterior();
                        break;
                }

            }//fin while
        }//fin si
        sumatoriaTotal = this.sumaDer + this.sumaIzq;
        return sumatoriaTotal;
    }

    // gets
    public DNodo getInicio() {
        return this.principio;
    }

    public DNodo getFinal() {
        return this.fin;
    }

    public int getSumaDer() {
        return this.sumaDer;
    }

    public int getSumaIzq() {
        return this.sumaIzq;
    }
}
