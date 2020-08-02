package poo.coders.main;

public class PuntajePenalidad implements Puntaje {
	int puntajeAcumulado = 0;
	int factor = 1;

	@Override
	public void incrementarPuntaje() {
		puntajeAcumulado += factor;
	}

	@Override
	public void anularPuntaje() {
		factor = -1;
		puntajeAcumulado = 0;
		puntajeAcumulado += factor;
	}

	@Override
	public int getPuntajeAcumulado() {
		return puntajeAcumulado;
	}
}
