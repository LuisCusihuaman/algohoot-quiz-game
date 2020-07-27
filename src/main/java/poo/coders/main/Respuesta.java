package poo.coders.main;

public abstract class Respuesta {
	protected String textoRespuesta;

	public Respuesta() {
	}

	public Respuesta(String textoRespuesta) {
		this.textoRespuesta = textoRespuesta;
	}

	protected void setTextoRespuesta(String textoRespuesta) {
		this.textoRespuesta = textoRespuesta;
	}

	protected String getTextoRespuesta() {
		return this.textoRespuesta;
	}

	abstract void aplicarComportamiento(Comportamiento comportamiento, Puntos puntos);

}
