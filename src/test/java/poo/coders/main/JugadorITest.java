package poo.coders.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class JugadorITest {
	@Test
	public void test01JugadorUsaMutiplicadorX2YContestaConRespuestaCorrectaGana2Puntos() {
		Pregunta pregunta = new Pregunta("", new ComportamientoVoFPenalidad());
		Jugador jugador = new Jugador("");
		ArrayList<Respuesta> respuestasJugador = new ArrayList<>();
		respuestasJugador.add(new RespuestaCorrecta(""));

		jugador.usarMultiplicadorX2();
		jugador.procesarPregunta(pregunta, respuestasJugador);

		Assertions.assertEquals(2, jugador.getPuntos());
	}

	@Test
	public void test02JugadorUsaMultiplicadorX3YContestaConRespuestaIncorrectaTieneMenos3Puntos() {
		Pregunta pregunta = new Pregunta("", new ComportamientoVoFPenalidad());
		Jugador jugador = new Jugador("");
		ArrayList<Respuesta> respuestasJugador = new ArrayList<>();
		respuestasJugador.add(new RespuestaIncorrecta(""));

		jugador.usarMultiplicadorX3();
		jugador.procesarPregunta(pregunta, respuestasJugador);

		Assertions.assertEquals(-3, jugador.getPuntos());
	}

	@Test
	public void test03JugadorUsaMultiplicadorPor3YContestaCon3RespuestasCorrectasGana9Puntos() {
		Pregunta pregunta = new Pregunta("", new ComportamientoMultipleChoicePenalidad());
		Jugador jugador = new Jugador("");
		ArrayList<Respuesta> respuestasJugador  = new ArrayList<>();
		respuestasJugador.add(new RespuestaCorrecta(""));
		respuestasJugador.add(new RespuestaCorrecta(""));
		respuestasJugador.add(new RespuestaCorrecta(""));

		jugador.usarMultiplicadorX3();
		jugador.procesarPregunta(pregunta, respuestasJugador);

		Assertions.assertEquals(9, jugador.getPuntos());
	}

	@Test
	public void test04JugadorUsaMultiplicadorPor2YContestaCon3RespuestasIncorrectasTieneMenos6Puntos() {
		Pregunta pregunta = new Pregunta("", new ComportamientoMultipleChoicePenalidad());
		Jugador jugador = new Jugador("");
		ArrayList<Respuesta> respuestasJugador = new ArrayList<>();
		respuestasJugador.add(new RespuestaIncorrecta(""));
		respuestasJugador.add(new RespuestaIncorrecta(""));
		respuestasJugador.add(new RespuestaIncorrecta(""));

		jugador.usarMultiplicadorX2();
		jugador.procesarPregunta(pregunta, respuestasJugador);

		Assertions.assertEquals(-6, jugador.getPuntos());
	}
}
