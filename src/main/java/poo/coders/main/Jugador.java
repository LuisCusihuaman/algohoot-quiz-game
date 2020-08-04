package poo.coders.main;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

	private String nombre;
	private int puntajeJugador = 0;

	public Jugador(String nombre) {
		this.nombre = nombre;
	}

	public void procesarPregunta(Pregunta pregunta, List<Respuesta> respuestas) {
		puntajeJugador = puntajeJugador + pregunta.obtenerPuntaje(respuestas);
	}

	public void procesarPregunta(Pregunta pregunta, ArrayList<String> respuestas) {
		puntajeJugador = puntajeJugador + pregunta.obtenerPuntaje(respuestas);
	}

	public int getPuntos() {
		return puntajeJugador;
	}
}
