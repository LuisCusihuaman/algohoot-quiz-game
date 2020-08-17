package poo.coders.main.modelo;

import poo.coders.main.modelo.comportamientos.Comportamiento;

import java.util.List;

public class Pregunta {
	private String enunciado;
	private List<Opcion> opciones;
	private Comportamiento comportamiento;


	public Pregunta(String enunciado, Comportamiento comportamiento) {
		this.comportamiento = comportamiento;
		this.enunciado = enunciado;
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


}
