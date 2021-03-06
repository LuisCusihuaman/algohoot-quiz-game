package poo.coders.main.modelo;

public class OpcionConjunto extends Opcion {
	private String claveElegida;

	public OpcionConjunto(String clave, String textoOpcion) {
		super(clave, textoOpcion);
	}

	public OpcionConjunto(String clave, String textoOpcion, String claveElegida) {
		super(clave, textoOpcion);
		this.claveElegida = claveElegida;
	}

	public OpcionConjunto(Opcion opcionOriginal, String claveElegida) {
		super(opcionOriginal.getClave(), opcionOriginal.getTextoOpcion());
		this.claveElegida = claveElegida;
	}

	@Override
	public Respuesta convertirEnRespuesta() {
		return this.claveElegida.equals(super.getClave()) ? new RespuestaCorrecta("Correcta") : new RespuestaIncorrecta("Incorrecta");
	}

	public String getClaveElegida() {
		return claveElegida;
	}
}
