package poo.coders.main;

public class RespuestaCorrecta extends Respuesta {

	public RespuestaCorrecta() {
		super();
	}

	public RespuestaCorrecta(String textoRespuesta) {
		super(textoRespuesta);
	}

	@Override
	public void aplicarComportamiento(Comportamiento comportamiento, Puntos puntos) {
		comportamiento.correcto(puntos);
	}
}
