package poo.coders.main.modelo.builders;

import poo.coders.main.modelo.data.OpcionSerializada;
import poo.coders.main.modelo.data.PreguntaSerializada;

import java.util.List;

public class DirectorPregunta {
	String tipoPuntaje;
	String enunciado;
	List<OpcionSerializada> opciones;

	public DirectorPregunta(String tipoPuntaje, String enunciado, List<OpcionSerializada> opciones) {
		this.tipoPuntaje = tipoPuntaje;
		this.enunciado = enunciado;
		this.opciones = opciones;
	}

	public DirectorPregunta(PreguntaSerializada preguntaSerializada) {
		this(preguntaSerializada.getPuntajeType(), preguntaSerializada.getEnunciado(), preguntaSerializada.getOptions());
	}

	public void construirPreguntaVOF(Builder builder) {
		builder.setOpciones(opciones);
		builder.asignarComportamiento(tipoPuntaje);
		builder.setEnunciado(enunciado);
	}

	public void construirPreguntaMultipleChoice(Builder builder) {
		builder.setOpciones(opciones);
		builder.asignarComportamiento(tipoPuntaje);
		builder.setEnunciado(enunciado);
	}

	public void construirPreguntaOrderChoice(Builder builder) {
		builder.setOpciones(opciones);
		builder.asignarComportamiento(tipoPuntaje);
		builder.setEnunciado(enunciado);
	}

	public void construirPreguntaGroupChoice(Builder builder) {
		builder.setOpciones(opciones);
		builder.asignarComportamiento(tipoPuntaje);
		builder.setEnunciado(enunciado);
	}
}
