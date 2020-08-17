package poo.coders.main.modelo.comportamientos;

import poo.coders.main.modelo.*;

import java.util.List;

public class ComportamientoOrderedChoice extends Comportamiento {
	public ComportamientoOrderedChoice(){
	}
	public ComportamientoOrderedChoice(List<Opcion> opciones){
		if(opciones.size() < 2 || opciones.size() > 5 ) throw new RuntimeException();
	}

	@Override
	protected Puntaje crearPuntaje() {
		return new PuntajeClasico();
	}

	@Override
	public String getTipoPregunta() {
		return "Ordered Choice";
	}

	public Estado.MultiplicadorBasicoX2 crearMultiplicadorX2(){
		//TODO: NoSePuedeCrearMultiplicadorEnPreguntaSinPenalidadException
		throw new RuntimeException();
	}
	public Jugador.MultiplicadorBasicoX3 crearMultiplicadorX3(){
		//TODO: NoSePuedeCrearMultiplicadorEnPreguntaSinPenalidadException
		throw new RuntimeException();
	}

}
