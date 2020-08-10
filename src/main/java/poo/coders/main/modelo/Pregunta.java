package poo.coders.main.modelo;

import java.util.List;

public class Pregunta {
	private String enunciado;
	private List<Opcion> opciones;
	private Comportamiento comportamiento;
	Exclusividad exclusividad;


	public Pregunta(String enunciado, Comportamiento comportamiento) {
		this.comportamiento = comportamiento;
		this.enunciado = enunciado;
		this.exclusividad = new Exclusividad();
	}

	public Pregunta(String enunciado, Comportamiento comportamiento, List<Opcion> opciones) {
		this(enunciado, comportamiento);
		this.opciones = opciones;
	}

	public List<Opcion> getOpciones() {
		return opciones;
	}

	public void setOpciones(List<Opcion> opciones) {
		this.opciones = opciones;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public String getTipoPregunta() {
		return this.comportamiento.getTipoPregunta();
	}

	public int obtenerPuntaje(List<Opcion> opcionesElegidasPorElJugador) {
		return comportamiento.obtenerPuntaje(opcionesElegidasPorElJugador);
	}

	public void activarExclusividadEnPregunta() {
		this.exclusividad.activarExclusividad();
	}

	public void aplicarConJugadores(Jugador jugador1, Jugador jugador2, List<Opcion> respuestasJugador1, List<Opcion> respuestasJugador2) {
		int puntajeJugador1 = this.obtenerPuntaje(respuestasJugador1);
		int puntajeJugador2 = this.obtenerPuntaje(respuestasJugador2);
		exclusividad.determinarPuntosGanados(jugador1, jugador2, puntajeJugador1, puntajeJugador2);
		exclusividad.reiniciarExclusividad();
	}

}
