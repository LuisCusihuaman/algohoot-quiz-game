package poo.coders.main;

public class RespuestasOrdenadasFactory {

	public Respuesta crearRespuestaEnBaseA(OpcionesOrdenadas opciones) {
		if (opciones.estaOrdenada()) {
			return new RespuestaCorrecta("Correcta");
		}
		return new RespuestaIncorrecta("Incorrecta");
	}
}
