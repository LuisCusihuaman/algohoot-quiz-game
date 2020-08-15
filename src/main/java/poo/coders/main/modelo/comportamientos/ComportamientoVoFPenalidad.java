package poo.coders.main.modelo.comportamientos;

import poo.coders.main.modelo.Exclusividad;
import poo.coders.main.modelo.Opcion;
import poo.coders.main.modelo.Puntaje;
import poo.coders.main.modelo.PuntajePenalidad;

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

	public int activarMultiplicadorX2(){
		return 2;
	}
	public int activarMultiplicadorX3(){
		return 3;
	}
	public void activarExclusividad(Exclusividad exclusividad){
		throw new RuntimeException();
	}
}
