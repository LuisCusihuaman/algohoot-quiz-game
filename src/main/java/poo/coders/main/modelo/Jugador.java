package poo.coders.main.modelo;

import java.util.List;

public class Jugador {

	private String nombre;
	private int puntajeJugador = 0;
	private int multiplicador = 1;

	public Jugador(String nombre) {
		this.nombre = nombre;
	}

	public void procesarPregunta(Pregunta pregunta, List<Opcion> respuestas) {
		puntajeJugador = puntajeJugador + (multiplicador * pregunta.obtenerPuntaje(respuestas));
	}

	public int puntosConseguidosEnPregunta(Pregunta pregunta, List<Opcion> respuestas){
		return multiplicador * pregunta.obtenerPuntaje(respuestas);
	}

	public void procesarPregunta(Pregunta pregunta, List<Opcion> respuestas, Exclusividad exclusividad) {
		puntajeJugador = puntajeJugador + (exclusividad.aplicar(multiplicador * pregunta.obtenerPuntaje(respuestas)));
	}

	public void activarExclusividadEnPregunta(Pregunta pregunta) {
		pregunta.activarExclusividadEnPregunta();
	}

	public void usarMultiplicadorX2EnPregunta(Pregunta pregunta) {
		try {
			multiplicador = pregunta.activarMultiplicadorX2();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	public void usarMultiplicadorX3EnPregunta(Pregunta pregunta) {
		try {
			multiplicador = pregunta.activarMultiplicadorX3();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}


	public int getPuntos() {
		return puntajeJugador;
	}

	void ganarPuntaje(int puntaje ) {
		puntajeJugador += puntaje;
	}

}
