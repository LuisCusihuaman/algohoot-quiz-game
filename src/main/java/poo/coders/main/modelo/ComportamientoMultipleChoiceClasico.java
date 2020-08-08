package poo.coders.main.modelo;

import java.util.List;

public class ComportamientoMultipleChoiceClasico extends Comportamiento {

	@Override
	public Puntaje crearPuntaje() {
		return new PuntajeClasico();
	}


}
