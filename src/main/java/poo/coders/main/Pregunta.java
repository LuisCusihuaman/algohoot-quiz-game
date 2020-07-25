package poo.coders.main;

import java.util.List;

public class Pregunta {
	private Comportamiento tipoComportamiento;
	private String         textoPregunta;
	private List<Respuesta> respuestas;

	public Pregunta(String textoPregunta, Comportamiento comportamiento) {
		this.tipoComportamiento = comportamiento;
		this.textoPregunta = textoPregunta;
	}

	public String getTextoPregunta() {
		return textoPregunta;
	}

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

	public void agregarRespuesta(Respuesta respuesta){
		respuestas.add(respuesta);
	}

	public void agregarRespuestas(List<Respuesta> respuestas){
		this.respuestas.addAll(respuestas);
	}

}
