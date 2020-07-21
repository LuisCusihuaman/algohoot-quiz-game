package poo.coders.Main;

public class Pregunta {
	private Comportamiento tipoComportamiento;
	private String pregunta;
	private Puntos diferencialPuntos; //n
	private Respuesta respuesta ;

	public Pregunta(String pregunta, Respuesta respuesta, Comportamiento comportamiento){
		this.tipoComportamiento = comportamiento;
		this.pregunta = pregunta;
		diferencialPuntos = new Puntos();
		this.respuesta =  respuesta ;
	}

	private void evaluarRespuesta(Respuesta respuesta){
		respuesta.aplicarComportamiento( tipoComportamiento, diferencialPuntos );
	}

	public void evaluarRespuesta(Respuesta[] respuestas){
		for (Respuesta unaRespuesta : respuestas){
			this.evaluarRespuesta(unaRespuesta);

		}
	}
}
