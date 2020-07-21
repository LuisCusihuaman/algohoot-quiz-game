package poo.coders.Main;

public class RespuestaCorrecta implements Respuesta {
	@Override
	public void aplicarComportamiento(Comportamiento comportamiento, Puntos puntos) {
		comportamiento.correcto(puntos);
	}
}
