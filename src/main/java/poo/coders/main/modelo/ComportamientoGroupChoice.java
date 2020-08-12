package poo.coders.main.modelo;

import java.util.List;

public class ComportamientoGroupChoice extends Comportamiento {
	ComportamientoGroupChoice(List<Opcion> opciones){
		if(opciones.size() < 2 || opciones.size() > 6 ) throw new RuntimeException();
	}
	@Override
	protected Puntaje crearPuntaje() {
		return new PuntajeClasico();
	}

	@Override
	protected String getTipoPregunta() {
		return "Group Choice";
	}
}
