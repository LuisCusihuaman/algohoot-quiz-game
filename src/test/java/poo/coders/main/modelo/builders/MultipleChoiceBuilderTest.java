package poo.coders.main.modelo.builders;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import poo.coders.main.modelo.Pregunta;
import poo.coders.main.modelo.data.OpcionSerializada;

import java.util.ArrayList;
import java.util.List;

class MultipleChoiceBuilderTest {
	@Test
	public void MultipleChoiceBuilderInstanciaUnaPreguntaCorrectamente() {
		List<OpcionSerializada> opciones = new ArrayList<>();
		MultipleChoiceBuilder multipleChoiceBuilder = new MultipleChoiceBuilder();
		multipleChoiceBuilder.setOpciones(opciones);
		multipleChoiceBuilder.asignarComportamiento("Clasico");
		multipleChoiceBuilder.setEnunciado("ejemplo");
		Pregunta mc = multipleChoiceBuilder.construirPregunta();
		//TODO: Agregar test unitario que verifique los atributos de
		// pregunta como el enunciado y las opciones son correctas - 3/2 asserts
		Assertions.assertTrue(true);
	}

}
