package poo.coders.main.modelo;

import java.util.List;

public class ComportamientoVoFPenalidad extends Comportamiento {


	@Override
	public Puntaje crearPuntaje() {
		return new PuntajePenalidad();
	}


}
