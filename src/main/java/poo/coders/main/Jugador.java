package poo.coders.main;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

	private String nombre;
	private int puntajeJugador = 0;
	private int multiplicador = 1;

	public Jugador(String nombre) {
		this.nombre = nombre;
	}

	public void procesarPregunta(Pregunta pregunta, List<Respuesta> respuestas) {
		puntajeJugador = puntajeJugador + pregunta.obtenerPuntaje(respuestas);
	}

	public void procesarPregunta(Pregunta pregunta, ArrayList<String> respuestas) {
		puntajeJugador = puntajeJugador + multiplicador * pregunta.obtenerPuntaje(respuestas);
	}
	public void usarMultiplicadorX2() {
		multiplicador = 2;
	}

	public void usarMultiplicadorX3() {
		multiplicador = 3;
	}

	public int getPuntos() {
		return puntajeJugador;
	}
}
