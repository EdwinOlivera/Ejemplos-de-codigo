package clasesCliente;

import clasePrincipal.Principal;

public class PropiedadesClientes {
	int Edad = 0;
	String NumeroTelefonico = "", Vivienda = "", CorreoElectronico = "", Alergias = "", Nombre = "", Apellido = "";
	char Sexo;
//Los Constructores de la Clase **************************************************
	public PropiedadesClientes() {
	}
	
	public PropiedadesClientes(int edad, String numeroTelefonico, String vivienda, String correoElectronico,
			String alergias, String nombre, String apellido, char sexo) {
		Edad = edad;
		NumeroTelefonico = numeroTelefonico;
		Vivienda = vivienda;
		CorreoElectronico = correoElectronico;
		Alergias = alergias;
		Nombre = nombre;
		Apellido = apellido;
		Sexo = sexo;
	}
//**************************************************


	//Set y Get Establecidos
	public int getEdad() {
		return Edad;
	}

	public void setEdad(int edad) {
		Edad = edad;
	}

	public String getNumeroTelefonico() {
		return NumeroTelefonico;
	}

	public void setNumeroTelefonico(String numeroTelefonico) {
		NumeroTelefonico = numeroTelefonico;
	}

	public String getVivienda() {
		return Vivienda;
	}

	public void setVivienda(String vivienda) {
		Vivienda = vivienda;
	}

	public String getCorreoElectronico() {
		return CorreoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		CorreoElectronico = correoElectronico;
	}

	public String getAlergias() {
		return Alergias;
	}

	public void setAlergias(String alergias) {
		Alergias = alergias;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public char getSexo() {
		return Sexo;
	}

	public void setSexo(char sexo) {
		Sexo = sexo;
	}

}
