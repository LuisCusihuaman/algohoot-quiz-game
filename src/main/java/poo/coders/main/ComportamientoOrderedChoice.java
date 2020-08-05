package poo.coders.main;

import java.util.List;

public class ComportamientoOrderedChoice extends Comportamiento {

	InterpretadorOrderedChoice interpretador;

	public ComportamientoOrderedChoice(List<String> respuestasOrdenadas){
		this.interpretador = new InterpretadorOrderedChoice(respuestasOrdenadas);
	}


	@Override
	public Puntaje crearPuntaje() {
		return new PuntajeClasico();
	}

	public List<Respuesta> evaluarRespuestas(List<String> respuestas){
		return interpretador.evaluarRespuestas(respuestas);
	}

}
