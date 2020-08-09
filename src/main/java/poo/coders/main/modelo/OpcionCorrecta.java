package poo.coders.main.modelo;

public class OpcionCorrecta extends Opcion {

	public OpcionCorrecta(String clave, String textoOpcion) {
		super(clave, textoOpcion);
	}

	@Override
	public Respuesta convertirEnRespuesta(){
		return new RespuestaCorrecta("Correcta");
	}
}
