package poo.coders.main.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class JuegoConDiferentesTiposDePreguntasITests {
	@Test
	public void test01JugadorContestaCon3RespuestasCorrectasDeMultipleChoiceParcialYVoFPenalidadConUnaIncorrectaTienePuntaje2() {
		Jugador jugador = new Jugador("");
		Pregunta preguntaMultipleChoice = new Pregunta("", new ComportamientoMultipleChoiceParcial());
		ArrayList<Respuesta> respuestasDeJugador = new ArrayList<>();
		respuestasDeJugador.add(new RespuestaCorrecta(""));
		respuestasDeJugador.add(new RespuestaCorrecta(""));
		respuestasDeJugador.add(new RespuestaCorrecta(""));
		jugador.procesarPregunta(preguntaMultipleChoice, respuestasDeJugador);
		respuestasDeJugador.clear();
		Pregunta preguntaVoFPenalidad = new Pregunta("", new ComportamientoVoFPenalidad());
		respuestasDeJugador.add(new RespuestaIncorrecta(""));
		jugador.procesarPregunta(preguntaVoFPenalidad, respuestasDeJugador);

		Assertions.assertEquals(2, jugador.getPuntos());
	}

	@Test
	public void test02JugadorContestaCon2CorrectasDeChoiceClasicoYUnaIncorrectaDeVoFTienePuntaje2() {
		Jugador jugador = new Jugador("");
		Pregunta preguntaMultipleChoiceClasico = new Pregunta("", new ComportamientoMultipleChoiceClasico());
		ArrayList<Respuesta> respuestasJugador = new ArrayList<>();
		respuestasJugador.add(new RespuestaCorrecta(""));
		respuestasJugador.add(new RespuestaCorrecta(""));
		jugador.procesarPregunta(preguntaMultipleChoiceClasico, respuestasJugador);
		respuestasJugador.clear();
		Pregunta preguntaVoF = new Pregunta("", new ComportamientoVoF());
		respuestasJugador.add(new RespuestaCorrecta(""));
		jugador.procesarPregunta(preguntaVoF, respuestasJugador);

		Assertions.assertEquals(2, jugador.getPuntos());
	}
}
