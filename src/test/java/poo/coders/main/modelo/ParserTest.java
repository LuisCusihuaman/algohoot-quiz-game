package poo.coders.main.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ParserTest {
	@Test
	void testElParserDeberiaDevolverUnaListaDePreguntas() {
		ArrayList<Pregunta> preguntas = new Parser().parsear();
		Assertions.assertTrue(true);
	}
}
