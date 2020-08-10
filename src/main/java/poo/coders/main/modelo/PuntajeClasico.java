package poo.coders.main.modelo;

public class PuntajeClasico extends Puntaje {

	@Override
	public void accionCorrecta() {
		puntajeAcumulado = factor;
	}

	@Override
	public void accionIncorrecta() {
		puntajeAcumulado = 0;
		factor = 0;
	}

	@Override
	public int getPuntajeAcumulado() {
		return puntajeAcumulado;
	}

}
