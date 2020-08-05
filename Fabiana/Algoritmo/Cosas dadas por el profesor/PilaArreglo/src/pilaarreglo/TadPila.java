package pilaarreglo;

public class TadPila {
    private int cima;
    private int maximo;
    private TipoInfo[] info;

    //-----------------------------------------------------------------------------------------------
    //Operaciones fundamentales
    //-----------------------------------------------------------------------------------------------

    //constructor cuando no se envía máximo de pila
    public TadPila() {
        this.cima = 0;
        this.maximo = 100;
        this.info = new TipoInfo[this.maximo + 1];
    }

    //constructor cuando se envía máximo de pila
    public TadPila(int p_Max) {
        this.cima = 0;
        this.maximo = p_Max;
        this.info = new TipoInfo[p_Max + 1];
    }

    
    //verifica si la pila ha llegado al máximo
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

    //guarda información en la pila si no esta llena
    public boolean Meter(TipoInfo pDato) {
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

    //saca información en la pila si no esta vacía
    public TipoInfo Sacar() {
        TipoInfo temp;
        if (this.Vacia()) {
            temp = null;
        } else {
            temp = this.info[this.cima];
            this.cima--;
        }
        return temp;
    }

    //recupera información en la pila si no esta vacía (sin sacar el elemento)
    public TipoInfo VerCima() {
        TipoInfo temp;
        if (this.Vacia()) {
            temp = null;
        } else {
            temp = this.info[this.cima];
        }
        return temp;
    }

    //métodos de acceso a las variables
    public int getCima() {
        return this.cima;
    }
    
    //-----------------------------------------------------------------------------------------------
    //métodos no estandar del TAD
    //-----------------------------------------------------------------------------------------------
    
    //IMPORTANTE: este método hace un recorrido de todos los elementos de la pila
    public void Mostrar() {
        if (this.Vacia()) {
            System.out.println("----> LA PILA ESTA VACIA <----");
        } else {
            TipoInfo temp;
            for (int i = this.getCima(); i > 0; i--) {
                temp = this.info[i];
                if (i == this.getCima()) {
                    System.out.print("Cima--> ");
                    System.out.println(temp.getPlaca() + "-" + temp.getApartamento());
                } else {
                    System.out.println("\t" + temp.getPlaca() + "-" + temp.getApartamento());
                }
            }
        }
    }
    
    //método que busca si un carro se encuentra en la pila
    //si lo encuentra devuelve el índice de la posición en el arreglo, sino retorna 0
    public int Posicion(String pPlaca) {
        if (this.Vacia()) {
            return 0;
        } else {
            TipoInfo temp;
            for (int i = this.getCima(); i > 0; i--) {
                temp = this.info[i];
                if ( temp.getPlaca().equals(pPlaca)) {
                    return i;
                }
            }
        }
        return 0;
    }    
    

}

    
