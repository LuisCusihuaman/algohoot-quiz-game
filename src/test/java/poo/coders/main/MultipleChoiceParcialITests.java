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
		respuestas.add(new RespuestaIncorrecta());
		respuestas.add((new RespuestaCorrecta()));

		jugador.procesarPregunta(pregunta, respuestas);
		Assertions.assertEquals(0, jugador.getPuntos());
	}
	@Test
	public void test04JuegoEntreDosJugadoresCon3Preguntas(){
		Pregunta pregunta = new Pregunta("Pregunta", new MultipleChoiceParcial());
		Jugador jugador1 = new Jugador("Jugador 1");
		Jugador jugador2 = new Jugador("Jugador 2");

		ArrayList<Respuesta>respuestasDeJugador1 = new ArrayList<>();
		ArrayList<Respuesta>respuestasDeJugador2 = new ArrayList<>();

		//	Multiple Choice con 2 respuestas y una respuesta incorrecta
		respuestasDeJugador1.add(new RespuestaCorrecta());
		respuestasDeJugador1.add(new RespuestaCorrecta());

		respuestasDeJugador2.add(new RespuestaCorrecta());
		respuestasDeJugador2.add(new RespuestaIncorrecta());

		jugador1.procesarPregunta(pregunta, respuestasDeJugador1);
		jugador2.procesarPregunta(pregunta, respuestasDeJugador2);

		Assertions.assertEquals(2, jugador1.getPuntos());
		Assertions.assertEquals(0, jugador2.getPuntos());

		respuestasDeJugador1.clear();
		respuestasDeJugador2.clear();

		//	Multiple choice con 3 respuestas correctas y 1 incorrecta
		respuestasDeJugador1.add(new RespuestaCorrecta());

		respuestasDeJugador2.add(new RespuestaCorrecta());
		respuestasDeJugador2.add(new RespuestaCorrecta());
		respuestasDeJugador2.add(new RespuestaCorrecta());

		jugador1.procesarPregunta(pregunta, respuestasDeJugador1);
		jugador2.procesarPregunta(pregunta, respuestasDeJugador2);

		Assertions.assertEquals(3, jugador1.getPuntos());
		Assertions.assertEquals(3, jugador2.getPuntos());

		respuestasDeJugador1.clear();
		respuestasDeJugador2.clear();

		//	Multiple choice con 2 respuestas correctas y una incorrecta
		respuestasDeJugador1.add(new RespuestaCorrecta());
		respuestasDeJugador1.add(new RespuestaIncorrecta());

		respuestasDeJugador2.add(new RespuestaCorrecta());
		respuestasDeJugador2.add(new RespuestaCorrecta());
		respuestasDeJugador2.add(new RespuestaCorrecta());

		jugador1.procesarPregunta(pregunta, respuestasDeJugador1);
		jugador2.procesarPregunta(pregunta, respuestasDeJugador2);

		Assertions.assertEquals(3, jugador1.getPuntos());
		Assertions.assertEquals(6, jugador1.getPuntos());
	}
}
