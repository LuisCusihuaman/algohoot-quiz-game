package poo.coders.main;

public class PuntajeClasico implements Puntaje {
	int puntajeAcumulado = 0;
	int factor = 1;

	@Override
	public void accionCorrecta(){
		puntajeAcumulado = factor;
	}

	@Override
	public void accionIncorrecta(){
		puntajeAcumulado = 0;
		factor = 0;
	}

	@Override
	public int getPuntajeAcumulado() {
		return puntajeAcumulado;
	}

}
