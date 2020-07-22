package poo.coders.main;

public class RespuestaCorrecta implements Respuesta {
	@Override
	public void aplicarComportamiento(Comportamiento comportamiento, Puntos puntos) {
		comportamiento.correcto(puntos);
	}
}
