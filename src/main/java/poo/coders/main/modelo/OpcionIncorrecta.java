package poo.coders.main.modelo;

public class OpcionIncorrecta extends Opcion {

	public OpcionIncorrecta(String clave, String textoOpcion) {
		super(clave, textoOpcion);
	}

	@Override
	public Respuesta convertirEnRespuesta(){
		return new RespuestaIncorrecta("Incorrecta");
	}
}
