package poo.coders.main.modelo;

import java.util.List;

public class ComportamientoMultipleChoiceParcial extends Comportamiento {
	ComportamientoMultipleChoiceParcial(List<Opcion> opciones){
		if(opciones.size() < 2 || opciones.size() > 5 ) throw new RuntimeException();
	}
	@Override
	protected Puntaje crearPuntaje() {
		return new PuntajeParcial();
	}

	@Override
	protected String getTipoPregunta() {
		return "Multiple Choice Parcial";
	}
}
