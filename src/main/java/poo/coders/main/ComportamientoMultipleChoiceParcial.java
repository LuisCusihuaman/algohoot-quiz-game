package poo.coders.main;

public class ComportamientoMultipleChoiceParcial implements Comportamiento {
	@Override
	public void correcto(Puntos puntos){
		puntos.sumar();
	}
	public void incorrecto(Puntos puntos){
		puntos.anular();
	}
}
