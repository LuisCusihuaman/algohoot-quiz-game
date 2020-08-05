package poo.coders.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PreguntasConMultiplicadorTest {
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
	
}
