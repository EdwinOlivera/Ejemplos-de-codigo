package clasePrincipal;

import clasesCliente.PropiedadesClientes;
import formularios.FormularioPOS;

public class Principal {

	public static String MensajeFinal="Este es el final del Programa----------->>>>>>>>>>>";
	public static void main(String[] args) {
		FormularioPOS Formulario	= new FormularioPOS();
		Formulario.setVisible(true);
		PropiedadesClientes Clientes = new PropiedadesClientes();
		
		System.out.println(MensajeFinal);

	}

}
