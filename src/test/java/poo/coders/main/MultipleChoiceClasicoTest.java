package poo.coders.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class MultipleChoiceClasicoTest {
	@Test
	public void test01JugadorContestaTodoCorrectamenteYRecibe1Punto() {
		Pregunta pregunta = new Pregunta("Pregunta", new ComportamientoMultipleChoiceClasico());
		Jugador jugador = new Jugador("Pepe");

		ArrayList<Respuesta> respuestas = new ArrayList<>();
		respuestas.add(new RespuestaCorrecta());
		respuestas.add(new RespuestaCorrecta());
		respuestas.add(new RespuestaCorrecta());

		jugador.procesarPregunta(pregunta, respuestas);

		Assertions.assertEquals(1, jugador.getPuntos());
	}

	@Test
	public void test02JugadorContesta2CorrectamenteY1IncorrectamenteYRecibe0Punto() {
		Pregunta pregunta = new Pregunta("Pregunta", new ComportamientoMultipleChoiceClasico());
		Jugador jugador = new Jugador("Pepe");

		ArrayList<Respuesta> respuestas = new ArrayList<>();
		respuestas.add(new RespuestaCorrecta());
		respuestas.add(new RespuestaIncorrecta());
		respuestas.add(new RespuestaCorrecta());

		jugador.procesarPregunta(pregunta, respuestas);

		Assertions.assertEquals(0, jugador.getPuntos());
	}

	@Test
	public void test03JugadorContesta4CorrectamenteY1IncorrectamenteYRecibe0Punto() {
		Pregunta pregunta = new Pregunta("Pregunta", new ComportamientoMultipleChoiceClasico());
		Jugador jugador = new Jugador("Pepe");

		ArrayList<Respuesta> respuestas = new ArrayList<>();
		respuestas.add(new RespuestaCorrecta());
		respuestas.add(new RespuestaCorrecta());
		respuestas.add(new RespuestaCorrecta());
		respuestas.add(new RespuestaCorrecta());
		respuestas.add(new RespuestaIncorrecta());

		jugador.procesarPregunta(pregunta, respuestas);

		Assertions.assertEquals(0, jugador.getPuntos());
	}

	@Test
	public void test04JugadorContestaTodoIncorrectamenteYRecibe0Punto() {
		Pregunta pregunta = new Pregunta("Pregunta", new ComportamientoMultipleChoiceClasico());
		Jugador jugador = new Jugador("Pepe");

		ArrayList<Respuesta> respuestas = new ArrayList<>();
		respuestas.add(new RespuestaIncorrecta());
		respuestas.add(new RespuestaIncorrecta());
		respuestas.add(new RespuestaIncorrecta());
		respuestas.add(new RespuestaIncorrecta());

		jugador.procesarPregunta(pregunta, respuestas);

		Assertions.assertEquals(0, jugador.getPuntos());
	}

	@Test
	public void test05JugadorContesta2CorrectamenteY1IncorrectamenteEnPrimerLugarYRecibe0Punto() {
		Pregunta pregunta = new Pregunta("Pregunta", new ComportamientoMultipleChoiceClasico());
		Jugador jugador = new Jugador("Pepe");

		ArrayList<Respuesta> respuestas = new ArrayList<>();
		respuestas.add(new RespuestaIncorrecta());
		respuestas.add(new RespuestaCorrecta());
		respuestas.add(new RespuestaCorrecta());

		jugador.procesarPregunta(pregunta, respuestas);

		Assertions.assertEquals(0, jugador.getPuntos());
	}
}
