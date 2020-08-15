package poo.coders.main.modelo;

import poo.coders.main.modelo.comportamientos.Comportamiento;

public class RespuestaIncorrecta extends Respuesta {
	public RespuestaIncorrecta(String textoRespuesta) {
		super(textoRespuesta);
	}

	public void aplicarComportamiento(Comportamiento comportamiento, Puntaje puntaje) {
		comportamiento.incorrecto(puntaje);
	}
}
