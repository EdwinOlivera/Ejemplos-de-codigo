package clasesImplementadas;

import main.ClasePrincipal;

public class Clase_de_Enums {
	//En esta clase solo tiene que haber Enums y sus respectivos objetos
	// Definiendo a los Enum con sus difernete estados y objetos
	public enum TipoJuegos {
		NORMAL, DEUCE;
	}

	public enum JugadorConVentajas {
		NINGUNO, PC, USUARIO;
	}

	public enum cantidadDeVentajas {
		NIGUNA, PRIMERA, SEGUNDA;
	}

	public enum JuegosRealizados {
		NINGUNO, PRIMERO, SEGUNDO, TERCERO, CUARTO, QUINTO, SEXTO, SEPTIMO, OCTAVO, NOVENO, DECIMO, UNDECIMO,
		DECIMOSEGUNDO, DECIMOTERCERO, FINSET;
	}

	public enum PuntosAsignados {
		NINGUNO, PRIMERO, SEGUNDO, TERCERO;
	}

	public enum Lados {
		IZQUIERDA, DERECHA;
	}

	public enum Estados {
		INDEFINIDO, GANO, EMPATE;
	}

	public enum Turnos {
		USUARIO, PC;
	}

	public enum SaqueInciales {
		USUARIO, PC;
	}

	public enum Golpes {
		ACERTO, FALLO;
	}

	public enum JugadorGanadores {
		INDEFINIDO, PC, USUARIO;
	}

	public enum SetJugados {
		PRIMERO, SEGUNDO, TERCERO, FINMATCH;
	}

	public SetJugados getSetJugado() {
		return SetJugado;
	}

	public void setSetJugado(SetJugados setJugado) {
		SetJugado = setJugado;
	}

	public JuegosRealizados getGames() {
		return games;
	}

	public void setGames(JuegosRealizados games) {
		this.games = games;
	}

	public TipoJuegos getTipoDeJuego() {
		return tipoDeJuego;
	}

	public void setTipoDeJuego(TipoJuegos tipoDeJuego) {
		this.tipoDeJuego = tipoDeJuego;
	}

	public JugadorConVentajas getJugadorConLaVentaja() {
		return JugadorConLaVentaja;
	}

	public void setJugadorConLaVentaja(JugadorConVentajas jugadorConLaVentaja) {
		JugadorConLaVentaja = jugadorConLaVentaja;
	}

	public cantidadDeVentajas getNumeroDeVentaja() {
		return NumeroDeVentaja;
	}

	public void setNumeroDeVentaja(cantidadDeVentajas numeroDeVentaja) {
		NumeroDeVentaja = numeroDeVentaja;
	}

	public JugadorGanadores getJugadorQueGano() {
		return jugadorQueGano;
	}

	public void setJugadorQueGano(JugadorGanadores jugadorQueGano) {
		this.jugadorQueGano = jugadorQueGano;
	}

	public Lados getLadoPC() {
		return ladoPC;
	}

	public void setLadoPC(Lados ladoPC) {
		this.ladoPC = ladoPC;
	}

	public Lados getLadoUsuario() {
		return ladoUsuario;
	}

	public void setLadoUsuario(Lados ladoUsuario) {
		this.ladoUsuario = ladoUsuario;
	}

	public Estados getEstado() {
		return estado;
	}

	public void setEstado(Estados estado) {
		this.estado = estado;
	}

	public Turnos getTurnoActual() {
		return turnoActual;
	}

	public void setTurnoActual(Turnos turnoActual) {
		this.turnoActual = turnoActual;
	}

	public SaqueInciales getPrimerSaque() {
		return primerSaque;
	}

	public void setPrimerSaque(SaqueInciales primerSaque) {
		this.primerSaque = primerSaque;
	}

	public Golpes getGolpe() {
		return golpe;
	}

	public void setGolpe(Golpes golpe) {
		this.golpe = golpe;
	}

	public PuntosAsignados getSumarPuntosPC() {
		return sumarPuntosPC;
	}

	public void setSumarPuntosPC(PuntosAsignados sumarPuntosPC) {
		this.sumarPuntosPC = sumarPuntosPC;
	}

	public PuntosAsignados getSumarPuntosUsuario() {
		return sumarPuntosUsuario;
	}

	public void setSumarPuntosUsuario(PuntosAsignados sumarPuntosUsuario) {
		this.sumarPuntosUsuario = sumarPuntosUsuario;
	}

	public ClasePrincipal getPrincipalClase() {
		return PrincipalClase;
	}

	public void setPrincipalClase(ClasePrincipal principalClase) {
		PrincipalClase = principalClase;
	}

	SetJugados SetJugado = SetJugados.PRIMERO;

	JuegosRealizados games = JuegosRealizados.NINGUNO;

	TipoJuegos tipoDeJuego = TipoJuegos.NORMAL;
	JugadorConVentajas JugadorConLaVentaja = JugadorConVentajas.NINGUNO;
	cantidadDeVentajas NumeroDeVentaja = cantidadDeVentajas.NIGUNA;

	JugadorGanadores jugadorQueGano = JugadorGanadores.INDEFINIDO;
	Lados ladoPC = Lados.DERECHA; // Lado de lanzamiento de la PC
	Lados ladoUsuario = Lados.DERECHA; // Lado de lanzamiento del Usuario
	Estados estado = Estados.INDEFINIDO;
	Turnos turnoActual = Turnos.USUARIO; // Establece el turno del lanzador que sigue
	SaqueInciales primerSaque = SaqueInciales.PC;
	Golpes golpe = Golpes.ACERTO; // Define si acierta o falla un golpe
	PuntosAsignados sumarPuntosPC = PuntosAsignados.NINGUNO;
	PuntosAsignados sumarPuntosUsuario = PuntosAsignados.NINGUNO;
	// ***************************

	ClasePrincipal PrincipalClase = new ClasePrincipal();

}
