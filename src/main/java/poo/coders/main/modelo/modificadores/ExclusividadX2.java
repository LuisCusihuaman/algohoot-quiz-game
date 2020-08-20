package poo.coders.main.modelo.modificadores;

import poo.coders.main.modelo.Jugador;
import poo.coders.main.modelo.Pregunta;

public class ExclusividadX2 implements Exclusividad{
	public int valorExclusividad;

	public ExclusividadX2() {
		this.valorExclusividad = 2;
	}

	@Override
	public void darPuntosAGanador(Jugador jugador, int puntosGanados) {
		jugador.ganarPuntaje(valorExclusividad * puntosGanados);
	}

	@Override
	public void darPuntosAPerdedor(Jugador jugador, int puntosGanados) {
		jugador.ganarPuntaje(puntosGanados);
	}

	@Override
	public Exclusividad activarExclusividad() {
		return new ExclusividadX4();
	}

	@Override
	public void definirPuntosJugadoresEnPregunta(Pregunta pregunta, Jugador jugadorActual) {
		int puntosJugador1 = pregunta.obtenerPuntaje(jugadorActual.getRespuestasElegidas());
		int puntosJugador2 = pregunta.obtenerPuntaje(jugadorActual.getJugadorSiguiente().getRespuestasElegidas());
		if(puntosJugador1 == puntosJugador2) return;
		if(puntosJugador1 > puntosJugador2) {
			this.darPuntosAGanador(jugadorActual, puntosJugador1);
			this.darPuntosAPerdedor(jugadorActual.getJugadorSiguiente(), puntosJugador2);
		} else if (puntosJugador1 < puntosJugador2) {
			this.darPuntosAGanador(jugadorActual, puntosJugador2);
			this.darPuntosAPerdedor(jugadorActual.getJugadorSiguiente(), puntosJugador1);
		}
	}
}
