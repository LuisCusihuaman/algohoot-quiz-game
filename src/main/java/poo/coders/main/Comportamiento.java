package poo.coders.main;

public interface Comportamiento {
	void correcto(Puntaje puntaje);

	void incorrecto(Puntaje puntaje);

	Puntaje crearPuntaje();
}
