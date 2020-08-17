package poo.coders.main.modelo.modificadores;

public class MultiplicadorBasico implements Multiplicador {
	private int valorMultiplicador;

	public MultiplicadorBasico() {
		this.valorMultiplicador = 1;
	}

	@Override
	public int aplicarMultiplicador(int puntajeBase) {
		return 0;
	}

}
