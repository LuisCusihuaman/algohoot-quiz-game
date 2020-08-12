package poo.coders.main.modelo;

import java.util.List;

public class ComportamientoMultipleChoiceClasico extends Comportamiento {
	ComportamientoMultipleChoiceClasico(List<Opcion> opciones){
		if(opciones.size() < 2 || opciones.size() > 5 ) throw new RuntimeException();
	}
	@Override
	protected Puntaje crearPuntaje() {
		return new PuntajeClasico();
	}

	@Override
	protected String getTipoPregunta() {
		return "Multiple Choice Clasico";
	}
}
