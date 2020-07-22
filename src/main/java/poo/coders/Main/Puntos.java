package poo.coders.Main;

public class Puntos {

	private int cantidadPuntos;
	private int multiplicador;

	public Puntos() {
		cantidadPuntos = 0;
		multiplicador = 1;
	}

	public int getCantidadPuntos() {
		return cantidadPuntos;
	}

	public void sumar(Puntos puntos) {
		cantidadPuntos += puntos.getCantidadPuntos();
	}

	public void sumar() {
		cantidadPuntos++;
	}

	public void anular() {
		cantidadPuntos = 0;
		multiplicador = 0;
	}

	public void restar() {
		cantidadPuntos--;
	}

	public void setMultiplicador(int multiplicador) {
		this.multiplicador = multiplicador;
	}
}
