package poo.coders.main.modelo;

import java.util.ArrayList;
import java.util.List;

public class ComportamientoMultipleChoiceClasico extends Comportamiento {

	@Override
	protected Puntaje crearPuntaje() {
		return new PuntajeClasico();
	}


}
