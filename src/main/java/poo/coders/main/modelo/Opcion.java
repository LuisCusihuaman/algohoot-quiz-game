package poo.coders.main.modelo;

public class Opcion {
	private int clave;

	public Opcion(int clave) {
		this.clave = clave;
	}

	public boolean esMayorQue(Opcion opcion) {
		return clave > opcion.getId();
	}

	public int getId() {
		return this.clave;
	}

	public boolean esIgualA(Opcion opcion) {
		return clave == opcion.getId();
	}
}
