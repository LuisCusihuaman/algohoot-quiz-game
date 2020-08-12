package poo.coders.main.modelo;

import java.util.List;

public class ComportamientoVoF extends Comportamiento {
	ComportamientoVoF(List<Opcion> opciones){
		if(opciones.size() < 2 || opciones.size() > 5 ) throw new RuntimeException();
	}
	@Override
	protected Puntaje crearPuntaje() {
		return new PuntajeClasico();
	}

	@Override
	protected String getTipoPregunta() {
		return "Verdadero o Falso";
	}
}
