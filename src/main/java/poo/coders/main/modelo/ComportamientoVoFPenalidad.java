package poo.coders.main.modelo;

import java.util.ArrayList;
import java.util.List;

public class ComportamientoVoFPenalidad extends Comportamiento {


	@Override
	protected Puntaje crearPuntaje() {
		return new PuntajePenalidad();
	}


}
