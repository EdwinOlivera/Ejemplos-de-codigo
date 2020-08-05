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
        System.out.println();

        if (this.Vacia()) {
            System.out.println("----> NO HAY NIGUN NUMERO INGRESADO<----");
        } else {
            Numeros temp;
            System.out.println("----> PILA ORGINILA INGRESADA<----");
            
            for (int i = 1; i < this.getCima() + 1; i++) {
                temp = this.numero[i];

                System.out.println(" " + temp.getNumeroIngresado());
            }
            
            
            System.out.println();
            System.out.println("----> PILA SOLAMENTE DE NUMEROS IMPARES<----");
            for (int i = 1; i < this.getCima() + 1; i++) {
                temp = this.numero[i];
                if (temp.getNumeroIngresado() % 2 != 0) {
                    System.out.println(" " + temp.getNumeroIngresado());
                }
            }
        }
        System.out.println("¡PILA VACIA!");
    }
}
