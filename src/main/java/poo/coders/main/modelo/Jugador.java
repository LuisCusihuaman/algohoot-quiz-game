package poo.coders.main.modelo;

import java.util.ArrayList;
import java.util.List;

public class Jugador{

	private String nombre;
	private int puntajeJugador = 0;
	private int multiplicador = 1;

	public Jugador(String nombre) {
		this.nombre = nombre;
	}

	public void procesarPregunta(Pregunta pregunta, List<Opcion> respuestas) {
		puntajeJugador = puntajeJugador + (multiplicador * pregunta.obtenerPuntaje(respuestas));
	}

	public void procesarPregunta(Pregunta pregunta, List<Opcion> respuestas, Exclusividad exclusividad) {
		puntajeJugador = puntajeJugador + (exclusividad.aplicar(multiplicador * pregunta.obtenerPuntaje(respuestas)));
	}

	public void activarExclusividad(Exclusividad exclusividad){
		exclusividad.activarExclusividad();
	}

	public void activarExclusividadEnPregunta(Pregunta pregunta) {
		pregunta.activarExclusividadEnPregunta();
	}

	public void usarMultiplicadorX2() {
		multiplicador = 2;
	}

	public void usarMultiplicadorX3() {
		multiplicador = 3;
	}

	public void aplicarExclusividad(Pregunta pregunta, List<Opcion> respuestas){
		puntajeJugador = puntajeJugador + (multiplicador * pregunta.obtenerPuntaje(respuestas) * 2);
	}

	public int getPuntos() {
		return puntajeJugador;
	}

	void ganarPuntaje(int puntaje ) {
		puntajeJugador += puntaje;
	}
}
