package poo.coders.main;

public class RespuestaIncorrecta implements Respuesta {
	@Override
	public void aplicarComportamiento(Comportamiento comportamiento, Puntos puntos) {
		comportamiento.erroneo(puntos);
	}
}
