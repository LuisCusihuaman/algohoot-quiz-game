package poo.coders.main.modelo.comportamientos;

import poo.coders.main.modelo.*;
import poo.coders.main.modelo.modificadores.Exclusividad;

import java.util.List;

public class ComportamientoVoFPenalidad extends Comportamiento implements ComportamientoConExclusividad{
	public ComportamientoVoFPenalidad(){

	}
	public ComportamientoVoFPenalidad(List<Opcion> opciones){
		if(opciones.size() != 2) throw new RuntimeException();
	}
	@Override
	protected Puntaje crearPuntaje() {
		return new PuntajePenalidad();
	}

	@Override
	public String getTipoPregunta() {
		return "Verdadero o Falso Penalidad";
	}

	@Override
	public Exclusividad activarExclusividad(Exclusividad exclusividad) {
		return exclusividad.activarExclusividad();
	}
}
