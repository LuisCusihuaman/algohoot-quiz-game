package poo.coders.main.modelo.comportamientos;

import poo.coders.main.modelo.*;
import poo.coders.main.modelo.modificadores.Multiplicador;

import java.util.List;

public class ComportamientoMultipleChoiceClasico extends Comportamiento implements ComportamientoConMultiplicador {
	public ComportamientoMultipleChoiceClasico(){
	}
	public ComportamientoMultipleChoiceClasico(List<Opcion> opciones){
		if(opciones.size() < 2 || opciones.size() > 5 ) throw new RuntimeException();
	}
	@Override
	protected Puntaje crearPuntaje() {
		return new PuntajeClasico();
	}

	@Override
	public String getTipoPregunta() {
		return "Multiple Choice Clasico";
	}

	@Override
	public void agregarMultiplicadorAJugador(Jugador jugador, Multiplicador multiplicador) {
		jugador.setMultiplicador(multiplicador);
	}
}
