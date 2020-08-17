package poo.coders.main.modelo.modificadores;


import poo.coders.main.modelo.Jugador;
import poo.coders.main.modelo.ModificadorGod;

public class MultiplicadorX3 extends ModificadorGod implements Multiplicador{
	private Jugador jugador;

	public MultiplicadorX3(){

	}

	@Override
	public int aplicarMultiplicador(int puntajeBase){
		return puntajeBase * 2;
	}


	@Override
	public void agregarJugador(Jugador jugador) {
		this.jugador = jugador;
	}
}
