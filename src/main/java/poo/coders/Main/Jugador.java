package poo.coders.Main;

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


}
