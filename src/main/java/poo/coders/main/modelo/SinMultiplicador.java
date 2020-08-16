package poo.coders.main.modelo;

import java.util.ArrayList;

public class SinMultiplicador extends Modificador implements Multiplicador{
	private Jugador jugador;

	public SinMultiplicador(Jugador jugador) {
		this.jugador = jugador;
	}
	@Override
	public int aplicarMultiplicador(int puntajeBase){
		return puntajeBase;
	}

	@Override
	public void agregarJugador(Jugador jugador) {
		this.jugador = jugador;
	}
}
