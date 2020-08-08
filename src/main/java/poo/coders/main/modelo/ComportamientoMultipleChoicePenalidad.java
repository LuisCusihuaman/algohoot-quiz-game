package poo.coders.main.modelo;

import java.util.List;

public class ComportamientoMultipleChoicePenalidad extends Comportamiento {


	@Override
	public Puntaje crearPuntaje() {
		return new PuntajePenalidad();
	}

	@Override
	public List<Respuesta> evaluarRespuestas(List<String> respuestas) {
		return null;
	}
}
