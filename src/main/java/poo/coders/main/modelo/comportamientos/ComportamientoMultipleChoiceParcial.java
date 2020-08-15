package poo.coders.main.modelo.comportamientos;

import poo.coders.main.modelo.Exclusividad;
import poo.coders.main.modelo.Opcion;
import poo.coders.main.modelo.Puntaje;
import poo.coders.main.modelo.PuntajeParcial;

import java.util.List;

public class ComportamientoMultipleChoiceParcial extends Comportamiento {
	public ComportamientoMultipleChoiceParcial(){
	}
	public ComportamientoMultipleChoiceParcial(List<Opcion> opciones){
		if(opciones.size() < 2 || opciones.size() > 5 ) throw new RuntimeException();
	}
	@Override
	protected Puntaje crearPuntaje() {
		return new PuntajeParcial();
	}

	@Override
	public String getTipoPregunta() {
		return "Multiple Choice Parcial";
	}

	public int activarMultiplicadorX2(){
		throw new RuntimeException();
	}
	public int activarMultiplicadorX3(){
		throw new RuntimeException();
	}
	public void activarExclusividad(Exclusividad exclusividad){
		exclusividad.activarExclusividad();
	}
}
