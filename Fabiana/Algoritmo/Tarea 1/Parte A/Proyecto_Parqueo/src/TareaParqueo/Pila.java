
package TareaParqueo;

/**
 *
 * @author yamap
 */
public class Pila {

    private int cima;
    private int maximo;
    private Info[] info;
    private int espaciosDisponible = 0;

    public Pila(int maximo) {
        this.cima = 0;
        this.maximo = maximo;
        this.info = new Info[maximo + 1];


    }
    public Pila() {
        this.cima = 0;
        this.maximo = 100;
        this.info = new Info[this.maximo + 1];
    }

    public int EspaciosDisponibles() {

        return maximo - cima;
    }

    public int AutosParqueados() {
        return cima - espaciosDisponible;
    }


    public boolean Llena() {
        if (this.cima == this.maximo) {
            return true;
        } else {
            return false;
        }
    }

    //verifica si la pila no tiene datos
    public boolean Vacia() {
        if (this.cima == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean Meter(Info pDato) {
        boolean Hecho;
        if (this.Llena()) {
            Hecho = false;
        } else {
            this.cima++;
            this.info[this.cima] = pDato;
            Hecho = true;
        }
        return Hecho;
    }

    public void Sacar(String placa) {
        Info temp;
        for (int i = 1; i < cima; i++) {
            temp = this.info[i];

            if (temp.getPlaca().equals(placa)) {
                System.out.println("Se ha retirado exitosamente el vehiculo");
                this.info[i].setPlaca("");
                this.info[i].setApartamento(0);

                break;
            }
        }
    }




    public int getCima() {
        return this.cima;
    }

    public void Mostrar() {
        if (this.Vacia()) {
            System.out.println("----> LA PILA ESTA VACIA <----");
        } else {
            Info temp;
            for (int i = this.getCima(); i > 0; i--) {
                temp = this.info[i];
                if (i == this.getCima()) {

                    System.out.print("Cima--> ");
                    System.out.println(temp.getPlaca() + "-" + temp.getApartamento());
                } else {
                    if (temp.getApartamento() == 0) {
                        System.out.println("\t Vehiculo Retirado" );

                    } else {

                        System.out.println("\t" + temp.getPlaca() + "-" + temp.getApartamento());
                    }
                }
            }
        }
    }

    

}
