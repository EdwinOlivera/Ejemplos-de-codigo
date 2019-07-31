package poo;

public abstract class Animal {
	private String sNombre;
	private String sEspecie;
	private String sGenero;
	private String sSintomas;
	private double dPeso;
	private int iEdad;

	public Animal() {

		this.sNombre = "";
		this.sEspecie = "";
		this.sGenero = "";
		this.sSintomas = "";
		this.iEdad = 0;
		this.dPeso = 0.0;
	}

	public Animal(String sNombre, String sEspecie, String sGenero, String sSintomas, int iEdad, double dPeso) {

		this.sNombre = sNombre;
		this.sEspecie = sEspecie;
		this.sGenero = sGenero;
		this.sSintomas = sSintomas;
		this.iEdad = iEdad;
		this.dPeso = dPeso;

	}

	protected String getsNombre() {
		return sNombre;
	}

	protected void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}

	protected String getsEspecie() {
		return sEspecie;
	}

	protected void setsEspecie(String sEspecie) {
		this.sEspecie = sEspecie;
	}

	protected String getsGenero() {
		return sGenero;
	}

	protected void setsGenero(String sGenero) {
		this.sGenero = sGenero;
	}

	protected String getsSintomas() {
		return sSintomas;
	}

	protected void setsSintomas(String sSintomas) {
		this.sSintomas = sSintomas;
	}

	protected double getdPeso() {
		return dPeso;
	}

	protected void setdPeso(double dPeso) {
		this.dPeso = dPeso;
	}

	protected int getiEdad() {
		return iEdad;
	}

	protected void setiEdad(int iEdad) {
		this.iEdad = iEdad;
	}

	protected abstract String Desplazamiento();

}