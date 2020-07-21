package poo.coders.Main;

public class ComportamientoVoF implements Comportamiento {
	@Override
	public void correcto(Puntos diferencialPuntos) {
		diferencialPuntos.sumar();
	}

	@Override
	public void erroneo(Puntos diferencialPuntos) {
		diferencialPuntos.anular();
	}
}
