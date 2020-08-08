package poo.coders.main.modelo;

import java.util.List;

public class ComportamientoMultipleChoiceParcial extends Comportamiento {

	@Override
	public Puntaje crearPuntaje() {
		return new PuntajeParcial();
	}


}
