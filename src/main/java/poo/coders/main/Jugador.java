package poo.coders.main;

public class Jugador {

	private String nombre;
	private Puntos totalPuntos;

	public Jugador(String nombre) {
		this.nombre = nombre;
		totalPuntos = new Puntos();
	}

	public void modificarPuntos(Puntos diferencialPuntos) {
		totalPuntos.sumar(diferencialPuntos);
	}

	public int getPuntos() {
		return totalPuntos.getCantidadPuntos();
	}

	public String getNombre() {
		return nombre;
	}
}