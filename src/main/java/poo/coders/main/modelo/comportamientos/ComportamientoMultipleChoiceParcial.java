package poo.coders.main.modelo.comportamientos;

import poo.coders.main.modelo.*;
import poo.coders.main.modelo.modificadores.Multiplicador;

import java.util.List;

public class ComportamientoMultipleChoiceParcial extends Comportamiento implements ComportamientoConMultiplicador {
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


	@Override
	public void agregarMultiplicadorAJugador(Jugador jugador, Multiplicador multiplicador) {
		jugador.setMultiplicador(multiplicador);
	}
}
