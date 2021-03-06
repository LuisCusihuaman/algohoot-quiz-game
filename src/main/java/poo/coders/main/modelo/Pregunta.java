package poo.coders.main.modelo;

import poo.coders.main.modelo.comportamientos.Comportamiento;
import poo.coders.main.modelo.comportamientos.ComportamientoConExclusividad;
import poo.coders.main.modelo.comportamientos.ComportamientoConMultiplicador;
import poo.coders.main.modelo.modificadores.Exclusividad;
import poo.coders.main.modelo.modificadores.Multiplicador;

import java.util.List;

public class Pregunta {
	private String enunciado;
	private List<Opcion> opciones;
	private Comportamiento comportamiento;
	private Pregunta siguientePregunta;


	public Pregunta(String enunciado, Comportamiento comportamiento) {
		this.comportamiento = comportamiento;
		this.enunciado = enunciado;
	}

	public Pregunta(String enunciado, Comportamiento comportamiento, List<Opcion> opciones) {
		this(enunciado, comportamiento);
		this.opciones = opciones;
	}

	public void setSiguientePregunta(Pregunta siguientePregunta) {
		this.siguientePregunta = siguientePregunta;
	}
	public Pregunta getSiguientePregunta() {
		return siguientePregunta;
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

	public int obtenerPuntaje(List<Opcion> opcionesDeJugador, Multiplicador multiplicador) {
		return multiplicador.modificarPuntos(this.comportamiento.obtenerPuntaje(opcionesDeJugador));
	}

	public void agregarMultiplicadorAJugador(Jugador jugador, Multiplicador multiplicador) {
		((ComportamientoConMultiplicador)comportamiento).agregarMultiplicadorAJugador(jugador, multiplicador);
	}

	public Exclusividad activarExclusividad(Exclusividad exclusividad) {
		return ((ComportamientoConExclusividad)comportamiento).activarExclusividad(exclusividad);
	}
}
