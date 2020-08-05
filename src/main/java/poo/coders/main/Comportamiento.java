package poo.coders.main;

import java.util.List;

public interface Comportamiento {
	void correcto(Puntaje puntaje);

	void incorrecto(Puntaje puntaje);

	Puntaje crearPuntaje();

	List<Respuesta> evaluarRespuestas(List<String> respuestas);
}
