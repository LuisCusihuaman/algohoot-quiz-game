package poo.coders.main.modelo.modificadores;

import poo.coders.main.modelo.Jugador;
import poo.coders.main.modelo.Modificador;
import poo.coders.main.modelo.Opcion;
import poo.coders.main.modelo.Pregunta;
import poo.coders.main.modelo.modificadores.Exclusividad;

import java.util.ArrayList;

public class ExclusividadX4 implements Exclusividad, Modificador {
	public int valorExclusividad;

	public ExclusividadX4() {
		this.valorExclusividad = 4;
	}
	@Override
	public void darPUntosAJugador(Jugador jugador, int puntosGanados) {
		jugador.ganarPuntaje(valorExclusividad * puntosGanados);
	}

	@Override
	public Exclusividad activarExclusividad() {
		throw new RuntimeException();
	}

	@Override
	public void definirPuntosJugadoresEnPregunta(Pregunta pregunta, Jugador jugador1, Jugador jugador2, ArrayList<Opcion> opcionesJugador1, ArrayList<Opcion> opcionesJugador2) {
		int puntosJugador1 = pregunta.obtenerPuntaje(opcionesJugador1);
		int puntosJugador2 = pregunta.obtenerPuntaje(opcionesJugador2);
		this.darPUntosAJugador(jugador1, puntosJugador1);
		this.darPUntosAJugador(jugador2, puntosJugador2);
	}
}
