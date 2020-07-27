package poo.coders.main;

import java.util.List;

public class Jugador {

	private String nombre;
	private Puntos totalPuntos;

	public Jugador(String nombre) {
		this.nombre = nombre;
		totalPuntos = new Puntos();
	}

	public Jugador(String nombre, int cantidadPuntos) {
		this.nombre = nombre;
		totalPuntos = new Puntos(cantidadPuntos);
	}

	public void procesarPregunta(Pregunta pregunta, List<Respuesta> respuestas) {
		Puntos diferencialPuntos = pregunta.obtenerPuntaje(respuestas);
		modificarPuntos(diferencialPuntos);
	}

	private void modificarPuntos(Puntos diferencialPuntos) {
		totalPuntos.sumar(diferencialPuntos);
	}

	public int getPuntos() {
		return totalPuntos.getCantidadPuntos();
	}

	public String getNombre() {
		return nombre;
	}
}
