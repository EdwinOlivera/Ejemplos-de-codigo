package listasimpleexam;

/**
 * Author: Fabiana Yamaly Artiaga Portillo cuenta: 20151000019
 */
public class InfoSemana {

    private InfoEstudiante[] estudiante;
    private int numeroDesemana;

    public InfoSemana() {
        numeroDesemana = 0;
    }

    public int getNumeroDesemana() {
        return numeroDesemana;
    }

    public void setNumeroDesemana(int numeroDesemana) {
        this.numeroDesemana = numeroDesemana;
    }

    public InfoEstudiante[] getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(InfoEstudiante[] estudiante) {
        this.estudiante = estudiante;
    }

}
