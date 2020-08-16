package poo.coders.main.modelo;

public class MultiplicadorX2 extends Modificador implements Multiplicador{
	private Jugador jugador;

	public MultiplicadorX2(){

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
