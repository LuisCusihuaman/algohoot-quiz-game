package poo.coders.main.modelo;

import java.util.ArrayList;
import java.util.List;

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
