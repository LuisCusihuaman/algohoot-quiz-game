package poo.coders.main.modelo;

public class PuntajeParcial implements Puntaje {
	int puntajeAcumulado = 0;
	int factor = 1;

	@Override
	public void accionCorrecta() {
		puntajeAcumulado += factor;
	}

	@Override
	public void accionIncorrecta() {
		puntajeAcumulado = 0;
		factor = 0;
	}

	public int getPuntajeAcumulado() {
		return puntajeAcumulado;
	}
}
