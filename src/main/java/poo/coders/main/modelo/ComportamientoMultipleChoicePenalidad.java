package poo.coders.main.modelo;

public class ComportamientoMultipleChoicePenalidad extends Comportamiento {

	@Override
	protected Puntaje crearPuntaje() {
		return new PuntajePenalidad();
	}

	@Override
	protected String getTipoPregunta() {
		return "Multiple Choice Penalidad";
	}

}
