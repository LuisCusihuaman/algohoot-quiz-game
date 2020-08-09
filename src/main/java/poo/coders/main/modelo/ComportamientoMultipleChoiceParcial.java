package poo.coders.main.modelo;

import java.util.ArrayList;
import java.util.List;

public class ComportamientoMultipleChoiceParcial extends Comportamiento {

	@Override
	protected Puntaje crearPuntaje() {
		return new PuntajeParcial();
	}

	@Override
	protected String getTipoPregunta() {
		return "Multiple Choice Parcial";
	}
}
