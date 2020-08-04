package poo.coders.main;

import java.util.ArrayList;
import java.util.List;

public class Pregunta {
	private Comportamiento  tipoComportamiento;
	private String          textoPregunta;
	private List<Respuesta> respuestas;

	public Pregunta(String textoPregunta, Comportamiento comportamiento) {
		this.tipoComportamiento = comportamiento;
		this.textoPregunta = textoPregunta;
	}

	public String getTextoPregunta() {
		return textoPregunta;
	}
/*
	private Puntos obtenerPuntaje(Respuesta respuesta, Puntos puntajeRespuesta) {
		respuesta.aplicarComportamiento(tipoComportamiento, puntajeRespuesta);
		return puntajeRespuesta;
	}

	public Puntos obtenerPuntaje(List<Respuesta> respuestas) {
		Puntos puntajeTotalPregunta = new Puntos();
		for (Respuesta unaRespuesta : respuestas) {
			this.obtenerPuntaje(unaRespuesta, puntajeTotalPregunta);
		}
		return puntajeTotalPregunta;
	}
*/
	public int obtenerPuntaje(List<Respuesta> respuestas) {
		Puntaje puntajePregunta = tipoComportamiento.crearPuntaje();

		for (Respuesta unaRespuesta : respuestas) {
			unaRespuesta.aplicarComportamiento(tipoComportamiento, puntajePregunta);
		}
		return puntajePregunta.getPuntajeAcumulado();
	}

	public int obtenerPuntaje(ArrayList<String> respuestas) {
		return this.obtenerPuntaje(tipoComportamiento.evaluarRespuestas(respuestas));
	}


}
