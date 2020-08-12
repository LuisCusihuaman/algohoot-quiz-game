package poo.coders.main.modelo;

import java.util.List;

public class ComportamientoMultipleChoicePenalidad extends Comportamiento {
	ComportamientoMultipleChoicePenalidad(List<Opcion> opciones){
		if(opciones.size() < 2 || opciones.size() > 5 ) throw new RuntimeException();
	}
	@Override
	protected Puntaje crearPuntaje() {
		return new PuntajePenalidad();
	}

	@Override
	protected String getTipoPregunta() {
		return "Multiple Choice Penalidad";
	}

}
