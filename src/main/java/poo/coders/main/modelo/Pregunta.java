package poo.coders.main.modelo;

import poo.coders.main.modelo.comportamientos.Comportamiento;

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
		return this.comportamiento.obtenerPuntaje(opcionesElegidasPorElJugador);
	}
	public int activarMultiplicadorX2(){
		return this.comportamiento.activarMultiplicadorX2();
	}

	public int activarMultiplicadorX3(){
		return this.comportamiento.activarMultiplicadorX3();
	}

	public void activarExclusividadEnPregunta() {
		this.comportamiento.activarExclusividad(this.exclusividad);
	}

	public void darPuntosAJugadores(Jugador jugador1, Jugador jugador2, List<Opcion> respuestasJugador1, List<Opcion> respuestasJugador2) {
		int puntajeJugador1 = jugador1.puntosConseguidosEnPregunta(this, respuestasJugador1);
		int puntajeJugador2 = jugador2.puntosConseguidosEnPregunta(this, respuestasJugador2);
		exclusividad.darPuntosAJugadores(jugador1, jugador2, puntajeJugador1, puntajeJugador2);

	}

}
