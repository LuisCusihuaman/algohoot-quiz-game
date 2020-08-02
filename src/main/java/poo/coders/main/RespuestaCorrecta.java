package poo.coders.main;

public class RespuestaCorrecta extends Respuesta {
	public RespuestaCorrecta(String textoRespuesta) {
		super(textoRespuesta);
	}

	public void aplicarComportamiento(Comportamiento comportamiento, Puntaje puntaje) {
		comportamiento.correcto(puntaje);
	}
}
