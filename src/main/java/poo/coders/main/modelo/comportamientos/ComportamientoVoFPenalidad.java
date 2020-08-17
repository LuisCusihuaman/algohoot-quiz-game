package poo.coders.main.modelo.comportamientos;

import poo.coders.main.modelo.*;

import java.util.List;

public class ComportamientoVoFPenalidad extends Comportamiento {
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

}
