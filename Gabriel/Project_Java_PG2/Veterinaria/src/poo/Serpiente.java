package poo;

public class Serpiente extends Animal {

	private boolean Venenosa;

	public Serpiente() {
		super();
		this.Venenosa = false;
	}

	public Serpiente(String sNombre, String sEspecie, String sGenero, String sSintomas, int iEdad, double dPeso,
			boolean Venenosa) {
		super(sNombre, sEspecie, sGenero, sSintomas, iEdad, dPeso);
		this.Venenosa = Venenosa;
	}
	

	public boolean isVenenosa() {
		return Venenosa;
	}

	public void setVenenosa(boolean venenosa) {
		Venenosa = venenosa;
	}

	protected String Desplazamiento() {
		return "Arrastrar";
	}
}