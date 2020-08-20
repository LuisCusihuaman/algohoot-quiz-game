package poo.coders.main.modelo.comportamientos;

import poo.coders.main.modelo.*;
import poo.coders.main.modelo.excepciones.CantidadDeOpcionesInvalidasException;
import poo.coders.main.modelo.modificadores.Exclusividad;

import java.util.List;

public class ComportamientoMultipleChoiceParcial extends Comportamiento implements ComportamientoConExclusividad {
	public ComportamientoMultipleChoiceParcial(){
	}
	public ComportamientoMultipleChoiceParcial(List<Opcion> opciones){
		if(opciones.size() < 2 || opciones.size() > 5 ) throw new CantidadDeOpcionesInvalidasException();
	}
	@Override
	protected Puntaje crearPuntaje() {
		return new PuntajeParcial();
	}

	@Override
	public String getTipoPregunta() {
		return "Multiple Choice Parcial";
	}


	@Override
	public Exclusividad activarExclusividad(Exclusividad exclusividad) {
		return exclusividad.activarExclusividad();
	}
}
