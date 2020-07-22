package poo.coders.Main;

public class Pregunta {
	private Comportamiento tipoComportamiento;
	private String         textoPregunta;

	public Pregunta(String textoPregunta, Comportamiento comportamiento) {
		this.tipoComportamiento = comportamiento;
		this.textoPregunta = textoPregunta;
	}

	public String getTextoPregunta() {
		return textoPregunta;
	}

	private Puntos evaluarRespuesta(Respuesta respuesta) {
		Puntos puntajeRespuesta = new Puntos();
		respuesta.aplicarComportamiento(tipoComportamiento, puntajeRespuesta);
		return puntajeRespuesta;
	}

	public Puntos calcularPuntaje(Respuesta[] respuestas) {
		Puntos puntajeTotalPregunta = new Puntos();
		for (Respuesta unaRespuesta : respuestas) {
			puntajeTotalPregunta.sumar(this.evaluarRespuesta(unaRespuesta));
		}
		return puntajeTotalPregunta;
	}
}
