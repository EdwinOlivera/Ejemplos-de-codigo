package listadoble;

/**
 *
 * @author Ricardo Rivera
 */
public class TipoInfo {

    String identidad;
    String nombre;
    int   edad;
  

    public TipoInfo() {
        this.nombre = "";
        this.identidad="";
        this.edad=0;
    }

    public String getIdentidad() {
        return identidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setIdentidad(String identidad) {
        this.identidad = identidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    
    
}
