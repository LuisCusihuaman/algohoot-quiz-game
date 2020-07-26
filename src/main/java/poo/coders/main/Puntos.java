package poo.coders.main;

public class Puntos {

	private int cantidadPuntos;
	private int factor;

	public Puntos() {
		cantidadPuntos = 0;
		factor = 1;
	}

	public int getCantidadPuntos() {
		return cantidadPuntos;
	}

	public void sumar(Puntos puntos) {
		cantidadPuntos += puntos.getCantidadPuntos();
	}

	public void sumar() {
		cantidadPuntos += factor;
	}

	public void anular() {
		cantidadPuntos = 0;
		factor = 0;
	}

	public void restar() {
		if (this.cantidadPuntos > 0) cantidadPuntos = 0;
		cantidadPuntos -= factor;
	}

	public void setFactor(int factor) {
		this.factor = factor;
	}
}
