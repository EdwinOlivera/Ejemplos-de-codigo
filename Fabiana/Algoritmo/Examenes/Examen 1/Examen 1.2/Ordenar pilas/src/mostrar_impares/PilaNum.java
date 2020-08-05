package mostrar_impares;

/**
 *
 * @author yamap
 */
public class PilaNum {

    private Numeros[] numero;
    private int cima;
    private int maximo;

    public PilaNum(int cantidadNumeros) {
        this.cima = 0;
        this.maximo = cantidadNumeros;
        this.numero = new Numeros[maximo + 1];
    }

    public boolean Vacia() {
        if (this.cima == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void Meter(Numeros objNumero) {

        this.cima++;
        this.numero[this.cima] = objNumero;
    }

    public int getCima() {
        return this.cima;
    }

    public void Mostrar() {
        if (this.Vacia()) {
            System.out.println("----> NO HAY NIGUN NUMERO INGRESADO<----");
        } else {
            Numeros temp;
            for (int i = 1; i < this.getCima() + 1; i++) {
                temp = this.numero[i];

                System.out.println(" " + temp.getNumeroIngresado());
            }

        }

    }
//Ejercicio No. 2 del Examen;
    //Funcion que retorna un numero de la pila. USado actualmente para retornar todos los numeros de la Pila

    public int RetorNumeros(int numeroARetornar) {
        Numeros temp = new Numeros();

        for (int i = 1; i < numeroARetornar; i++) {
            temp = this.numero[i];
        }
        numeroARetornar = temp.getNumeroIngresado();

        return numeroARetornar;
    }
}
