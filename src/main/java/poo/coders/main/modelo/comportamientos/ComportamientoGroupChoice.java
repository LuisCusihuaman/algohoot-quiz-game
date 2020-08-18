package poo.coders.main.modelo.comportamientos;

import poo.coders.main.modelo.*;
import poo.coders.main.modelo.modificadores.Exclusividad;

import java.util.List;

public class ComportamientoGroupChoice extends Comportamiento implements ComportamientoConExclusividad {
	public ComportamientoGroupChoice(){
	}

	public ComportamientoGroupChoice(List<Opcion> opciones){
		if(opciones.size() < 2 || opciones.size() > 6 ) throw new RuntimeException();
	}
	@Override
	protected Puntaje crearPuntaje() {
		return new PuntajeClasico();
	}

	@Override
	public String getTipoPregunta() {
		return "Group Choice";
	}

	@Override
	public Exclusividad activarExclusividad(Exclusividad exclusividad) {
		return exclusividad.activarExclusividad();
	}
}
