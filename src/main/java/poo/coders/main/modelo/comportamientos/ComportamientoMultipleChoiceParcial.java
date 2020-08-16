package poo.coders.main.modelo.comportamientos;

import poo.coders.main.modelo.*;

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

	public MultiplicadorX2 crearMultiplicadorX2(){
		//TODO: NoSePuedeCrearMultiplicadorEnPreguntaSinPenalidadException
		throw new RuntimeException();
	}
	public MultiplicadorX3 crearMultiplicadorX3(){
		//TODO: NoSePuedeCrearMultiplicadorEnPreguntaSinPenalidadException
		throw new RuntimeException();
	}
	public Exclusividad crearExclusividad(Jugador jugador1, Jugador jugador2){
		return new Exclusividad(jugador1, jugador2);
	}
}
