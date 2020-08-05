package poo.coders.main;

public class RespuestaIncorrecta extends Respuesta {
	public RespuestaIncorrecta(String textoRespuesta) {
		super(textoRespuesta);
	}

	public void aplicarComportamiento(Comportamiento comportamiento, Puntaje puntaje) {
		comportamiento.incorrecto(puntaje);
	}
}
