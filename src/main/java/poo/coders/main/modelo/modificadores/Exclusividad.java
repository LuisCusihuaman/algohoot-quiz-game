package poo.coders.main.modelo.modificadores;

import poo.coders.main.modelo.Jugador;
import poo.coders.main.modelo.Opcion;
import poo.coders.main.modelo.Pregunta;

import java.util.ArrayList;

public interface Exclusividad {
	void definirPuntosJugadoresEnPregunta(Pregunta pregunta, Jugador jugador1, Jugador jugador2, ArrayList<Opcion> opcionesJugador1, ArrayList<Opcion> opcionesJugador2);
	Exclusividad activarExclusividad();
	void darPuntosAGanador(Jugador jugador, int puntosGanados);
	void darPuntosAPerdedor(Jugador jugador, int puntosGanados);
}
