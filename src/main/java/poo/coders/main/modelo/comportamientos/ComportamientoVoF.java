package poo.coders.main.modelo.comportamientos;

import poo.coders.main.modelo.*;
import poo.coders.main.modelo.excepciones.CantidadDeOpcionesInvalidasException;
import poo.coders.main.modelo.modificadores.Exclusividad;

import java.util.List;

public class ComportamientoVoF extends Comportamiento implements ComportamientoConExclusividad {
	public ComportamientoVoF(){

	}
	public ComportamientoVoF(List<Opcion> opciones){
		if(opciones.size() != 2 ) throw new CantidadDeOpcionesInvalidasException();
	}
	@Override
	protected Puntaje crearPuntaje() {
		return new PuntajeClasico();
	}

	@Override
	public String getTipoPregunta() {
		return "Verdadero o Falso";
	}

	@Override
	public Exclusividad activarExclusividad(Exclusividad exclusividad) {
		return exclusividad.activarExclusividad();
	}
}
