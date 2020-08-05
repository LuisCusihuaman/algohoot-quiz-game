package poo.coders.main;

import java.util.List;

public class ComportamientoMultipleChoiceClasico extends Comportamiento {

	@Override
	public Puntaje crearPuntaje() {
		return new PuntajeClasico();
	}

	@Override
	public List<Respuesta> evaluarRespuestas(List<String> respuestas) {
		return null;
	}
}
