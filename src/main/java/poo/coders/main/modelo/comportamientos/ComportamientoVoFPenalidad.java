package poo.coders.main.modelo.comportamientos;

import poo.coders.main.modelo.*;
import poo.coders.main.modelo.modificadores.ExclusividadGod;
import poo.coders.main.modelo.modificadores.MultiplicadorX2;
import poo.coders.main.modelo.modificadores.MultiplicadorX3;

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

	public MultiplicadorX2 crearMultiplicadorX2(){
		return new MultiplicadorX2();
	}
	public MultiplicadorX3 crearMultiplicadorX3(){
		return new MultiplicadorX3();
	}
	public ExclusividadGod crearExclusividad(Jugador jugador1, Jugador jugador2){
		//TODO: NoPuedoCrearExclusividadEnPreguntaConPenalidadException
		throw new RuntimeException();
	}

}
