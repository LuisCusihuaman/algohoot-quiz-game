package poo.coders.main.modelo;

public class ComportamientoGroupChoice extends Comportamiento {

	@Override
	protected Puntaje crearPuntaje() {
		return new PuntajeClasico();
	}

	@Override
	protected String getTipoPregunta() {
		return "Group Choice";
	}
}
