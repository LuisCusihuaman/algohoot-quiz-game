package poo.coders.main.modelo;

public class Opcion {
	private int clave;
	private String textoOpcion;

	public Opcion(int clave, String textoOpcion) {
		this.clave = clave;
		this.textoOpcion = textoOpcion;
	}

	public boolean esMayorQue(Opcion opcion) {
		return clave > opcion.getClave();
	}

	public int getClave() {
		return this.clave;
	}

	public boolean esIgualA(Opcion opcion) {
		return clave == opcion.getClave();
	}
}
