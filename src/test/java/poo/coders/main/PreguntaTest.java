package poo.coders.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PreguntaTest {
	@Test
	void deberiaCrearsePreguntaConElTextoCorrespondiente() {
		Pregunta pregunta = new Pregunta("El texto de una pregunta", null);
		Assertions.assertEquals("El texto de una pregunta", pregunta.getTextoPregunta());
	}
}
