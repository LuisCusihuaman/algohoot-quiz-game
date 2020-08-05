package poo.coders.main;

import java.util.List;

public class ComportamientoOrderedChoice implements Comportamiento, Interpretador{

	InterpretadorOrderedChoice interpretador;

	public ComportamientoOrderedChoice(List<String> respuestasOrdenadas){
		this.interpretador = new InterpretadorOrderedChoice(respuestasOrdenadas);
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

	public List<Respuesta> evaluarRespuestas(List<String> respuestas){
		return interpretador.evaluarRespuestas(respuestas);
	}

}
