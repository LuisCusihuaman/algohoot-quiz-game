package poo.coders.main.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class MultipleChoiceParcialITest {
	@Test
	public void test01JugadorContestaCon3PreguntasCorrectasGana3Puntos() {
		Pregunta pregunta = new Pregunta("Pregunta", new ComportamientoMultipleChoiceParcial());
		Jugador jugador = new Jugador("Jugador");

		ArrayList<Opcion> respuestas = new ArrayList<>();
		respuestas.add(new OpcionCorrecta("Correcta", ""));
		respuestas.add(new OpcionCorrecta("Correcta", ""));
		respuestas.add(new OpcionCorrecta("Correcta", ""));

		pregunta.darPuntosAJugadores(jugador, new Jugador(""), respuestas, new ArrayList<>());

		Assertions.assertEquals(3, jugador.getPuntos());
	}

	@Test
	public void test02JugadorContestaCon2PreguntasCorrectasYUnaIncorrectaAlFinalTienePuntos0() {
		Pregunta pregunta = new Pregunta("Pregunta", new ComportamientoMultipleChoiceParcial());
		Jugador jugador = new Jugador("Jugador");

		ArrayList<Opcion> respuestas = new ArrayList<>();
		respuestas.add(new OpcionCorrecta("Correcta", ""));
		respuestas.add(new OpcionCorrecta("Correcta", ""));
		respuestas.add(new OpcionIncorrecta("Incorecta", ""));

		pregunta.darPuntosAJugadores(jugador, new Jugador(""), respuestas, new ArrayList<>());

		Assertions.assertEquals(0, jugador.getPuntos());
	}

	@Test
	public void test03JugadorContestaConPreguntaIncorrectaYNoGanaPuntosSiVuelveAContestarConRespuestaCorrecta() {
		Pregunta pregunta = new Pregunta("Pregunta", new ComportamientoMultipleChoiceParcial());
		Jugador jugador = new Jugador("Jugador");

		ArrayList<Opcion> respuestas = new ArrayList<>();
		respuestas.add(new OpcionCorrecta("Correcta", ""));
		//jugador.procesarPregunta(pregunta, respuestas);
		respuestas.add(new OpcionIncorrecta("Incorecta", ""));
		respuestas.add(new OpcionCorrecta("Correcta", ""));

		pregunta.darPuntosAJugadores(jugador, new Jugador(""), respuestas, new ArrayList<>());
		Assertions.assertEquals(0, jugador.getPuntos());
	}

	@Test
	public void test04JuegoEntreDosJugadoresCon3Preguntas() {
		Pregunta pregunta = new Pregunta("Pregunta", new ComportamientoMultipleChoiceParcial());
		Jugador jugador1 = new Jugador("Jugador 1");
		Jugador jugador2 = new Jugador("Jugador 2");

		ArrayList<Opcion> respuestasDeJugador1 = new ArrayList<>();
		ArrayList<Opcion> respuestasDeJugador2 = new ArrayList<>();

		//	Multiple Choice con 2 respuestas y una respuesta incorrecta
		respuestasDeJugador1.add(new OpcionCorrecta("Correcta", ""));
		respuestasDeJugador1.add(new OpcionCorrecta("Correcta", ""));

		respuestasDeJugador2.add(new OpcionCorrecta("Correcta", ""));
		respuestasDeJugador2.add(new OpcionIncorrecta("Incorrecta", ""));


		pregunta.darPuntosAJugadores(jugador1, jugador2, respuestasDeJugador1, respuestasDeJugador2);

		Assertions.assertEquals(2, jugador1.getPuntos());
		Assertions.assertEquals(0, jugador2.getPuntos());

		respuestasDeJugador1.clear();
		respuestasDeJugador2.clear();

		// Jugador 1 responde una correcta y Jugador 2 responde 3 correctas
		respuestasDeJugador1.add(new OpcionCorrecta("Correcta", ""));

		respuestasDeJugador2.add(new OpcionCorrecta("Correcta", ""));
		respuestasDeJugador2.add(new OpcionCorrecta("Correcta", ""));
		respuestasDeJugador2.add(new OpcionCorrecta("Correcta", ""));


		pregunta.darPuntosAJugadores(jugador1, jugador2, respuestasDeJugador1, respuestasDeJugador2);

		Assertions.assertEquals(3, jugador1.getPuntos());
		Assertions.assertEquals(3, jugador2.getPuntos());

		respuestasDeJugador1.clear();
		respuestasDeJugador2.clear();


		respuestasDeJugador1.add(new OpcionCorrecta("Correcta", ""));
		respuestasDeJugador1.add(new OpcionIncorrecta("Incorrecta", ""));

		respuestasDeJugador2.add(new OpcionCorrecta("Correcta", ""));
		respuestasDeJugador2.add(new OpcionCorrecta("Correcta", ""));
		respuestasDeJugador2.add(new OpcionCorrecta("Correcta", ""));

		pregunta.darPuntosAJugadores(jugador1, jugador2, respuestasDeJugador1, respuestasDeJugador2);

		Assertions.assertEquals(3, jugador1.getPuntos());
		Assertions.assertEquals(6, jugador2.getPuntos());
	}
}
