package poo.coders.main.modelo;

public class ComportamientoVoF extends Comportamiento {

	@Override
	protected Puntaje crearPuntaje() {
		return new PuntajeClasico();
	}

	@Override
	protected String getTipoPregunta() {
		return "Verdadero o Falso";
	}
}
