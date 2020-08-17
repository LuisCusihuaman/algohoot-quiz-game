package poo.coders.main.modelo.modificadores;

public class MultiplicadorX2 implements Multiplicador {
	private int valorMultiplicador;
	public MultiplicadorX2() {
		this.valorMultiplicador = 2;
	}

	@Override
	public int aplicarMultiplicador(int puntajeBase) {
		return 0;
	}

	@Override
	public int modificarPuntos(int puntos) {
		return valorMultiplicador * puntos;
	}

}
