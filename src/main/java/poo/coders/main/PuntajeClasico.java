package poo.coders.main;

public class PuntajeClasico implements Puntaje {
	int puntajeAcumulado = 0;
	int factor = 1;

	@Override
	public void incrementarPuntaje(){
		puntajeAcumulado = factor;
	}

	@Override
	public void anularPuntaje(){
		puntajeAcumulado = 0;
		factor = 0;
	}

	public int getPuntajeAcumulado() {
		return puntajeAcumulado;
	}

}
