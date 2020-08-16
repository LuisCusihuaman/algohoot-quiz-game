package poo.coders.main.modelo.comportamientos;

import poo.coders.main.modelo.*;

import java.util.List;

public class ComportamientoVoF extends Comportamiento {
	public ComportamientoVoF(){

	}
	public ComportamientoVoF(List<Opcion> opciones){
		if(opciones.size() != 2 ) throw new RuntimeException();
	}
	@Override
	protected Puntaje crearPuntaje() {
		return new PuntajeClasico();
	}

	@Override
	public String getTipoPregunta() {
		return "Verdadero o Falso";
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
