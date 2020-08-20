package poo.coders.main.modelo.modificadores;

import poo.coders.main.modelo.*;


public class SinExclusividad implements Exclusividad{
	@Override
	public Exclusividad activarExclusividad() {
		return new ExclusividadX2();
	}

	@Override
	public void darPuntosAGanador(Jugador jugador, int puntosGanados) {
		jugador.ganarPuntaje(puntosGanados);
	}

	@Override
	public void darPuntosAPerdedor(Jugador jugador, int puntosGanados) {
		jugador.ganarPuntaje(puntosGanados);
	}

	@Override
	public void definirPuntosJugadoresEnPregunta(Pregunta pregunta, Jugador jugadorActual) {
		int puntosJugador1 = pregunta.obtenerPuntaje(jugadorActual.getRespuestasElegidas());
		int puntosJugador2 = pregunta.obtenerPuntaje(jugadorActual.getJugadorSiguiente().getRespuestasElegidas());
		this.darPuntosAGanador(jugadorActual, puntosJugador1);
		this.darPuntosAGanador(jugadorActual.getJugadorSiguiente(), puntosJugador2);
	}

}
