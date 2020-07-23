package poo.coders.main;

public class RespuestaIncorrecta extends Respuesta {

	public RespuestaIncorrecta() {
		super();
	}

	public RespuestaIncorrecta(String textoRespuesta) {
		super(textoRespuesta);
	}

	@Override
	public void aplicarComportamiento(Comportamiento comportamiento, Puntos puntos) {
		comportamiento.erroneo(puntos);
	}

	public String getTextoRespuesta(){
		return this.textoRespuesta;
	}
}
