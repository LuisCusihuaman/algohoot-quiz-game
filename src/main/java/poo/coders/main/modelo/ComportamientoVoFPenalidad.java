package poo.coders.main.modelo;

import java.util.List;

public class ComportamientoVoFPenalidad extends Comportamiento {
	ComportamientoVoFPenalidad(List<Opcion> opciones){
		if(opciones.size() < 2 || opciones.size() > 5 ) throw new RuntimeException();
	}
	@Override
	protected Puntaje crearPuntaje() {
		return new PuntajePenalidad();
	}

	@Override
	protected String getTipoPregunta() {
		return "Verdadero o Falso Penalidad";
	}
}
