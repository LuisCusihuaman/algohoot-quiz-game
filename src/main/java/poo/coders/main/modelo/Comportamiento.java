package poo.coders.main.modelo;

import java.util.List;

public abstract class Comportamiento {

	public void correcto(Puntaje puntaje) {
		puntaje.accionCorrecta();
	}


	public void incorrecto(Puntaje puntaje) {
		puntaje.accionIncorrecta();
	}

	public abstract Puntaje crearPuntaje();

	public abstract List<Respuesta> verificarOpciones(List<Opcion> opcionesElegidasPorElJugador);

}
