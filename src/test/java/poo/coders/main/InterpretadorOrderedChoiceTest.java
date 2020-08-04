package poo.coders.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class InterpretadorOrderedChoiceTest {
	@Test
	void test01UnaRespuestasOrdenadaDevuelveRespuestaCorrecta(){
		List<String> respuestasOrdenadas = List.of("Orden 1", "Orden 2", "Orden 3");
		List<String> respuestasJugador = List.of("Orden 1", "Orden 2", "Orden 3");

		InterpretadorOrderedChoice interpretador = new InterpretadorOrderedChoice(respuestasOrdenadas);

		Assertions.assertEquals("Correcta", interpretador.evaluarRespuestas(respuestasJugador).getTextoRespuesta());
	}
}
