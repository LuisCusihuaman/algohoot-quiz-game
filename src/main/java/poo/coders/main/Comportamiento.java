package poo.coders.main;

import java.util.List;

public abstract class Comportamiento {

	public void correcto(Puntaje puntaje) {
		puntaje.accionCorrecta();
	}


	public void incorrecto(Puntaje puntaje) {
		puntaje.accionIncorrecta();
	}

	public abstract Puntaje crearPuntaje();

	public abstract List<Respuesta> evaluarRespuestas(List<String> respuestas);
}
