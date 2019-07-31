package poo;

public class Pajaros extends Animal {

	private boolean Diurno;

	public Pajaros() {
		
		super();
		this.Diurno = false;
	}

	public Pajaros(String sNombre, String sEspecie, String sGenero, String sSintomas, int iEdad, double dPeso,
			boolean Diurno) {
		
		super(sNombre, sEspecie, sGenero, sSintomas, iEdad, dPeso);
		this.Diurno = Diurno;
	}

	public boolean isDiurno() {
		return Diurno;
	}

	public void setDiurno(boolean diurno) {
		Diurno = diurno;
	}

	@Override
	protected String Desplazamiento() {
		return "Nadar";
	}

}