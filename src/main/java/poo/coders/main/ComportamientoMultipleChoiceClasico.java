package poo.coders.main;

public class ComportamientoMultipleChoiceClasico implements Comportamiento {

	@Override
	public void correcto(Puntos puntos) {
		puntos.sumar();
		puntos.setFactor(0);
	}

	@Override
	public void incorrecto(Puntos puntos) {
		puntos.anular();
	}
}
