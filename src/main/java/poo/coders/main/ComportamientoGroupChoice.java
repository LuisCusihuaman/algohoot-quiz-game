package poo.coders.main;

import java.util.List;

public class ComportamientoGroupChoice implements Comportamiento{

	InterpretadorGroupChoice interpretador;

	public ComportamientoGroupChoice(List<String> respuestasOrdenadas){
		this.interpretador = new InterpretadorGroupChoice(respuestasOrdenadas);
	}

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
		return new PuntajeClasico();
	}

	@Override
	public List<Respuesta> evaluarRespuestas(List<String> respuestas) {
		return interpretador.evaluarRespuestas(respuestas);
	}

}
