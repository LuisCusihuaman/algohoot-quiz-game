package poo.coders.main.modelo;

public class ComportamientoVoFPenalidad extends Comportamiento {

	@Override
	protected Puntaje crearPuntaje() {
		return new PuntajePenalidad();
	}

	@Override
	protected String getTipoPregunta() {
		return "Verdadero o Falso Penalidad";
	}
}
