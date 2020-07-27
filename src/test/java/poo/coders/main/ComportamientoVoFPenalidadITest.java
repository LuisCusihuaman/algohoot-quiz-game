package poo.coders.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ComportamientoVoFPenalidadITest {

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
		Jugador              jugador          = new Jugador("Alan", 5);
		Pregunta             pregunta         = new Pregunta("El software es tangible.", new ComportamientoVoFPenalidad());
		ArrayList<Respuesta> respuestaJugador = new ArrayList<>();
		respuestaJugador.add(new RespuestaIncorrecta());
		respuestaJugador.add(new RespuestaIncorrecta());
		jugador.procesarPregunta(pregunta, respuestaJugador);
		Assertions.assertEquals(3, jugador.getPuntos());
	}
}
