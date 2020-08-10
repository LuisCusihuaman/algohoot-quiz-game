package poo.coders.main.modelo;

public abstract class Puntaje {
	int puntajeAcumulado = 0;
	int factor = 1;

	public abstract void accionCorrecta();

	public abstract void accionIncorrecta();

	public abstract int getPuntajeAcumulado();
}
