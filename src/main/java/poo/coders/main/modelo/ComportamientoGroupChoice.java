package poo.coders.main.modelo;

import java.util.ArrayList;
import java.util.List;

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
