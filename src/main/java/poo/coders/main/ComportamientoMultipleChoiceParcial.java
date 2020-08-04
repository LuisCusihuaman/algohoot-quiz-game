package poo.coders.main;

import java.util.List;

public class ComportamientoMultipleChoiceParcial implements Comportamiento {

	@Override
	public void correcto(Puntaje puntaje) {
		puntaje.accionCorrecta();
	}

	@Override
	public void incorrecto(Puntaje puntaje) {
		puntaje.accionIncorrecta();
	}

	@Override
	public Puntaje crearPuntaje() {
		return new PuntajeParcial();
	}

	@Override
	public List<Respuesta> evaluarRespuestas(List<String> respuestas) {
		return null;
	}
}
