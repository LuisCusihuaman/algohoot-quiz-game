package poo.coders.main.modelo;

import java.util.List;

public class ComportamientoGroupChoice extends Comportamiento {

	InterpretadorGroupChoice interpretador;

	public ComportamientoGroupChoice(List<String> respuestasOrdenadas) {
		this.interpretador = new InterpretadorGroupChoice(respuestasOrdenadas);
	}


	@Override
	public Puntaje crearPuntaje() {
		return new PuntajeClasico();
	}


	public List<Respuesta> evaluarRespuestas(List<String> respuestas) {
		return interpretador.evaluarRespuestas(respuestas);
	}

}
