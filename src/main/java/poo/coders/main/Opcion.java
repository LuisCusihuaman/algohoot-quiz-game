package poo.coders.main;

public class Opcion {
	int id;
	public Opcion(int id) {
		this.id = id;
	}

	public boolean esMayorQue(Opcion opcion) {
		return id > opcion.getID();
	}

	public int getID() {
		return id;
	}

	public boolean esIgualA(Opcion opcion) {
		return id == opcion.getID();
	}
}
