package poo.coders.main;

public class ComportamientoVoF implements Comportamiento {
	@Override
	public void correcto(Puntaje puntaje) {
		puntaje.accionCorrecta();
	}

	@Override
	public void incorrecto(Puntaje puntaje) {
		puntaje.accionIncorrecta();
	}

	@Override
	public Puntaje crearPuntaje() {
		return new PuntajeParcial();
	}
}
