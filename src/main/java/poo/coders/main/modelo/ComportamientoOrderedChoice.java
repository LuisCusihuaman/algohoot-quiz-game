package poo.coders.main.modelo;

import java.util.ArrayList;
import java.util.List;

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
