package poo.coders.main;

import java.util.List;

public class ComportamientoVoFPenalidad extends Comportamiento {


	@Override
	public Puntaje crearPuntaje() {
		return new PuntajePenalidad();
	}

	@Override
	public List<Respuesta> evaluarRespuestas(List<String> respuestas) {
		return null;
	}
}
