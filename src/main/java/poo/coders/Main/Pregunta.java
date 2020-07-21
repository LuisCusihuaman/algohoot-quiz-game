package poo.coders.Main;

public class Pregunta {
	private Comportamiento tipoComportamiento;
	private String pregunta;
	private Respuesta respuesta ;

	public Pregunta(String pregunta, Respuesta respuesta, Comportamiento comportamiento){
		this.tipoComportamiento = comportamiento;
		this.pregunta = pregunta;
		this.respuesta = respuesta ;
	}


	private Puntos evaluarRespuesta(Respuesta respuesta){
		Puntos puntajeRespuesta = new Puntos();
		respuesta.aplicarComportamiento( tipoComportamiento, puntajeRespuesta );
		return puntajeRespuesta ;
	}

	public Puntos calcularPuntaje(Respuesta[] respuestas){
		Puntos puntajeTotalPregunta = new Puntos();
		for (Respuesta unaRespuesta : respuestas){
			puntajeTotalPregunta.sumar(this.evaluarRespuesta(unaRespuesta));
		}
		return puntajeTotalPregunta;
	}
}
