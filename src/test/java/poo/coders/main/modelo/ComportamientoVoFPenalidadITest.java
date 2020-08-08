package poo.coders.main.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ComportamientoVoFPenalidadITest {
	/*
		@Test
		void deberiaPreguntaVoFPenalidadCrearseCorrectamenteIndicandoleCualEsLaRespuestaCorrecta() {
			Pregunta             pregunta        = new Pregunta("Este es el mejor TP.", new ComportamientoVoFPenalidad());
			RespuestaCorrecta    correcta        = new RespuestaCorrecta();
			ArrayList<Respuesta> listaRespuestas = new ArrayList<>();
			listaRespuestas.add(correcta);
			Puntos diferencialPuntos = pregunta.obtenerPuntaje(listaRespuestas);
			Assertions.assertEquals(1, diferencialPuntos.getCantidadPuntos());
		}

		@Test
		void jugadorCon5puntosRespondeIncorrectamente2vecesYSuPuntajeDeberiaSer3() {
			Jugador              jugador          = new Jugador("Alan");
			Pregunta             pregunta         = new Pregunta("El software es tangible.", new ComportamientoVoFPenalidad());
			ArrayList<Respuesta> respuestaJugador = new ArrayList<>();
			respuestaJugador.add(new RespuestaIncorrecta(""));
			respuestaJugador.add(new RespuestaIncorrecta(""));
			jugador.procesarPregunta(pregunta, respuestaJugador);
			Assertions.assertEquals(3, jugador.getPuntos());
		}
	*/
	@Test
	public void test02JugadorRespondeConUnaIncorrectaTienePuntajeMenos1() {
		Jugador jugador = new Jugador("");
		Pregunta pregunta = new Pregunta("", new ComportamientoVoFPenalidad());
		ArrayList<Respuesta> respuestasJugador = new ArrayList<>();
		respuestasJugador.add(new RespuestaIncorrecta(""));

		jugador.procesarPregunta(pregunta, respuestasJugador);

		Assertions.assertEquals(-1, jugador.getPuntos());
	}

	@Test
	public void test03JugadorRespondeCon1CorrectaTienePuntaje1() {
		Jugador jugador = new Jugador("");
		Pregunta pregunta = new Pregunta("", new ComportamientoVoFPenalidad());
		ArrayList<Respuesta> respuestasJugador = new ArrayList<>();
		respuestasJugador.add(new RespuestaCorrecta(""));

		jugador.procesarPregunta(pregunta, respuestasJugador);

		Assertions.assertEquals(1, jugador.getPuntos());
	}
}
