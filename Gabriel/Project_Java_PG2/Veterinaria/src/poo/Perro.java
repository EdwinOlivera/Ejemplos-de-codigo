package poo;

public class Perro extends Animal {
	private String sRaza;

	public Perro() {
		super();
		this.sRaza = "";
	}

	public Perro(String sNombre, String sEspecie, String sGenero, String sSintomas, int iEdad, double dPeso,
			String sRaza) {
		super(sNombre, sEspecie, sGenero, sSintomas, iEdad, dPeso);
		this.sRaza = sRaza;
	}
	
	

	public String getsRaza() {
		return sRaza;
	}

	public void setsRaza(String sRaza) {
		this.sRaza = sRaza;
	}

	protected String Desplazamiento() {
		return "Trote";
	}

}
