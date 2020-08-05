package poo.coders.main;

public abstract class Respuesta {
	protected String textoRespuesta;

	public Respuesta(String textoRespuesta) {
		this.textoRespuesta = textoRespuesta;
	}

	protected String getTextoRespuesta() {
		return this.textoRespuesta;
	}

	public abstract void aplicarComportamiento(Comportamiento comportamiento, Puntaje puntaje);
}
