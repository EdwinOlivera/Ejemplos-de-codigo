package poo;

public class Peces extends Animal {

	private String sHabitad;

	public Peces() {
		super();
		this.sHabitad = "";
	}

	public Peces(String sNombre, String sEspecie, String sGenero, String sSintomas, int iEdad, double dPeso,
			String sHabitad) {
		super(sNombre, sEspecie, sGenero, sSintomas, iEdad, dPeso);
		this.sHabitad = sHabitad;
	}
	

	public String getsHabitad() {
		return sHabitad;
	}

	public void setsHabitad(String sHabitad) {
		this.sHabitad = sHabitad;
	}

	protected String Desplazamiento() {
		return "Nadar";
	}
}
