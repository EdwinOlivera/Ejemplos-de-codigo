
package reordernar_frase;

/**
 *
 * @author yamap
 */
public class LinkedList {

    private int cima;
    private int maximo;
    private Palabra[] palabra;


    public LinkedList(int cantidadCaracteres) {
        this.cima = 0;
        this.maximo = cantidadCaracteres;
        this.palabra = new Palabra[maximo + 1];
    }


    public boolean Vacia() {
        if (this.cima == 0) {
            return true;
        } else {
            return false;
        }
    }

  
    public void Meter(Palabra objPalabra) {
        
        this.cima++;
        this.palabra[this.cima] = objPalabra;
        
        
    }

    public int getCima() {
        return this.cima;
    }

   
    public void Mostrar() {
        System.out.println();

        if (this.Vacia()) {
            System.out.println("----> NO HAY NIGUNA PALABRA ESCRITA <----");
        } else {
            Palabra temp;
            for (int i = this.getCima(); i > 0; i--) {
                temp = this.palabra[i];

                System.out.print(" " + temp.getPalbraAlmacenada());

            }
        }
        System.out.println();
    }

}
