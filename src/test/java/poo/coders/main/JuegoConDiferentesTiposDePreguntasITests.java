package poo.coders.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class JuegoConDiferentesTiposDePreguntasITests {
	@Test
	public void test01JugadorRespondeBien3PreguntasDeMultipleChoiceParcialYMalEnVoFPenalidadTienePuntaje2() {
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
}
