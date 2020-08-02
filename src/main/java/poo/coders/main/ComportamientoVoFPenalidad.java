package poo.coders.main;

public class ComportamientoVoFPenalidad implements Comportamiento {
	@Override
	public void correcto(Puntaje puntaje) {
		puntaje.incrementarPuntaje();
	}

	@Override
	public void incorrecto(Puntaje puntaje) {
		puntaje.anularPuntaje();
	}

	@Override
	public Puntaje crearPuntaje() {
		return new PuntajePenalidad();
	}
}
