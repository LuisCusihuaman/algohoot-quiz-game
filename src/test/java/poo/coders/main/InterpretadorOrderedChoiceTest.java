package poo.coders.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class InterpretadorOrderedChoiceTest {
	@Test
	void test01UnaRespuestaOrdenadaDevuelveRespuestaCorrecta(){
		List<String> respuestasOrdenadas = List.of("Orden 1", "Orden 2", "Orden 3");
		List<String> respuestasJugador = List.of("Orden 1", "Orden 2", "Orden 3");

		InterpretadorOrderedChoice interpretador = new InterpretadorOrderedChoice(respuestasOrdenadas);

		List<Respuesta> respuesta = interpretador.evaluarRespuestas(respuestasJugador);
		Assertions.assertEquals("Correcta", respuesta.get(0).getTextoRespuesta());
	}

	@Test
	void test02UnaRespuestaDesordenadaDevuelveRespuestaIncorrecta(){
		List<String> respuestasOrdenadas = List.of("Orden 1", "Orden 2", "Orden 3");
		List<String> respuestasJugador = List.of("Orden 2", "Orden 1", "Orden 3");

		InterpretadorOrderedChoice interpretador = new InterpretadorOrderedChoice(respuestasOrdenadas);

		List<Respuesta> respuesta = interpretador.evaluarRespuestas(respuestasJugador);
		Assertions.assertEquals("Incorrecta", respuesta.get(0).getTextoRespuesta());
	}
}
