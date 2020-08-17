package poo.coders.main.modelo.comportamientos;

import poo.coders.main.modelo.Jugador;
import poo.coders.main.modelo.modificadores.Multiplicador;

public interface ComportamientoConMultiplicador {
	void agregarMultiplicadorAJugador(Jugador jugador, Multiplicador multiplicador);
}
