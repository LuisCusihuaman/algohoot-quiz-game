package poo.coders.main.modelo;

import poo.coders.main.modelo.comportamientos.Comportamiento;

public abstract class Respuesta {
	protected String textoRespuesta;

	public Respuesta(String textoRespuesta) {
		this.textoRespuesta = textoRespuesta;
	}


	public abstract void aplicarComportamiento(Comportamiento comportamiento, Puntaje puntaje);
}
