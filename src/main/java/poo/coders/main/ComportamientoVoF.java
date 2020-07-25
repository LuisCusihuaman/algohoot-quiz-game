package poo.coders.main;

public class ComportamientoVoF implements Comportamiento {
	@Override
	public void correcto(Puntos diferencialPuntos) {
		diferencialPuntos.sumar();
	}

	@Override
	public void incorrecto(Puntos diferencialPuntos) {
		diferencialPuntos.anular();
	}
}
