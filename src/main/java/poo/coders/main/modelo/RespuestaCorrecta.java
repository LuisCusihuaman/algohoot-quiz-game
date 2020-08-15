package poo.coders.main.modelo;

import poo.coders.main.modelo.comportamientos.Comportamiento;

public class RespuestaCorrecta extends Respuesta {
	public RespuestaCorrecta(String textoRespuesta) {
		super(textoRespuesta);
	}

	public void aplicarComportamiento(Comportamiento comportamiento, Puntaje puntaje) {
		comportamiento.correcto(puntaje);
	}
}
