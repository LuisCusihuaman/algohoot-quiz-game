package poo.coders.main.modelo.modificadores;

import poo.coders.main.modelo.*;

import java.util.ArrayList;

public class SinExclusividad implements Exclusividad, Modificador {
	public int valorExclusividad;

	public SinExclusividad() {
		this.valorExclusividad = 1;
	}

	@Override
	public void darPUntosAJugador(Jugador jugador, int puntosGanados) {
		jugador.ganarPuntaje(valorExclusividad * puntosGanados);
	}

	@Override
	public Exclusividad activarExclusividad() {
		return new ExclusividadX2();
	}

	@Override
	public void definirPuntosJugadoresEnPregunta(Pregunta pregunta, Jugador jugador1, Jugador jugador2, ArrayList<Opcion> opcionesJugador1, ArrayList<Opcion> opcionesJugador2) {
		int puntosJugador1 = pregunta.obtenerPuntaje(opcionesJugador1);
		int puntosJugador2 = pregunta.obtenerPuntaje(opcionesJugador2);
		this.darPUntosAJugador(jugador1, puntosJugador1);
		this.darPUntosAJugador(jugador2, puntosJugador2);
	}
}
