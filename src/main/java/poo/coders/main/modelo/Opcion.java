package poo.coders.main.modelo;

public class Opcion {
	private String clave;
	private String textoOpcion;

	public Opcion(String clave, String textoOpcion) {
		this.clave = clave;
		this.textoOpcion = textoOpcion;
	}

	public boolean esMayorQue(Opcion opcion) {
		return Integer.parseInt(clave) > Integer.parseInt(opcion.getClave());
	}

	public String getClave() {
		return this.clave;
	}
	public String getTextoOpcion(){ return this.textoOpcion; }

	public boolean esIgualA(Opcion opcion) {
		return clave.equals(opcion.getClave());
	}

	public Respuesta convertirEnRespuesta() throws Exception {

		// TODO: Crear una Exception especifica para esto.
		throw new Exception("Esta opcion no se puede convertir en Respuesta");
	}

}

