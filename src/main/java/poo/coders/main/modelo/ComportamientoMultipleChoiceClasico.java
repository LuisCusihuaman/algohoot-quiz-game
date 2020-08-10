package poo.coders.main.modelo;

public class ComportamientoMultipleChoiceClasico extends Comportamiento {

	@Override
	protected Puntaje crearPuntaje() {
		return new PuntajeClasico();
	}

	@Override
	protected String getTipoPregunta() {
		return "Multiple Choice Clasico";
	}
}
