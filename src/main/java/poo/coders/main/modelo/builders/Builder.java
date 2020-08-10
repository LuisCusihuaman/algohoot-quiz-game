package poo.coders.main.modelo.builders;

import poo.coders.main.modelo.Pregunta;
import poo.coders.main.modelo.data.OpcionSerializada;

import java.util.List;

public interface Builder {
	void asignarComportamiento(String tipoPuntaje);

	void setEnunciado(String enunciado);

	void setOpciones(List<OpcionSerializada> opciones);

	Pregunta construirPregunta();
}
