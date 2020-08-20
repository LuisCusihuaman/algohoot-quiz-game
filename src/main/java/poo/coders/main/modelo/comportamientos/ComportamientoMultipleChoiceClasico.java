package poo.coders.main.modelo.comportamientos;

import poo.coders.main.modelo.*;
import poo.coders.main.modelo.excepciones.CantidadDeOpcionesInvalidasException;
import poo.coders.main.modelo.modificadores.Exclusividad;

import java.util.List;

public class ComportamientoMultipleChoiceClasico extends Comportamiento implements ComportamientoConExclusividad {
	public ComportamientoMultipleChoiceClasico(){
	}
	public ComportamientoMultipleChoiceClasico(List<Opcion> opciones){
		if(opciones.size() < 2 || opciones.size() > 5 ) throw new CantidadDeOpcionesInvalidasException();
	}
	@Override
	protected Puntaje crearPuntaje() {
		return new PuntajeClasico();
	}

	@Override
	public String getTipoPregunta() {
		return "Multiple Choice Clasico";
	}

	@Override
	public Exclusividad activarExclusividad(Exclusividad exclusividad) {
		return exclusividad.activarExclusividad();
	}
}
