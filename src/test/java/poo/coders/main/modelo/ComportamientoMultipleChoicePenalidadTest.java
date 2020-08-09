package poo.coders.main.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ComportamientoMultipleChoicePenalidadTest {

	@Test
	public void test01JugadorResponde3OpcionesCorrectasYRecibe3Puntos() {

		Pregunta pregunta = new Pregunta("Pregunta", new ComportamientoMultipleChoicePenalidad());
		Jugador jugador = new Jugador("Pepe");
		ArrayList<Opcion> respuestas = new ArrayList<>();
		respuestas.add(new OpcionCorrecta("Correcta", ""));
		respuestas.add(new OpcionCorrecta("Correcta", ""));
		respuestas.add(new OpcionCorrecta("Correcta", ""));

		jugador.procesarPregunta(pregunta, respuestas);

		Assertions.assertEquals(3, jugador.getPuntos());
	}

	@Test
	public void test02JugadorResponde2OpcionesCorrectasY2IncorrectasRecibe2Puntos() {

		Pregunta pregunta = new Pregunta("Pregunta", new ComportamientoMultipleChoicePenalidad());
		Jugador jugador = new Jugador("Pepe");
		ArrayList<Opcion> respuestas = new ArrayList<>();
		respuestas.add(new OpcionCorrecta("Correcta", ""));
		respuestas.add(new OpcionIncorrecta("Incorrecta", ""));
		respuestas.add(new OpcionCorrecta("Correcta", ""));
		respuestas.add(new OpcionIncorrecta("Incorrecta", ""));

		jugador.procesarPregunta(pregunta, respuestas);

		Assertions.assertEquals(0, jugador.getPuntos());
	}

	@Test
	public void test03JugadorResponde4OpcionesIncorrectamenteYDeberiaTenerMenos4Puntos() {

		Pregunta pregunta = new Pregunta("Pregunta", new ComportamientoMultipleChoicePenalidad());
		Jugador jugador = new Jugador("Pepe");
		ArrayList<Opcion> respuestas = new ArrayList<>();

		respuestas.add(new OpcionIncorrecta("Incorrecta", ""));
		respuestas.add(new OpcionIncorrecta("Incorrecta", ""));
		respuestas.add(new OpcionIncorrecta("Incorrecta", ""));
		respuestas.add(new OpcionIncorrecta("Incorrecta", ""));

		jugador.procesarPregunta(pregunta, respuestas);

		Assertions.assertEquals((-4), jugador.getPuntos());
	}


}
