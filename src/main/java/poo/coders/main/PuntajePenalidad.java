package poo.coders.main;

public class PuntajePenalidad implements Puntaje {
	int puntaje = 0;
	int factor = 1;

	@Override
	public void accionCorrecta() {
		puntaje += factor;
	}

	@Override
	public void accionIncorrecta() {
		puntaje -= factor;
	}

	@Override
	public int getPuntajeAcumulado() {
		return puntaje;
	}
}
