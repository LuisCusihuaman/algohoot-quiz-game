package poo.coders.main.modelo;

public class PuntajePenalidad extends Puntaje {

	@Override
	public void accionCorrecta() {
		puntajeAcumulado += factor;
	}

	@Override
	public void accionIncorrecta() {
		puntajeAcumulado -= factor;
	}

	@Override
	public int getPuntajeAcumulado() {
		return puntajeAcumulado;
	}
}
