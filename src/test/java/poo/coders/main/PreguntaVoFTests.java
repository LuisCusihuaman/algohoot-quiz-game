package poo.coders.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class PreguntaVoFTests {

	@Test
	void test01CreoPreguntaVoFIndicandoCualEsLaRespuestaCorrecta() {
		Pregunta pregunta = new Pregunta("Este es el mejor TP.", new ComportamientoVoF());
		RespuestaCorrecta correcta = new RespuestaCorrecta();

		ArrayList<Respuesta> listaRespuestas = new ArrayList<>();
		listaRespuestas.add(correcta);
		Puntos diferencialPuntos = pregunta.obtenerPuntaje(listaRespuestas);

		Assertions.assertEquals(1, diferencialPuntos.getCantidadPuntos());

	}

	/*
			P1 (Multiselect):
				J1: [Respuesta1, Respuesta2]
				J2: [Respuesta2, Respuesta4]

			P2 (VoF):
				J1: [Respuesta1]
				J2: [Respuesta2]
	*/

	@Test
	void test02PreguntaVoFRecibeListaDeRespuestasYAsignaPuntosCorrectamente() {
		Jugador jugador1 = new Jugador("Tomas");
		Jugador jugador2 = new Jugador("Kevin");

		Pregunta pregunta = new Pregunta("Este enunciado es falso.", new ComportamientoVoF());

		RespuestaCorrecta correcta = new RespuestaCorrecta();
		RespuestaIncorrecta incorrecta = new RespuestaIncorrecta();

		ArrayList<Respuesta> respuestaJugador1 = new ArrayList<>();
		ArrayList<Respuesta> respuestaJugador2 = new ArrayList<>();


		respuestaJugador1.add(correcta);
		respuestaJugador2.add(incorrecta);

		jugador1.procesarPregunta(pregunta, respuestaJugador1);
		jugador2.procesarPregunta(pregunta, respuestaJugador2);

		Assertions.assertEquals(1, jugador1.getPuntos());
		Assertions.assertEquals(0, jugador2.getPuntos());
	}

	@Test
	void test03DeberianAsignarseLosTextosAPreguntaYRespuestaCorrectamente() {
		Pregunta pregunta = new Pregunta("Vamos a aprobar el TP.", new ComportamientoVoF());

		RespuestaCorrecta correcta = new RespuestaCorrecta("Verdadero.");
		RespuestaIncorrecta incorrecta = new RespuestaIncorrecta("Falso.");

		Assertions.assertEquals("Vamos a aprobar el TP.", pregunta.getTextoPregunta());
		Assertions.assertEquals("Verdadero.", correcta.getTextoRespuesta());
		Assertions.assertEquals("Falso.", incorrecta.getTextoRespuesta());
	}
}
