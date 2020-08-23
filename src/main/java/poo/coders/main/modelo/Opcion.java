package poo.coders.main.modelo;

import poo.coders.main.modelo.excepciones.ImposibleConvertirEnRespuestaException;

public class Opcion {
	private String clave;
	private String textoOpcion;

	public Opcion(String clave, String textoOpcion) {
		this.clave = clave;
		this.textoOpcion = textoOpcion;
	}

	public String getClave() {
		return this.clave;
	}

	public String getTextoOpcion() {
		return this.textoOpcion;
	}

	public Respuesta convertirEnRespuesta() {

		throw new ImposibleConvertirEnRespuestaException();
	}

}

