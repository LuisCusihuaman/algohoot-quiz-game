package poo.coders.main;

public class PuntajePenalidad implements Puntaje {
	int puntaje = 0;
	int factor = 1;

	@Override
	public void incrementarPuntaje() {
		puntaje = factor;
	}

	@Override
	public void anularPuntaje() {
		factor = -1;
		puntaje = factor;
	}

	@Override
	public int getPuntajeAcumulado() {
		return puntaje;
	}
}
