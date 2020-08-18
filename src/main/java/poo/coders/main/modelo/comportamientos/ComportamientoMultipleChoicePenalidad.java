package poo.coders.main.modelo.comportamientos;

import poo.coders.main.modelo.Opcion;
import poo.coders.main.modelo.Puntaje;
import poo.coders.main.modelo.PuntajePenalidad;
import poo.coders.main.modelo.modificadores.Exclusividad;

import java.util.List;

public class ComportamientoMultipleChoicePenalidad extends Comportamiento implements ComportamientoConExclusividad {
	private int valor;
	public ComportamientoMultipleChoicePenalidad(){
		this.valor = 1;
	}

	public ComportamientoMultipleChoicePenalidad(List<Opcion> opciones){
		if(opciones.size() < 2 || opciones.size() > 5 ) throw new RuntimeException();
	}

	@Override
	protected Puntaje crearPuntaje() {
		return new PuntajePenalidad();
	}

	@Override
	public String getTipoPregunta() {
		return "Multiple Choice Penalidad";
	}


	@Override
	public Exclusividad activarExclusividad(Exclusividad exclusividad) {
		return exclusividad.activarExclusividad();
	}
}
