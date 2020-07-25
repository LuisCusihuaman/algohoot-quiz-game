package poo.coders.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MultipleChoiceParcialITests {
	@Test
	public void test01JugadorContestaCon3PreguntasCorrectasGana3Puntos(){
		Pregunta pregunta = new Pregunta("Pregunta", new MultipleChoiceParcial());
		Jugador jugador = new Jugador("Jugador");

		ArrayList<Respuesta> respuestas = new ArrayList<>();
		respuestas.add(new RespuestaCorrecta());
		respuestas.add(new RespuestaCorrecta());
		respuestas.add(new RespuestaCorrecta());

		jugador.procesarPregunta(pregunta, respuestas);

		Assertions.assertEquals(3, jugador.getPuntos());
	}
	@Test
	public void test02JugadorContestaCon2PreguntasCorrectasYUnaIncorrectaAlFinalTienePuntos0(){
		Pregunta pregunta = new Pregunta("Pregunta", new MultipleChoiceParcial());
		Jugador jugador = new Jugador("Jugador");

		ArrayList<Respuesta>respuestas = new ArrayList<>();
		respuestas.add(new RespuestaCorrecta());
		respuestas.add(new RespuestaCorrecta());
		respuestas.add(new RespuestaIncorrecta());

		jugador.procesarPregunta(pregunta, respuestas);

		Assertions.assertEquals(0, jugador.getPuntos());
	}
	@Test
	public void test03JugadorContestaConPreguntaIncorrectaYNoGanaPuntosSiVuelveAContestarConRespuestaCorrecta(){
		Pregunta pregunta = new Pregunta("Pregunta", new MultipleChoiceParcial());
		Jugador jugador = new Jugador("Jugador");

		ArrayList<Respuesta>respuestas = new ArrayList<>();
		respuestas.add(new RespuestaCorrecta());
		jugador.procesarPregunta(pregunta, respuestas);
		Assertions.assertEquals(1, jugador.getPuntos());

		respuestas.add(new RespuestaIncorrecta());
		jugador.procesarPregunta(pregunta, respuestas);
		Assertions.assertEquals(0, jugador.getPuntos());

		respuestas.add((new RespuestaCorrecta()));
		jugador.procesarPregunta(pregunta, respuestas);
		Assertions.assertEquals(0, jugador.getPuntos());
	}
}
