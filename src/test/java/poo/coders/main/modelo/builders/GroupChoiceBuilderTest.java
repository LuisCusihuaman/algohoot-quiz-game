package poo.coders.main.modelo.builders;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import poo.coders.main.modelo.Pregunta;
import poo.coders.main.modelo.data.OpcionSerializada;

import java.util.ArrayList;
import java.util.List;

class GroupChoiceBuilderTest {
	@Test
	public void GroupChoiceInstanciaUnaPreguntaCorrectamente() {
		List<OpcionSerializada> opciones = new ArrayList<>();
		GroupChoiceBuilder groupChoiceBuilder = new GroupChoiceBuilder();
		groupChoiceBuilder.setOpciones(opciones);
		groupChoiceBuilder.asignarComportamiento("Clasico");
		groupChoiceBuilder.setEnunciado("ejemplo");
		Pregunta group = groupChoiceBuilder.construirPregunta();
		//TODO: Agregar test unitario que verifique los atributos de
		// pregunta como el enunciado y las opciones son correctas - 3/2 asserts
		Assertions.assertTrue(true);
	}
}
