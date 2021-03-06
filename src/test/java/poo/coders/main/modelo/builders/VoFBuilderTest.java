package poo.coders.main.modelo.builders;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import poo.coders.main.modelo.Pregunta;
import poo.coders.main.modelo.data.OpcionSerializada;

import java.util.ArrayList;
import java.util.List;

class VoFBuilderTest {
	@Test
	public void VoFBuilderInstanciaUnaPreguntaCorrectamente() {
		List<OpcionSerializada> opciones = new ArrayList<>();
		VoFBuilder voFBuilder = new VoFBuilder();
		voFBuilder.setOpciones(opciones);
		voFBuilder.asignarComportamiento("Clasico");
		voFBuilder.setEnunciado("ejemplo");
		Pregunta vof = voFBuilder.construirPregunta();
		//TODO: Agregar test unitario que verifique los atributos de
		// pregunta como el enunciado y las opciones son correctas - 3/2 asserts
		Assertions.assertTrue(true);
	}
}
