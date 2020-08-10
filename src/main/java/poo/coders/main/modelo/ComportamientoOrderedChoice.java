package poo.coders.main.modelo;

public class ComportamientoOrderedChoice extends Comportamiento {

	@Override
	protected Puntaje crearPuntaje() {
		return new PuntajeClasico();
	}

	@Override
	protected String getTipoPregunta() {
		return "Ordered Choice";
	}

}
