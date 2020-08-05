package poo.coders.main;

import java.util.List;

public class ComportamientoVoF extends Comportamiento {


	@Override
	public Puntaje crearPuntaje() {
		return new PuntajeParcial();
	}

	@Override
	public List<Respuesta> evaluarRespuestas(List<String> respuestas) {
		return null;
	}
}
