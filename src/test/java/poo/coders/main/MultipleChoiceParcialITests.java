package poo.coders.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class MultipleChoiceParcialITests {
	@Test
	public void test01JugadorContestaCon3PreguntasCorrectasGana3Puntos(){
		//	Arrange
		Pregunta pregunta = new Pregunta("Pregunta", new MultipleChoiceParcial());
		Jugador jugador = new Jugador("Jugador");

		ArrayList<Respuesta> respuestas = new ArrayList<>();

		respuestas.add(new RespuestaCorrecta());
		respuestas.add(new RespuestaCorrecta());
		respuestas.add(new RespuestaCorrecta());

		//	Act
		jugador.procesarPregunta(pregunta, respuestas);

		//	Assert
		Assertions.assertEquals(3, jugador.getPuntos());
	}
}
