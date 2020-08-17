package poo.coders.main.modelo.modificadores;

public class MultiplicadorBasico implements Multiplicador {

	@Override
	public int aplicarMultiplicador(int puntajeBase) {
		return 0;
	}

	@Override
	public Multiplicador activarMultiplicadorX2() {
		return new MultiplicadorX2();
	}

	@Override
	public Multiplicador activarMultiplicadorX3() {
		return new MultiplicadorX3();
	}
}
